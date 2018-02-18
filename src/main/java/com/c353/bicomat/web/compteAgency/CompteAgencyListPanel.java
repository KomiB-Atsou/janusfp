
package com.c353.bicomat.web.compteAgency;

import com.c353.bicomat.web.fp.ComptePage;
import com.c353.bicomat.entities.agency.CompteAgency;
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


public class CompteAgencyListPanel extends BaseListePanel<CompteAgency, Integer> {

    @SpringBean
    private ICompteAgencyDefaultService compteAgencyService;

    public CompteAgencyListPanel(String id) {
        super(id);
    }

    @Override
    protected void addFormComponents(Form<CompteAgency> form) {
    }

    @Override
    protected List getColumns(List columns) {
        columns.add(new PropertyColumn<>(
                Model.of(getString("table.login")), "login"));
        columns.add(new PropertyColumn<>(
                Model.of(getString("table.motDePasse")), "motDePasse"));
        return columns;
    }

    @Override
    protected void getColumnsAction(List<IColumn<CompteAgency, Sort>> columns) {
        columns.add(new AbstractColumn<CompteAgency, Sort>(Model.of(getString("table.actions"))) {
            @Override
            public void populateItem(Item<ICellPopulator<CompteAgency>> cellItem, String componentId, IModel<CompteAgency> rowModel) {
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
        return compteAgencyService;
    }

    @Override
    protected String getId(CompteAgency t) {
        try {
            return t.getIdClient().toString();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected Class getResponsePageClass() {
        return ComptePage.class;
    }

}
