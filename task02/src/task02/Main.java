package task02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File save = new File("./task02/last.txt");

        //create save file if it doesnt exist.
        try {
            save.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Welcome.");

        String input = "";

        while (!input.equals("exit")) {

            Scanner inputReader = new Scanner(System.in);

            switch (input = inputReader.nextLine()) {
                case "exit": {
                    System.out.println("Bye bye");
                    break;
                }
                default: {
                    String[] split = input.split(" ");
                    float first = readOperator(split[0]);
                    float second = readOperator(split[2]);
                    float answer;
                    String operand = split[1];

                    switch (operand) {
                        case "+": {
                            answer = first + second;
                            System.out.printf("%.0f\n", answer);
                            write(answer);
                            break;
                        }
                        case "-": {
                            answer = first - second;
                            System.out.printf("%.0f\n", answer);
                            write(answer);
                            break;
                        }
                        case "/": {
                            answer = first / second;
                            System.out.printf("%.0f\n", answer);
                            write(answer);
                            break;
                        }
                        case "*": {
                            answer = first * second;
                            System.out.printf("%.0f\n", answer);
                            write(answer);
                            break;
                        }
                        default: {
                            break;
                        }
                    }

                    break;
                }

            }

        }

    }

    private static void write(float answer) {

        BufferedWriter writer;
        File save = new File("./task02/last.txt");

        try {
            writer = new BufferedWriter(new FileWriter(save));
            writer.write(Float.toString(answer));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //returns Operator depending if $last is called.
    private static float readOperator(String input) {
        float output = 0f;

        File save = new File("./task02/last.txt");

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(save));
            String filetext;
            if ((filetext = reader.readLine()) == null) {
                output = 0f;
            } else {
                output = Float.parseFloat(filetext);
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }

        if (input.equals("$last")) {
            return output;
        } else {
            output = Float.parseFloat(input);
            return output;
        }
    }

}
