package br.com.testeentrevista.boundary.pessoa;

import br.com.testeentrevista.database.data.Pessoa;
import br.com.testeentrevista.database.repository.PessoaRepository;
import br.com.testeentrevista.service.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {

    private static final Logger logger = LoggerFactory.getLogger(PessoaServiceImpl.class);

    @Autowired
    PessoaRepository repository;

    @Override
    public Pessoa criar(Pessoa pessoa){

        logger.info("Iniciando verificação dos dados inseridos");

        if ((pessoa.getDocumento().length() == 11) && (pessoa.getTelefone().length() == 11)){
            try {
                logger.info("Iniciando processo de cadastro de hóspede");
                return repository.save(pessoa);

            } catch (Exception e) {
                logger.info("Erro ao inserir hóspede");
                logger.info("Menssagem de erro: " + e.getMessage());
                return null;
            }
        } else {
            logger.info("Erro encontrado. Por favor, verifique os números de documento e telefone inseridos");
            return null;
        }
    }

    @Override
    public Pessoa buscarPessoaPorNome(String nome){
        return repository.findByNome(nome);
    }

    @Override
    public Pessoa buscarPessoaPorDocumento(String documento){
        return repository.findByDocumento(documento);
    }

    @Override
    public Pessoa buscarPessoaPorTelefone(String telefone){
        return repository.findByTelefone(telefone);
    }
}
