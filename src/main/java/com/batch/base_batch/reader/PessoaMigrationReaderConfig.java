package com.batch.base_batch.reader;

import com.batch.base_batch.dominio.Pessoa;
import com.batch.base_batch.mapper.PessoaFieldSetMapper;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class PessoaMigrationReaderConfig {

    @Autowired
    private PessoaFieldSetMapper pessoaFieldSetMapper;

    @Bean
    public FlatFileItemReader<Pessoa> pessoaMigrationReader(){
        return new FlatFileItemReaderBuilder<Pessoa>()
                .name("pessoaMigrationReader")
                .resource(new FileSystemResource("file:/files/pessoas.csv"))
                .delimited()
                .names("nome", "email", "dataNascimento", "idade", "id")
                .fieldSetMapper(pessoaFieldSetMapper)
                .build();
    }

}
