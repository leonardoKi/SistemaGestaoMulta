/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.data.licencaDAO;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.licenca;

/**
 *
 * @author Leonardo Fonseca
 */
public class LicencaServices implements ILicencaService {

    private final licencaDAO licencaDAO;

    public LicencaServices(licencaDAO licencaDAO) {
        this.licencaDAO = licencaDAO;
    }

    @Override
    public void add(licenca licencas) throws ServiceException {
        try {
            licencaDAO.add(licencas);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao adicionar a licença.", ex);
        }
    }

    @Override
    public void remove(int ID_Licenca) throws ServiceException {
        try {
            licencaDAO.remove(ID_Licenca);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao remover a licença.", ex);
        }
    }

    @Override
    public void removeAllByLicenca(licenca licencas) throws ServiceException {
        try {
            licencaDAO.removeAllByLicenca(licencas);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao remover todas as licenças.", ex);
        }
    }

    @Override
    public void update(licenca licencas) throws ServiceException {
        try {
            licencaDAO.update(licencas);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao atualizar a licença.", ex);
        }
    }

    @Override
    public Optional<licenca> get(int id) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<licenca> findAll() throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
