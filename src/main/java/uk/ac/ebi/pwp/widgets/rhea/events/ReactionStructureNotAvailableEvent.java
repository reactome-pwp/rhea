package uk.ac.ebi.pwp.widgets.rhea.events;

import com.google.gwt.event.shared.GwtEvent;
import uk.ac.ebi.pwp.widgets.rhea.handlers.ReactionStructureNotAvailableHandler;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class ReactionStructureNotAvailableEvent extends GwtEvent<ReactionStructureNotAvailableHandler> {
    public static Type<ReactionStructureNotAvailableHandler> TYPE = new Type<ReactionStructureNotAvailableHandler>();

    @Override
    public Type<ReactionStructureNotAvailableHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ReactionStructureNotAvailableHandler handler) {
        handler.onReactionStructureNotAvailable(this);
    }
}
