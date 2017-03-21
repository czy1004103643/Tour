package me.luajk.question.service.impl;

import me.luajk.question.dao.QuestionDao;
import me.luajk.question.model.Question;
import me.luajk.question.service.QuestionService;
import me.luajk.dictionary.model.Dictionary;
import me.luajk.tags.dao.TagsDao;
import me.luajk.user.model.User;
import me.luajk.utils.IdGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao;
    private TagsDao tagsDao;

    @Resource
    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Resource
    public void setTagsDao(TagsDao tagsDao) {
        this.tagsDao = tagsDao;
    }

    public String addQues(String title, String content, int dest, int[] tags, int anon, User user) {
        Question question = new Question();
        String id = IdGenerator.getId();
        question.setId(id);
        question.setTitle(title);
        question.setContent(content);
        Dictionary dictionary = new Dictionary();
        dictionary.setId(dest);
        question.setDest(dictionary);
        question.setDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        question.setAnon(anon);
        question.setUser(user);
        questionDao.addQues(question);
        for (int tag : tags) {
            tagsDao.relate(tag, id);
        }
        return id;
    }

    public void modifyQues(String id, String content) {
        Question question = new Question();
        question.setId(id);
        question.setContent(content);
        questionDao.updateQues(question);
    }

    public void deleteQues(String id) {
        questionDao.deleteQues(id);
    }

    public List<Question> listQues() {
        return questionDao.listQues();
    }

    public Question getQues(String id) {
        return questionDao.getQues(id);
    }
}
