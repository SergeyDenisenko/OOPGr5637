package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

public class ModelClassHash implements iGetModel {
    
    private HashMap<Integer, Student> students = new HashMap<>();

    public ModelClassHash(List<Student> studentsList) {
        addAll(studentsList);
    }

    /**
     * @return Возвращает список студентов
     */
    public List<Student> getAllStudents() {
        List<Student> studentsList = new ArrayList<>();
        if (students.size() > 0) {
            studentsList.addAll(this.students.values());
        }
        return studentsList;
    }

   /**
     * @apiNote Удалаяет студента из списка
     * @param idStudent Идентификатор студента
     * @return boolean
     */
    public boolean deleteStudent(Integer idStudent) {
        for (int i=0; i<this.students.size(); i++) {
            if (this.students.get(i) != null && this.students.get(i).getId() == idStudent) {
                this.students.remove(i);
                sortKey();
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
     * @apiNote Сортирует ключи
     */
    public void sortKey() {
        HashMap<Integer, Student> newList = new HashMap<>();
        Integer count = 0;
        for (Student student: this.students.values()) {
            newList.put(count++, student);
        }
        this.students = newList;
    }

    /**
     * @apiNote Добавляет список студентов
     * @param listStudent
     */
    public void addAll(List<Student> studentsList) {
        Integer index = this.students.size();
        for (int i=0; i<studentsList.size(); i++) {
            this.students.put(index++, studentsList.get(i));
        }
    }

    /**
     * @apiNote Добавляет студента
     * @param listStudent
     */
    public void add(Student student) {
        Integer index = this.students.size();
        this.students.put(index, student);
    }
}
