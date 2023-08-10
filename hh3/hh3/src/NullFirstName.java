public class NullFirstName extends NullPointerException{
    public NullFirstName() {
        super("не найдено ни одного значения, соответвующего формату имени");
    }
}
