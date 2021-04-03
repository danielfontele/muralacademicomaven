package model;

public class Telefone {

    private long id;
    private String codigoArea;
    private String DDD;
    private String numero;
    private TelefoneTipo tipo;

    public Telefone() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    public String getDDD() {
        return DDD;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TelefoneTipo getTipo() {
        return tipo;
    }

    public void setTipo(TelefoneTipo tipo) {
        this.tipo = tipo;
    }
}
