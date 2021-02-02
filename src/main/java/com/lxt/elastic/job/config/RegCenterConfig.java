//package com.lxt.elastic.job.config;
//
//import lombok.Data;
//import org.apache.shardingsphere.elasticjob.reg.base.CoordinatorRegistryCenter;
//import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperConfiguration;
//import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperRegistryCenter;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author lixt90
// */
//@Data
//@Configuration
//@ConfigurationProperties(prefix = "elasticjob.jobs.zk")
//public class RegCenterConfig {
//
//    /**
//     * 连接Zookeeper服务器的列表.
//     * 包括IP地址和端口号.
//     * 多个地址用逗号分隔.
//     * 如: host1:2181,host2:2181
//     */
//    private String serverLists;
//
//    /**
//     * 命名空间.
//     */
//    private String namespace;
//
//    /**
//     * 等待重试的间隔时间的初始值.
//     * 单位毫秒.
//     */
//    private int baseSleepTimeMilliseconds = 1000;
//
//    /**
//     * 等待重试的间隔时间的最大值.
//     * 单位毫秒.
//     */
//    private int maxSleepTimeMilliseconds = 3000;
//
//    /**
//     * 最大重试次数.
//     */
//    private int maxRetries = 3;
//
//    /**
//     * 会话超时时间.
//     * 单位毫秒.
//     */
//    private int sessionTimeoutMilliseconds = 60_000;
//
//    /**
//     * 连接超时时间.
//     * 单位毫秒.
//     */
//    private int connectionTimeoutMilliseconds = 60_000;
//
//    /**
//     * 连接Zookeeper的权限令牌.
//     * 缺省为不需要权限验证.
//     */
//    private String digest;
//
//
//    @Bean(destroyMethod = "close")
//    public CoordinatorRegistryCenter zookeeperRegistryCenter() {
//
//        // zookeeper 配置
//        ZookeeperConfiguration zkConfig = new ZookeeperConfiguration(serverLists, namespace);
//        zkConfig.setBaseSleepTimeMilliseconds(baseSleepTimeMilliseconds);
//        zkConfig.setMaxSleepTimeMilliseconds(maxSleepTimeMilliseconds);
//        zkConfig.setMaxRetries(maxRetries);
//        zkConfig.setSessionTimeoutMilliseconds(sessionTimeoutMilliseconds);
//        zkConfig.setConnectionTimeoutMilliseconds(connectionTimeoutMilliseconds);
//        zkConfig.setDigest(digest);
//
//        CoordinatorRegistryCenter registryCenter = new ZookeeperRegistryCenter(zkConfig);
//        registryCenter.init();
//
//        return registryCenter;
//    }
//}
