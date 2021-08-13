package br.com.testeentrevista.boundary.pessoa;


import br.com.testeentrevista.database.data.Pessoa;
import br.com.testeentrevista.dto.Response;
import br.com.testeentrevista.dto.pessoa.PessoaDTO;
import br.com.testeentrevista.exception.PessoaNaoEncontradaException;
import br.com.testeentrevista.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hoteis/v1/pessoas")
public class PessoaController{

    private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);

    PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {this.pessoaService = pessoaService;}

    @PostMapping
    public ResponseEntity<Response<PessoaDTO>> criar(@RequestBody PessoaDTO dto){

        Response<PessoaDTO> response = new Response<>();

        Pessoa pessoa = pessoaService.criar(dto.conversorDTOEmEntity());
        PessoaDTO pessoaDTO = pessoa.conversorEntityEmDTO();

        response.setData(pessoaDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "/buscar_por_nome/{nome}")
    @ApiOperation(value = "Rota para procurar um hospede por nome na API")
    public ResponseEntity<Response<PessoaDTO>> buscarPessoaPorNome(@PathVariable("nome") String nome) throws PessoaNaoEncontradaException {

        Response<PessoaDTO> response = new Response<>();

        Pessoa pessoa = pessoaService.buscarPessoaPorNome(nome);

        if(pessoa == null) {
            throw new PessoaNaoEncontradaException("Não existe nenhum hospede com o nome: " + nome);
        }

        response.setData(pessoa.conversorEntityEmDTO());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/buscar_por_documento/{documento}")
    @ApiOperation(value = "Rota para procurar um hospede por documento na API")
    public ResponseEntity<Response<PessoaDTO>> buscarPessoaPorDocumento(@PathVariable("documento") String documento) throws PessoaNaoEncontradaException {

        Response<PessoaDTO> response = new Response<>();

        Pessoa pessoa = pessoaService.buscarPessoaPorDocumento(documento);

        if(pessoa == null) {
            throw new PessoaNaoEncontradaException("Não existe nenhum hospede com o documento: " + documento);
        }

        response.setData(pessoa.conversorEntityEmDTO());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/buscar_por_telefone/{telefone}")
    @ApiOperation(value = "Rota para procurar um hospede por telefone na API")
    public ResponseEntity<Response<PessoaDTO>> buscarPessoaPorTelefone(@PathVariable("telefone") String telefone) throws PessoaNaoEncontradaException {

        Response<PessoaDTO> response = new Response<>();

        //Valida o telefone inserido
        if(telefone.length() < 11){
            return ResponseEntity.badRequest().body(response);
        }

        Pessoa pessoa = pessoaService.buscarPessoaPorTelefone(telefone);

        if(pessoa == null) {
            throw new PessoaNaoEncontradaException("Não existe nenhum hospede com o telefone: " + telefone);
        }

        response.setData(pessoa.conversorEntityEmDTO());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
