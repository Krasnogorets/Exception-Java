public class task5 {
    public static int getArrSum(String[][] arr) {
        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException(arr.length, arr[0].length);
        } ;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    try {
                        throw new MyArrayDataException(i, j, arr[i][j]);
                    } catch (MyArrayDataException ex) {
                        System.out.println(ex.getMessage());
                    }
                    ;
                }
            }
        }
        return sum;
    }
    public boolean checkParse(String value){
        try{
            Integer.parseInt(value);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static void main(String[] args) {
        String[][] arr = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] arr1 = {{"1", "2", "3", "4", "5"}, {"1", "2", "3", "4", "5"}, {"1", "2", "3", "4", null}, {"1", "2", "3", "4", null}};
        String[][] arr2 = {{"1", "2", "3", "fgfgfgf"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        System.out.println(getArrSum(arr1));
    }

}

class MyArraySizeException extends RuntimeException {

    public MyArraySizeException(int row, int col) {
        super("массив размерность не 4х4, переметры текущие: " + row + " * " + col);
    }
}

class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int row, int col, String value) {
        super("значение " + value + " в ячейке" + row + " * " + col + " невозможно перевести в число");
    }
}
