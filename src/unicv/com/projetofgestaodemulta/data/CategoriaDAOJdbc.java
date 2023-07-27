/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Categoria;
import unicv.com.projetofgestaodemulta.utils.JDBCUtil;
import java.sql.*;
import unicv.com.projetofgestaodemulta.model.Multado;

/**
 *
 * @author Leonardo Fonseca
 */
public class CategoriaDAOJdbc implements CategoriaDAO {

    @Override
    public void add(Categoria categoria) throws DaoException {
        String sql = "insert into Categoria(ID_Categoria, Identificacao, ID_Multado)"
                + "values(?, ?, ?)";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            pstmt.setInt(1, categoria.getIDcategoria());
            pstmt.setString(2, categoria.getIdentificacao());
            pstmt.setInt(3, categoria.getMultado().getID_Multado());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                categoria.setIDcategoria(id);
            }
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void remove(int idCategoria) throws DaoException {
        String sql = "delete from Categoria where ID_Categoria = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, idCategoria);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void update(Categoria categoria) throws DaoException {
        String sql = "update Categoria set Identificacao = ?, ID_Multado = ? where ID_Categoria = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, categoria.getIdentificacao());
            pstmt.setInt(2, categoria.getMultado().getID_Multado());
            pstmt.setInt(3, categoria.getIDcategoria());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public Optional<Categoria> findById(int idCategoria) throws DaoException {
        String sql = "select * from Categoria where ID_Categoria = ?";
        Optional<Categoria> optionalCategoria = Optional.empty();
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, idCategoria);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setIDcategoria(rs.getInt("ID_Categoria"));
                    categoria.setIdentificacao(rs.getString("Identificacao"));
                    Multado multado = new Multado();
                    multado.setID_Multado(rs.getInt("ID_Multado"));
                    categoria.setMultado(multado);
                    optionalCategoria = Optional.of(categoria);
                }
                return optionalCategoria;
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }
}


