import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Janela extends JFrame implements ActionListener {
	
	JButton[] button = new JButton[140];
	Container c;
	public String escolha = getEscolha();
	ArrayEstadio estadio;
	
	public Janela(Pessoa[][] array){
		
		super("Escolha um dos assentos disponiveis para Torcedor");
		
		estadio = new ArrayEstadio();
		estadio.arrayDoEstadio = array.clone();
		
		c = getContentPane();
		c.setLayout(new FlowLayout());
		
		int contador = 0;
		for (int linha=0; linha<10;linha++){
			for (int coluna=0; coluna<14; coluna++ ){
				if(estadio.arrayDoEstadio[linha][coluna].getNome().equals("Torcedor")){
					if(coluna <10){
						button[contador] = new JButton("[0"+linha+"|0"+coluna+"]");
						button[contador].addActionListener(this);
						c.add(button[contador]);
						button[contador].setBackground(new Color(34,139,34));
						button[contador].setForeground(Color.WHITE);
						contador++;
					}else{
						button[contador] = new JButton("[0"+linha+"|"+coluna+"]");
						button[contador].addActionListener(this);
						c.add(button[contador]);
						button[contador].setBackground(new Color(34,139,34));
						button[contador].setForeground(Color.WHITE);
						contador++;
					}
				}
				else{
					button[contador] = new JButton("[__|__]");
					c.add(button[contador]);
					button[contador].setBackground(new Color(240,230,140));
					contador++;
				}
			}
		}
		button[0].setBackground(new Color(255,48,48));
		button[0].setText("Saida1");
		button[0].setForeground(Color.WHITE);
		button[13].setBackground(new Color(255,48,48));
		button[13].setText("Saida2");
		button[13].setForeground(Color.WHITE);
		button[126].setBackground(new Color(255,48,48));
		button[126].setText("Saida3");
		button[126].setForeground(Color.WHITE);
		button[139].setBackground(new Color(255,48,48));
		button[139].setText("Saida4");
		button[139].setForeground(Color.WHITE);
		c.setBackground(new Color(135,206,235));
		
		c.add(new JLabel("Os assentos mais proximos ao campo sao:"));
		c.add(new JLabel(estadio.getAssentoMaisProximo()));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); 
		setSize(1170, 390);
		setVisible(false);
		setLocationRelativeTo(null);
		
	}

	public void actionPerformed(ActionEvent evt) {
		
		Object src = evt.getSource();
		for(int i = 0; i<140;i++)
				if(src == button[i]){
					char fst = (button[i].getActionCommand().charAt(1));
					char scnd = (button[i].getActionCommand().charAt(2));
					String first = Character.toString(fst) + Character.toString(scnd);
					int primeiro = Integer.parseInt(first);
					char trd = (button[i].getActionCommand().charAt(4));
					char frd = (button[i].getActionCommand().charAt(5));
					String second = Character.toString(trd) + Character.toString(frd);
					int segundo = Integer.parseInt(second);
					String completo = (primeiro+" "+segundo);
					setEscolha(completo);
					setVisible(false);
					getEscolha();
					break;
					
				}
	}
	
	public String getEscolha(){
		return escolha;
	}
	
	public void setEscolha(String escolha){
		this.escolha = escolha;
		
	}
	
}
