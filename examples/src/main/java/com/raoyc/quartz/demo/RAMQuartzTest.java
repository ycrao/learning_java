package com.raoyc.quartz.demo;


import com.raoyc.quartz.demo.job.SampleRAMJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * RAM store QuartzTest
 * https://blog.csdn.net/u010648555/article/details/54863394
 */
public class RAMQuartzTest {

    private static Logger _log = LoggerFactory.getLogger(RAMQuartzTest.class);

    public static void main(String[] args) throws SchedulerException {

        // 1.创建Scheduler的工厂
        SchedulerFactory sf = new StdSchedulerFactory();
        // 2.从工厂中获取调度器实例
        Scheduler scheduler = sf.getScheduler();


        // 3.创建JobDetail
        JobDetail jb = JobBuilder.newJob(SampleRAMJob.class)
                .withDescription("this is a ram job") // job 的描述
                .withIdentity("ramJob", "ramGroup") // job 的 name 和 group
                .build();

        // 任务运行的时间，SimpleSchedule 类型触发器有效
        long time =  System.currentTimeMillis() + 3*1000L; // 3秒后启动任务
        Date statTime = new Date(time);

        // 4.创建Trigger
        // 使用 SimpleScheduleBuilder 或者 CronScheduleBuilder
        Trigger t = TriggerBuilder.newTrigger()
                .withDescription("RAM Quartz Test")
                .withIdentity("ramTrigger", "ramTriggerGroup")
                //.withSchedule(SimpleScheduleBuilder.simpleSchedule())
                .startAt(statTime)  // 默认当前时间启动
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                // 两秒执行一次 <second minute hour day-of-month mouth-of-year day-of-week year>
                // 具体参考 https://blog.csdn.net/shfqbluestone/article/details/51009685
                // 这里不同于 *nix 系统的 crontab <minute hour day-of-month month-of-year day-of-week commands>
                .build();

        // 5.注册任务和定时器
        scheduler.scheduleJob(jb, t);

        // 6.启动 调度器
        scheduler.start();
        _log.info("启动时间 ： " + new Date());

    }
}
