public class task2 {

    public static int getExceptions(int[] array,int number, int min){
        if (array == null){
            return -3;
        }
        if (array.length < min){
        return -1;
        }else {
            for (int i = 0; i < array.length; i++) {
                if (array[i]==number) {
                    return i;
                    }
            }
        }
        return -2;
    }

    public static void getMessage(int[] array,int number, int min){
        int result =getExceptions(array,number,min);
        System.out.println(result);
        if (result == -3){
            System.out.println("массив null");
        }
        if (result >= 0){
            System.out.println("индекс числа " + result);
        }
        if (result == -1){
            System.out.println("массив меньше минимума" );
        }
        if (result == -2){
            System.out.println("число не найдено" );
        }

    }

    public static void main(String[] args) {
        int[] newArray = {1,2,3,4,5,6,7,8,9};
        getMessage(newArray,1,6);


    }
}
