package br.com.testeentrevista.dto.pessoa;

import br.com.testeentrevista.database.data.Pessoa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;


@Setter
@Getter
@NoArgsConstructor
public class PessoaDTO {

    private Long id;

    private String nome;

    private String documento;

    private String telefone;

    public Pessoa conversorDTOEmEntity() { return new ModelMapper().map(this, Pessoa.class);}
}
