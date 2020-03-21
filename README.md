# epamejc2020 - Vitaly Bogdanov   
**Attention!!! The structure is different from the parent project!**  
The root of the project should be the module com.epamejc.lessons  
(I have deleted the project in which the com.epamejc.lessons module was lying)    

***
[SeaBattle](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/seabattle/java/)  
Sea battle. Implemented the ability to play both with another player (person) and with a computer.
Implemented the possibility of manual and auto placement of ships. With manual placement, only the coordinate of the start and end cells of the ship is entered. The ship itself calculates its cells. Everything is checked, if you try to set the ship in the wrong place, the logic of the ship will not allow this to be done.
Implemented an algorithm for "finishing off" a wounded ship.  
 
***
HW 1 [TrafficLight](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw1)  
Create a “traffic light” that outputs a signal-color. You enter a time from 0-3 minutes - green,
4-5 minutes - yellow, 6-10 red. Enter the number 0 to n, we get the result. Program work
make continuous, the output can be processed.
***
HW 2 [ImmutableInt](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw2/)  
Create an immutable class, create a couple of objects, see how it works, experiment with the data. REMEMBER!  
***  
HW 3-1 [ArrayOfArraysGenerator](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw3/arrays_1)  
Create an array of arrays, sets the dimension based on which random characters of type char are generated.  
Input: 4 2  
output:  
k c   
b p  
b h  
h g  

HW 3-2 [StringGeneratorFromArrayByStrategy](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw3/arrays_2)  
Generate an array of arrays specifying the dimension, fill it with random characters. Write 2 strategies that will form a string based on this array. Strategy A - works on the principle of ABABA, and strategy B - works on the principle of BABAB. Example:  
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
Write a program that will generate a pyramid. Example:  
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
Write a program that generates a new line based on the input data, line + even / odd, example:  
Input: String        Input: even        output: tig

HW 4-2 [GenerateStringFromInputStringByIndex](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw4/strings_2)  
Write a program that will generate a string by index. Example:  
Input: Hello World,      
input: 0  output: H,  
input: 4  output: Ho,  
input: 6 output: HoW  

HW 4-3 [Change chars in line by indexes](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw4/strings_3)  
To interchange the characters in the string, the string and 2 indices between which you want to exchange come to the input. Example:  
Input: Hello World  
Input: 0, 4  
output oelloH World  
  
HW 4-4 [Reverse words](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw4/strings_4)  
Write a program that flips words, but leaves them in their original places. Example:   
Input: Hello World  
output: olleH dlroW  

***  
HW 5-1 [Fibonacci generator](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw5/recursion_1)  
Fibonacci number search
  
HW 5-2 [Exponentiation](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw5/recursion_2)  
Write a program that can integrate to the degree of:
input number: 4  
input pow: 3  
output: 64  
  
HW 5-3 [Digits counter](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw5/recursion_3)  
Count numbers of digits:  
input: 567  
output: 3  
  
***
HW 6 [PersonFields (Annotation)](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw6)  
Create your custom annotation, where there will be an annotation before the name (name = "sdgf", age = "12"). Hang the annotation on the constructor. Face = new person () - the constructor is empty, through reflection we should get the annotation data and slip the name and age from the annotation when initializing the object. Use lombok.  
***
HW 7 [File copy](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw7)  
Create a file, fill it with text (a lot of text), then read it and write it to another file. Make the second method the same only with buffered. Measure runtime without buffered and with buffered.  
***
HW 8-1 [Functional interfaces](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw8/functional_interfaces)  
Write your own functional interfaces like BiFunction and Supplier (Producer). Create any class with multiple fields. Create a method that will accept functional interfaces created earlier. Get 2 fields and process the received values and return.  
***
HW 8-2 [Streams](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw8/streams)  
In classe StreamOperations implement streams  
***
HW 9 [ATM (Threads)](https://github.com/VLDRospuskov/epamejc2020/tree/Vitaly_Bogdanov/com.epamejc.lessons/src/main/homeworks/java/hw9)  
We have 1 general account (balance), there are several ATMs (ATMs) that work with this account - they are like in different parts of the city, and the virtual account is common. There are also several users. who will go to these ATMs, deposit / withdraw / maybe something else, for example, check the balance. Accordingly, we loop this process. To add features, it is mandatory: do not give out money in minus, the integer type here is not suitable for working with money, think about which type should be used, each user also has his own balance.

You can add another feature, but this is optional. Suppose each ATM has its own separate balance and if money runs out on it, then we add it to the common resource, and if there is too much money in the ATM, then we return it to the resource. In other words, we add the collection process.