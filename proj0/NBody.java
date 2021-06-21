public class NBody{
	public static double readRadius(String adress){
		In in = new In(adress);
		int numberPlanets = in.readInt();
		Double radius = in.readDouble();
		return radius;
	}


	/* return an arrey of planets read from the file */

	public static Planet[] readPlanets(String adress){
		In in = new In(adress);
		int numberPlanets = in.readInt();
		Double radius = in.readDouble();
		Planet[] planets = new Planet[numberPlanets];
		for(int i = 0; i<numberPlanets; i++){
			/*
			IMPORTANT! : 初始化数组 planets 后，初始值为null，null 无法访问指针，因此无法直接赋值planets[i].xxPol = ……
			因为null 变量没有对应的成员变量。必须要new 一个 Planet instance 然后赋值给planets[i]。
			*/
			planets[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
		}
		return planets;
	}

	public static void main(String[] args){
		StdDraw.enableDoubleBuffering();
		Double T = Double.parseDouble(args[0]);
		Double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Double radius = readRadius(filename);
		String universPicture = "images/starfield.jpg";
		StdDraw.setXscale(-radius,radius);
		StdDraw.setYscale(-radius,radius);
		Double time = 0.0;
		Planet[] planets = readPlanets(filename); 
		int numberPlanets = planets.length;
		Double[] xForce = new Double[numberPlanets];
		Double[] yForce = new Double[numberPlanets];


	
		while(time <= T){

			for(int i = 0; i < numberPlanets; i++){
				xForce[i] = planets[i].calcNetForceExertedByX(planets);
				yForce[i] = planets[i].calcNetForceExertedByY(planets);
			}

			for(int i = 0; i < numberPlanets; i++){
				planets[i].update(dt, xForce[i], yForce[i]);
			}

			StdDraw.picture(0.0000e+00, 0.0000e+00, universPicture, radius*2, radius*2); 

			for(int i = 0; i < numberPlanets; i++){
				planets[i].draw();
			}

			StdDraw.show();
			StdDraw.pause(5);
			time += dt;

		}	
	}
}