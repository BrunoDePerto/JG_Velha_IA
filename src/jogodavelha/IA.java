package jogodavelha;

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
        setNovoJogo(false);
        char tabuleiroPar[] = {
            'X', 'X', 'O', 
            ' ', ' ', ' ', 
            'O', 'O', ' '};
        tabuleiroPar = efetuarJogada(tabuleiroPar);
        for (int i = 0; i < tabuleiroPar.length; i++) {
            System.out.print(tabuleiroPar[i] + " ");
            if (i == 2 || i == 5) {
                System.out.println("");
            }
        }
    }

    @Override
    public char[] efetuarJogada(char tabuleiro[]) {
        this.tabuleiro = tabuleiro;
        //Verifica se é a primeira jogada e escolhe um dos melhores locais
        if (novoJogo) {
            this.tabuleiro = novoJogo(tabuleiro);
        }
        //Verifica se perdeu
        if (verificarGanhador(this.tabuleiro, 'X')) {
            System.out.println("Perdeu");
            return this.tabuleiro;
        }
        //Verifica as posicoes vagas
        int[] posicoesVagas = getPosicoesVagas(this.tabuleiro);
        if(posicoesVagas.length == 0){
            System.out.println("Acabou as opcoes");
            return this.tabuleiro;
        }
        //Executa o minimax
        int[][] melhoresEscolhas
                = miniMax(this.tabuleiro, posicoesVagas);
        //Verifica se pode ganhar
        if(verificarSePodeGanhar(this.tabuleiro, melhoresEscolhas)){
            System.out.println("Ganhou");
            return this.tabuleiro;
        }
        //Bloquear jogador
        if(bloquearJogador(this.tabuleiro, melhoresEscolhas)){
            System.out.println("Perderia");
            return this.tabuleiro;
        }
        //jogar na melhor posicao
        if(jogarNaMelhorPosicao(tabuleiro, melhoresEscolhas)){
            System.out.println("Jogou na melhor opção");
            return this.tabuleiro;
        }
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
        int melhorValor = 0, melhorPosicao = 0;
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
