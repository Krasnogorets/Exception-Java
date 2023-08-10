public class WrongStringData extends ClassCastException{
    public WrongStringData(String s) {
        super("значение строки "+s +" не соответсвует формату строки");
    }
}
