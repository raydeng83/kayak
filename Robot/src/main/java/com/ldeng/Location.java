package com.ldeng;

/**
 * Created by Le on 9/7/2016 0007.
 *
 * An abstraction layer to deal with locations of Robot. Scalable to add third dimension.
 */

public class Location<X, Y> {

    private X x;
    private Y y;

    public Location() {}

    public Location(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }

    public void setX(X x) {
        this.x = x;
    }

    public void setY(Y y) {
        this.y = y;
    }

    public void setLocation(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return x.hashCode() ^ y.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Location)) return false;
        Location pairo = (Location) o;
        return this.x.equals(pairo.getX()) &&
                this.y.equals(pairo.getY());
    }

    @Override
    public String toString() {
        return "[" +
                 x +
                ", " + y +
                ']';
    }
}
