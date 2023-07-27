/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.model.Artigo;
import unicv.com.projetofgestaodemulta.data.ArtigoDAO;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;

/**
 * @author Leonardo Fonseca
 */
public class ArtigoServices implements IArtigoServices {

    private final ArtigoDAO artigoDAO;

    public ArtigoServices(ArtigoDAO artigoDAO) {
        this.artigoDAO = artigoDAO;
    }

    @Override
    public void add(Artigo o) throws ServiceException {
        if (o.getNum_Artigo() <= 0) {
            throw new ServiceException("O valor da descrição é invalida");
        }
        try {
            artigoDAO.add(o);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao adicionar o Artigo. "
                    + "Revice a coneção à base de dado", ex);
        }
    }

    @Override
    public Optional<Artigo> get(int ID_Artigo) throws ServiceException {
        Optional<Artigo> optionalartigos = Optional.empty();
        try {
            optionalartigos = artigoDAO.findByIdArtigo(ID_Artigo);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao ler o Artigo. "
                    + "Revice a coneção à base de dado", ex);
        }
        return optionalartigos;
    }

    @Override
    public void update(Artigo o) throws ServiceException {
        if (o.getID_Artigo() <= 0) {
            throw new ServiceException("O valor da descrição é invalida");
        }
        try {
            artigoDAO.update(o);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao atualizar o Artigo. "
                    + "Revice a coneção à base de dado", ex);
        }
    }

    @Override
    public void remove(int ID_Artigo) throws ServiceException {
        try {
            artigoDAO.remove(ID_Artigo);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao excluir o Artigo. "
                    + "Revice a coneção à base de dados", ex);
        }
    }

    @Override
    public List<Artigo> findAll() throws ServiceException {
        List<Artigo> listaartigos = new ArrayList<>();
        try {
            listaartigos.addAll(artigoDAO.findAll());

        } catch (DaoException ex) {
            throw new ServiceException("Erro ao ler os Artigo. "
                    + "Revice a coneção à base de dados", ex);
        }
        return listaartigos;
    }

    @Override
    public Optional<Artigo> findByNumArtigo(int Num_Artigo) throws ServiceException {
        Optional<Artigo> optionalartigos = Optional.empty();
        try {
            optionalartigos = artigoDAO.findByNumArtigo(Num_Artigo);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao ler os Artigo por num-Artigo. "
                    + "Revice a conexão à base de dados", ex);
        }
        return optionalartigos;
    }

    @Override
    public Optional<Artigo> findById(int ID_Artigo) throws ServiceException {
        Optional<Artigo> optionalartigos = Optional.empty();
        try {
            optionalartigos = artigoDAO.findByIdArtigo(ID_Artigo);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao ler os Artigo por ID_Artigo. "
                    + "Revice a conexão à base de dados", ex);
        }
        return optionalartigos;
    }

    @Override
    public List<Artigo> findByValor(float ValorMulta) throws ServiceException {
        List<Artigo> listaartigos = new ArrayList<>();
        try {
            listaartigos = artigoDAO.findByValor(ValorMulta);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao ler os Artigo por Valor. "
                    + "Revice a conexão à base de dados", ex);
        }
        return listaartigos;
    }

}
