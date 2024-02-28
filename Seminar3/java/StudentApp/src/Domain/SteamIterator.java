package Domain;

import java.util.Iterator;
import java.util.List;

public class SteamIterator implements Iterator<StudentGroup> {
    private int counter;
    private final List<StudentGroup> steam;

    public SteamIterator(List<StudentGroup> steam) {
        this.steam = steam;
        this.counter = 0;
    }

    @Override
    public boolean hasNext() {
        return counter<steam.size();
    }

    @Override
    public StudentGroup next() {
        if (!hasNext())
        {
            return null;
        }
        return steam.get(counter++);
    }
}
