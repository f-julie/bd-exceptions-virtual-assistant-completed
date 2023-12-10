# Exceptions: Virtual Assistant

We are going to begin building a virtual assistant which can react
differently to keywords. Many virtual assistants will wait for a
'wake' keyword, often the name of the assistant, then begin
listening for further instructions before giving assistance. This
usually involves Natural Language Processing, which involves
parsing out and understanding of human language to identify what
is being asked. Our assistant will be on the lighter side.

Our virtual assistant will be waiting for their 'wake' word,
which will be whatever name we give the assistant. Immediately
after the 'wake' word, we will enter a specific keyword command.

An example:
```
Amaya time
```

Which would ask our assistant, Amaya, to tell us the time.

### Exceptions
Exceptions can and will occur in many areas of code. Some of the most
common exceptions are: 
```
NullPointerException
IndexOutOfBoundsException
ArrayIndexOutOfBoundsException
IllegalStateException
IllegalArgumentException
Arithmetic Exception
ClassCastException
```
There are an unlimited number of Exceptions that could occur. You
can write new Exception types yourself.

An Exception that does occur will usually generate a stack trace
to help the programmer identify where the exception took place
and find out the order of calls to get to that exception. It is not a
good practice to allow these exceptions to prevent programs from
continuing, so we often find ways to acknowledge the exception in
code and trigger and alternate action when one occurs.

This project will be focusing on throwing Exceptions and using 
try/catch blocks to allow for alternate results.




## Starting Code:

You are provided with a `Main` which builds a `VirtualAssistant`. 
Feel free to adjust the name of your assistant here.

You are provided with a beginning skeleton of the `VirtualAssistant`
class. The assistant can already wait for input, but does not
process the input correctly yet.
## Instructions

You are to add in the capability for the assistant to recognize its
name, specific keywords, and allow these keywords to function.
You will also focus on a variety of potential exceptions that may
occur and preventing those exceptions from stopping the program.


#### Requirements

- Create an enum, `KeywordEnum`, with the values: 
```
YELL
TIME
SUM
PRODUCT
LARGEST
PLAY
ORDER
SING
```
- Implement the completed project requirements below.
- Throw appropriate exceptions and use a try/catch for each unique one.

## A Completed Project Will:

- Prompt the user to offer assistance.

- In `processInput` check the user's input to see if it begins 
with the assistant's name. If not produce an `IncorrectNameException` 
and then handle the exception in the `run` method.

- In `processInput` check the user's input to see if any text was 
typed after the assistant's name, if not produce a
`NoKeywordProvidedException` and then handle the exception in 
the `run` method.

- In `processInput` convert the text after the assistant's name
into a `KeywordEnum`. All enums have a static method, `valueOf`,
which will take in a String and convert the String to the 
correct enum value. However, this may throw an exception. Handle
the exception.

- Use a `switch` statement to determine which keyword was
inputted. For each of the keywords, implement the following
actions:

##### YELL
Prompt the user 'What would you like me to yell?'. 
Get new input and print back the input in all uppercase with an !.

##### TIME
Use the `getCurrentTime` method and print the result.


##### SUM
Prompt the user 'Type in the numbers to sum separated by a space.' 
Get new input then call the `sum` method and print the result.
You will need to implement the sum method. We will use Scanner
to get each number.

##### PRODUCT
Prompt the user 'Type in the numbers to multiply separated by a space.'
Get new input then call the `product` method and print the result.
You will need to implement the product method. We will use Scanner
to get each number.

##### LARGEST
Prompt the user 'Type in the numbers separated by a space.'
Get new input then call the `largest` method and print the result.
You will need to implement the largest method. We will use Scanner
to get each number.

##### OTHER KEYWORDS
Throw a KeywordNotImplementedException and handle this result
in the `run` method.



## Extension

Try implementing the SONG keyword. Create a few different 'songs'
(just some lyrics) and randomly choose one to sing (print) back.
