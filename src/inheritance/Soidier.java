package inheritance;

public class Soidier {
	private AbstractGun gun;
	void setGun(AbstractGun gun)
	{
		this.gun  = gun ;
	}
	
	public AbstractGun getGun() {
		return gun;
	}

	void KillEnemy(){
		System.out.println("士兵开始杀敌");
	}
}
