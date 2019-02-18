/*
 * Grava log no arquivo
 */

package br.com.prototipo.log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *
 * @author Leonardo
 */
public class LogAPI{
    private String mensagem;
    private FileOutputStream arquivoLog;
    PrintStream gravar;

    public LogAPI(){}
    
    /**
     * Cria a classe e já faz a gravação da mensagem no arquivo.
     * @param mensagem A mensagem que será gravada no arquivo de log, para consulta posteriores.
     * @throws Excecao
     */
    public LogAPI(String mensagem) throws FileNotFoundException{
        try {
            arquivoLog = new FileOutputStream("",true);
            gravar = new PrintStream(arquivoLog);
            gravar.println(mensagem);
            gravar.close();
                
        } catch (FileNotFoundException ie){
            throw ie;
        }
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public FileOutputStream getArquivoLog() {
        return arquivoLog;
    }

    public void setArquivoLog(FileOutputStream arquivoLog) {
        this.arquivoLog = arquivoLog;
    }
    
    /*Métodos*/
    /**
     * Método faz a iniciliação do arquivo de log.
     * @param caminho Caminho do arquivo.
     * @return Arquivo que foi aberto
     */
    public File inicializaArquivo(String caminho){
        File arquivo;
        try {
            arquivo =  new File(caminho);
        } catch (NullPointerException ne) {
            throw ne;
        } catch (Exception e){
            throw e;
        }
        return arquivo;
    }
    
}
