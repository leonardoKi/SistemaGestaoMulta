/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import java.sql.*;
import unicv.com.projetofgestaodemulta.model.SistemadeMulta;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.utils.JDBCUtil;
/**
 *
 * @author Leonardo Fonseca
 */
public class SistemaMultaDAOJdbc implements SistemaMultaDAO {

    @Override
    public void add(SistemadeMulta sistema) throws DaoException {
        String sql = "INSERT INTO SistemaMulta (ID_SistemaMulta, DataHoje, ID_Administrador) VALUES (?, ?, ?)";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            pstmt.setObject(1, sistema.getID_SistemaMulta());
            pstmt.setObject(2, sistema.getDataHoje());
            pstmt.setObject(3, sistema.getAdministrador().getID_Administrador());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                sistema.setID_SistemaMulta(id);
            }
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void remove(int idsistema) throws DaoException {
        String sql = "DELETE FROM SistemaMulta WHERE ID_SistemaMulta = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idsistema);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void removeAllBySistemadeMulta(SistemadeMulta sistema) throws DaoException {
        String sql = "DELETE FROM SistemaMulta WHERE ID_SistemaMulta = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, sistema.getID_SistemaMulta());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void update(SistemadeMulta sistema) throws DaoException {
        String sql = "UPDATE SistemaMulta SET DataHoje = ?, ID_Administrador = ? WHERE ID_SistemaMulta = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, sistema.getDataHoje());
            pstmt.setObject(2, sistema.getAdministrador());
            pstmt.setInt(3, sistema.getID_SistemaMulta());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }
}
