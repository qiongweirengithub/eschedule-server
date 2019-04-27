package com.pingpangus.escheduleserver.web;

import com.pingpangus.escheduleserver.common.JobModule;
import com.pingpangus.escheduleserver.core.taskstorage.ITaskStorage;
import com.pingpangus.escheduleserver.web.vo.JobVo;
import com.pingpangus.escheduleserver.web.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * http://localhost:8080/register?jobName=&&task2&&ip=mockIp&&cron=0/5%20*%20*%20*%20*%20*
 * http://localhost:8080/register?jobName=%22task1%22&ip=%22xx%22&cron=%22cc%22
 * @author qunar-qw
 * @date 18-7-12
 */
@Controller
@RequestMapping(value = "eschdule-server")
public class ManagementController {

    private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

    @Autowired
    private ITaskStorage taskStorage;


    @RequestMapping("queryAll")
    @ResponseBody
    public ResponseVo queryAll() {
        logger.info("load for all request");
        try {
            List<JobModule> taskModuleList = taskStorage.queryAll();
            return ResponseVo.createTrue(taskModuleList);
        } catch (Exception e) {
            logger.error("任务注册失败");
        }
        return new ResponseVo();
    }

    @RequestMapping("query")
    @ResponseBody
    public ResponseVo query(String name) {
        try {
            JobModule taskModule = taskStorage.queryOne(name);
            return ResponseVo.createTrue(taskModule);
        } catch (Exception e) {
            logger.error("任务注册失败");
        }
        return new ResponseVo();
    }

    @RequestMapping("update")
    @ResponseBody
    public ResponseVo update(JobVo jobVo) {
        logger.info("更新定时任务:{}", jobVo.toString());
        try {
            taskStorage.update(new JobModule(jobVo));
            return ResponseVo.createTrue(null);
        } catch (Exception e) {
            logger.error("任务更新失败");
        }
        return new ResponseVo();
    }

}