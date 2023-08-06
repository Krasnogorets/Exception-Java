public class task4 {
    public static void main(String[] args) {
        try {
            Integer[] arr = {1, 1, 1,null,null};
            System.out.println(checkArr(arr));
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

    }
    public static StringBuilder checkArr(Integer[]arr){
        StringBuilder isNull = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] ==null){
                isNull.append(i).append(", ");
            }
        }
        if (isNull.length()>0){
            throw new RuntimeException("ошибки null в индексах: " + isNull);
        }
        return new StringBuilder("все ок");
    }
}
