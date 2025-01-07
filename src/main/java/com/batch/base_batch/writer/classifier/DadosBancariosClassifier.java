package com.batch.base_batch.writer.classifier;

import com.batch.base_batch.dominio.DadosBancarios;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.classify.Classifier;
import org.springframework.stereotype.Component;

@Component
public class DadosBancariosClassifier implements Classifier<DadosBancarios, ItemWriter<? super DadosBancarios>> {

    private final JdbcBatchItemWriter<DadosBancarios> jdbcBatchItemWriter;
    private final FlatFileItemWriter<DadosBancarios> invalidDadosBancariosWriter;

    public DadosBancariosClassifier(JdbcBatchItemWriter<DadosBancarios> jdbcBatchItemWriter, FlatFileItemWriter<DadosBancarios> flatFileItemWriter) {
        this.jdbcBatchItemWriter = jdbcBatchItemWriter;
        this.invalidDadosBancariosWriter = flatFileItemWriter;
    }

    @Override
    public ItemWriter<? super DadosBancarios> classify(DadosBancarios dadosBancarios) {
        if (dadosBancarios.isValid()){
            return jdbcBatchItemWriter;
        }
        return invalidDadosBancariosWriter;
    }
}
