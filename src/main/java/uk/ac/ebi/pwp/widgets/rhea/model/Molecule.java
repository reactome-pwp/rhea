package uk.ac.ebi.pwp.widgets.rhea.model;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class Molecule {
    String title;
    String id;

    public Molecule(String title, String id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Molecule{" +
                "title='" + title + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
