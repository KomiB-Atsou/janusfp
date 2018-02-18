/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.web.banque;

import com.c353.bicomat.entities.banque.Banque;
import com.c353.bicomat.services.common.IService;
import com.c353.bicomat.web.base.BaseListePanel;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import com.c353.bicomat.services.common.banque.IBanqueDefaultService;


public class BanqueListPanel extends BaseListePanel<Banque, Integer> {

    @SpringBean
    private IBanqueDefaultService banqueService;

    public BanqueListPanel(String id) {
        super(id);
    }

    @Override
    protected void addFormComponents(Form<Banque> form) {
    }

    @Override
    protected List getColumns(List columns) {
        columns.add(new PropertyColumn<>(
                Model.of(getString("table.nom")), "nom"));
        columns.add(new PropertyColumn<>(
                Model.of(getString("table.adresse")), "adresse"));
        return columns;
    }

    @Override
    protected void getColumnsAction(List<IColumn<Banque, Sort>> columns) {
        columns.add(new AbstractColumn<Banque, Sort>(Model.of(getString("table.actions"))) {
            @Override
            public void populateItem(Item<ICellPopulator<Banque>> cellItem, String componentId, IModel<Banque> rowModel) {
                cellItem.add(new ActionPanel(componentId, getResponsePageClass(),
                        getId(rowModel.getObject())));
            }
        });
    }

    private class ActionPanel extends Panel {

        public ActionPanel(String id, Class clazz, String modelId) {
            super(id);
            add(new BookmarkablePageLink("modifier", getResponsePageClass(),
                    new PageParameters().add("id", modelId).add("action", "edit")));
            add(new BookmarkablePageLink("supprimer", getResponsePageClass(),
                    new PageParameters().add("id", modelId).add("action", "delete")));
            add(new BookmarkablePageLink("activerDesactiver", BanquePage.class,
                    new PageParameters().add("idBanque", modelId)));
        }
    }

    @Override
    protected IService getService() {
        return banqueService;
    }

    @Override
    protected String getId(Banque t) {
        try {
            return t.getIdBanque().toString();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected Class getResponsePageClass() {
        return BanquePage.class;
    }

}
