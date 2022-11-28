package model.bean;

public class Pfisica extends Pessoa{

    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        Validacao.noEqualsLength(cpf, 11,"Cpf e invalido, verifique-o.");
        this.cpf = cpf;
    }
}
