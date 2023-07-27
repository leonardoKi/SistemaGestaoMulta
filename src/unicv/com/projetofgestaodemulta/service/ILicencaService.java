/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.licenca;

/**
 *
 * @author Leonardo Fonseca
 */
public interface ILicencaService extends IService<licenca> {

    public void removeAllByLicenca(licenca licencas) throws ServiceException;
}
