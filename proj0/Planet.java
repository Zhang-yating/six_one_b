public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xPos,double yPos,double xVel,double yVel,double m,String img){
		xxPos = xPos;
		yyPos = yPos;
		xxVel = xVel;
		yyVel = yVel;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		xxPos = p.xxPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		yyPos = p.yyPos;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}
	/* calculate the distance between two planets */
	public double calcDistance(Planet p){
		double dx = p.xxPos-xxPos;
		double dy = p.yyPos-yyPos;
		return Math.pow( (dx*dx + dy*dy), (1d/2));
	}

	/* calculate the attractive force between two planets */
	public double calcForceExertedBy(Planet p){
		double distance = calcDistance(p);
		double G = 6.67e-11;
		return (G * p.mass * mass)/(distance*distance);
	}

	
	/*calculate the force on the x direction */
	public double calcForceExertedByX(Planet p){
		double dx = p.xxPos-xxPos;
		double distance = calcDistance(p);
		return (calcForceExertedBy(p)/distance)*dx;
	}


	/*calculate the force on the y direction */
	public double calcForceExertedByY(Planet p){
		double dy = p.yyPos-yyPos;
		double distance = calcDistance(p);
		return (calcForceExertedBy(p)/distance)*dy;
	}

	/*calculate the net force by an arrey of planets on the x direction*/
	public double calcNetForceExertedByX(Planet[] planets){
		double force_x = 0.0;
		int length = planets.length;
		for(int i = 0; i<length; i++){
			if(planets[i].equals(this)){
				continue;
			}
			force_x = calcForceExertedByX(planets[i])+force_x;
		}
		return force_x;
	}

	/*calculate the net force by an arrey of planets on the y direction*/
	public double calcNetForceExertedByY(Planet[] planets){
		double force_y = 0.0;
		int length = planets.length;
		for(int i = 0; i<length; i++){
			if(planets[i].equals(this)){
				continue;
			}
			force_y = calcForceExertedByY(planets[i])+force_y;
		}
		return force_y;
	}

	/*update the current position and velocity according to the force and applyed time */
	public void update(double dt, double fx, double fy){
		double ay = fy/mass;
		double ax = fx/mass;
		xxVel = xxVel + ax*dt;
		yyVel = yyVel + ay*dt;
		xxPos = xxPos + xxVel*dt;
		yyPos = yyPos + yyVel*dt;
	}

	public void draw(){
		String filename = "images/"+imgFileName;
		StdDraw.picture(xxPos, yyPos, imgFileName);
	}

}