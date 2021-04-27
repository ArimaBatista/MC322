package Jogo;

public class Pecas 
{
	String comando;
	char j1 = 'p';
	char j2 = 'b';
	Tabuleiro tt;
	
	boolean move_peca()
	{
		if (tt.tabua[tt.e[2]][tt.e[3]] == '-') 
		{
			int x = tt.e[2] - tt.e[0];
			int y = tt.e[1] - tt.e[3];
			x = x*x;
			y = y*y;
			if (x == 1 && y == 1)
			{
				tt.e[4] = tt.e[0];
				tt.e[5] = tt.e[1];
				if (tt.vez == 0 && tt.tabua[tt.e[0]][tt.e[1]] == j1 && tt.e[0] < tt.e[2]) { return true;}
				else if (tt.vez == 1 && tt.tabua[tt.e[0]][tt.e[1]] == j2  && tt.e[0] > tt.e[2]) { return true;}
				else { return false; }
			}
			else if (x == 4 && y == 4)
			{
				tt.e[4] = (tt.e[2] + tt.e[0])/2;
				tt.e[5] = (tt.e[1] + tt.e[3])/2;
				if (tt.vez == 0 && tt.tabua[tt.e[0]][tt.e[1]] == j1 && tt.e[0] < tt.e[2]) 
				{ 
					if (tt.tabua[tt.e[4]][tt.e[5]] == 'B' || tt.tabua[tt.e[4]][tt.e[5]] == 'b') { return true; } 
					else { return false; }
				}
				else if (tt.vez == 1 && tt.tabua[tt.e[0]][tt.e[1]] == j2 && tt.e[0] > tt.e[2]) 
				{
					if (tt.tabua[tt.e[4]][tt.e[5]] == 'p' || tt.tabua[tt.e[4]][tt.e[5]] == 'P') { return true; } 
					else { return false; } 
				}
				else { return false; }
			}
			else { return false; }
		}
		else { return false; }
	}
	
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
