package br.com.macias;


import model.bean.Endereco;
import model.dao.Fisica;

public class Test {
    public static void main(String[] args) {
        Endereco enderecoPessoa = new Endereco();
        Fisica pessoaf = new Fisica();
        /*info pessoa*/
        pessoaf.setNome("Matheus Macias");
        pessoaf.setEmail("matheusmacias3@gmail.com");
        pessoaf.setSenha("matheus123");
        pessoaf.setNumeroCelular("9994443333");
        pessoaf.setNumeroTelefone("998444223");
        pessoaf.setCpf("55533344422");
        /* endereço da pessoa */
        enderecoPessoa.setCep("88888888");
        enderecoPessoa.setRua("albuquerque");
        enderecoPessoa.setComplemento("proximo ao deserto do breaking bad");
        enderecoPessoa.setNumero("220B");
        /* SETAR O ENDEREÇO NA PESSOA */
        pessoaf.setEndereco(enderecoPessoa);
        /* CRIAR CONTA */
        pessoaf.createAccout();
    }
}
