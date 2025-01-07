package com.batch.base_batch.writer;

import com.batch.base_batch.dominio.DadosBancarios;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DadosBancariosWriterConfig {

    @Bean
    public JdbcBatchItemWriter<DadosBancarios> dadosBancariosWriter(@Qualifier("appDataSource")DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<DadosBancarios>()
                .dataSource(dataSource)
                .sql("INSERT INTO dados_bancarios(id, agencia, conta, banco, pessoa_id) VALUES (:id,:agencia,:conta,:banco,:pessoaId)")
                .beanMapped()
                .build();
    }

}
