/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.data.FaturaDAO;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.Fatura;

/**
 *
 * @author Leonardo Fonseca
 */
public class FaturaServices implements IFaturaServices {

    private final FaturaDAO faturaDAO;

    public FaturaServices(FaturaDAO faturaDAO) {
        this.faturaDAO = faturaDAO;
    }
 
    @Override
    public void remove(int ID_Fatura) throws ServiceException {
        try {
            faturaDAO.remove(ID_Fatura);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao remover a fatura.", ex);
        }
    }
    @Override
    public Optional<Fatura> findById(int ID_Fatura) throws ServiceException {
        Optional<Fatura> optionalFatura = Optional.empty();
        try {
            optionalFatura = faturaDAO.findById(ID_Fatura);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao encontrar a fatura pelo ID.", ex);
        }
        return optionalFatura;
    }
  

    @Override
    public void add(Fatura o) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Fatura> get(int id) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Fatura o) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Fatura> findAll() throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
