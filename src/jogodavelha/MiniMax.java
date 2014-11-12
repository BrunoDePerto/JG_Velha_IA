package jogodavelha;

import java.util.Arrays;
import java.util.Random;

public class MiniMax implements Regras {

    private char tabuleiro[];
    private boolean poda;
    private int nosAberto;
    private int totalNosAberto;
    private String ganhador;
    private boolean novoJogo;
    private final int primeiraJogada[] = {4, 0, 2, 6, 8};
    private final int posicoesGanhardoras[][]
            = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};

    public MiniMax() {
        tabuleiro = new char[9];
        novoJogo = true;
        poda = false;
    }

    public void teste() {
        novoJogo = false;
        char tabuleiroPar[] = {'O', 'O', ' ', 'X', 'X', 'O', 'X', ' ', ' '};
        tabuleiroPar = verificarJogada(tabuleiroPar);
        for(int i=0; i<tabuleiroPar.length; i++){
            System.out.print(tabuleiroPar[i] + " ");
            if(i == 2 || i == 5);
        }
        System.out.println(Arrays.toString(tabuleiroPar));
    }

    @Override
    public char[] verificarJogada(char tabuleiro[]) {
        //Verifica se é a primeira jogada e escolhe um dos melhores locais
        if (novoJogo) {
            tabuleiro = novoJogo(tabuleiro);
        }
        if(verificarSePerdeu(tabuleiro)){
            System.out.println("Perdeu");
        }
        if(verificarSePodeGanhar(tabuleiro) != null){
            
        }
        this.tabuleiro = tabuleiro;
        return this.tabuleiro;
    }

    @Override
    public char[] novoJogo(char tabuleiro[]) {
        while (novoJogo) {
            int i = getPrimeiraJogada();
            if (tabuleiro[i] == ' ') {
                tabuleiro[i] = 'O';
                novoJogo = false;
            }
        }
        return tabuleiro;
    }

    @Override
    public char[] verificarSePodeGanhar(char tabuleir[]) {
        return null;
    }

    @Override
    public boolean verificarSePerdeu(char[] tabuleiro) {
        int placar = 0;
        for (int[] combinacaoGanhardora : posicoesGanhardoras) {
            for (int posicaoCorreta : combinacaoGanhardora) {
                if (tabuleiro[posicaoCorreta] == 'X') {
                    placar++;
                }
            }
            if(placar == 3)
                return true;
            placar = 0;
        }
        return false;
    }

    @Override
    public char[] bloquearJogador(char[] tabuleiro) {
        return tabuleiro;
    }

    @Override
    public char[] escolherPosicaoComChanceDeGanhar(char[] tabuleiro) {
        return tabuleiro;
    }

    @Override
    public char[] bloquearPosicaoComChanceDePerto(char[] tabuleiro) {
        return tabuleiro;
    }

    @Override
    public char[] escolherMelhorPosicao(char[] tabuleiro) {
        return tabuleiro;
    }

    public void setPoda(boolean poda) {
        this.poda = poda;
    }

    public int getNosAberto() {
        return nosAberto;
    }

    public String getGanhador() {
        return ganhador;
    }

    public int getTotalNosAberto() {
        return totalNosAberto;
    }

    public void setNovoJogo(boolean novoJogo) {
        this.novoJogo = novoJogo;
    }

    public int getPrimeiraJogada() {
        int max = primeiraJogada.length - 1;
        int min = 0;
        int random = new Random().nextInt((max - min) + 1) + min;
        return primeiraJogada[random];
    }

    public int[][] getPosicoesGanhardoras() {
        return posicoesGanhardoras;
    }
}
