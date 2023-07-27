/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.Fatura;

/*
 * @author Leonardo Fonseca
 */
public interface IFaturaServices extends IService<Fatura> {

  public Optional<Fatura> findById(int ID_Fatura) throws ServiceException;
}
