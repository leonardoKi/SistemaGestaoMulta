/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Multado;

/**
 *
 * @author Leonardo Fonseca
 */
public interface MultadoDAO {

    public void add(Multado multado) throws DaoException;

    public void remove(int idMultado) throws DaoException;

    public void update(Multado multado) throws DaoException;

}
