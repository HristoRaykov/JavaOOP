package contracts;

import java.io.IOException;

public interface Engine {
    void run() throws IOException, NoSuchMethodException, ClassNotFoundException;
}
