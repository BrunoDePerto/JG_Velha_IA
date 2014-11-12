package jogodavelha;

public interface Regras {

    public char[] efetuarJogada(char tabuleiro[]);
    public char[] novoJogo(char tabuleiro[]);
    public boolean verificarSePerdeu(char tabuleiro[]);
    public char[] verificarSePodeGanhar(char tabuleiro[]);
    public char[] bloquearJogador(char tabuleiro[]);
    public char[] escolherPosicaoComChanceDeGanhar(char tabuleiro[]);
    public char[] bloquearPosicaoComChanceDePerto(char tabuleiro[]);
    public char[] escolherMelhorPosicao(char tabuleiro[]);
    
}
