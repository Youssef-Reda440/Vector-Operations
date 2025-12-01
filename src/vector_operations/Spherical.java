package vector_operations;

public class Spherical {
    private double r;
    private double theta;
    private double phi;

    public Spherical(double r, double theta, double phi) {
        this.r = r;
        this.theta = theta;
        this.phi = phi;
    }

    public double getR() {
        return r;
    }
    public void setR(double r) {
        this.r = r;
    }

    public double getTheta() {
        return theta;
    }
    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double getPhi() {
        return phi;
    }
    public void setPhi(double phi) {
        this.phi = phi;
    }

    public Cartesian toCartesian(Spherical s1) {
        double r = s1.getR();
        double theta = s1.getTheta();
        double phi = s1.getPhi();
        double x = r * Math.sin(Math.toRadians(45)) * Math.cos(Math.toRadians(phi)) + theta * Math.cos(Math.toRadians(45)) * Math.cos(Math.toRadians(phi)) - phi * Math.sin(Math.toRadians(45));
        double y = r * Math.sin(Math.toRadians(45)) * Math.sin(Math.toRadians(phi)) + theta * Math.cos(Math.toRadians(45)) * Math.sin(Math.toRadians(phi)) + phi * Math.cos(Math.toRadians(45));
        double z = r * Math.cos(Math.toRadians(45)) - theta * Math.sin(Math.toRadians(45));
        return new Cartesian(x, y, z);
    }

}
