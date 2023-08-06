public class task3 {
    public static void main(String[] args) {
        int [][] array ={{1,0,1,0},{0,1,0,1},{1,0,1,0}};
        System.out.println(checkArray(array));
    }

    public static int checkArray(int [] [] array){
        if (array.length != array[0].length){
            throw new RuntimeException("массив не квадратный");
        }
        int sum =0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 0 || array[i][j] == 1){
                    sum+=array[i][j];
                }else{
                    throw new RuntimeException("числа не те в индексе " +i+','+j);
                }
            }
        }
        return sum;
    }
}
