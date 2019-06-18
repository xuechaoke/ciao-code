package ciao.code.spring.example.job;

import ciao.code.spring.example.service.JobService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @program: ciao-code
 * @author: xuechaoke
 * @description: job hi
 * @create: 2019-06-18 10:18
 **/
@AllArgsConstructor
public class HelloJob extends QuartzJobBean {
    private final JobService jobService;

    @Override
    @SneakyThrows
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        jobService.sayHello();
        System.out.println("    Hi! :" + jobExecutionContext.getJobDetail().getKey());
    }
}
