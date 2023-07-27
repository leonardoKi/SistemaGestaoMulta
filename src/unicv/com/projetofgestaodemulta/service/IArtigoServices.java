/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.Artigo;

/*
 * @author Leonardo Fonseca
 */
public interface IArtigoServices extends IService<Artigo> {

    public Optional<Artigo> findById(int ID_Artigo) throws ServiceException;

    public Optional<Artigo> findByNumArtigo(int Num_Artigo) throws ServiceException;

    public List<Artigo> findByValor(float ValorMulta) throws ServiceException;

    @Override
    public List<Artigo> findAll() throws ServiceException;
}
