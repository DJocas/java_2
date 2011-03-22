package uzduotis_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Donatas Jocas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String line = "";
        Integer counter = 0;
        ArrayList<String> upCaseWords = new ArrayList();
        String[] temporary;
        BufferedReader br = new BufferedReader(new FileReader(new File("src/failas/1.txt")));
        BufferedWriter out = new BufferedWriter(new FileWriter(new File("src/failas/rez.txt")));
        try {
            while ((line = br.readLine()) != null) {
                temporary = line.split(" ");
                for (String s : temporary) {
                    if ((s.charAt(0) >= 'A') && (s.charAt(0) <= 'Z')) {
                        upCaseWords.add(s);
                        counter++;
                    }
                }
            }
            br.close();
            for (String s: upCaseWords) {
                System.out.println(s);
                out.append(s + "\n");
            }
            System.out.println("Number of words that are from upper case letters is: " + counter);
            out.append(counter.toString());
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
