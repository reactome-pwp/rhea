package uk.ac.ebi.pwp.widgets.rhea.model;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class Molecule extends JavaScriptObject {
    protected Molecule() {

    }

    public final native String getName() /*-{
        return this.htmlName;
    }-*/;

    public final native String getId() /*-{
        return this.id;
    }-*/;

    public final native String getIdPrefix() /*-{
        return this.idPrefix;
    }-*/;

    public final native String getLabel() /*-{
        return this.label;
    }-*/;

    public final native String getFormula() /*-{
        return this.formula;
    }-*/;

    public final native String getInChIKey() /*-{
        return this.inchikey;
    }-*/;


    public final native String getCharge() /*-{
        return this.charge;
    }-*/;

    public final native String getThumbnailURL() /*-{
        return this.thumbnail;
    }-*/;


}
