package org.exp.config;

import org.n3r.idworker.Sid;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 紫苏
 * @date: 2019/11/8 下午5:43
 * @description:
 */
@Configuration
public class SidConfig {

    @Bean
    public Sid sid() {
        return new Sid();
    }

}
