package Jogo;

public class Pecas 
{
	String c;
	char p = 'P';
	Tabuleiro tt;
	void conecta(Tabuleiro tt)
	{
		this.tt = tt;
		for (int i = 0; i < 7; i++)
		{
			for (int b = 0; b < 7; b++)
			{
				if (tt.tabua[i][b] == '-') { tt.tabua[i][b] = p;}
			}
		}
		tt.tabua[3][3] = '-';
		System.out.print("Montando o Tabuleiro \n");
		tt.mostra();
		System.out.print("\n");
	}
	
	void move(String c)
	{
		this.c = c;
		int e[] = new int[6];
		char chars[] = c.toCharArray();
		for (int g = 0; g < 6; g++)
		{
			e[g] = 0;
		}
		System.out.print("    " + c + "\n");		
		e[0] = chars[0] - 'a';
		e[1] = chars[1] - '1';
		e[4] = chars[3] - 'a';
		e[5] = chars[4] - '1';
		if (e[0] == e[4])
		{
			e[2] = e[4];
			e[3] = (e[1] + e[5])/2;
		}
		else
		{
			e[3] = e[1];
			e[2] = (e[0] + e[4])/2;
		}
		if (tt.tabua[e[0]][e[1]] == p)
		{
			if (tt.tabua[e[2]][e[3]] == p)
			{
				if (tt.tabua[e[4]][e[5]] == '-')
				{
					tt.tabua[e[0]][e[1]] = '-';
					tt.tabua[e[2]][e[3]] = '-';
					tt.tabua[e[4]][e[5]] = p;
					tt.mostra();
				}
				else {System.out.print(" COMANDO INVALIDO");}
			}
			else {System.out.print(" COMANDO INVALIDO");}
		}
		else {System.out.print(" COMANDO INVALIDO");}
		System.out.print(" \n");
	}
}



//f4:b4,b4:b2,c4:c2,a1:e1,e1:e3
