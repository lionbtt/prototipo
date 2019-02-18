/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prototipo.exception.impl;

import br.com.prototipo.exception.APIExcecao;
import br.com.prototipo.exception.ErrorDetail;

/**
 *
 * @author Leonardo
 */
public class NaoEncontradoException extends APIExcecao {

    private static final long serialVersionUID = 1L;
    private static final int CODIGO_ERRO = 1000;
    private static final String MENSAGEM_DESENVOLVEDOR = "Não foi encontrado nenhuma entidade para a chamada. Verifique o código enviado!";

    public NaoEncontradoException() 
    {
        super();
    }
    
    public NaoEncontradoException(Exception e) {
        super(e);
    }
    
    public NaoEncontradoException(String ex) {
        super(ex);
    }
    
    public ErrorDetail errorDetail(String url, Exception e){
       return new ErrorDetail(url, e, CODIGO_ERRO, MENSAGEM_DESENVOLVEDOR); 
    }
}
