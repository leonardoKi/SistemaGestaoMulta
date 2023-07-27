/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.FormaPagamento;
import unicv.com.projetofgestaodemulta.utils.JDBCUtil;


/**
 *
 * @author Leonardo Fonseca
 */
public class FormaPagamentoDAOJdbc implements FormaPagamentoDAO {
    @Override
    public void add(FormaPagamento forma) throws DaoException {
        String sql = "INSERT INTO FormaPagamento (ID_FormaPagamento, Opcao, ID_Pagamento) VALUES (?, ?, ?)";
        try (java.sql.Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);) {
            pstmt.setInt(1, forma.getID_FormaPagamento());
            pstmt.setString(2, forma.getOpcao());
            pstmt.setObject(3, forma.getPagamento().getID_Pagamento());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                forma.setidformapagamento(id);
            }
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void remove(int ID_FormaPagamento) throws DaoException {
        String sql = "DELETE FROM FormaPagamento WHERE ID_FormaPagamento = ?";
        try (java.sql.Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ID_FormaPagamento);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

   @Override
   public void update(FormaPagamento forma) throws DaoException{
       String sql = "UPDATE FormaPagamento SET Opcao = ?, ID_Pagamento= ? WHERE ID_Formapagamento=?";
       try(java.sql.Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql))
       {
           pstmt.setString(1, forma.getOpcao());
           pstmt.setObject(2, forma.getPagamento().getID_Pagamento());
           pstmt.setInt(3, forma.getID_FormaPagamento());
           pstmt.executeUpdate();
           conn.commit();
       } catch (SQLException ex) {
   
        throw new DaoException(ex);    
                                   }
    }

   
}