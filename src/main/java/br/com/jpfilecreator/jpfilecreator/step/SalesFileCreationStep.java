package br.com.jpfilecreator.jpfilecreator.step;

import br.com.jpfilecreator.jpfilecreator.model.Sale;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SalesFileCreationStep {

    @Bean
    public Step newSalesFileStep(JobRepository jobRepository,
                                 FlatFileItemWriter<Sale> salesFileWriter,
                                 JdbcPagingItemReader<Sale> saleItemReader,
                                 PlatformTransactionManager platformTransactionManager){
        return new StepBuilder("newSalesFileStep", jobRepository)
                .<Sale, Sale>chunk(100, platformTransactionManager)
                .reader(saleItemReader)
                .writer(salesFileWriter)
                .build();
    }

}
