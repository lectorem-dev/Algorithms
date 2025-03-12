package ru.ya;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* О себе
* I курс
*  - С++, ООП, Структуры данных
*  - LDAP, C#
* II курс
*  - C# (WinForm)
*  - React (JS, HTML, CSS)
*  - DevOps (Linux, Git, ssh)
*  - UtilitaPDF
* III курс
*  - курс по Java
*  - VPS
*  - Си для Atmega16
*  - БД PostgresSQL (JDBC, R2DBC), ClickHouse, Scala (со скриптами py в юпитер)
*  - Chgzabor
*  - Исток
*
* https://github.com/lectorem-dev */

public class _Memo {
    public static void main(String[] args) {
        // Создаем Scanner для ввода данных с консоли
        Scanner scanner = new Scanner(System.in);

        // Ввод массива чисел
        System.out.println("Введите массив чисел, разделенных пробелами:");
        String input = scanner.nextLine();  // Считываем строку
        String[] stringArray = input.split(" ");   // Разбиваем строку на массив строк

        // Преобразуем строковый массив в массив целых чисел
        int[] data = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            data[i] = Integer.parseInt(stringArray[i]);
        }

        // Ввод числа
        System.out.println("Введите число:");
        int number = scanner.nextInt();

        // Закрытие сканера
        scanner.close();

        // Вывод массива чисел с помощью Arrays.toString()
        System.out.println("Массив чисел (Arrays.toString()): " + Arrays.toString(data));

        // Вывод массива чисел с использованием цикла for
        System.out.println("Массив чисел (цикл for):");
        for (int item : data) {
            System.out.println(item);
        }

        // Вывод массива чисел с использованием цикла while и индекса
        System.out.println("Массив чисел (цикл while):");
        int i = 0;
        while (i < data.length) {
            System.out.println(data[i]);
            i++;
        }

        // Вывод числа
        System.out.println("Число: " + number);


        // String upper = str.toUpperCase();
        // String lower = str.toLowerCase();

        // int[] arr = new int[5];
        // int[] arr = {1, 2, 3, 4, 5};
        // arr[0] = 10;

        // import java.util.*;
        //
        // List<Integer> list = new ArrayList<>();
        // list.add(10); // добавление
        // list.remove(0); // удаление
        // list.get(0); // доступ по индексу

        // for (int i = 0; i < n; i++) {}

        // try {
        //     код, который может вызвать исключение
        // } catch (ExceptionType e) {
        //     обработка исключения
        // } finally {
        //     код, который выполнится в любом случае
        // }

        mapExample();     // Пример работы с мап
        hashMapExample(); // Произвольный порядок элементов так как хешируется
        stackExample();
        queueExample();
        dequeExample();
        setExample();
    }

    // 1. Пример использования Stack (Стек)
    public static void stackExample() {
        Stack<Integer> stack = new Stack<>();

        // Операции на стеке
        stack.push(10);  // Добавить элемент в стек
        stack.push(20);
        stack.push(30);

        System.out.println("Stack after pushing elements: " + stack);

        System.out.println("Peek top element: " + stack.peek());  // Посмотреть верхний элемент
        System.out.println("Pop top element: " + stack.pop());   // Удалить и вернуть верхний элемент

        System.out.println("Stack after pop: " + stack);
    }

    // 2. Пример использования Queue (Очередь)
    public static void queueExample() {
        Queue<Integer> queue = new LinkedList<>();

        // Операции на очереди
        queue.offer(10);  // Добавить элемент в очередь
        queue.offer(20);
        queue.offer(30);

        System.out.println("Queue after adding elements: " + queue);

        System.out.println("Peek front element: " + queue.peek());  // Посмотреть передний элемент
        System.out.println("Poll front element: " + queue.poll());   // Удалить и вернуть передний элемент

        System.out.println("Queue after poll: " + queue);
    }

    // 3. Пример использования Deque (Двусторонняя очередь)
    public static void dequeExample() {
        Deque<Integer> deque = new ArrayDeque<>();

        // Операции на двусторонней очереди
        deque.offerFirst(10);  // Добавить элемент в начало
        deque.offerLast(20);   // Добавить элемент в конец
        deque.offerFirst(30);
        deque.offerLast(40);

        System.out.println("Deque after adding elements: " + deque);

        System.out.println("Peek first element: " + deque.peekFirst());  // Посмотреть первый элемент
        System.out.println("Peek last element: " + deque.peekLast());    // Посмотреть последний элемент

        System.out.println("Poll first element: " + deque.pollFirst());  // Удалить и вернуть первый элемент
        System.out.println("Poll last element: " + deque.pollLast());    // Удалить и вернуть последний элемент

        System.out.println("Deque after poll operations: " + deque);
    }

    // 4. Пример использования Set (Множество)
    public static void setExample() {
        Set<Integer> set = new HashSet<>();

        // Операции на множестве (Set не поддерживает дубли)
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20);  // Этот элемент не будет добавлен, так как Set не допускает дубли

        System.out.println("Set after adding elements: " + set);

        System.out.println("Contains 20: " + set.contains(20));  // Проверка наличия элемента
        set.remove(20);  // Удалить элемент
        System.out.println("Set after removing 20: " + set);
    }

    static void mapExample() {
        Map<String, Integer> map = new HashMap<>();

        // Добавление элементов в Map
        map.put("apple", 5);
        map.put("banana", 3);
        map.put("orange", 8);

        // Получение значения по ключу
        System.out.println("Количество яблок: " + map.get("apple"));

        // Проверка наличия ключа
        if (map.containsKey("banana")) {
            System.out.println("Количество бананов: " + map.get("banana"));
        }

        // Перебор всех элементов в Map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        map.forEach((key, value) -> System.out.println(key + ": " + value));


        // Удаление элемента по ключу
        map.remove("orange");
        System.out.println("После удаления orange: " + map);
    }

    static void hashMapExample() {
        // Создание объекта HashMap
        HashMap<String, Integer> hashMap = new HashMap<>();

        // Добавление элементов
        hashMap.put("John", 25);
        hashMap.put("Alice", 30);
        hashMap.put("Bob", 35);

        // Получение значения по ключу
        System.out.println("Возраст John: " + hashMap.get("John"));

        // Проверка на наличие ключа
        if (hashMap.containsKey("Alice")) {
            System.out.println("Возраст Alice: " + hashMap.get("Alice"));
        }

        // Перебор элементов
        System.out.println("Содержимое HashMap:");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        hashMap.forEach((key, value) -> System.out.println(key + ": " + value));


        // Удаление элемента
        hashMap.remove("Bob");
        System.out.println("После удаления Bob: " + hashMap);
    }

    // Объединенные примеры лямбда-выражений
    public static void lambdaExamples() {
        // Пример с интерфейсом Runnable
        Runnable run = () -> System.out.println("Hello, World!");
        run.run();  // Выводит "Hello, World!"

        // Пример с интерфейсом BiFunction (два параметра)
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("Сумма 5 и 3: " + add.apply(5, 3));  // Выводит 8

        // Пример с интерфейсом Supplier (без параметров)
        Supplier<String> supplier = () -> "Hello, Lambda!";
        System.out.println(supplier.get());  // Выводит "Hello, Lambda!"

        // Пример с интерфейсом Consumer (с параметром)
        Consumer<String> consumer = (str) -> {
            System.out.println("Начало");
            System.out.println(str);
            System.out.println("Конец");
        };
        consumer.accept("Lambda Function");  // Выводит:
        // Начало
        // Lambda Function
        // Конец

        // Пример работы с коллекциями (Stream API) и фильтрация
        List<String> names = Arrays.asList("Anna", "John", "Bob", "Alice");
        names.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);  // Выведет "Anna" и "Alice"

        // Пример использования Map с лямбда-выражением
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 5);
        map.put("banana", 3);
        map.put("orange", 8);

        // Перебор Map с лямбда-выражением
        map.forEach((key, value) -> System.out.println(key + ": " + value));

        // Пример с использованием Optional
        Optional<String> optional = Optional.of("Hello");
        optional.ifPresent(s -> System.out.println(s));  // Выводит "Hello"
    }
}
