package uk.ac.ebi.pwp.widgets.rhea.handlers;

import com.google.gwt.event.shared.EventHandler;
import uk.ac.ebi.pwp.widgets.rhea.events.ReactionStructureLoadedEvent;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface ReactionStructureLoadedHandler extends EventHandler {

    void onReactionStructureLoaded(ReactionStructureLoadedEvent event);
}
