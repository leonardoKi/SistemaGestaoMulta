/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.data.PagamentoDAO;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.Pagamento;

/**
 *
 * @author Leonardo Fonseca
 */
public class PagamentoService implements IPagamentoServices {

    private final PagamentoDAO pagamentoDAO;

    public PagamentoService(PagamentoDAO pagamentoDAO) {
        this.pagamentoDAO = pagamentoDAO;
    }

    @Override
    public void add(Pagamento o) throws ServiceException {
        if (o.getValorPagar() <= 0) {
            throw new ServiceException("O valor da descrição é invalida");
        }
        try {
            pagamentoDAO.add(o);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao adicionar o Pagamento. "
                    + "Revice a coneção à base de dado", ex);
        }
    }
    
    @Override
    public void remove(int ID_Pagamento) throws ServiceException {
        try {
            pagamentoDAO.remove(ID_Pagamento);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao remover o pagamento.", ex);
        }
    }

    @Override
    public void update(Pagamento pagamento) throws ServiceException {
        try {
            pagamentoDAO.update(pagamento);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao atualizar o pagamento.", ex);
        }
    }

    @Override
    public Optional<Pagamento> findById(int ID_Pagamento) throws ServiceException {
        Optional<Pagamento> optionalPagamento = Optional.empty();
        try {
            optionalPagamento = pagamentoDAO.findById(ID_Pagamento);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao encontrar o pagamento pelo ID.", ex);
        }
        return optionalPagamento;
    }

    @Override
    public Optional<Pagamento> findByDataPagamento(LocalDate DataPagamento) throws ServiceException {
        Optional<Pagamento> optionalPagamento = Optional.empty();
        try {
            optionalPagamento = pagamentoDAO.findByDataPagamento(DataPagamento);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao encontrar o pagamento pela data.", ex);
        }
        return optionalPagamento;
    }
    
    @Override
    public List<Pagamento> findByEstado(boolean estado) throws ServiceException {
    List<Pagamento> pagamentos = new ArrayList<>();
    try {
        pagamentos = pagamentoDAO.findByEstado(estado);
    } catch (DaoException ex) {
        throw new ServiceException("Erro ao encontrar pagamentos pelo estado.", ex);
    }
    return pagamentos;
}

  @Override
    public Optional<Pagamento> get(int ID_Pagamento) throws ServiceException {
        Optional<Pagamento> optionalartigos = Optional.empty();
        try {
            optionalartigos = pagamentoDAO.findById(ID_Pagamento);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao ler o Pagamento. "
                    + "Revice a coneção à base de dado", ex);
        }
        return optionalartigos;
    }

   @Override
public List<Pagamento> findAll() throws ServiceException {
    List<Pagamento> listaPagamentos = new ArrayList<>();
    try {
        listaPagamentos.addAll(pagamentoDAO.findAll());
    } catch (DaoException ex) {
        throw new ServiceException("Erro ao encontrar todos os pagamentos.", ex);
    }
    return listaPagamentos;
}


}
