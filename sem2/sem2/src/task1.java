import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task1 {
    public static void main(String[] args) {
        String data = "D:\\ОБУЧЕНИЕ GEEKBRAINS\\Исключения в программировании и их обработка\\program\\sem2\\sem2\\src\\data.txt";
        List<String[]> b = loadData(data);
        checkList(b);
        for (String[] item: b) {
            System.out.println("первый элемент: "+ item[0]+" второй элемент: "+ item[1]);
        }
        saveFile(checkList(b),data);
    }
    public static List<String[]> loadData(String data) {
        List<String[]> list=new ArrayList<>();
        try {
            FileReader fileReader= new FileReader(data);
            BufferedReader br=new BufferedReader(fileReader);
            String line="";
            while ((line= br.readLine())!=null){
                String [] a0 = line.split("=");
                list.add(a0);

            }
            return list;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static List<String[]> checkList(List<String[]> list){
        for (String[] item: list) {
            if (item[1].equals("?")){
                item[1]= String.valueOf(item[0].length());
            }
            if (!item[1].contains("[0-9]")){
                item[1]= String.valueOf(item[0].length());
            }
        }
        return list;
    }
    public static void saveFile(List<String[]> list,String data){
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter(data));
            for (String[] item:list) {
                writer.write(item[0]+"="+ item[1]+"\n");
            }
            writer.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
