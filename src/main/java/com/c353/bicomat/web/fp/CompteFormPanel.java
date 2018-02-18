/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.web.fp;

import com.c353.bicomat.entities.Compte;
import com.c353.bicomat.services.ICompteService;
import com.c353.bicomat.services.common.IService;
import com.c353.bicomat.web.base.BaseFormPanel;
import org.apache.wicket.markup.html.form.HiddenField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.spring.injection.annot.SpringBean;


public class CompteFormPanel extends BaseFormPanel<Compte, Integer> {

    @SpringBean
    private ICompteService compteService;

    public CompteFormPanel(String id) {
        super(id);
    }

    public CompteFormPanel(String id, Compte t) {
        super(id, t);
    }

    @Override
    protected void addComponents(EditForm editForm) {
        editForm.add(new HiddenField("id"));
        editForm.add(new TextField("libelle").setRequired(true));
        editForm.add(new TextField("soldeCourant").setRequired(true));
    }

    @Override
    protected IService getService() {
        return compteService;
    }

    @Override
    protected void enregistrer(Compte compte) {
        try {
            if (getId(compte) == null) {
                compteService.ajouter(compte);
            } else {
                compteService.modifier(compte);
            }
            setResponsePage(getResponsePageClass());
        } catch (Exception e) {
            error(e);
        }
    }

    @Override
    protected String getId(Compte cpt) {
        try {
            return cpt.getId().toString();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected Class getResponsePageClass() {
        return ComptePage.class;
    }
}
