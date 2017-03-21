package me.luajk.news.dao;

import me.luajk.news.model.News;

import java.util.List;
import java.util.Map;

public interface InformationDao {

    List<News> listInformation(Map<String, Object> map);

    int count(Map<String, Object> parameter);
}

