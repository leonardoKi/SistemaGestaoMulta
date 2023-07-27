/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;

/**
 * @param <T>
Disciplina: PROGRAMAÇÃO ORIENTADA A OBJETOS
Projeto: Sistema de Gestão de Multa
Data Criação:‎28‎ de ‎junho‎ de ‎2023, ‏‎18:06:26
Data de Modificação:26 de julho de 2023
Versão:final
Autor: Leonardo Fonseca
Faculdade de Ciências e Tecnologias
Universidade de Cabo Verde
*/

// Define uma interface genérica para os serviços de negócio
public interface IService <T>{

    // Define um método para adicionar um objeto do tipo T
    void add(T o)throws ServiceException;   

    // Define um método para buscar um objeto opcional do tipo T pelo ID
    Optional<T> get(int id)throws ServiceException;

    // Define um método para atualizar um objeto do tipo T
    void update(T o)throws ServiceException;      

    // Define um método para remover um objeto do tipo T pelo ID
    void remove(int id)throws ServiceException; 
    
    // Define um método para buscar uma lista de objetos do tipo T
    List<T> findAll() throws ServiceException;    

}


