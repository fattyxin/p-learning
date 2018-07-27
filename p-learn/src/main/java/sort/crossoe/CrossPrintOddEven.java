package sort.crossoe;

/**
 * created by qinwanxin on 2018/7/18 11:12
 */
public class CrossPrintOddEven {

    public static void main(String[] args) {
        PrintState state = new PrintState(false);
        Thread oddThread = new Thread(new OddPrint(state,100));
        Thread evenThread = new Thread(new EvenPrint(state,100));
        oddThread.start();
        evenThread.start();
    }
}

class PrintState{
    public PrintState(boolean printOdd){
        this.printOdd = printOdd;
    }
    private boolean printOdd;

    public boolean isPrintOdd() {
        return printOdd;
    }

    public void setPrintOdd(boolean printOdd) {
        this.printOdd = printOdd;
    }
}
class OddPrint implements Runnable {
    private PrintState state;
    private int max;

    public OddPrint(PrintState state, int max) {
        this.state = state;
        this.max = max;
    }

    @Override
    public void run() {
        int i = 1;
        while (i < max) {
            synchronized (state){
                if(state.isPrintOdd()){
                    System.out.println(i=i+2);
                    state.setPrintOdd(!state.isPrintOdd());
                    state.notifyAll();

                }else {
                    try {
                        state.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class EvenPrint implements Runnable {
    private PrintState state;
    private int max;

    public EvenPrint(PrintState state, int max) {
        this.state = state;
        this.max = max;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < max) {
            synchronized (state){
                if(!state.isPrintOdd()){
                    System.out.println(i=i+2);
                    state.setPrintOdd(!state.isPrintOdd());
                    state.notifyAll();

                }else {
                    try {
                        state.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}