package br.com.jpfilecreator.jpfilecreator.writer;

import br.com.jpfilecreator.jpfilecreator.model.Sale;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.WritableResource;

@Configuration
public class SalesFileWriter {

    @StepScope
    @Bean
    public FlatFileItemWriter<Sale> fileWriter(@Value("#{jobParameters['salesFileOut']}") WritableResource salesFileOut){
        return new FlatFileItemWriterBuilder<Sale>()
                .name("fileWriter")
                .resource(salesFileOut)
                .delimited()
                .names("username", "transaction_date", "transaction_value", "transaction_description", "transaction_type", "local_type")
                .build();
    }

    private FlatFileItemWriter<Sale> createFile() {

        return null;
    }
}
