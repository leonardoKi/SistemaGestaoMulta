/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.data.CategoriaDAO;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.Categoria;

/**
 *
 * @author Leonardo Fonseca
 */
public class CategoriaServices implements ICategoriaServices {

    private final CategoriaDAO categoriaDAO;

    public CategoriaServices(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    @Override
    public void add(Categoria categoria) throws ServiceException {
        if (categoria.getIdentificacao().isBlank()) {
            throw new ServiceException("O valor da descrição é inválido");
        }
        try {
            categoriaDAO.add(categoria);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao adicionar a categoria. "
                    + "Revise a conexão à base de dados", ex);
        }
    }

    @Override
    public void remove(int ID_Categoria) throws ServiceException {
        try {
            categoriaDAO.remove(ID_Categoria);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao remover a categoria.", ex);
        }
    }

    @Override
    public void update(Categoria categoria) throws ServiceException {
        try {
            categoriaDAO.update(categoria);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao atualizar a categoria.", ex);
        }
    }

    @Override
    public Optional<Categoria> findById(int ID_Categoria) throws ServiceException {
        Optional<Categoria> optionalCategoria = Optional.empty();
        try {
            optionalCategoria = categoriaDAO.findById(ID_Categoria);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao encontrar a categoria pelo ID.", ex);
        }
        return optionalCategoria;
    }

    @Override
    public Optional<Categoria> get(int ID_Categoria) throws ServiceException {
        Optional<Categoria> optionalCategoria = Optional.empty();
        try {
            optionalCategoria = categoriaDAO.findById(ID_Categoria);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao ler o Administrador. "
                    + "Revice a coneção à base de dado", ex);
        }
        return optionalCategoria;
    }

    @Override
    public List<Categoria> findAll() throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
