package model.dao;


import connection.ConnectionFactory;
import model.bean.Constantes;
import model.bean.Pessoa;
import model.bean.Pfisica;
import model.bean.Pjuridica;


public class PessoaServiceDAO {

    public String createAccout(Pfisica pessoa){
        PessoaRepositoryDAO repositoryDAO = new PessoaRepositoryDAO();
        if(repositoryDAO.checkCPF(pessoa)){
            repositoryDAO.createAccout(pessoa);
            repositoryDAO.updateAccout(pessoa);
        }else{
            ConnectionFactory.closeConnection(repositoryDAO.getCon(),repositoryDAO.getStmt(),repositoryDAO.getRs());
            return Constantes.CADASTRO_PF_FAIL_CPF;
        }
        ConnectionFactory.closeConnection(repositoryDAO.getCon(),repositoryDAO.getStmt(),repositoryDAO.getRs());
        return null;
    }

    public String createAccout(Pjuridica pessoa){
        PessoaRepositoryDAO repositoryDAO = new PessoaRepositoryDAO();
        if(repositoryDAO.checkCNPJ(pessoa)){
            repositoryDAO.createAccout(pessoa);
            repositoryDAO.updateAccout(pessoa);
        }else{
            ConnectionFactory.closeConnection(repositoryDAO.getCon(),repositoryDAO.getStmt(),repositoryDAO.getRs());
            return Constantes.CADASTRO_PJ_FAIL_CNPJ;
        }
        ConnectionFactory.closeConnection(repositoryDAO.getCon(),repositoryDAO.getStmt(),repositoryDAO.getRs());
        return null;
    }
    public String signInAccount(Pessoa pessoa){
        PessoaRepositoryDAO repositoryDAO = new PessoaRepositoryDAO();
        if(repositoryDAO.signInAccout(pessoa)){
            ConnectionFactory.closeConnection(repositoryDAO.getCon(),repositoryDAO.getStmt(),repositoryDAO.getRs());
            return Constantes.LOGIN_SUCESSO;
        }
        ConnectionFactory.closeConnection(repositoryDAO.getCon(),repositoryDAO.getStmt(),repositoryDAO.getRs());
        return Constantes.LOGIN_ERRADO;
    }
}
