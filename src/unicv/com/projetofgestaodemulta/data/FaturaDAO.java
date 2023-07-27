/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Fatura;

/**
 *
 * @author Leonardo Fonseca
 */
public interface FaturaDAO {

    public void add(Fatura fatura) throws DaoException;

    public void remove(int ID_Fatura) throws DaoException;

    public Optional<Fatura> findById(int ID_Fatura) throws DaoException;
    
}
