package uk.ac.ebi.pwp.widgets.rhea.events;

import com.google.gwt.event.shared.GwtEvent;
import uk.ac.ebi.pwp.widgets.rhea.handlers.ReactionStructureLoadedHandler;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class ReactionStructureLoadedEvent extends GwtEvent<ReactionStructureLoadedHandler> {
    public static Type<ReactionStructureLoadedHandler> TYPE = new Type<ReactionStructureLoadedHandler>();

    @Override
    public Type<ReactionStructureLoadedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ReactionStructureLoadedHandler handler) {
        handler.onReactionStructureLoaded(this);
    }
}
