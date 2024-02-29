package Controllers;

import java.util.List;

import Domain.Person;
import Domain.Teacher;
import Domain.WorkingPerson;

public class AccountController {

    public static <T extends WorkingPerson> void paySalary(T person, int salary) {
        System.out.println(person.getName() + " выплачено зарплата " + salary + "р. ");
    }

    //Загатовка для метода averageAge
    public static <T extends Person> double averageAge(List<T> persons)
    {
        double sum = 0;
        int count = 0;

        for (T person : persons) {
            sum += person.getAge();
            count++;
        }
        return Math.ceil((sum / count) * 100) / 100;
    }
}
