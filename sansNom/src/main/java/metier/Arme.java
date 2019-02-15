package metier;

public abstract class Arme {
	
	protected int decompteRechargeMax;
	protected int decompteRecharge;
	protected int dommage;
	
	public Arme(int dommage, int decompteRechergeMax) {
		this.dommage = dommage;
		this.decompteRechargeMax = decompteRechergeMax;
		this.decompteRecharge = 0;
	}
	
	public abstract void utilise(Monstre attaquant);
	public abstract void utilise(Joueur attaquant);
	
	public void decompteRecharge() {
		if (decompteRecharge > 0) {
			decompteRecharge -= 1;
		} else {
			decompteRecharge = decompteRechargeMax;
		}
	}
}
