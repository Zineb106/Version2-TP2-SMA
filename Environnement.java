import java.util.Random;

public class Environnement {
String[][] grille = new String[50][50];
	
	void initialiser(Environnement env) {
		for (int i=0;i<50;i++) {
			for(int j=0;j<50;j++) {
				env.grille[i][j]="0";
			}
		}
		
		for (int i=0;i<199;i++) {
			Random random = new Random();
			int ligne = random.nextInt(50);
			int colonne = random.nextInt(50);
			
			if(env.grille[ligne][colonne] == "A") {i--;}
			else {env.grille[ligne][colonne]="A";}
			
			
		}
		for (int i=0;i<199;i++) {
			Random random = new Random();
			int ligne = random.nextInt(50);
			int colonne = random.nextInt(50);
			
			if(env.grille[ligne][colonne]=="A") {i--;}
			if(env.grille[ligne][colonne]=="B") {i--;}
			else {env.grille[ligne][colonne]="B";}
			
			
		}
		for (int i=0;i<199;i++) {
			Random random = new Random();
			int ligne = random.nextInt(50);
			int colonne = random.nextInt(50);
			
			if(env.grille[ligne][colonne]=="A") {i--;}
			if(env.grille[ligne][colonne]=="B") {i--;}
			if(env.grille[ligne][colonne]=="C") {i--;}
			else {env.grille[ligne][colonne]="C";}
			
			
		}
		for (int i=0;i<50;i++) {
			for(int j=0;j<50;j++)
			{
				//System.out.print(env.grille[i][j]+"\t");
			
			}
			//System.out.println();
		}
	
	} 

}
