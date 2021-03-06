import java.util.*;

// -----------------------------------------------------
// Assignment 1
// © Chirag Hasmukhbhai Patel
// © Harsh Patel
// Written by: Chirag Hasmukhbhai Patel 40160656
// Written by: Harshkumar Nileshkumar Patel  Patel 40165709
// -----------------------------------------------------

/**
 * Computer class consists of relevant attributes , constructors ,
 * access methods,
 * toString and equals methods.
 */
public class Computer {
    private String brand;
    private String model;
    private long SN;
    private double price;
    private static int count = 0;
    private int index;


    /**
     * default constructor which will be used to create an object with,
     * default values.
     */
    public Computer() {
        this.brand = "Default";
        this.model = "A100";
        this.SN = 100000000;
        this.price = 1000;
        this.index = count;
        incrementCount();

    }


    /**
     * Parameterised constructor which will set values passed to it.
     * @param brand Brand of the computer.
     * @param model Model of the computer.
     * @param SN    Serial number of the computer.
     * @param price Price of the computer.
     * @param index index of the computer.
     */
    public Computer(String brand, String model, long SN, double price, int index) {
        this.brand = brand;
        this.model = model;
        this.SN = SN;
        this.price = price;
        this.index = index;
        incrementCount();
    }


    /**
     * Copy constructor which will be used to copy the values from one object,
     * and assign it to another object.
     *
     * @param otherComputer Object to be copied.
     */
    public Computer(Computer otherComputer) {
        this.brand = otherComputer.brand;
        this.model = otherComputer.model;
        this.SN = otherComputer.SN;
        this.price = otherComputer.price;
        this.index = otherComputer.index;
        incrementCount();
    }


    /**
     * Increments the value of counter which helps to manage an inventory.
     */
    public static void incrementCount() {
        count++;
    }


    /**
     * Setter method which allows to set the value of brand once an object is created.
     * @param brand brand of the computer.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }


    /**
     * Get method which allows to get the value of brand once an object is created.
     * @return Brand of the computer.
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * Setter method which allows to set the model of brand once an object is created.
     * @param model Model of the computer.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Get method which allows to get the value of model once an object is created.
     * @return Model of the computer.
     */
    public String getModel() {
        return this.model;
    }

    /**
     * Setter method which allows to set the Serial Number once an object is created.
     * @param SN Serial number of the computer.
     */
    public void setSN(long SN) {
        this.SN = SN;
    }

    /**
     * Get method which allows to get the value of Serial Number once an object is created.
     * @return Serial Number of the computer.
     */
    public long getSN() {
        return this.SN;
    }

    /**
     * Setter method which allows to set the price once an object is created.
     * @param price Price of the computer
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get method which allows to get the value of Price once an object is created.
     * @return Price of the computer
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Setter method which allows to set the index once an object is created.
     * @param index Index of the computer.
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Get method which allows to get the value of Index once an object is created.
     * @return Index of the computer.
     */
    public int getIndex() {
        return this.index;
    }


    /**
     * Generates information to be displayed for computer class to user.
     * @return String message generated by values of computer.
     */
    public String toString() {
        return "Computer #" + (this.getIndex()+1) + "\n" +
                "Brand: " + this.getBrand() + "\n" +
                "Model: " + this.getModel() + "\n" +
                "SN: " + this.getSN() + "\n" +
                "Price: $" + this.getPrice() + "\n";
    }


    /**
     * Checks if current object is equal to object passed.
     * @param x Object to be compared to current object.
     * @return true if objects are equal or false.
     */
    public boolean equals(Object x) {
        if (x != null && this.getClass() == x.getClass()) {
            Computer c = (Computer) x;
            if (this.brand == c.brand && this.model == c.model && this.price == c.price && this.SN == c.SN) {
                System.out.println("Both objects are equal");
                return true;
            } else {
                System.out.println("Both objects are not equal");
                return false;
            }
        } else {
            return false;
        }

    }


    /**
     * Static method which help to return count of current objects of computer.
     * @return Number of created computers.
     */
    public static int findNumberOfCreatedComputers() {
        return count;
    }

}

