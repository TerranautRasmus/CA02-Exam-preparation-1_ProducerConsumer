
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable {

    long totalSum = 0;
    BlockingQueue<Long> s2;
    
    public Consumer(BlockingQueue<Long> s2) {
        this.s2 = s2;
    }
    
    @Override
    public void run() {
        long temp = 0;
        
        while(true) {
            try {
                temp = s2.take();
                totalSum += temp;
            } catch (InterruptedException ex) {
                break;
            }
            
            System.out.println("Temp: " + temp);
        }
    }

    public long getTotalSum() {
        return totalSum;
    }
    
}
