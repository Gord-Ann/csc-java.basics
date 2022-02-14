package anna.threads;

class InThread implements Runnable{
    int i = 0;
    public void run(){
        System.out.println("i = "+ ++i);
    }
}

class Quest extends Thread {
    Quest () {}
    Quest (Runnable r) {
        super(r);
    }
    public void run() {
        System.out.print("thread ");
    }
    public static void main(String[] args) {
        Runnable r = new Quest();  //1
        Quest t = new Quest(r);  //2
        t.start();
    }
}