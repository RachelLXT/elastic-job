//package com.lxt.elastic.job.config;
//
//import com.dangdang.ddframe.job.api.ElasticJob;
//import com.dangdang.ddframe.job.config.JobCoreConfiguration;
//import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
//import com.dangdang.ddframe.job.lite.api.JobScheduler;
//import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
//import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
//import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
//import com.lxt.elastic.job.simplejob.MultiShardJob;
//import com.lxt.elastic.job.simplejob.SingleShardJob;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.ContextRefreshedEvent;
//
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @author lixt90
// */
//@Slf4j
//@Configuration
//public class JobHandler implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Autowired
//    private CoordinatorRegistryCenter registryCenter;
//
//    @Autowired
//    private MultiShardJob multiShardJob;
//    @Autowired
//    private SingleShardJob singleShardJob;
//
//    @Autowired
//    private JobConfig jobConfig;
//
//    private AtomicInteger jobCount = new AtomicInteger(0);
//
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//
//        try {
//
//
//            initJob(singleShardJob,
//                    SingleShardJob.JOB_NAME,
//                    SingleShardJob.class.getCanonicalName(),
//                    jobConfig.getSingleShardJob());
//
//            initJob(multiShardJob,
//                    MultiShardJob.JOB_NAME,
//                    MultiShardJob.class.getCanonicalName(),
//                    jobConfig.getMultiShardJob());
//
//
//            log.info("定时任务启动结束，总任务数{}个", jobCount.get());
//        } catch (Exception e) {
//            log.error("定时任务初始化失败，{}", e.getMessage(), e);
//        }
//    }
//
//    private void initJob(ElasticJob job, String jobName, String canonicalName, JobConfig.JobProperties jobProperties) {
//        try {
//            log.info("启动[{}]", jobName);
//            JobScheduler jobScheduler = new SpringJobScheduler(job, registryCenter,
//                    createJobConfiguration(jobName, canonicalName, jobProperties.getShards(), jobProperties.getCron()));
//            jobScheduler.init();
//            jobCount.incrementAndGet();
//            log.info("[{}]启动完毕", jobName);
//        } catch (Exception e) {
//            log.error("[{}]启动失败:{}", jobName, e.getMessage(), e);
//        }
//
//    }
//
//    private LiteJobConfiguration createJobConfiguration(String jobName, String canonicalName, Integer shards, String cron) {
//        JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder(jobName, cron, shards).build();
//        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig, canonicalName);
//        return LiteJobConfiguration.newBuilder(simpleJobConfig).build();
//    }
//}
