/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.data.VeiculoDAO;
import unicv.com.projetofgestaodemulta.model.Veiculo;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;

/*
 * @author Leonardo Fonseca
 */
public class VeiculoServices implements IVeiculoServices {

    private final VeiculoDAO veiculoDAO;

    public VeiculoServices(VeiculoDAO veiculoDAO) {
        this.veiculoDAO = veiculoDAO;
    }

    @Override
    public void add(Veiculo o) throws ServiceException {
        if (o.getLotacao() <= 0) {
            throw new ServiceException("O valor da descrição é invalida");
        }
        try {
            veiculoDAO.add(o);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao adicionar o veiculo. "
                    + "Revice a coneção à base de dado", ex);
        }
    }

    @Override
    public Optional<Veiculo> get(int ID_Veiculo) throws ServiceException {
        Optional<Veiculo> optionalProduto = Optional.empty();
        try {
            optionalProduto = veiculoDAO.findById(ID_Veiculo);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao ler o veiculo. "
                    + "Revice a coneção à base de dado", ex);
        }
        return optionalProduto;
    }

    @Override
    public void remove(int ID_Veiculo) throws ServiceException {
        try {
            veiculoDAO.remove(ID_Veiculo);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao remover o veículo.", ex);
        }
    }

    @Override
    public void update(Veiculo o) throws ServiceException {
        if (o.getLotacao() <= 0) {
            throw new ServiceException("O valor da lotação é invalida");
        }
        try {
            veiculoDAO.update(o);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao atualizar o Artigo. "
                    + "Revice a coneção à base de dado", ex);
        }
    }

    @Override
    public List<Veiculo> findAll() throws ServiceException {
        List<Veiculo> listaVeiculos = new ArrayList<>();
        try {
            listaVeiculos.addAll(veiculoDAO.findAll());
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao encontrar todos os Veiculos.", ex);
        }
        return listaVeiculos;
    }

    @Override
    public Optional<Veiculo> findById(int ID_Veiculo) throws ServiceException {
        Optional<Veiculo> optionalVeiculo = Optional.empty();
        try {
            optionalVeiculo = veiculoDAO.findById(ID_Veiculo);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao ler o Veículo por ID_Veiculo. "
                    + "Revise a conexão à base de dados", ex);
        }
        return optionalVeiculo;
    }

    @Override
    public Optional<Veiculo> findByPlaca(String Placa) throws ServiceException {
        Optional<Veiculo> optionalVeiculo = Optional.empty();
        try {
            optionalVeiculo = veiculoDAO.findByPlaca(Placa);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao ler o Veículo por Placa. "
                    + "Revise a conexão à base de dados", ex);
        }
        return optionalVeiculo;
    }

    @Override
    public List<Veiculo> findByIdentificacao(int Num_Identificacao) throws ServiceException {
        List<Veiculo> listaVeiculos = new ArrayList<>();
        try {
            listaVeiculos = veiculoDAO.findByIdentificacao(Num_Identificacao);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao ler os Veículos por Num_Identificacao. "
                    + "Revise a conexão à base de dados", ex);
        }
        return listaVeiculos;
    }

}
