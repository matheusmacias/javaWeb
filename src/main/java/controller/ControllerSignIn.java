package controller;

import model.bean.Pessoa;
import model.dao.PessoaServiceDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class ControllerSignIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Pessoa pessoa = new Pessoa();
        try{
            pessoa.setEmail(req.getParameter("email"));
            pessoa.setSenha(req.getParameter("senha"));
            PessoaServiceDAO pessoaService = new PessoaServiceDAO();
            writer.println(pessoaService.signInAccount(pessoa));
        }catch (Exception e){
            writer.println(e.getMessage());
        }
    }
}
