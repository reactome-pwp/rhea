package uk.ac.ebi.pwp.widgets.rhea.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class Reaction {
    String name;
    String identifier;
    List<Chemical> reactantList = new LinkedList<Chemical>();
    List<Chemical> productList = new LinkedList<Chemical>();

    public Reaction(String name, String identifier) {
        this.name = name;
        this.identifier = identifier;
    }

    public void addReactant(Chemical chemical){
        this.reactantList.add(chemical);
    }

    public void addReactants(Collection<Chemical> reactantList){
        this.reactantList.addAll(reactantList);
    }

    public void addProduct(Chemical chemical){
        this.productList.add(chemical);
    }

    public void addProducts(Collection<Chemical> productList){
        this.productList.addAll(productList);
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public List<Chemical> getReactantList() {
        return reactantList;
    }

    public List<Chemical> getProductList() {
        return productList;
    }

    @Override
    public String toString() {
        return "Reaction{" +
                "name='" + name + '\'' +
                ", identifier='" + identifier + '\'' +
                ", reactantList=" + reactantList +
                ", productList=" + productList +
                '}';
    }
}
