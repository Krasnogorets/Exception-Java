//Задание 3
//
//public static void main(String[] args) throws Exception {
//        try {
//        int a = 90;
//        int b = 3;
//        System.out.println(a / b);
//        printSum(23, 234);
//        int[] abc = { 1, 2 };
//        abc[3] = 9;
//        } catch (Throwable ex) {
//        System.out.println("Что-то пошло не так...");
//        } catch (NullPointerException ex) {
//        System.out.println("Указатель не может указывать на null!");
//        } catch (IndexOutOfBoundsException ex) {
//        System.out.println("Массив выходит за пределы своего размера!");
//        }
//        }
//public static void printSum(Integer a, Integer b) throws FileNotFoundException {
//        System.out.println(a + b);
//        }

public class task3 {
    public static void main(String[] args) throws Exception { // удалено throws Exception, т.к оно не будет
        // использоваться, т.к есть более высокий уровень Throwable
        try {
        int a = 90;
        int b = 3;
        if (b!=0){
            System.out.println(a / b);
        }else {
            System.out.println("деление на ноль запрещено");} // добавлено обработка деления на ноль

        printSum(23, 234);
        int[] abc = { 1, 2 };
        abc[3] = 9;
        } // удалено  NullPointerException, тк и переменные и массив int - там null не может появиться - Java
        // обработает на этапе сборки
        catch (IndexOutOfBoundsException ex) {
        System.out.println("Массив выходит за пределы своего размера!");
        }
        catch (Exception ex) {
            System.out.println("Что-то пошло не так..."); // это самый высокий уровень исключений - его нужно ставить
            // в конец и Throwable лучше заменить на Exception, т.к. errors мы не обрабатываем
        }
        }
        public static void printSum(Integer a, Integer b)  {// удалено
        // throws FileNotFoundException, т.к. является не корректным исключением для данного метода, без удаления файл
            // не скомпилируется, здесь не нужно лочить исключения - передачу в метод не правильных типов данных
            // не пропустит Java при компиляции и у нас есть обработка исключений в методе из которого вызываем
        System.out.println(a + b);
        }
}
