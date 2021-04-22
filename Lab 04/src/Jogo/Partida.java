package Jogo;

public class Partida 
{
	public static void main(String[] args) 
	{
		Tabuleiro t1 = new Tabuleiro();
		Pecas p1 = new Pecas();
		CSVReader csv = new CSVReader();
		csv.setDataSource("/home/arima/Área de Trabalho/mc322/Resta1/src/Jogo/RestaUm.csv");
		String commands[] = csv.requestCommands();
		p1.conecta(t1);
		int v;
		v = commands.length;
		for (int i = 0; i < v; i++)
		{
			String manda = commands[i];
			p1.move(manda);
		}
	}

}
