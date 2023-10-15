package fr.bank.template;

public class CompteBancaire {

	private String numeroCompte;
	private double soldeCompte;
	
	CompteBancaire(){
	}
	
	public CompteBancaire(String numeroCompte,double soldeCompte){
	  	this.numeroCompte = numeroCompte;
	  	this.soldeCompte = soldeCompte;
	}
	
	public double getSoldeCompte() {
		return soldeCompte;
	}

	public void setSoldeCompte(double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public double getSolde() {
		return soldeCompte;
	}
	
	public String getNumeroCompte() {
		return numeroCompte;
	}
	
	public String infoCompteBancaire() {
		return "N° " + numeroCompte + " : " + soldeCompte + "€"; 
	}
	public double versement(double montant) {
		return soldeCompte += montant;
	}
	
	public boolean prelevement( double montant) {
            if (montant <= soldeCompte) {
            	soldeCompte -= montant;
                return true;
            } else {
                return false;
        }
	}
	
	public boolean transfert(CompteBancaire c,double montant) {
		if(this.prelevement(montant)) {
			c.versement(montant);
			return true;
		}else {
			return false;
		}
	}
		
}
