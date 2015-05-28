
public class Socio extends Pessoa {
	
	private int numeroCarteirinha;
	
	public Socio(int id){
		super();
		numeroCarteirinha = id;
	}
	
	public Socio(String nome, int idade, double peso, double altura, int id){
		super(nome, idade, peso, altura);
		numeroCarteirinha = id;
	}
	
	public Socio(String nome){
		super();
		setNome(nome);
	}
	
	public void setId(int id){
		numeroCarteirinha = id;
	}
	
	public int getId(){
		return numeroCarteirinha;
	}
}
