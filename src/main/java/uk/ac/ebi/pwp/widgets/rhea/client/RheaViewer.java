package uk.ac.ebi.pwp.widgets.rhea.client;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.ui.*;
import uk.ac.ebi.pwp.widgets.rhea.data.ReactionFactory;
import uk.ac.ebi.pwp.widgets.rhea.events.ReactionRetrievedEvent;
import uk.ac.ebi.pwp.widgets.rhea.events.ReactionStructureLoadedEvent;
import uk.ac.ebi.pwp.widgets.rhea.events.ReactionStructureNotAvailableEvent;
import uk.ac.ebi.pwp.widgets.rhea.handlers.ReactionRetrievedHandler;
import uk.ac.ebi.pwp.widgets.rhea.handlers.ReactionStructureLoadedHandler;
import uk.ac.ebi.pwp.widgets.rhea.handlers.ReactionStructureNotAvailableHandler;
import uk.ac.ebi.pwp.widgets.rhea.model.Reaction;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
@SuppressWarnings("UnusedDeclaration")
public class RheaViewer extends Composite implements HasHandlers, ReactionRetrievedHandler {
    VerticalPanel container;

    public RheaViewer(TextResource xml) {
        initialize();
        showReaction(ReactionFactory.getReaction(xml));
    }

    public RheaViewer(String rheaId) {
        initialize();
        ReactionFactory.getReaction(rheaId, this);
    }

    public HandlerRegistration addStructureLoadedHandler(ReactionStructureLoadedHandler handler){
        return this.addHandler(handler, ReactionStructureLoadedEvent.TYPE);
    }

    public HandlerRegistration addStructureNotAvailableHandler(ReactionStructureNotAvailableHandler handler) {
        return this.addHandler(handler, ReactionStructureNotAvailableEvent.TYPE);
    }

    public static Widget getMessage(ImageResource imageResource, String customMessage){
        HorizontalPanel hp = new HorizontalPanel();
        hp.setSpacing(5);

        hp.add(new Image(imageResource.getSafeUri()));

        InlineLabel label = new InlineLabel(customMessage);
        label.getElement().getStyle().setFontWeight(Style.FontWeight.NORMAL);
        label.getElement().getStyle().setFloat(Style.Float.LEFT);
        hp.add(label);

        return hp;
    }

    private void initialize(){
        this.container = new VerticalPanel();
        container.setWidth("100%");
        //noinspection GWTStyleCheck
        this.container.addStyleName("rhea-RheaViewer");

        String msg = "Loading the Rhea structure. Please wait...";
        container.add(getMessage(Images.INSTANCE.getLoadingImage(), msg));
        initWidget(container);
    }

    @Override
    public void onReactionRetrieved(ReactionRetrievedEvent event) {
        this.showReaction(event.getReaction());
    }

    @Override
    public void onReactionFactoryError(Throwable exception) {
        this.showErrorMessage(exception.getMessage());
    }

    private void showErrorMessage(String msg){
        this.container.clear();
        this.container.add(getMessage(Images.INSTANCE.getAlertImage(), msg));
        fireEvent(new ReactionStructureNotAvailableEvent());
    }

    private void showReaction(Reaction r){
        this.container.clear();

        Anchor anchor = new Anchor(r.getIdentifier(), "//www.rhea-db.org/reaction?id=" + r.getIdentifier(), "_blank");
        anchor.setTitle(r.getName());
        this.container.add(anchor);

        this.container.add(new RheaTable(r));
        this.container.getElement().getStyle().setPadding(15, Style.Unit.PX);
        fireEvent(new ReactionStructureLoadedEvent());
    }
}
