package com.batch.base_batch.writer;

import com.batch.base_batch.dominio.DadosBancarios;
import com.batch.base_batch.writer.classifier.DadosBancariosClassifier;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DadosBancariosClassifierConfig {

    @Autowired
    private DadosBancariosClassifier classifier;

    @Bean
    public ClassifierCompositeItemWriter<DadosBancarios> dadosBancariosWriterClassifier(){
        return new ClassifierCompositeItemWriterBuilder<DadosBancarios>()
                .classifier(classifier)
                .build();
    }

}
