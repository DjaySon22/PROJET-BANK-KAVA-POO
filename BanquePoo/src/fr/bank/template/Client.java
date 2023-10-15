package fr.bank.template;

import java.util.List;

public class Client {
		private String nom;
		private String prenom;
		private int age;
		private String login;
		private String password;
		private Address adresse;
		private List<CompteBancaire> ComptesBancaire;

		public Client() {

		}

		public Client(String nom, String prenom, int age, String login, String password, Address adresse,
				List<CompteBancaire> ComptesBancaire) {
			this.nom = nom;
			this.prenom = prenom;
			this.age = age;
			this.login = login;
			this.password = password;
			this.adresse = adresse;
			this.ComptesBancaire = ComptesBancaire;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Address getAdresse() {
			return adresse;
		}

		public void setAdresse(Address adresse) {
			this.adresse = adresse;
		}

		public List<CompteBancaire> getComptes() {
			return ComptesBancaire;
		}

		public void setComptes(List<CompteBancaire> ComptesBancaire) {
			this.ComptesBancaire = ComptesBancaire;
		}

		public String infoClient() {
			return prenom + " " + nom + " " + age + " ans ==> [" + login + "]\n" 
		+ adresse.infoAddress() + "\n" + afficherComptes();
		}
		
		private String afficherComptes() {
			String data = "";
			for (CompteBancaire compte : ComptesBancaire) {
				data += compte.infoCompteBancaire() + "\n";
			}
			return data;
		}
}