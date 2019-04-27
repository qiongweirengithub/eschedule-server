package com.pingpangus.escheduleserver.web;

import com.pingpangus.escheduleserver.common.JobModule;
import com.pingpangus.escheduleserver.core.SchedulerRegister;
import com.pingpangus.escheduleserver.core.taskstorage.ITaskStorage;
import com.pingpangus.escheduleserver.web.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : qw.r
 * @since : 19-4-27 12:28
 */
@RestController
public class ServerApiController {

    private static final Logger logger = LoggerFactory.getLogger(ServerApiController.class);

    @Autowired
    private SchedulerRegister schedulerRegister;

    @Autowired
    private ITaskStorage taskStorage;

    @RequestMapping("register")
    public ResponseVo register(String jobName, String ip, String cron) {
        logger.info("接收到添加任务请求->  jobName:{}, host:{}, cron:{}", jobName, ip, cron);
        try {
            taskStorage.insertOne(new JobModule(jobName, ip, "", cron));
            schedulerRegister.register(jobName);
        } catch (Exception e) {
            logger.error("任务注册失败");
        }
        return new ResponseVo();
    }

}
