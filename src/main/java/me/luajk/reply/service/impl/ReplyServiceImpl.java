package me.luajk.reply.service.impl;

import me.luajk.reply.dao.ReplyDao;
import me.luajk.reply.model.Reply;
import me.luajk.reply.service.ReplyService;
import me.luajk.user.model.User;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

import javax.annotation.Resource;

@Service
public class ReplyServiceImpl implements ReplyService {

    private ReplyDao replyDao;

    @Resource
    public void setReplyDao(ReplyDao replyDao) {
        this.replyDao = replyDao;
    }

//    private List<Reply> getChildrenManyGroup(List<Reply> listQues, String parent) {
//        List<Reply> arr = new ArrayList<>();
//        listQues.stream().filter(comment -> parent.equals(comment.getParent())).forEach(comment -> {
//            comment.setReplies(getChildrenManyGroup(listQues, comment.getId()));
//            arr.add(comment);
//        });
//        return arr;
//    }

    public Map<String, Object> listComment(Map<String, Object> parameter) {
        Integer index = (Integer) parameter.get("page");
        Integer size = (Integer) parameter.get("rows");
        int totalCount = replyDao.count(parameter);
        int totalPage = totalCount % size == 0 ? totalCount / size : totalCount / size + 1;
//        int from = (index - 1) * size + 1;
//        int to = index * size < totalCount ? index * size : totalCount;
//        parameter.put("from", from);
//        parameter.put("to", to);
        parameter.put("index", index);
        parameter.put("size", size);
        List<Reply> replies = replyDao.listComment(parameter);
//        String guide = (String) parameter.getQues("guide");
//        List<Reply> result = getChildrenManyGroup(replies, guide);
        Map<String, Object> dataMap = new HashMap<>();
//        dataMap.put("listQues", result);
        dataMap.put("list", replies);
        dataMap.put("totalCount", totalCount);
        dataMap.put("totalPage", totalPage);
        dataMap.put("currentPage", index);
        return dataMap;

    }

    public void addComment(String content, int type, String parent,
                           User user) throws ParseException {
//        String id = IdGenerator.getId();
//        Reply comment = new Reply(id, new Date(), content, 0, 0, type, parent);
//        comment.setUser(user);
//        commentDao.addComment(comment);
    }

    public void deleteComment(String id) {
        replyDao.deleteComment(id);
    }
}
