package Jogo;

public class Damas extends Pecas
{
	char j1 = 'P';
	char j2 = 'B';
	Damas(int a)
	{
		if (a==1) { casa = j1;}
		else { casa = j2;}
	}
	public boolean move(char[] caminho)
	{
		int v;
		int a= 0;
		v = caminho.length;
		for (int i = 1; i < (v); i++)
		{
			if (caminho[i] != '-') a++;
			if (caminho[i] == caminho[0]) return false;
			
		}
		if (a > 1) return false;
		return true;	
	}
}