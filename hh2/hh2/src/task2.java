
//Задание 2
//        try {
//        int d = 0;
//        double catchedRes1 = intArray[8] / d;
//        System.out.println("catchedRes1 = " + catchedRes1);
//        } catch (ArithmeticException e) {
//        System.out.println("Catching exception: " + e);
//        }

public class task2 {
    public static void main(String[] args) {
        try {
            int d = 0; // проверку  на ноль через if данной переменной не делаю, т.к. изначально в коде стоит обработка
            // этого исключения по условию задачи;
            Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, null, 10};
                // добавлен массив иначе Java не скомпилируется, несовместимость типов обрабатывается Java
                // либо в этой строке}
                double catchedRes1 = intArray[8] / d; // либо в этой строке Java выдаст ошибку в момент сборки,
            // если создать,например, строковый массив intArray, или попытка записать строку или float/double
                System.out.println("catchedRes1 = " + catchedRes1);
            } catch(ArithmeticException e){
                System.out.println("Catching exception: " + e);
            } catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Catching exception: " + e);// добавлена обработка выхода за пределы массива
            }catch(NullPointerException e){
                System.out.println("Catching exception: " + e);// добавлена обработка null
            }
        }
}