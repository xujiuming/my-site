package com.ming.base.config;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.ming.core.GlobalConstants;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class JacksonConfig {
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
            builder.featuresToEnable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            builder.simpleDateFormat(GlobalConstants.DATE_FORMAT_PATTERN);
            //添加jackson 针对于jdk8的time包的序列化
            JavaTimeModule javaTimeModule = new JavaTimeModule();
            javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(GlobalConstants.LOCAL_DATE_TIME_FORMAT_PATTERN)));
            javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(GlobalConstants.LOCAL_DATE_TIME_FORMAT_PATTERN)));

            javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(GlobalConstants.LOCAL_DATE_FORMAT_PATTERN)));

            javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(GlobalConstants.LOCAL_TIME_FORMAT_PATTERN)));
            javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(GlobalConstants.LOCAL_TIME_FORMAT_PATTERN)));

            builder.modules(javaTimeModule);
        };
    }
}
