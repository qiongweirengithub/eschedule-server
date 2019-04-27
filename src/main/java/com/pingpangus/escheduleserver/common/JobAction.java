package com.pingpangus.escheduleserver.common;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.pingpangus.escheduleserver.utils.EscheduleHttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * @author qunar-qw
 * @date 18-7-12
 */
public class JobAction implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobAction.class);

    private String clientIp;

    private String url = "eschdule-eclient/start";

    private String jobName;

    public JobAction() {
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public static class ActionBuilder {
        JobAction jobAction = new JobAction();
        public ActionBuilder setClientIp(String ip) {
            jobAction.setClientIp(ip);
            return this;
        }
        public ActionBuilder setUrl(String url) {
            jobAction.setUrl(url);
            return this;
        }
        public ActionBuilder setTaskName(String jobName) {
            jobAction.setJobName(jobName);
            return this;
        }
        public JobAction build(){
            return jobAction;
        }
    }

    @Override
    public void run() {
        Map<String, String> paramMap = Maps.newHashMap();
        paramMap.put("jobName", getJobName());
        try {
            EscheduleHttpUtils.get(clientIp, paramMap);
        } catch (IOException e) {
            LOGGER.error("error when invoking eclient job", e);
        }
        LOGGER.info("task -{}- running", jobName);
    }
}