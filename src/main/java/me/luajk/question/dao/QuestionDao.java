package me.luajk.question.dao;

import me.luajk.question.model.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao {

    void addQues(Question question);

    void updateQues(Question question);

    void deleteQues(String id);

    List<Question> listQues();

    Question getQues(String id);
}
