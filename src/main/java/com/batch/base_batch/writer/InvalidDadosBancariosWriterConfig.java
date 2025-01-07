package com.batch.base_batch.writer;

import com.batch.base_batch.dominio.DadosBancarios;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class InvalidDadosBancariosWriterConfig {

    @Bean
    public FlatFileItemWriter<DadosBancarios> invalidDadosBancariosWriter(){
        return new FlatFileItemWriterBuilder<DadosBancarios>()
                .name("dadosBancariosInvalidos")
                .resource(new FileSystemResource("files/dados_bancarios_invalidos.csv"))
                .delimited()
                .names("id")
                .build();
    }

}
