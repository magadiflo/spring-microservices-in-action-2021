package dev.magadiflo.licensing.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

    @Value("${redis.server}")
    private String redisServer;

    @Value("${redis.port}")
    private Integer redisPort;

    //Configura la conexión de la base de datos al servidor Redis
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        var redisStandaloneConfiguration = new RedisStandaloneConfiguration(this.redisServer, this.redisPort);
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    //Crea una RedisTemplate para realizar acciones para nuestro servidor Redis
    @Bean
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        return template;
    }

}
