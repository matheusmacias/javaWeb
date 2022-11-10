package model.dao;


import connection.ConnectionFactory;
import model.bean.Constantes;
import model.bean.Pessoa;
import model.bean.Pfisica;
import model.bean.Pjuridica;


public class PessoaServiceDAO {

    public String createAccout(Pfisica pessoa) {
        PessoaRepositoryDAO repositoryDAO = new PessoaRepositoryDAO();
        if (!repositoryDAO.checkCPF(pessoa)) {
            if (repositoryDAO.createAccout(pessoa)) {
                repositoryDAO.updateAccout(pessoa);
            } else {
                return Constantes.CADASTRO_PF_FAIL_EMAIL;
            }
        } else {
            return Constantes.CADASTRO_PF_FAIL_CPF;
        }
        return Constantes.CONTA_PF_CRIADA;
    }

    public String createAccout(Pjuridica pessoa) {
        PessoaRepositoryDAO repositoryDAO = new PessoaRepositoryDAO();
        if (!repositoryDAO.checkCNPJ(pessoa)) {
            if (repositoryDAO.createAccout(pessoa)) {
                repositoryDAO.updateAccout(pessoa);
            } else {
                return Constantes.CADASTRO_PF_FAIL_EMAIL;
            }
        } else {
            return Constantes.CADASTRO_PJ_FAIL_CNPJ;
        }
        return Constantes.CONTA_PJ_CRIADA;
    }

    public String signInAccount(Pessoa pessoa) {
        PessoaRepositoryDAO repositoryDAO = new PessoaRepositoryDAO();
        if (repositoryDAO.signInAccout(pessoa)) {
            return Constantes.LOGIN_SUCESSO;
        }
        return Constantes.LOGIN_ERRADO;
    }
}
