package uk.ac.ebi.pwp.widgets.rhea.model;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class Chemical extends Molecule {
    protected Chemical() {
    }

    public final native String getCount() /*-{ return this.coff; }-*/;

}
