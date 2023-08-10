public class WrongYearData extends NumberFormatException{
    public WrongYearData(int message) {
        super("год может быть только цифрой от 1923 до 2023, а вы ввели: "+message);
    }
}
