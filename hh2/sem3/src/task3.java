import java.io.IOException;

public class task3 {
    static class Counter implements AutoCloseable{
        private int counter;
        public Counter() {
            this.counter=0;
        }

        public int getCounter() {
            return counter;
        }
        public void add() throws IOException {
            if(checkClose()) throw new IOException("объект закрыт");
            this.counter++;
        }

        @Override
        public void close()  {
            this.counter=-1;
            System.out.println("method Close closed");
        }
        public boolean checkClose(){
            return counter <0;

        }
    }

    public static void main(String[] args)  {

        try (Counter counter = new Counter();){
            counter.add();
            System.out.println(counter.getCounter());
            counter.close();
            counter.add();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
