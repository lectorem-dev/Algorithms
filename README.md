# Algorithms

Этот репозиторий создан для подготовки к техническим собеседованиям.  
Здесь собраны алгоритмические задачи, которые помогут прокачать навыки решения и понимания алгоритмов.

### Код для других 

Важно не забывать что наш код читают другие программисты, и нам стоит придерживаться чистого кода. Например если стоит 
выбор между Math.max() и тернарным оператором - стоит выбирать функцию, потому что разность в скорочти исполнения 
ничтожна, при том что мы сильно выигрываем в читаемости кода. Бесцельное использование изощренных инструментов и 
однострочные решения свидетествуют о раздутом эго, а не уме автора. 

## Цель

Тренировка алгоритмического мышления и подготовка к отборочному этапу собеседования.

## Ресурсы

[CodeRun - задачи от Яндекса](https://coderun.yandex.ru)

[leetcode](https://leetcode.com/problem-list/ocywzq52/)

# Solution 

## Графы

[RangeSumBST](https://leetcode.com/problems/range-sum-of-bst) - Работаем с двоичным деревом поиска

[SumLeftLeaves](https://leetcode.com/problems/sum-of-left-leaves) - Сумма оставшихся листьев

[BalancedBinaryTree](https://leetcode.com/problems/balanced-binary-tree) - Определяем баланс дерева используя рекурсивный DFS

[MaximumDepthBinaryTree](https://leetcode.com/problems/maximum-depth-of-binary-tree) -  Поиск глубины графа (рекурсия/DFS/BFS)

[SymmetricTree](https://leetcode.com/problems/symmetric-tree) - Поиск в глубину (DFS) проходит дерево зеркально.

[SameTree](https://leetcode.com/problems/same-tree) - Обход двоичного дерева в ширину (BFS)

## Строки 

[IsSubsequence](https://leetcode.com/problems/is-subsequence) - является ли строка последовательной подстрокой 

[FirstUniqueCharacter](https://leetcode.com/problems/first-unique-character-in-a-string) - Ищем первый неповторяющийся символ в строке 

[JewelsAndStones](https://leetcode.com/problems/jewels-and-stones) - сколько символов строки A есть в строке B 

[ValidAnagram](https://leetcode.com/problems/valid-anagram) - Являются ли строки анограмами

[ValidPalindrome](https://leetcode.com/problems/valid-palindrome) - Палиндромы

## Массивы

[SquaresSortedArray](https://leetcode.com/problems/squares-of-a-sorted-array) - Вернуть отсортированный массив квадратов отсортированного массива

[FindDifferenceTwoArrays](https://leetcode.com/problems/find-the-difference-of-two-arrays) - Симметрическая разность массивов (not (A and B))

[IntersectionTwoArraysII](https://leetcode.com/problems/intersection-of-two-arrays-ii) - Найти пересечение двух массивов

[MoveZeroes](https://leetcode.com/problems/move-zeroes) - Перемещаем нули в правую часть

[BinarySearch](https://leetcode.com/problems/binary-search) - Бинарный поиск по отсортированному массиву

[SummaryRanges](https://leetcode.com/problems/summary-ranges) - диапазоны в массиве 

[ReverseWordsStringIII](https://leetcode.com/problems/reverse-words-in-a-string-iii) - переворот слов в строке 

[FindIndexFirstOccurrenceString](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string)

[RemoveDuplicatesFromSortedArray](https://leetcode.com/problems/remove-duplicates-from-sorted-array) - потрясающе кривая задача, input массив является ответом, его нужно изменять :D

[BusyStudent](https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time) 

[MergeSortedArray]() - слияние отсортированных массивов

[SequentialCharacters](https://leetcode.com/problems/consecutive-characters)

[TwoSum](https://leetcode.com/problems/two-sum) - ищем в масиве два числа сумма которых образует заданное число 

## Списки

[PalindromeLinkedList](https://leetcode.com/problems/palindrome-linked-list) - Является ли список полиндромом

[ImplementQueueUsingStacks](https://leetcode.com/problems/implement-queue-using-stacks) - реализуем очередь (FIFO) через два стека 
 
[ReverseLinkedList](https://leetcode.com/problems/reverse-linked-list) - разворачиваем односвязный список

[MergeTwoSortedLists](https://leetcode.com/problems/merge-two-sorted-lists) - слияние отсортированных односвязных спиосков 

[LinkedListCycle](https://leetcode.com/problems/linked-list-cycle) - определяем есть ли цикл в списке

## Разное

[MinProductPair]() - Сделало мне больно на собесе

[AddStrings](https://leetcode.com/problems/add-strings/description) - Имитируем сложение в столбик

[GuessNumberHigherLower](https://leetcode.com/problems/guess-number-higher-or-lower) - Бинарный поиск, решающий задачу поиска числа от 0 до N c АPI

[MissingNumber](https://leetcode.com/problems/missing-number) - ищем недостающие число в арифметической прогресии

[SingleNumber](https://leetcode.com/problems/single-number) -  Поиск числа без пары в массиве используя XOR ❤️

[BestTimeBuySellStock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock) - Поиск максимальной прибыли акций (перебор массива скользящим окном за O(n))

[ValidParentheses](https://leetcode.com/problems/valid-parentheses) - проверка скобочной последователности ❤️

[RomanToInteger](https://leetcode.com/problems/roman-to-integer)

[MiddleNumber](https://coderun.yandex.ru/problem/median-out-of-three)

[PascalTriangle](https://leetcode.com/problems/pascals-triangle) - строим треугольник паскаля

## Динамическое программирование 

[KnightsMove](https://coderun.yandex.ru/problem/knight-move) - сколькими путями конь может пройти доску 

## Яндекс, тренеровка по алгоритмам (разминка)

[SortingReverseOrder](https://coderun.yandex.ru/problem/sorting-reverse-order/description) - Сортировка положительных чисел в обратном порядке

[MergeJsons2](https://coderun.yandex.ru/problem/merge-jsons-2) - Опять JSON’ы перекладывать