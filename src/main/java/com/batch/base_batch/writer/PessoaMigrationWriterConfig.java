package com.batch.base_batch.writer;

import com.batch.base_batch.dominio.Pessoa;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Date;

@Configuration
public class PessoaMigrationWriterConfig {

    @Bean
    public JdbcBatchItemWriter<Pessoa> pessoaWriter(@Qualifier("appDataSource")DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<Pessoa>()
                .dataSource(dataSource)
                .sql("INSERT INTO pessoa(id, nome, email, data_nascimento, idade) VALUES (?,?,?,?,?)")
                .itemPreparedStatementSetter((pessoa, ps) -> {
                    ps.setLong(1, pessoa.getId());
                    ps.setString(2, pessoa.getNome());
                    ps.setString(3, pessoa.getEmail());
                    ps.setDate(4, new Date(pessoa.getDataNascimento().getTime()));
                    ps.setInt(5, pessoa.getIdade());
                })
                .build();
    }

}
