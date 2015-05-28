
public class Torcedor extends Pessoa {

	private double frequencia;
	
	public Torcedor(){
		super();
	}
	
	public Torcedor(String nome, int idade, double peso, double altura, double frequencia){
		super(nome, idade, peso, altura);
		setFrequencia(frequencia);
	}
	
	public Torcedor(String nome, double frequencia){
		setNome(nome);
		setFrequencia(frequencia);
	}

	public Torcedor(String nome){
		super();
		setNome(nome);
	}
	
	public void setFrequencia(double frequencia){
		this.frequencia += frequencia;
	}
	
	public double getFrequencia(){
		return frequencia;
	}
	
	public String toString(){
		String toString = ("Nome: "+getNome()+"\nIdade: "+getIdade()+"\nPeso: "+getPeso()+"\nAltura: "+getAltura()+"\nID: "+getFrequencia()+"\n");
		return toString;
	}
	
}
