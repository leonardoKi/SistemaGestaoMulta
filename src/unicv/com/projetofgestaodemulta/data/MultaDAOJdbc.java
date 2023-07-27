/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

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
import java.util.List;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Artigo;
import unicv.com.projetofgestaodemulta.model.Multa;
import unicv.com.projetofgestaodemulta.model.SistemadeMulta;
import unicv.com.projetofgestaodemulta.utils.JDBCUtil;


// Define uma classe que implementa a interface MultaDAO usando JDBC
public class MultaDAOJdbc implements MultaDAO {

    // Define um método para adicionar uma multa no banco de dados
    @Override
    public void add(Multa multa) throws DaoException {
        // Define a instrução SQL para inserir uma multa na tabela Multa
        String sql = "insert into Multa( Seccao, DataMulta, ID_Artigo)"
                + "values( ?, ?, ?)";
        try (
            // Obtém uma conexão com o banco de dados
            Connection conn = JDBCUtil.getConnection();
            // Cria um objeto PreparedStatement com a instrução SQL e a opção de retornar as chaves geradas
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            // Define os valores dos parâmetros da instrução SQL com os dados da multa
            pstmt.setString(1, multa.getSeccao());
            pstmt.setDate(2,Date.valueOf(multa.getDataMulta()));
            pstmt.setInt(3, multa.getArtigo().getID_Artigo());
            // Executa a instrução SQL
            pstmt.executeUpdate();
            // Obtém um objeto ResultSet com as chaves geradas
            ResultSet rs = pstmt.getGeneratedKeys();
            // Se houver uma chave gerada, obtém o valor dela e define o ID da multa com ele
            if (rs.next()) {
                int id = rs.getInt(1);
                multa.setID_Multa(id);
            }
            // Confirma a transação no banco de dados
            conn.commit();
        } catch (SQLException ex) {
            // Lança uma exceção de DAO se houver algum problema ao executar a instrução SQL
            throw new DaoException(ex);
        }
    }

    // Define um método para remover uma multa do banco de dados pelo ID
    @Override
    public void remove(int id) throws DaoException {
        // Define a instrução SQL para deletar uma multa da tabela Multa pelo ID
        String sql = "delete from Multa where ID_Multa = ?";
            // Obtém uma conexão com o banco de dados
            // Cria um objeto PreparedStatement com a instrução SQL
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

// Define um método para atualizar uma multa no banco de dados
@Override
public void update(Multa multa) throws DaoException {
    // Define a instrução SQL para atualizar os dados de uma multa na tabela Multa pelo ID
    String sql = "update Multa set Seccao = ?, DataMulta = ?, ID_SistemaMulta = ?, ID_Artigo = ? where ID_Multa = ?";
    try (
        // Obtém uma conexão com o banco de dados
        Connection conn = JDBCUtil.getConnection();
        // Cria um objeto PreparedStatement com a instrução SQL
        PreparedStatement pstmt = conn.prepareStatement(sql);
    ) {
        // Define os valores dos parâmetros da instrução SQL com os dados da multa
        pstmt.setString(1, multa.getSeccao());
        pstmt.setObject(2, multa.getDataMulta());
        pstmt.setInt(3, multa.getSistemaMulta().getID_SistemaMulta());
        pstmt.setInt(4, multa.getArtigo().getID_Artigo());
        pstmt.setInt(5, multa.getID_Multa());
        // Executa a instrução SQL
        pstmt.executeUpdate();
        // Confirma a transação no banco de dados
        conn.commit();
    } catch (SQLException ex) {
        // Lança uma exceção de DAO se houver algum problema ao executar a instrução SQL
        throw new DaoException(ex);
    }
}


   @Override
public Optional<Multa> findById(int id) throws DaoException {
    String sql = "select * from Multa "
            + "join SistemaMulta on Multa.ID_SistemaMulta = SistemaMulta.ID_SistemaMulta "
            + "join Artigo on Multa.ID_Artigo = Artigo.ID_Artigo "
            + "where ID_Multa = ?";
    Optional<Multa> optionalMulta = Optional.empty();
    try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
        pstmt.setInt(1, id);
        try (ResultSet rs = pstmt.executeQuery();) {
            if (rs.next()) {
                Multa multa = new Multa();
                multa.setID_Multa(rs.getInt("ID_Multa"));
                multa.setSeccao(rs.getString("Seccao"));
                multa.setDataMulta(rs.getObject("DataMulta", LocalDate.class));
                SistemadeMulta sistema = new SistemadeMulta();
                Artigo artigo = new Artigo();
                sistema.setID_SistemaMulta(rs.getInt("ID_SistemaMulta"));
                artigo.setID_Artigo(rs.getInt("ID_Artigo"));
                artigo.setNum_Artigo(rs.getInt("Num_Artigo"));
                multa.setSistemaMulta(sistema);
                multa.setArtigos(artigo);
                optionalMulta = Optional.of(multa);
            }
            return optionalMulta;
        }
    } catch (SQLException ex) {
        throw new DaoException(ex);
    }
}



   // Define um método para buscar uma lista de todas as multas
@Override
public List<Multa> findAll() throws DaoException {
    // Cria uma lista para armazenar as multas
    List<Multa> multas = new ArrayList<>();
    // Define a instrução SQL para selecionar todas as multas da tabela Multa e da tabela relacionada Artigo
    String sql = "select * from Multa"
            +" join Artigo on Multa.ID_Artigo = Artigo.ID_Artigo  ";
    try (
        // Obtém uma conexão com o banco de dados
        Connection conn = JDBCUtil.getConnection();
        // Cria um objeto Statement para executar a instrução SQL
        Statement stmt = conn.createStatement();
        // Executa a instrução SQL e obtém um objeto ResultSet com o resultado da consulta
        ResultSet rs = stmt.executeQuery(sql);
    ) {
        // Enquanto houver resultados, cria um objeto Multa e preenche seus atributos com os valores do ResultSet
        while (rs.next()) {
            Multa multa = new Multa();
            multa.setID_Multa(rs.getInt("ID_Multa"));
            multa.setSeccao(rs.getString("Seccao"));
            multa.setDataMulta(rs.getObject("DataMulta", LocalDate.class));
            SistemadeMulta sistema = new SistemadeMulta();
            Artigo artigo = new Artigo();
            sistema.setID_SistemaMulta(rs.getInt("ID_SistemaMulta"));
            artigo.setID_Artigo(rs.getInt("ID_Artigo"));
            artigo.setNum_Artigo(rs.getInt("Num_Artigo"));
            multa.setSistemaMulta(sistema);
            multa.setArtigos(artigo);
            // Adiciona o objeto Multa na lista de multas
            multas.add(multa);
        }
    } catch (SQLException ex) {
        // Lança uma exceção de DAO se houver algum problema ao executar a instrução SQL ou ao manipular o ResultSet
        throw new DaoException(ex);
    }
    // Retorna a lista de multas
    return multas;
}

    
@Override
public Optional<Multa> findByDataMulta(LocalDate dataMulta) throws DaoException {
    String sql = "select * from Multa "
            + "join SistemaMulta on Multa.ID_SistemaMulta = SistemaMulta.ID_SistemaMulta "
            + "join Artigo on Multa.ID_Artigo = Artigo.ID_Artigo "
            + "where DataMulta = ?";
    Optional<Multa> optionalMulta = Optional.empty();
    try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
        pstmt.setObject(1, dataMulta);
        try (ResultSet rs = pstmt.executeQuery();) {
            if (rs.next()) {
                Multa multa = new Multa();
                multa.setID_Multa(rs.getInt("ID_Multa"));
                multa.setSeccao(rs.getString("Seccao"));
                multa.setDataMulta(rs.getObject("DataMulta", LocalDate.class));
                SistemadeMulta sistema = new SistemadeMulta();
                Artigo artigo = new Artigo();
                sistema.setID_SistemaMulta(rs.getInt("ID_SistemaMulta"));
                artigo.setID_Artigo(rs.getInt("ID_Artigo"));
                artigo.setNum_Artigo(rs.getInt("Num_Artigo"));
                multa.setSistemaMulta(sistema);
                multa.setArtigos(artigo);
                optionalMulta = Optional.of(multa);
            }
            return optionalMulta;
        }
    } catch (SQLException ex) {
        throw new DaoException(ex);
    }
}


}



