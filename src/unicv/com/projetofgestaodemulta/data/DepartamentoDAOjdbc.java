/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Departamento;
import unicv.com.projetofgestaodemulta.utils.JDBCUtil;

/**
 *
 * @author Leonardo Fonseca
 */
public class DepartamentoDAOjdbc {

    public void add(Departamento departamento) throws DaoException {
        String sql = "insert into Departamento(ID_Departamento, NomeDepartamento)"
                + "values(?, ?)";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            pstmt.setInt(1, departamento.getID_Departamento());
            pstmt.setString(2, departamento.getNomeDepartamento());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                departamento.setID_Departamento(id);
            }
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    public void remove(int ID_Departamento) throws DaoException {
        String sql = "delete from Departamento where ID_Departamento = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, ID_Departamento);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    public void update(Departamento departamento) throws DaoException {
        String sql = "update Departamento set NomeDepartamento = ? where ID_Departamento = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, departamento.getNomeDepartamento());
            pstmt.setInt(2, departamento.getID_Departamento());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

}
