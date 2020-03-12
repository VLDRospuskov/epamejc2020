# epamejc2020 \o/


### Homework description

#### homework1:
    Traffic light that shows color based on user input that can be integer or double:
    0-4 = GREEN , 4-6 = YELLOW , 6-10 = RED
 
#### homework2:
##### Factory Method:
    Creating objects of classes based on interface Human via pattern Factory Method
##### Immutable Class:
    Implementation of immutable and ordinary classes and their comparison
    
#### homework3:
##### All in one:
    Making pyramid generator, random char generator and strategy char generator work in parallel
    via ExecutorService
##### Pyramid generator:
    Generating and printing a colored pyramid based on user input
##### Random char generator:
    Generating and printing a colored matrix of random generated chars based on user input
##### Strategy char generator:
    Generating and printing a colored matrix of random generated chars based on user input
    and creating a new array from that matrix based on even or odd combination 
    of rows and columns
    
#### homework4:
##### Even odd string:
    Generating new string from user string based on even or odd sequence
##### Index String Generator:
    Generating new string from user string based on next principles:
    Input: Hello World,     
    input: 0  output: H, 
    input: 4  output: Ho, 
    input: 6 output: HoW
##### Reverse words:
    Creating new string that contains of reversed words from user string
##### Swap chars:
    Creating new string from user string with swapped chars based on user input
    
#### homework5:
##### Dozens counter hard:
    Count amout of digits in user input with converting it to numbers.
    User input can be integer or double
##### Dozens counter lite:
    Count amout of digits in user input which can be integer or double
##### Exponentiation:
    Exponentation of number to steppe based on user input
##### Find Fibonacci:
    Generating an array of random integers in range 0-100 with user length
    
#### homework6:
    Using package level annotation in class constructor
    
#### homework7:
    Comparison speed of BufferedReader using write and read, BufferedReader using write and readLine
    and FileReader and FileWriter.
    Files located in resources
    
#### homework8:
##### Part1:
    Creating our own functional interfaces and using them in streams and lambdas
##### Part2:
    Implementations of particular methods in StreamOperations using stream

#### multithreading
    Imitation of bank working with several ATMs with their users in parallel
    
#### sea battle:
    Implemantation of well known sea battle game on terminal:
    
    Available game modes: Player vs Player; Player vs Bot; Bot vs Bot;
    
    Ship rules '■':
    - Amount of ships each type is limited: 4 cells - 1; 3 cells - 2;
      2 cells - 3; 1 cell - 4;
    - Ship should be a non-diagonal straight line and position of each it's cell should be at least
      on cell away from amother ships cells;
      
    Player can choose cells to put his ship in format 'a1 a2 a3 a4' according to ship rules;
    Bot generates positions of it's ships randomly according to ship rules;
    
    Shot rules:
    - Player can't shoot twice in one cell;
    - Players move ends if you miss opponents ship 'x';
    - If player hit opponents ship he can shoot again '¤';
    - If player killed opponents ship it becomes '□' and he can shoot again;
    - If player killed all opponents ships game ends immediately;
    
    Player can choose where to shoot in format 'e5' according to shot rules;
    Bot generates where to shoot randomly according to shot rules, but: 
    - If it hits opponents ship for the first time it seeks nearby non-diagonal cells to hit it again;
    - If it hits opponents ship again it seeks nearby horizontal or vertical cells according to ship
      orientation to hit it again;
    - If it kills opponents ship it starts to shoot at random positions, but not near dead ships;
    
    At the end of the game player can see the congratulations and amount of his moves;
    
#### test:
    Unit tests on homeworks