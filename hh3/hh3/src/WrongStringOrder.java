public class WrongStringOrder extends RuntimeException{
    public WrongStringOrder(int message) {
        super("Фамилия Имя Отчество нужно вводить по порядку, " +
                "друг за другом, а у вас подряд только: " +message+ " строки");
    }
}
