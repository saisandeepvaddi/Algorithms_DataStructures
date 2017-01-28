class MySingletonClass{
    static MySingletonClass instance = null;
    static int count = 0;
    String name;
    private MySingletonClass(){};
    public static MySingletonClass getInstance(){
        if(instance == null){
            instance = new MySingletonClass();
        }
        else {
            System.out.println("Only one object is allowed here...");
        }
        return instance;
    }
    public void printClassDetails(String name){
        System.out.println("Name: "+name);
        System.out.printf("I am in class %s\n",this.getClass().getSimpleName());
        System.out.println("Count: "+(++count));
    }

}
public class LearnSingletonClass {
    public static void main(String[] args) {
        MySingletonClass myCls = MySingletonClass.getInstance();
        myCls.printClassDetails("Sandeep");

        MySingletonClass oneMore = MySingletonClass.getInstance();
//        oneMore.printClassDetails();
    }
}
