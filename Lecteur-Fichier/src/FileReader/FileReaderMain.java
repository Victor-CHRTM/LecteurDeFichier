package FileReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain {

	public static void main(String[] args) throws IOException {
		
		//Ouverture des fichiers :
		String path1 = "C://Users//wetin//Desktop//Sorbonne-Cours//Java//Lecteur-Fichier/monDocumentTexte.txt"; //Chemin vers le fichier 1
		String path2 = "C://Users//wetin//Desktop//Sorbonne-Cours//Java//Lecteur-Fichier/monDocumentCSV.csv"; //Chemin vers le fichier 2
		
		File f1 = new File(path1); //On r�cup�re le fichier 1
		File f2 = new File(path2); //Puis on r�cup�re le fichier 2 
		//V�rifier que les fichiers existent
		if(f1.exists() && f2.exists()) { //On v�rifie l'existence des fichiers f1 et f2 r�cup�r�s pr�alablement
			System.out.println("Les fichiers sont bien ouverts"+"\n");
			
			//On peut commencer le programme
			FileReaderGlobal main = new FileReaderGlobal(); //On instancie notre interface 
			
			//Comparaison des extensions des fichiers :
			System.out.println("Comparaison des extensions de fichiers");
			main.compareFile(path1,path2); //Appel de la m�thode compareFile() qui prend en param�tre 2 chemins vers des fichiers � comparer
			
			//Affichage du contenu des fichiers :
			System.out.println("Affichage normal du contenu du fichier 1 :");
			main.contentFile(new FileReader(f1)); //Appel de la m�thode contentFile() qui prend en param�tre un Reader pour afficher le contenu de celui-ci
			System.out.println("Affichage normal du contenu du fichier 2 :");
			main.contentFile(new FileReader(f2)); //On fait la m�me chose pour le fichier 2
			
			//Affichage du contenu des fichiers � l'envers :
			System.out.println("Affichage � l'envers (en terme de ligne) du contenu du fichier 1 :");
			main.reverseFile(new FileReader(f1)); //Appel de la m�thode reverseFile() qui prend en param�tre un Reader pour afficher le contenu � l'envers en terme de ligne de celui-ci
			System.out.println("Affichage � l'envers (en terme de ligne) du contenu du fichier 2 :");
			main.reverseFile(new FileReader(f2)); //On fait la m�me chose pour le fichier 2
			
			//Affichage du contenu des fichiers de fa�on palindromique :
			System.out.println("Affichage du contenu du fichier 1 de fa�on palindromique :");
			main.palindromeFile(new FileReader(f1)); //Appel de la m�thode palindromeFile() qui prend en param�tre un Reader pour afficher son contenu de fa�on palindromique (� l'envers en terme de ligne et les mots retourn�s)
			System.out.println("Affichage du contenu du fichier 2 de fa�on palindromique :");
			main.palindromeFile(new FileReader(f2)); //On fait la m�me chose pour le fichier 2
			
		} else if (!f1.exists() && f2.exists()){ //Le fichier 1 n'existe pas
			
			System.out.println("Le chemin du fichier 1 n'est pas bon !"+"\n");
			
		} else if (f1.exists() && !f2.exists()) { //Le fichier 2 n'existe pas
			
			System.out.println("Le chemin du fichier 2 n'est pas bon !"+"\n");
			
		} else { //Les fichiers n'existent pas
			
			System.out.println("Les chemins vers les fichiers ne sont pas bon !"+"\n");
			
		}
    }
}
