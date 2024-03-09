package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.FileModelClass;
import Model.ModelClass;
import Model.ModelClassHash;
import Model.Domain.Fake;
import Model.Domain.Student;
import View.ViewClass;
import View.ViewClassEng;

public class ControllerClass {

    private iGetModel model;
    private HashMap<String, iGetModel> modelList = new HashMap<String, iGetModel>();
    private iGetView view;
    private List<Student> bufferStudentList = new ArrayList<Student>();

    public ControllerClass() {
        init();
    }

    /**
     * @apiNote Инициализирует значения по умолчанию
     */
    public void init() {
        modelList.put("LIST", new ModelClass(new ArrayList<Student>()));
        modelList.put("HASHMAP", new ModelClassHash(new ArrayList<Student>()));
        modelList.put("FILE", new FileModelClass("StudentDB.csv"));
        this.model = modelList.get("LIST");
        this.view = new ViewClass();
    }

    /**
     * @apiNote Выбор языка
     */
    public void selectLanguage() {
        this.view.printListLang(Lang.values());
        String command = view.prompt(view.textMesage(Msg.LANG));
        try {
            Lang language = Lang.valueOf(command.toUpperCase());
            switch (language) {
                case ENG:
                    this.view = new ViewClassEng();
                    break;
                case RUS:
                    this.view = new ViewClass();
                    break;
            }
        } catch (Exception e) {
            this.view = new ViewClass();
        }
    }

    /**
     * @apiNote Выбор хранилища
     */
    public void selectStorage() {
        Storage storage = Storage.LIST;
        this.view.printStorageList(Storage.values());
        String command = view.prompt(view.textMesage(Msg.STORAGE));
        try {
            Integer numberStorage = Integer.parseInt(command);
            if (numberStorage > 0 && numberStorage <= Storage.values().length)
            {
                storage = Storage.values()[--numberStorage];
            }
        } catch (Exception e) {
            try {
                storage = Storage.valueOf(command.toUpperCase());
            } catch (Exception ex) {
                storage = Storage.LIST;
            }
        }
        switch (storage) {
            case LIST:
                this.model = modelList.get("LIST");
                break;
            case HASHMAP:
                this.model = modelList.get("HASHMAP");
                break;
            case FILE:
                this.model = modelList.get("FILE");
                break;
        }
        this.view.printSelectedStorage(this.model);
    }

    /**
     * @apiNote Сохраняет список студентов в файл
     */
    private void saveToFile(){
        if (this.model.equals(modelList.get("FILE"))) {
            FileModelClass fileModel = (FileModelClass)modelList.get("FILE");
            fileModel.saveAllStudentToFile(this.model.getAllStudents());
        } else {
            String name = String.format("%s.csv", this.model.getClass().getName());
            FileModelClass fileModel = new FileModelClass(name);
            fileModel.saveAllStudentToFile(this.model.getAllStudents());
        }
    }

    /**
     * @apiNote Получает список студентов из файла
     * @return Список студентов
     */
    private List<Student> readFile() {
        if (this.model.equals(modelList.get("FILE"))) {
            FileModelClass fileModel = (FileModelClass)modelList.get("FILE");
            return fileModel.getAllStudents();
        } else {
            String name = String.format("%s.csv", this.model.getClass().getName());
            FileModelClass fileModel = new FileModelClass(name);
            List<Student> students = fileModel.getAllStudents();
            this.model.addAll(students);
            return fileModel.getAllStudents();
        }
    }

    /**
     * @apiNote Удалаяет студента из файла
     * @param idStudent Идентификатор студента
     * @return boolean
     */
    public boolean deleteStudent(Integer numberStudent) {
        if (!this.model.deleteStudent(numberStudent))
        {
            for (iGetModel mod: this.modelList.values()) {
                if (!mod.equals(this.model))
                {
                    if (mod.deleteStudent(numberStudent)) return true;
                }
            }
            return false;
        }
        return true;
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
     * @apiNote Обновляет данные в файле
     */
    public void updateFile() {
        if (!this.model.equals(modelList.get("FILE"))) {
            String name = String.format("%s.csv", this.model.getClass().getName());
            FileModelClass fileModel = new FileModelClass(name);
            fileModel.updateFile(this.model.getAllStudents()); 
        }
    }

    /**
     * @apiNote Создает нового студента
     * @return Статус создания
     */
    public boolean createStudent() {
        String name = view.prompt(view.textMesage(Msg.NAME));
        Integer age;
        try {
            age = Integer.parseInt(view.prompt(view.textMesage(Msg.AGE)));
        } catch (Exception e) {
            return false;
        }
        this.model.add(new Student(name, age));
        return true;
    }

    /**
     * @apiNote Запускает окно команд
     * @return void
     */
    public void run() {
        selectLanguage();
        Command com = Command.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            String command = view.prompt(view.textMesage(Msg.COMMAND));
            com = Command.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    getNewIteration = false;
                    System.out.println(view.textMesage(Msg.EXIT));
                    break;
                case LIST:
                    view.printAllStudents(model.getAllStudents());
                    break;
                case DELETE:
                    String numberStudent = view.prompt(view.textMesage(Msg.IDSTUDENT));
                    view.infoDelete(deleteStudent(numberStudent), numberStudent);
                    break;
                case FAKE:
                    String countStudent = view.prompt(view.textMesage(Msg.COUNTSTUDENT));
                    Integer countStud = 10;
                    try {
                        countStud = Integer.parseInt(countStudent);
                    } catch (Exception e) {
                        countStud = 10;
                    }
                    if (this.model.equals(this.modelList.get("FILE"))) {
                        ((FileModelClass)this.model).addAll(Fake.generateStudent(countStud));
                    } else {
                        this.model.addAll(Fake.generateStudent(countStud));
                    }
                    break;
                case STORAGE:
                    selectStorage();
                    break;
                case SAVE:
                    saveToFile();
                    break;
                case READ:
                    view.printAllStudents(readFile());
                    break;
                case CREATE:
                    createStudent();
                    break;
                case UPDATE:
                    updateFile();
                    break;
            }
        }
    }

    /**
     * @apiNote Проверяет наличие студентов в списке
     * @param students Список студентов
     * @return boolean
     */
    private boolean testData(List<Student> students) {
        if (students.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void update() {
        bufferStudentList = model.getAllStudents();
        if (testData(bufferStudentList)) {
            view.printAllStudents(bufferStudentList);
        } else {
            System.out.println(view.textMesage(Msg.EMPTYLIST));
        }
    }
}