package jogodavelha;

import java.util.Random;

public abstract class MiniMax {
    
    private final int primeiraJogada[] = {4, 0, 2, 6, 8};
    private final int posicoesGanhadoras[][] = 
            {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};

     public int getPrimeiraJogada() {
        int max = primeiraJogada.length - 1;
        int min = 0;
        int random = new Random().nextInt((max - min) + 1) + min;
        return primeiraJogada[random];
    }

    public int[][] getPosicoesGanhadoras() {
        return posicoesGanhadoras;
    }
    
}
