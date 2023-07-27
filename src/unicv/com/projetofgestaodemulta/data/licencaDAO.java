/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.licenca;

/**
 *
 * @author Leonardo Fonseca
 */
public interface licencaDAO {

    public void add(licenca licencas) throws DaoException;

    public void remove(int ID_Licenca) throws DaoException;

    public void removeAllByLicenca(licenca licencas) throws DaoException;

    public void update(licenca licencas) throws DaoException;

}
