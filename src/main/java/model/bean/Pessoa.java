package model.bean;

public class Pessoa {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String numeroCelular;
    private String numeroTelefone;
    private Endereco endereco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Validacao.minLength(nome, 10,"O nome digitado e muito curto, digite mais.");
        Validacao.maxLength(nome, 100,"No campo nome e permitido ate 100 caracteres");
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Validacao.minLength(email, 15,"E-mail invalido");
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        Validacao.minLength(senha, 10,"Sua senha esta fraca, digite mais");
        Validacao.maxLength(senha, 32,"No campo senha e permitido ate 32 caracteres");

        this.senha = senha;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        Validacao.minLength(numeroCelular, 9,"Numero de celular invalido");
        Validacao.maxLength(numeroCelular, 13,"Numero de celular invalido");
        this.numeroCelular = numeroCelular;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        Validacao.minLength(numeroTelefone, 9,"Numero de telefone invalido");
        Validacao.maxLength(numeroTelefone, 13,"Numero de telefone invalido");
        this.numeroTelefone = numeroTelefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
