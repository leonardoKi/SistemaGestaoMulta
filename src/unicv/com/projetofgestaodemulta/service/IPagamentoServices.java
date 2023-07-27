/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.Pagamento;

/**
 *
 * @author Leonardo Fonseca
 */
public interface IPagamentoServices extends IService<Pagamento> {

    public Optional<Pagamento> findById(int ID_Pagamento) throws ServiceException;

    public Optional<Pagamento> findByDataPagamento(LocalDate ID_Pagamento) throws ServiceException;
    
    public List<Pagamento> findByEstado(boolean estado) throws ServiceException;

}
