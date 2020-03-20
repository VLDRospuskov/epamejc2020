# epamejc2020 \m/
#### HW1 - TrafficLight

The logic follows:
input from 0 to 3 (minutes) - output is green,
input from 4 to 5 - output is yellow,
input from 6 to 10 - output is red.
In total: we put a number from 0 to n and get the result based on that number.
Program works continuously, exit executes by input "exit".

#### HW2 - Own immutable class
Immutable class of student instance(ImmutableClassStudent) was created. Class has field from mutable class MutableAge.
In StudentCreatorClass some operations were made on student's field.

#### HW3 - Arrays

Arrays tasks:

1. Create double array, dimension defines by console input. Array contains a random chars.

Example:
Input: 4 2
output:
k c
b p
b h
h g

2. Generate double array with definable dimension, fill it by random chars.
Implement 2 strategies that makes string on base of that array.
strategy A - *_*_* (* - word in output, _ - word is skipped)
strategyB - _*_*_ .

Example:
input: 5 5
output:
d a l p j
v c b z g
a d l r f
f d m x h
k d l h b
input strategy: A
output: dljalfklb

3. Make a program that will make a pyramid.
Example:

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

#### HW4 - Strings
##### Strings tasks
1. Make a program that generates a string on base of input (string + even/odd).

Example:
Input: String
Input: even
output: tig

2. Make a program that generates a string by indexes.

Example:

Input: Hello World,
input: 0  output: H,
input: 4  output: Ho,
input: 6 output: HoW

3. Make a program that switches the places of symbols.
On input we have a line and two indexes of chars which should be swapped.

Example:

Input: Hello World
Input: 0, 4
output oelloH World

4. Make a program which reverses the words in the line but remains them on there places.

Example:

Input: Hello World
output: olleH dlroW

#### HW5 - Recursion
Recursion

1. Finding the Fibonacci number. The row starts from 0.

2. Make a program to calculate the number raised to the power:

input number: 4
input pow: 3
output: 64

3. Count the number of digits:

input: 567
output: 3

#### HW6 - Custom Annotation
Create a custom annotation with "name - string" and "age - int",
so, in annotation we pass the follow (name = "sdgf", age = "12")).
Put the annotation before the constructor of class Person.
Create an instance of Person with empty constructor (Person person = new Person()) and use the reflection to replace
the values of name and age when object initializing to the annotation name and age values. Use the Lombok.

#### HW7 - Java IO
Create a files, put the text into (big amount), then reade it and rewrite to another file.
Make the second method, which does the same, but with using buffer.

#### HW8 - Functional Interfaces and Stream Operations
1. Make your own functional interfaces like BiFunction and Supplier(Producer).
Create any class with several fields. Create a method which will use created interfaces.
Get two fields, process them and return.
2. In class StreamOperations implement the streams.

#### HW9 - Multithreading.

Generate a multithreaded operations from several ATMs with common balance.

#### SEA BATTLE

##### Task:
Make a standard sea battle. [Sea battle - wikipedia (on russian)](https://ru.wikipedia.org/wiki/%D0%9C%D0%BE%D1%80%D1%81%D0%BA%D0%BE%D0%B9_%D0%B1%D0%BE%D0%B9_(%D0%B8%D0%B3%D1%80%D0%B0))
Field 10 x 10, ships list the follow:
4 pieces of 1-deck ships;
3 pieces of 2-decks ships;
2 pieces of 3-decks ships;
1 piece of 4-decks ship.
There has to be a space between ships on field.
While battle if attack was lucky and ship has been hit or sank - keep attacking.

##### Realized:
+ Game with Bot is possible.
+ You can see the log of the whole game.
+ Player can fill the field by himself or to choose automatic filling.
+ Bot field  is filled automatically.
+ When player or Bot hits an enemy ship next attacks the one who hit.
+ If Bot hits the players ship in next step he hits the neighbour point.
+ Bot doesn't attacks the points around sank ship.
+ The game ends when all ships on one side are sank.

##### Remaining problems:

* If Bot hits the neighbour point after first hitting the players ship and new point is empty (Bot misses)
he wouldn't try to finish off discovered ship and will return to random attack.
* (minor) If player fills his field be his own, the Bot attacks first.
