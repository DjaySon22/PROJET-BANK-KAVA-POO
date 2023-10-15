package fr.bank.view;

import java.util.ArrayList;
import java.util.List;

import fr.bank.commande.TransactionClient;
import fr.bank.commande.TransactionCompte;
import fr.bank.template.Address;
import fr.bank.template.Client;
import fr.bank.template.CompteBancaire;

public class Program {

	static {
		CompteBancaire c1 = new CompteBancaire("FR00P75015B" + TransactionCompte.num, 150);
		TransactionCompte.num++;
		CompteBancaire c2 = new CompteBancaire("FR00P75015B" + TransactionCompte.num, 0);
		TransactionCompte.num++;
		CompteBancaire c3 = new CompteBancaire("FR00P75015B" + TransactionCompte.num, 315);
		TransactionCompte.num++;

		List<CompteBancaire> comptes1 = new ArrayList<>();
		comptes1.add(c1);
		comptes1.add(c2);
		List<CompteBancaire> comptes2 = new ArrayList<>();
		comptes2.add(c3);

		Address a1 = new Address("374 rue de vaugirad", "75015", "Paris");
		Address a2 = new Address("36 Avenue Pierre Brossollet", "92240", "Malakoff");

		Client client1 = new Client("JOJO", "Jo", 18, "joel@esic.fr", "azerty", a1, comptes1);
		Client client2 = new Client("ROJA", "Nat", 17, "nat@roja.fr", "azerty", a2, comptes2);
		TransactionClient.clients.add(client1);
		TransactionClient.clients.add(client2);

	}

	public static void main(String[] args) {
		Menu.menuPrincipal();
	}
}
