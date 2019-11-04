package org.easymis.easywebsocket.server;




import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = "org.easymis.easycompany")
@EnableTransactionManagement(order = 2) // 设置事务执行顺序(需要在切换数据源之后，否则只走主库)
@MapperScan(basePackages = "org.easymis.easycompany.entitys.mybatis.mapper")
@ServletComponentScan
@EnableRedisHttpSession(maxInactiveIntervalInSeconds =  60*60*8 )
@EnableSwagger2
public class EasyWebSocketApplication {
	protected static final Logger logger = LoggerFactory.getLogger(EasyWebSocketApplication.class);

	public static void main(String[] args) {
		logger.info("EasyWebSocket开始加载");
		SpringApplication.run(EasyWebSocketApplication.class, args);
		logger.info("EasyWebSocket加载完毕");
	}

}