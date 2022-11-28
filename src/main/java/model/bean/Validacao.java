package model.bean;

public class Validacao {

    public static void minLength(String input,int min, String mensagem){
        if(input.length() < min){
            throw new IllegalArgumentException(Constantes.DIV_DANGER_BEGIN+mensagem+Constantes.DIV_END);
        }
    }
    public static void maxLength(String input,int max, String mensagem){
        if(input.length() > max){
            throw new IllegalArgumentException(Constantes.DIV_DANGER_BEGIN+mensagem+Constantes.DIV_END);
        }
    }
    public static void noEqualsLength(String input, int equals, String mensagem){
        if(input.length() != equals){
            throw new IllegalArgumentException(Constantes.DIV_DANGER_BEGIN+mensagem+Constantes.DIV_END);
        }
    }

}
