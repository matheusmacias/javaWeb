package model.dao;

import model.bean.Endereco;
import model.bean.FuncPessoa;

public class Pessoa implements FuncPessoa {
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

    protected void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public void createAccout() {

    }

    @Override
    public void updateAccout() {

    }

    @Override
    public void deleteAccout() {

    }

    @Override
    public void signInAccout() {

    }

    @Override
    public void signOutAccout() {

    }
}
