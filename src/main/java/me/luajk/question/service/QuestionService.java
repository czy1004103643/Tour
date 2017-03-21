package me.luajk.question.service;

import me.luajk.question.model.Question;
import me.luajk.user.model.User;

import java.util.List;

public interface QuestionService {

    String addQues(String title, String content, int dest, int[] tags, int anon, User user);

    void modifyQues(String id, String content);

    void deleteQues(String id);

    List<Question> listQues();

    Question getQues(String id);
}
