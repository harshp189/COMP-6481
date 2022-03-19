/**
 * The class defines the type of exception to be thrown for invalid situations while working with files
 */
public class FileInvalidException extends Exception {
    /**
     * It will instantiate new File invalid exception
     */
    public FileInvalidException() {
        super("Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)\n");
    }

    /**
     * It will instantiate new File invalid exception
     * @param field the field to be printed
     */
    public FileInvalidException(String field) {
        super("File is Invalid: Field \"" + field + "\" is Empty. Processing stopped at this point. Other empty fields may be present as well\n");
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}