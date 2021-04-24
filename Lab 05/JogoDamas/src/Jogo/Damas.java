package Jogo;

public class Damas 
{
	String comando;
	char j1 = 'B';
	char j2 = 'P';
	Tabuleiro tt;
	void liga(Tabuleiro tt) 
	{
		this.tt = tt;
		for (int b = 1; b < 9; b++)
		{
			tt.tabua[4][b] = j1;
			tt.tabua[3][b] = j2;
		}
	}
}