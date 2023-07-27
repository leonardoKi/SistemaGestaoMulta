/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.data.AdministradorDAO;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.Administrador;

/**
 *
 * @author Leonardo Fonseca
 */
public class AdministradorServices implements IAdministradorServices {

    private final AdministradorDAO administradorDAO;

    public AdministradorServices(AdministradorDAO administradorDAO) {
        this.administradorDAO = administradorDAO;
    }

    @Override
    public void add(Administrador administrador) throws ServiceException {
        try {
            administradorDAO.add(administrador);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao adicionar o administrador.", ex);
        }
    }

    @Override
    public Optional<Administrador> get(int ID_Administrador) throws ServiceException {
        Optional<Administrador> optionalAdministrador = Optional.empty();
        try {
            optionalAdministrador = administradorDAO.findByIdAdministrador(ID_Administrador);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao ler o Administrador. "
                    + "Revice a coneção à base de dado", ex);
        }
        return optionalAdministrador;
    }

    @Override
    public void remove(int ID_Administrador) throws ServiceException {
        try {
            administradorDAO.remove(ID_Administrador);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao remover o administrador.", ex);
        }
    }

    @Override
    public void update(Administrador administrador) throws ServiceException {
        try {
            administradorDAO.update(administrador);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao atualizar o administrador.", ex);
        }
    }

    @Override
    public Optional<Administrador> findByIdAdministrador(int ID_Administrador) throws ServiceException {
        Optional<Administrador> optionalAdministrador = Optional.empty();
        try {
            optionalAdministrador = administradorDAO.findByIdAdministrador(ID_Administrador);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao encontrar o administrador pelo ID.", ex);
        }
        return optionalAdministrador;
    }

    @Override
    public List<Administrador> findAll() throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
