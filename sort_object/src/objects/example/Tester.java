package objects.example;

/**
 * @author michal.oles
 */
public class Tester {
    private String a;
    private int b;

    public Tester(String a, int b) {
        this.a = a;
        this.b = b;
    }

    public Tester(Tester tester) {
        this.a = tester.getA();
        this.b = tester.getB();
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tester tester = (Tester) o;

        if (b != tester.b) return false;
        return a != null ? a.equals(tester.a) : tester.a == null;
    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + b;
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "a='" + a + '\'' +
                ", b=" + b +
                '}';
    }
}
