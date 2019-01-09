package com.raoyc.quartz.demo.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 使用 RAM 方式
 * http://www.quartz-scheduler.org/documentation/quartz-2.x/tutorials/tutorial-lesson-09.html
 * https://blog.csdn.net/u010648555/article/details/54863394
 */
public class SampleRAMJob implements Job {

    private static Logger _log = LoggerFactory.getLogger(SampleRAMJob.class);

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        _log.info("Say hello to Quartz" + new Date());
    }
}
