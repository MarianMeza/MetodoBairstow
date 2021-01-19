package Bairstow;

import java.util.ArrayList;
import java.util.Scanner;

public class Metodo_Bairstow {
	
	public static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		ArrayList<Double> a = new ArrayList<Double>();
		ArrayList<Double> b = new ArrayList<Double>();
		ArrayList<Double> c = new ArrayList<Double>();
		ArrayList<Double> d = new ArrayList<Double>();
		double error = 0.000001;
		double eaR = 1000000000;
		double eaS = 1000000000;
		int i = 1;
		int m = 0;
		int grado = 0;
		int co = 0;
		double coeficiente = 0.0;
		double r = 0.0;
		double s = 0.0;
		int contador = 1;
		double b0 = 0.0;
		double b1 = 0.0;
		double c1 = 0.0;
		double c2 = 0.0;
		double c3 = 0.0;
		double deltaR = 0.0;
		double deltaS = 0.0;
		double discriminante = 0.0;
		double x1 = 0.0;
		double x2 = 0.0;
		double x3 = 0.0;
		double x4 = 0.0; 
		double imaginario = 0.0;
		double imaginario2 = 0.0;
		int im = 0;
		int im2 = 0;
		
		double det = 0;
		double nr = 0;
		double ns = 0;
		
		
		double d1 = 0;
		double d2 = 0;
		double d3 = 0;
		
		
		System.out.println("\n\n--------- MÉTODO BAIRSTOW ---------");
		
		System.out.print("\n Ingresa el grado del polinomio: ");
		grado = sc.nextInt();
		co = grado;
		i = grado;
		m = grado;
				
		for(int j = 0; j <= grado; j++) {
			a.add(0.0);
			b.add(0.0);
			c.add(0.0);
		}
		
		while (i >= 0) {
			
			System.out.print(" Ingresa el coeficiente #"+i+": ");
			coeficiente = sc.nextDouble();
			
			a.set(i, coeficiente);
			
			i--;
			
		}
		
		i = 0;
		
		System.out.print("\n Ingresa el criterio de paro (%): ");
		error = sc.nextDouble();
		
		System.out.print("\n Ingresa el valor inicial de r: ");
		r = sc.nextDouble();
		
		System.out.print(" Ingresa el valor inicial de s: ");
		s = sc.nextDouble();
		
	while(co > 3) {	
		
		while( (eaR > error) ) {
			
		while( (eaS > error) ) {
		
			while(i <= grado) {
			
				if(contador == 1) {
					
					b.set(m, a.get(m));
					
				}
				if(contador == 2) {
					
					b.set(m, a.get(m) + (r * b.get(m + 1)));
					
				}
				if(contador >= 3) {
					
					b.set(m, a.get(m) + (r * b.get(m + 1)) + (s * b.get(m + 2)) );
					
				}
				
				
				i++;
				contador++;
				m--;
			}
//			System.out.println(b.get(0));
//			System.out.println(b.get(1));
//			System.out.println(b.get(2));
//			System.out.println(b.get(3));
//			System.out.println(b.get(4));
			
			i = 0;
			contador = 1;
			m = grado;
			
			while(i <= grado) {
				
				if(contador == 1) {
					
					c.set(m, b.get(m));
					
				}
				if(contador == 2) {
					
					c.set(m, b.get(m) + (r * c.get(m + 1)) );
					
				}
				if(contador >= 3) {
					
					c.set(m, b.get(m) + (r * c.get(m + 1)) + (s * c.get(m + 2)) );
					
				}
				
				i++;
				contador++;
				m--;
			}
//			System.out.println(c.get(0));
//			System.out.println(c.get(1));
//			System.out.println(c.get(2));
//			System.out.println(c.get(3));
//			System.out.println(c.get(4));
			
			i = 0;
			contador = 1;
			m = grado;
			
//			System.out.println(a);
//			System.out.println(b);
//			System.out.println(c);
			
//			i = b.size() - 1;
			b0 = b.get(0);
			b1 = b.get(1);
			
//			System.out.println(b0);
//			System.out.println(b1);
			
			i = 0;
			
			c3 = c.get(3);
			c2 = c.get(2);
			c1 = c.get(1);
			
			
//			System.out.println(c1);
//			System.out.println(c2);
//			System.out.println(c3);
			
//			deltaS = ( (-1 * b1) + ((c2/c1) * b0) ) / ( ( (-1 * c2 * c2) / (c1) ) + c3 );
//			
//			deltaR = ( (-1 * b0) - (c2 * deltaS) ) / (c1);
		
			deltaS = ((b0*c3)-(b1*c2)) / ((c2*c2)-(c1*c2));
			
			deltaR = ((b1*c1)-(b0*c2)) / ((c2*c2)-(c1*c2));
			
//			det = ((c2*c2)-(c1*c2));
//			
//			nr = ((b1*c1)-(b0*c2));
//			
//			ns = ((b0*c3)-(b1*c2));
//			
//			if (det == 0) {
//		          deltaS = 1;
//		          deltaR = 1;
//		    } 
//			else 
//			{
//		          deltaS = ns / det;
//		          deltaR = nr / det;
//		    }

//		        eaR = Math.sqrt(deltaR * deltaR + deltaS * deltaS);
			
//			System.out.println(deltaR);
//			System.out.println(deltaS);
			
			r = r + deltaR;
			s = s + deltaS;
			
//			System.out.println(r);
//			System.out.println(s);
			
			eaR = Math.abs(deltaR / r);
			eaS = Math.abs(deltaS / s);
			
//			System.out.println(eaR);
//			System.out.println(eaS);
			
		}//while
		}//while2
		
		discriminante = Math.pow(s, 2) + (4 * r);
		imaginario = (Math.sqrt(Math.abs(Math.pow(s, 2) + (4 * r)))) / 2;
		
		if(discriminante > 0) {
		
//			im = 1;
			x1 = ((s + Math.sqrt(Math.pow(s, 2) + (4 * r)))) / 2;
			x2 = ((s - Math.sqrt(Math.pow(s, 2) + (4 * r)))) / 2;
			System.out.println("\nraíz: "+x1);
			System.out.println("raíz: "+x2);			
			
		}
		else {
			
//			im = 2;
			x1 = (s/2);
			x2 = (s/2);
			System.out.println("\nraíz: "+x1+" + "+imaginario+"i");
			System.out.println("raíz: "+x2+" - "+imaginario+"i");
			
		}
		
		
		for(int j = 0; j <= co-2; j++) {
			
			a.set(j, b.get(j+2));
			
		}
		
//		System.out.println(a.get(0));
//		System.out.println(a.get(1));
//		System.out.println(a.get(2));
//		System.out.println(a.get(3));
		
		co = co-2;
		
	}//whileCO
		
		
		
	if(co == 3) {
	
		d1 = -(a.get(0) / a.get(1));
//		System.out.println(d1);
		
		b.add(0.0);
		b.add(0.0);
		b.add(0.0);
		b.add(0.0);
		
		c.add(0.0);
		c.add(0.0);
		c.add(0.0);
		c.add(0.0);
		
		do {
			
			for(int j = co, k = co; j >= 0; j--, k--) {
				
				if(j == co) {
					
					b.set(k, a.get(k));
//					System.out.println(b.get(k));
					
				}
				else
				{
					
					b.set(k, a.get(k) + b.get(k+1)*d1);
					
				}
				
			}
			d2 = b.get(0);
			
			for(int j = co, k = co; j >= 0; j--, k--) {
				
				if(j == co) {
					
					c.set(k, b.get(k));
					
				}
				else
				{
					
					c.set(k, b.get(k) + c.get(k+1)*d1);
					
				}
				
			}
			d3 = c.get(1);
			d1 += -(d2/d3);			
			
		} while(Math.abs(d2) > error);
		
		System.out.println("raíz: "+d1);
		
		for(int j = 0; j <= co-1; j++) {
			
			a.set(j, b.get(j+1));
			
		}
		
		co = co-1;
		
//		x3 = (-1 * (s/r));
	
	}
		
		
	if(co == 2) {
			
		c1 = a.get(0);
		c2 = a.get(1);
		c3 = a.get(2);
//		System.out.println(c1);
//		System.out.println(c2);
//		System.out.println(c3);
		
			discriminante = Math.pow(c2, 2) - (4 * c1 * c3);
			imaginario2 = (Math.sqrt(Math.abs(discriminante))) / (c3*2);
			
			if(discriminante > 0) {
				
//				im2 = 1;
				x3 = (-c2 + Math.sqrt(discriminante)) / (c3*2);
				x4 = (-c2 - Math.sqrt(discriminante)) / (c3*2);
				System.out.println("raíz: "+x3);
				System.out.println("raíz: "+x4);
				
			}
			else {
				
//				im2 = 2;
				x3 = (-c2 / (c3*2));
				x4 = (-c2 / (c3*2));
				System.out.println("raíz: "+x3+" + "+imaginario2+"i");
				System.out.println("raíz: "+x4+" - "+imaginario2+"i");
				
			}
	}
		
//		if(im == 1) {
//			System.out.println("\nraíz 1: "+x1);
//			System.out.println("raíz 2: "+x2);
//		}
//		if(im == 2)
//		{
//			System.out.println("\nraíz 1: "+x1+" + "+imaginario+"i");
//			System.out.println("raíz 2: "+x2+" - "+imaginario+"i");
//		}
//		if(grado-1 == 3) {
//			System.out.println("raíz 3: "+x3);
//		}
//		
//		if(im2 == 1) {
//			System.out.println("raíz 3: "+x3);
//			System.out.println("raíz 4: "+x4);
//		}
//		if(im2 == 2)
//		{
//			System.out.println("raíz 3: "+x3+" + "+imaginario2+"i");
//			System.out.println("raíz 4: "+x4+" - "+imaginario2+"i");
//		}
		
	
	}//main

}//class
