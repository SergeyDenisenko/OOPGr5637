package Model.Domain;

public abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 
     * @return Возвращает имя
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name Устанавливает имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return Возвращает возраст
     */
    public int getAge() {
        return age;
    }

    /**
     * 
     * @param age Устанавливает возраст
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
