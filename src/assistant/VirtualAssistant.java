package assistant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VirtualAssistant {

    private static final String startingPrompt = "How may I help you? Type 'quit' to end assistance.";
    private static final String stopProgramKeyword = "quit";

    private String name;



    // TODO Create the KeywordEnum



    public VirtualAssistant(String name) {
        this.name = name;
    }

    public void processInput(String input, Scanner scanner) {
        // TODO Follow instructions on README

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
            processInput(input, scanner);




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
        return 0.0;
    }

    /**
     * Calculates the product of all the numbers in values.
     * Throws an InputMismatchException if values is not only numbers.
     * @param values numbers separated by spaces
     * @return the product of all the number in values
     */
    public double product(String values) {
        // TODO Implement this method.
        return 0.0;
    }

    /**
     * Calculates the largest number in values.
     * Throws an InputMismatchException if values is not only numbers.
     * @param values numbers separated by spaces
     * @return the largest number in values
     */
    public double largest(String values) {
        // TODO Implement this method.
        return 0.0;
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
