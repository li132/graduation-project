package com.lijin.service.impl;

import com.lijin.pojo.Log;
import com.lijin.mapper.LogMapper;

import com.lijin.service.LogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lijin
 * <p>
 * 2018年4月18日
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;


    public Integer saveLog(Log log) {

        return logMapper.insert(log);
    }
}
