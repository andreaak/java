package com.java._02_Classes._11_Object;

// класс Car явно наследуется от класса Object
class CarOverridden {

    // создаем поля
    int speed;
    String color;

    // конструктор
    public CarOverridden(int speed, String color) {
        super();
        this.speed = speed;
        this.color = color;
        longValue = speed;
    }

    // перезаписываем метод toString класса Object так как мы считаем нужно
    @Override
    public String toString() {

        return String.format("Speed is: %s and Color is: %s", speed, color);
    }

    // перезаписываем метод equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CarOverridden car = (CarOverridden) obj;
        return speed == car.speed;
    }

    private boolean booleanValue = true;
    private char charValue = 'd';
    private long longValue = 1231234422L;
    private float floatValue = 1244124.21F;
    private double doubleValue = 9873234.123;
    private byte[] arrayValue = {1, 2, 3, 4};

    // переопределенный хэш-код(руками)
    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + (booleanValue ? 1 : 0);
        result = 37 * result + (int) charValue;
        result = 37 * result + (color == null ? 0 : color.hashCode());
        result = 37 * result + (int) (longValue ^ (longValue >>> 32));
        result = 37 * result + Float.floatToIntBits(floatValue);
        long longBits = Double.doubleToLongBits(doubleValue);
        result = 37 * result + (int) (longBits ^ (longBits >>> 32));
        for (byte b : arrayValue)
            result = 37 * result + (int) b;

        return result;
    }
}