package uk.ac.ebi.pwp.widgets.rhea.model;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class Chemical {
    Double count;
    String title;
    Molecule molecule;

    public Chemical(Double count, String title, Molecule molecule) {
        this.count = count;
        this.title = title;
        this.molecule = molecule;
    }

    public Double getCount() {
        return count;
    }

    public String getTitle() {
        return title;
    }

    public Molecule getMolecule() {
        return molecule;
    }

    @Override
    public String toString() {
        return "Chemical{" +
                "count=" + count +
                ", title='" + title + '\'' +
                ", molecule=" + molecule +
                '}';
    }
}
