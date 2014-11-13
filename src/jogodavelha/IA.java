package jogodavelha;

import java.util.ArrayList;
import java.util.List;

public class IA extends MiniMax implements Regras {

    private char tabuleiro[];
    private boolean poda;
    private int nosAberto;
    private int totalNosAberto;
    private String ganhador;
    private boolean novoJogo;
   

    public IA() {
        tabuleiro = new char[9];
        novoJogo = true;
        poda = false;
    }

    public void teste() {
        setNovoJogo(true);
        char tabuleiroPar[] = {' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' '};
        tabuleiroPar = efetuarJogada(tabuleiroPar);
        for(int i=0; i<tabuleiroPar.length; i++){
            System.out.print(tabuleiroPar[i] + " ");
            if(i == 2 || i == 5)
                System.out.println("");
        }
    }

    @Override
    public char[] efetuarJogada(char tabuleiro[]) {
        //Verifica se é a primeira jogada e escolhe um dos melhores locais
        if (novoJogo) {
            tabuleiro = novoJogo(tabuleiro);
        }
        if(verificarSePerdeu(tabuleiro)){
            System.out.println("Perdeu");
        }
        //Verifica as posicoes vagas
        List<Integer> posicoesVagas = getPosicoesVagas(tabuleiro);
        //Executa o minimax
        
        //verifica se pode ganhar
        //bloquear jogador
        //escolher melhor posicao com chance de ganhar
        //nao deixar jogador escolher posicao com chance de ganhar
        //escolher uma boa posicao
        if(verificarSePodeGanhar(tabuleiro) != null){
            
        }
        this.tabuleiro = tabuleiro;
        return this.tabuleiro;
    }

    @Override
    public char[] novoJogo(char tabuleiro[]) {
        while (isNovoJogo()) {
            int i = getPrimeiraJogada();
            if (tabuleiro[i] == ' ') {
                tabuleiro[i] = 'O';
                setNovoJogo(false);
            }
        }
        return tabuleiro;
    }

    @Override
    public char[] verificarSePodeGanhar(char tabuleiro[]) {
        return null;
    }

    @Override
    public boolean verificarSePerdeu(char[] tabuleiro) {
        int placar = 0;
        for (int[] combinacaoGanhardora : getPosicoesGanhadoras()) {
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
    
    public List<Integer> getPosicoesVagas(char[] tabuleiro){
        List<Integer> posicoesVagas = new ArrayList<>();
        for(int i=0; i < tabuleiro.length; i++){
            if(tabuleiro[i] == ' '){
                posicoesVagas.add(i);
            }
        }
        return posicoesVagas;
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

    public boolean isNovoJogo() {
        return novoJogo;
    }
    
    public void setNovoJogo(boolean novoJogo) {
        this.novoJogo = novoJogo;
    }


}
