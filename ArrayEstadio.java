import javax.swing.JOptionPane;

public class ArrayEstadio {

	Pessoa[][] arrayDoEstadio;
	private Saida[] saida;
	private Socio[] socio;
	private Torcedor[] torcedor;
	private InteracaoUsuario iu;
	private int dias;
	Janela janela;
	JanelaSocio janelaSocio;
	
	public ArrayEstadio(){
		dias = 1;
		arrayDoEstadio = new Pessoa[10][14];
		saida = new Saida[4];
		iu = new InteracaoUsuario();
		for(int i=0; i<4;i++)
			saida[i] = new Saida(i);
		
		setArray(saida[0], 0, 0);
		setArray(saida[1], 0, 13);
		setArray(saida[2], 9, 0);
		setArray(saida[3], 9, 13);
		
		Campo campo = new Campo();
		
		for (int linha=2; linha<8;linha++)
			for (int coluna=3; coluna<11; coluna++ )
				setArray(campo, linha, coluna);
		
		socio = new Socio[32];
		for(int i=0; i<32;i++)
			socio[i] = new Socio("Socio");
		
		int contador=0;
		for (int linha=1; linha<9;linha++)
			for (int coluna=2; coluna<12; coluna++ )
				if(getArray(linha, coluna) == null){
					setArray(socio[contador], linha, coluna);
					contador ++;
				}	
		
		torcedor = new Torcedor[56];
		for(int i=0; i<56;i++)
			torcedor[i] = new Torcedor("Torcedor");
		
		contador = 0;
		for (int linha=0; linha<10;linha++)
			for (int coluna=0; coluna<14; coluna++ )
				if(getArray(linha, coluna) == null){
					setArray(torcedor[contador], linha, coluna);
					contador++;
				}	
	}
	
	public void setArray(Pessoa o, int linha,int coluna){
		arrayDoEstadio[linha][coluna] = o;
	}	
	
	public Pessoa getArray(int linha, int coluna){
		return arrayDoEstadio[linha][coluna];
	}
	
	public String verificaAssentoSocio(){
		String visGrafic = "";
		for (int linha=1; linha<9;linha++){
			for (int coluna=2; coluna<12; coluna++ )
				if(getArray(linha, coluna).getNome().equals("Socio")){
					visGrafic += " ["+linha+"|"+coluna+"]";
				}
				else if(getArray(linha, coluna).getNome() != ("Socio") && coluna>=10){
					visGrafic += " [ |  ]";
				}
				else if(getArray(linha, coluna).getNome() != ("Socio")){
					visGrafic += " [ | ]";
				}
			visGrafic+= "\n";
		}
		return visGrafic;
	}

	public void cadastrarSocio(int contador){
		
		int temp = verificaIndiceSocio();
		Pessoa dados = new Pessoa();
		dados = iu.getDados();
		
		int idade = dados.getIdade();
		String nome = dados.getNome();
		double peso = dados.getPeso();
		double altura = dados.getAltura();
		
		if(nome.equals("-1")){
			JOptionPane.showMessageDialog(null, "Dados invalidos, favor preencher todos os campos");
		}
		else if (nome != "0"){
			boolean verifica = false;
			for(int i =0; i<32;i++){
				if((nome.equals(socio[i].getNome())) &&
						idade == socio[i].getIdade() &&
						peso == socio[i].getPeso() &&
						altura == socio[i].getAltura()) {
					JOptionPane.showMessageDialog(null,"Socio ja cadastrado\n");
						socio[temp] = new Socio("Socio");
						verifica = true;
						break;
				}
			}
			if (verifica == false){
				socio[temp] = new Socio(nome,idade, peso, altura, temp+100);
				JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!\nSua ID e: "+socio[temp].getId());
			}
		}	
	}
	
	public int verificaIndiceSocio(){
		int i;
		for( i=0; i<32;i++){
			if(socio[i].getNome().equals("Socio")){
				break;
			}
		}
		return i;
	}
	
	public void setSocio(int i, String nome, int idade, double peso, double altura, int id){
		socio[i]= new Socio (nome, idade, peso ,altura,id);
	}
	
	public void setTorcedor(int i, String nome){
		torcedor[i]= new Torcedor (nome);
	}
	
	public Socio getSocio(int i){
		return socio[i];
	}
	
	public Torcedor getTorcedor(int i){
		return torcedor[i];
	}
	
	public String verificaAssentoTorcedor(){
		String visGrafic = "";
		for (int linha=0; linha<10;linha++){
			for (int coluna=0; coluna<14; coluna++ )
				if(getArray(linha, coluna).getNome().equals("Torcedor")){
					visGrafic += " ["+linha+"|"+coluna+"]";
				}
				else if(getArray(linha, coluna).getNome() != ("Torcedor") && coluna>=10){
					visGrafic += " [ |  ]";
				}
				else if(getArray(linha, coluna).getNome() != ("Torcedor")){
					visGrafic += " [ | ]";
				}
			visGrafic+="\n";
		}
		return visGrafic;
	}

	public void cadastraTorcedor(){
		
		int temp = verificaIndiceTorcedor();
		Pessoa dados = new Pessoa();
		dados = iu.getDados();
		
		int idade = dados.getIdade();
		String nome = dados.getNome();
		double peso = dados.getPeso();
		double altura = dados.getAltura();
		
		if(nome.equals("-1")){
			JOptionPane.showMessageDialog(null, "Dados invalidos, favor preencher todos os campos");
		}
		
		else if (nome != "0"){
			boolean verifica = false;
			for(int i =0; i<56;i++){
				if((nome.equals(torcedor[i].getNome())) &&
					idade == torcedor[i].getIdade() &&
					peso == torcedor[i].getPeso() &&
					altura == torcedor[i].getAltura()) {
						JOptionPane.showMessageDialog(null,"Torcedor ja cadastrado\n");
						torcedor[temp] = new Torcedor("Torcedor");
						verifica = true;
						break;
				}
			}
			if(verifica == false){
					torcedor[temp] = new Torcedor(nome,idade, peso, altura, 0);
					JOptionPane.showMessageDialog(null,"Torcedor cadastrado com sucesso");
			}
		}
	}
	
	public int verificaIndiceTorcedor(){
		int i;
		for( i =0; i<56;i++){
			if(torcedor[i].getNome().equals("Torcedor")){
				break;
			}
		}
		return i;
	}
	
	public String getAssentoMaisProximo(){
		int linha,coluna,colunaCampo,linhaCampo;
		String visGrafic = "";
		float menorDistancia = 140;
		for (linha=0; linha<10;linha++)
			for (coluna=0; coluna<14; coluna++ )
				if(getArray(linha, coluna).getNome().equals("Torcedor"))
					for (linhaCampo=2; linhaCampo<8;linhaCampo++)
						for (colunaCampo=3; colunaCampo<11; colunaCampo++ )
							if(Math.sqrt( Math.pow( (linha - linhaCampo),2 ) + Math.pow( (coluna - colunaCampo),2 ) ) < menorDistancia){
								menorDistancia = (float) Math.sqrt( Math.pow( (linha - linhaCampo),2 ) + Math.pow( (coluna - colunaCampo),2 ) );
								visGrafic = " ["+linha+"|"+coluna+"] -";
							}	
							else if(menorDistancia == Math.sqrt( Math.pow( (linha - linhaCampo),2 ) + Math.pow( (coluna - colunaCampo),2 ) )){
								visGrafic += " ["+linha+"|"+coluna+"] -";
							}
		return visGrafic;
	}
	
	public String getSaidaMaisProxima(int linha, int coluna){
		
		String visGrafic = "";
		float menorDistancia = 140;	
		//1
		if(Math.sqrt( Math.pow( (linha - 0),2 ) + Math.pow( (coluna - 0),2 ) ) < menorDistancia){
			menorDistancia = (float) Math.sqrt( Math.pow( (linha - 0),2 ) + Math.pow( (coluna - 0),2 ) );
			visGrafic = " [saida|"+1+"]";
		}
		//2
		if(Math.sqrt( Math.pow( (linha - 0),2 ) + Math.pow( (coluna - 13),2 ) ) < menorDistancia){
			menorDistancia = (float) Math.sqrt( Math.pow( (linha - 0),2 ) + Math.pow( (coluna - 13),2 ) );
			visGrafic = " [saida|"+2+"]";
		}
		//3
		if(Math.sqrt( Math.pow( (linha - 9),2 ) + Math.pow( (coluna - 0),2 ) ) < menorDistancia){
			menorDistancia = (float) Math.sqrt( Math.pow( (linha - 9),2 ) + Math.pow( (coluna - 0),2 ) );
			visGrafic = " [saida|"+3+"]";
		}
		//4
		if(Math.sqrt( Math.pow( (linha - 9),2 ) + Math.pow( (coluna - 13),2 ) ) < menorDistancia){
			menorDistancia = (float) Math.sqrt( Math.pow( (linha - 9),2 ) + Math.pow( (coluna - 13),2 ) );
			visGrafic = " [saida|"+4+"]";
		}
		return visGrafic;
	}

	public int getNumeroTorcedores(){
		int contador = 0;
		for (int linha=0; linha<10;linha++){
			for (int coluna=0; coluna<14; coluna++ ){
					if(getArray(linha, coluna) instanceof Torcedor && ((Torcedor)getArray(linha, coluna)).getNome() != ("Torcedor")){
						contador ++;
					}
				
			}
		}
		return contador;
	}
	
	public int getNumeroSocios(){
		int contador = 0;
		for (int linha=0; linha<10;linha++){
			for (int coluna=0; coluna<14; coluna++ ){
					if(getArray(linha, coluna) instanceof Socio && ((Socio)getArray(linha, coluna)).getId() != 0){
						contador ++;
					}
			}
		}
		return contador;
	}
	
	public void zeraEstadio(){
		
		Torcedor[] torcedor2 = torcedor.clone();
		
		torcedor[0] = new Torcedor("Torcedor");
		
		for (int linha=0; linha<10;linha++)
			for (int coluna=0; coluna<14; coluna++ )
				setArray(torcedor[0], linha, coluna);
			
		setArray(saida[0], 0, 0);
		setArray(saida[1], 0, 13);
		setArray(saida[2], 9, 0);
		setArray(saida[3], 9, 13);
		
		Campo campo = new Campo();
				
		for (int linha=2; linha<8;linha++)
			for (int coluna=3; coluna<11; coluna++ )
				setArray(campo, linha, coluna);
		
		Socio[] socio2 = socio.clone();
				
		for(int i=0; i<32;i++)
			socio[i] = new Socio("Socio");
		
		int contador=0;
		for (int linha=1; linha<9;linha++)
			for (int coluna=2; coluna<12; coluna++ )
				if(getArray(linha, coluna).getNome() != "Campo" ){
					setArray(socio[contador], linha, coluna);
					contador ++;
				}
		socio = socio2.clone();
		torcedor = torcedor2.clone();
	}
	
	public int getDias(){
		return dias;
	}
	
	public void setDias(int dias){
		this.dias = dias;
	}
	
	public void somaDias(int dias){
		this.dias += dias;
	}
	
	public String maiorFrequencia(){
		
		double maiorFrequencia = 0;
		String nome = "";
		String freq = "";
		for(int i=0;i<56;i++){
			if((torcedor[i].getFrequencia())/(getDias())*100 > maiorFrequencia){
				maiorFrequencia = (torcedor[i].getFrequencia())/(getDias())*100;
				nome = torcedor[i].getNome();
				freq = String.valueOf(maiorFrequencia);
			}
		}
		String txt = ("O torcedor com maior frequencia e: "+nome+". Com uma frequencia de "+freq+"%\n");
		return txt;
	}
	
	public void compraIngresso(){
		
		int id;
		int local = 0;
		boolean verifica = false;
		String tipo = iu.informaTipo();
		if(tipo.equals("s")){
			id = iu.informaId();
			if (id == -1){}
			else if(id < -1){
				JOptionPane.showMessageDialog(null, "ID invalida");
			}
			else if (id >= 0){
				Pessoa verificacao = new Pessoa();
				verificacao = iu.getDados();
				for (int linha=0; linha<32;linha++){
					if(((Socio)getSocio(linha)).equals(verificacao) &&
						id == ((getSocio(linha).getId()))){
							local = linha;
							JOptionPane.showMessageDialog(null, "Cadastro OK");
							verifica = true;
							break;
					}
				}
				if (verifica == false){
					do{
						JOptionPane.showMessageDialog(null,"Cadastro nao encontrado\nFavor verifique os dados inseridos\n");
						id = iu.informaId();
						
						if (id == -1){
							verifica = true;
						}
						else if(id < -1){
							JOptionPane.showMessageDialog(null, "ID invalida");
							verifica = true;
						}
						else if (id >= 0){
							Pessoa verificacao2 = new Pessoa();
							verificacao2 = iu.getDados();
							for (int linha=0; linha<32;linha++){
								if(((Socio)getSocio(linha)).equals(verificacao2) &&
									id == ((getSocio(linha).getId()))){
										local = linha;
										JOptionPane.showMessageDialog(null, "Cadastro OK");
										verifica = true;
										break;
								}
							}
						}
					}while(verifica == false);
				}
				if (id == -1){}
				else if(id < -1){
				}
				else if (id >= 0){
					//System.out.println("Assentos disponiveis:\n");
					//System.out.println(verificaAssentoSocio());
					
					actionSocio(arrayDoEstadio);
					String linhaColuna = (informaLinhaColunaSocio());
					String[] options = new String[2];
					options = linhaColuna.split(" ");
					int linhaAssento=Integer.parseInt(options[0]), colunaAssento=Integer.parseInt(options[1]);
					
					if (linhaAssento == -1 || colunaAssento == -1){
						JOptionPane.showMessageDialog(null, "Assento invalido");
					}
					else{
						if((getArray(linhaAssento, colunaAssento).getNome()).equals("Socio")){
							setArray(((Socio)getSocio(local)), linhaAssento,colunaAssento );
							JOptionPane.showMessageDialog(null, "Seu assento foi reservado com sucesso!\n"+iu.informaAssento(linhaAssento, colunaAssento)+
									"\nA saida mais proxima do seu assento e:"+getSaidaMaisProxima(linhaAssento, colunaAssento)+"\n");
						}
						else{	
							JOptionPane.showMessageDialog(null,"Esse assento nao esta disponivel!\n");
						}
					}	
				}
			}
		}
		else if(tipo.equals("t")){
			local = 0;	
			Pessoa verificacao3 = new Pessoa();
			verificacao3 = iu.getDados();
			if (verificacao3.getNome().equals("0")){}
			else if (verificacao3.getNome().equals("-1")){
				JOptionPane.showMessageDialog(null, "Dados invalidos");
			}
			else{
				for (int linha=0; linha<56;linha++){
					if(((Torcedor)getTorcedor(linha)).equals(verificacao3)){
							local = linha;
							JOptionPane.showMessageDialog(null,"Cadastro OK\n");
							verifica = true;
							if (verifica == true){
								
								action(arrayDoEstadio);
								
								String linhaColuna = (informaLinhaColuna());
								String[] options = new String[2];
								options = linhaColuna.split(" ");
								int linhaAssento=Integer.parseInt(options[0]), colunaAssento=Integer.parseInt(options[1]);
								if (linhaAssento == -1 || colunaAssento == -1){
									JOptionPane.showMessageDialog(null, "Assento invalido");
								}
								else{
									if((getArray(linhaAssento, colunaAssento).getNome()).equals("Torcedor")){
										setArray((Torcedor)getTorcedor(local), linhaAssento,colunaAssento );
											JOptionPane.showMessageDialog(null,"Seu assento foi reservado com sucesso!\n"+iu.informaAssento(linhaAssento, colunaAssento)+
												"\nA saida mais proximas do seu assento e:"+getSaidaMaisProxima(linhaAssento, colunaAssento));
											getTorcedor(local).setFrequencia(1);
											break;
									}
									else{	
										JOptionPane.showMessageDialog(null,"Esse assento nao esta disponivel!\n");
										break;
									}
								}	
							}
					}
				}
				if (verifica == false){
					do{
						JOptionPane.showMessageDialog(null,"Cadastro nao encontrado\nFavor verifique os dados inseridos\n");
						Pessoa verificacao4 = new Pessoa();
						verificacao4 = iu.getDados();
						if(verificacao4.getNome().equals("-1")){
							JOptionPane.showMessageDialog(null, "Dados invalidos, favor preencher todos os campos");
							verifica = true;
						}
						else if (verificacao4.getNome().equals("0")){
							verifica = true;
						}
						else if (verificacao4.getNome() != "0"){
						
							for (int linha=0; linha<56;linha++){
								if(((Torcedor)getTorcedor(linha)).equals(verificacao4)){
										local = linha;
										JOptionPane.showMessageDialog(null,"Cadastro OK\n");
										verifica = true;
										if (verifica == true){
											//System.out.println("Escolha um dos assentos disponiveis:\n");
											//System.out.println(verificaAssentoTorcedor());
											//JOptionPane.showMessageDialog(null, "Os assentos mais proximos ao campo sao:\n"+getAssentoMaisProximo());
											//System.out.println(getAssentoMaisProximo()+"\n");
											
											action(arrayDoEstadio);
											String linhaColuna = (informaLinhaColuna());
											String[] options = new String[2];
											options = linhaColuna.split(" ");
											int linhaAssento=Integer.parseInt(options[0]), colunaAssento=Integer.parseInt(options[1]);
											if (linhaAssento == -1 || colunaAssento == -1){
												JOptionPane.showMessageDialog(null, "Assento invalido");
											}
											else{
												if((getArray(linhaAssento, colunaAssento).getNome()).equals("Torcedor")){
													setArray((Torcedor)getTorcedor(local), linhaAssento,colunaAssento );
														JOptionPane.showMessageDialog(null,"Seu assento foi reservado com sucesso!\n"+iu.informaAssento(linhaAssento, colunaAssento)+
															"\nA saida mais proximas do seu assento e:"+getSaidaMaisProxima(linhaAssento, colunaAssento));
														getTorcedor(local).setFrequencia(1);
														break;
												}
												else{	
													JOptionPane.showMessageDialog(null,"Esse assento nao esta disponivel!\n");
													break;
												}
											}	
										}
								}
							}
						}
						
					}while(verifica == false);
				}
			}	
		}
	}
	
	public void action(Pessoa[][] arrayDoEstadio){
		janela = null;
		janela = new Janela(arrayDoEstadio);
		do{janela.setVisible(true);
		}while(janela.getEscolha() == null);
		janela.setVisible(false);
	}

	public String informaLinhaColuna(){
		String txt = janela.getEscolha();
		return txt;
	}
	
	public void actionSocio(Pessoa[][] arrayDoEstadio){
		janelaSocio = null;
		janelaSocio = new JanelaSocio(arrayDoEstadio);
		do{janelaSocio.setVisible(true);
		}while(janelaSocio.getEscolha() == null);
		janelaSocio.setVisible(false);
	}

	public String informaLinhaColunaSocio(){
		String txt = janelaSocio.getEscolha();
		return txt;
	}
}
