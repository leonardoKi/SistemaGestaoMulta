/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.Veiculo;

/*
 * @author Leonardo Fonseca
 */
public interface IVeiculoServices extends IService<Veiculo> {

    public Optional<Veiculo> findById(int ID_Veiculo) throws ServiceException;

    public Optional<Veiculo> findByPlaca(String Placa) throws ServiceException;

    public List<Veiculo> findByIdentificacao(int Num_Identificacao) throws ServiceException;

}
