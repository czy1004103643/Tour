package me.luajk.index.service.impl;

import me.luajk.destination.model.Destination;
import me.luajk.index.dao.IndexDao;
import me.luajk.index.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    private IndexDao indexDao;

    @Resource
    public void setIndexDao(IndexDao indexDao) {
        this.indexDao = indexDao;
    }

    public List<Destination> init() {
        return indexDao.init();
    }

    public List<Destination> top3() {
        return indexDao.top3();
    }

    public List<Destination> random3() {
        return indexDao.random3();
    }
}
