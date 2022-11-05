package br.com.macias;


import model.bean.Endereco;
import model.dao.Fisica;
import model.dao.Juridica;
import model.dao.Pessoa;

import javax.servlet.http.HttpServletResponse;

public class Test {
    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa();
        pessoa.setEmail("matheusmacias3@gmail.com");
        pessoa.setSenha("matheus123");


        //Endereco enderecoPessoa = new Endereco();
        //Juridica pessoaf = new Juridica();
        /*info pessoa*/
        //pessoaf.setNome("Empresa Macias");
        //pessoaf.setEmail("matheusmacias0@gmail.com");
        //pessoaf.setSenha("matheus123");
        //pessoaf.setNumeroCelular("9994443333");
        //pessoaf.setNumeroTelefone("998444223");
        //pessoaf.setCnpj("5553334442212");
        /* endereço da pessoa */
        //enderecoPessoa.setCep("88888888");
        //enderecoPessoa.setRua("albuquerque");
        //enderecoPessoa.setComplemento("proximo ao deserto do breaking bad");
        //enderecoPessoa.setNumero("220B");
        /* SETAR O ENDEREÇO NA PESSOA */
        //pessoaf.setEndereco(enderecoPessoa);
        /* CRIAR CONTA */
        //pessoaf.createAccout();
    }
}
