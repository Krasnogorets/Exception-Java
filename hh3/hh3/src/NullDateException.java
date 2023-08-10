public class NullDateException extends NullPointerException{
    public NullDateException() {
        super("не найдено ни одного значения, соответвующего формату даты рождения");
    }
}
