/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.data.DepartamentoDAO;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.Departamento;

/**
 *
 * @author Leonardo Fonseca
 */
public class DepartamentoServices implements IDepartamentoServices {

    private final DepartamentoDAO departamentoDAO;

    public DepartamentoServices(DepartamentoDAO departamentoDAO) {
        this.departamentoDAO = departamentoDAO;
    }

    @Override
    public void add(Departamento departamento) throws ServiceException {
        try {
            departamentoDAO.add(departamento);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao adicionar o departamento.", ex);
        }
    }

    @Override
    public void remove(int ID_Departamento) throws ServiceException {
        try {
            departamentoDAO.remove(ID_Departamento);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao remover o departamento.", ex);
        }
    }

    @Override
    public void update(Departamento departamento) throws ServiceException {
        try {
            departamentoDAO.update(departamento);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao atualizar o departamento.", ex);
        }
    }

    @Override
    public Optional<Departamento> get(int id) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Departamento> findAll() throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
