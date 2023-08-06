public class task1 {

    public static int getExceptions(int[] array,int minLength){
        if (array.length <5){
            throw new RuntimeException("длинна массива меньше 5");
        }
        return array.length;
    }
    public static void main(String[] args) {
        int[] newArray = new int [10];
        System.out.println(getExceptions(newArray,5));


    }
}
