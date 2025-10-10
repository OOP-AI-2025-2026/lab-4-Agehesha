package ua.opnu;

import ua.opnu.java.inheritance.point.Point;

/**
 * 3D-точка на основе 2D-Point из библиотеки: добавляет координату z.
 */
public class Point3D extends Point {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() { return z; }
    public void setZ(int z) { this.z = z; }

    /** Сдвиг на (dx,dy,dz). Важно: вызвать именно super.move(dx, dy). */
    public void move(int dx, int dy, int dz) {
        super.move(dx, dy);         // <-- ключевая правка против твоей ошибки "move(int,int) not found"
        this.z += dz;
    }

    /** Евклидово расстояние до другой 3D-точки. */
    public double distance(Point3D p) {
        long dx = (long) getX() - p.getX();
        long dy = (long) getY() - p.getY();
        long dz = (long) this.z   - p.z;
        return Math.sqrt(dx*dx + dy*dy + dz*dz);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point3D)) return false;
        Point3D other = (Point3D) o;
        return getX() == other.getX() && getY() == other.getY() && z == other.z;
    }

    @Override
    public int hashCode() {
        int r = 17;
        r = 31 * r + getX();
        r = 31 * r + getY();
        r = 31 * r + z;
        return r;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }
}
