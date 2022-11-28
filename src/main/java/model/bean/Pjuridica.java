package model.bean;

public class Pjuridica extends Pessoa{
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        Validacao.noEqualsLength(cnpj, 14,"Cnpj e invalido, verifique-o.");
        this.cnpj = cnpj;
    }
}
