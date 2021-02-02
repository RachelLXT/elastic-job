package com.lxt.elastic.job.simplejob;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author lixt90
 */
@Slf4j
@Service
public class MultiShardJob implements SimpleJob {
    public static final String JOB_NAME = "MULTI SHARD JOB";

    @Value("${spring.application.name}")
    private String app;

    @Override
    public void execute(ShardingContext shardingContext) {
        log.info("{}: execute [{}], concurrent shard={}", app, JOB_NAME, shardingContext.getShardingItem());
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
