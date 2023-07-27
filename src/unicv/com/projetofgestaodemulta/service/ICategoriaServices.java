/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.Categoria;

/*
 * @author Leonardo Fonseca
 */
public interface ICategoriaServices extends IService<Categoria> {

    public Optional<Categoria> findById(int ID_Categoria) throws ServiceException;
}
