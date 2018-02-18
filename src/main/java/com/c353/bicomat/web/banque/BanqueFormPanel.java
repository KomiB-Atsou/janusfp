package com.c353.bicomat.web.banque;

import com.c353.bicomat.entities.banque.Banque;
import com.c353.bicomat.services.common.IService;
import com.c353.bicomat.web.base.BaseFormPanel;
import org.apache.wicket.markup.html.form.HiddenField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.spring.injection.annot.SpringBean;
import com.c353.bicomat.services.common.banque.IBanqueDefaultService;


public class BanqueFormPanel extends BaseFormPanel<Banque, Integer> {

    @SpringBean
    private IBanqueDefaultService banqueService;

    public BanqueFormPanel(String id) {
        super(id);
    }

    public BanqueFormPanel(String id, Banque t) {
        super(id, t);
    }

    @Override
    protected void addComponents(EditForm editForm) {
        editForm.add(new HiddenField("idBanque"));
        editForm.add(new TextField("nom").setRequired(true));
        editForm.add(new TextField("adresse"));
    }

    @Override
    protected IService getService() {
        return banqueService;
    }

    @Override
    protected void enregistrer(Banque banque) {
        try {
            if (getId(banque) == null) {
                banqueService.ajouter(banque);
            } else {
                banqueService.modifier(banque);
            }
            setResponsePage(getResponsePageClass());
        } catch (Exception e) {
            error(e);
        }
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
