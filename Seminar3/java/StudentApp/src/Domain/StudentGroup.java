package Domain;

import java.util.Iterator;
import java.util.List;

public class StudentGroup implements Iterable<Student>, Comparable<StudentGroup> {
    private List<Student> group;
    private Integer idGroup;

    public StudentGroup(List<Student> group, Integer idGroup) {
        this.group = group;
        this.idGroup = idGroup;
    }

    public List<Student> getGroup() {
        return group;
    }

    public void setGroup(List<Student> group) {
        this.group = group;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public int size() {
        return group.size();
    }

     @Override
    public String toString() {
        // return "StudentGroup{" +
        //         "group=" + group +
        //         ", idGroup=" + idGroup +
        //         '}';
        return "Group id: " + this.idGroup +
                "\nNumber of students: " + this.size() +
                "\nList of students: " + group + "\n\n";
    }

    // @Override
    // public Iterator<Student> iterator() {
    //    return new Iterator<Student>() {

    //     private int counter;

    //     @Override
    //     public boolean hasNext() {

    //         if(counter<group.size())
    //         {
    //             return true;
    //         }
    //         else
    //         {
    //             return false;
    //         }            
    //     }

    //     @Override
    //     public Student next() {            
    //         return group.get(counter++);
    //     }
        
    //    };
        
    // }

     @Override
    public Iterator<Student> iterator() {
       return new StudentIterator(group);
    }

    @Override
    public int compareTo(StudentGroup g) {
        if (this.size() == g.size()) {
            return (this.idGroup == g.getIdGroup()) ? 0 : (this.idGroup > g.getIdGroup()) ? 1 : -1;
        }
        return this.size() > g.size() ? 1 : -1;
    }
}
