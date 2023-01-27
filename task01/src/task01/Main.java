package task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        File file = new File("./task01/%s".formatted(args[0]));

        BufferedReader reader;

        //Mapper contains the map and ranking functions.
        Mapper mapper = new Mapper();

        try {
            reader = new BufferedReader(new FileReader(file));

            int total = 0;
            String sentence;
            Scanner scan;

            while ((sentence = reader.readLine()) != null) {

                scan = new Scanner(sentence);
                String word;

                while (scan.hasNext()) {
                    word = scan.next();
                    mapper.addWord(word);
                }

            }

            mapper.doRanking();
            mapper.printArray();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}