package br.com.jpfilecreator.jpfilecreator.writer;

import br.com.jpfilecreator.jpfilecreator.model.Sale;
import lombok.extern.slf4j.Slf4j;
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
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Configuration
@Slf4j
public class SalesFileWriter {

    @Value("${spring.fileDirectory}")
    private String fileDirectory;

    @StepScope
    @Bean
    public FlatFileItemWriter<Sale> fileWriter(){
        log.info("Creating the file...");
        FlatFileItemWriter<Sale> saleItemWriter = new FlatFileItemWriter<>();

        String fileNameToSave = fileDirectory + "salesFileOut - " + LocalDateTime
                .now()
                .atZone(ZoneId.of("America/Sao_Paulo"))
                .format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss"))
                + ".csv";

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

        log.info("File created!");

        return saleItemWriter;
    }

}
