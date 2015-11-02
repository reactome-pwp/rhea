package uk.ac.ebi.pwp.widgets.rhea.handlers;

import com.google.gwt.event.shared.EventHandler;
import uk.ac.ebi.pwp.widgets.rhea.events.ReactionRetrievedEvent;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface ReactionRetrievedHandler extends EventHandler {

    void onReactionRetrieved(ReactionRetrievedEvent event);
    void onReactionFactoryError(Throwable exception);

}
