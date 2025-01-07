package com.batch.base_batch.reader.mapper;

import com.batch.base_batch.dominio.Pessoa;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindException;

@Configuration
public class PessoaFieldSetMapper implements FieldSetMapper<Pessoa> {

    @Override
    public Pessoa mapFieldSet(FieldSet fieldSet) throws BindException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(fieldSet.readLong("id"));
        pessoa.setEmail(fieldSet.readString("email"));
        pessoa.setNome(fieldSet.readString("nome"));
        pessoa.setIdade(fieldSet.readInt("idade"));
        pessoa.setDataNascimento(fieldSet.readDate("dataNascimento", "yyyy-MM-dd HH:mm:ss"));
        return pessoa;
    }

}
