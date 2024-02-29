package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

public class ModelClassHash implements iGetModel {
    
    private HashMap<Integer, Student> students;

    public void ModelClass(List<Student> studentsList) {
        for (int i=0; i<studentsList.size(); i++) {
            this.students.put(i, studentsList.get(i));
        }
    }

    /**
     * @return Возвращает список студентов
     */
    public List<Student> getAllStudents() {
        List<Student> studentsList = new ArrayList<>();
        studentsList.addAll(this.students.values());
        return studentsList;
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
}
