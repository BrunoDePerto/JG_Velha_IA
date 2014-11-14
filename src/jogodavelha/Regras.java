package jogodavelha;

public interface Regras {

    public char[] efetuarJogada(char tabuleiro[]);
    public char[] novoJogo(char tabuleiro[]);
    public boolean verificarGanhador(char tabuleiro[], char jogador);
    public boolean verificarSePodeGanhar(char tabuleiro[], int[][] melhoresEscolhas);
    public boolean bloquearJogador(char tabuleiro[], int[][] melhoresEscolhas);
    public boolean escolherPosicaoComChanceDeGanhar(char tabuleiro[]);
    public boolean bloquearPosicaoComChanceDePerto(char tabuleiro[]);
    public char[] escolherMelhorPosicao(char tabuleiro[]);
    
}
