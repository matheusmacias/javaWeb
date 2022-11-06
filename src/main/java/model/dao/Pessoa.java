package model.dao;

import connection.ConnectionFactory;
import model.bean.Constantes;
import model.bean.Endereco;
import model.bean.FuncPessoa;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public void createAccout(HttpServletResponse resp) throws IOException {

    }

    @Override
    public void updateAccout() {

    }

    @Override
    public void deleteAccout() {

    }

    @Override
    public void signInAccout(HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT email,senha FROM pessoa WHERE email=? AND senha=?");
            stmt.setString(1,getEmail());
            stmt.setString(2,getSenha());
            rs = stmt.executeQuery();
            if(rs.next()){
                writer.println(Constantes.LOGIN_SUCESSO);
            }else{
                writer.println(Constantes.LOGIN_ERRADO);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionFactory.closeConnection(con,stmt,rs);
        }

    }

    @Override
    public void signOutAccout() {

    }
}
