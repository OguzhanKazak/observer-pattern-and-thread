import java.util.ArrayList;

public abstract class Firm {

    abstract public int getShare();

    abstract public void setShare(int share);

    abstract public void NotifyObservers();

    abstract public void Attach(Observer observer);

    abstract public void GenerateRandomNumberAndSetShareWithThread();

}

