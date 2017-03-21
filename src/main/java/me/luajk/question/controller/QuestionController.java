package me.luajk.question.controller;

import me.luajk.question.model.Question;
import me.luajk.question.service.QuestionService;
import me.luajk.user.model.User;
import me.luajk.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class QuestionController {

    private QuestionService questionService;

    @Resource
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping("ques/hm")
    public ModelAndView hm() {
        return new ModelAndView("question/wrsx");
    }

    @RequestMapping("ques/rep")
    public ModelAndView rep() {
        return new ModelAndView("question/rep");
    }

    @RequestMapping("ques/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {

        ModelAndView modelAndView = new ModelAndView("question/detail");
        Question question = questionService.getQues(id);
        modelAndView.addObject("ques", question);
        return modelAndView;
    }

    @RequestMapping("quesins")
    @ResponseBody
    public Result quesInsert(String title, String content, int dest, String tags, int anon, HttpServletRequest request) {

        String id = questionService.addQues(title, content, dest, new int[]{1, 2}, anon, (User) request.getSession().getAttribute("user"));

        return new Result(true, id);
    }

    @RequestMapping("quesmdf")
    @ResponseBody
    public Result quesModify(String id, String content) {

        questionService.modifyQues(id, content);

        return new Result(true, id);
    }

    @RequestMapping("quesdel")
    @ResponseBody
    public Result quesDelete(String id) {

        questionService.deleteQues(id);

        return new Result(true, "");
    }

    @RequestMapping("queslist")
    @ResponseBody
    public List<Question> quesList() {

        return questionService.listQues();
    }
}
