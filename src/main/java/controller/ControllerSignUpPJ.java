package controller;

import model.bean.Endereco;
import model.bean.Pfisica;
import model.dao.PessoaServiceDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cadastroPF")
public class ControllerSignUpPJ extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Endereco enderecoPessoa = new Endereco();
        Pfisica pessoaf = new Pfisica();
        try {
            /*info pessoa*/
            pessoaf.setNome(req.getParameter("nomecompleto"));
            pessoaf.setEmail(req.getParameter("email"));
            pessoaf.setSenha(req.getParameter("senha"));
            pessoaf.setNumeroCelular(req.getParameter("celular"));
            pessoaf.setNumeroTelefone(req.getParameter("telefone"));
            pessoaf.setCpf(req.getParameter("cpf"));
            /* endereço da pessoa */
            enderecoPessoa.setCep(req.getParameter("cep"));
            enderecoPessoa.setRua(req.getParameter("nomerua"));
            enderecoPessoa.setComplemento(req.getParameter("complemento"));
            enderecoPessoa.setNumero(req.getParameter("numeroend"));
            /* SETAR O ENDEREÇO NA PESSOA */
            pessoaf.setEndereco(enderecoPessoa);

            PessoaServiceDAO pessoaService = new PessoaServiceDAO();
            writer.println(pessoaService.createAccout(pessoaf));

        } catch (Exception e) {
            writer.println(e.getMessage());
        }


    }
}
