public class printer {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
    public static class Answer {
        public static void arrayOutOfBoundsException() {
            int [] arr = {1,2,3,4};
            System.out.println(arr[10]);

        }

        public static void divisionByZero() {
            System.out.println(90/0);

        }

        public static void numberFormatException() {
            String first="123get56";
            int i = Integer.parseInt (first);

        }
    }
}
