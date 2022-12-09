package src.milton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        Map<String, Integer> map = new HashMap<>();  
        
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            Integer k = 0;
            do {
                String line = br.readLine().trim();
                if (line.length() != 0){
                  String[] words = line.split(" ");
                  for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    Integer v = map.getOrDefault(word, 0);
                    v++;
                    map.put(word, v);
                    // Can be replaced with line 66 and 67
                    // if (map.containsKey(word)){
                    //   int count = map.get(word);
                    //   count++;
                    //   map.put(word, count);
                    // }else{
                    //   map.put(word, 1);
                    // }
                  }
                }
                k++;
            }while (br.readLine() != null && k < 100);
            Set<String> uniqueWords = map.keySet();

            System.out.printf("Number of unique words: %d\n", uniqueWords.size());
            File csvFile = new File("result.csv");
            FileWriter fileWriter = new FileWriter(csvFile);
          
            fileWriter.write("Number of unique words: " + uniqueWords.size() + "\n");
            fileWriter.write("Word, Count\n");
            for (String w: uniqueWords){
              System.out.printf("> %s: %d\n", w, map.get(w));
              StringBuilder lineToWrite = new StringBuilder();
              lineToWrite.append(w + " " + map.get(w) + "\n");
              fileWriter.write(lineToWrite.toString());
            }
            fileWriter.close();
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

        /*
        In Main
        public static final String HEADER = "Word,Count";
        // Create CSV file
        FileOutputStream fos = new FileOutputStream(args[1]);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write(HEADER);

        for (String w : map.KeySet()) {
          String lineWrite = String.format("%s, %d\n", w, map.get(w));
          osw.write(lineWrite);
        }

        osw.flush();
        osw.close();
        fos.close();
        */
    }