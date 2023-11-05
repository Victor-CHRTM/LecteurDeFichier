package FileReader;


import java.io.Reader;

public interface FileReader {
	void contentFile(Reader file); //M�thode qui sert � mettre � l'envers le contenu de n'importe quel fichier
	
	void reverseFile(Reader file); //M�thode qui sert � mettre � l'envers le contenu de n'importe quel fichier en terme de lignes
	
    void palindromeFile(Reader file); //M�thode qui sert � mettre le contenu de certain fichier de fa�on palindromique
	
	void compareFile(String file1, String file2); //M�thode qui sert � la comparaison d'extension de n'importe quel fichier
}
