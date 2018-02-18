/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.web.base;

import com.c353.bicomat.services.common.IService;
import com.c353.bicomat.web.html.table.provider.CRUDDataProvider;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackHeadersToolbar;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxNavigationToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NoRecordsToolbar;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author 
 */
public abstract class BaseListePanel<T, PK extends java.io.Serializable> extends Panel {

    private SimpleDateFormat simpleDateFormat;
    private SimpleDateFormat simpleDateCompletFormat;

    public BaseListePanel(String id) {
        super(id);
        this.addFormBoutons();
        this.simpleDateFormat = new SimpleDateFormat(getDateFormat());
        this.simpleDateCompletFormat = new SimpleDateFormat(getDateCompletFormat());
    }

    private void addFormBoutons() {
        Form<T> form = new Form<T>("form");

        form.add(getDataTable());
        form.setMultiPart(true);
        this.addFormComponents(form);
        this.add(form);

    }

    public String getDateFormat() {
        return "dd/MM/yyyy";
    }

    private String getDateCompletFormat() {
        return "dd-MM-yyyy hh-mm-ss";
    }

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public SimpleDateFormat getSimpleDateCompletFormat() {
        return simpleDateCompletFormat;
    }

    protected void addFormComponents(Form<T> form) {
    }

    private DataTable<T, Sort> getDataTable() {
        List<IColumn<T, Sort>> columns = new LinkedList<>();
        getColumns(columns);
        getColumnsAction(columns);
        CRUDDataProvider<T, PK> crudDataProvider = new CRUDDataProvider<T, PK>(getService());
        crudDataProvider.setListe(getList());
        DataTable<T, Sort> dateTable = new DataTable("table", columns, crudDataProvider, 10);
        dateTable.addBottomToolbar(new AjaxNavigationToolbar(dateTable));
        dateTable.addBottomToolbar(new NoRecordsToolbar(dateTable));
        dateTable.addTopToolbar(new AjaxNavigationToolbar(dateTable));
        dateTable.addTopToolbar(new AjaxFallbackHeadersToolbar(dateTable, crudDataProvider));
        return dateTable;
    }

    protected List<T> getList() {
        return null;
    }

    protected abstract List<IColumn<T, Sort>> getColumns(List<IColumn<T, Sort>> columns);

    protected void getColumnsAction(List<IColumn<T, Sort>> columns) {
        columns.add(new AbstractColumn<T, Sort>(Model.of(getString("table.actions"))) {

            @Override
            public void populateItem(Item<ICellPopulator<T>> cellItem, String componentId, IModel<T> rowModel) {
                cellItem.add(new BaseListePanel.ActionPanel(componentId, getResponsePageClass(),
                        getId(rowModel.getObject())));
            }
        });
    }

    protected abstract IService<T, PK> getService();

    protected abstract String getId(T t);

    private class ActionPanel extends Panel {

        public ActionPanel(String id, Class clazz, String modelId) {
            super(id);
            add(new BookmarkablePageLink("modifier", clazz,
                    new PageParameters().add("id", modelId).add("action", "edit")));
            add(new BookmarkablePageLink("supprimer", clazz,
                    new PageParameters().add("id", modelId).add("action", "delete")));
        }
    }

    public class Sort {

    }

    protected abstract Class getResponsePageClass();
}
