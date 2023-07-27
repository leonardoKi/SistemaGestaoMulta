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
import unicv.com.projetofgestaodemulta.utils.JDBCUtil;

/*
 * @author Leonardo Fonseca
 */
public class AdministradorDAOjdbc {

    public void add(Administrador administrador) throws DaoException {
        String sql = "insert into Administrador( Nome_Administrador, ID_Departamento)"
                + "values( ?, ?)";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            pstmt.setString(1, administrador.getNome_Administrador());
            pstmt.setInt(2, administrador.getDepartamento().getID_Departamento());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                administrador.setID_Administrador(id);
            }
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    public void remove(int ID_Administrador) throws DaoException {
        String sql = "delete from Administrador "
                + "where Administrador = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, ID_Administrador);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    public void update(Administrador administrador) throws DaoException {
        String sql = "update Administrador set Nome_Administrador = ?, ID_Departamento = ? "
                + "where ID_Administrador = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, administrador.getNome_Administrador());
            pstmt.setInt(2, administrador.getDepartamento().getID_Departamento());
            pstmt.setInt(3, administrador.getID_Administrador());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    public Optional<Administrador> findByIdAdministrador(int ID_Administrador) throws DaoException {
        String sql = "select * from Administrador "
                + "where ID_Administrador = ?";
        Optional<Administrador> optionalAdministrador = Optional.empty();
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, ID_Administrador);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    Administrador administrador = new Administrador();
                    administrador.setID_Administrador(rs.getInt("ID_Administrador"));
                    administrador.setNome_Administrador(rs.getString("Nome_Administrador"));
                    Departamento departamento = new Departamento();
                    departamento.setID_Departamento(rs.getInt("ID_Departamento"));
                    administrador.setDepartamento(departamento);
                    optionalAdministrador = Optional.of(administrador);
                }

                return optionalAdministrador;
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

}
