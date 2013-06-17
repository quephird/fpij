package fpij.chapter6;

public class HolderNaive {
    private Heavy heavy;

    public HolderNaive() {
        System.out.println("Naive holder created");
    }

    public Heavy getHeavy() {
        if (heavy == null) {
            heavy = new Heavy();
        }
        return heavy;
    }
}
