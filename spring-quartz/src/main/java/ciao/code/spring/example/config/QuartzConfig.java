package ciao.code.spring.example.config;

import ciao.code.spring.example.job.HelloJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description:
 * @create: 2019-06-18 10:21
 **/
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(HelloJob.class)
                .withIdentity("myjob", "myjobgroup1")
                .usingJobData("job_param", "good jod")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger(){
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail())
                .withIdentity("myTrigger", "myTriggergroup1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? 2019")).build();
    }

    @Bean
    public void test(){
        System.out.println("test");
    }
}
