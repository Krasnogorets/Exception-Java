import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class task1 {
    public void rwLine(Path pathRead, Path pathWrite) throws IOException{
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = Files.newBufferedReader((java.nio.file.Path) pathRead);
            out = Files.newBufferedWriter((java.nio.file.Path) pathWrite);
            out.write(in.readLine());
        }finally {
            try{
                if (in != null){
                    in.close();
                }
            }catch (IOException e){

            }
            try{
                if (out != null){
                    out.close();
                }
            }catch (IOException e){

            }
        }
    }
    public void rwLineUpdate(Path pathRead, Path pathWrite) throws IOException{
        try (
                BufferedReader in = Files.newBufferedReader((java.nio.file.Path) pathRead);
                BufferedWriter out = Files.newBufferedWriter((java.nio.file.Path) pathWrite);
                ){

            out.write(in.readLine());
        }
        }

    class Path {

    }
}
