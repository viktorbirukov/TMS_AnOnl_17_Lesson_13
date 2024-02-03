// Урок №13
// Домашка №1
// Бирюков Виктор
// Создать коллекцию класса ArrayList со значениями имен всех студентов в группе с помощью stream.
// Вернуть количество людей с вашим именем в независимости от верхнего или нижнего регистра букв.
// Выбрать все имена, начинающиеся на "а" вне зависимости от верхнего или нижнего регистра букв.
// Отсортировать и вернуть первый элемент коллекции или  "Empty@, если коллекция пуста.
package dz2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentNames {
    public static void main(String[] args) {
        // Шаг 1: Создаем коллекцию имен студентов
        List<String> studentNames = new ArrayList<>();
        studentNames.add("Виктор");
        studentNames.add("Владимир");
        studentNames.add("анна");
        studentNames.add("Алексей");
        studentNames.add("Ева");
        studentNames.add("Михаил");
        studentNames.add("Андрей");
        studentNames.add("Дмитрий");
        studentNames.add("анна");
        studentNames.add("Мария");

        // Выводим исходную коллекцию
        System.out.println("Исходная коллекция имен студентов: " + studentNames);

        // Шаг 2: Подсчитываем количество имен, совпадающих с вашим
        String myName = "Виктор";
        long countOfMyName = studentNames.stream()
                .filter(name -> name.equalsIgnoreCase(myName))
                .count();

        // Выводим количество имен, совпадающих с вашим
        System.out.println("Количество студентов с именем \"" + myName + "\": " + countOfMyName);

        // Шаг 3: Выбираем все имена, начинающиеся на "а" (независимо от регистра)
        List<String> namesStartingWithA = studentNames.stream()
                .filter(name -> name.toLowerCase().startsWith("а"))
                .collect(Collectors.toList());

        // Выводим имена, начинающиеся на "а"
        System.out.println("Имена, начинающиеся на 'а': " + namesStartingWithA);

        // Шаг 4: Сортируем и возвращаем первый элемент (или "Empty@", если коллекция пуста)
        String firstStudentName = studentNames.stream()
                .findFirst()
                .orElse("Empty@");

        // Выводим первый элемент
        System.out.println("Первый элемент коллекции: " + firstStudentName);
    }
}
