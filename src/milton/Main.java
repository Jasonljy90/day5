package src.milton;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];

        System.out.printf("Processing %s\n", fileName);

        // Open the file
        // Read the first 100 lines and print out each line
        // Close the file when done
        // If the file is less than 100 lines, close when done

        // try {
        //     FileReader fr = new FileReader(fileName);
        //     BufferedReader br = new BufferedReader(fr);
        //     Integer i = 0;
        //     do {
        //         String line = br.readLine();
        //         System.out.printf("%d: %s\n", i, line.toUpperCase());
        //         i++;
        //     }while (br.readLine() != null && i < 100);
        //     br.close();
        //     fr.close();
        //   } catch (FileNotFoundException e) {
        //     System.out.println("An error occurred.");
        //     e.printStackTrace();
        //   }

        // Count number of words in first 100 lines
        // try {
        //   FileReader fr = new FileReader(fileName);
        //   BufferedReader br = new BufferedReader(fr);
        //   Integer words = 0;
        //   for (Integer i = 0; i < 100; i++) {
        //       String line = br.readLine();
        //       words += wordsCounter(line);
        //   }
        //   System.out.printf("The number of words in first 100 lines: %d\n", words);
        //   br.close();
        //   fr.close();
        // } catch (FileNotFoundException e) {
        //   System.out.println("An error occurred.");
        //   e.printStackTrace();
        // }
        // 

        // Map with word as key and counter as value, whenever new word found increment counter else create a new key with word as key increment counter
        Map<String, Integer> map = new HashMap<String, Integer>();  
        
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            Integer k = 0;
            do {
                String line = br.readLine();
                String[] words = line.trim().split(" ");
                for (int i = 0; i < words.length; i++) {
                  String word = words[i];
                  if (map.containsKey(word)){
                    int count = map.get(word);
                    count++;
                    map.put(word, count);
                  }else{
                    map.put(word, 1);
                  }
                }

            }while (br.readLine() != null && k < 100);
            System.out.println(map);
            br.close();
            fr.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        }

        // private static int wordsCounter(String line) {
        //   int count = line.trim().split(" ").length;
        //   return count;
        // }
    }