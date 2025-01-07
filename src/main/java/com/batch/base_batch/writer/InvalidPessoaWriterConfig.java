package com.batch.base_batch.writer;

import com.batch.base_batch.dominio.Pessoa;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class InvalidPessoaWriterConfig {

    @Bean
    public FlatFileItemWriter<Pessoa> invalidDataWriter(){
        return new FlatFileItemWriterBuilder<Pessoa>()
                .name("invalidData")
                .resource(new FileSystemResource("files/pessoas_invalidas.csv"))
                .delimited()
                .names("id")
                .build();
    }

}