package FileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileReaderGlobal implements FileReader {
	
	@Override
	public void contentFile(Reader file) {
		try (BufferedReader reader = new BufferedReader(file)){
	        String ligne; //Variable "ligne" qui servira � afficher 1 ligne apr�s l'autre
	        while ((ligne = reader.readLine()) != null) { //Tant qu'on lis des lignes
	            System.out.println(ligne +"\n"); //On affiche la ligne courante
	        }
	    } catch (IOException e) {
	    	System.err.println("Une erreur s'est produite lors de la lecture du fichier : " + e.getMessage() +"\n");
	    }
	}
	
	@Override
	public void reverseFile(Reader file) {
	    try (BufferedReader reader = new BufferedReader(file)){
	        List<String> tabLignes = new ArrayList<>(); //ArrayList de lignes qui servira � stocker les lignes pour les inverser
	        String ligne; //Variable "ligne" qui servira simplement � stocker chaque ligne dans l'ArrayList

	        while ((ligne = reader.readLine()) != null) {
	        	tabLignes.add(ligne); //On stocke la ligne courante dans l'ArrayList
	        }

	        // Inverser l'ordre des lignes
	        Collections.reverse(tabLignes);

	        // Afficher chaques lignes invers�es
	        for (String nouvLigne : tabLignes) { //On parcours le tableau
	            System.out.println(nouvLigne +"\n"); //Et on affiche la ligne courante
	        }
	    } catch (IOException e) {
	        System.err.println("Une erreur s'est produite lors de la lecture du fichier : " + e.getMessage() +"\n");
	    }
	}

	@Override
	public void palindromeFile(Reader file) {
        try (BufferedReader reader = new BufferedReader(file)){
            List<String> tabLignes = new ArrayList<>(); //ArrayList de lignes qui servira � stocker les lignes pour les inverser
            String ligne; //Variable "ligne" qui servira simplement � stocker chaque ligne dans l'ArrayList

            while ((ligne = reader.readLine()) != null) { //Tant qu'on lis des lignes
                // Inverser les mots de la ligne actuelle
                String[] words = ligne.split(" "); //S�parer les lettres du mot
                for (int i = 0; i < words.length; i++) {
                    words[i] = new StringBuilder(words[i]).reverse().toString(); //On retourne les mots en inversant l'odre des lettres s�par�es
                }
                String reversedLine = String.join(" ", words); //On rassemble les lettres

                tabLignes.add(reversedLine); //On ajoute au tableau de lignes la nouvelle ligne
            }

            // Si le fichier ne contient qu'une ligne, on inverse l'ordre des mots de cette ligne
            if (tabLignes.size() == 1) {
                String[] words = tabLignes.get(0).split(" ");
                List<String> reversedWords = new ArrayList<>();
                for (int i = words.length - 1; i >= 0; i--) {
                    reversedWords.add(words[i]);
                }
                tabLignes.set(0, String.join(" ", reversedWords));
            }

            Collections.reverse(tabLignes); //Inverser l'odre des lignes

            // Afficher le r�sultat � l'�cran
            for (String reversedLine : tabLignes) { //Pour chaque ligne de l'ArrayList tabLignes
                System.out.println(reversedLine +"\n"); //On affiche les ligne une par une
            }
        } catch (IOException e) {
            System.err.println("Une erreur s'est produite lors de la lecture du fichier : " + e.getMessage() +"\n");
        }
	}
	
	@Override
	public void compareFile(String file1, String file2) {

        String extension1 = file1.substring(file1.lastIndexOf(".") + 1); //On r�cup�re l'extension 1
        String extension2 = file2.substring(file2.lastIndexOf(".") + 1); //On r�cup�re l'extension 2
        
        if (!extension1.equals(extension2)) { //Si les extensions sont diff�rentes
            System.out.println("Les extensions " + extension1 + " et " + extension2 + " sont diff�rentes \n");
        } else { //Si les extensions sont les m�mes
        	System.out.println("Les deux fichiers ont l'extension " + extension1 +"\n");
        }
	}
}