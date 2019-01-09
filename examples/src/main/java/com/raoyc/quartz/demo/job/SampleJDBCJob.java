package com.raoyc.quartz.demo.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleJDBCJob implements Job {

    private static final Logger log = LoggerFactory.getLogger(SampleJDBCJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        log.info("SampleJDBCJob  is start ..................");
        JobKey jobKey = context.getJobDetail().getKey();

        log.info("SimpleJDBCJob jobKey is " + jobKey);

        log.info("Hello quartz  " +
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date()));

        log.info("SampleJDBCJob  is end .....................");
    }

}
