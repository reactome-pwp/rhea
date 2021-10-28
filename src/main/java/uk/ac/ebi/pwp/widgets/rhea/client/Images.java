package uk.ac.ebi.pwp.widgets.rhea.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
interface Images extends ClientBundle {

    Images INSTANCE = GWT.create(Images.class);

    @Source("images/alert.png")
    ImageResource getAlertImage();

    @Source("images/loading.gif")
    ImageResource getLoadingImage();
}