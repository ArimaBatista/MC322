package Jogo;

public class Tabuleiro 
{
	char tabua[][] = new char[9][9];
	Damas dama;
	Pecas peca;
	String comando;
	Tabuleiro()
	{
		for (int i = 0; i < 9; i++)
		{
			for (int b = 0; b < 9; b++)
			{
				tabua[i][b] = '-';
			}
		}
		for (int i = 0; i < 8; i++) { tabua[i][0] = (char) ('8' - i);}
		for (int i = 0; i < 8; i++) { tabua[8][i+1] = (char) ('a' + i);}
		tabua[8][0] = ' ';
	}
	
	void calldama(Damas dama) { this.dama=dama; }
	void callpeca(Pecas peca) { this.peca=peca; }

	void controle(String comando)
	{
		this.comando = comando;
		int c[] = new int[4];
		char chars[] = comando.toCharArray();
		for (int g = 0; g < 4; g++)
		{
			c[g] = 0;
		}
		System.out.print(comando + "\n");		
		c[0] = chars[0] - 'a';
		c[1] = chars[1] - '1';
		c[2] = chars[3] - 'a';
		c[3] = chars[4] - '1';
		for (int i = 0; i < 4; i++)
		{
			System.out.print(c[i]);		
		}
		System.out.print("\n");	
	}
	
	void mostra()
	{
		System.out.print("\n");
		for (int i = 0; i < 9; i++)
		{
			for (int b = 0; b < 9; b++)
			{
				System.out.print(tabua[i][b] + " ");
			}
			System.out.print("\n");
		}
	}
}