package Jogo;

public class Pecas 
{
	String comando;
	char j1 = 'b';
	char j2 = 'p';
	Tabuleiro tt;
	void conecta(Tabuleiro tt)
	{
		this.tt = tt;
		int acumulador = 0;
		for (int i = 0; i < 3; i++)
		{
			for (int b = 1; b < 9; b++)
			{
			if (((b+acumulador)%2)== 0) { tt.tabua[i][b] = j1;}
			}
			acumulador = (1+acumulador)%2;
		}
		for (int i = 5; i < 8; i++)
		{
			for (int b = 1; b < 9; b++)
			{
			if (((b+acumulador)%2)== 0) { tt.tabua[i][b] = j2;}
			}
			acumulador = (1+acumulador)%2;
		}
	}
}
