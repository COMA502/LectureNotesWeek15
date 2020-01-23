
#Final Project: Hangman
Hangman is a classic word game where there are empty spaces for each letter in a word and the player must guess the letters.
For each wrong guess the player makes, a head, body, arm or leg is drawn on a hanging man. After six wrong guesses, the hanging man is complete and the play loses.
The following is an example of a game the player lost:
```
   _____   
  |     |        Wrong Guesses: ELYCWBU
  |     0  
  |    \|/ 
  |     |  
  |    / \ 
__|__      

  
 _ R _ _ R _ _ _ I _ _
```

#Requirements

##Repository and Submission
You'll be submitting this project the same way you submit your assignments. Review how to start and submit an assignment by refer to the [Tutorial in Course Contents](https://dmacc.blackboard.com/webapps/blackboard/content/launchLink.jsp?course_id=_72661_1&content_id=_4238749_1&mode=cpview).  Ask questions early in Slack if you need help!

##Game Loop
###Start
The game starts by:
1. printing the instructions
1. printing an empty hangman
1. loading a random word from a text file of words
1. printing blank spaces for the word to guess.

The text file of words can be in any format, but must support any number of words.

Here's an example of the output in command line:
```
Welcome to Hangman!
Type a letter you think is in the word below and press <ENTER>. Get a letter wrong and 
another body part appears on the person. Get a full body and you lose!

   _____   
  |     |        Wrong Guesses: 
  |        
  |        
  |        
  |        
__|__      

  
 _ _ _ _ _ _ _ _ _ _ _
```


###User Interaction
The user can then enter a letter and press `<ENTER>`. If the guess is correct, then fill in all blanks that represent that letter. If the guess is wrong, then add a body part to the hangman and include the letter in the "WRONG GUESSES" list.

The following is an example where the word is "PROGRAMMING" and the user incorrectly guessed "E" and correctly guessed "R".
```
   _____   
  |     |        Wrong Guesses: E
  |     0  
  |        
  |        
  |        
__|__      

  
 _ R _ _ R _ _ _ _ _ _
```

###Losing
Once the user has made six incorrect guesses
1. print the full hangman body
1. print "You lose..."
1. exit the game

###Winning
Once the user correctly guesses all letters:
1. print "You win!"
1. ask for their name
1. save and print the top 10 high scores
1. exit the game

The high scores must be saved and read from a text file. The following is an example of printing the high scores:
```
Top 10 High Scores
# Wrong | Date       | Name
   0    | 01/03/2020 | Harry
   3    | 01/01/2020 | Cathy
   5    | 01/01/2020 | Tom
```

#Grading
##60 Points Possible
Note that to get all points, your code must be able to compile and include the following elements.

###(15 points) All functionality from the Game Loop description above

###(15 points) Your code must include at least one of all of the following:
* if/else block
* While loop, for loop **or** for each loop
* An array, list, set **or** map
* Reading user input
* Class containing at least one member variable **and** one constructor

###(15 points) Your code must use all of the following clean code and object oriented practices:
* Classes, methods and variables named so that they are readable
* Logic broken into methods to make code more readable
* Logic broken into classes to make code more readable
* If an exception occurs, either recover from it or output a message that makes sense
* Consider Encapsulation and Abstraction in how you design your classes

###(7 points) User Input Validation
* Handle if the user inputs nothing
* Handle if the user inputs more than one letter
* Handle if the user inputs a non-letter (e.g. special character or number)

###(8 points) Files
* Reading from a text file of words
* Reading and saving the top 10 high scores
