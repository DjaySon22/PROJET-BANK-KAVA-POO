package fr.bank.commande;

import fr.bank.template.Client;
import fr.bank.template.CompteBancaire;

public class TransactionCompte {

	public static int num = 1;

	public static CompteBancaire createCompteBancaire() {
		CompteBancaire c = new CompteBancaire("FR00P75015B" + num, 0);
		num++;
		return c;
	}

	public static CompteBancaire selectionDeCompteBancaireClient(Client client) {
		String data = "";
		int nb = 1;
		
		for (CompteBancaire c : client.getComptes()) {
			data += nb + "- " + c.infoCompteBancaire() + "\n";
			nb++;
		}

		int choix = MyLibrary.saisieInt("Choisir le CompteBancaire \n" + data);

		return client.getComptes().get(choix - 1);
	}

	public static void consulterSolde(Client client) {
		MyLibrary.afficher(selectionDeCompteBancaireClient(client).getSolde() + " €");
	}

	public static void deposer(Client client) {
		CompteBancaire c = selectionDeCompteBancaireClient(client);
		double oldSolde = c.getSolde();
		
		c.versement(MyLibrary.saisieDouble("Montant du dépot"));
		MyLibrary.afficher("Dépot terminé ! \n Ancien solde : " + oldSolde + " € \n Nouveau solde : " +  c.getSolde());
	}
	
	public static void retirer(Client client) {
		CompteBancaire c = selectionDeCompteBancaireClient(client);
		double oldSolde = c.getSolde();
		
		c.prelevement(MyLibrary.saisieDouble("Montant du retrait "));
		MyLibrary.afficher("Retrait terminé ! \n Ancien solde : " + oldSolde + " € \n Nouveau solde : " +  c.getSolde());
	}
	
	public static void virement(Client client) {
		CompteBancaire c = selectionDeCompteBancaireClient(client);
		double oldSolde = c.getSolde();
		
		c.transfert(c, MyLibrary.saisieDouble("Montant du Virement "));
		MyLibrary.afficher("Virement effectuer ! \n Montant du virement : " + oldSolde + " € \n Nouveau solde : " +  c.getSolde());
	}
}
