package model.dao;

import connection.ConnectionFactory;
import model.bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaRepositoryDAO implements FuncPessoa {
    private Connection con = ConnectionFactory.getConnection();
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public Connection getCon() {
        return con;
    }

    public PreparedStatement getStmt() {
        return stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    @Override
    public String createAccout(Pessoa pessoa) {
        try {
            stmt = con.prepareStatement("SELECT email from pessoa WHERE email = ?");
            stmt.setString(1,pessoa.getEmail());
            rs = stmt.executeQuery();

            if(!rs.next()){
                stmt = con.prepareStatement("INSERT INTO pessoa(nome,email,senha,numeroCelular,numeroTelefone,cep,Rua,complemento,numeroEnd)" +
                        "VALUES(?,?,?,?,?,?,?,?,?)");
                stmt.setString(1,pessoa.getNome());
                stmt.setString(2,pessoa.getEmail());
                stmt.setString(3,pessoa.getSenha());
                stmt.setString(4,pessoa.getNumeroCelular());
                stmt.setString(5,pessoa.getNumeroTelefone());
                stmt.setString(6,pessoa.getEndereco().getCep());
                stmt.setString(7,pessoa.getEndereco().getRua());
                stmt.setString(8,pessoa.getEndereco().getComplemento());
                stmt.setString(9,pessoa.getEndereco().getNumero());
                stmt.executeUpdate();
                stmt = con.prepareStatement("SELECT id from pessoa WHERE email = ?");
                stmt.setString(1,pessoa.getEmail());
                rs = stmt.executeQuery();
                if(rs.next()){
                    pessoa.setId(rs.getInt("id"));
                }
                return null;
            }else{
                return Constantes.CADASTRO_PF_FAIL_EMAIL;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String updateAccout(Pfisica pessoa) {
        try {
            stmt = con.prepareStatement("INSERT INTO fisica(cpf,fk_Pessoa_id)VALUES(?,?)");
            stmt.setString(1,pessoa.getCpf());
            stmt.setInt(2,pessoa.getId());
            stmt.executeUpdate();
            return Constantes.CONTA_PF_CRIADA;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String updateAccout(Pjuridica pessoa) {
        try {
            stmt = con.prepareStatement("INSERT INTO juridica(cnpj,fk_Pessoa_id)VALUES(?,?)");
            stmt.setString(1,pessoa.getCnpj());
            stmt.setInt(2,pessoa.getId());
            stmt.executeUpdate();
            return Constantes.CONTA_PJ_CRIADA;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean checkCPF(Pfisica pessoa) {
        try {
            stmt = con.prepareStatement("SELECT cpf from fisica WHERE cpf = ?");
            stmt.setString(1,pessoa.getCpf());
            rs = stmt.executeQuery();

            if(rs.next()){
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    @Override
    public boolean checkCNPJ(Pjuridica pessoa) {
        try {
            stmt = con.prepareStatement("SELECT cnpj from juridica WHERE cnpj = ?");
            stmt.setString(1,pessoa.getCnpj());
            rs = stmt.executeQuery();

            if(rs.next()){
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    @Override
    public void updateAccout() {

    }

    @Override
    public void deleteAccout() {

    }

    @Override
    public boolean signInAccout(Pessoa pessoa) {
        try {
            stmt = con.prepareStatement("SELECT email,senha FROM pessoa WHERE email=? AND senha=?");
            stmt.setString(1,pessoa.getEmail());
            stmt.setString(2,pessoa.getSenha());
            rs = stmt.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public void signOutAccout() {

    }
}
