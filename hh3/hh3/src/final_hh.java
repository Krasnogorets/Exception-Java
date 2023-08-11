/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол
Форматы данных:
фамилия, имя, отчество - строки
датарождения - строка формата dd.mm.yyyy
номертелефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.
Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
пользователю выведено сообщение с информацией, что именно неверно.
Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
в него в одну строку должны записаться полученные данные, вида
<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
пользователь должен увидеть стектрейс ошибки.
*/

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class final_hh {
    public static String secondName= null;


    public static void main(String[] args) throws Exception {
        boolean flag = true;
               Scanner scan = new Scanner(System.in);
        String[] arr = null;
        while (flag) {
            System.out.println("Форматы данных:" + "\n" +
                    "- фамилия, имя, отчество " +"\n" +
                    "- строки датарождения - строка формата dd.mm.yyyy " +"\n" +
                    "- номертелефона - целое беззнаковое число без форматирования " +"\n" +
                    "- пол - символ латиницей f или m."+"\n");
            System.out.println("Введите данные в произвольном порядке, разделенные пробелом\n" +
                    "Фамилия Имя Отчество датарождения номертелефона пол:" + "\n");
            String drawString = scan.nextLine();
            arr = drawString.split(" ");
            int error = 0;
            error = checkWordQts(arr, error);
            if (error == -1) {
                System.out.println("Ошибка ввода данных: " + error + " -> Вы ввели недостаточно данных");

            } else if (error == -2) {
                System.out.println("Ошибка ввода данных: " + error + " -> Вы ввели много данных");

            }
            if (error == 0) {
                flag = false;
            }
        }

        String path="data.txt";
//        String fileName=secondName;
        StringBuilder sb = stringParser(arr);
        StringBuilder fileName = new StringBuilder();
        fileName.append(secondName);
        fileName.append(".txt");
        System.out.println(sb);
        System.out.println(fileName);
        Service(sb,path,fileName.toString());

    }

    public static void Service (StringBuilder sb, String path,String fileName) throws IOException {
        File file = new File(fileName);
        if (file.createNewFile()){
            System.out.println("File is created!");
            try (FileWriter writer = new FileWriter(fileName)){
                writer.write(String.valueOf(sb));
            }catch (FileNotFoundException e){
                System.out.println(e);
            }
        }
        else{
            System.out.println("File already exists.");
            try (FileWriter writer = new FileWriter(fileName,true)){
                writer.write(String.valueOf(sb)+"\n");
            }catch (IOException e){
                System.out.println(e);
            }
        }

    }

    public static int checkWordQts(String[] arr, int err) {
        if (arr.length < 6) {
            err = -1;
        } else if (arr.length > 6) {
            err = -2;
        }
        return err;
    }

//    public static void printArray(String[] arr) {
//        for (String s : arr) {
//            System.out.print(s + ";");
//        }
//    }

    public static StringBuilder stringParser(String[] arr) throws Exception {

        String firstName = null;
        String thirdName = null;
        String date = null;
        Integer phone = null;
        Character gender = null;
        int countString = 0;
        int countStringMax = 0;
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            if (countString != 3) {
                countString = 0;
            }
            if (checkInteger(temp)) {
                if (temp.length() < 5 || temp.length() > 10) {
                    throw new WrongPhoneNumber(temp.length());
                } else {
                    if (phone == null) {
                        phone = Integer.parseInt(temp);
                    }
                }
            }
            if (checkDate(temp)) {
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                    formatter.setLenient(false);
                    formatter.parse(temp);
                } catch (ParseException e) {
                    try {
                        throw new WrongDataFormat(temp, e.getErrorOffset());
                    } catch (WrongDataFormat ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                String[] rawData1 = temp.split("[/.]");
                if (Integer.parseInt(rawData1[0]) < 1 || Integer.parseInt(rawData1[0]) > 12) {
                    throw new WrongMonthData(Integer.parseInt(rawData1[0]));
                } else if (Integer.parseInt(rawData1[1]) < 1 || Integer.parseInt(rawData1[1]) > 12) {
                    throw new WrongDateData(Integer.parseInt(rawData1[1]));
                } else if (Integer.parseInt(rawData1[2]) < 1923 || Integer.parseInt(rawData1[2]) > 2023) {
                    throw new WrongYearData(Integer.parseInt(rawData1[2]));
                } else {
                    if (date == null) {
                        date = temp;
                    }
                }
            }
            if (checkChar(temp)) {
                Character c = temp.charAt(0);
                if (c.equals('f') || c.equals('m')) {
                    if (gender == null) {
                        gender = c;
                    }
                } else {
                    throw new WrongGenderFormat(temp);
                }
            }
            if (checkString(temp)) {
                if (countString != 3) {
                    countString++;
                    if (countString > countStringMax) countStringMax = countString;
                }
                if (i + 2 < arr.length) {
                    String temp1 = arr[i + 1];
                    if (checkString(temp1)) {
                        if (countString != 3) {
                            countString++;
                            if (countString > countStringMax) countStringMax = countString;
                        }
                        String temp2 = arr[i + 2];
                        if (checkString(temp2)) {
                            if (countString != 3) {
                                countString++;
                                if (countString > countStringMax) countStringMax = countString;
                            }
                            if (secondName == null) {
                                secondName = temp;
                            }
                            if (firstName == null) {
                                firstName = temp1;
                            }
                            if (thirdName == null) {
                                thirdName = temp2;
                            }

                        }
                    }
                }
            }
        }

        return fillResultList(arr, secondName, firstName,
                thirdName, date, phone, gender, countStringMax);
    }

    public static boolean checkInteger(String temp) {
        if (temp == null) {
            return false;
        }
        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDate(String temp) throws Exception {
        if (temp == null) {
            return false;
        }
        if (temp.contains("/")) {
            throw new WrongDataFormat(temp,0);
        }
        if (!temp.contains(".")) {
            return false;
        }
        String temp1 = temp.replaceAll("[//.]", "");
        for (int i = 0; i < temp1.length(); i++) {
            char c = temp1.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean checkChar(String temp) {
        if (temp.length() > 1) {
            return false;
        }
        if (Character.isDigit(temp.charAt(0))) {
            return false;
        }
        return true;
    }

    public static boolean checkString(String temp) {
        if (temp.length() < 3) {
            return false;
        }
        for (int i = 0; i < temp.length(); i++) {
            if (Character.isDigit(temp.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static StringBuilder fillResultList(String[] arr,
                                               String secondName, String firstName, String thirdName,
                                               String date, Integer phone, Character gender, int countStringMax)  {
        int countString1 = 0;
        if (secondName == null || firstName == null || thirdName == null) {
            for (String temp : arr) {
                if (checkString(temp)) {
                    countString1++;
                }
            }
            if (countString1 != countStringMax) {
                throw new WrongStringOrder(countStringMax);
            }
        }
            if (secondName == null) throw new NullSecondName();
            if (firstName == null) throw new NullFirstName();
            if (thirdName == null) throw new NullThirdName();
            if (date == null) throw new NullDateException();
            if (phone == null) throw new NullPhoneNumber();
            if (gender == null) throw new NullGender();
            StringBuilder sb = new StringBuilder();
            sb.append("<").append(secondName).append(">");
            sb.append("<").append(firstName).append(">");
            sb.append("<").append(thirdName).append(">");
            sb.append("<").append(date).append(">");
            sb.append("<").append(phone).append(">");
            sb.append("<").append(gender).append(">");
            sb.append("\n");
            return sb;
        }


}