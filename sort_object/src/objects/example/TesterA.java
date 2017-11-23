package objects.example;

/**
 * @author michal.oles
 */
public class TesterA extends Tester implements Comparable<TesterA> {

    public TesterA(Tester t) {
        super(t);
    }

    private int sortByB(TesterA o) {
        Integer i = getB();
        Integer j = o.getB();
        return i.compareTo(j);
    }

    @Override
    public int compareTo(TesterA o) {
        if (getA() == null) {
            return -1;
        }
        if (o.getA() == null) {
            return 1;
        }
        int i = getA().compareTo(o.getA());
        if (i == 0) {
            i = sortByB(o);
        }
        return i;
    }
}
