package com.pingpangus.escheduleserver.service;

import com.pingpangus.escheduleserver.config.EScheduleProperties;
import com.pingpangus.escheduleserver.web.ServerApiController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : qw.r
 * @since : 19-4-27 09:54
 */
@Configuration
@EnableConfigurationProperties(value = EScheduleProperties.class)
@ConditionalOnClass(value = ServerApiController.class)
@ConditionalOnProperty(prefix = "eschedule.server", name = "enable", havingValue = "true", matchIfMissing = false)
public class EScheduleAutoConfigure {

    private static final Logger logger = LoggerFactory.getLogger(EScheduleAutoConfigure.class);

    @Autowired
    private EScheduleProperties eScheduleProperties;

    @Bean
    @ConditionalOnClass(value = EScheduleAutoConfigure.class)
    public ESinitService doStart() {

        String startAs = eScheduleProperties.getStartas();
        String cluster = eScheduleProperties.getCluster();
        String serverurl = eScheduleProperties.getServerurl();
        logger.info("start as :{}, cluster:{}, serverUrl:{}", startAs, cluster, serverurl);
        return null;
    }

}
