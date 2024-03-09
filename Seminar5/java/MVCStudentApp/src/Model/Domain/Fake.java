package Model.Domain;

import java.util.ArrayList;
import java.util.List;

public class Fake {
    public static String[] names = new String[]{
        "Александра","Алена","Алина","Алиса","Анастасия","Ангелина","Анна","Арина",
        "Валерия","Варвара","Василиса","Вера","Вероника","Виктория","Дарья","Диана",
        "Ева","Евгения","Екатерина","Елена","Елизавета","Злата","Ирина","Карина",
        "Кира","Кристина","Ксения","Лилия","Любовь","Людмила","Маргарита","Марина",
        "Мария","Милана","Надежда","Наталья","Ольга","Полина","Светлана","София",
        "Таисия","Ульяна","Юлия","Яна","Александр","Алексей","Андрей","Антон","Арсений",
        "Артем","Василий","Виктор","Виталий","Владимир","Владислав","Вячеслав","Георгий",
        "Глеб","Давид","Даниил","Денис","Дмитрий","Евгений","Егор","Иван","Игорь",
        "Илья","Кирилл","Константин","Лев","Максим","Марк","Матвей","Михаил","Никита",
        "Николай","Олег","Павел","Роман","Руслан","Сергей","Станислав","Степан",
        "Тимофей","Тимур","Федор","Юрий","Ярослав"
    };

    public static String[] namesEng = new String[]{
        "Alexandra","Alyona","Alina","Alice","Anastasia","Angelina","Anna","Arina",
        "Valeria","Varvara","Vasilisa","Vera","Veronica","Victoria","Daria","Diana",
        "Eva","Eugenia","Ekaterina","Elena","Elizabeth","Zlata","Irina","Karina",
        "Kira","Kristina","Ksenia","Lily","Lyubov","Lyudmila","Margarita","Marina",
        "Maria","Milana","Nadezhda","Natalia","Olga","Polina","Svetlana","Sofia",
        "Taisiya","Ulyana","Julia","Yana","Alexander","Alexey","Andrey","Anton","Arseny",
        "Artyom","Vasily","Victor","Vitaly","Vladimir","Vladislav","Vyacheslav","George",
        "Gleb","David","Daniel","Denis","Dmitry","Eugene","Egor","Ivan","Igor",
        "Ilya","Kirill","Konstantin","Lev","Maxim","Mark","Matvey","Mikhail", "Nikita",
        "Nikolai","Oleg","Pavel","Roman","Ruslan","Sergey","Stanislav","Stepan",
        "Timofey","Timur","Fedor","Yuri","Yaroslav"
    };

    public static List<Student> generateStudent(Integer count) {
        List<Student> students = new ArrayList<>();
        int nameSize = names.length;
        int maxAge = 60;
        int minAge = 16;
        int age;
        int numberName;
        for (int i=0; i<count; i++) {
            age = (int) ((Math.random() * (maxAge - minAge)) + minAge);
            numberName = (int) (Math.random() * nameSize);
            students.add(new Student(namesEng[numberName], age));
        }
        return students;
    }
}
