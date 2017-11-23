package sort.tools;

import objects.example.TesterB;

import java.util.Comparator;

/**
 * @author michal.oles
 */
public class TesterBSorter implements Comparator<TesterB> {

    private Boolean isA;

    public TesterBSorter(Boolean isA) {
        this.isA = isA;
    }

    private int sortByA(TesterB o1, TesterB o2) {
        return (o1.getA() == null) ? -1 : ((o2.getA() == null) ? 1 : o1.getA().compareTo(o2.getA()));
    }

    private int sortByB(TesterB o1, TesterB o2) {
        Integer i = o1.getB();
        Integer j = o2.getB();
        return (o1 == null) ? -1 : ((o2 == null) ? 1 : i.compareTo(j));
    }

    @Override
    public int compare(TesterB o1, TesterB o2) {
        if (isA) {
            return sortByA(o1, o2);
        } else {
            return sortByB(o1, o2);
        }
    }
}
