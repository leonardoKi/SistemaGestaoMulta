/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Administrador;
import unicv.com.projetofgestaodemulta.model.Departamento;
import unicv.com.projetofgestaodemulta.model.licenca;
import unicv.com.projetofgestaodemulta.utils.JDBCUtil;

/**
 *
 * @author Leonardo Fonseca
 */
public class licencaDAOjdbc implements licencaDAO {

    @Override
    public void add(licenca licencas) throws DaoException {
        String sql = "insert into Licenca(ID_Licenca, Num_Licenca, ID_Condutor, Suspensa)"
                + "values(?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            pstmt.setInt(1, licencas.getID_Licenca());
            pstmt.setInt(2, licencas.getNum_Licenca());
            pstmt.setInt(3, licencas.getCondutor().getID_Condutor());
            pstmt.setBoolean(4, licencas.isSuspensa());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                licencas.setID_Licenca(id);
            }
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void remove(int ID_Licenca) throws DaoException {
        String sql = "delete from Licenca where ID_Licenca = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, ID_Licenca);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void removeAllByLicenca(licenca licencas) throws DaoException {
        // This method is not applicable to the provided schema and should be removed from the interface.
    }

    @Override
    public void update(licenca licencas) throws DaoException {
        String sql = "update Licenca set Num_Licenca = ?, ID_Condutor = ?, Suspensa = ? where ID_Licenca = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, licencas.getNum_Licenca());
            pstmt.setInt(2, licencas.getCondutor().getID_Condutor());
            pstmt.setBoolean(3, licencas.isSuspensa());
            pstmt.setInt(4, licencas.getID_Licenca());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }
}
