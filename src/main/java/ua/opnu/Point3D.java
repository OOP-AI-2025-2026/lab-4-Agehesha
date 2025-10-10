package ua.opnu;

public class Point3D extends Point {

  private int z;

  public Point3D() {
    this(0, 0, 0);
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

  public int getZ() {
    return z;
  }

  public double distance(Point3D p) {
    long dx = (long) getX() - p.getX();
    long dy = (long) getY() - p.getY();
    long dz = (long) this.z - p.z;
    return Math.sqrt(dx * dx + dy * dy + dz * dz);
  }

  @Override
  public double distanceFromOrigin() {
    long lx = getX();
    long ly = getY();
    long lz = z;
    return Math.sqrt(lx * lx + ly * ly + lz * lz);
  }

  @Override
  public String toString() {
    return "(" + getX() + ", " + getY() + ", " + z + ")";
  }
}
