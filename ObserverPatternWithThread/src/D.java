import java.util.ArrayList;
import java.util.Random;

public class D extends Firm {

    int share;

    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public D(int share){
        this.share = share;
    }

    @Override
    public int getShare() {
        return share;
    }

    @Override
    public void setShare(int share) {

        if(this.share != share){ //Notify Observer if change applied.
            this.share = share;
            NotifyObservers();
        }
    }

    @Override
    public void NotifyObservers() {
        for (Observer observer: observers) {
            observer.Update(this);
        }
    }

    @Override
    public void Attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void GenerateRandomNumberAndSetShareWithThread() {
        Thread thread = new Thread() {
            public void run() {
                for(int i=0;i<5;i++){

                    Random random = new Random();
                    int randomNumber = random.nextInt(200);
                    setShare(randomNumber);
                    System.out.println("Number Generated and D firm's share is Set");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        thread.start();

    }
}
