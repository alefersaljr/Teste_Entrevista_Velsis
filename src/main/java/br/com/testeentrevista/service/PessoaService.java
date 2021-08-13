package br.com.testeentrevista.service;

import br.com.testeentrevista.database.data.Pessoa;

public interface PessoaService {

    Pessoa criar(Pessoa pessoa);

    Pessoa buscarPessoaPorNome(String nome);

    Pessoa buscarPessoaPorDocumento(String documento);

    Pessoa buscarPessoaPorTelefone(String telefone);

}
