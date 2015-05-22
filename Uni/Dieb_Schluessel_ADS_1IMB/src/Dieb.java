
public class Dieb {
	
	
public static void main(String[] args) {
		
		int a;
		int b;
		int c;
		int d;
		int counter = 0;
		
		for (a=1; a<=4; a++){
			for (b=1; b<=4; b++){
				for (c=1; c<=4; c++){
					for (d=1; d<= 4; d++){
						
						if (a!=b&b!=c&c!=d&d!=a&c!=a&d!=b){
							counter ++;
							System.out.println();							
							System.out.println("SchlŸssel-Nr. " + counter + ": " + a+  b+  c+  d);
						}
					}
				}
			}
		}
	}

}
