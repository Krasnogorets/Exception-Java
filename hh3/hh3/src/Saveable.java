
import java.io.IOException;
import java.io.Serializable;

public interface Saveable {

    void save(Serializable obj) throws IOException;


}
