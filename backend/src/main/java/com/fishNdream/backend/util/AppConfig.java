package com.fishNdream.backend.util;

import java.util.Map;

import javax.validation.Validator;

import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class AppConfig
{
@Bean
    public ObjectMapper objectMapper()
    {
        ObjectMapper mapper = new ObjectMapper();
        //mapper.setSerializationInclusion(Include.NON_EMPTY);
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        mapper.registerModule(javaTimeModule);

        return mapper;
    }

@Bean
public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(final Validator validator) {
  return new HibernatePropertiesCustomizer() {

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
      @SuppressWarnings("rawtypes")
      Class[] classes = {OnInsert.class};
      hibernateProperties.put("javax.persistence.validation.group.pre-persist", classes);
    }
  };
}

}