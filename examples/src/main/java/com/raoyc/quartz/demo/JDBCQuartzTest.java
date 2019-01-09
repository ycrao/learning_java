package com.raoyc.quartz.demo;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;
import java.util.Properties;

import com.raoyc.quartz.demo.job.SampleJDBCJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class JDBCQuartzTest {

    public static void main(String[] args) throws Exception {
        startSchedule();
        // resumeJob();
    }

    /**
     * 开始一个simpleSchedule()调度
     * o.quartz.core.QuartzSchedulerThread - Runtime error occurred in main trigger firing loop.
     * java.lang.IllegalStateException: JobStore is shutdown - aborting retry
     * https://github.com/quartz-scheduler/quartz/issues/134
     * https://github.com/quartz-scheduler/quartz/issues/145
     * https://github.com/quartz-scheduler/quartz/pull/146
     *
     */
    public static void startSchedule() throws IOException {

        try {
            // 1、创建一个JobDetail实例，指定Quartz
            JobDetail jobDetail = JobBuilder.newJob(SampleJDBCJob.class)
                    // 任务执行类
                    .withIdentity("job1_1", "jGroup1")
                    // 任务名，任务组
                    // .storeDurably(true)
                    .build();

            // 触发器类型

            SimpleScheduleBuilder builder = SimpleScheduleBuilder
                    // 设置执行次数
                    .repeatSecondlyForTotalCount(100);


            // CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule("0/2 * * * * ?");
            // 2、创建Trigger
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1_1", "tGroup1").startNow()
                    .withSchedule(builder)
                    .build();

            // 3、创建Scheduler
            // 由于某些原因 quartz.properties 有可能不会自动加载进去，可以采用下面方式手动引入
            Scheduler scheduler = getScheduler();
            // Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            // 4、调度执行

            if (scheduler.checkExists(jobDetail.getKey())) {
                scheduler.deleteJob(jobDetail.getKey());
            }
            scheduler.scheduleJob(jobDetail, trigger);

            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 一分钟后，关闭调度器
            scheduler.shutdown();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从数据库中找到已经存在的job，并重新开户调度
     */
    public static void resumeJob() {

        try {
            Scheduler scheduler = getScheduler();
            JobKey jobKey = new JobKey("job1_1", "jGroup1");
            List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
            // SELECT TRIGGER_NAME, TRIGGER_GROUP FROM {0}TRIGGERS WHERE SCHED_NAME = {1} AND JOB_NAME = ? AND JOB_GROUP = ?
            // 重新恢复在 jGroup1 组中，名为 job1_1 的 job 的触发器运行
            if (triggers.size() > 0) {
                for (Trigger tg : triggers) {
                    // 根据类型判断
                    if ((tg instanceof CronTrigger) || (tg instanceof SimpleTrigger)) {
                        // 恢复job运行
                        scheduler.resumeJob(jobKey);
                    }
                }
                scheduler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Scheduler getScheduler() throws IOException, SchedulerException {
        Properties props = new Properties();
        // InputStream fis = new BufferedInputStream(new FileInputStream("/path/to/learning_java/examples/src/main/resources/config/quartz.properties"));
        InputStream fis = JDBCQuartzTest.class.getClassLoader().getResourceAsStream("config/quartz.properties");
        props.load(fis);
        StdSchedulerFactory factory = new StdSchedulerFactory();
        factory.initialize(props);
        // 创建调度器
        // Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        Scheduler scheduler = factory.getScheduler();
        return scheduler;
    }
}
