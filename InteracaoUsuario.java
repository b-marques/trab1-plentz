import java.awt.LayoutManager;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InteracaoUsuario {
	
	Scanner sc = new Scanner(System.in);

	public InteracaoUsuario(){
	}
	
	public String informaTipo(){
		String resp = "";
		String[] options = { "Socio", "Torcedor"};
		int resp1 = JOptionPane.showOptionDialog(null, "Escolha uma das opcoes",
		        "Menu",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,options[0]);
		if (resp1 == 0){
			resp = "s";
		}else{
			resp = "t";
		}
		return resp;
	}
	
	public int informarAcao(){
		int i = 0;
		String[] options = { "0 - Sair", "1 - Comprar ingresso","2 - Cadastrar Socio\n ", "3 - Cadastrar Torcedor","4 - Numero de torcedores presentes", "5 - Numero de socios presentes", "6 - Zerar estadio","7 - Torcedor com maior frequencia" };
		String resp = (String) JOptionPane.showInputDialog(null, "Escolha uma das opcoes",
		        "Menu", JOptionPane.QUESTION_MESSAGE, null, options,options[1]);
		if(resp == null){
			i = 0;
		}
		else{ 
			i = Character.getNumericValue(resp.charAt(0));
		}
		return i;
	}
	
	public String informaNome(){
		String resp = JOptionPane.showInputDialog(null, "Informe seu nome:");
		return resp;
	}
	
	public int informaIdade(){
		int resp = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe sua idade:"));
		return resp;
	}
	
	public double informaPeso(){
		double resp = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe seu peso:"));
		return resp;
	}
	
	public double informaAltura(){
		double resp = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe sua altura:"));
		return resp;
	}	
	
	public int informaId(){
		int i = 0;
		String resp = JOptionPane.showInputDialog(null, "Informe sua ID:");
		if (resp == null){
			i = -1;
		}	
		else if (resp.equals("")){
			i = -2;
		}else{
			i = Integer.parseInt(resp);
		}
		return i;
	}
	
	public int informaLinhaAssento(){
		String resposta = JOptionPane.showInputDialog(null, "Qual a linha do assento desejado?");
		int resp;
		if (resposta == null || resposta.equals("")){
			resp =-1;
		}
		else{
			resp = Integer.parseInt(resposta);
			if (resp < 0 || resp > 9){
				resp =-1;
			}
		}
		return resp;
	}
	
	public int informaColunaAssento(){
		String resposta = JOptionPane.showInputDialog(null, "Qual a coluna do assento desejado?");
		int resp;
		if (resposta == null || resposta.equals("")){
			resp =-1;
		}
		else{
			resp = Integer.parseInt(resposta);
			if (resp < 0 || resp > 13){
				resp =-1;
			}
		}
		return resp;
	}
	
	public double informaFrequencia(){
		System.out.println("Informe a frequencia:");
		double resp = sc.nextDouble();
		return resp;
	}	
	
	public String informaAssento(int linha, int coluna){
		String texto = ("Seu assento e o: ["+linha+"|"+coluna+"]");
		return texto;
	}
	
	public String informaSociosPresentes(int i){
		String temp = ("O numero de socios presentes no estadio e: "+i);
		return temp;
	}
	
	public String informaTorcedoresPresentes(int i){
		String temp = ("O numero de torcedores presentes no estadio e: "+i);
		return temp;
	}
	
	public Pessoa getDados(){
		Pessoa dados = new Pessoa();
		
		JTextField nome = new JTextField(15);
	    JTextField idade = new JTextField(15);
	    JTextField peso = new JTextField(15);
	    JTextField altura = new JTextField(15);

	    JPanel myPanel = new JPanel();
	    myPanel.setLayout((LayoutManager) new BoxLayout(myPanel, BoxLayout.Y_AXIS));
	    myPanel.add(new JLabel("Nome:"));
	    myPanel.add(nome);
	    myPanel.add(new JLabel("Idade:"));
	    myPanel.add(idade);
	    myPanel.add(new JLabel("Peso:"));
	    myPanel.add(peso);
	    myPanel.add(new JLabel("Altura:"));
	    myPanel.add(altura);
	    

	    int result = JOptionPane.showConfirmDialog(null, myPanel, 
	             "Favor insira seus dados", JOptionPane.OK_CANCEL_OPTION);
	    
	    String n = null;
		int i = 0;
		double p = 0,a = 0;
	    
	    if (result == JOptionPane.OK_OPTION) {
	    	if (nome.getText().equals("") || idade.getText().equals("") || peso.getText().equals("") || altura.getText().equals("") ){
	    		n = "-1";
		    	i = -1;
		    	p = -1;
		    	a = -1;
	    	}
	    	else {
		    	n = nome.getText();
		    	i = Integer.parseInt(idade.getText());
		    	p = Double.parseDouble(peso.getText());
		    	a = Double.parseDouble(altura.getText());
	    	}
	    }else{
	    	n = "0";
	    	i = 0;
	    	p = 0;
	    	a = 0;
	    }
	    dados.setNome(n);
	    dados.setIdade(i);
	    dados.setPeso(p);
	    dados.setAltura(a);
	    return dados;
	}
}
