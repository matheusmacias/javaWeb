package model.bean;

public class Endereco {
    private String cep;
    private String rua;
    private String complemento;
    private String numero;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        Validacao.noEqualsLength(cep, 8,"Cep e invalido, verifique-o.");

        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        Validacao.minLength(rua, 4,"O nome da rua e muito curto, digite mais.");
        Validacao.maxLength(rua, 100,"No campo Rua e permitido ate 100 caracteres");
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        Validacao.minLength(complemento, 4,"O complemento e muito curto, digite mais.");
        Validacao.maxLength(complemento, 100,"No complemento e permitido ate 100 caracteres");
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        Validacao.maxLength(numero, 7,"No campo numero e permitido ate 8 caracteres");
        this.numero = numero;
    }
}
