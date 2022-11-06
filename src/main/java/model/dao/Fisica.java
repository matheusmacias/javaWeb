package model.dao;

import connection.ConnectionFactory;
import model.bean.Constantes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
    public void createAccout(HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
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
            stmt = con.prepareStatement("SELECT cpf from fisica WHERE cpf = ?");
            stmt.setString(1,getCpf());
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
                stmt = con.prepareStatement("INSERT INTO fisica(cpf,fk_Pessoa_id)VALUES(?,?)");
                stmt.setString(1,getCpf());
                stmt.setInt(2,getId());
                stmt.executeUpdate();
                writer.println(Constantes.CONTA_PF_CRIADA);
            }else{
                writer.println(Constantes.CADASTRO_PF_FAIL_CPF_EMAIL);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
    }

}
