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
	        String ligne;
	        while ((ligne = reader.readLine()) != null) {
	            System.out.println(ligne +"\n");
	        }
	    } catch (IOException e) {
	    	System.err.println("Une erreur s'est produite lors de la lecture du fichier : " + e.getMessage() +"\n");
	    }
	}
	
	@Override
	public void reverseFile(Reader file) {
	    try (BufferedReader reader = new BufferedReader(file)){
	        List<String> tabLignes = new ArrayList<>();
	        String ligne;

	        while ((ligne = reader.readLine()) != null) {
	        	tabLignes.add(ligne);
	        }

	        // Inverser l'ordre des lignes
	        Collections.reverse(tabLignes);

	        // Afficher chaques lignes inversées
	        for (String nouvLignes : tabLignes) {
	            System.out.println(nouvLignes +"\n");
	        }
	    } catch (IOException e) {
	        System.err.println("Une erreur s'est produite lors de la lecture du fichier : " + e.getMessage() +"\n");
	    }
	}

	@Override
	public void palindromeFile(Reader file) {
        try (BufferedReader reader = new BufferedReader(file)){
            List<String> lines = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                // Inversez les mots de la ligne actuelle
                String[] words = line.split(" ");
                for (int i = 0; i < words.length; i++) {
                    words[i] = new StringBuilder(words[i]).reverse().toString();
                }
                String reversedLine = String.join(" ", words);

                lines.add(reversedLine);
            }

            // Si le fichier ne contient qu'une ligne, inversez l'ordre des mots dans cette ligne.
            if (lines.size() == 1) {
                String[] words = lines.get(0).split(" ");
                List<String> reversedWords = new ArrayList<>();
                for (int i = words.length - 1; i >= 0; i--) {
                    reversedWords.add(words[i]);
                }
                lines.set(0, String.join(" ", reversedWords));
            } else {
                // Sinon, inversez l'ordre des lignes.
                Collections.reverse(lines);
            }

            // Affichez le résultat à l'écran
            for (String reversedLine : lines) {
                System.out.println(reversedLine +"\n");
            }
        } catch (IOException e) {
            System.err.println("Une erreur s'est produite lors de la lecture du fichier : " + e.getMessage() +"\n");
        }
	}
	
	@Override
	public void compareFile(String file1, String file2) {

        String extension1 = file1.substring(file1.lastIndexOf(".") + 1); //On récupère l'extension 1
        String extension2 = file2.substring(file2.lastIndexOf(".") + 1); //On récupère l'extension 2
        
        if (!extension1.equals(extension2)) {
            System.out.println("Les extensions " + extension1 + " et " + extension2 + " sont différentes \n");
        } else {
        	System.out.println("Les deux fichiers ont l'extension " + extension1 +"\n");
        }
	}
}