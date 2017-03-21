package me.luajk.reply.dao;

import me.luajk.reply.model.Reply;

import java.util.List;
import java.util.Map;

public interface ReplyDao {

    List<Reply> listComment(Map<String, Object> parameter);

    int count(Map<String, Object> parameter);

    void addComment(Reply reply);

    void deleteComment(String id);
}

