import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Domain.Student;
import Domain.StudentGroup;
import Domain.StudentSteam;

public class App {
    public static void main(String[] args) throws Exception {
        
        Student s1 = new Student("Иван", 25);
        Student s2 = new Student("Игорь", 23);
        Student s3 = new Student("Иван", 22);
        Student s4 = new Student("Игорь",  23);
        Student s5 = new Student("Даша",  23);
        Student s6 = new Student("Лена",  23);

        List<Student> listStud = new ArrayList<Student>();
        listStud.add(s1);
        listStud.add(s2);
        listStud.add(s3);
        listStud.add(s4);
        listStud.add(s5);
        listStud.add(s6);
        

        StudentGroup group4580 = new StudentGroup(listStud, 4580);

        Student s7 = new Student("Иван 2", 25);
        Student s8 = new Student("Игор 2ь", 23);
        Student s9 = new Student("Иван 2", 22);
        Student s10 = new Student("Игорь 2",  23);
        Student s11 = new Student("Даша 2",  23);
        Student s12 = new Student("Лена 2",  23);

        List<Student> listStud2 = new ArrayList<Student>();
        listStud2.add(s7);
        listStud2.add(s8);
        listStud2.add(s9);
        listStud2.add(s10);
        listStud2.add(s11);
        listStud2.add(s12);
        

        StudentGroup group4681 = new StudentGroup(listStud2, 4681);

        System.out.println(group4580);

        for(Student std : group4580)
        {
            System.out.println(std);
        }

        System.out.println("=========================================================");

        Collections.sort(group4580.getGroup());

        for(Student std: group4580.getGroup())
        {
            System.out.println(std);
        }

        System.out.println("=========================================================");

        StudentSteam steam = new StudentSteam(4580);
        steam.add(group4580);
        steam.add(group4681);
        // System.out.println(steam);
        for(StudentGroup stdn : steam)
        {
            System.out.println("\n --- " + stdn);
        }
    }
}
