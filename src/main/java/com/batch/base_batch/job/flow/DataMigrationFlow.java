package com.batch.base_batch.job.flow;

import com.batch.base_batch.dominio.Pessoa;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class DataMigrationFlow {

    @Bean
    public Flow parallelSteps(@Qualifier("pessoaMigrationStep") Step pessoaMigrationStep,
                              @Qualifier("dadosBancariosStep") Step dadosBancariosMigrationStep){
        Flow pessoaMigrationFlow = new FlowBuilder<Flow>("pessoaMigrationFlow")
                .start(pessoaMigrationStep)
                .build();

        return new FlowBuilder<Flow>("parallelStep")
                .start(dadosBancariosMigrationStep)
                .split(new SimpleAsyncTaskExecutor())
                .add(pessoaMigrationFlow)
                .build();
    }

}
