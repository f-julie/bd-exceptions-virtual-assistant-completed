package assistant;

import CustomExceptions.IncorrectNameException;
import CustomExceptions.KeywordNotImplementedException;
import CustomExceptions.NoKeywordProvidedException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class VirtualAssistant {

    private static final String startingPrompt = "How may I help you? Type 'quit' to end assistance.";
    private static final String stopProgramKeyword = "quit";

    private String name;



    // TODO Create the KeywordEnum

    public enum KeywordEnum {
        YELL,
        TIME,
        SUM,
        PRODUCT,
        LARGEST,
        PLAY,
        ORDER,
        SING
    }



    public VirtualAssistant(String name) {
        this.name = name;
    }

    /**
     *
     * @param input
     * @param scanner
     * @throws IncorrectNameException
     * @throws NoKeywordProvidedException
     * @throws KeywordNotImplementedException
     */

    public void processInput(String input, Scanner scanner)
            throws IncorrectNameException,
            NoKeywordProvidedException,
            KeywordNotImplementedException {
        // TODO Follow instructions on README
        // Does input start with our Assistant's name?
        if (!input.startsWith(name + " ")) {
            throw new IncorrectNameException();
        }

        // Is there anything after the assistant's name?
        // I could substring off the name
        // I could check the length
        String keyword = input.substring(name.length() + 1);
        keyword = keyword.trim().toUpperCase();

        if (keyword.equals("")) {
            throw new NoKeywordProvidedException();
        }

        KeywordEnum key = KeywordEnum.valueOf(keyword);

        switch (key) {
            case YELL:
                String yellInput = waitForNextLine("What would you like me to yell?", scanner);
                System.out.println(yellInput.toUpperCase() + "!");
                break;
            case TIME:
                System.out.println(getCurrentTime());
                break;
            case SUM:
                String sumInput = waitForNextLine("Type in the numbers to sum separated by a space.", scanner);
                System.out.println("The sum of those numbers is " + sum(sumInput));
                break;
            case PRODUCT:
                String productInput = waitForNextLine("Type in the numbers to multiply separated by a space.", scanner);
                System.out.println("The product of those numbers is " + product(productInput));
                break;
            case LARGEST:
                String largestInput = waitForNextLine("Type in the numbers separated by a space.", scanner);
                System.out.println("The largest of those numbers is " + largest(largestInput));
                break;
            default:
                throw new KeywordNotImplementedException();
        }
    }

    /**
     * Places the virtual assistant into a run mode, where it is listening for the
     * next typed in text. The assistant will end when 'quit' is entered as an input.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String input = waitForNextLine(startingPrompt, scanner);

        while (!input.equalsIgnoreCase(stopProgramKeyword)) {
            // TODO Fix exceptions that will occur upon further implementation of process input.
            try {
                processInput(input, scanner);
            } catch (IncorrectNameException e) {
                System.out.println("Please start your command with the assistant's name.");
            } catch (NoKeywordProvidedException e) {
                System.out.println("Please enter a keyword after the assistant's name.");
            } catch (IllegalArgumentException e) {
                System.out.println("I do not know that command.");
            } catch (InputMismatchException e) {
                System.out.println("I can only apply that command to numbers.");
            } catch (NoSuchElementException e) {
                System.out.println("You must give me input to calculate the largest.");
            } catch (KeywordNotImplementedException e) {
                System.out.println("This feature is not yet implemented.");
            }

            System.out.println();
            input = waitForNextLine(startingPrompt, scanner);
        }
    }

    /**
     * Returns the sum of all the numbers in values.
     * Throws an InputMismatchException if values is not only numbers.
     * @param values numbers separated by spaces
     * @return the sum of all the number in values
     */
    public double sum(String values) {
        // TODO Implement this method.
        Scanner scanner = new Scanner(values);

        double sumResult = 0.0;
        while (scanner.hasNext()) {
            sumResult += scanner.nextDouble();
        }

        return sumResult;
    }

    /**
     * Calculates the product of all the numbers in values.
     * Throws an InputMismatchException if values is not only numbers.
     * @param values numbers separated by spaces
     * @return the product of all the number in values
     */
    public double product(String values) {
        // TODO Implement this method.
        Scanner scanner = new Scanner(values);

        double productResult = 1.0;
        while (scanner.hasNext()) {
            productResult *= scanner.nextDouble();
        }

        return productResult;
    }

    /**
     * Calculates the largest number in values.
     * Throws an InputMismatchException if values is not only numbers.
     * @param values numbers separated by spaces
     * @return the largest number in values
     */
    public double largest(String values) {
        // TODO Implement this method.
        Scanner scanner = new Scanner(values);

        double biggest = scanner.nextDouble();
        // The first number I hear is the potential largest.
        // Now compare the next I hear to my largest. If it is larger, update my mental largest value.
        // Keep doing that for every new number.

        while (scanner.hasNext()) {
            double current = scanner.nextDouble();
            if (current > biggest) {
                biggest = current;
            }
        }

        return biggest;
    }

    /**
     * Gets the current hour:minute:seconds of the user.
     * @return the current time in Hour:minute:second format
     */
    public String getCurrentTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dateTimeFormatter.format(now);
    }

    /**
     * Gets the next input from the keyboard.
     * @param prompt the words the assistant will use to ask the user for more information
     * @param scanner the opened Scanner capable of inputting text
     * @return the next line of text the user inputted
     */
    public String waitForNextLine(String prompt, Scanner scanner) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
