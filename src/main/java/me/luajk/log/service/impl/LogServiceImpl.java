package me.luajk.log.service.impl;

import me.luajk.log.dao.LogDao;
import me.luajk.log.model.Log;
import me.luajk.log.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LogServiceImpl implements LogService {

    private LogDao logDao;

    @Resource
    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }

    public void addLog(Log log) {
        logDao.add(log);
    }
}
