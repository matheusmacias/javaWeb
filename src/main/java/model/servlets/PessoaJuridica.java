package model.servlets;

import model.bean.Endereco;
import model.dao.Juridica;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cadastroPJ")
public class PessoaJuridica extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Endereco enderecoPessoa = new Endereco();
        Juridica pessoaf = new Juridica();
        /*info pessoa*/
        pessoaf.setNome(req.getParameter("nomeempresa"));
        pessoaf.setEmail(req.getParameter("email"));
        pessoaf.setSenha(req.getParameter("senha"));
        pessoaf.setNumeroCelular(req.getParameter("celular"));
        pessoaf.setNumeroTelefone(req.getParameter("telefone"));
        pessoaf.setCnpj(req.getParameter("cnpj"));
        /* endereço da pessoa */
        enderecoPessoa.setCep(req.getParameter("cep"));
        enderecoPessoa.setRua(req.getParameter("nomerua"));
        enderecoPessoa.setComplemento(req.getParameter("complemento"));
        enderecoPessoa.setNumero(req.getParameter("numeroend"));
        /* SETAR O ENDEREÇO NA PESSOA */
        pessoaf.setEndereco(enderecoPessoa);
        /* CRIAR CONTA */
        pessoaf.createAccout(resp);
    }
}
