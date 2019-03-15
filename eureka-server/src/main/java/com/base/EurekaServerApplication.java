package com.base;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * 
 * @author 
 * @date 2018年4月23日 下午6:33:29
 * 
 * jar 运行方式
 * java -jar eureka-server-0.0.1-SNAPSHOT.jar
 * 
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}	
