/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Categoria;

/**
 *
 * @author Leonardo Fonseca
 */
public interface CategoriaDAO {
    
    public void add(Categoria categoria) throws DaoException;

    public void remove(int ID_Categoria) throws DaoException;

    public void update(Categoria categoria) throws DaoException;
    
    public Optional<Categoria>  findById(int ID_Categoria) throws DaoException;
    
}
