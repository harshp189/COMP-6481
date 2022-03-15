import java.io.*;
import java.util.Scanner;

public class BibCreator {
    static int countValidFiles = 0;
    static int countInvalidFiles = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to BibCreator!");

        PrintWriter[][] printWriters = new PrintWriter[10][3];

        openAllFiles(printWriters);
        readAllFiles(printWriters);

        Scanner scan = new Scanner(System.in);
        BufferedReader bufferedReader = null;
        try {
            System.out.println("Please enter the name of the files that you need to review:");
            String fileName = scan.nextLine();
            bufferedReader = new BufferedReader(new FileReader(fileName));
            System.out.println("Here are the contents of the successsfully created JSON File:"+fileName);
            String strCurrentLine = null;
            while ((strCurrentLine = bufferedReader.readLine()) != null) {
                System.out.println(strCurrentLine);
            }
            System.out.println("Goodbye! Hope you have enjoyed creating the needed files using BibCreator.");
        }
        catch (FileNotFoundException e) {
            try{
                System.out.println("Could not open input file. File does not exist or could not be created.\n");
                System.out.println("However, you will be allowed another chance to enter another file name:");
                String fileName = scan.nextLine();
                bufferedReader = new BufferedReader(new FileReader(fileName));
                System.out.println("Here are the contents of the successsfully created JSON File:"+fileName);
                String strCurrentLine = null;
                while ((strCurrentLine = bufferedReader.readLine()) != null) {
                    System.out.println(strCurrentLine);
                }
                System.out.println("Goodbye! Hope you have enjoyed creating the needed files using BibCreator.");
            }
            catch (FileNotFoundException e1){
                System.out.println("Sorry! I am unable to display your desired files! Program will exit!");
                return;
            }
            catch (IOException e1){
                e.printStackTrace();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

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
        sbACM.append(article.getVolume() + ", ");
        sbACM.append(article.getNumber() + " ");
        sbACM.append("(" + article.getYear() + "), ");
        sbACM.append(article.getPages() + ". ");
        sbACM.append("DOI:https://doi.org/" + article.getDoi() + ".");

        return sbACM.toString();
    }

    /**
     *
     * @param scanner the input file that is to be validated and be converted into three different formats
     * @param printWriterACM to write the ACM format data into the ACM file for the opened latex file
     * @param printWriterIEEE to write the IEEE format data into the ACM file for the opened latex file
     * @param printWriterNJ to write the NJ format data into the ACM file for the opened latex file
     * @return will return true if the validation is successful
     */
    public static boolean processFilesForValidation(Scanner scanner, PrintWriter printWriterACM, PrintWriter printWriterIEEE, PrintWriter printWriterNJ) throws FileInvalidException {
        String fileDataBuffer = "";

        while (scanner.hasNextLine()) {
            fileDataBuffer = new StringBuilder(fileDataBuffer).append(scanner.nextLine()).toString();
        }
        String[] articles_numbers = fileDataBuffer.split("@ARTICLE");
        for (int j = 1; j < articles_numbers.length; j++) {
            String[] fieldDetails = articles_numbers[j].split("},");
            ArticleModel article = new ArticleModel();

            for (int i = 0; i < fieldDetails.length - 1; i++) {
                if (i == 0) {
                    String[] startValue = fieldDetails[0].split(",");
                    if (startValue.length != 2) {
                        throw new FileInvalidException();

                    }
                    String[] FirstIndex = startValue[1].split("=\\{");
                    if (FirstIndex.length != 2) {

                       // throw new FileInvalidException(FirstIndex[0].trim());

                    }
                    article.setData(FirstIndex[0].trim(), FirstIndex[1]);
                    continue;
                }

                String[] fieldAndValue = fieldDetails[i].split("=\\{");
                if (fieldAndValue.length == 1) {

                   // throw new FileInvalidException(fieldAndValue[0].trim());

                }
                article.setData(fieldAndValue[0].trim(), fieldAndValue[1]);
            }



        }
        return true;
    }
}
