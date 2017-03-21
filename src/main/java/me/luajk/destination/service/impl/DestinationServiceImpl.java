package me.luajk.destination.service.impl;

import me.luajk.destination.dao.DestinationDao;
import me.luajk.destination.model.Destination;
import me.luajk.destination.service.DestinationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DestinationServiceImpl implements DestinationService {

    private DestinationDao destinationDao;

    @Resource
    public void setDestinationDao(DestinationDao destinationDao) {
        this.destinationDao = destinationDao;
    }

    public Map<String, Object> listGuide(Map<String, Object> parameter) {
        Integer index = (Integer) parameter.get("page");
        Integer size = (Integer) parameter.get("rows");
        int totalCount = destinationDao.count(parameter);
        int totalPage = totalCount % size == 0 ? totalCount / size : totalCount / size + 1;
        parameter.put("index", (index - 1) * size);
        parameter.put("size", size);
//        int from = (index - 1) * size + 1;
//        int to = index * size < totalCount ? index * size : totalCount;
//        parameter.put("from", from);
//        parameter.put("to", to);
        List<Destination> destinations = destinationDao.listGuide(parameter);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("totalCount", totalCount);
        dataMap.put("totalPage", totalPage);
        dataMap.put("currentPage", index);
        dataMap.put("list", destinations);
        return dataMap;
    }

    public Destination getGuide(String id) {
        destinationDao.updateHit(id);
        return destinationDao.getGuide(id);
    }
}
