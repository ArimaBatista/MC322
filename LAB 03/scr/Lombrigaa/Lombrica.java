package lombrigaa;

public class Lombrica
{
    int tlombrica, taquario, inicio, lado, etapa, saida;
    String aquario = "";
    String infolombrica;
    Lombrica (String infolombrica)
    {
        String provi;
        this.infolombrica = infolombrica;
        char chars[] = infolombrica.toCharArray();
        for (int i = 0; i < 6; i=i+2)
        {
            etapa = 6;
            saida = infolombrica.length();
            char p1 = chars[i];
            char p2 = chars[i+1];
            String s1 = String.valueOf(p1);
            String s2 = String.valueOf(p2);
            provi = s1 +  s2;
            if ( i == 0) { taquario = Integer.parseInt(provi);}
            else if ( i == 2) { tlombrica = Integer.parseInt(provi);}
            else { inicio = Integer.parseInt(provi); }
            inicio = inicio + tlombrica - 1;
        }
        if ( tlombrica > (taquario - 2) || inicio < 2 || inicio > (taquario - 2) ) {System.out.println(" erro monumental");}
        aquario = "";
        lado =1 ;
    }
    void construtor()
    {
        System.out.println("  construindo  ");
        int p = inicio - tlombrica;
        int pe = inicio - 1;
        int per = inicio;
        for (int i = 0; i < taquario; i++)
        {
            if (i < p) { aquario = aquario + "#"; }
            else if (i < pe) { aquario = aquario + "@"; }
            else if (i < per) { aquario = aquario + "0"; }
            else { aquario = aquario + "#"; }
        }
    }
    void apresenta()
    {
        System.out.println(" " + aquario + " ");
    }
    void cresce()
    {
        if (lado == 1)
        {
            if ( inicio - tlombrica > 0) 
            {
                int y = inicio - tlombrica -1;
                char chars[] = aquario.toCharArray();
                chars [y] = '@';
                aquario = new String (chars);
                tlombrica++;
                System.out.println("  crescer ");
            }
            else { System.out.println("  erro  "); }
        }
        else
        {
            if ( inicio < taquario) //////////////////////////////////////
            {
                int y = inicio;
                char chars[] = aquario.toCharArray();
                chars [y] = '@';
                aquario = new String (chars);
                tlombrica++;
                System.out.println("  crescer ");
                inicio++;
            }
            else { System.out.println("  erro  "); }
        }
    }
    void vira()
    {
        if (lado == 1)
        {
            int y = inicio - tlombrica;
            char chars[] = aquario.toCharArray();
            chars [inicio - 1] = '@';
            chars [y] = '0';
            aquario = new String (chars);
            lado=2;
            System.out.println("  virar para esquerda");
        }
        else
        {
            int y = inicio - tlombrica;
            char chars[] = aquario.toCharArray();
            chars [inicio - 1] = '0';
            chars [y] = '@';
            aquario = new String (chars);
            lado=1;
            System.out.println("  virar para direita");
        }
    }
    void move()
    {
        if(lado == 1)
        {
            if (inicio != taquario)
            {
                int y = inicio - tlombrica;
                char chars[] = aquario.toCharArray();
                chars [inicio] = '0';
                chars [inicio - 1] = '@';
                chars [y] = '#';
                aquario = new String (chars);
                System.out.println("  move para direita");
                inicio++;
            }
            else { System.out.println("  erro");}
        }
        else
        {
            if ((inicio - tlombrica) > 0)
            {
                int y = inicio - tlombrica;
                char chars[] = aquario.toCharArray();
                chars [y - 1] = '0';
                chars [y] = '@';
                chars [inicio-1] = '#';
                aquario = new String (chars);
                System.out.println("  move para esquerda");
                inicio--;
            }
            else { System.out.println("  erro");}
        }
    }
    void animacao()
    {
        char chars[] = infolombrica.toCharArray();
        if (chars[etapa] == 'c' || chars[etapa] == 'C') { cresce(); }
        else if (chars[etapa] == 'm' || chars[etapa] == 'M') { move(); }
        else if (chars[etapa] == 'v' || chars[etapa] == 'V') { vira(); }
        else { System.out.println(" comando invalido");}
        etapa++;
        apresenta();
    }
    public static void main(String[] args)
    {
        Lombrica l = new Lombrica("150503MCMMMVVvwdjVM");
        l.construtor();
        for (int i = l.etapa; i < l.saida; i++) { l.animacao(); } 
    }
}