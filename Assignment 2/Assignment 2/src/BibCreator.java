import java.io.*;
import java.util.Scanner;

public class BibCreator {

    /**
     * This method will open all the files in three formats to be written
     * @param printWriters array of printwriters
     */

    private static void openAllFiles(PrintWriter[][] printWriters) {
        for (int i = 0; i < 10; i++) {
            try {
                printWriters[i][0] = new PrintWriter(new FileOutputStream("ACM" + (i + 1) + ".json"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                printWriters[i][1] = new PrintWriter(new FileOutputStream("IEEE" + (i + 1) + ".json"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                printWriters[i][2] = new PrintWriter(new FileOutputStream("NJ" + (i + 1) + ".json"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
