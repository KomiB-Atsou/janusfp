/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.web.html.table.provider;

import com.c353.bicomat.services.common.IService;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.util.SingleSortState;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 *
 * @author komilo
 */
public class CRUDDataProvider<T, PK extends Serializable> implements IDataProvider<T>, ISortStateLocator<T> {

    private IService<T, PK> service;
    private List<T> liste;
    private final SingleSortState<T> state = new SingleSortState<>();

    public CRUDDataProvider(IService<T, PK> service) {
        this.service = service;
    }

    public List<T> getListe() {
        return liste;
    }

    public void setListe(List<T> liste) {
        this.liste = liste;
    }

    public CRUDDataProvider(IService<T, PK> service, List<T> liste) {
        this(service);
        this.liste = liste;
    }

    @Override
    public Iterator<? extends T> iterator(long debut, long nombre) {
        if (service != null) {
            return service.lister().subList(Long.valueOf(debut).intValue(),
                    Long.valueOf(debut + nombre).intValue()).iterator();
        } else {
            return liste.subList(Long.valueOf(debut).intValue(),
                    Long.valueOf(debut + nombre).intValue()).iterator();
        }
    }

    @Override
    public long size() {
        if (this.service != null) {
            return service.count();
        } else if (liste.isEmpty()) {
            return 0;
        } else {
            return liste.size();
        }
    }

    @Override
    public IModel<T> model(final T object) {
        return new LoadableDetachableModel<T>() {
            @Override
            protected T load() {
                return object;
            }
        };
    }

    @Override
    public void detach() {

    }

    @Override
    public ISortState<T> getSortState() {
        return state;
    }
}
