/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Multado;
import unicv.com.projetofgestaodemulta.utils.JDBCUtil;

/**
 *
 * @author Leonardo Fonseca
 */
public class MultadoDAOjdbc implements MultadoDAO {

    @Override
    public void add(Multado multado) throws DaoException {
        String sql = "insert into Multado(ID_Multado, ID_Multa)"
                + "values(?, ?)";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            pstmt.setInt(1, multado.getID_Multado());
            pstmt.setInt(2, multado.getMultas().getID_Multa());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                multado.setID_Multado(id);
            }
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void remove(int idMultado) throws DaoException {
        String sql = "delete from Multado where ID_Multado = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, idMultado);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void update(Multado multado) throws DaoException {
        String sql = "update Multado set ID_Multa = ? where ID_Multado = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, multado.getMultas().getID_Multa());
            pstmt.setInt(2, multado.getID_Multado());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }
}

