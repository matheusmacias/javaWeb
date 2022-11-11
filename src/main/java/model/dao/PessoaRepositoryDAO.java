package model.dao;

import connection.ConnectionFactory;
import model.bean.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaRepositoryDAO implements FuncPessoa {
    @Override
    public boolean createAccout(Pessoa pessoa) {
        boolean checkEmail;
        checkEmail = ConnectionFactory.ckSelect("email", "pessoa", "email='" + pessoa.getEmail() + "'");

        if (!checkEmail) {
            try {
                PreparedStatement stmtr = ConnectionFactory.pInsert("pessoa", "nome,email,senha,numeroCelular,numeroTelefone,cep,Rua,complemento,numeroEnd","?,?,?,?,?,?,?,?,?");
                stmtr.setString(1,pessoa.getNome());
                stmtr.setString(2,pessoa.getEmail());
                stmtr.setString(3,pessoa.getSenha());
                stmtr.setString(4,pessoa.getNumeroCelular());
                stmtr.setString(5,pessoa.getNumeroTelefone());
                stmtr.setString(6,pessoa.getEndereco().getCep());
                stmtr.setString(7,pessoa.getEndereco().getRua());
                stmtr.setString(8,pessoa.getEndereco().getComplemento());
                stmtr.setString(9,pessoa.getEndereco().getNumero());
                stmtr.executeUpdate();

                PreparedStatement stmt = ConnectionFactory.pSelect("id","pessoa","email='"+pessoa.getEmail()+"'");
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    pessoa.setId(rs.getInt("id"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }

    @Override
    public void updateAccout(Pfisica pessoa) {
        ConnectionFactory.insert("fisica", "cpf,fk_Pessoa_id", "'" + pessoa.getCpf() + "','" + pessoa.getId() + "'");
    }

    @Override
    public void updateAccout(Pjuridica pessoa) {
        ConnectionFactory.insert("juridica", "cnpj,fk_Pessoa_id", "'" + pessoa.getCnpj() + "','" + pessoa.getId() + "'");
    }

    @Override
    public boolean checkCPF(Pfisica pessoa) {
        return ConnectionFactory.ckSelect("cpf", "fisica", "cpf = '" + pessoa.getCpf() + "'");
    }

    @Override
    public boolean checkCNPJ(Pjuridica pessoa) {
        return ConnectionFactory.ckSelect("cnpj", "juridica", "cnpj = '" + pessoa.getCnpj() + "'");
    }

    @Override
    public void updateAccout() {

    }

    @Override
    public void deleteAccout() {

    }

    @Override
    public boolean signInAccout(Pessoa pessoa) {
        return ConnectionFactory.ckSelect("email,senha", "pessoa", " email = '" + pessoa.getEmail() + "' AND " + "senha='" + pessoa.getSenha() + "'");
    }

    @Override
    public void signOutAccout() {

    }
}
