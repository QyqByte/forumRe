package com.qiao.controller;

import com.qiao.domain.User;
import com.qiao.domain.UserLoginLog;
import com.qiao.service.LoginLogService;
import com.qiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;


@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final LoginLogService loginLogService;

    @Autowired
    public UserController(UserService userService, LoginLogService loginLogService) {
        this.userService = userService;
        this.loginLogService = loginLogService;
    }


    /**
     * 用户登录
     *
     * @param loginUser 登录的用户
     * @param request   请求
     * @return 返回页面
     */
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public String userLogin(User loginUser, HttpServletRequest request) {
        // 通过用户名查找User对象
        User user = userService.getUserByUserName(loginUser.getUserName());
        String password = "";
        if (user != null) {
            password = userService.getPassword(user.getUserName());
        }

        // 判断登录信息是否正确
        if (user != null && loginUser.getPassword().equals(password)) {

            // 获取登录基本信息
            String lastIp = request.getRemoteAddr(); // 获取远程登录ip
            String userName = user.getUserName();
            Timestamp lastLoginTime = new Timestamp(System.currentTimeMillis());

            // 更新用户信息
            user.setLastIp(lastIp);
            user.setLastLoginTime(lastLoginTime);
            user.setCredit(5 + user.getCredit());
            userService.updateUserByUserName(user);

            // 更新用户登录日志
            UserLoginLog userLoginLog = new UserLoginLog();
            userLoginLog.setUserName(userName);
            userLoginLog.setLoginIp(lastIp);
            userLoginLog.setLoginDateTime(lastLoginTime);
            loginLogService.addUserLoginLog(userLoginLog);

            // 登陆成功，跳转到主页
            request.getSession().setAttribute("username", user.getUserName());

            // 考虑通过登录成功后，向request的session存储器存储相关内容，然后在拦截器里面进行判断
            request.getSession().setAttribute("success","success");

            return "redirect:/main";
        }

        // 登录失败，跳转页面
        request.setAttribute("Msg", "登录失败");
        return "error";
    }

    /**
     * 用户注册
     *
     * @param userRegister 注册的用户
     * @param request      请求
     * @return 返回页面
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView userRegister(User userRegister, HttpServletRequest request) {
        User user = userRegister;
        ModelAndView mv = new ModelAndView();
        if (user != null) {
            try {
                String username = user.getUserName();
                String ip = request.getRemoteAddr();

                // 如果数据库中没有该用户，可以注册，否则跳转页面
                if (userService.getUserByUserName(username) == null) {

                    // 添加用户
                    user.setLastIp(ip);
                    Timestamp createLoginTime = new Timestamp(System.currentTimeMillis());
                    user.setCreateTime(createLoginTime);
                    user.setLastLoginTime(createLoginTime);
                    userService.addUser(user);

                    // 添加用户登录日志
                    UserLoginLog userLoginLog = new UserLoginLog();
                    userLoginLog.setUserName(username);
                    userLoginLog.setLoginIp(ip);
                    userLoginLog.setLoginDateTime(createLoginTime);
                    loginLogService.addUserLoginLog(userLoginLog);

                    // 注册成功跳转
                    request.setAttribute("username", username);
                    mv.setViewName("forward:/user/userLogin");
                    return mv;
                } else {
                    request.setAttribute("Msg", "注册失败，用户名已被占用！");
                    mv.setViewName("error");
                    return mv;
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("Msg", "发生未知错误！");
                mv.setViewName("error");
                return mv;
            }
        }

        request.setAttribute("Msg", "发生未知错误！");
        mv.setViewName("error");
        return mv;
    }

    /**
     * 显示个人信息
     *
     * @param username 用户名
     * @param request  请求
     * @return 返回页面
     */
    @RequestMapping(value = "/listUserInfo")
    public String listUserInfo(String username, HttpServletRequest request) {
        User user = userService.getUserByUserName(username);
        request.setAttribute("user", user);
        return "user/userInfo";
    }

    /**
     * 修改个人信息页面
     *
     * @param username 用户名
     * @param request  请求
     * @return 返回页面
     */
    @RequestMapping(value = "/userUpdateInfo", method = RequestMethod.GET)
    public String userUpdateInfoPage(String username, HttpServletRequest request) {
        User user = userService.getUserByUserName(username);
        request.setAttribute("user", user);
        return "user/userUpdateInfo";
    }

    /**
     * 提交用户修改信息
     *
     * @param user               修改后的用户
     * @param redirectAttributes 重定向
     * @return 重定向页面
     */
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public String updateUserInfo(User user, RedirectAttributes redirectAttributes) {
        User newUser = user;
        userService.updateUserByUserName(newUser);
        //redirectAttributes.addAttribute("username", newUser.getUserName());
        return "redirect:/main";
    }

    /**
     * 用户注销功能
     *
     * @param request 请求
     * @return 返回页面
     */
    @RequestMapping(value = "/loginOut")
    public ModelAndView loginOut(HttpServletRequest request) {
        request.getSession().removeAttribute("username");

        // 将request中存在的标志位“success”删除；
        request.getSession().removeAttribute("success");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:../index.jsp");
        return mv;
    }
}
