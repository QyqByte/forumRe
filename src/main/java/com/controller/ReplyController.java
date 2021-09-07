package com.qiao.controller;


import com.qiao.domain.Reply;
import com.qiao.service.ReplyService;
import com.qiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/reply")
public class ReplyController {
    private final ReplyService replyService;
    private final UserService userService;

    @Autowired
    public ReplyController(ReplyService replyService, UserService userService) {
        this.replyService = replyService;
        this.userService = userService;
    }

    /**
     * 添加回复
     *
     * @param reply 新增的回复
     * @return 重定向页面
     */
    @RequestMapping(value = "addReply", method = RequestMethod.POST)
    public String addReply(Reply reply) {
        replyService.addReply(reply);
        return "redirect:/post/postContent-" + reply.getReplyPostId();
    }
}
