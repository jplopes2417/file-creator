package br.com.jpfilecreator.jpfilecreator.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileCreatorjobConfig {

//    @Bean
//    public Job newFileJob(Step newFileStep){
//        return jobBuilderFactory
//                .get("newFileJob")
//                .start(newFileStep)
//                .incrementer(new RunIdIncrementer())
//                .build();
//    }

    @Bean
    public Job newFileJob(JobRepository jobRepository, Step newFileStep){
        return new JobBuilder("newFileJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(newFileStep)

                .build();
    }


}
