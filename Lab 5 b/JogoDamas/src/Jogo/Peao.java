package Jogo;

public class Peao extends Pecas
{
	char j1 = 'p';
	char j2 = 'b';
	Peao(int a)
	{
		if (a==1) { casa = j1;}
		else { casa = j2;}
	}
	public boolean move(char[] caminho)
	{
		int v;
		v = caminho.length;
		if (v == 2 && caminho[1] == '-') return true;
		else if (v == 3 && caminho[2] == '-' && caminho[1] != '-' && caminho[1] != caminho[0]) return true;
		return false;	
	}
}
