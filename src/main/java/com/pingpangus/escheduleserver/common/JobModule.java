package com.pingpangus.escheduleserver.common;

import com.pingpangus.escheduleserver.web.vo.JobVo;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

/**
 * @author qunar-qw
 * @date 18-7-12
 */
public class JobModule {

    private String jobId;
    private String jobName;
    private String hostIp;
    private String group;
    private String cron;

    public JobModule(JobVo jobVo) {
        BeanUtils.copyProperties(jobVo, this);
        jobId = UUID.randomUUID().toString().substring(15);
    }

    public JobModule(String taskName, String hostIp, String group, String cron) {
        jobId = UUID.randomUUID().toString().substring(15);
        this.jobName = taskName;
        this.hostIp = hostIp;
        this.group = group;
        this.cron = cron;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getTaskName() {
        return jobName;
    }

    public void setTaskName(String taskName) {
        this.jobName = taskName;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}