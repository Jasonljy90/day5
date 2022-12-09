package src.milton;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];

        System.out.printf("Processing %s\n", fileName);

        // Open the file
        // Read the first 100 lines and print out each line
        // Close the file when done
        // If the file is less than 100 lines, close when done

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            Integer i = 0;
            do {
                String line = br.readLine();
                System.out.printf("%d: %s\n", i, line.toUpperCase());
                i++;
            }while (br.readLine() != null && i < 100);
            br.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        }
    }