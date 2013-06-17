package fpij.chapter6;

public class HolderBetterButNotPerfect {
    private Heavy heavy;

    public HolderBetterButNotPerfect () {
        System.out.println("Better holder created");
    }

    public synchronized Heavy getHeavy() {
        if (heavy == null) {
            heavy = new Heavy();
        }
        return heavy;
    }
}
