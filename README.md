# epamejc2020
### HW0 - [TrafficLight](https://github.com/VLDRospuskov/epamejc2020/tree/ErmakovAleksandr/com.epamejc.lessons/src/main/java/homeworks/homework00)

### HW1 - [Own immutable class](https://github.com/VLDRospuskov/epamejc2020/tree/ErmakovAleksandr/com.epamejc.lessons/src/main/java/homeworks/homework01)
> Создать immutable class, создать пару объектов, поэксперементировать с данными.

### HW2 - [Arrays](https://github.com/VLDRospuskov/epamejc2020/tree/ErmakovAleksandr/com.epamejc.lessons/src/main/java/homeworks/homework02)
> 2.1. Создать массив массивов, задается размерность, на основании которой генерируются случайные символы типа char. 
> Пример:

    Input: 4 2
    output:
    k c 
    b p 
    b h 
    h g 

> 2.2. Сгенерировать массив массивов, указав размерность, заполнить его случайными символами. Написать 2 стратегии, 
>которые будут формировать строку на основе данного массива. Стратегия А - работает по принципу \*\_\*\_\*, 
>а стратегия B - работает по принципу \_\*\_\*\_ . Пример:

    input: 5 5
    output: 
    d a l p j 
    v c b z g 
    a d l r f 
    f d m x h 
    k d l h b 
    input strategy: A
    output: dljalfklb
> 2.3. Написать программу, которая будет генерировать пирамидку. Пример:

    input: 4
    output: 
    XXXX
    XXX
    XX
    X

### HW3 - [Strings](https://github.com/VLDRospuskov/epamejc2020/tree/ErmakovAleksandr/com.epamejc.lessons/src/main/java/homeworks/homework03)
> 3.1. Написать программу, которая генерирует новую строку на основании входных данных, строка + четные/нечетные. 
>Пример:

    Input: String        Input: even        output: tig
> 3.2. Написать программу, которая будет генерировать строку по индексам. Пример:

    Input: Hello World,     
    input: 0  output: H, 
    input: 4  output: Ho, 
    input: 6 output: HoW
> 3.3. Поменять местами символы в строке, на вход приходит строка и 2 индекса, между которыми нужно сделать обмен. 
> Пример:

    Input: Hello World
    Input: 0, 4
    output oelloH World
> 3.4. Написать программу, которая переворачивает слова, но при этом оставляет их на прежних местах. Пример:

    Input: Hello World
    output: olleH dlroW

### HW4 - [Recursion](https://github.com/VLDRospuskov/epamejc2020/tree/ErmakovAleksandr/com.epamejc.lessons/src/main/java/homeworks/homework04)
> 4.1. Поиск числа Фиббоначи

> 4.2. Написать программу, которая возводит число в степень:

    input number: 4
    input pow: 3
    output: 64
> 4.3. Посчитать количество цифр в числе:

    input: 567
    output: 3

### HW5 - [Tests](https://github.com/VLDRospuskov/epamejc2020/tree/ErmakovAleksandr/com.epamejc.lessons/src/test/java/homeworks)
> Покрыть код junit 4.12 тестами

### HW6 - [Annotation](https://github.com/VLDRospuskov/epamejc2020/tree/ErmakovAleksandr/com.epamejc.lessons/src/main/java/homeworks/homework06)
> Создать свою кастомную аннотацию где будет "имя - string" и "возраст - int", то есть в аннотации передаем 
>(name = "sdgf", age = "12"). 
> Повесить аннотацию на конструктор. 
> Цель - при создании объекта пустым конструктором инициализировать значениями из аннотации.

### HW7 - [Reader comparison](https://github.com/VLDRospuskov/epamejc2020/tree/ErmakovAleksandr/com.epamejc.lessons/src/main/java/homeworks/homework07)
> Создайте файл, заполните большим количеством текста, потом считайте его и запишите в другой файл. 
> Повторите, но используя buffered. Замерьте время выполнения без buffered и c buffered.

### HW8 - [Functional Interfaces and streams](https://github.com/VLDRospuskov/epamejc2020/tree/ErmakovAleksandr/com.epamejc.lessons/src/main/java/homeworks/homework08)
> Написать свои функциональные интерфейсы по типу BiFunction и Supplier(Producer).
  Создать любой класс с несколькими полями. Создать метод, который будет принимать
  функциональные интерфейсы, созданные ранее. Достать 2 поля и обработать полученные значения и вернуть.

> Реализовать стримы в классе StreamOperations.

### HW9 - [Multithreading + ATM simulation](https://github.com/VLDRospuskov/epamejc2020/tree/ErmakovAleksandr/com.epamejc.lessons/src/main/java/homeworks/homework09)
> Есть 1 общий счет(balance), существует несколько банкоматов(ATM) которые работают с этим счетом, 
> а счет виртуальный общий. Также существует несколько пользователей. которые будут ходить в эти банкоматы, 
> пополнять/снимать. Зациклить данный процесс. Добавить фичи, обязательно: в минус не выдавать денег, 
> у каждого пользователя есть свой баланс(количество денег, которое у них на руках).

>  ОПЦИОНАЛЬНО: У каждого банкомата есть свой отдельный баланс и если на нем заканчиваются деньги, 
> то из общего ресурса мы туда добавляем, а если в банкомате слишком много денег, то обратно отдаем в ресурс. 
> Другими словами добавляем процесс инкассации.

### FinalHW - [Seabattle](https://github.com/VLDRospuskov/epamejc2020/tree/ErmakovAleksandr/com.epamejc.lessons/src/main/java/seabattle)
> Написать морской бой.
