/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.data.MultadoDAO;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.Multado;

/**
 *
 * @author Leonardo Fonseca
 */
public class MultadoServices implements IMultadoServices {

    private final MultadoDAO multadoDAO;

    public MultadoServices(MultadoDAO multadoDAO) {
        this.multadoDAO = multadoDAO;
    }

    @Override
    public void add(Multado multado) throws ServiceException {
        try {
            multadoDAO.add(multado);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao adicionar o multado.", ex);
        }
    }

    @Override
    public void remove(int idMultado) throws ServiceException {
        try {
            multadoDAO.remove(idMultado);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao remover o multado.", ex);
        }
    }

    @Override
    public void update(Multado multado) throws ServiceException {
        try {
            multadoDAO.update(multado);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao atualizar o multado.", ex);
        }
    }

    @Override
    public Optional<Multado> get(int id) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Multado> findAll() throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
