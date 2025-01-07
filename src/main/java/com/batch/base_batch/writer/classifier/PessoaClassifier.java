package com.batch.base_batch.writer.classifier;

import com.batch.base_batch.dominio.Pessoa;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.classify.Classifier;
import org.springframework.stereotype.Component;

@Component
public class PessoaClassifier implements Classifier<Pessoa, ItemWriter<? super Pessoa>> {

    private final JdbcBatchItemWriter<Pessoa> jdbcBatchItemWriter;
    private final FlatFileItemWriter<Pessoa> invalidPessoaWriter;

    public PessoaClassifier(JdbcBatchItemWriter<Pessoa> jdbcBatchItemWriter, FlatFileItemWriter<Pessoa> invalidPessoaWriter) {
        this.jdbcBatchItemWriter = jdbcBatchItemWriter;
        this.invalidPessoaWriter = invalidPessoaWriter;
    }

    @Override
    public ItemWriter<? super Pessoa> classify(Pessoa pessoa) {
        if(pessoa.isValid()){
            return jdbcBatchItemWriter;
        }
        return invalidPessoaWriter;
    }
}
