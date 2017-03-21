package me.luajk.news.service.impl;

import me.luajk.news.dao.InformationDao;
import me.luajk.news.model.News;
import me.luajk.news.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl implements NewsService {

    private InformationDao informationDao;

    @Resource
    public void setInformationDao(InformationDao informationDao) {
        this.informationDao = informationDao;
    }

    public Map<String, Object> listNews(Map<String, Object> parameter) {
        Integer index = (Integer) parameter.get("page");
        Integer size = (Integer) parameter.get("rows");
        int totalCount = informationDao.count(parameter);
        int totalPage = totalCount % size == 0 ? totalCount / size : totalCount / size + 1;
//        int from = (index - 1) * size;
//        int to = index * size - 1 < totalCount ? index * size - 1 : totalCount;
//        parameter.put("from", from);
//        parameter.put("to", to);
        parameter.put("index", index);
        parameter.put("size", size);
        List<News> newses = informationDao.listInformation(parameter);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("totalCount", totalCount);
        dataMap.put("totalPage", totalPage);
        dataMap.put("currentPage", index);
        dataMap.put("list", newses);
        return dataMap;
    }
}
