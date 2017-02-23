package uk.ac.ebi.pwp.widgets.rhea.data;

import com.google.gwt.http.client.*;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.xml.client.*;
import uk.ac.ebi.pwp.widgets.rhea.events.ReactionRetrievedEvent;
import uk.ac.ebi.pwp.widgets.rhea.handlers.ReactionRetrievedHandler;
import uk.ac.ebi.pwp.widgets.rhea.model.Chemical;
import uk.ac.ebi.pwp.widgets.rhea.model.Molecule;
import uk.ac.ebi.pwp.widgets.rhea.model.Reaction;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public final class ReactionFactory {

    public static String version = "" + System.currentTimeMillis(); //UNIQUE per session

    public final static Integer TIME_OUT = 4000;

    public static void getReaction(String rheaId, final ReactionRetrievedHandler handler) {
        String uri = "rhea/rest/1.0/ws/reaction/cmlreact/" + rheaId + "?v=" + version; //25278
        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, uri);
        requestBuilder.setTimeoutMillis(TIME_OUT);
        try {
            requestBuilder.sendRequest(null, new RequestCallback() {
                @Override
                public void onResponseReceived(Request request, Response response) {
                    Document xml = XMLParser.parse(response.getText());
                    handler.onReactionRetrieved(new ReactionRetrievedEvent(getReaction(xml)));
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
        Document xml = XMLParser.parse(resource.getText());
        return getReaction(xml);
    }

    private static Reaction getReaction(Document xml){
        Element r = (Element) xml.getElementsByTagName("name").item(0);
        String name = ((Text) r.getFirstChild()).getData();
        r = (Element) xml.getElementsByTagName("identifier").item(0);
        String identifier = r.getAttribute("value");
        Reaction reaction = new Reaction(name, identifier);

        NodeList reactantList = xml.getElementsByTagName("reactant");
        for (int i = 0; i < reactantList.getLength(); i++) {
            reaction.addReactant(getChemical(reactantList.item(i)));
        }

        NodeList productList = xml.getElementsByTagName("product");
        for (int i = 0; i < reactantList.getLength(); i++) {
            reaction.addProduct(getChemical(productList.item(i)));
        }

        return reaction;
    }

    private static Chemical getChemical(Node node){
        Element reactant = (Element) node;
        Double count = Double.valueOf(reactant.getAttribute("count"));
        String title = reactant.getAttribute("title");

        Element m = (Element) reactant.getElementsByTagName("molecule").item(0);
        Element i = (Element) m.getElementsByTagName("identifier").item(0);
        Molecule molecule = new Molecule(m.getAttribute("title"), i.getAttribute("value"));

        return new Chemical(count, title, molecule);
    }
}
