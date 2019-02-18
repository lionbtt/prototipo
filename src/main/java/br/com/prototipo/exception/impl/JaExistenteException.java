package br.com.prototipo.exception.impl;

import br.com.prototipo.exception.APIExcecao;
import br.com.prototipo.exception.ErrorDetail;

public class JaExistenteException extends APIExcecao {
	
	private static final long serialVersionUID = 1L;
    private static final int CODIGO_ERRO = 1001;
    private static final String MENSAGEM_DESENVOLVEDOR = "Foi encontrado uma ou mais entidades com a chave de busca enviada. Entidade não pode ser inserida!";
    
    public JaExistenteException() 
    {
        super();
    }
    
    public JaExistenteException(Exception e) {
        super(e);
    }
    
    public JaExistenteException(String ex) {
        super(ex);
    }
    
    public ErrorDetail errorDetail(String url, Exception e){
       return new ErrorDetail(url, e, CODIGO_ERRO, MENSAGEM_DESENVOLVEDOR); 
    }

}
