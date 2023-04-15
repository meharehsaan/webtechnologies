public class Intgr {
    private int value;
    
    public Intgr() {
        value = 0;
    }
    
    public Intgr(int value) {
        this.value = value;
    }
    
    public Intgr(Intgr other) {
        value = other.value;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public Intgr add(Intgr other) {
        return new Intgr(value + other.value);
    }
    
    public static void main(String[] args) {
        Intgr a = new Intgr(5);
        Intgr b = new Intgr(10);
        Intgr c = a.add(b);
        
        System.out.println("a = " + a.getValue());
        System.out.println("b = " + b.getValue());
        System.out.println("c = " + c.getValue());
        
        a.setValue(7);
        b = new Intgr(a);
        System.out.println("a = " + a.getValue());
        System.out.println("b = " + b.getValue());
    }
}
