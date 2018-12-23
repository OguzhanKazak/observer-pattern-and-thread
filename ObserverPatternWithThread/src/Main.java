import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //Firm instantiation
        A a = new A(1);
        B b = new B(1);
        C c = new C(1);
        D d = new D(1);
        E e = new E(1);

        Firm[] firmsAB ={a,b};
        Firm[] firmsCD = {c,d};
        Firm[] firmsE = {e};

        //attaching firms to observers
        new FirmABObserver(firmsAB);
        new FirmCDObserver(firmsCD);
        new FirmEObserver(firmsE);

        //Produces random numbers at regular intervals with threads and setting firm's share.
        a.GenerateRandomNumberAndSetShareWithThread();
        b.GenerateRandomNumberAndSetShareWithThread();
        c.GenerateRandomNumberAndSetShareWithThread();
        d.GenerateRandomNumberAndSetShareWithThread();
        e.GenerateRandomNumberAndSetShareWithThread();
    }
}
