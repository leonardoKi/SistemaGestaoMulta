/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.SistemadeMulta;

/**
 *
 * @author Leonardo Fonseca
 */
public interface ISistemadeMultaServices {

    public void removeAllBySistemadeMulta(SistemadeMulta sistema) throws ServiceException;
}
