package br.com.testeentrevista.database.data;

import br.com.testeentrevista.dto.pessoa.PessoaDTO;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pessoas")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "documento")
    private String documento;

    @Column(name = "telefone")
    private String telefone;

    public Pessoa(Long id) {this.id = id;}

    public PessoaDTO conversorEntityEmDTO() { return new ModelMapper().map(this, PessoaDTO.class);}
}
