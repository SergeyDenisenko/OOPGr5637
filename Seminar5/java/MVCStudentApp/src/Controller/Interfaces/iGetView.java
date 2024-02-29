package Controller.Interfaces;

import java.util.List;

import Controller.Lang;
import Controller.Msg;
import Controller.Storage;
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

    /**
     * @apiNote Выводит в консоль список языков
     * @param languages Список языков
     */
    public void printListLang(Lang[] languages);

    /**
     * @apiNote Выводит в консоль список языков
     * @param storage Список языков
     */
    public void printStorageList(Storage[] storages);

    /**
     * @apiNote Выводит название выбранного класса хранилища
     * @param model
     */
    public void printSelectedStorage(iGetModel model);

    /**
     * @apiNote Содержит строки информационных сообщений
     * @param name enumerate Msg
     * @return текст сообщения
     */
    public String textMesage(Msg name);
}
