/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Administrador;

/**
 * @author Leonardo Fonseca
 */
public interface AdministradorDAO {

    public void add(Administrador administrador) throws DaoException;

    public void remove(int ID_Administrador) throws DaoException;

    public void update(Administrador administrador) throws DaoException;

    public Optional<Administrador> findByIdAdministrador(int ID_Administrador) throws DaoException;

}
