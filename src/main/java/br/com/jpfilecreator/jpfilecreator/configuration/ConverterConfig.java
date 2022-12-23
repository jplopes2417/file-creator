package br.com.jpfilecreator.jpfilecreator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ConverterConfig {

    @Bean
    public ConversionService conversionService(){
        DefaultConversionService defaultConversionService = new DefaultConversionService();
        DefaultConversionService.addDefaultConverters(defaultConversionService);

        defaultConversionService.addConverter(new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
        });
        return defaultConversionService;
    }

}
