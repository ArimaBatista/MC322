package Jogo;

public class Damas 
{
	String comando;
	char g1 = 'B';
	char g2 = 'P';
	Tabuleiro tt;
	void liga(Tabuleiro tt) { this.tt = tt; }
	
	boolean move_dama()
	{
		int x = tt.e[2] - tt.e[0];
		int y = tt.e[3] - tt.e[1];
		tt.e[4] = tt.e[0];
		tt.e[5] = tt.e[1];
		int z = x;
		if (z < 0) z *= -1;
		if (x*x == y*y)
		{
			if (tt.tabua[tt.e[2]][tt.e[3]] == '-')
			{
				if (x > 0) x=1;
				else x=-1;
				if (y > 0) y=1;
				else y=-1;
				for (int i = 0; i < (z-2); i++)
				{
					tt.e[4] += x;
					tt.e[5] += y;
					if (tt.tabua[tt.e[4]][tt.e[5]] != '-') return false;
				}
				tt.e[4] += x;
				tt.e[5] += y;
				return true;
			}
			else return false;
		}
		else return false;
	}
}