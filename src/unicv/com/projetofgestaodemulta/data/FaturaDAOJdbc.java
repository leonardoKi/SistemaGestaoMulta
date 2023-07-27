/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import java.sql.*;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Fatura;
import unicv.com.projetofgestaodemulta.utils.JDBCUtil;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import unicv.com.projetofgestaodemulta.model.Pagamento;

/**
 *
 * @author Leonardo Fonseca
 */
public class FaturaDAOJdbc implements FaturaDAO {

    @Override
    public void add(Fatura fatura) throws DaoException {
        String sql = "insert into Fatura( DataFatura, ID_Pagamento)"
                + "values( ?, ?)";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);) {
            pstmt.setObject(1, fatura.getDataFatura());
            pstmt.setObject(2, fatura.getPagamento().getID_Pagamento());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                fatura.setID_Fatura(id);
            }
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void remove(int idfatura) throws DaoException {
        String sql = "delete from Fatura where ID_Fatura = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, idfatura);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public Optional<Fatura> findById(int idfatura) throws DaoException {
        String sql = "SELECT Fatura.ID_Fatura, Fatura.DataFatura, Pagamento.ID_Pagamento, Pagamento.ValorPagar "
                + "FROM Fatura "
                + "JOIN Pagamento ON Faturas.ID_Pagamento = Pagamento.ID_Pagamento "
                + "WHERE Fatura.ID_Fatura = ?";
        Optional<Fatura> optionalFatura = Optional.empty();
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, idfatura);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    Fatura fatura = new Fatura();
                    fatura.setID_Fatura(rs.getInt("ID_Fatura"));
                    fatura.setDataFatura(rs.getObject("DataFatura", LocalDate.class));
                    Pagamento pagamento = new Pagamento();
                    pagamento.setID_Pagamento(rs.getInt("ID_Pagamento"));
                    pagamento.setValorPagar(rs.getFloat("ValorPagar"));
                    fatura.setPagamento(pagamento);
                    optionalFatura = Optional.of(fatura);
                }
                return optionalFatura;
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

}
