import java.lang.reflect.Field;

public class Coordinates {
    private String name;
    private int x;
    private int y;

    public Coordinates() {}

    public Coordinates(String _name, int _x, int _y) {
        if (!setName(_name)) return;
        setX(_x);
        setX(_y);
    }

    public void getAttribute(String attribute) {
        try {
            Field field = this.getClass().getDeclaredField(attribute);
            field.setAccessible(true);

            System.out.println(field.get(this));
        } catch (NoSuchFieldException e) {
            System.err.println("Attribute does not exist: " + attribute);
        } catch (IllegalAccessException e) {
            System.err.println("Unable to access attribute: " + attribute);
        }
    }

    public boolean setName(String name) {
        if (!name.isBlank()) {
            this.name = name;
            return true;
        } else {
            System.err.println("The name cannot be empty.");
            return false;
        } 
    }

    public boolean checkInt(int number) {
        if (number < Integer.MIN_VALUE || number > Integer.MAX_VALUE)
            return false;

        return true;
    }

    public void setX(int _n) {
        if (checkInt(_n)) {
            this.x = _n;
        }
    } 

    public void setY(int _n) {
        if (checkInt(_n)) {
            this.x = _n;
        }
    }

    public String toString() {
        return this.name + "()";
    }    
}