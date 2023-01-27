package task01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapper {

    private Map<String, Integer> map;
    private String[] ranking;
    private Integer total;

    public Mapper() {
        this.map = new HashMap();
        this.ranking = new String[10];
        this.total = 0;
    }

    //cleans and adds word to Map.
    public void addWord(String current) {

        // clean up the string.
        String cleaned = "";
        for (Character c : current.toCharArray()) {
            if (Character.isLetterOrDigit(c))
                cleaned += c;
        }
        cleaned = cleaned.toLowerCase();


        //check if map contains key. if absent, add and initialize at 1. if present, increment 1.
        if (map.get(cleaned) == null) {
            map.put(cleaned, 1);
        } else {
            Integer curr = map.get(cleaned);
            map.put(cleaned, curr + 1);
        }

        total++;

    }

    public Map getMap() {
        return map;
    }

    //runs through words and ranks them into Array.
    public void doRanking() {

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String current = entry.getKey();
            String holder = "";

            for (int i = 0; i < 10; i++) {

                if (map.get(ranking[i]) == null) {
                    ranking[i] = current;
                    break;
                }

                if (map.get(current) > map.get(ranking[i])) {

                    holder = ranking[i];
                    ranking[i] = current;
                    current = holder;
                }
            }
        }
    }

    public void printArray(){

        System.out.printf("%-10s %s\n\n", "Word", "Freq");

        for(String word: ranking){
            float freq = (float)map.get(word)/total;
            System.out.printf("%-10s%.3f\n", word, freq);
        }

    }

}
