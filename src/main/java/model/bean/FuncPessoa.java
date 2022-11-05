package model.bean;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface FuncPessoa {

    void createAccout(HttpServletResponse resp) throws IOException;
    void updateAccout();
    void deleteAccout();
    void signInAccout(HttpServletResponse resp) throws IOException;
    void signOutAccout();

}
