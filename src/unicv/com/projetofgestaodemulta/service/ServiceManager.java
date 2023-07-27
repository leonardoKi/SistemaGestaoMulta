/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import unicv.com.projetofgestaodemulta.data.ArtigoDAOJdbc;
import unicv.com.projetofgestaodemulta.data.CondutorDAOJdbc;
import unicv.com.projetofgestaodemulta.data.VeiculoDAOJdbc;
import unicv.com.projetofgestaodemulta.data.MultaDAOJdbc;
import unicv.com.projetofgestaodemulta.data.PagamentoDAOjdbc;

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

   // Define uma classe para gerenciar os Services
public class ServiceManager {

    // Define um atributo estático para armazenar a instância única do gerenciador
    private static ServiceManager manager;

    // Define os atributos para armazenar os serviços de cada entidade
    private final IArtigoServices artigoService;
    private final IVeiculoServices veiculoService;
    private final ICondutorServices condutorService;
    private final IMultaServices multaService;
    private final IPagamentoServices pagamentoService;

    // Define um construtor privado para evitar a criação de outras instâncias do gerenciador
    private ServiceManager() {
        // Inicializa os serviços com as implementações que usam JDBC e DAO
        artigoService = new ArtigoServices(new ArtigoDAOJdbc());
        veiculoService = new VeiculoServices(new VeiculoDAOJdbc());
        condutorService = new CondutorServices(new CondutorDAOJdbc());
        multaService = new MultaServices(new MultaDAOJdbc());
        pagamentoService = new PagamentoService(new PagamentoDAOjdbc());
    }

    // Define um método estático para obter a instância única do gerenciador
    public static ServiceManager getServiceManager() {
        // Se o gerenciador ainda não foi criado, cria uma nova instância
        if (manager == null) {
            manager = new ServiceManager();
        }
        // Retorna a instância do gerenciador
        return manager;
    }

    // Define os métodos para obter os serviços de cada entidade
    public IArtigoServices getArtigoService() {
        return artigoService;
    }

    public IVeiculoServices getVeiculoService() {
        return veiculoService;
    }

    public ICondutorServices getCondutorService() {
        return condutorService;
    }
    
    public IMultaServices getMultaService() {
        return multaService;
    }

    public IPagamentoServices getPagamentoService() {
        return pagamentoService;
    }
}



