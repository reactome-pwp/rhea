package uk.ac.ebi.pwp.widgets.rhea.data;

import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.*;
import com.google.gwt.resources.client.TextResource;
import uk.ac.ebi.pwp.widgets.rhea.events.ReactionRetrievedEvent;
import uk.ac.ebi.pwp.widgets.rhea.handlers.ReactionRetrievedHandler;
import uk.ac.ebi.pwp.widgets.rhea.model.Reaction;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public final class ReactionFactory {

    public static String version = "" + System.currentTimeMillis(); //UNIQUE per session

    public final static Integer TIME_OUT = 4000;

    public static void getReaction(String rheaId, final ReactionRetrievedHandler handler) {
        String uri = "rhea/" + rheaId + "/json";
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, uri);
        requestBuilder.setTimeoutMillis(TIME_OUT);
        try {
            requestBuilder.sendRequest(null, new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    handler.onReactionRetrieved(new ReactionRetrievedEvent(JsonUtils.safeEval(response.getText())));
                }

                @Override
                public void onError(Request request, Throwable exception) {
                    handler.onReactionFactoryError(exception);
                }
            });
        } catch (RequestException e) {
            handler.onReactionFactoryError(e);
        }
    }


    public static Reaction getReaction(TextResource resource) {
        return JsonUtils.safeEval(resource.getText());
    }
}
