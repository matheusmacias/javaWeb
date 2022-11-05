package br.com.macias;

import model.dao.Fisica;

public class Test {
    public static void main(String[] args) {
        Fisica pessoa = new Fisica();
        pessoa.setEmail("matheusw");
        pessoa.setCpf("666");
        pessoa.CreateAccout();
    }
}
