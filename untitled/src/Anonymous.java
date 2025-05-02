@FunctionalInterface
public interface Anonymous {
    int show(int x, int y);
   /* int oprate(int a,int b);*/
    static  void print(){
        System.out.println("hello i am static menthod declare in the Sunctional interface");
    }
    default   void printdef(){
        System.out.println("hello i am default menthod declare in the Sunctional interface");
    }
}
