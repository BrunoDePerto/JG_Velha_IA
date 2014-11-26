package jogodavelha;

public class IA extends MiniMax implements Regras {

    private char tabuleiro[];
    private boolean poda;
    
    private String ganhador;
    private boolean primeiroJogar;

    public IA() {
        tabuleiro = new char[9];
        primeiroJogar = true;
        poda = false;
        totalNosAberto = 0;
    }

    @Override
    public char[] efetuarJogada(char tabuleiro[]) {
        this.tabuleiro = tabuleiro;
        ganhador = "";
        //Verifica se é a primeira jogada e escolhe um dos melhores locais
        if (primeiroJogar) {
            this.tabuleiro = novoJogo(tabuleiro);
            return this.tabuleiro;
        }
        //Verifica se perdeu
        if (verificarGanhador(this.tabuleiro, 'X')) {
            ganhador = "Jogador";
            return this.tabuleiro;
        }
        //Verifica as posicoes vagas
        int[] posicoesVagas = getPosicoesVagas(this.tabuleiro);
        if(posicoesVagas.length == 0){
            ganhador = "Empate";
            return this.tabuleiro;
        }
        //Executa o minimax
        int[][] melhoresEscolhas
                = miniMax(this.tabuleiro, posicoesVagas);
        //Verifica se pode ganhar
        if(verificarSePodeGanhar(this.tabuleiro, melhoresEscolhas)){
            ganhador = "Computador";
            return this.tabuleiro;
        }
        //Bloquear jogador
        if(bloquearJogador(this.tabuleiro, melhoresEscolhas)){
            return this.tabuleiro;
        }
        //jogar na melhor posicao
        if(jogarNaMelhorPosicao(tabuleiro, melhoresEscolhas)){
            return this.tabuleiro;
        }
        return this.tabuleiro;
    }

    @Override
    public char[] novoJogo(char tabuleiro[]) {
        while (primeiroJogar) {
            int i = getPrimeiraJogada();
            if (tabuleiro[i] == ' ') {
                tabuleiro[i] = 'O';
                setPrimeiroJogar(false);
            }
        }
        return tabuleiro;
    }

    @Override
    public boolean verificarGanhador(char[] tabuleiro, char jogador) {
        int placar = 0;
        for (int[] combinacaoGanhardora : getPosicoesGanhadoras()) {
            for (int posicaoCorreta : combinacaoGanhardora) {
                if (tabuleiro[posicaoCorreta] == jogador) {
                    placar++;
                }
            }
            if (placar == 3) {
                return true;
            }
            placar = 0;
        }
        return false;
    }
    
    @Override
    public boolean verificarSePodeGanhar(char[] tabuleiro, int[][] melhoresEscolhas){
        int melhorValor = -1000, melhorPosicao = -1000;
        for (int[] melhoresEscolha : melhoresEscolhas) {
            if (melhoresEscolha[1] > melhorValor) {
                melhorPosicao = melhoresEscolha[0];
                melhorValor = melhoresEscolha[1];
            }
        }
        char[] tabuleiroTemp = new char[tabuleiro.length];
        System.arraycopy(tabuleiro, 0, tabuleiroTemp, 0, tabuleiro.length);
        tabuleiroTemp[melhorPosicao] = 'O';
        if (verificarGanhador(tabuleiroTemp, 'O')) {
            this.tabuleiro = tabuleiroTemp;
            return true;
        }
        return false;
    }

    @Override
    public boolean bloquearJogador(char[] tabuleiro, int[][] melhoresEscolhas) {
        int piorValor = 1000, piorPosicao = 1000;
        for (int[] melhoresEscolha : melhoresEscolhas) {
            if (melhoresEscolha[2] < piorValor) {
                piorPosicao = melhoresEscolha[0];
                piorValor = melhoresEscolha[2];
            }
        }
        char[] tabuleiroTemp = new char[tabuleiro.length];
        System.arraycopy(tabuleiro, 0, tabuleiroTemp, 0, tabuleiro.length);
        tabuleiroTemp[piorPosicao] = 'X';
        if (verificarGanhador(tabuleiroTemp, 'X')) {
            tabuleiroTemp[piorPosicao] = 'O';
            this.tabuleiro = tabuleiroTemp;
            return true;
        }
        return false;
    }

    @Override
    public boolean jogarNaMelhorPosicao(char tabuleiro[], int[][] melhoresEscolhas){
        int melhorValor = -1000, melhorPosicao = -1000;
        for (int[] melhoresEscolha : melhoresEscolhas) {
            if (melhoresEscolha[1] > melhorValor) {
                melhorPosicao = melhoresEscolha[0];
                melhorValor = melhoresEscolha[1];
            }
        }
        this.tabuleiro[melhorPosicao] = 'O';
        return true;
    }
    
    public int[] getPosicoesVagas(char[] tabuleiro) {
        int[] posicoesVagasTemp = new int[9];
        int controle = 0;
        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i] == ' ') {
                posicoesVagasTemp[controle] = i;
                controle++;
            }
        }
        int[] posicoesVagas = new int[controle];
        System.arraycopy(posicoesVagasTemp, 0, posicoesVagas, 0, posicoesVagas.length);
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

    public void setTotalNosAberto(int totalNosAberto) {
        this.totalNosAberto = totalNosAberto;
    }
    
    public int getTotalNosAberto() {
        return totalNosAberto;
    }

    public void setPrimeiroJogar(boolean primeiroJogar) {
        this.primeiroJogar = primeiroJogar;
        this.tabuleiro = new char[9];
    }

}
