/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.execeptions;

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
public class ServiceException extends Exception {

// Construtor sem parâmetros que chama o construtor da superclasse Exception
public ServiceException() {
    super();
}

// Construtor que recebe uma mensagem como parâmetro e chama o construtor da superclasse Exception com a mensagem
public ServiceException(String message) {
    super(message);
}

// Construtor que recebe uma causa como parâmetro e chama o construtor da superclasse Exception com a causa
public ServiceException(Throwable cause) {
    super(cause);
}

// Construtor que recebe uma mensagem e uma causa como parâmetros e chama o construtor da superclasse Exception com a mensagem e a causa
public ServiceException(String message, Throwable cause) {
    super(message, cause);
}

    
}