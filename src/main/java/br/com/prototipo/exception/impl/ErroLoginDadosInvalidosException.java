package br.com.prototipo.exception.impl;

import br.com.prototipo.exception.APIExcecao;
import br.com.prototipo.exception.ErrorDetail;

public class ErroLoginDadosInvalidosException extends APIExcecao{

	private final long serialVersionUID = 1L;
    private final int CODIGO_ERRO = 1001;
    private final String MENSAGEM_DESENVOLVEDOR = "Não foi fazer o login. Os dados do usuário não estão corretos na base. Verifique o código enviado!";

	public ErroLoginDadosInvalidosException() {
		super();
	}
	
	public ErroLoginDadosInvalidosException(Exception e) {
		super(e);
	}
	
	public ErroLoginDadosInvalidosException(String msg) {
		super(msg);
	}

	@Override
	public ErrorDetail errorDetail(String url, Exception e) {
       return new ErrorDetail(url, e, CODIGO_ERRO, MENSAGEM_DESENVOLVEDOR); 
	}
}
