package bai_1;

import java.lang.reflect.Field;

public class Coordinates {
    private String name;
    private int x;
    private int y;

    public Coordinates() {
    }

    public Coordinates(String name, int x, int y) {
        if (!setName(name)) {
            return;
        }
        setX(x);
        setY(y);
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

    public String getName() {
        return this.name;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
            return true;
        }

        System.err.println("The name cannot be empty.");
        return false;
    }

    protected  boolean checkInt(int number) {
        return number >= Integer.MIN_VALUE && number <= Integer.MAX_VALUE;
    }

    public void setX(int _n) {
        if (this.checkInt(_n)) {
            this.x = _n;
        }
    }

    public void setY(int _n) {
        if (this.checkInt(_n)) {
            this.y = _n;
        }
    }

    @Override
    public String toString() {
        return this.name + "(" + this.x + ", " + this.y + ")";
    }
}