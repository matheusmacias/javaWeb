package model.servlets;

import model.bean.Endereco;
import model.bean.Pfisica;
import model.bean.Pjuridica;
import model.bean.Validacao;
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
        Validacao.minLength(pessoaj.getNome(), 10,"O nome digitado e muito curto, digite mais.");
        Validacao.maxLength(pessoaj.getNome(), 100,"No campo nome e permitido ate 100 caracteres");
        Validacao.minLength(pessoaj.getEmail(), 15,"E-mail invalido");
        Validacao.minLength(pessoaj.getSenha(), 10,"Sua senha esta fraca, digite mais");
        Validacao.maxLength(pessoaj.getSenha(), 32,"No campo senha e permitido ate 32 caracteres");
        Validacao.minLength(pessoaj.getNumeroCelular(), 9,"Numero de celular invalido");
        Validacao.maxLength(pessoaj.getNumeroCelular(), 13,"Numero de celular invalido");
        Validacao.minLength(pessoaj.getNumeroTelefone(), 9,"Numero de telefone invalido");
        Validacao.maxLength(pessoaj.getNumeroTelefone(), 13,"Numero de telefone invalido");
        Validacao.noEqualsLength(pessoaj.getCnpj(), 14,"Cnpj e invalido, verifique-o.");
        Validacao.minLength(enderecoPessoa.getRua(), 4,"O nome da rua e muito curto, digite mais.");
        Validacao.maxLength(enderecoPessoa.getRua(), 100,"No campo Rua e permitido ate 100 caracteres");
        Validacao.maxLength(enderecoPessoa.getNumero(), 7,"No campo numero e permitido ate 8 caracteres");
        Validacao.minLength(enderecoPessoa.getComplemento(), 4,"O complemento e muito curto, digite mais.");
        Validacao.maxLength(enderecoPessoa.getComplemento(), 100,"No complemento e permitido ate 100 caracteres");
        Validacao.noEqualsLength(enderecoPessoa.getCep(), 8,"Cep e invalido, verifique-o.");

        if(Validacao.Check(resp)) {
            PessoaServiceDAO pessoaService = new PessoaServiceDAO();
            writer.println(pessoaService.createAccout(pessoaj));
        }
    }
}
