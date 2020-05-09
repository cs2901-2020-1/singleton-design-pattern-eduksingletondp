public class ChocolateBoilerSingleton {
    private static ChocolateBoilerSingleton instance = null;
    private boolean empty;
    private boolean boiled;

    public ChocolateBoilerSingleton() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoilerSingleton getInstance() {
      if (instance == null) {
        instance = new ChocolateBoilerSingleton();
        }
      return instance;
    }
    
    public void fill() {
        if(isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    public void drain() {
        if(isEmpty() && isBoiled()) {
            //drain the boiled milk and chocolate
            empty = true;
        }
    }

    public void boil() {
        if(!isEmpty() && isBoiled()) {
            //bring the contents to a boil
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }

    public void print() {
        System.out.println("Empty :" + empty);
        System.out.println("Boiled :" + boiled);
        System.out.println("\n");
    }
}

class ChocolateBoilerSingletonTest extends Thread {
    ChocolateBoilerSingletonTest(){};
    public void run(){
      ChocolateBoilerSingleton x = ChocolateBoilerSingleton.getInstance();
      ChocolateBoilerSingleton y = ChocolateBoilerSingleton.getInstance();
      x.print();
      y.print();
      System.out.println("Filled x\n");
      x.fill();
      x.print();
      y.print();
    }
} 

class Main {
  public static void main(String[] args) {
    System.out.println("ChocolateBoilerSingleton Test\n");
    ChocolateBoilerSingletonTest test1 = new ChocolateBoilerSingletonTest();
    ChocolateBoilerSingletonTest test2 = new ChocolateBoilerSingletonTest();
    ChocolateBoilerSingletonTest test3 = new ChocolateBoilerSingletonTest();
    test1.start();
    test2.start();
    test3.start();
  }
}
