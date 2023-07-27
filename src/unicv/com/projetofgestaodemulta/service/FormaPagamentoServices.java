/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.data.FormaPagamentoDAO;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.FormaPagamento;

/*
 * @author Leonardo Fonseca
 */
public class FormaPagamentoServices implements IFormaPagamentoServices {

    private final FormaPagamentoDAO formaPagamentoDAO;

    public FormaPagamentoServices(FormaPagamentoDAO formaPagamentoDAO) {
        this.formaPagamentoDAO = formaPagamentoDAO;
    }

    @Override
    public void add(FormaPagamento formapagamento) throws ServiceException {
        try {
            formaPagamentoDAO.add(formapagamento);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao adicionar a forma de pagamento.", ex);
        }
    }

    @Override
    public void remove(int ID_Formapagamento) throws ServiceException {
        try {
            formaPagamentoDAO.remove(ID_Formapagamento);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao remover a forma de pagamento.", ex);
        }
    }

    @Override
    public void update(FormaPagamento formapagamento) throws ServiceException {
        try {
            formaPagamentoDAO.update(formapagamento);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao atualizar a forma de pagamento.", ex);
        }
    }

    @Override
    public Optional<FormaPagamento> get(int id) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<FormaPagamento> findAll() throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
