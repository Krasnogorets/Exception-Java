public class WrongMonthData extends NumberFormatException{
    public WrongMonthData(int message) {
        super("месяц может быть только цифрой от 1 до 12, а вы ввели: "+message);
    }
}
