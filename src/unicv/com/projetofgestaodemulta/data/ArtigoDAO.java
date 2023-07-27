/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Artigo;

/**
 * @author Leonardo Fonseca
 */
public interface ArtigoDAO {
 
// Interface responsavel pelos comandos
    public void add(Artigo artigo) throws DaoException;

    public void remove(int ID_Artigo) throws DaoException;

    public void update(Artigo artigo) throws DaoException;

    public Optional<Artigo> findByIdArtigo(int ID_Artigo) throws DaoException;

    public Optional<Artigo> findByNumArtigo(int Num_Artigo) throws DaoException;

    public List<Artigo> findByValor(float valor) throws DaoException;

    public List<Artigo> findAll() throws DaoException;
    
}
