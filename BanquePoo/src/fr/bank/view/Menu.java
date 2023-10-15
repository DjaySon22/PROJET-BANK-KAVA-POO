package fr.bank.view;

import fr.bank.commande.MyLibrary;
import fr.bank.commande.TransactionClient;
import fr.bank.commande.TransactionCompte;
import fr.bank.template.Client;
import fr.bank.template.CompteBancaire;

public class Menu {

	public static Client clientConnected = null;

	public static void menuPrincipal() {
		String msg = "Menu principal \n\n\n 1- Créer un compte\n 2- Se connecter\n\n 0- Quitter";

		boolean sortie = false;

		while (sortie == false) {
			switch (MyLibrary.saisieInt(msg)) {
			case 1:
				TransactionClient.creationClient();
				break;
			case 2:
				clientConnected = TransactionClient.authClient();
				if (clientConnected != null) {
					menuAfterConnected();
				} else {
					MyLibrary.afficher("Identifiant ou mot de passe incorrect");
				}
				break;
			case 0:
				sortie = true;
				break;

			default:
				MyLibrary.afficher("Une erreur est Survenue !!!");
				break;
			}
		}
	}

	public static void menuAfterConnected() {
		String msg = "Bonjour " + clientConnected.getPrenom() + " " + clientConnected.getNom() +  " \n\nMenu opération sur le compte \n\n\n 1- Consulter son solde \n 2- Déposer de l'argent \n 3- Retirer de l'argent \n 4- Faire un virement vers un autre compte \n 5- Historique des transactions \n 6- Créer un autre compte \n\n 7- Retour au menu principal \n\n\n 0- Quitter";

		boolean sortie = false;

		while (sortie == false) {
			switch (MyLibrary.saisieInt(msg)) {
			case 1:
				TransactionCompte.consulterSolde(clientConnected);
				break;
			case 2:
				TransactionCompte.deposer(clientConnected);
				break;
			case 3: 
				TransactionCompte.retirer(clientConnected);
				break;
			case 4:
				TransactionCompte.virement(clientConnected);
				break;
			case 5:
				//Historique des transactions 
				break;
			case 6:
				CompteBancaire c = TransactionCompte.createCompteBancaire();
				clientConnected.getComptes().add(c);
				MyLibrary.afficher(c.getNumeroCompte() + " a bien été créer");
				break;
			case 7:
				sortie = true;
				break;
			case 0:
				System.exit(1);
				break;

			default:
				MyLibrary.afficher("Une erreur est Survenue !!!");
				break;
			}
		}
	}

}
