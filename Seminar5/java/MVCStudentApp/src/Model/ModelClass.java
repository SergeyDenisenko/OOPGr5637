package Model;

import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

public class ModelClass implements iGetModel {
    
    private List<Student> students;     // Список студентов

    public ModelClass(List<Student> students) {
        this.students = students;
    }

    /**
     * @return Возвращает список студентов
     */
    public List<Student> getAllStudents() {
        return students;
    }

    /**
     * @apiNote Удалаяет студента из списка
     * @param idStudent Идентификатор студента
     * @return boolean
     */
    public boolean deleteStudent(Integer idStudent) {
        for (int i=0; i<this.students.size(); i++) {
            if (this.students.get(i).getId()== idStudent) {
                this.students.remove(i);
                return true;
            }
        }

        return false;
    }

    /**
     * @apiNote Удалаяет студента из списка
     * @param idStudent Идентификатор студента
     * @return boolean
     */
    public boolean deleteStudent(String idStudent) {
        return this.deleteStudent(Integer.parseInt(idStudent));
    }

    /**
     * @apiNote Добавляет список студентов
     * @param listStudent
     */
    public void addAll(List<Student> listStudent) {
        for (Student student: listStudent) {
            this.students.add(student);
        }
    }

    /**
     * @apiNote Добавляет студента
     * @param listStudent
     */
    public void add(Student student) {
        this.students.add(student);
    }
}
