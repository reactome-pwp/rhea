package uk.ac.ebi.pwp.widgets.rhea.client;

import com.google.gwt.core.client.JsArray;
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
    private final HTMLTable table;

    public RheaTable(Reaction reaction) {
        this.table = new FlexTable();
        this.table.setCellSpacing(1);
        initialize(reaction);
        setWidth("100%");
        getElement().getStyle().setBackgroundColor("white");
        getElement().getStyle().setProperty("borderRadius", "10px");
        getElement().getStyle().setProperty("border", "solid 1px grey");
    }

    private void initialize(Reaction reaction) {

        JsArray<Chemical> reactantList = reaction.getReactantList();
        int rsize = reactantList.length();
        for (int i = 0; i < rsize; i++) {
            this.addChemical(reactantList.get(i), i + 1 < rsize ? "+" : "=>");
        }

        JsArray<Chemical> productList = reaction.getProductList();
        int psize = productList.length();
        for (int j = 0; j < psize; j++) {
            this.addChemical(productList.get(j), j + 1 < psize ? "+" : "");
        }

        //DEFINE ALIGNMENT
        for (int k = 0; k < this.table.getRowCount(); k++) {
            for (int l = 0; l < this.table.getCellCount(k); l++) {
                this.table.getCellFormatter().setHorizontalAlignment(k, l, HasHorizontalAlignment.ALIGN_CENTER);
            }
        }
        initWidget(this.table);
    }

    private void addChemical(Chemical chemical, String symbol) {
        int row = 0;
        int col = this.table.getRowCount() == 0 ? 0 : this.table.getCellCount(0);

        for (Widget widget : new Widget[]{
                new Label(chemical.getLabel()),
                this.getAnchor(chemical),
                this.getImage(chemical)}) {
            boolean hasCount = chemical.getCount() != null;
            if (hasCount) this.table.setWidget(row, col, this.getSymbol(chemical.getCount()));
            this.table.setWidget(row, hasCount ? col + 1 : col, widget);
            if (!symbol.isEmpty()) this.table.setWidget(row, hasCount ? col + 2 : col + 1, this.getSymbol(symbol));
            row++;
        }
    }

    private Widget getAnchor(Molecule molecule) {
        return new Anchor(molecule.getId(), "http://www.ebi.ac.uk/chebi/searchId.do?chebiId=" + molecule.getId() + "&conversationContext=2", "_blank");
    }

    private Widget getImage(Molecule molecule) {
        String url = "http://www.rhea-db.org/compoundImage.xhtml?dimensions=200&chebiId=" + molecule.getId();
        Image image = new Image(url);
        image.getElement().getStyle().setBorderWidth(0, Style.Unit.PX);
        Anchor anchor = new Anchor("", "http://www.ebi.ac.uk/chebi/searchId.do?chebiId=" + molecule.getId() + "&conversationContext=2", "_blank");
        DOM.insertBefore(anchor.getElement(), image.getElement(), DOM.getFirstChild(anchor.getElement()));
        return anchor;
    }

    private Widget getSymbol(String symbol) {
        Label l = new Label(symbol);
        l.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
        return l;
    }
}
