package com.c353.bicomat.web.base.selecteur;

import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.model.Model;

public class BaseModal extends ModalWindow {

    public BaseModal(String id) {
        super(id);
        setMinimalHeight(300);
        setMinimalWidth(500);
        setInitialHeight(300);
        setInitialWidth(500);
        setAutoSize(false);
        setTitle(Model.of("Selectionner"));
    }
}
