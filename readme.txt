项目实现拦截器功能：
    实现目标：在用户未登录之前，不可访问除了首页以外，其他任何页面，若想访问，则需要登录，登录后还要有注销选项，以保护用户隐私

    实现步骤：
        1.创建interception子包，然后自定义类MyInterception，需要继承HandlerInterceptor接口

        2.覆盖重写接口内的preHandle（）方法，该方法会在请求之前拦截并进行判断条件

        3.具体实现，可以是通过在登陆成功后，在全局session容器内添加相应的标志位
            request.getSession().setAttribute("success","success");

        4.在MyInterception类中通过检查session中标志位是否存在来判断是否让该链接通过（即是否返回true）

        5.在springmvc配置文件中（dispatchServlet.xml），声明过滤器的存在，并设置被拦截的访问请求范围，及不被拦截的请求（重点）

        6.在点击账户注销后，需要将session中已保持的信息标志位清除
            request.getSession().removeAttribute("success");

        7.注：在配置文件中需要将注册页面也无条件放行（因为此时不可能存在登录成功标志位）