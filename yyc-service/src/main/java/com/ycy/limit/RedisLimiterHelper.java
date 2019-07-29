package com.ycy.limit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

/**
 * @author Levin
 * @since 2018/8/2 0002
 */
@Configuration
public class RedisLimiterHelper {
	
	

  @Bean
  @SuppressWarnings("all")
  public RedisTemplate<String, Serializable> limitRedisTemplate(RedisConnectionFactory factory) {
      RedisTemplate<String, Serializable> template = new RedisTemplate<String, Serializable>();
      template.setConnectionFactory(factory);
      Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
      ObjectMapper om = new ObjectMapper();
      om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
      jackson2JsonRedisSerializer.setObjectMapper(om);
      StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
      // key采用String的序列化方式
      template.setKeySerializer(stringRedisSerializer);
      // hash的key也采用String的序列化方式
      template.setHashKeySerializer(stringRedisSerializer);
      // value序列化方式采用jackson
      template.setValueSerializer(jackson2JsonRedisSerializer);
      // hash的value序列化方式采用jackson
      template.setHashValueSerializer(jackson2JsonRedisSerializer);
      template.afterPropertiesSet();
      return template;
  }

      /**
       * springboot2.x 使用LettuceConnectionFactory 代替 RedisConnectionFactory
       * application.yml配置基本信息后,springboot2.x  RedisAutoConfiguration能够自动装配
       * LettuceConnectionFactory 和 RedisConnectionFactory 及其 RedisTemplate
       * @param redisConnectionFactory
       * @return
       */
     /* @Bean
      public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory redisConnectionFactory){
          RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
          redisTemplate.setKeySerializer(new StringRedisSerializer());
          redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
          redisTemplate.setHashKeySerializer(new StringRedisSerializer());
          redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
          redisTemplate.setConnectionFactory(redisConnectionFactory);
          return redisTemplate;
      }*/



   /* @Bean
    public RedisTemplate<String, Serializable> limitRedisTemplate(LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Serializable> template = new RedisTemplate<String, Serializable>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }*/
}
