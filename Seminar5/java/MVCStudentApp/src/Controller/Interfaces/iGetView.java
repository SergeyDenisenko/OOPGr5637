package Controller.Interfaces;

import java.util.List;

import Model.Domain.Student;

public interface iGetView {
    /**
     * @apiNote Выводит в консоль список студентов
     * @param students Список студентов
     * @return void
     */
    public void printAllStudents(List<Student> students);

    /**
     * @apiNote Читает строку из консоли
     * @param msg Информационное сообщение
     * @return String
     */
    public String prompt(String msg);

    /**
     * @apiNote Выводит текстовую информацию о статусе удаления студента из списка
     * @param isDelete Статус удаления
     * @param idStudent Идентификатор студента
     * @return void
     */
    public void infoDelete(boolean isDelete, String idStudent);
}
