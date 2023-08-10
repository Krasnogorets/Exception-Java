public class WrongDateData extends NumberFormatException{
    public WrongDateData(int message) {
        super("дата может быть только цифрой от 1 до 31, а вы ввели: "+message);
    }
}
