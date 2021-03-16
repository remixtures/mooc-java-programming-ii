
public class Dog extends Animal {
    
    
    public Dog() {
        super("Dog");
    }
        
    public Dog(String name) {
        super(name);
    }
    
    public void bark() {
        System.out.println(super.getName() + " barks");
    }
    
    @Override
    public void makeNoise() {
        this.bark();
    }
    
}

