public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
public Body(double xP, double yP, double xV, double yV, double m, String img){
    xxPos = xP;
    yyPos = yP;
    xxVel = xV;
    yyVel = yV;
    mass = m;
    imgFileName = img;
}
public Body (Body rocinante){
    xxPos = rocinante.xxPos;
    yyPos = rocinante.yyPos;
    xxVel = rocinante.xxVel;
    yyVel = rocinante.yyVel;
    mass = rocinante.mass;
    imgFileName = rocinante.imgFileName;
}
public double calcDistance(Body rocinante){
    double x = this.xxPos - rocinante.xxPos;
    double y = this.yyPos - rocinante.yyPos;
    return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
}
public double calcForceExertedBy(Body rocinante){
    double x = this.xxPos - rocinante.xxPos;
    double y = this.yyPos - rocinante.yyPos;
    return 6.67e-11 * this.mass * rocinante.mass / (Math.pow(x,2)+Math.pow(y,2));
}
public double calcForceExertedByX(Body rocinante){
    double dx = rocinante.xxPos - this.xxPos;
    double r = this.calcDistance(rocinante);
    return this.calcForceExertedBy(rocinante) * dx / r;
}
public double calcForceExertedByY(Body rocinante){
    double dy = rocinante.yyPos - this.yyPos;
    double r = this.calcDistance(rocinante);
    return this.calcForceExertedBy(rocinante) * dy / r;
}
public double calcNetForceExertedByX(Body[] allBodys){
    double fX = 0.0;
    for(int i = 0; i < allBodys.length; i++) {
        if(this.equals(allBodys[i])) {
            continue;
        }
        fX = fX + this.calcForceExertedByX(allBodys[i]);
    }
    return fX;
}
public double calcNetForceExertedByY(Body[] allBodys){
    double fY = 0.0;
    for(int i = 0; i < allBodys.length; i++) {
        if(this.equals(allBodys[i])) {
            continue;
        }
        fY = fY + this.calcForceExertedByY(allBodys[i]);
    }
    return fY;
    }
public void update(double dt, double fX, double fY){
    double ax = fX / this.mass;
    double ay = fY / this.mass;
    double vx = this.xxVel + dt * ax;
    double vy = this.yyVel + dt * ay;
    double px = this.xxPos + dt * vx;
    double py = this.yyPos + dt * vy;
    this.xxPos = px;
    this.yyPos = py;
    this.xxVel = vx;
    this.yyVel = vy;

}

public void draw(){
    StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
/*javac Body.java*/
}

