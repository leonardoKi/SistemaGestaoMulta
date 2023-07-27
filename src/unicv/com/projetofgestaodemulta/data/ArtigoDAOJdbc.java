/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Artigo;
import unicv.com.projetofgestaodemulta.utils.JDBCUtil;

public class ArtigoDAOJdbc implements ArtigoDAO {

    @Override
    public void add(Artigo artigo) throws DaoException {
        String sql = "insert into Artigo(ValorMulta, Num_Pontos, Num_Artigo)"
                + "values(?, ?, ?)";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {          
            pstmt.setFloat(1, artigo.getValorMulta());
            pstmt.setInt(2, artigo.getNum_Pontos());
            pstmt.setInt(3, artigo.getNum_Artigo());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                artigo.setID_Artigo(id);
            }
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void remove(int ID_Artigo) throws DaoException {
        String sql = "delete from Artigo "
                + "where ID_Artigo = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, ID_Artigo);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void update(Artigo artigo) throws DaoException {
        String sql = "update Artigo set ValorMulta = ?, Num_Pontos = ?, Num_Artigo = ? "
                + "where ID_Artigo = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setFloat(1, artigo.getValorMulta());
            pstmt.setInt(2, artigo.getNum_Pontos());
            pstmt.setInt(3, artigo.getNum_Artigo());
            pstmt.setInt(4, artigo.getID_Artigo());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public Optional<Artigo> findByIdArtigo(int ID_Artigo) throws DaoException {
        String sql = "select * from Artigo where ID_Artigo = ?";
        Optional<Artigo> optionalArtigo = Optional.empty();
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, ID_Artigo);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    Artigo artigo = new Artigo();
                    artigo.setID_Artigo(rs.getInt("ID_Artigo"));
                    artigo.setValorMulta(rs.getFloat("ValorMulta"));
                    artigo.setNum_Pontos(rs.getInt("Num_Pontos"));
                    artigo.setNum_Artigo(rs.getInt("Num_Artigo"));
                    optionalArtigo = Optional.of(artigo);
                }
                return optionalArtigo;
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public Optional<Artigo> findByNumArtigo(int Num_Artigo) throws DaoException {
        String sql = "select * from Artigo "
                + "where Num_Artigo = ?";
        Optional<Artigo> optionalArtigo = Optional.empty();
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, Num_Artigo);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    Artigo artigo = new Artigo();
                    artigo.setID_Artigo(rs.getInt("ID_Artigo"));
                    artigo.setValorMulta(rs.getFloat("ValorMulta"));
                    artigo.setNum_Pontos(rs.getInt("Num_Pontos"));
                    artigo.setNum_Artigo(rs.getInt("Num_Artigo"));
                    optionalArtigo = Optional.of(artigo);
                }
                return optionalArtigo;
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public List<Artigo> findByValor(float ValorMulta) throws DaoException {
        String sql = "select * from Artigo "
                + "where ValorMulta = ?";
        List<Artigo> artigos = new ArrayList<>();
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setFloat(1, ValorMulta);
            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    Artigo artigo = new Artigo();
                    artigo.setID_Artigo(rs.getInt("ID_Artigo"));
                    artigo.setValorMulta(rs.getFloat("ValorMulta"));
                    artigo.setNum_Pontos(rs.getInt("Num_Pontos"));
                    artigo.setNum_Artigo(rs.getInt("Num_Artigo"));
                    artigos.add(artigo);
                }
                return artigos;
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }
    @Override
    public List<Artigo> findAll() throws DaoException {
        String sql = "select * from Artigo";
        List<Artigo> artigos = new ArrayList<>();
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
            while (rs.next()) {
                Artigo artigo = new Artigo();
                artigo.setID_Artigo(rs.getInt("ID_Artigo"));
                artigo.setValorMulta(rs.getFloat("ValorMulta"));
                artigo.setNum_Pontos(rs.getInt("Num_Pontos"));
                artigo.setNum_Artigo(rs.getInt("Num_Artigo"));
                artigos.add(artigo);
            }
            return artigos;
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }  
}
