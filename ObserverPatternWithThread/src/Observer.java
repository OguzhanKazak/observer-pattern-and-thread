import java.io.IOException;
import java.io.File;

public abstract class Observer {

    public Firm subject;

    public abstract void Update(Firm firm);

    public abstract void CreateOutputFile() throws IOException;

    public abstract void WriteOutputFile(String data);

}
