/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import unicv.com.projetofgestaodemulta.data.CondutorDAO;
import unicv.com.projetofgestaodemulta.execeptions.DaoException;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.Condutor;

/**
 *
 * @author Leonardo Fonseca
 */
public class CondutorServices implements ICondutorServices{
    private final CondutorDAO condutorDAO;

    public CondutorServices(CondutorDAO condutorDAO) {
        this.condutorDAO = condutorDAO;
    }

      @Override
    public Optional<Condutor> get(int ID_Condutor) throws ServiceException {
        Optional<Condutor> optionalartigos = Optional.empty();
        try {
            optionalartigos = condutorDAO.findById(ID_Condutor);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao ler o Condutor. "
                    + "Revice a coneção à base de dado", ex);
        }
        return optionalartigos;
    }
    
    
      @Override
    public void add(Condutor o) throws ServiceException {
        if (o.getIdade()<=17) {
            throw new ServiceException("Idade do condutor tem que ser maior de 17");
        }
        try {
            condutorDAO.add(o);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao adicionar o Artigo. "
                    + "Revice a coneção à base de dado", ex);
        }
    }

      @Override
    public void update(Condutor o) throws ServiceException {
        if (o.getIdade()<=17) {
            throw new ServiceException("Idade do condutor tem que ser maior de 17");
        }
        try {
            condutorDAO.update(o);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao atualizar o condutor.", ex);
        }
    }
  @Override
    public void remove(int ID_Condutor) throws ServiceException {
        try {
            condutorDAO.remove(ID_Condutor);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao remover o condutor.", ex);
        }
    }
    @Override
    public Optional<Condutor> findById(int ID_Condutor) throws ServiceException {
        Optional<Condutor> optionalCondutor = Optional.empty();
        try {
            optionalCondutor = condutorDAO.findById(ID_Condutor);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao encontrar o condutor pelo ID.", ex);
        }
        return optionalCondutor;
    }

    @Override
    public Optional<Condutor> findByCNI(String CNI) throws ServiceException {
        Optional<Condutor> optionalCondutor = Optional.empty();
        try {
            optionalCondutor = condutorDAO.findByCNI(CNI);
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao encontrar o condutor pelo CNI.", ex);
        }
        return optionalCondutor;
    }

    @Override
    public List<Condutor> findAll() throws ServiceException {
        List<Condutor> listaCondutores = new ArrayList<>();
        try {
            listaCondutores.addAll(condutorDAO.findAll());
        } catch (DaoException ex) {
            throw new ServiceException("Erro ao encontrar todos os condutores.", ex);
        }
        return listaCondutores;
    }

   
}

