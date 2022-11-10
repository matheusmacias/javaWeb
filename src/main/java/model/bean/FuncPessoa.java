package model.bean;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface FuncPessoa {

    boolean createAccout(Pessoa pessoa);
    void updateAccout(Pfisica pessoa);
    void updateAccout(Pjuridica pessoa);
    boolean checkCPF(Pfisica pessoa);
    boolean checkCNPJ(Pjuridica pessoa);
    void updateAccout();
    void deleteAccout();
    boolean signInAccout(Pessoa pessoa);
    void signOutAccout();

}
