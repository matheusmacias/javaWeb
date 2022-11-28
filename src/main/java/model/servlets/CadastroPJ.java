package model.servlets;

import model.bean.Endereco;
import model.bean.Pjuridica;
import model.dao.PessoaServiceDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cadastroPJ")
public class CadastroPJ extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Endereco enderecoPessoa = new Endereco();
        Pjuridica pessoaj = new Pjuridica();
        try{
            /*info pessoa*/
            pessoaj.setNome(req.getParameter("nomeempresa"));
            pessoaj.setEmail(req.getParameter("email"));
            pessoaj.setSenha(req.getParameter("senha"));
            pessoaj.setNumeroCelular(req.getParameter("celular"));
            pessoaj.setNumeroTelefone(req.getParameter("telefone"));
            pessoaj.setCnpj(req.getParameter("cnpj"));
            /* endereço da pessoa */
            enderecoPessoa.setCep(req.getParameter("cep"));
            enderecoPessoa.setRua(req.getParameter("nomerua"));
            enderecoPessoa.setComplemento(req.getParameter("complemento"));
            enderecoPessoa.setNumero(req.getParameter("numeroend"));
            /* SETAR O ENDEREÇO NA PESSOA */
            pessoaj.setEndereco(enderecoPessoa);
            /* VALIDAÇÃO DOS INPUT */
            PessoaServiceDAO pessoaService = new PessoaServiceDAO();
            writer.println(pessoaService.createAccout(pessoaj));
        }catch (Exception e){
            writer.println(e.getMessage());
        }

    }
}
