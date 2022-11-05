package model.dao;

import connection.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fisica extends Pessoa {
    private String cpf;
    private char genero;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
    @Override
    public void CreateAccout() {
        boolean check = true;
        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT email from pessoa WHERE email = ?");
            stmt.setString(1,getEmail());
            rs = stmt.executeQuery();

            if(rs.next()){
                check = false;
            }

            stmt = con.prepareStatement("SELECT cpf from fisica WHERE cpf = ?");
            stmt.setString(1,getCpf());
            rs = stmt.executeQuery();

            if(rs.next()){
                check = false;
            }

            if(check == true){
                stmt = con.prepareStatement("INSERT INTO usuario(nome,email,senha,numeroCelular,numeroTelefone,cep,Rua,complemento,numeroEnd)" +
                                            "VALUES(?,?,?,?,?,?,?,?,?)");
                stmt.setString(1,getNome());
                stmt.setString(2,getEmail());
                stmt.setString(3,getSenha());
                stmt.setString(4,getNumeroCelular());
                stmt.setString(5,getNumeroTelefone());
                stmt.setString(6,getEndereco().getCep());
                stmt.setString(7,getEndereco().getRua());
                stmt.setString(8,getEndereco().getComplemento());
                stmt.setString(9,getEndereco().getNumero());
                stmt.executeUpdate();

            }else{
                System.out.println("E-mail ou cpf já está cadastrado no sistema! tente outro");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(con,stmt,rs);
        }
    }
}
