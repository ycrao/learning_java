package com.raoyc.quartz.demo;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import com.raoyc.quartz.demo.job.MailJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.io.*;
import java.util.Properties;

public class TestQuartz {
    public static void main(String[] args) throws Exception {
        try {
            assginNewJob();
        } catch (ObjectAlreadyExistsException e) {
            System.err.println("发现任务已经在数据库存在了，直接从数据库里运行:" + e.getMessage());
            // TODO Auto-generated catch block
            resumeJobFromDatabase();
        }
    }

    private static void resumeJobFromDatabase() throws Exception {
        Scheduler scheduler = getScheduler();
        scheduler.start();
        // 等待 15 秒，让前面的任务都执行完了之后，再关闭调度器
        Thread.sleep(15000);
        scheduler.shutdown(true);
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

    private static void assginNewJob() throws SchedulerException, InterruptedException, IOException {
        // 创建调度器
        // Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        Scheduler scheduler = getScheduler();
        // 定义一个触发器
        CronTriggerImpl trigger = (CronTriggerImpl)newTrigger().withIdentity("trigger2_1", "tGroup2") // 定义名称和所属的租
                .startNow()
                .withSchedule(/*simpleSchedule().withIntervalInSeconds(5).withRepeatCount(6)*/ /*每隔5秒执行一次，总共执行7次(第一次执行不基数)*/
                        CronScheduleBuilder.cronSchedule("0/5 * * * * ?") // Cron表达式 每5秒执行一次
                )
                .build();

        // 错过触发策略，丢弃错过的触发，等待下一次执行时机
        trigger.setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_DO_NOTHING);

        // 定义一个JobDetail
        JobDetail job = newJob(MailJob.class) // 指定干活的类MailJob
                .withIdentity("job2_1", "jGroup2") // 定义任务名称和分组
                .usingJobData("email", "admin@example.com") // 定义属性
                .build();

        // 启动
        scheduler.start();

        // 调度加入这个job
        if (scheduler.checkExists(job.getKey())) {
            scheduler.deleteJob(job.getKey());
        }
        scheduler.scheduleJob(job, trigger);

        // 等待15秒，让前面的任务都执行完了之后，再关闭调度器
        Thread.sleep(15000);
        scheduler.shutdown(true);
    }
}
