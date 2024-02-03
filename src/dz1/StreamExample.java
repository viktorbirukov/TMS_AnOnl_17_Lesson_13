// Урок №13
// Домашка №1
// Бирюков Виктор
// создать коллекцию класса ArrayList наполнить ее рандомными элементами типа integer.
// затем с помощью Stream: удалить дубликаты.
// вывести все четные элименты в диапазоне от 7 до 17 включительно.
// каждый элемент  умножить на 2.
// отсортировать и вывести на экран первые 4 элемента.
// вывести количество элементов в streame.
// вывести среднее арифметическое в stream.

package dz1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        // Шаг 1: Создаем и заполняем коллекцию рандомными числами
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            numbers.add(random.nextInt(30)); // Генерируем случайные числа от 0 до 29
        }

        // Выводим исходную коллекцию
        System.out.println("Исходная коллекция: " + numbers);

        // Шаг 2: Удаляем дубликаты
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        // Выводим коллекцию без дубликатов
        System.out.println("Коллекция без дубликатов: " + distinctNumbers);

        // Шаг 3: Фильтруем четные числа в диапазоне от 7 до 17, умножаем на 2
        List<Integer> filteredAndMultiplied = distinctNumbers.stream()
                .filter(number -> number >= 7 && number <= 17 && number % 2 == 0)
                .map(number -> number * 2)
                .collect(Collectors.toList());

        // Выводим отфильтрованные и умноженные элементы
        System.out.println("Четные числа от 7 до 17, умноженные на 2: " + filteredAndMultiplied);

        // Шаг 4: Сортируем и выводим первые 4 элемента
        List<Integer> sortedNumbers = filteredAndMultiplied.stream()
                .sorted()
                .limit(4)
                .collect(Collectors.toList());

        // Выводим первые 4 элемента после сортировки
        System.out.println("Первые 4 элемента после сортировки: " + sortedNumbers);

        // Шаг 5: Выводим количество элементов
        long count = sortedNumbers.stream().count();
        System.out.println("Количество элементов: " + count);

        // Шаг 6: Вычисляем среднее арифметическое
        double average = sortedNumbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);

        // Выводим среднее арифметическое
        System.out.println("Среднее арифметическое: " + average);
    }
}
