package br.com.prototipo.exception;

public class ErrorDetail {

    public final String url;
    public final String ex;
    public final int codigo;
    public final String mensagemDesenv;
    public String link = "www.controlefinanceiro.com.br/erros/";

    public final String getLink() {
        return link;
    }

    public final void setLink(String link) {
        this.link = link;
    }

    public ErrorDetail(String url, Exception ex, int codigo, String mensagemDesenv) {
        this.url = url;
        this.ex = ex.getLocalizedMessage();
        this.codigo = codigo;
        this.mensagemDesenv=mensagemDesenv;
        this.setLink(this.link+String.valueOf(codigo));
    }
}
