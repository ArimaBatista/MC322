package Jogo;

public class Partida 
{
	public static void main(String[] args) 
	{
		Tabuleiro jogo1 = new Tabuleiro();
		Damas jogo001 = new Damas();
		Pecas jogo01 = new Pecas();
		CSVReader csv = new CSVReader();
		csv.setDataSource("/home/arima/Área de Trabalho/mc322/JogoDamas/src/Jogo/movimentosimples.csv");
		String commands[] = csv.requestCommands();
		jogo1.calldama(jogo001);
		jogo1.callpeca(jogo01);
		//jogo1.mostra();
		jogo01.conecta(jogo1);
		jogo001.liga(jogo1);
		//jogo1.mostra();
		int v;
		v = commands.length;
		for (int i = 0; i < v; i++)
		{
			String manda = commands[i];
			jogo1.controle(manda);
		}
		
	}

}
