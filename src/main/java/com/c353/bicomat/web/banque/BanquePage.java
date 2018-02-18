package com.c353.bicomat.web.banque;

import com.c353.bicomat.entities.banque.Banque;
import com.c353.bicomat.web.base.BasePage;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.Optional;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import com.c353.bicomat.services.common.banque.IBanqueDefaultService;

@MountPath("banques")
public class BanquePage extends BasePage {

    @SpringBean
    private IBanqueDefaultService banqueService;

    public BanquePage() {
        this(null);
    }

    public BanquePage(PageParameters param) {
        if (param != null && param.get("idBanque") != null) {
            System.out.println("IdBanque" + param.get("idBanque").toInt());
        }

        Banque banque = new Banque();
        Boolean isModif = super.isModifier(param);
        if (isModif != null) {
            if (isModif) {
                Optional<Banque> optional = banqueService
                        .selectionner(param.get("id").toInt());
                banque = (optional.isPresent()) ? optional.get() : banque;
            } else {
                Optional<Banque> optional = banqueService
                        .selectionner(param.get("id").toInt());
                banqueService.supprimer(optional.get());
            }
        }
        add(new BanqueFormPanel("formPanel", banque));
        add(new BanqueListPanel("listPanel"));
    }
}
