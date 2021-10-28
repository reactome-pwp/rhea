package uk.ac.ebi.pwp.widgets.rhea.model;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class Reaction extends JavaScriptObject {
    protected Reaction() {
    }

    public final native String getId() /*-{
        return this.id;
    }-*/;

    public final native String getEquation() /*-{
        return this.equation;
    }-*/;

    public final native String getHTMLEquation() /*-{
        return this.htmlequation;
    }-*/;

    public final native String getStatus() /*-{
        return this.status;
    }-*/;

    public final native JsArray<Chemical> getReactantList() /*-{
        return this.left;
    }-*/;

    public final native JsArray<Chemical> getProductList() /*-{
        return this.right;
    }-*/;
}
