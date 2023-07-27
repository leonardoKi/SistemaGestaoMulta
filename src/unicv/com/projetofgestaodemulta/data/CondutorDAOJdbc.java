/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.data;

/**
 * @author Leonardo Fonseca
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.model.Condutor;
import unicv.com.projetofgestaodemulta.utils.JDBCUtil;

public class CondutorDAOJdbc implements CondutorDAO {

    @Override
    public void add(Condutor condutor) throws DaoException {
        String sql = "insert into Condutor( NomeCondutor, CNI, Sexo, Idade,Contato,ilharesidencia)"
                + "values( ?, ?, ?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            pstmt.setString(1, condutor.getNomeCondutor());
            pstmt.setString(2, condutor.getCNI());
            pstmt.setString(3, condutor.getSexo());
            pstmt.setInt(4, condutor.getIdade());
            pstmt.setInt(5, condutor.getContato());
            pstmt.setString(6, condutor.getilharesidencia());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                condutor.setIdCondutor(id);
            }
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void remove(int id) throws DaoException {
        String sql = "delete from Condutor where ID_Condutor = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void update(Condutor condutor) throws DaoException {
        String sql = "update Condutor set NomeCondutor = ?, CNI = ?, Sexo = ?, Idade = ?, Contato = ?, ilharesidencia = ? where ID_Condutor = ?";
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, condutor.getNomeCondutor());
            pstmt.setString(2, condutor.getCNI());
            pstmt.setString(3, condutor.getSexo());
            pstmt.setInt(4, condutor.getIdade());
            pstmt.setInt(5, condutor.getContato());
            pstmt.setString(6, condutor.getilharesidencia());
            pstmt.setInt(7, condutor.getID_Condutor());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public Optional<Condutor> findById(int id) throws DaoException {
        String sql = "select * from Condutor where ID_Condutor = ?";
        Optional<Condutor> optionalCondutor = Optional.empty();
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    Condutor condutor = new Condutor();
                    condutor.setIdCondutor(rs.getInt("ID_Condutor"));
                    condutor.setNomeCondutor(rs.getString("NomeCondutor"));
                    condutor.setCNI(rs.getString("CNI"));
                    condutor.setSexo(rs.getString("Sexo"));
                    condutor.setIdade(rs.getInt("Idade"));
                    condutor.setContato(rs.getInt("Contato"));
                    condutor.setIlharesidencia(rs.getString("ilharesidencia"));
                    optionalCondutor = Optional.of(condutor);
                }
                return optionalCondutor;
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public Optional<Condutor> findByCNI(String CNI) throws DaoException {
        String sql = "select * from Condutor where CNI = ?";
        Optional<Condutor> optionalCondutor = Optional.empty();
        try (Connection conn = JDBCUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, CNI);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    Condutor condutor = new Condutor();
                    condutor.setIdCondutor(rs.getInt("ID_Condutor"));
                    condutor.setNomeCondutor(rs.getString("NomeCondutor"));
                    condutor.setCNI(rs.getString("CNI"));
                    condutor.setSexo(rs.getString("Sexo"));
                    condutor.setIdade(rs.getInt("Idade"));
                    condutor.setContato(rs.getInt("Contato"));
                    condutor.setIlharesidencia(rs.getString("ilharesidencia"));
                    optionalCondutor = Optional.of(condutor);
                }
                return optionalCondutor;
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public List<Condutor> findAll() throws DaoException {
        String sql = "select * from Condutor";
        List<Condutor> condutores = new ArrayList<>();
        try (Connection conn = JDBCUtil.getConnection(); Statement stmt = conn.createStatement();) {
            try (ResultSet rs = stmt.executeQuery(sql);) {
                while (rs.next()) {
                    Condutor condutor = new Condutor();
                    condutor.setIdCondutor(rs.getInt("ID_Condutor"));
                    condutor.setNomeCondutor(rs.getString("NomeCondutor"));
                    condutor.setCNI(rs.getString("CNI"));
                    condutor.setSexo(rs.getString("Sexo"));
                    condutor.setIdade(rs.getInt("Idade"));
                    condutor.setContato(rs.getInt("Contato"));
                    condutor.setIlharesidencia(rs.getString("ilharesidencia"));
                    condutores.add(condutor);
                }
                return condutores;
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
    }

}
