package me.luajk.reply.controller;

import me.luajk.reply.service.ReplyService;

import me.luajk.user.model.User;
import me.luajk.utils.Result;
import me.luajk.utils.StringUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ReplyController {

    private ReplyService replyService;

    @Resource
    public void setReplyService(ReplyService replyService) {
        this.replyService = replyService;
    }

    @RequestMapping("relist")
    @ResponseBody
    public Map commentQueryResult(int page, int rows, String guide) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("page", page);
        parameter.put("rows", rows);
        if (StringUtils.isNotEmpty(guide)) {
            parameter.put("guide", guide);
        }
        return replyService.listComment(parameter);
    }

    @RequestMapping("reins")
    @ResponseBody
    public Result commentInsertResult(String content, int type, String parent, HttpServletRequest request) {
        try {
            replyService.addComment(content, type, parent, (User)request.getSession().getAttribute("user"));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "评论失败");
        }
        return new Result(true, "");
    }

    @RequestMapping("redel")
    @ResponseBody
    public Result commentDeleteResult(String id) {
        try {
            replyService.deleteComment(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
        return new Result(true, "");
    }
}
