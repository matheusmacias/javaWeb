package model.servlets;

import model.bean.Endereco;
import model.bean.Validacao;
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
        /* VALIDAÇÃO DOS INPUT */
        Validacao.minLength(pessoaf.getNome(), 3,"O nome da empresa e muito curto, digite mais.");
        Validacao.maxLength(pessoaf.getNome(), 100,"No campo nome e permitido ate 100 caracteres");
        Validacao.minLength(pessoaf.getEmail(), 15,"E-mail invalido");
        Validacao.minLength(pessoaf.getSenha(), 10,"Sua senha esta fraca, digite mais");
        Validacao.maxLength(pessoaf.getSenha(), 32,"No campo senha e permitido ate 32 caracteres");
        Validacao.minLength(pessoaf.getNumeroCelular(), 9,"Numero de celular invalido");
        Validacao.maxLength(pessoaf.getNumeroCelular(), 13,"Numero de celular invalido");
        Validacao.minLength(pessoaf.getNumeroTelefone(), 9,"Numero de telefone invalido");
        Validacao.maxLength(pessoaf.getNumeroTelefone(), 13,"Numero de telefone invalido");
        Validacao.noEqualsLength(pessoaf.getCnpj(), 14,"Cnpj e invalido, verifique-o.");
        Validacao.minLength(enderecoPessoa.getRua(), 4,"O nome da rua e muito curto, digite mais.");
        Validacao.maxLength(enderecoPessoa.getRua(), 100,"No campo Rua e permitido ate 100 caracteres");
        Validacao.maxLength(enderecoPessoa.getNumero(), 7,"No campo numero e permitido ate 8 caracteres");
        Validacao.minLength(enderecoPessoa.getComplemento(), 4,"O complemento e muito curto, digite mais.");
        Validacao.maxLength(enderecoPessoa.getComplemento(), 100,"No complemento e permitido ate 100 caracteres");
        Validacao.noEqualsLength(enderecoPessoa.getCep(), 8,"Cep e invalido, verifique-o.");
        /* CRIAR CONTA */
        if(Validacao.Check(resp)) {
            pessoaf.createAccout(resp);
        }
    }
}
