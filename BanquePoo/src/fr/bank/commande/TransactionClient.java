package fr.bank.commande;

import java.util.ArrayList;
import java.util.List;

import fr.bank.template.Address;
import fr.bank.template.Client;
import fr.bank.template.CompteBancaire;

public class TransactionClient {

	public static List<Client> clients = new ArrayList<>();

	public static void creationClient() {
		String nom = MyLibrary.saisieString("votre nom");
		String prenom = MyLibrary.saisieString("votre prenom");
		int age = MyLibrary.saisieInt("votre age");
		String login = MyLibrary.saisieString("votre email");
		String password = MyLibrary.saisieString("votre mot de passe");

		Address a = TransactionAddress.createAddress();

		List<CompteBancaire> ComptesBancaire = new ArrayList<>();
		ComptesBancaire.add(TransactionCompte.createCompteBancaire());

		Client c = new Client(nom, prenom, age, login, password, a, ComptesBancaire);
		clients.add(c);
	}

	public static Client authClient() {
		String login = MyLibrary.saisieString("votre email");
		String password = MyLibrary.saisieString("votre mot de passe");

		Client c = null;

		for (Client client : clients) {
			if (client.getLogin().equals(login) && client.getPassword().equals(password)) {
				c = client;
			}
		}

		return c;
	}
}