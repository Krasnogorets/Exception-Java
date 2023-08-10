
    import java.io.*;

    public class Service implements Saveable {
        @Override
        public void save(Serializable obj) throws IOException {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("data.txt"));
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
        }



    }


