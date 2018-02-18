/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.web.compteAgency;

import com.c353.bicomat.web.fp.ComptePage;
import com.c353.bicomat.entities.agency.CompteAgency;
import com.c353.bicomat.services.common.IService;
import com.c353.bicomat.web.base.BaseFormPanel;
import org.apache.wicket.markup.html.form.HiddenField;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.spring.injection.annot.SpringBean;
import com.c353.bicomat.services.common.agency.ICompteAgencyDefaultService;


public class CompteAgencyFormPanel extends BaseFormPanel<CompteAgency, Integer> {

    @SpringBean
    private ICompteAgencyDefaultService compteAgencyService;

    public CompteAgencyFormPanel(String id) {
        super(id);
    }

    public CompteAgencyFormPanel(String id, CompteAgency t) {
        super(id, t);
    }

    @Override
    protected void addComponents(EditForm editForm) {
        editForm.add(new HiddenField("idClient"));
        editForm.add(new TextField("login").setRequired(true));
        editForm.add(new PasswordTextField("motDePasse").setRequired(true));
    }

    @Override
    protected IService getService() {
        return compteAgencyService;
    }

    @Override
    protected void enregistrer(CompteAgency compteAgency) {
        try {
            if (getId(compteAgency) == null) {
                compteAgencyService.ajouter(compteAgency);
            } else {
                compteAgencyService.modifier(compteAgency);
            }
            setResponsePage(getResponsePageClass());
        } catch (Exception e) {
            error(e);
        }
    }

    @Override
    protected String getId(CompteAgency cpt) {
        try {
            return cpt.getIdClient().toString();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected Class getResponsePageClass() {
        return ComptePage.class;
    }
}
