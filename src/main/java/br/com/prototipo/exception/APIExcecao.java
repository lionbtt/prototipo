/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prototipo.exception;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.prototipo.log.LogAPI;

/**
 *
 * @author Leonardo
 */
public abstract class APIExcecao extends RuntimeException{
    
    /**
	 * 
	 */
	private final long serialVersionUID = 1L;

	public APIExcecao(){
        super();
        try {
            LogAPI objLog = new LogAPI(montaLog(this));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(APIExcecao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public APIExcecao(Exception e)
    {
        super(e);
        try {
            LogAPI objLog = new LogAPI(montaLog(e));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(APIExcecao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public APIExcecao(String msg)
    {
        super(msg);
        try {
            LogAPI objLog = new LogAPI(montaLog(this));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(APIExcecao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String montaLog(Exception e){
        String linhaErro = "";
        Date objData = new Date();
        linhaErro += "\n----------\n" + "Erro | " + objData.toString() + "\n----------\n";
        //linhaErro += "Erro: " + this.mensagemUsuario+" "+this.hashCode()+"\n";
        if (e!=null)
        {
            StringWriter objSw = new StringWriter();
            PrintWriter objPw = new PrintWriter(objSw);
            
            e.printStackTrace(objPw);
            
            linhaErro += "\n\tExceção que originou: " + e.getMessage() + "\n";
            linhaErro += "\tPilha de execução: " + objSw.toString() + "\n";
            linhaErro += "\tHashCode: " + String.valueOf(e.hashCode()) + "\n\n";
        }
        linhaErro += "----------\n";

        return linhaErro;
    }
    
    public abstract ErrorDetail errorDetail(String url, Exception e);
}
