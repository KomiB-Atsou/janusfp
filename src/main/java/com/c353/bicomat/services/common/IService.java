/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.services.common;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author 
 * @param <T>
 * @param <PK>
 */
public interface IService<T, PK extends java.io.Serializable> {

    public T ajouter(T t);

    public T modifier(T t);

    public boolean supprimer(T t);

    public boolean supprimer(PK pk);

    public Optional<T> selectionner(PK k);

    public List<T> lister();

    public void supprimer(PK[] pks);

    public void supprimer();

    public void ajouter(Collection<T> ts);

    public void modifier(Collection<T> ts);

    public Long count();
}
