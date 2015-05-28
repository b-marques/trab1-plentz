
public class Pessoa {

	private String nome;
	private int idade;
	private double peso;
	private double altura;
	
	public Pessoa (){
		super();
	}
	
	public Pessoa (String nome, int idade, double peso, double altura){
		this.nome = nome;
		this.idade = idade;
		this.peso = peso;
		this.altura = altura;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String toString(){
		String toString = ("Nome: "+nome+"\nIdade: "+idade+"\nPeso: "+peso+"\nAltura: "+altura+"\n");
		return toString;
	}
	
	public boolean equals(Object o){
		if (o instanceof Pessoa){
			if((this.getNome().equals(((Pessoa)o).getNome())) &&
			   (this.getIdade() == ((Pessoa) o).getIdade()) &&
			   (this.getPeso() == ((Pessoa)o).getPeso()) &&
			   (this.getAltura() == ((Pessoa)o).getAltura()))
				return true;
		}
		return false;
	}
}
