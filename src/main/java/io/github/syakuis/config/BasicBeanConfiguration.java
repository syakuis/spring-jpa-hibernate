package io.github.syakuis.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.github.syakuis.config.support.SimpleObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;

import java.util.Locale;

@Configuration
public class BasicBeanConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);

        return SimpleObjectMapper.of(mapper);
    }

    @Bean("i18n")
    @ConditionalOnMissingBean
    public MessageSourceAccessor i18n(MessageSource messageSource) {
        return new MessageSourceAccessor(messageSource, Locale.getDefault());
    }
}
