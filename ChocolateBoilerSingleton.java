public class ChocolateBoilerSingleton {
    private boolean empty;
    private boolean boiled;
    private static ChocolateBoilerSingleton instance = null;

    private ChocolateBoilerSingleton() {
        empty = true;
        boiled = false;
    }

    public void fill(){
        if(isEmpty()){
            empty = false;
            boiled = false;
        }
    }

    public void drain(){
        if(isEmpty() && isBoiled()){
            empty = true;
        }
    }

    public void boil(){
        if(!isEmpty() && isBoiled()){
            boiled = true;
        }
    }

    public boolean isEmpty(){
        return empty;
    }

    public boolean isBoiled(){
        return boiled;
    }

    public static ChocolateBoilerSingleton getInstance(){

      if (instance == null){
        instance = new ChocolateBoilerSingleton();
      }
      return instance;
    }

    public void print(){
      System.out.println("Empty :" + empty);
      System.out.println("Boiled :" + boiled);
      System.out.println("\n");
    }
}


class ChocolateBoilerSingletonTest{
  ChocolateBoilerSingletonTest(){};

  static public void test(){
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
    ChocolateBoilerSingletonTest.test();
  }
}
