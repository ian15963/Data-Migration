package com.batch.base_batch.step;

import com.batch.base_batch.dominio.DadosBancarios;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DadosBancariosMigrationStep {

    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public Step dadosBancariosStep(ItemReader<DadosBancarios> itemReader,
                                   ItemWriter<DadosBancarios> itemWriter){
        return new StepBuilder("dadosBancariosStep", jobRepository)
                .<DadosBancarios, DadosBancarios>chunk(1, transactionManager)
                .reader(itemReader)
                .writer(itemWriter)
                .build();
    }

}
