package com.batch.base_batch.reader;

import com.batch.base_batch.dominio.DadosBancarios;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class DadosBancariosMigrationReaderConfig {

   @Bean
   public FlatFileItemReader<DadosBancarios> dadosBancariosReader(){
       return new FlatFileItemReaderBuilder<DadosBancarios>()
               .name("dadosBancariosReader")
               .resource(new FileSystemResource("file:/files/dados_bancarios.csv"))
               .delimited()
               .names("pessoaId", "agencia", "conta", "banco", "id")
               .targetType(DadosBancarios.class)
               .build();
   }

}
