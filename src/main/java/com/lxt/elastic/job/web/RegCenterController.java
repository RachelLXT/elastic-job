//package com.lxt.elastic.job.web;
//
//import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shardingsphere.elasticjob.reg.base.CoordinatorRegistryCenter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author lixt90
// */
//@Slf4j
//@RestController("regCenter")
//public class RegCenterController {
//
//    @Autowired
//    private CoordinatorRegistryCenter regCenter;
//
//
//    /**
//     * 删除namespace根目录会导致整个集群需要重启。
//     * @param key
//     * @return
//     */
//    @DeleteMapping("del")
//    public String del(@RequestParam(defaultValue = "/") String key) {
//        regCenter.remove(key);
//        return "ok.";
//    }
//
//}
