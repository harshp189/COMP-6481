import java.util.*;

// -----------------------------------------------------
// Assignment 1
// © Chirag Hasmukhbhai Patel
// © Harshkumar Nileshkumar Patel
// Written by: Chirag Hasmukhbhai Patel 40160656
// Written by: Harshkumar Nileshkumar Patel 40165709
// -----------------------------------------------------


/**
 * Driver class for Computer which helps in managing the inventory.
 */
public class ComputerStoreDriver {

    private static int maxComputers;
    private static final String storePassword = "password";


    /**
     * provides the login functionality  if user enters wrong password for three times.
     * then user will be redirected to main screen.
     *
     * @param scan Scanner object to scan the input provided by the user.
     * @return true if login was successful or returns false.
     */
    public static boolean login(Scanner scan) {
        boolean flag = false;

        for (int i = 0; i < 3; i++) {
            flag = true;
            System.out.println("Enter the password:");
            String enteredPassword = scan.next();
            if (!enteredPassword.equals(storePassword)) {
                flag = false;
                System.out.println("Password is incorrect, you have " + (3 - (i + 1)) + " chances left for entering password.");
                continue;
            }
            break;
        }
        return flag;

    }


    /**
     * Helps in getting a integer number from user.
     * If entered is not a number than it will ask user again to enter a number.
     * Until user enters a valid number it will keep on going.
     *
     * @param scan Scanner object to scan the input provided by the user.
     * @return valid integer number entered by user.
     */
    public static int getNumber(Scanner scan) {
        Integer number = null;
        boolean flag = false;
        String input = null;
        while (!flag) {
            try {
                input = scan.next();
                number = Integer.parseInt(input);
                if (number >= 0)
                    flag = true;
                else
                    System.out.println("Please enter a positive number");
            } catch (Exception e) {
                System.out.println("Please enter a valid number");
            }
        }
        return number;
    }


    /**
     * Helps  in getting a double number from user.
     * If entered is not a double number than it will ask user again to enter a double number.
     * Until user enters a valid number it will keep on going.
     *
     * @param scan Scanner object to scan the input provided by the user.
     * @return valid double number entered by user.
     */
    public static double getDouble(Scanner scan) {
        Double number = null;
        boolean flag = false;
        String input = null;
        while (!flag) {
            try {
                input = scan.next();
                number = Double.parseDouble(input);
                if (number > 0.0)
                    flag = true;
                else
                    System.out.println("Please enter a positive Double value");
            } catch (Exception e) {
                System.out.println("Please enter a valid Double value");
            }
        }
        return number;
    }


    /**
     * Helps  in getting a long number from user.
     * If entered is not a long number than it will ask user again to enter a number.
     * Until user enters a long valid number it will keep on going.
     *
     * @param scanner Scanner object to scan the input provided by the user.
     * @return valid long number entered by user.
     */
    public static long getLong(Scanner scanner) {
        Long number = null;
        boolean flag = false;
        String input = null;
        while (!flag) {
            try {
                input = scanner.next();
                number = Long.parseLong(input);
                if (number > 0L)
                    flag = true;
                else
                    System.out.println("Please enter a positive Long value");
            } catch (Exception e) {
                System.out.println("Please enter a valid Long value");
            }
        }
        return number;
    }


    /**
     * adds new Computer to the inventory.
     * If space is not present in the inventory user will be prompted that not enough space in inventory.
     * If enough space is present it will ask user for input for values of computer.
     *
     * @param scan helps in scanning the user data.
     * @param inv  Inventory of computer objects.
     */
    public static void addNewComputers(Scanner scan, Computer[] inv) {

        System.out.println("Enter the number of computers to be added: ");
        int numComputers = getNumber(scan);
        scan.nextLine();
        int createdComputers = Computer.findNumberOfCreatedComputers();
        int availableSpace = maxComputers - createdComputers;

        while (numComputers > availableSpace) {
            System.out.println("There is not enough space to add more computers, the available space is:" + availableSpace);
            return;
        }


        for (int i = 0; i < numComputers; i++) {

            int lastIndex = Computer.findNumberOfCreatedComputers();

            System.out.println("Enter the brand name:");
            String brand = scan.nextLine();
            System.out.println("Enter the model name: ");
            String model = scan.nextLine();
            System.out.println("Enter the serial number: ");
            long sn = getLong(scan);
            System.out.println("Enter the price: ");
            double pr = getDouble(scan);
            scan.nextLine();
            inv[lastIndex] = new Computer(brand, model, sn, pr, lastIndex);
            System.out.println("Computer number " + (lastIndex + 1) + " has been added to the store.");

        }
    }


    /**
     * Helps in updating the value of computer.
     * If users enter index which is out of index of inventory then index invalid will be displayed.
     * otherwise, it will allow user to update the value of the inventory.
     *
     * @param scan helps in scanning the user data.
     * @param inv  Inventory of computer objects.
     */
    public static void updateComputer(Scanner scan, Computer[] inv) {
        boolean flag = true;
        int totalCreatedComputers = Computer.findNumberOfCreatedComputers();
        while (true) {
            System.out.println("Enter the index of computer you want to update: ");
            int updateIndex = getNumber(scan) - 1;

            if (updateIndex > totalCreatedComputers || updateIndex < 0) {
                System.out.println("The entered index is not valid");
                System.out.println("Do you want to enter another computer?");
                System.out.println("Enter 1 for entering new computer or else press any other number to exit this operation.");
                if (getNumber(scan) == 1) {
                    continue;
                } else {
                    flag = false;
                    break;
                }

            } else {
                System.out.println("\n" + inv[updateIndex].toString() + "\n");


                while (true) {
                    System.out.println("What information would you like to change?");
                    System.out.println("\t 1. Brand");
                    System.out.println("\t 2. Model");
                    System.out.println("\t 3. SN");
                    System.out.println("\t 4. Price");
                    System.out.println("\t 5. Quit \n");
                    System.out.println("Enter your choice >");

                    int updateField = scan.nextInt();
                    switch (updateField) {
                        case 1:
                            System.out.println("Enter the new brand of the Computer #" + updateIndex + 1);
                            scan.nextLine();
                            String newBrand = scan.nextLine();
                            inv[updateIndex].setBrand(newBrand);
                            System.out.println("\n" + inv[updateIndex].toString() + "\n");
                            break;

                        case 2:
                            System.out.println("Enter the new model of the Computer #" + updateIndex + 1);
                            scan.nextLine();
                            String newModel = scan.nextLine();
                            inv[updateIndex].setModel(newModel);
                            System.out.println("\n" + inv[updateIndex].toString() + "\n");
                            break;

                        case 3:
                            System.out.println("Enter the new Serial Number(SN) of the Computer #" + updateIndex + 1);
                            scan.nextLine();
                            int newSN = getNumber(scan);
                            inv[updateIndex].setSN(newSN);
                            System.out.println("\n" + inv[updateIndex].toString() + "\n");
                            break;

                        case 4:
                            System.out.println("Enter the Price of the Computer #" + updateIndex + 1);
                            scan.nextLine();
                            int newPrice = getNumber(scan);
                            inv[updateIndex].setPrice(newPrice);
                            System.out.println("\n" + inv[updateIndex].toString() + "\n");
                            break;

                        case 5:
                            return;

                        default:
                            System.out.println("Please enter a valid number between 1 and 5");
                            break;

                    }

                }

            }

        }

    }


    /**
     * Helps in finding the computer form the inventory by brand name passed by the user.
     *
     * @param inv         Inventory of computer objects.
     * @param searchBrand Brand name passed by the user to be searched in inventory.
     */
    public static void findComputersBy(Computer[] inv, String searchBrand) {
        int totalComputers = Computer.findNumberOfCreatedComputers();

        int count = 0;
        for (int i = 0; i < totalComputers; i++) {
            //System.out.println(inv[i+1]);
            if (inv[i].getBrand().equals(searchBrand)) {
                System.out.println(inv[i].toString());
                count++;
            }
        }
        if (count == 0)
            System.out.println("---------- No Computers exits by that brand in the inventory ---------- ");
    }

    /**
     * Helps in finding computers which are cheaper than the particular price.
     *
     * @param inv  Inventory of computer objects.
     * @param scan helps in scanning the search price of the computer.
     */
    public static void findCheaperThan(Computer[] inv, Scanner scan) {
        int totalComputers = Computer.findNumberOfCreatedComputers();
        Double searchPrice = getDouble(scan);
        int count = 0;
        for (int i = 0; i < totalComputers; i++) {

            if (inv[i].getPrice() <= searchPrice) {
                System.out.println(inv[i].toString());
                count++;
            }
        }
        if (count == 0)
            System.out.println("---------- No Computers found cheaper than that price ----------");
    }


    /**
     * Entry point of the system which helps in running the program.
     * and provides options to user.
     * User chooses particular choice and actions are performed accordingly.
     *
     * @param args Arguments to be passed at run time if any.
     */
    public static void main(String args[]) {
        System.out.println("-------------- Welcome to the Computer store-------------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the maximum number of computers the store can contain: ");
        maxComputers = getNumber(scan);
        Computer[] inventory = new Computer[maxComputers];

        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("\t 1. Enter new computers (password required)");
            System.out.println("\t 2. Change information of a computer (password required)");
            System.out.println("\t 3. Display all computers by a specific brand");
            System.out.println("\t 4. Display all computers under a certain a price.");
            System.out.println("\t 5. Quit");
            System.out.println("Please enter your choice >");
            int choice = getNumber(scan);

            switch (choice) {
                case 1:
                    if (!login(scan)) {
                        break;
                    }
                    addNewComputers(scan, inventory);
                    break;

                case 2:
                    if (!login(scan)) {
                        break;
                    }
                    updateComputer(scan, inventory);
                    break;

                case 3:
                    System.out.println("Enter the brand name for fetching computers with similar brand:");
                    scan.nextLine();
                    String searchBrand = scan.nextLine();
                    findComputersBy(inventory, searchBrand);
                    break;

                case 4:
                    System.out.println("Enter the price fetching computers with lower price:");
                    scan.nextLine();
                    //Double searchPrice = scan.nextDouble();
                    findCheaperThan(inventory, scan);
                    break;

                case 5:
                    System.out.println("----------- Quitting the Computer Store System, Bye -------------------");
                    return;


                default:
                    System.out.println("Please enter a valid number between 1 and 5");
                    break;

            }


        }
    }
}



