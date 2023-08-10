public class NullPhoneNumber extends NullPointerException{
    public NullPhoneNumber() {
        super("не найдено ни одного значения, соответствующего формату номера телефона");
    }
}
