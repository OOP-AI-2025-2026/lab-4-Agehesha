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

  public void setLocation(int x, int y, int z) {
    super.setLocation(x, y);
    this.z = z;
  }

  @Override
  public void setLocation(int x, int y) {
    super.setLocation(x, y);
    this.z = 0; 
  }

  public double distance(Point3D p) {
    int dx = getX() - p.getX();
    int dy = getY() - p.getY();
    int dz = this.z - p.z;
    return Math.sqrt((long) dx * dx + (long) dy * dy + (long) dz * dz);
  }

  @Override
  public double distanceFromOrigin() {
    return Math.sqrt(
        (long) getX() * getX() + (long) getY() * getY() + (long) z * z);
  }

  public int getZ() { return z; }

  @Override
  public String toString() {
    return "(" + getX() + ", " + getY() + ", " + z + ")";
  }
}
