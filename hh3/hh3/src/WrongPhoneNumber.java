public class WrongPhoneNumber extends RuntimeException{
    public WrongPhoneNumber(int length) {
        super("номер телефона должен содержать от 5 до 10 цифр, а их "+length);
    }
}
