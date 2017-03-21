package me.luajk.index.controller;

import me.luajk.index.service.IndexService;
import me.luajk.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class IndexController {

    private IndexService indexService;

    @Resource
    public void setIndexService(IndexService indexService) {
        this.indexService = indexService;
    }

    @RequestMapping("")
    public ModelAndView index(){
        System.out.print("sssrensx" +
                "\n");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("pics",indexService.init());
        modelAndView.addObject("top3",indexService.top3());
        modelAndView.addObject("ran3",indexService.random3());
        return modelAndView;
    }

    @RequestMapping("contact")
    public ModelAndView contact() {
        return new ModelAndView("contact");
    }

    @RequestMapping("contactResult")
    @ResponseBody
    public Result contactResult(){
        return new Result(true,"感谢您的反馈");
    }
}
