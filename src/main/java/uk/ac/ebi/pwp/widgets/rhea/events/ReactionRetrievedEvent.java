package uk.ac.ebi.pwp.widgets.rhea.events;

import com.google.gwt.event.shared.GwtEvent;
import uk.ac.ebi.pwp.widgets.rhea.handlers.ReactionRetrievedHandler;
import uk.ac.ebi.pwp.widgets.rhea.model.Reaction;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class ReactionRetrievedEvent extends GwtEvent<ReactionRetrievedHandler> {
    public static Type<ReactionRetrievedHandler> TYPE = new Type<ReactionRetrievedHandler>();
    Reaction reaction;

    public ReactionRetrievedEvent(Reaction reaction) {
        this.reaction = reaction;
    }

    @Override
    public Type<ReactionRetrievedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ReactionRetrievedHandler handler) {
        handler.onReactionRetrieved(this);
    }

    public Reaction getReaction() {
        return reaction;
    }
}
