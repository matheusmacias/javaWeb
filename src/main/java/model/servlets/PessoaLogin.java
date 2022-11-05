package model.servlets;

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
        pessoa.signInAccout(resp);
    }
}
