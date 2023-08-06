import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        boolean flag=true;
        while (flag){
            Scanner iScanner = new Scanner(System.in);
            System.out.print("введите строку: ");
            String inputString = iScanner.nextLine();
            if (inputString.isEmpty()){
                System.out.println("вы ввели пустую строку, повторите ввод");
                flag = true;
            }else {
                System.out.println("вы ввели: "+"'"+inputString+"'");
                flag = false;
            }
        }

    }
}
