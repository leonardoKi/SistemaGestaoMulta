/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.time.LocalDate;
import java.util.Optional;
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
public interface IMultaServices extends IService<Multa> {

   // Método para buscar uma multa pelo seu id que recebe um inteiro ID_Multa como 
    //parâmetro e retorna um objeto Optional<Multa> com a multa encontrada ou vazio 
    //se não encontrou e lança uma exceção ServiceException em caso de erro
public Optional<Multa> findById(int ID_Multa) throws ServiceException;

// Método para buscar uma multa pela sua data que recebe um objeto LocalDate DataMulta
//como parâmetro e retorna um objeto Optional<Multa> com a multa encontrada ou vazio se
//não encontrou e lança uma exceção ServiceException em caso de erro
public Optional<Multa> findByDataMulta(LocalDate DataMulta) throws ServiceException;

}
