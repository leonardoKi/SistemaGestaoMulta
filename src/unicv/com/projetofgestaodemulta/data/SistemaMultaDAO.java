/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.SistemadeMulta;

/**
 * @author Leonardo Fonseca
 */
public interface SistemaMultaDAO {

    public void add(SistemadeMulta sistema) throws DaoException;

    public void remove(int idsistema) throws DaoException;

    public void update(SistemadeMulta sistema) throws DaoException;

    public void removeAllBySistemadeMulta(SistemadeMulta sistema) throws DaoException;

}
