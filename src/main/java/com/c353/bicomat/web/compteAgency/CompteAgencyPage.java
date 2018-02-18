package com.c353.bicomat.web.compteAgency;

import com.c353.bicomat.web.fp.CompteListPanel;
import com.c353.bicomat.web.fp.CompteFormPanel;
import com.c353.bicomat.entities.agency.CompteAgency;
import com.c353.bicomat.web.base.BasePage;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.Optional;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import com.c353.bicomat.services.common.agency.ICompteAgencyDefaultService;

@MountPath("compteAgency")
public class CompteAgencyPage extends BasePage {

    @SpringBean
    private ICompteAgencyDefaultService compteAgencyService;

    public CompteAgencyPage() {
        this(null);
    }

    public CompteAgencyPage(PageParameters param) {
        if (param != null && param.get("idCompteAgency") != null) {
            System.out.println("IdCompteAgency" + param.get("idAgency").toInt());
        }

        CompteAgency compteAgency = new CompteAgency();
        Boolean isModif = super.isModifier(param);
        if (isModif != null) {
            if (isModif) {
                Optional<CompteAgency> optional = compteAgencyService
                        .selectionner(param.get("id").toInt());
                compteAgency = (optional.isPresent()) ? optional.get() : compteAgency;
            } else {
                Optional<CompteAgency> optional = compteAgencyService
                        .selectionner(param.get("id").toInt());
                compteAgencyService.supprimer(optional.get());
            }
        }
        // Comme il n'existe qu'un seul composant "formPanel", 
        // je suis obligé de commenter la ligne correspondante ci-dessous
        //add(new CompteFormPanel("formPanel", compteAgency));
        //add(new CompteListPanel("listPanel"));
    }
}
