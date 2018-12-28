package com.raoyc.thrift.demo.service.impl;

import com.raoyc.thrift.demo.service.PingService;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PingServiceImpl implements PingService.Iface {
    private Logger logger = LoggerFactory.getLogger(PingService.class);

    @Override
    public String ping() throws TException {
        System.out.println("pong");
        return "pong";
    }

    @Override
    public void say(String msg) throws TException {
        System.out.println(msg);
    }
}
