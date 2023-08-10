import java.text.ParseException;

public class WrongDataFormat extends ParseException {

    /**
     * Constructs a ParseException with the specified detail message and
     * offset.
     * A detail message is a String that describes this particular exception.
     *
     * @param s           the detail message
     * @param errorOffset the position where the error is found while parsing.
     */
    public WrongDataFormat(String message, int errorOffset) {
        super("формат даты не соответсвует dd.mm.yyyy, а вы ввели: "+message, errorOffset);
    }
}
