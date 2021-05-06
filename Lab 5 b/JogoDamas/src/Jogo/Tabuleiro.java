package Jogo;

public class Tabuleiro 
{
	int e[] = new int[6];
	Pecas[][] tabua = new Pecas[9][9];
	String comando;
	Pecas pp;
	int xx, x ,yy ,y ,j;
	boolean faz = false;
	
	Tabuleiro()
	{
		for (int i = 0; i < 9; i++)
		{
			for (int b = 0; b < 9; b++)
			{
				tabua[i][b] = new Pecas();
			}
		}
		for (int i = 0; i < 8; i++) { tabua[i][0] = new Pecas((char) ('8' - i));}
		for (int i = 0; i < 8; i++) { tabua[8][i+1] = new Pecas((char) ('a' + i));}
		tabua[8][0] = new Pecas(' ');
	}
	
	void monta()
	{
		int acumulador = 0;
		for (int i = 0; i < 3; i++)
		{
			for (int b = 1; b < 9; b++)
			{
			if (((b+acumulador)%2)== 0) { tabua[i][b] = new Peao(1);}
			}
			acumulador = (1+acumulador)%2;
		}
		for (int i = 5; i < 8; i++)
		{
			for (int b = 1; b < 9; b++)
			{
			if (((b+acumulador)%2)== 0) { tabua[i][b] = new Peao(2);}
			}
			acumulador = (1+acumulador)%2;
		}
	}

	void controle(String comando)
	{	
		this.comando = comando;
		char chars[] = comando.toCharArray();
		System.out.print(comando + "\n");	
		e[1] = chars[0] - '`';
		e[0] = '8' - chars[1];
		e[3] = chars[3] - '`';
		e[2] = '8' -chars[4];
		x = e[2] - e[0];
		y = e[3] - e[1];
		if (x < 0) x *= -1;
		if (y < 0) y *= -1;
		if (x == y)
		{
			x++;
			char caminho[] = new char[x];
			j = x;
			xx = e[0];
			yy = e[1];
			x = e[2] - e[0];
			y = e[3] - e[1];
			if (x < 0) x = -1;
			else x = 1;
			if (y < 0) y = -1;
			else y = 1;
			e[4] = e[2] - x;
			e[5] = e[3] - y;
			//System.out.print(tabua[e[0]][e[1]].mostra()+" "+(e[0]-e[2]) + " "+ (e[2]-e[0]) + " " + (e[1]-e[3]) + " "+ (e[3]-e[1]) +"\n");
			for (int i = 0; i < j; i++)
			{
				caminho[i] = tabua[xx][yy].mostra();
				xx += x;
				yy += y;
			}
			boolean faz = tabua[e[0]][e[1]].move(caminho);
			if (faz == true)
			{
				altera();
				mostra();
			}
			else System.out.print("Movimento invalido! \n");
		}
		else System.out.print("Movimento invalido! \n");
		
	}
	void altera()
	{
		if (tabua[e[0]][e[1]].mostra() == 'b') 
		{
			tabua[e[2]][e[3]] = new Peao(2);
			if (e[2] == 0) tabua[e[2]][e[3]] = new Damas(2);
		}
		else if (tabua[e[0]][e[1]].mostra() == 'p')
		{
			tabua[e[2]][e[3]] = new Peao(1);
			if (e[2] == 7) tabua[e[2]][e[3]] = new Damas(1);
		}
		else if (tabua[e[0]][e[1]].mostra() == 'P') tabua[e[2]][e[3]] = new Damas(1);
		else  tabua[e[2]][e[3]] = new Damas(2);
		tabua[e[0]][e[1]] = new Pecas();
		tabua[e[4]][e[5]] = new Pecas();
		xx = e[0];
		yy = e[1];
		for (int i = 0; i < j-2; i++)
		{
			xx += x;
			yy += y;
			tabua[xx][yy] = new Pecas();
		}
	}
	
	void mostra()
	{
		for (int i = 0; i < 9; i++)
		{
			for (int b = 0; b < 9; b++)
			{
				System.out.print(tabua[i][b].mostra() + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	char[] mostracsv()
	{
		int end = 0;
		char[] vetor = new char[81];
		for (int i = 0; i < 9; i++)
		{
			for (int b = 0; b < 9; b++)
			{
				vetor[end] =tabua[i][b].mostra();
				end++;
			}
		}
		return vetor;
	}
}