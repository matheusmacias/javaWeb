package model.bean;


import model.servlets.PessoaLogin;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Validacao{
    PessoaLogin login;

    private final static ArrayList<String>  msg = new ArrayList<String>();

    public static boolean Check(HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        for (String s : msg) {
            writer.println(s);
            msg.clear();
            return false;
        }
        return true;
    }
    public static void minLength(String input,int min, String mensagem){
        if(input.length() < min){
            msg.add(Constantes.DIV_DANGER_BEGIN+mensagem+Constantes.DIV_END);
        }
    }
    public static void maxLength(String input,int max, String mensagem){
        if(input.length() > max){
            msg.add(Constantes.DIV_DANGER_BEGIN+mensagem+Constantes.DIV_END);
        }
    }
    public static void equalsLength(String input,int equals, String mensagem){
        if(input.length() != equals){
            msg.add(Constantes.DIV_DANGER_BEGIN+mensagem+Constantes.DIV_END);
        }
    }


}








