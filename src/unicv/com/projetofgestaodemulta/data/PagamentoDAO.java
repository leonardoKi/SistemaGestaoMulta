/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Pagamento;

/**
 *
 * @author Leonardo Fonseca
 */
public interface PagamentoDAO {

    public void add(Pagamento pagamento) throws DaoException;

    public void remove(int ID_Pagamento) throws DaoException;

    public void update(Pagamento pagamento) throws DaoException;

    public Optional<Pagamento> findById(int ID_Pagamento) throws DaoException;
    
    public List<Pagamento> findAll() throws DaoException ;

    public List<Pagamento> findByEstado(boolean estado) throws DaoException;

    public Optional<Pagamento> findByDataPagamento(LocalDate Datapagameno) throws DaoException;
}
