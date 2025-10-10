package ua.opnu;

import ua.opnu.java.inheritance.point.Point;


public class Point3D extends Point {

  private int z;

  public Point3D() {
    super(0, 0);
    this.z = 0;
  }

  public Point3D(int x, int y, int z) {
    super(x, y);
    this.z = z;
  }

  public int getZ() {
    return z;
  }

  public void setZ(int z) {
    this.z = z;
  }


  public void move(int dx, int dy, int dz) {

    setX(getX() + dx);
    setY(getY() + dy);
    this.z += dz;
  }

  public double distance(Point3D p) {
    int dx = getX() - p.getX();
    int dy = getY() - p.getY();
    int dz = z - p.z;
    return Math.sqrt((double) dx * dx + (double) dy * dy + (double) dz * dz);
  }

  public double distance() {
    int x = getX();
    int y = getY();
    return Math.sqrt((double) x * x + (double) y * y + (double) z * z);
  }

  @Override
  public String toString() {
    return "(" + getX() + ", " + getY() + ", " + z + ")";
  }
}
