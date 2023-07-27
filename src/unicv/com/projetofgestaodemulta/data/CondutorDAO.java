/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Condutor;

/**
 *
 * @author Leonardo Fonseca
 */
public interface CondutorDAO {
    
    public void add(Condutor condutor) throws DaoException;
    public void remove(int ID_Condutor) throws DaoException;
    public void update(Condutor condutor) throws DaoException;
    public Optional<Condutor>  findById(int ID_Condutor) throws DaoException;
    public Optional<Condutor>  findByCNI(String CNI) throws DaoException;
    public List<Condutor> findAll() throws DaoException;        

    
}
