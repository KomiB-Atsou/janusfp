
package com.c353.bicomat.web.fp;

import com.c353.bicomat.entities.Compte;
import com.c353.bicomat.entities.agency.CompteAgency;
import com.c353.bicomat.services.ICompteService;
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
import com.c353.bicomat.services.common.agency.ICompteAgencyDefaultService;


public class CompteListPanel extends BaseListePanel<Compte, Integer> {

    @SpringBean
    private ICompteService compteService;

    public CompteListPanel(String id) {
        super(id);
    }

    @Override
    protected void addFormComponents(Form<Compte> form) {
    }

    @Override
    protected List getColumns(List columns) {
        columns.add(new PropertyColumn<>(
                Model.of(getString("table.libelle")), "libelle"));
        columns.add(new PropertyColumn<>(
                Model.of(getString("table.soldeCourant")), "soldeCourant"));
        return columns;
    }

    @Override
    protected void getColumnsAction(List<IColumn<Compte, Sort>> columns) {
        columns.add(new AbstractColumn<Compte, Sort>(Model.of(getString("table.actions"))) {
            @Override
            public void populateItem(Item<ICellPopulator<Compte>> cellItem, String componentId, IModel<Compte> rowModel) {
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
            add(new BookmarkablePageLink("activerDesactiver", ComptePage.class,
                    new PageParameters().add("idCompteAgency", modelId)));
        }
    }

    @Override
    protected IService getService() {
        return compteService;
    }

    @Override
    protected String getId(Compte t) {
        try {
            return t.getId().toString();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected Class getResponsePageClass() {
        return ComptePage.class;
    }

}
