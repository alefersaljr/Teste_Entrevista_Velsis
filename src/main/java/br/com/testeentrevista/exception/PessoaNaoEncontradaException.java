package br.com.testeentrevista.exception;

public class PessoaNaoEncontradaException extends Exception{

    private static final long serialVersionUID = -7139304880555402679L;

    public PessoaNaoEncontradaException() { super(); }

    public PessoaNaoEncontradaException(String msg){
        super(msg);
    }

    public PessoaNaoEncontradaException(String msg, Throwable cause) { super(msg, cause); }
}
