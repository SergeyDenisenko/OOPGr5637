package View;

import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.Domain.Student;

public class ViewClassEng implements iGetView {
    
    /**
     * @apiNote Выводит в консоль список студентов
     * @param students Список студентов
     * @return void
     */
    public void printAllStudents(List<Student> students)
    {
        System.out.println("--------------------List of students-------------------");
        for (Student s: students)
        {
            System.out.println(s);
        }
        System.out.println("-------------------------------------------------------");
    }

    /**
     * @apiNote Читает строку из консоли
     * @param msg Информационное сообщение
     * @return String
     */
    public String prompt(String msg)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();
    }

    /**
     * @apiNote Выводит текстовую информацию о статусе удаления студента из списка
     * @param isDelete Статус удаления
     * @param idStudent Идентификатор студента
     * @return void
     */
    public void infoDelete(boolean isDelete, String idStudent) {
        if (isDelete) {
            System.out.println(String.format("\nСтудент с идентификатором %s удален успешно!\n", idStudent));
        } else {
            System.out.println(String.format("\nСтудент с идентификатором %s не найден!\n", idStudent));
        }
    }
}
