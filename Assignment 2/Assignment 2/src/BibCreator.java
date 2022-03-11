import java.io.*;
import java.util.Scanner;

public class BibCreator {
    static int countValidFiles = 0;
    static int countInvalidFiles = 0;

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

    /**
     * This method will read all the files as they are opened and will throw file not found exception if the file is not found
     * @param printWriters array of printwriters
     */

    private static void readAllFiles(PrintWriter[][] printWriters) {
        Scanner scanner[] = new Scanner[10];
        for(int i =0;i<10;i++){
            try{
                scanner[i] = new Scanner(new FileInputStream("Latex" + (i + 1) + ".bib"));

            } catch(FileNotFoundException e){
                System.out.println("Could not open input file Latex"+(i+1) +".bib for reading. Please check if file exists! Program will terminate after closing any opened files.");
                System.exit(0);
            }

        }

        for (int i = 0; i < 10; i++) {

            try {
                processFilesForValidation(scanner[i], printWriters[i][0], printWriters[i][1], printWriters[i][2]);
                countValidFiles++;
                printWriters[i][0].close();
                printWriters[i][1].close();
                printWriters[i][2].close();

            } catch (FileInvalidException e) {

                System.out.println("Problem Detected with input file: Latex" + (i + 1) + ".bib");
                System.out.println(e.getMessage());


                printWriters[i][0].close();
                printWriters[i][1].close();
                printWriters[i][2].close();
                String dir = System.getProperty("user.dir");

                File deleteFile = new File(dir + "\\ACM" + (i + 1) + ".json");
                deleteFile.delete();

                deleteFile = new File(dir + "\\IEEE" + (i + 1) + ".json");
                deleteFile.delete();

                deleteFile = new File(dir + "\\NJ" + (i + 1) + ".json");
                deleteFile.delete();
                countInvalidFiles++;

            }


        }

        System.out.println("A total of " + countInvalidFiles + " files were invalid, and could not be processed. " +
                "All other " + countValidFiles + " \"Valid\" files have been created.\n");

    }

    /**
     * Method to create the ArticleModel passed in the IEEE format and return it as a String
     * @param article the passed article model
     * @return will return the IEEE format String
     */


    public static String createIEEEFormat(ArticleModel article) {


        StringBuilder sbIEEE = new StringBuilder();

        sbIEEE.append(article.getAuthor().replaceAll(" and", ","));
        sbIEEE.append(". \"");
        sbIEEE.append(article.getTitle() + " \", ");
        sbIEEE.append(article.getJournal() + ", ");
        sbIEEE.append("vol. " + article.getVolume() + ", ");
        sbIEEE.append("no. " + article.getNumber() + ", ");
        sbIEEE.append("p. " + article.getPages() + ", ");
        sbIEEE.append(article.getMonth() + " " + article.getYear() + ".");


        return sbIEEE.toString();
    }

    /**
     * Method to create the ArticleModel passed in the NJ format and return it as a String
     * @param article the passed article model
     * @return will return the NJ format String
     */

    public static String createNJFormat(ArticleModel article) {

        StringBuilder sbNJ = new StringBuilder();

        String author = article.getAuthor().replaceAll("and", "&");
        sbNJ.append(author);
        sbNJ.append(". ");
        sbNJ.append(article.getTitle() + ". ");
        sbNJ.append(article.getJournal() + ". ");
        sbNJ.append(article.getVolume() + ", ");
        sbNJ.append(article.getPages());
        sbNJ.append("(" + article.getYear() + ").");

        return sbNJ.toString();
    }


    /**
     * Method to create the ArticleModel passed in the ACM format and return it as a String
     * @param article the passed article model
     * @param index the passed index
     * @return will return the ACM format String
     */
    public static String createACMFormat(ArticleModel article, int index) {

        StringBuilder sbACM = new StringBuilder();

        String[] author = article.getAuthor().split("and");
        sbACM.append("[" + index + "]\t");
        sbACM.append(author[0].trim() + " et al. ");
        sbACM.append(article.getYear() + ". ");
        sbACM.append(article.getTitle() + ". ");
        sbACM.append(article.getJournal() + ". ");

        return sbACM.toString();
    }


    public static boolean processFilesForValidation(Scanner scanner, PrintWriter printWriterACM, PrintWriter printWriterIEEE, PrintWriter printWriterNJ) throws FileInvalidException {
        return false;
    }

}
