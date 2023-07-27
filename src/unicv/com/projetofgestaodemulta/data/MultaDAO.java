/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Multa;

/**
 * @author Leonardo Fonseca
 */
    public interface MultaDAO {

// Método para inserir uma multa no banco de dados que recebe um objeto Multa como parâmetro e lança uma exceção DaoException em caso de erro
public void add(Multa multa) throws DaoException;

// Método para deletar uma multa do banco de dados pelo seu id que recebe um inteiro ID_Multa como parâmetro e lança uma exceção DaoException em caso de erro
public void remove(int ID_Multa) throws DaoException;

// Método para atualizar uma multa no banco de dados que recebe um objeto Multa como parâmetro e lança uma exceção DaoException em caso de erro
public void update(Multa multa) throws DaoException;

// Método para buscar uma multa no banco de dados pelo seu id que recebe um inteiro ID_Multa como parâmetro e retorna um objeto Optional<Multa> com a multa encontrada ou vazio se não encontrou e lança uma exceção DaoException em caso de erro
public Optional<Multa> findById(int ID_Multa) throws DaoException;

// Método para buscar todas as multas no banco de dados que não recebe nenhum parâmetro e retorna uma lista de multas com as multas encontradas ou vazia se não encontrou nenhuma e lança uma exceção DaoException em caso de erro
public List<Multa> findAll() throws DaoException;

// Método para buscar uma multa no banco de dados pela sua data que recebe um objeto LocalDate DataMulta como parâmetro e retorna um objeto Optional<Multa> com a multa encontrada ou vazio se não encontrou e lança uma exceção DaoException em caso de erro
public Optional<Multa> findByDataMulta(LocalDate DataMulta) throws DaoException;

}
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