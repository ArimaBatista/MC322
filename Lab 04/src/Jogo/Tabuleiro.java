package Jogo;

public class Tabuleiro 
{
	char tabua[][] = new char[7][7];
	Tabuleiro()
	{
		for (int i = 0; i < 7; i++)
		{
			for (int b = 0; b < 7; b++)
			{
				if (i > 1 && i < 5) { tabua[i][b] = '-';}
				else if (b > 1 && b < 5) { tabua[i][b] = '-';}
				else { tabua[i][b] = ' ';}//null
			}
		}
	}

	void mostra()
	{
		for (int i = 0; i < 7; i++)
		{
			for (int b = 0; b < 7; b++)
			{
				System.out.print(tabua[i][b] + " ");
			}
			System.out.print("\n");
		}
	}
}
