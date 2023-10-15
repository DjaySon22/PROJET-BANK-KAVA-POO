package fr.bank.commande;

import fr.bank.template.Address;

public class TransactionAddress {

	public static Address createAddress() {
		String rue = MyLibrary.saisieString("votre numero et nom de la rue");
		String codePostal = MyLibrary.saisieString("votre code postal");
		String ville = MyLibrary.saisieString("votre ville");
		
		return new Address(rue, codePostal, ville);
	}
}
