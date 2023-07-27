/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Departamento;

/**
 *
 * @author Leonardo Fonseca
 */
public interface DepartamentoDAO {

    public void add(Departamento departamento) throws DaoException;

    public void remove(int ID_Departamento) throws DaoException;

    public void update(Departamento departamento) throws DaoException;

}
