package uk.ac.ebi.pwp.widgets.rhea.handlers;

import com.google.gwt.event.shared.EventHandler;
import uk.ac.ebi.pwp.widgets.rhea.events.ReactionStructureNotAvailableEvent;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface ReactionStructureNotAvailableHandler extends EventHandler {

    void onReactionStructureNotAvailable(ReactionStructureNotAvailableEvent event);
}
