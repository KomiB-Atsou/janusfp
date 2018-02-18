package com.c353.bicomat.web.base;

import com.c353.bicomat.web.banque.BanquePage;
import com.c353.bicomat.web.fp.ComptePage;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.agilecoders.wicket.webjars.request.resource.WebjarsJavaScriptResourceReference;
import java.io.Serializable;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

public abstract class BasePage<T> extends WebPage implements Serializable {

    private MarkupContainer defaultModal;

    public BasePage(PageParameters params) {
        super(params);
        initPage();
    }

    public BasePage() {
        initPage();
    }

    private void initPage() {
        defaultModal = new EmptyPanel("defaultModal");
        defaultModal.setOutputMarkupId(true);
        add(defaultModal);
        add(new FeedbackPanel("feedback").setOutputMarkupId(true));
        addMenu();
    }

    public void replaceDefaultModal(ModalWindow newModal) {
        defaultModal.replaceWith(newModal);
        defaultModal = newModal;
        defaultModal.setOutputMarkupId(true);
    }

    public void addMenu() {
        add(new BookmarkablePageLink("banque", BanquePage.class));
        add(new BookmarkablePageLink("fp", ComptePage.class));
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.render(JavaScriptHeaderItem.forReference(getApplication().getJavaScriptLibrarySettings().getJQueryReference()));
        response.render(JavaScriptHeaderItem.forReference(getApplication().getJavaScriptLibrarySettings().getWicketEventReference()));
        response.render(JavaScriptHeaderItem.forReference(getApplication().getJavaScriptLibrarySettings().getWicketAjaxReference()));

        String bootstrapPrefixPath = "bootstrap/current";
        response.render(JavaScriptHeaderItem.forReference(new WebjarsJavaScriptResourceReference(bootstrapPrefixPath + "/js/bootstrap.js")));
        response.render(CssHeaderItem.forReference(new WebjarsJavaScriptResourceReference(bootstrapPrefixPath + "/css/bootstrap.css")));
    }

    public final Boolean isModifier(PageParameters param) {
        if (param != null && !param.get("id").isEmpty()) {
            if (!param.get("action").isEmpty()) {
                if ("edit".equals(param.get("action").toString())) {
                    return true;
                } else if ("delete".equals(param.get("action").toString())) {
                    return false;
                }
            }
        }
        return null;
    }
}
