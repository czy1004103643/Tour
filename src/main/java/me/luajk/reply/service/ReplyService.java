package me.luajk.reply.service;

import me.luajk.user.model.User;

import java.text.ParseException;
import java.util.Map;

public interface ReplyService {

    Map<String, Object> listComment(Map<String, Object> parameter);

    void addComment(String content, int type, String parent, User user) throws ParseException;

    void deleteComment(String id);
}
