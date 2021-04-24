package Jogo;

public class Tabuleiro 
{
	char tabua[][] = new char[9][9];
	Tabuleiro()
	{
		for (int i = 0; i < 9; i++)
		{
			for (int b = 0; b < 9; b++)
			{
				tabua[i][b] = '-';
			}
		}
		for (int i = 0; i < 8; i++) { tabua[i][0] = (char) ('1' + i);}
		for (int i = 0; i < 8; i++) { tabua[8][i+1] = (char) ('a' + i);}
		tabua[8][0] = ' ';
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