package FileReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain {

	public static void main(String[] args) throws IOException {
		
		//Ouverture des fichiers :
		String path1 = "C://Users//wetin//Desktop//Sorbonne-Cours//Java//Lecteur-Fichier/monDocumentTexte.txt"; //Chemin vers le fichier 1
		String path2 = "C://Users//wetin//Desktop//Sorbonne-Cours//Java//Lecteur-Fichier/monDocumentCSV.csv"; //Chemin vers le fichier 2
		
		File f1 = new File(path1); //On récupère le fichier 1
		File f2 = new File(path2); //Puis on récupère le fichier 2 
		//Vérifier que les fichiers existent
		if(f1.exists() && f2.exists()) { //On vérifie l'existence des fichiers f1 et f2 récupérés préalablement
			System.out.println("Les fichiers sont bien ouverts"+"\n");
			
			//On peut commencer le programme
			FileReaderGlobal main = new FileReaderGlobal(); //On instancie notre interface 
			
			//Comparaison des extensions des fichiers :
			System.out.println("Comparaison des extensions de fichiers");
			main.compareFile(path1,path2); //Appel de la méthode compareFile() qui prend en paramètre 2 chemins vers des fichiers à comparer
			
			//Affichage du contenu des fichiers :
			System.out.println("Affichage normal du contenu du fichier 1 :");
			main.contentFile(new FileReader(f1)); //Appel de la méthode contentFile() qui prend en paramètre un Reader pour afficher le contenu de celui-ci
			System.out.println("Affichage normal du contenu du fichier 2 :");
			main.contentFile(new FileReader(f2)); //On fait la même chose pour le fichier 2
			
			//Affichage du contenu des fichiers à l'envers :
			System.out.println("Affichage à l'envers (en terme de ligne) du contenu du fichier 1 :");
			main.reverseFile(new FileReader(f1)); //Appel de la méthode reverseFile() qui prend en paramètre un Reader pour afficher le contenu à l'envers en terme de ligne de celui-ci
			System.out.println("Affichage à l'envers (en terme de ligne) du contenu du fichier 2 :");
			main.reverseFile(new FileReader(f2)); //On fait la même chose pour le fichier 2
			
			//Affichage du contenu des fichiers de façon palindromique :
			System.out.println("Affichage du contenu du fichier 1 de façon palindromique :");
			main.palindromeFile(new FileReader(f1)); //Appel de la méthode palindromeFile() qui prend en paramètre un Reader pour afficher son contenu de façon palindromique (à l'envers en terme de ligne et les mots retournés)
			System.out.println("Affichage du contenu du fichier 2 de façon palindromique :");
			main.palindromeFile(new FileReader(f2)); //On fait la même chose pour le fichier 2
			
		} else if (!f1.exists() && f2.exists()){ //Le fichier 1 n'existe pas
			
			System.out.println("Le chemin du fichier 1 n'est pas bon !"+"\n");
			
		} else if (f1.exists() && !f2.exists()) { //Le fichier 2 n'existe pas
			
			System.out.println("Le chemin du fichier 2 n'est pas bon !"+"\n");
			
		} else { //Les fichiers n'existent pas
			
			System.out.println("Les chemins vers les fichiers ne sont pas bon !"+"\n");
			
		}
    }
}
