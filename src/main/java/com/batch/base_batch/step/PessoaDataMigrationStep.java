package com.batch.base_batch.step;

import com.batch.base_batch.dominio.Pessoa;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class PessoaDataMigrationStep {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public Step pessoaMigrationStep(ItemReader<Pessoa> itemReader,
                                    FlatFileItemWriter<Pessoa> itemWriter,
                                    ClassifierCompositeItemWriter<Pessoa> classifier){
        return new StepBuilder("pessoaMigration", jobRepository)
                .<Pessoa, Pessoa>chunk(200, transactionManager)
                .reader(itemReader)
                .writer(classifier)
                .stream(itemWriter)
                .build();
    }

}
