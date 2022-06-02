package io.github.syakuis.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebMvcConfiguration extends DelegatingWebMvcConfiguration {
    private final Environment environment;
    private final ObjectMapper objectMapper;

    // TODO restDocs setting
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (environment.acceptsProfiles(Profiles.of("stage | default"))) {
            registry.addResourceHandler("/docs/**").addResourceLocations("classpath:/static/docs/");
        }
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        converters.add(stringConverter);
        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
        super.addDefaultHttpMessageConverters(converters);
    }
}
