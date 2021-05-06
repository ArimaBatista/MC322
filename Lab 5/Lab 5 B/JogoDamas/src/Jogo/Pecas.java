package Jogo;

public class Pecas 
{
	char casa;
	Pecas()
	{
		casa = '-';
	}
	Pecas(char casa)
	{
		this.casa = casa;
	}
	public char mostra()
	{
		return casa;
	}
	public boolean move(char[] caminho)
	{
		System.out.print("1 ");
		return false;		
	}
}
