/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

/**
 *
 * @author Leonardo Fonseca
 */
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Veiculo;
import unicv.com.projetofgestaodemulta.utils.JDBCUtil;

public class VeiculoDAOJdbc implements VeiculoDAO {

    @Override
    public void add(Veiculo veiculo) throws DaoException {
        String sql = "insert into Veiculo(Placa, Num_Identificao, DataExpecao, Peso, Lotacao, Descricao)"
                + "values( ?, ?, ?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            pstmt.setString(1, veiculo.getPlaca());
            pstmt.setInt(2, veiculo.getNum_Identificao());
            pstmt.setObject(3, veiculo.getDataExpecao());
            pstmt.setFloat(4, veiculo.getPeso());
            pstmt.setInt(5, veiculo.getLotacao());
            pstmt.setString(6, veiculo.getDescricao());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                veiculo.setID_Veiculo(id);
            }
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void remove(int id) throws DaoException {
        String sql = "delete from Veiculo where ID_Veiculo = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void update(Veiculo veiculo) throws DaoException {
        String sql = "update Veiculo set  Placa = ?, Num_Identificao = ?, DataExpecao = ?, Peso = ?, Lotacao = ?, Descricao = ? where ID_Veiculo = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, veiculo.getPlaca());
            pstmt.setInt(2, veiculo.getNum_Identificao());
            pstmt.setObject(3, veiculo.getDataExpecao());
            pstmt.setFloat(4, veiculo.getPeso());
            pstmt.setInt(5, veiculo.getLotacao());
            pstmt.setString(6, veiculo.getDescricao());
            pstmt.setInt(7, veiculo.getID_Veiculo());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }


   @Override
public Optional<Veiculo> findById(int ID_Veiculo) throws DaoException {
    String sql = "SELECT * FROM Veiculo WHERE ID_Veiculo = ?";
    Optional<Veiculo> optionalVeiculo = Optional.empty();
    try (Connection conn = JDBCUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, ID_Veiculo);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setID_Veiculo(rs.getInt("ID_Veiculo"));
                veiculo.setPlaca(rs.getString("Placa"));
                veiculo.setNum_Identificao(rs.getInt("Num_Identificao"));
                veiculo.setDataExpecao(rs.getObject("DataExpecao", LocalDate.class));
                veiculo.setPeso(rs.getFloat("Peso"));
                veiculo.setLotacao(rs.getInt("Lotacao"));
                veiculo.setDescricao(rs.getString("Descricao"));
                optionalVeiculo = Optional.of(veiculo);
            }
            return optionalVeiculo;
        }
    } catch (SQLException ex) {
        throw new DaoException(ex);
    }
}

   @Override
public Optional<Veiculo> findByPlaca(String Placa) throws DaoException {
    String sql = "SELECT * FROM Veiculo WHERE Placa = ?";
    Optional<Veiculo> optionalVeiculo = Optional.empty();
    try (Connection conn = JDBCUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, Placa);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setID_Veiculo(rs.getInt("ID_Veiculo"));
                veiculo.setPlaca(rs.getString("Placa"));
                veiculo.setNum_Identificao(rs.getInt("Num_Identificao"));
                veiculo.setDataExpecao(rs.getObject("DataExpecao", LocalDate.class));
                veiculo.setPeso(rs.getFloat("Peso"));
                veiculo.setLotacao(rs.getInt("Lotacao"));
                veiculo.setDescricao(rs.getString("Descricao"));
                 optionalVeiculo = Optional.of(veiculo);
            }
            return optionalVeiculo;
        }
    } catch (SQLException ex) {
        throw new DaoException(ex);
    }
}

    @Override
public List<Veiculo> findByIdentificacao(int Num_Identificacao) throws DaoException {
    List<Veiculo> veiculos = new ArrayList<>();
    String sql = "SELECT * FROM Veiculo WHERE Num_Identificao = ?";
    try (Connection conn = JDBCUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, Num_Identificacao);
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setID_Veiculo(rs.getInt("ID_Veiculo"));
                veiculo.setPlaca(rs.getString("Placa"));
                veiculo.setNum_Identificao(rs.getInt("Num_Identificao"));
                veiculo.setDataExpecao(rs.getObject("DataExpecao", LocalDate.class));
                veiculo.setPeso(rs.getFloat("Peso"));
                veiculo.setLotacao(rs.getInt("Lotacao"));
                veiculo.setDescricao(rs.getString("Descricao"));
                veiculos.add(veiculo);
            }
        }
    } catch (SQLException ex) {
        throw new DaoException(ex);
    }
    return veiculos;
}


   @Override
public List<Veiculo> findAll() throws DaoException {
    String sql = "SELECT * FROM Veiculo";
    List<Veiculo> veiculos = new ArrayList<>();
    try (Connection conn = JDBCUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {
        while (rs.next()) {
            Veiculo veiculo = new Veiculo();
            veiculo.setID_Veiculo(rs.getInt("ID_Veiculo"));
            veiculo.setPlaca(rs.getString("Placa"));
            veiculo.setNum_Identificao(rs.getInt("Num_Identificao"));
            veiculo.setDataExpecao(rs.getObject("DataExpecao", LocalDate.class));
            veiculo.setPeso(rs.getFloat("Peso"));
            veiculo.setLotacao(rs.getInt("Lotacao"));
            veiculo.setDescricao(rs.getString("Descricao"));
            veiculos.add(veiculo);
        }
        return veiculos;
    } catch (SQLException ex) {
        throw new DaoException(ex);
    }
}


}
