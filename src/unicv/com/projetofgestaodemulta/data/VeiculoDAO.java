/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Veiculo;

/*
 * @author Leonardo Fonseca
 */
public interface VeiculoDAO {

    // Interface responsavel pelos comandos
    public void add(Veiculo veiculo) throws DaoException;

    public void remove(int idVeiculo) throws DaoException;

    public void update(Veiculo veiculo) throws DaoException;

  public Optional<Veiculo> findById(int ID_Veiculo) throws DaoException;

   public Optional<Veiculo> findByPlaca(String Placa) throws DaoException;

   public List<Veiculo> findByIdentificacao(int Num_Identificacao) throws DaoException;

    public List<Veiculo> findAll() throws DaoException;

}
