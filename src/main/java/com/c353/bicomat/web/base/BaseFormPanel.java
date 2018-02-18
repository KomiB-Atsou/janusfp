/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.web.base;

import com.c353.bicomat.services.common.IService;
import com.c353.bicomat.web.html.panel.FeedbackPanel;
import java.io.Serializable;
import java.util.Map;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.lang.Bytes;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.Visit;

/**
 *
 * @author RODRIGUE
 */
public abstract class BaseFormPanel<T, PK extends Serializable> extends Panel {

    public BaseFormPanel(String id) {
        super(id);
    }

    public BaseFormPanel(String id, T t) {
        super(id);
        EditForm editForm = new EditForm("editform", t);
        editForm.setMultiPart(true);
        editForm.setMaxSize(Bytes.kilobytes(5000));
        addComponents(editForm);
        add(editForm);
    }

    public class EditForm extends Form<T> {

        public EditForm(String id, IModel<T> model) {
            super(id, model);
        }

        public EditForm(String id, T imf) {
            super(id, new CompoundPropertyModel(imf));
        }

        @Override
        protected void onSubmit() {
            enregistrer(getModelObject());
        }
    }

    protected abstract IService<T, PK> getService();

    protected abstract String getId(T t);

    protected void addComponents(EditForm editForm) {
    }

    protected void enregistrer(T imf) {
        try {
            if (getId(imf) == null) {
                getService().ajouter(imf);
            } else {
                getService().modifier(imf);
            }
            setResponsePage(getResponsePageClass());
        } catch (Exception e) {
            error(e);
        }
    }

    protected void updateFeedBackMessages(AjaxRequestTarget target) {
        target.addListener(new AjaxRequestTarget.IListener() {
            @Override
            public void onBeforeRespond(Map<String, Component> map, final AjaxRequestTarget target) {
                target.getPage().visitChildren(FeedbackPanel.class, (FeedbackPanel t, IVisit<Object> ivisit) -> {
                    target.add(t);
                    ivisit = new Visit<>();
                });
            }

            @Override
            public void onAfterRespond(Map<String, Component> map, AjaxRequestTarget.IJavaScriptResponse response) {
            }

            @Override
            public void updateAjaxAttributes(AbstractDefaultAjaxBehavior adab, AjaxRequestAttributes ara) {
            }
        });
    }

    protected abstract Class getResponsePageClass();
}
