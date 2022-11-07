package model.servlets;

import model.bean.Validacao;
import model.dao.Pessoa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class PessoaLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail(req.getParameter("email"));
        pessoa.setSenha(req.getParameter("senha"));
        /* VALIDAÇÃO DOS INPUT */
        Validacao.minLength(pessoa.getEmail(), 10,"E-mail digitado e invalido!");
        Validacao.minLength(pessoa.getSenha(), 2,"Senha digitada e invalida!");

        if(Validacao.Check(resp)){
            pessoa.signInAccout(resp);
        }

    }
}
