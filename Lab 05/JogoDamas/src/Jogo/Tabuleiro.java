package Jogo;

public class Tabuleiro 
{
	char tabua[][] = new char[9][9];
	Damas dama;
	Pecas peca;
	String comando;
	boolean faz = false;
	int e[] = new int[6];
	int vez = 1;
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
		for (int g = 0; g < 6; g++)
		{
			e[g] = 0;
		}
	}
	
	void calldama(Damas dama) { this.dama=dama; }
	void callpeca(Pecas peca) { this.peca=peca; }

	void controle(String comando)
	{	
		this.comando = comando;
		char chars[] = comando.toCharArray();
		System.out.print(comando + "\n");	
		if (e[3] == (chars[0] - '`') && e[2] == ('8' - chars[1])) {vez = (vez+1)%2;}//p/ repetição
		System.out.print("vez do jogador "+ (vez+1) + "\n");
		e[1] = chars[0] - '`';
		e[0] = '8' - chars[1];
		e[3] = chars[3] - '`';
		e[2] = '8' -chars[4];
		if (tabua[e[0]][e[1]] == peca.j1 || tabua[e[0]][e[1]] == peca.j2)
		{
			faz = peca.move_peca();
			if (faz == true)
			{
				altera();
				mostra();
			}
			else System.out.print("COMANDO INVALIDO \n\n");
		}
		else if (tabua[e[0]][e[1]] != '-')
		{
			faz = dama.move_dama();
			if (faz == true)
			{
				altera();
				mostra();
			}
			else System.out.print("COMANDO INVALIDO \n\n");
		}
		else System.out.print("COMANDO INVALIDO \n\n");
	}
	void altera()
	{
		tabua[e[2]][e[3]] = tabua[e[0]][e[1]];
		vez = (vez+1)%2;
		tabua[e[0]][e[1]] = '-';
		tabua[e[4]][e[5]] = '-';
		for (int i = 1; i < 8; i++)
		{
			if (tabua[0][i] == 'b') tabua[0][i] = 'B';
			if (tabua[8][i] == 'p') tabua[8][i] = 'P';
		}
	}
	void mostra()
	{
		for (int i = 0; i < 9; i++)
		{
			for (int b = 0; b < 9; b++)
			{
				System.out.print(tabua[i][b] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}