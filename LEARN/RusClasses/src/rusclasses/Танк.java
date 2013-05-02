package rusclasses;

public class Танк {

	private String название;
	private Орудие орудие;
	private Башня башня;
	private Гусеницы гусеницы;
	private Двигатель двигатель;
	private Рация рация;
	
	public String вСтроку(){
		return "Танк\n" + название +
				"\nОрудие:" + орудие +
				"\nБашня:" + башня +
				"\nГусеницы:" + гусеницы +
				"\nДвигатель:"+ двигатель +
				"\nРация:" + рация;
	}
}