package FileReader;


import java.io.Reader;

public interface FileReader {
	void contentFile(Reader file); //Méthode qui sert à mettre à l'envers le contenu de n'importe quel fichier
	
	void reverseFile(Reader file); //Méthode qui sert à mettre à l'envers le contenu de n'importe quel fichier en terme de lignes
	
    void palindromeFile(Reader file); //Méthode qui sert à mettre le contenu de certain fichier de façon palindromique
	
	void compareFile(String file1, String file2); //Méthode qui sert à la comparaison d'extension de n'importe quel fichier
}
