
class RunnableThread implements Runnable {
    private String t_name;
    private Thread t;
    private int count;

    RunnableThread(String t_name) {
        this.count = 0;
        this.t_name = t_name;
        System.out.println("Created Thread with name: " + this.t_name);
    }

    public void run() {
        System.out.println("Running Thread: " + this.t_name);
//        System.out.println("Thread Priority: ");
    }

    public void start(String pri) {
        System.out.println("Starting thread: " + t_name);
        if (t == null) {
            t = new Thread(this, t_name);
            if (pri.equals("High")){
                this.setHighPriority();
            }
            else if (pri.equals("Low")){
                this.setLowPriority();
            }
            t.start();
        }
    }
    private void setHighPriority(){
        if(t != null){
            t.setPriority(Thread.MAX_PRIORITY);
        }
    }
    private void setLowPriority(){
        if (t != null){
            t.setPriority(Thread.MIN_PRIORITY);
        }
    }


}


public class MultiThreads {
    public static void main(String[] args) {
        RunnableThread a = new RunnableThread("a");
        RunnableThread b = new RunnableThread("b");
        b.start("Low");
        a.start("High");
    }
}
