package com.batch.base_batch.writer;

import com.batch.base_batch.dominio.Pessoa;
import com.batch.base_batch.writer.classifier.PessoaClassifier;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PessoaWriterClassifierConfig {

    @Autowired
    private PessoaClassifier pessoaClassifier;

    @Bean
    public ClassifierCompositeItemWriter<Pessoa> pessoaWriterClassifier(){
        return new ClassifierCompositeItemWriterBuilder<Pessoa>()
                .classifier(pessoaClassifier)
                .build();
    }
}
