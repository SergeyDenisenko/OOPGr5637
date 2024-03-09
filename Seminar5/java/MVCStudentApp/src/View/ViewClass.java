package View;

import java.util.List;
import java.util.Scanner;

import Controller.Lang;
import Controller.Msg;
import Controller.Storage;
import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.Domain.Student;


public class ViewClass implements iGetView {

    /**
     * @apiNote Выводит в консоль список студентов
     * @param students Список студентов
     * @return void
     */
    public void printAllStudents(List<Student> students)
    {
        System.out.println("--------------------Список студентов-------------------");
        for(Student s: students)
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

    /**
     * @apiNote Выводит список языков
     */
    public void printListLang(Lang[] languages) {
        for (Lang item: languages) {
            System.out.println(String.format("+ %s", item));
        }
    }

    /**
     * @apiNote Выводит список хранилищ
     */
    public void printStorageList(Storage[] storages) {
        int count = 1;
        for (Storage item: storages) {
            System.out.println(String.format("%d: %s", count++, item));
        }
    }

    /**
     * @apiNote Выводит название выбранного класса хранилища
     * @param model
     */
    public void printSelectedStorage(iGetModel model) {
        System.out.println(String.format("Выбранное хранилище: %s", model.getClass().getName()));
    }

    public String textMesage(Msg name) {
        switch (name) {
            case LANG: return "Введите название языка: ";
            case STORAGE: return "Введите номер хранилища: ";
            case NAME: return "Введите имя: ";
            case AGE: return  "Введите возраст: ";
            case COMMAND: return "Введите команду: ";
            case EXIT: return  "Выход из программы!";
            case IDSTUDENT: return "Введите номер студента на удаление: ";
            case COUNTSTUDENT: return "Введите количество студентов: ";
            case EMPTYLIST: return "Список студентов пуст!";
        }
        return "";
    }
}
