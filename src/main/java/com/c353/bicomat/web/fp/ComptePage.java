package com.c353.bicomat.web.fp;

import com.c353.bicomat.entities.Compte;
import com.c353.bicomat.services.ICompteService;
import com.c353.bicomat.web.base.BasePage;
import org.wicketstuff.annotation.mount.MountPath;

import java.util.Optional;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

@MountPath("compte")
public class ComptePage extends BasePage {

    @SpringBean
    private ICompteService compteService;

    public ComptePage() {
        this(null);
    }

    public ComptePage(PageParameters param) {
        if (param != null && param.get("idCompteAgency") != null) {
            System.out.println("IdCompteAgency" + param.get("idAgency").toInt());
        }

        Compte compte = new Compte();
        Boolean isModif = super.isModifier(param);
        if (isModif != null) {
            if (isModif) {
                Optional<Compte> optional = compteService
                        .selectionner(param.get("id").toLong());
                compte = (optional.isPresent()) ? optional.get() : compte;
            } else {
                Optional<Compte> optional = compteService
                        .selectionner(param.get("id").toLong());
                compteService.supprimer(optional.get());
            }
        }
        add(new CompteFormPanel("formPanel", compte));
        add(new CompteListPanel("listPanel"));
    }
}
