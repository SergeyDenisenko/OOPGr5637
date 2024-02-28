package Domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentSteam implements Iterable<StudentGroup> {
    
    private static Integer id;
    private List<StudentGroup> steam = new ArrayList<StudentGroup>();;
    private int counter = 0;

    public StudentSteam(Integer id) {
        this.id = id;
    }

    public void add(StudentGroup group) {
        this.steam.add(group);
    }

    public List<StudentGroup> get() {
        return steam;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int size() {
        return steam.size();
    }

    @Override
    public String toString() {
        // return "StudentSteam [steam=" + this.steam + "]" ;
        return "Steam id: " + this.id + 
                "\nNumber of groups: " + this.size() + 
                "\nGroups:\n" + this.steam;
    }

    @Override
    public Iterator<StudentGroup> iterator() {
        return new SteamIterator(steam);
    }
}
