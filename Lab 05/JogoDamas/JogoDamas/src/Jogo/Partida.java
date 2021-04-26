package Jogo;

public class Partida 
{
	public static void main(String[] args) 
	{
		Tabuleiro jogo1 = new Tabuleiro();
		Damas jogo001 = new Damas();
		Pecas jogo01 = new Pecas();
		jogo1.mostra();
		jogo01.conecta(jogo1);
		jogo1.mostra();
		jogo001.liga(jogo1);
		jogo1.mostra();
	}

}
