/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.utils; 
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;

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
public class JDBCUtil {
     //jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]
 // Define um método para obter uma conexão com o banco de dados
public static Connection getConnection() throws SQLException {
    // Define as propriedades da conexão, como o host, a porta, o tipo de banco e os dados de autenticação
    String host = "localhost";
    String port = "1433";
    String dbms = "sqlserver";
    Properties connProps = new Properties();
    connProps.put("Database", "GestaoMulta");
    connProps.put("user", "sa");
    connProps.put("password", "123456789");
    connProps.put("encrypt", "false");
    connProps.put("trustServerCertificate", "true");
    // Define a URL da conexão com o formato adequado
    String url = String.format("jdbc:%1$s://%2$s:%3$s",
            dbms, host, port);
    // Cria um objeto Connection usando o método estático da classe DriverManager e 
    //passando a URL e as propriedades da conexão
    Connection conn;
    conn = (Connection)java.sql.DriverManager.getConnection(url, connProps);
    // Define que a conexão não deve fazer commit automático das transações
    conn.setAutoCommit(false);
    // Retorna o objeto Connection
    return conn;
}
// Define um método para fazer commit das transações na conexão
public static void commit(Connection conn) throws SQLException {
    // Se a conexão não for nula, chama o método commit do objeto Connection
    if (conn != null) {
        conn.commit();
    }
}
// Define um método para fazer rollback das transações na conexão
public static void rollback(Connection conn) throws SQLException {
    // Se a conexão não for nula, chama o método rollback do objeto Connection
    if (conn != null) {
        conn.rollback();
    }
}

   
}    

