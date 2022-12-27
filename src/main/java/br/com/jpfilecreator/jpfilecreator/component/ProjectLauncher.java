package br.com.jpfilecreator.jpfilecreator.component;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProjectLauncher implements CommandLineRunner {

    private final JobLauncher jobLauncher;
    private final Job job;

	@Override
	public void run(String... args) throws Exception {
		JobParameters parameters = new JobParametersBuilder()
				.addString("JobID", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();
		jobLauncher.run(job, parameters);
	}
}
