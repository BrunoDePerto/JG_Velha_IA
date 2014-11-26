package jogodavelha;

import java.util.Random;

public abstract class MiniMax {

    private final int primeiraJogada[] = {4, 0, 2, 6, 8};
    private final int posicoesGanhadoras[][]
            = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};
    protected int nosAberto;
    protected int totalNosAberto;

    public int getPrimeiraJogada() {
        int max = primeiraJogada.length - 1;
        int min = 0;
        int random = new Random().nextInt((max - min) + 1) + min;
        return primeiraJogada[random];
    }

    public int[][] getPosicoesGanhadoras() {
        return posicoesGanhadoras;
    }

    public int[][] miniMax(char[] tabuleiro, int[] posicoesVagas) {
        int[][] melhoresEscolhas
                = new int[posicoesVagas.length][3];
        nosAberto = 0;
        for (int i = 0; i < melhoresEscolhas.length; i++) {
            melhoresEscolhas[i][0] = posicoesVagas[i];
            melhoresEscolhas[i][1] = miniMax(tabuleiro, posicoesVagas[i], 0, 0, 'O');
            melhoresEscolhas[i][2] = miniMax(tabuleiro, posicoesVagas[i], 0, 0, 'X');
        }
        totalNosAberto += nosAberto;
        return melhoresEscolhas;
    }

    public int miniMax(char[] tabuleiro, int posicao, int opcao, int valor, char jogador) {
        nosAberto++;
        int valorTemp = 0;
        if (opcao == posicoesGanhadoras.length) {
            return valor;
        }
        if (tabuleiro[posicoesGanhadoras[opcao][0]] == 'O'
                || posicoesGanhadoras[opcao][0] == posicao && jogador == 'O') {
            valorTemp = 1;
        } else if (tabuleiro[posicoesGanhadoras[opcao][0]] == 'X'
                || posicoesGanhadoras[opcao][0] == posicao && jogador == 'X') {
            valorTemp = -1;
        }
        if (tabuleiro[posicoesGanhadoras[opcao][1]] == 'O'
                || posicoesGanhadoras[opcao][1] == posicao && jogador == 'O') {
            if (valorTemp == 1) {
                valorTemp = 10;
            } else if (valorTemp == -1) {
                valorTemp = 0;
            } else {
                valorTemp = 1;
            }
        } else if (tabuleiro[posicoesGanhadoras[opcao][1]] == 'X'
                || posicoesGanhadoras[opcao][1] == posicao && jogador == 'X') {
            if (valorTemp == -1) {
                valorTemp = -10;
            } else if (valorTemp == 1) {
                valorTemp = 0;
            } else {
                valorTemp = -1;
            }
        }
        if (tabuleiro[posicoesGanhadoras[opcao][2]] == 'O'
                || posicoesGanhadoras[opcao][2] == posicao && jogador == 'O') {
            if (valorTemp > 0) {
                valorTemp *= 10;
            } else if (valorTemp < 0) {
                valorTemp = 0;
            } else {
                valorTemp = 1;
            }
        } else if (tabuleiro[posicoesGanhadoras[opcao][2]] == 'X'
                || posicoesGanhadoras[opcao][2] == posicao && jogador == 'X') {
            if (valorTemp < 0) {
                valorTemp *= 10;
            } else if (valorTemp > 1) {
                valorTemp = 0;
            } else {
                valorTemp = -1;
            }

        }
        valor += valorTemp;
        return miniMax(tabuleiro, posicao, opcao + 1, valor, jogador);
    }
}
