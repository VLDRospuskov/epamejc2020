# epamejc2020 Andrew Nuzha
## Developed solutions:



## [Homework 1 - Traffic Light][HW1]
Write a program that determines the traffic light color depending on the entered time.\
Example input: 0 - 3\
Example output: Green light

## [Homework 2 - Immutable Class][HW2]
Create an immutable class and try to manipulate it
## [Homework 3 - Arrays][HW3]
#### [3.1 - Array Generation][HW3_1]
Create an array of arrays (the size is specified in user input) and fill it with characters.\
Example input: 3 3\
Example output:\
a b c\
t n n\
r f w\
z x g

#### [3.2 - Array Generation With Strategies][HW3_2]
The program generates an array of arrays (the user enters a size), fills it with random characters. 
Next, the user indicates the strategy number (1 for even characters in every even line of an array or 2 for 
odd characters of every odd line of an array) and the program collects a string from the array based on 
the selected strategy.\
Example:
1. Enter the number of lines: 3
2. Enter the number of rows: 3
3. Enter number of strategy: 1
4. Generated array:\
m  X  O\
C  m  Z\
G  V  T
5. Generated string: mOGT

#### [3.3 - Pyramid Generation][HW3_3]
The program prints in the console a pyramid of the specified size\
## [Homework 4 - Strings][HW4]
#### [4.1 - Even Or Odd String][HW4_1]
The program generates a new string based on the entered string and strategy. After entering a string and a strategy, 
the program deletes even/odd characters from the entered string.
Example:
1. Enter the string: Hello World
2. Select characters to be removed: even
3. Transformed string: HloWrd

#### [4.2 - Index String Generation][HW4_2]
The program generates a new string based on the entered string and the specified index of the entered string.\
Example:
1. Enter the string: Hello
2. Enter the char index of entered string: 3
3. Result string: l
4. Enter the char index of entered string: 0
5. Result string: lH

#### [4.3 - Replace Chars By Indices][HW4_3]
The program swaps the characters in the entered string based on their indices.\
Example:
1. Enter the string: Hello
2. Enter indices to change: 0 4
3. Result string: oellH

#### [4.4 - String Reverse][HW4_4]
The program reverses the words in the entered line, keeping their order.\
Example:
1. Enter a few words separated by a space: Hello World Again
2. Reversed string: olleH dlroW niagA

## [Homework 5 - Recursion][HW5]
#### [5.1 - Count Numbers][HW5_1]
The program counts the number of digits.\
Example: 
1. Enter the number: 666
2. The number of digits: 3
#### [5.2 - Fibonacci Number][HW5_2]
The program counts the Fibonacci number.\
Example:
1. Enter integer number: 10
2. Fibonacci number is: 55
#### [5.3 - Number To Power][HW5_3]
The program counts the number in degree.\
Example:
1. Enter integer number for base: 5
2. Enter integer number for power: 5
3. 5^5 is: 3125

## [Homework 6 - Annotations][HW6]
Create your own annotation with two fields. Attach it to the class constructor. Using reflection, during initialization 
of an object, set the field values from the annotation.

## [Homework 7 - Files][HW7]
The program measures the time of work of buffered and standard file reader/writer.

## [Homework 8 - Functional And Stream][HW8]
#### [8.1 - My Functional][HW8_1]
Create your own functional interfaces: BiFunction and Supplier (Producer). Create any class with several fields. 
Create a method which uses functional interfaces as a parameters. After do some operations and calculations with these
functional interfaces and get a result.
#### [8.2 - Stream Operations][HW8_2]
Implement streams in the StreamOperations class.

## [Homework 9 - Multithreading][HW9]
Create an ATM simulation process. There is one bank account with which several ATMs work. Several users use ATMs and 
perform different actions.

## [Sea Battle][HW10]
The game sea battle includes a game mode with a bot. You can place ships manually or automatically. Next begins the 
game according to the rules of the sea battle.

[HW1]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW1_trafficLight
[HW2]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW2_immutableClass
[Hw3]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW3_arrays
[HW3_1]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW3_arrays/arrayGeneration
[HW3_2]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW3_arrays/arrayGenerationWithStrategies
[HW3_3]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW3_arrays/pyramidGeneration
[HW4]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW4_strings
[HW4_1]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW4_strings/evenOrOddString
[HW4_2]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW4_strings/indexStringGeneration
[HW4_3]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW4_strings/replaceCharsByIndices
[HW4_4]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW4_strings/stringReverse
[HW5]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW5_recursion
[HW5_1]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW5_recursion/countNumbers 
[HW5_2]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW5_recursion/fibonacciNumber
[HW5_3]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW5_recursion/numberToPower
[HW6]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW6_annotations
[HW7]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW7_files
[HW8]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW8_functionalAndStream
[HW8_1]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW8_functionalAndStream/myFunctional
[HW8_2]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW8_functionalAndStream/streamOperations
[HW9]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/HW9_multithreading
[HW10]:https://github.com/VLDRospuskov/epamejc2020/tree/AndrewNuzha/com.epamejc.lessons/src/main/java/homeworks/seaBattle


