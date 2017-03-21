package me.luajk.news.controller;

import me.luajk.news.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class NewsController {

    private NewsService newsService;

    @Resource
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping("newslist")
    @ResponseBody
    public Map informationQueryResult(int page, int rows, String guide) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("page", page);
        parameter.put("rows", rows);
        parameter.put("guide", guide);
        return newsService.listNews(parameter);
    }

}
