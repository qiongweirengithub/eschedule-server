package com.pingpangus.escheduleserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author : qw.r
 * @since : 19-4-27 09:46
 */
@ConfigurationProperties(prefix = "escheduleserver")
public class EScheduleProperties {

    private String startas;

    private String serverurl;

    private String cluster;

    public String getStartas() {
        return startas;
    }

    public void setStartas(String startas) {
        this.startas = startas;
    }

    public String getServerurl() {
        return serverurl;
    }

    public void setServerurl(String serverurl) {
        this.serverurl = serverurl;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }
}
