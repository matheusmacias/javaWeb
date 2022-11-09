package model.bean;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Validacao{
    
    private final static ArrayList<String>  msg = new ArrayList<String>();
    private static boolean status = true;

    public static boolean Check(HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        for (String s : msg) {
            writer.println(s);
            msg.clear();
            status = true;
            return false;
        }
        return true;
    }
    public static void minLength(String input,int min, String mensagem){
        if(input.length() < min){
            if(status){
                msg.add(Constantes.DIV_DANGER_BEGIN+mensagem+Constantes.DIV_END);
                status = false;
            }
        }
    }
    public static void maxLength(String input,int max, String mensagem){
        if(input.length() > max){
            if(status){
                msg.add(Constantes.DIV_DANGER_BEGIN+mensagem+Constantes.DIV_END);
                status = false;
            }
        }
    }
    public static void noEqualsLength(String input, int equals, String mensagem){
        if(input.length() != equals){
            if(status){
                msg.add(Constantes.DIV_DANGER_BEGIN+mensagem+Constantes.DIV_END);
                status = false;
            }
        }
    }


}








