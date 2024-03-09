package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

public class FileModelClass implements iGetModel {

    private String fileName;
    private List<Student> students = new ArrayList<Student>(); 

    public FileModelClass(String fileName) {
        this.fileName = fileName;

        try(FileWriter fw = new FileWriter(fileName, true))
        {
            fw.flush();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @apiNote Сохраняет список студентов в файл
     * @param students Список студентов
     */
    public void saveAllStudentToFile(List<Student> students)
    {
        try(FileWriter fw = new FileWriter(fileName, true))
        {
            for(Student pers : students)
            {
                fw.write(pers.getName()+","+pers.getAge()+","+pers.getId());
                fw.append('\n');
            }
            fw.flush();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 
     * @return Возвращает список студентов из файла
     */
    @Override
    public List<Student> getAllStudents() {
        if (students.size() > 0) {
            return students;
        }
        try
        {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line!=null)
            {
                String[] param = line.split(",");
                Student pers = new Student(param[0], Integer.parseInt(param[1]));
                students.add(pers);
                line = reader.readLine();
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return students;
    }

    /**
     * @apiNote Обновляет файл
     * @param students
     */
    public void updateFile(List<Student> students) {
        try(FileWriter fw = new FileWriter(fileName, false))
        {
            for(Student pers : students)
            {
                fw.write(pers.getName()+","+pers.getAge()+","+pers.getId());
                fw.append('\n');
            }
            fw.flush();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @apiNote Удалаяет студента из файла
     * @param idStudent Идентификатор студента
     * @return boolean
     */
    public boolean deleteStudent(Integer idStudent) {
        List<Student> students = getAllStudents();
        for (int i=0; i<students.size(); i++) {
            if (students.get(i).getId()== idStudent) {
                students.remove(i);
                updateFile(students);
                return true;
            }
        }
        return false;
    }
    
    /**
     * @apiNote Удалаяет студента из файла
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
        this.saveAllStudentToFile(listStudent);
    }

    /**
     * @apiNote Добавляет студента
     * @param listStudent
     */
    public void add(Student student) {
        this.students.add(student);
        updateFile(this.students);
    }
}
