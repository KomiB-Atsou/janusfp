package com.c353.bicomat.web.base.selecteur;

import com.c353.bicomat.services.common.IService;
import com.c353.bicomat.web.html.table.provider.CRUDDataProvider;
import java.util.LinkedList;
import java.util.List;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackHeadersToolbar;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxNavigationToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NoRecordsToolbar;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public abstract class BaseSelecteurListPanel<T, PK extends java.io.Serializable> extends Panel {

    public BaseSelecteurListPanel(String id) {
        super(id);
        add(getDataTable());
    }

    private DataTable<T, Sort> getDataTable() {
        List<IColumn<T, Sort>> columns = new LinkedList<>();
        getColumns(columns);
        columns.add(new AbstractColumn<T, Sort>(Model.of(getString("table.actions"))) {

            @Override
            public void populateItem(Item<ICellPopulator<T>> cellItem, String componentId, IModel<T> rowModel) {
                cellItem.add(new ActionPanel(componentId, rowModel.getObject()));
            }
        });
        CRUDDataProvider<T, PK> crudDataProvider = new CRUDDataProvider<T, PK>(getService());
        crudDataProvider.setListe(getList());
        DataTable<T, Sort> dateTable = new DataTable("table", columns, crudDataProvider, 10);
        dateTable.addBottomToolbar(new AjaxNavigationToolbar(dateTable));
        dateTable.addBottomToolbar(new NoRecordsToolbar(dateTable));
        dateTable.addTopToolbar(new AjaxNavigationToolbar(dateTable));
        dateTable.addTopToolbar(new AjaxFallbackHeadersToolbar(dateTable, crudDataProvider));
        return dateTable;
    }

    protected abstract List<IColumn<T, Sort>> getColumns(List<IColumn<T, Sort>> columns);

    protected abstract IService<T, PK> getService();

    protected List<T> getList() {
        return null;
    }

    protected abstract String getId(T t);

    private class ActionPanel extends Panel {

        public ActionPanel(String id, final T model) {
            super(id);
            add(new AjaxLink("selection") {

                @Override
                public void onClick(AjaxRequestTarget art) {
                    onSelection(model, art);
                }
            });
        }
    }

    protected abstract void onSelection(T model, AjaxRequestTarget art);

    public class Sort {

    }
}
