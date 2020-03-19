# epamejc2020 - Vitaly Bogdanov 
HW 1 [TrafficLight](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw1)  
Создать "светофор", который выводит сигнал-цвет. Вы вводите время от 0-3 минуты - зеленый,
4-5 минуты - желтый, 6-10 красный. Вводим цифру 0 до n, получаем результат. Работу программы
сделать непрерывной, выход можно обработать.
***
HW 2 [ImmutableInt](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw2/)  
Создать immutable class, создать пару объектов, посмотреть как работает, поэксперементировать с данными. ЗАПОМНИТЬ!
***  
HW 3-1 [ArrayOfArraysGenerator](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw3/arrays_1)  
Создать массив массивов, задается размерность на основании которое генерируются случайные символы типа char.  
Input: 4 2  
output:  
k c   
b p  
b h  
h g  

HW 3-2 [StringGeneratorFromArrayByStrategy](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw3/arrays_2)  
Сгенерировать массив массивов указав размерность, заполнить его случайными символами. Написать 2 стратегии, которые будут формировать строку на основе данного массива. Стратегия А - работает по принципу *_*_*, а стратегия B - работает по принципу _*_*_ .   Пример:
input: 5 5  
output:  
d a l p j   
v c b z g  
a d l r f  
f d m x h  
k d l h b  
input strategy: A  
output: dljalfklb  
  
HW 3-3 [PyramidGenerator](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw3/arrays_3)  
Написать программу которая будет генерировать пирамидку. Пример:  
input: 10  
output:  
XXXXXXXXXX  
XXXXXXXXX  
XXXXXXXX  
XXXXXXX  
XXXXXX  
XXXXX  
XXXX  
XXX  
XX  
X  

***  
HW 4-1 [PrintOddOrEvenCharsFromString](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw4/strings_1)  
Написать программу которая генерирует новую строку на основании входных данных, строка + четные/нечетные, пример:  
Input: String        Input: even        output: tig

HW 4-2 [GenerateStringFromInputStringByIndex](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw4/strings_2)  
Написать программу которая будет генерировать строку по индексам. Пример:  
Input: Hello World,      
input: 0  output: H,  
input: 4  output: Ho,  
input: 6 output: HoW  

HW 4-3 [Change chars in line by indexes](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw4/strings_3)  
Поменять местами символы в строке, на вход приходит строка и 2 индекса между, которыми нужно сделать обмен. Пример:  
Input: Hello World  
Input: 0, 4  
output oelloH World  
  
HW 4-4 [Reverse words](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw4/strings_4)  
Написать программу которая переворачивает слова, но при этом оставляет их на прежних местах. Пример  
Input: Hello World  
output: olleH dlroW  

***  
HW 5-1 [Fibonacci generator](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw5/recursion_1)  
Поиск числа Фиббоначи
  
HW 5-2 [Exponentiation](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw5/recursion_2)  
Написать программу которая умеет вовзодить в степени:  
input number: 4  
input pow: 3  
output: 64  
  
HW 5-3 [Digits counter](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw5/recursion_3)  
Посчитать количество чисел:  
input: 567  
output: 3  
  
***
HW 6 [PersonFields (Annotation)](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw6)  
Создать свою кастомную аннотацию где будет "имя - string" и "возраст - int", то есть в аннотации передаем (name = "sdgf", age = "12"). Повесить аннотацию на конструктор. Цель сделать так чтобы когда у нас будет создаваться объект по типу Person person = new Person() - конструктор пустой, через рефлексию мы должны достать данные из аннотации и подсунуть при инициализации объекта name и age из аннотации. Используйте ломбок.  
***
HW 7 [File copy](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw7)  
Создайте файл, заполните его текстом(много текста), потом считайте его и запишите в другой файл. Сделайте 2ой метод такой же  только с buffered. Замерьте время выполнения без buffered и c buffered.
***
HW 8-1 [Functional interfaces](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw8/functional_interfaces)  
Написать свои функциональные интерфейсы по типу BiFunction и Supplier(Producer). Создать любой класс с несколькими полями. Создать метод, который будет принимать функциональные интерфейсы, созданные ранее. Достать 2 поля и обработать полученные значения и вернуть.
***
HW 8-2 [Streams](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw8/streams)  
В classe StreamOperations реализовать стримы  
***
HW 9 [ATM (Threads)](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw9)  
У нас есть 1 общий счет(balance), существует несколько банкоматов(ATM) которые работают с этим счетом - типа они в разных частях города, а счет виртуальный общий. Также существует несколько пользователей. которые будут ходить в эти банкоматы, пополнять/снимать/возможно еще что-нибудь, например проверять баланс. Соответственно зацикливаем данный процесс. Добавить фичи, обязательно: в минус не выдавать денег, целочисленный тип тут не подойдет для работы с деньгами, подумайте какой тип следует использовать, еще у каждого пользователя есть свой баланс(количество денег, которое у них на руках).

Можно добавить еще одну фичу, но это опционально. Допустим у каждого банкомата есть свой отдельный баланс и если на нем заканчиваются деньги, то из общего ресурса мы туда добавляем, а если в банкомате слишком много денег, то обратно отдаем в ресурс. Другими словами добавляем процесс инкассации.