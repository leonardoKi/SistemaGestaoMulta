/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import unicv.com.projetofgestaodemulta.data.SistemaMultaDAO;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.SistemadeMulta;

/**
 *
 * @author Leonardo Fonseca
 */
public class SistemadeMultaServices implements ISistemadeMultaServices {

    private final SistemaMultaDAO sistemaMultaDAO;

    public SistemadeMultaServices(SistemaMultaDAO sistemaMultaDAO) {
        this.sistemaMultaDAO = sistemaMultaDAO;
    }

    public void add(SistemadeMulta sistema) throws ServiceException {
        try {
            sistemaMultaDAO.add(sistema);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao adicionar o sistema de multa.", ex);
        }
    }

    public void remove(int idsistema) throws ServiceException {
        try {
            sistemaMultaDAO.remove(idsistema);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao remover o sistema de multa.", ex);
        }
    }

    public void update(SistemadeMulta sistema) throws ServiceException {
        try {
            sistemaMultaDAO.update(sistema);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao atualizar o sistema de multa.", ex);
        }
    }

    @Override
    public void removeAllBySistemadeMulta(SistemadeMulta sistema) throws ServiceException {
        try {
            sistemaMultaDAO.removeAllBySistemadeMulta(sistema);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao remover todos os sistemas de multa.", ex);
        }
    }

}
