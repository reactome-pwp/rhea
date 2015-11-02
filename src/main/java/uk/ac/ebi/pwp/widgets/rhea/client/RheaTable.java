package uk.ac.ebi.pwp.widgets.rhea.client;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.*;
import uk.ac.ebi.pwp.widgets.rhea.model.Chemical;
import uk.ac.ebi.pwp.widgets.rhea.model.Molecule;
import uk.ac.ebi.pwp.widgets.rhea.model.Reaction;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class RheaTable extends Composite {
    private HTMLTable table;

    public RheaTable(Reaction reaction) {
        this.table = new FlexTable();
        this.table.setCellSpacing(1);
        initialize(reaction);
        setWidth("100%");
    }

    private void initialize(Reaction reaction){
        int i=0; int rsize = reaction.getReactantList().size();
        for (Chemical chemical : reaction.getReactantList()) {
            this.addChemical(chemical, ++i < rsize ? "+" : "=>");
        }
        int j=0; int psize = reaction.getProductList().size();
        for (Chemical chemical : reaction.getProductList()) {
            this.addChemical(chemical, ++j < psize ? "+" : "");
        }

        //DEFINE ALIGNMENT
        for (int k = 0; k < this.table.getRowCount(); k++) {
            for (int l = 0; l < this.table.getCellCount(k); l++) {
                this.table.getCellFormatter().setHorizontalAlignment(k, l, HasHorizontalAlignment.ALIGN_CENTER);
            }
        }
        initWidget(this.table);
    }

    private void addChemical(Chemical chemical, String symbol){
        int row=0;
        int col = this.table.getRowCount() == 0 ? 0 : this.table.getCellCount(0);

        this.table.setWidget(row++, col, new Label(chemical.getTitle()));
        if(!symbol.isEmpty()){
            this.table.setWidget(row-1, col+1, this.getSymbol(symbol));
        }

        this.table.setWidget(row++, col, this.getAnchor(chemical.getMolecule()));
        if(!symbol.isEmpty()){
            this.table.setWidget(row-1, col+1, this.getSymbol(symbol));
        }

        this.table.setWidget(row++, col, this.getImage(chemical.getMolecule()));
        if(!symbol.isEmpty()){
            this.table.setWidget(row-1, col+1, this.getSymbol(symbol));
        }
    }

    private Widget getAnchor(Molecule molecule){
        return new Anchor(molecule.getId(), "http://www.ebi.ac.uk/chebi/searchId.do?chebiId=" + molecule.getId() + "&conversationContext=2", "_blank");
    }

    private Widget getImage(Molecule molecule){
        String url = "http://www.ebi.ac.uk/chebi/displayImage.do?defaultImage=true&chebiId=" + molecule.getId() + "&dimensions=200&scaleMolecule=true&transbg=true";
        Image image = new Image(url);
        image.getElement().getStyle().setBorderWidth(0, Style.Unit.PX);
        Anchor anchor = new Anchor("", "http://www.ebi.ac.uk/chebi/searchId.do?chebiId=" + molecule.getId() + "&conversationContext=2", "_blank");
        DOM.insertBefore(anchor.getElement(), image.getElement(), DOM.getFirstChild(anchor.getElement()));
        return anchor;
    }

    private Widget getSymbol(String symbol){
        Label l = new Label(symbol);
        l.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
        return l;
    }
}
