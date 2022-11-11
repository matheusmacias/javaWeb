package connection;

import java.sql.*;

public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/empresa01";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco: " + e);
        }
    }
    public static void closeConnection(Connection con){
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);
        try {
            if(stmt != null){
                stmt.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        try {
            if(rs != null){
                stmt.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static boolean insert(String tabela,String colunas, String valores){
        Connection con = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO "+tabela+"("+colunas+")VALUES("+valores+")");
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeConnection(con,stmt);
        }
        return true;
    }
    public static PreparedStatement pInsert(String tabela,String colunas, String valores){
        Connection con = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO "+tabela+"("+colunas+")VALUES("+valores+")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stmt;
    }

    public static boolean ckSelect(String colunas, String tabela, String where){
        Connection con = getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT "+colunas+" FROM "+tabela+" WHERE "+where);
            rs = stmt.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeConnection(con,stmt,rs);
        }
        return false;
    }

    public static PreparedStatement pSelect(String colunas, String tabela, String where){
        Connection con = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT "+colunas+" FROM "+tabela+" WHERE "+where);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stmt;
    }

}











