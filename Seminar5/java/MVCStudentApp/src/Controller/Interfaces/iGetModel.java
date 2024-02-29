package Controller.Interfaces;

import java.util.List;

import Model.Domain.Student;

public interface iGetModel {
    /**
     * @apiNote Возвращает список всех студентов
     * @return Список студентов
     */
    public List<Student> getAllStudents();

    /**
     * @apiNote Удаляет студента из списка
     * @param idStudent idStudent Идентификатор студента
     * @return boolean
     */
    public boolean deleteStudent(Integer idStudent);

    /**
     * @apiNote Удаляет студента из списка
     * @param idStudent Идентификатор студента
     * @return boolean
     */
    public boolean deleteStudent(String idStudent);
}
