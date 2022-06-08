package Privatepublicprotegido;

public class aula1 {
	public String modelo;
	public String cor;
	private float ponta;
	protected int carga;
	protected boolean tampada;
	public void status() {
		System.out.print(" \nmodelo " + this.modelo);
		System.out.print(" \ncor " + this.cor);
		System.out.print(" \nponta " + this.ponta);
		System.out.print( " \ncarga " + this.carga);
		System.out.print(" \ntampada " + this.tampada);
	}
	public void rabiscar() {
		if (this.tampada == true){
			System.out.print("ERRO");		

		} else {
			System.out.print("Estou rabiscando, Calma");
			
		}
	}
	protected void tampar() {
		this.tampada = true;
	}
	protected void destampada() {
		this.tampada = false;
	}

}
