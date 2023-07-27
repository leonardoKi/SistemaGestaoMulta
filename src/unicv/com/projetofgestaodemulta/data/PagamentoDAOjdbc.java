/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Pagamento;
import unicv.com.projetofgestaodemulta.utils.JDBCUtil;

/**
 *
 * @author Leonardo Fonseca
 */
public class PagamentoDAOjdbc implements PagamentoDAO {

    @Override
    public void add(Pagamento pagamento) throws DaoException {
        String sql = "insert into Pagamento( ValorPagar, DataPagamento,  estado)"
                + "values( ?, ?, ?)";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            pstmt.setFloat(1, pagamento.getValorPagar());
            pstmt.setDate(2, Date.valueOf(pagamento.getDataPagamento()));
            pstmt.setBoolean(3, pagamento.getEstado());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                pagamento.setID_Pagamento(id);
            }
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void remove(int ID_Pagamento) throws DaoException {
        String sql = "delete from Pagamento where ID_Pagamento = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, ID_Pagamento);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void update(Pagamento pagamento) throws DaoException {
        String sql = "update Pagamento set ValorPagar = ?, DataPagamento = ?, estado = ? where ID_Pagamento = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setFloat(1, pagamento.getValorPagar());
            pstmt.setDate(2, Date.valueOf(pagamento.getDataPagamento()));
            pstmt.setBoolean(3, pagamento.getEstado());
            pstmt.setInt(4, pagamento.getID_Pagamento());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public Optional<Pagamento> findById(int ID_Pagamento) throws DaoException {
        String sql = "select * from Pagamento where ID_Pagamento = ?";
        Optional<Pagamento> optionalPagamento = Optional.empty();
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, ID_Pagamento);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    Pagamento pagamento = new Pagamento();
                    pagamento.setID_Pagamento(rs.getInt("ID_Pagamento"));
                    pagamento.setValorPagar(rs.getFloat("ValorPagar"));
                    pagamento.setDataPagamento(rs.getDate("DataPagamento").toLocalDate());
                    pagamento.setEstado(rs.getBoolean("estado"));
                    optionalPagamento = Optional.of(pagamento);
                }
                return optionalPagamento;
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public Optional<Pagamento> findByDataPagamento(LocalDate Datapagameno) throws DaoException {
        String sql = "select * from Pagamento where DataPagamento = ?";
        Optional<Pagamento> optionalPagamento = Optional.empty();
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setDate(1, Date.valueOf(Datapagameno));
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    Pagamento pagamento = new Pagamento();
                    pagamento.setID_Pagamento(rs.getInt("ID_Pagamento"));
                    pagamento.setValorPagar(rs.getFloat("ValorPagar"));
                    pagamento.setDataPagamento(rs.getDate("DataPagamento").toLocalDate());
                    pagamento.setEstado(rs.getBoolean("estado"));
                    optionalPagamento = Optional.of(pagamento);
                }
                return optionalPagamento;
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }
    @Override
    public List<Pagamento> findByEstado(boolean estado) throws DaoException {
    String sql = "SELECT * FROM Pagamento WHERE estado = ?";
    List<Pagamento> pagamentos = new ArrayList<>();
    try (Connection conn = JDBCUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setBoolean(1, estado);
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.setID_Pagamento(rs.getInt("ID_Pagamento"));
                pagamento.setValorPagar(rs.getFloat("ValorPagar"));
                pagamento.setDataPagamento(rs.getDate("DataPagamento").toLocalDate());
                pagamento.setEstado(rs.getBoolean("estado"));
                // Set Multa object
                pagamentos.add(pagamento);
            }
            return pagamentos;
        }
    } catch (SQLException ex) {
        throw new DaoException(ex);
    }
}

    @Override
public List<Pagamento> findAll() throws DaoException {
    String sql = "SELECT * FROM Pagamento";
    List<Pagamento> pagamentos = new ArrayList<>();
    try (Connection conn = JDBCUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.setID_Pagamento(rs.getInt("ID_Pagamento"));
                pagamento.setValorPagar(rs.getFloat("ValorPagar"));
                pagamento.setDataPagamento(rs.getDate("DataPagamento").toLocalDate());
                pagamento.setEstado(rs.getBoolean("estado"));
                // Set Multa object
                pagamentos.add(pagamento);
            }
            return pagamentos;
        }
    } catch (SQLException ex) {
        throw new DaoException(ex);
    }
}


}
