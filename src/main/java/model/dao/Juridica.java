package model.dao;

import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Juridica extends Pessoa {
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void createAccout() {
        boolean check = true;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT email from pessoa WHERE email = ?");
            stmt.setString(1,getEmail());
            rs = stmt.executeQuery();

            if(rs.next()){
                check = false;
            }
            stmt = con.prepareStatement("SELECT cnpj from juridica WHERE cnpj = ?");
            stmt.setString(1,getCnpj());
            rs = stmt.executeQuery();

            if(rs.next()){
                check = false;
            }

            if(check == true){
                stmt = con.prepareStatement("INSERT INTO pessoa(nome,email,senha,numeroCelular,numeroTelefone,cep,Rua,complemento,numeroEnd)" +
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

                stmt = con.prepareStatement("SELECT id from pessoa WHERE email = ?");
                stmt.setString(1,getEmail());
                rs = stmt.executeQuery();
                if(rs.next()){
                    setId(rs.getInt("id"));
                }
                stmt = con.prepareStatement("INSERT INTO juridica(cnpj,fk_Pessoa_id)VALUES(?,?)");
                stmt.setString(1,getCnpj());
                stmt.setInt(2,getId());
                stmt.executeUpdate();

            }else{
                System.out.println("E-mail ou cnpj já está cadastrado no sistema! tente outro");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
    }



}
