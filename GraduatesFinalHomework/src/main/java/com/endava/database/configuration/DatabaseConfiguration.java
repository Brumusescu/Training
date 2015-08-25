package com.endava.database.configuration;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.net.UnknownHostException;

@EnableWebMvc
@Configuration
@ComponentScan("com.endava")
public class DatabaseConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public Jongo databaseConnection() throws UnknownHostException {
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        DB db = mongoClient.getDB("local");
        Jongo jongo = new Jongo(db);
        return jongo;
    }

    @Bean
    public MappingJackson2HttpMessageConverter getJacksonConverter(){
        return new MappingJackson2HttpMessageConverter();
    }


}
