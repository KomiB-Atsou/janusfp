/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.services.common.impl;

import com.c353.bicomat.services.common.IService;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Fabrice
 * @param <T>
 * @param <PK>
 */
public abstract class DefaultService<T, PK extends java.io.Serializable> implements IService<T, PK> {

    public abstract JpaRepository<T, PK> getDao();

    @Override
    public synchronized T ajouter(T t) {
        return this.getDao().save(t);
    }

    @Override
    public synchronized T modifier(T t) {
        return this.getDao().saveAndFlush(t);
    }

    @Override
    public synchronized boolean supprimer(PK k) {
        try {
            this.getDao().delete(k);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DefaultService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public synchronized boolean supprimer(T t) {
        try {
            this.getDao().delete(t);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DefaultService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Optional<T> selectionner(PK k) {
        try {
            return Optional.of(this.getDao().findOne(k));
        } catch (EmptyResultDataAccessException ex) {
        } catch (Exception ex) {
        }
        return Optional.empty();
    }

    @Override
    public List<T> lister() {
        try {
            return this.getDao().findAll();
        } catch (Exception ex) {
            Logger.getLogger(DefaultService.class.getName()).log(Level.SEVERE, null, ex);
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public void supprimer(PK[] pks) {
        for (PK pk : pks) {
            try {
                this.getDao().delete(pk);
            } catch (Exception ex) {
                Logger.getLogger(DefaultService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Voir {@link IService#ajouter(java.util.Collection) }
     *
     * @param ts
     */
    @Override
    public void ajouter(Collection<T> ts) {
        ts.stream().forEach(t -> this.ajouter(t));
    }

    /**
     * Voir {@link IService#modifier(java.util.Collection) }
     *
     * @param ts
     */
    @Override
    public void modifier(Collection<T> ts) {
        ts.stream().forEach(t -> this.modifier(t));
    }

    @Override
    public void supprimer() {
        try {
            this.getDao().deleteAll();
        } catch (Exception ex) {
            Logger.getLogger(DefaultService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Long count() {
        return this.getDao().count();
    }

}
