/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prototipo.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.prototipo.exception.impl.ErroLoginDadosInvalidosException;
import br.com.prototipo.exception.impl.JaExistenteException;
import br.com.prototipo.exception.impl.NaoEncontradoException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Leonardo
 */
@RestControllerAdvice
public class WebRestControllerAdvice {

//    @ExceptionHandler(KeywordNotFoundException.class)
//	public ErrorDetail myError(HttpServletRequest request, Exception exception) {
//	    ErrorDetail error = new ErrorDetail();
//	    error.setStatus(HttpStatus.BAD_REQUEST.value());
//	    error.setMessage(exception.getLocalizedMessage());
//	    error.setUrl(request.getRequestURL().append("/error/111").toString());
//	    return error;
//	}
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NaoEncontradoException.class)
    @ResponseBody ErrorDetail
    handleBadRequest(HttpServletRequest req, NaoEncontradoException ex) {
        return new NaoEncontradoException().errorDetail(req.getRequestURL().toString(), ex);
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ErroLoginDadosInvalidosException.class)
    @ResponseBody ErrorDetail
    handleBadRequest(HttpServletRequest req, ErroLoginDadosInvalidosException ex) {
        return new ErroLoginDadosInvalidosException().errorDetail(req.getRequestURL().toString(), ex);
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(JaExistenteException.class)
    @ResponseBody ErrorDetail
    handleBadRequest(HttpServletRequest req, JaExistenteException ex) {
    	return new JaExistenteException().errorDetail(req.getRequestURL().toString(), ex);
    }
}
