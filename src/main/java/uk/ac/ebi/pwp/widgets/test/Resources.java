package uk.ac.ebi.pwp.widgets.test;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface Resources extends ClientBundle {

    Resources INSTANCE = (Resources) GWT.create(Resources.class);

    @Source("20570.xml")
    TextResource responseText();
}
