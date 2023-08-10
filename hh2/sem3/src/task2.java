public class task2 {
    public static void main(String[] args) {
        try{doSomething();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    public static void doSomething() throws RuntimeException{

    }
}
