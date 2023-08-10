public class WrongStringQts extends RuntimeException{
    public WrongStringQts(String message) {
        super("ФИО должно идти по порядку" +message);
    }
}
