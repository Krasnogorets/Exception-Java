import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {
        System.out.println(getFloat());
    }
    public static float getFloat(){
        boolean flag=true;
        float num=0;
        while (flag){
            Scanner iScanner = new Scanner(System.in);
            System.out.print("введите дробное число: ");
            String inputString = iScanner.nextLine();
            try {
                num = Float.parseFloat(inputString);
                flag=false;
            }catch (RuntimeException ClassCastException){
                flag=true;
            }

        }
        return num;
    }
}
