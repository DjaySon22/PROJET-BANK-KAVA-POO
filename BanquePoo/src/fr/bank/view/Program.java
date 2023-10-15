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
		//Ce sont des compte préenregistré
		CompteBancaire c1 = new CompteBancaire("FR00P75015B" + TransactionCompte.num, 130);
		TransactionCompte.num++;
		CompteBancaire c2 = new CompteBancaire("FR00P75015B" + TransactionCompte.num, 0);
		TransactionCompte.num++;
		CompteBancaire c3 = new CompteBancaire("FR00P75015B" + TransactionCompte.num, 357);
		TransactionCompte.num++;

		List<CompteBancaire> comptes1 = new ArrayList<>();
		comptes1.add(c1);
		comptes1.add(c2);
		List<CompteBancaire> comptes2 = new ArrayList<>();
		comptes2.add(c3);

		Address address1 = new Address("374 rue de vaugirad", "75015", "Paris");
		Address address2 = new Address("36 Avenue Pierre Brossollet", "92240", "Malakoff");

		Client client1 = new Client("Dyer","Tina",27,"Dyertiti@hotmail.fr","aqwzasx",address1,comptes1 );
		Client client2 = new Client("Landry","Paula",32,"\"Paudry@hotmail.fr","aqwzasx",address2,comptes2);
		
		TransactionClient.clients.add(client1);
		TransactionClient.clients.add(client2);

	}

	public static void main(String[] args) {
		Menu.menuPrincipal();
	}
}
