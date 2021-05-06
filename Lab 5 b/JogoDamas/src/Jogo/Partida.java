package Jogo;

public class Partida 
{
	public static void main(String[] args) 
	{
		Tabuleiro jogo1 = new Tabuleiro();
		//jogo1.mostra();
		jogo1.monta();
		jogo1.mostra();
		CSVHandling csv = new CSVHandling();
		csv.setDataSource("/home/arima/Área de Trabalho/mc322/JogoDamas/data/arq001.csv");
		String[] commands = csv.requestCommands();

		char[] saida1 , saida2, saida;
		saida1 =jogo1.mostracsv();
		saida = new char[200];
		int v;
		v = commands.length;
		for (int i = 0; i < v; i++)
		{
			String manda = commands[i];
			jogo1.controle(manda);
		}
		saida2 = jogo1.mostracsv();
		for (int i = 0; i < 81 ; i++)
		{
			saida[i] = saida1[i];
		}
		for (int i = 0; i < 81 ; i++)
		{
			saida[i+81] = saida2[i];
		}	
		String[] arquivo;
		arquivo = new String[200];
		//String[] arquivo = null;
		for (int i = 0; i < 180 ; i++)
		{
			char character = saida[i];
			String str = Character.toString(character);
			arquivo[i] = str;
		}	
				
		CSVHandling to = new CSVHandling ();
		to.setDataExport ("/home/arima/Área de Trabalho/mc322/JogoDamas/data/retorno.csv");
		to.exportState(arquivo);
	}

}



