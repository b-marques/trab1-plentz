import javax.swing.JOptionPane;

public class Controle {

	public static void main(String[] args){
		
		InteracaoUsuario iu = new InteracaoUsuario();
		ArrayEstadio array = new ArrayEstadio();
		
		//TESTE:
		/*array.setArray(array.getSocio(30), 0, 3);
		array.setArray(array.getSocio(30), 0, 4);
		array.setArray(array.getSocio(30), 0, 5);
		array.setArray(array.getSocio(30), 0, 6);
		array.setArray(array.getSocio(30), 0, 7);
		array.setArray(array.getSocio(30), 0, 8);
		array.setArray(array.getSocio(30), 0, 9);
		array.setArray(array.getSocio(30), 0, 10);
		array.setArray(array.getSocio(30), 2, 1);
		array.setArray(array.getSocio(30), 2, 12);
		array.setArray(array.getSocio(30), 3, 12);
		array.setArray(array.getSocio(30), 3, 1);
		array.setArray(array.getSocio(30), 4, 1);
		array.setArray(array.getSocio(30), 4, 12);
		array.setArray(array.getSocio(30), 5, 1);
		array.setArray(array.getSocio(30), 5, 12);
		array.setArray(array.getSocio(30), 6, 1);
		array.setArray(array.getSocio(30), 6, 12);
		array.setArray(array.getSocio(30), 7, 1);
		array.setArray(array.getSocio(30), 7, 12);
		array.setArray(array.getSocio(30), 9, 3);
		array.setArray(array.getSocio(30), 9, 4);
		array.setArray(array.getSocio(30), 9, 5);
		array.setArray(array.getSocio(30), 9, 6);
		array.setArray(array.getSocio(30), 9, 7);
		array.setArray(array.getSocio(30), 9, 8);
		array.setArray(array.getSocio(30), 9, 9);
		array.setArray(array.getSocio(30), 9, 10);
		array.setSocio(30, "Bruno",19 , 77, 1.7, 10);
		array.setSocio(0,"1",1,1,1,11);
		array.setTorcedor(50,"1");
		Torcedor um = new Torcedor("1", 1,1,1,0);
		array.setTorcedor(0, "1");*/
		
		boolean loop = true;
		int contador=1;
		do{
			int acao = iu.informarAcao();
			
			if (acao == 1){
				array.compraIngresso();
			}	
			else if(acao == 2){
				array.cadastrarSocio(contador);
				contador++;
			}
			else if(acao == 3){
				array.cadastraTorcedor();
			}
			else if(acao == 4){
				JOptionPane.showMessageDialog(null,iu.informaTorcedoresPresentes(array.getNumeroTorcedores()));
			}
			else if(acao == 5){
				JOptionPane.showMessageDialog(null,iu.informaSociosPresentes(array.getNumeroSocios()));
			}
			else if(acao == 6){
				int dia = 1;
				array.zeraEstadio();
				array.somaDias(dia);
			}
			else if (acao == 7){
				JOptionPane.showMessageDialog(null, array.maiorFrequencia());
			}
			else if(acao == 0){
				JOptionPane.showMessageDialog(null,"Volte Sempre!\n");
				loop = false;
			}
		}
		while(loop == true);
	}
}
