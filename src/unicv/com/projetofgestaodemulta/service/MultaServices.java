/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.data.MultaDAO;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.Multa;

/*
Disciplina: PROGRAMAÇÃO ORIENTADA A OBJETOS
Projeto: Sistema de Gestão de Multa
Data Criação:‎28‎ de ‎junho‎ de ‎2023, ‏‎18:06:26
Data de Modificação:26 de julho de 2023
Versão:final
Autor: Leonardo Fonseca
Faculdade de Ciências e Tecnologias
Universidade de Cabo Verde
*/
public class MultaServices implements IMultaServices {

// Declara um atributo do tipo MultaDAO para acessar os dados das multas
private final MultaDAO multaDAO;

// Construtor da classe que recebe um objeto MultaDAO como parâmetro
public MultaServices(MultaDAO multaDAO) {
    // Atribui o objeto recebido ao atributo da classe
    this.multaDAO = multaDAO;
}

// Método para adicionar uma multa ao banco de dados
@Override
public void add(Multa o) throws ServiceException {
    // Se a multa não tem um artigo associado, lança uma exceção de serviço
    if (o.getArtigo()==null) {
        throw new ServiceException("O valor da descrição é invalida");
    }
    try {
        // Chama o método add do objeto multaDAO para inserir a multa no banco de dados
        multaDAO.add(o);
    } catch (DaoException ex) {
        // Se ocorrer um erro de acesso aos dados, lança uma exceção de serviço com uma mensagem e a causa
        throw new ServiceException("Erro ao adicionar o Multa. "
                + "Revice a coneção à base de dado", ex);
    }
}

// Método para remover uma multa do banco de dados pelo seu id
@Override
public void remove(int ID_Multa) throws ServiceException {
    try {
        // Chama o método remove do objeto multaDAO para deletar a multa do banco de dados pelo seu id
        multaDAO.remove(ID_Multa);
    } catch (DaoException ex) {
        // Se ocorrer um erro de acesso aos dados, lança uma exceção de serviço com a causa
        throw new ServiceException("Erro ao remover a multa.", ex);
    }
}

// Método para atualizar uma multa no banco de dados
@Override
public void update(Multa o) throws ServiceException {
    // Se a multa tem um id menor ou igual a zero, lança uma exceção de serviço
    if (o.getID_Multa()<=0) {
        throw new ServiceException("O valor da descrição é invalida");
    }
    try {
        // Chama o método update do objeto multaDAO para atualizar a multa no banco de dados
        multaDAO.update(o);
    } catch (DaoException ex) {
        // Se ocorrer um erro de acesso aos dados, lança uma exceção de serviço com uma mensagem e a causa
        throw new ServiceException("Erro ao atualizar o Multa. "
                + "Revice a coneção à base de dado", ex);
    }
}

// Método para buscar uma multa no banco de dados pelo seu id
@Override
public Optional<Multa> findById(int ID_Multa) throws ServiceException {
    // Declara um objeto Optional<Multa> vazio para armazenar o resultado da busca
    Optional<Multa> optionalMulta = Optional.empty();
    try {
        // Chama o método findById do objeto multaDAO para buscar a multa no banco de dados pelo seu id e atribui ao objeto Optional<Multa>
        optionalMulta = multaDAO.findById(ID_Multa);
    } catch (DaoException ex) {
        // Se ocorrer um erro de acesso aos dados, lança uma exceção de serviço com a causa
        throw new ServiceException("Erro ao encontrar a multa pelo ID.", ex);
    }
    // Retorna o objeto Optional<Multa> com a multa encontrada ou vazio se não encontrou
    return optionalMulta;
}
    
  // Define um método para buscar uma multa opcional pela data da multa
@Override
public Optional<Multa> findByDataMulta(LocalDate DataMulta) throws ServiceException {
    // Cria uma variável para armazenar a multa opcional
    Optional<Multa> optionalMulta = Optional.empty();
    try {
        // Busca a multa opcional pelo DAO com a data informada
        optionalMulta = multaDAO.findByDataMulta(DataMulta);
    } catch (DaoException ex) {
        // Lança uma exceção de serviço se houver algum problema ao buscar a multa pelo DAO
        throw new ServiceException("Erro ao encontrar a multa pela data.", ex);
    }
    // Retorna a multa opcional
    return optionalMulta;
}

// Define um método para buscar uma multa opcional pelo ID da multa
@Override
public Optional<Multa> get(int ID_Multa) throws ServiceException {
    // Cria uma variável para armazenar a multa opcional
    Optional<Multa> optionalartigos = Optional.empty();
    try {
        // Busca a multa opcional pelo DAO com o ID informado
        optionalartigos = multaDAO.findById(ID_Multa);
    } catch (DaoException ex) {
        // Lança uma exceção de serviço se houver algum problema ao buscar a multa pelo DAO
        throw new ServiceException("Erro ao ler o Multa. "
                + "Revice a coneção à base de dado", ex);
    }
    // Retorna a multa opcional
    return optionalartigos;
}

// Define um método para buscar uma lista de todas as multas
@Override
public List<Multa> findAll() throws ServiceException {
    // Cria uma lista para armazenar as multas
    List<Multa> listaMultas = new ArrayList<>();
    try {
        // Adiciona todas as multas encontradas pelo DAO na lista
        listaMultas.addAll(multaDAO.findAll());
    } catch (DaoException ex) {
        // Lança uma exceção de serviço se houver algum problema ao buscar as multas pelo DAO
        throw new ServiceException("Erro ao encontrar todas as multas.", ex);
    }
    // Retorna a lista de multas
    return listaMultas;
}

}
