package com.lxt.elastic.job.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author lixt90
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "job")
public class JobConfig {

    private JobProperties singleShardJob;
    private JobProperties multiShardJob;

    @Data
    static class JobProperties {
        private Integer shards;
        private String cron;
    }
}
