import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class task4 {
    public static void main(String[] args) {
        int a=7;
        String[] arr = {"gghghgh",null,"ghghghgh","ghghghg"};
        String file = "text.txt";
        try {
            int b = a/0;
        }catch (ArithmeticException e){
            try {
                throw new ArithEx();
            }catch (ArithEx ex){
                System.out.println(ex.getMessage());
            }
        }
        int i=0;
        try {
            for (; i < arr.length; i++) {
                System.out.println(arr[i].length());
            }

        }catch (NullPointerException e){
            try {
                throw new nullPointEx(i);
            }catch (nullPointEx ex){
                System.out.println(ex.getMessage());}
        }
        try (FileReader fileReader = new FileReader(file)){
            fileReader.read();
        } catch (FileNotFoundException e) {
            try{
                throw new FileNotFound(file);
            } catch (FileNotFound ex){
                System.out.println(ex.getMessage());
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
class ArithEx extends ArithmeticException {
    public ArithEx() {
        super("вы делите на ноль, ай-ай-ай!");
    }
}
class nullPointEx extends NullPointerException{
    public nullPointEx(int index) {
        super("элемент массива "+index+" =null");
    }
}
class FileNotFound extends FileNotFoundException {
    public FileNotFound(String path) {
        super("файл "+path+" не найден");
    }
}
