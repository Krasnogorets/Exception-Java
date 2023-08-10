public class WrongGenderFormat extends NumberFormatException{
    public WrongGenderFormat(String s) {
        super("пол может быть только значени f/m, а вы ввели: "+s);
    }
}
