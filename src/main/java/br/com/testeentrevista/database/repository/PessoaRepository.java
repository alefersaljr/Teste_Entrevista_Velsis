package br.com.testeentrevista.database.repository;

import br.com.testeentrevista.database.data.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findByNome(String nome);

    Pessoa findByDocumento(String documento);

    Pessoa findByTelefone(String telefone);
}
