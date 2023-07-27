/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.Condutor;

/**
 *
 * @author Leonardo Fonseca
 */
public interface ICondutorServices extends IService<Condutor> {

    public Optional<Condutor> findById(int ID_Condutor) throws ServiceException;

    public Optional<Condutor> findByCNI(String CNI) throws ServiceException;

    

}
