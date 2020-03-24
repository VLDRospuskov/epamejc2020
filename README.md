# epamejc2020 

##**Homeworks**

#### *Homework 1. Traffic lights*
| Input      | Output |
|------------|--------|
|from 0 to 3 | green  |
|from 4 to 5 | yellow |
|from 6 to 10| red    |
|exit        | *program stops*|

see [Traffic Lights](../tree/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw1)

#### *Homework 2. Immutable class example*
see [Immutable class](../tree/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw2)


#### *Homework 3. Arrays*
**Consists of following tasks:**
1. Create 2 dimensions array which contains random characters. 
    
    [Array task 1](../blob/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw3/RandomCharArray.java)
2. Create 2D array which contains random characters. Implement strategies of string creation based on the created array.
    
    Strategy A: char_char_char (where char is character from array and _ is skipped character)
    Strategy B: _char_char_
    
    [Array task 2](../blob/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw3/StringFromArray.java)

3. Create a pyramid out of X-s.
    
    [Array task 3](../blob/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw3/Pyramid.java)
    
see [Arrays homework](../tree/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw3)


#### *Homework 4. Strings*
**Consists of following tasks:**
1. Make a program that generates a string based on an input where input consists information on whether use even or odd
characters of input string

    [String task 1](../blob/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw4/EvenOdd.java)
    
2. Make a program that generates string based on indices (which are received as input)

    [String task 2](../blob/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw4/StringByIndices.java)
    
3. Make a program which swaps symbols located in places (which are received as input)
    
    [String task 3](../blob/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw4/SwitchSymbols.java)
    
4. Make a program which reverses every word in the input string while not changing words' order

    [String task 4](../blob/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw4/ReverseString.java)    

see [Strings homework](../tree/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw4)


#### *Homework 5. Recursion*
**Consists of following tasks:**
1. Find a Fibonacci number located at the place received as an input
    
    [Recursion task 1](../blob/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw5/Fibonacci.java)
    
2. Calculate power of a number
    
    [Recursion task 2](../blob/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw5/Power.java)
    
3. Count the number of digits

    [Recursion task 3](../blob/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw5/DigitsNumber.java)

see [Recursion](../tree/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw5)


#### *Homework 6. Custom annotation*
Create a custom annotation with parameters *name* (String) and *age* (int)
Create an instance of a class with empty constructor and replace the values of name and age to name and ages received
from annotation using reflection

see [Custom annotation](../tree/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw6)


#### *Homework 7. Java IO and files*
Create a file, generate or put a text in it. Read it and rewrite to another file. 
Use two methods (reader and buffered reader).

see [Java IO and files](../tree/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw7)


#### *Homework 8. Functional interfaces & Stream operations*
***Functional interfaces***

Create functional interfaces such as BiFunction and Supplier and work with them

see    [Functional interfaces task](../tree/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw8/functionalInterfaces)


***Stream operations***
Implement stream operations in given file

see [Stream operations task](../tree/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw8/streamOperations)


#### *Homework 9. Multithreading*
Work with multithreading operations using ATMs with common balance as the base of the example

see [Multithreading](../tree/renataGimranova/com.epamejc.lessons/src/main/homeworks/hw9)


#### *Homework 10. Battleship/Sea battle*
As an OOP practice create a battleship game.

Standard field 10x10. Players get to place 10 ships - 4 ships with 1 deck; 3 ships with 2 decks; 2 ships with 3 decks;
1 ship with 4 decks.

Ships are not allowed to cross or be placed next to each other without an empty space between them.

**Implemented:**
* Ship placement (to place a ship of said length type *character number number*, where *character* is a letter which
    defines the coordinate of chosen point, first *number* is the second coordinate, second *number* is used to define
    the direction of the ship - 0 is horizontal, 1 is vertical)
* Player vs Player game mode
* Game ends whenever all ships of one of the player are destroyed

**WIP:**
* Player vs AI game mode
