package br.com.jpfilecreator.jpfilecreator.writer;

import br.com.jpfilecreator.jpfilecreator.model.Sale;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.WritableResource;

import java.time.LocalDateTime;

@Configuration
public class SalesFileWriter {

    @Value("${spring.fileDirectory}")
    private String fileDirectory;

    @StepScope
    @Bean
    public FlatFileItemWriter<Sale> fileWriter(){
        FlatFileItemWriter<Sale> saleItemWriter = new FlatFileItemWriter<>();

        String fileNameToSave = fileDirectory + "salesFileOut" + LocalDateTime.now() + ".csv";
        WritableResource outputResource = new FileSystemResource(fileNameToSave);

        BeanWrapperFieldExtractor<Sale> saleBeanWrapperFieldExtractor = new BeanWrapperFieldExtractor<>();
        saleBeanWrapperFieldExtractor.setNames(new String[]{"username",
                "transactionDate",
                "transactionValue",
                "transactionDescription",
                "transactionType",
                "localType"});

        DelimitedLineAggregator<Sale> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setDelimiter(";");
        lineAggregator.setFieldExtractor(saleBeanWrapperFieldExtractor);

        saleItemWriter.setResource(outputResource);
        saleItemWriter.setLineAggregator(lineAggregator);
        saleItemWriter.setAppendAllowed(true);
        saleItemWriter.setHeaderCallback(writer -> {
            String header = "username;transaction_date;transaction_value;transaction_description,transaction_type,local_type";
            writer.write(header);
        });

        return saleItemWriter;
    }

}
