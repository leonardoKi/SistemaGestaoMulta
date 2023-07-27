/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.FormaPagamento;

/**
 *
 * @author Leonardo Fonseca
 */
public interface FormaPagamentoDAO {
    
      public void add(FormaPagamento formapagamento) throws DaoException;

    public void remove(int ID_Formapagamento) throws DaoException;

    public void update(FormaPagamento formapagamento) throws DaoException;
    
}
