package jogodavelha;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Tela extends javax.swing.JFrame {

    IA ia;
    char  tabujogada[] = {
            ' ', ' ', ' ', 
            ' ', ' ', ' ', 
            ' ', ' ', ' '};
    
    double tempo1, tempo2, result;  
    
    public Tela() {
        initComponents();   
        ia = new IA();
    }  
    
    //Francis Hilla em: 22/11/2014 Método da jogada do PC
    public void jogaPc(){
        int tam = tabujogada.length;
        for(int i = 0; i < tam; i++){
            if(tabujogada[i] == 'O'){   //identifica se a posição é bolinha = jogada do pc
                if(i == 0){
                    jbL1C1.setText("O");
                    jbL1C1.setEnabled(false);
                }
                if(i == 1){
                    jbL1C2.setText("O");
                    jbL1C2.setEnabled(false);
                }
                if(i == 2){
                    jbL1C3.setText("O");
                    jbL1C3.setEnabled(false);
                }
                if(i == 3){
                    jbL2C1.setText("O");
                    jbL2C1.setEnabled(false);
                }
                if(i == 4){
                    jbL2C2.setText("O");
                    jbL2C2.setEnabled(false);
                }
                if(i == 5){
                    jbL2C3.setText("O");
                    jbL2C3.setEnabled(false);
                }
                if(i == 6){
                    jbL3C1.setText("O");
                    jbL3C1.setEnabled(false);
                }
                if(i == 7){
                    jbL3C2.setText("O");
                    jbL3C2.setEnabled(false);
                }
                if(i == 8){
                    jbL3C3.setText("O");
                    jbL3C3.setEnabled(false);
                }
            }
        }
    }
    
    void fazerJogada(int posicao){
        tempo1 = System.nanoTime();
        tabujogada[posicao] = 'X';
        tabujogada = ia.efetuarJogada(tabujogada);
        jogaPc();
        tempo2 = System.nanoTime();
        result = (tempo2 - tempo1)/100;
        //System.out.println("O tempo da jogada é: " + String.valueOf(result) + " ms");
        jlTempoDeJogadaPC.setText(String.valueOf(new DecimalFormat("0.000").format(result/1000)));      
        jlNosAbertos.setText(String.valueOf(ia.getNosAberto()));
        jlTotNosAbertos.setText(String.valueOf(ia.getTotalNosAberto()));
        
		verificaGanhador();     
    }
	
	 void verificaGanhador(){
        if(ia.getGanhador().equals("Jogador") || ia.getGanhador().equals("Computador")){
            jlVencedorDaPartida.setText(ia.getGanhador());
            
            jbL1C1.setEnabled(false);
            jbL1C2.setEnabled(false);
            jbL1C3.setEnabled(false);
            jbL2C1.setEnabled(false);
            jbL2C2.setEnabled(false);
            jbL2C3.setEnabled(false);
            jbL3C1.setEnabled(false);
            jbL3C2.setEnabled(false);
            jbL3C3.setEnabled(false);
        }
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgJogadorInicial = new javax.swing.ButtonGroup();
        bgAlgoritmo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jrbUsuario = new javax.swing.JRadioButton();
        jrbComputador = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jrbMinimax = new javax.swing.JRadioButton();
        jrbPodaAlphaBetha = new javax.swing.JRadioButton();
        jlVencedorDaPartida = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlTempoDeJogadaPC = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlNosAbertos = new javax.swing.JLabel();
        jlTotNosAbertos = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jbL1C1 = new javax.swing.JButton();
        jbL1C2 = new javax.swing.JButton();
        jbL1C3 = new javax.swing.JButton();
        jbL2C1 = new javax.swing.JButton();
        jbL2C3 = new javax.swing.JButton();
        jbL3C1 = new javax.swing.JButton();
        jbL3C2 = new javax.swing.JButton();
        jbL2C2 = new javax.swing.JButton();
        jbL3C3 = new javax.swing.JButton();
        jbIniciarPartida = new javax.swing.JButton();
        jbReiniciarPartida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Jogador Incial: ");

        bgJogadorInicial.add(jrbUsuario);
        jrbUsuario.setSelected(true);
        jrbUsuario.setText("Usuário");

        bgJogadorInicial.add(jrbComputador);
        jrbComputador.setText("Computador");

        jLabel3.setText("Algoritmo:");

        bgAlgoritmo.add(jrbMinimax);
        jrbMinimax.setSelected(true);
        jrbMinimax.setText("Minimax");

        bgAlgoritmo.add(jrbPodaAlphaBetha);
        jrbPodaAlphaBetha.setText("Poda Alpha-Betha");
        jrbPodaAlphaBetha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbPodaAlphaBethaActionPerformed(evt);
            }
        });

        jlVencedorDaPartida.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlVencedorDaPartida.setForeground(new java.awt.Color(204, 0, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Dados da Partida:");

        jLabel5.setText("Tempo de Jogada: ");

        jlTempoDeJogadaPC.setText("0.000");

        jLabel6.setText("Nós abertos:");

        jLabel7.setText("Total de nós abertos:");

        jlNosAbertos.setText("0");

        jlTotNosAbertos.setText("0");

        jLabel10.setText("Ações");

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("JOGO DA VELHA ");

        jbL1C1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbL1C1.setForeground(new java.awt.Color(204, 0, 102));
        jbL1C1.setEnabled(false);
        jbL1C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbL1C1ActionPerformed(evt);
            }
        });

        jbL1C2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbL1C2.setForeground(new java.awt.Color(204, 0, 102));
        jbL1C2.setEnabled(false);
        jbL1C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbL1C2ActionPerformed(evt);
            }
        });

        jbL1C3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbL1C3.setForeground(new java.awt.Color(204, 0, 102));
        jbL1C3.setEnabled(false);
        jbL1C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbL1C3ActionPerformed(evt);
            }
        });

        jbL2C1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbL2C1.setForeground(new java.awt.Color(204, 0, 102));
        jbL2C1.setEnabled(false);
        jbL2C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbL2C1ActionPerformed(evt);
            }
        });

        jbL2C3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbL2C3.setForeground(new java.awt.Color(204, 0, 102));
        jbL2C3.setEnabled(false);
        jbL2C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbL2C3ActionPerformed(evt);
            }
        });

        jbL3C1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbL3C1.setForeground(new java.awt.Color(204, 0, 102));
        jbL3C1.setEnabled(false);
        jbL3C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbL3C1ActionPerformed(evt);
            }
        });

        jbL3C2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbL3C2.setForeground(new java.awt.Color(204, 0, 102));
        jbL3C2.setEnabled(false);
        jbL3C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbL3C2ActionPerformed(evt);
            }
        });

        jbL2C2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbL2C2.setForeground(new java.awt.Color(204, 0, 102));
        jbL2C2.setEnabled(false);
        jbL2C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbL2C2ActionPerformed(evt);
            }
        });

        jbL3C3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbL3C3.setForeground(new java.awt.Color(204, 0, 102));
        jbL3C3.setEnabled(false);
        jbL3C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbL3C3ActionPerformed(evt);
            }
        });

        jbIniciarPartida.setText("Iniciar Partida");
        jbIniciarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIniciarPartidaActionPerformed(evt);
            }
        });

        jbReiniciarPartida.setText("Reiniciar Partida");
        jbReiniciarPartida.setEnabled(false);
        jbReiniciarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbReiniciarPartidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jrbUsuario)
                    .addComponent(jLabel2)
                    .addComponent(jrbComputador)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jrbMinimax)
                            .addComponent(jrbPodaAlphaBetha)))
                    .addComponent(jLabel10)
                    .addComponent(jbIniciarPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbReiniciarPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbL1C1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbL1C2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbL1C3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jbL3C1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbL3C2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbL3C3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jbL2C1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbL2C2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbL2C3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlTempoDeJogadaPC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlTotNosAbertos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlNosAbertos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlVencedorDaPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(273, 273, 273))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jbL1C3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbL1C2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbL1C1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jbL2C1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbL2C2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbL2C3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jlTempoDeJogadaPC)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlNosAbertos))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(jlTotNosAbertos))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbL3C2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbL3C3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbL3C1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlVencedorDaPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbMinimax)
                            .addComponent(jrbUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbComputador)
                            .addComponent(jrbPodaAlphaBetha))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jbIniciarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbReiniciarPartida)
                        .addGap(40, 40, 40))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(726, 398));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbL1C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbL1C1ActionPerformed
        //Marihelly Santini em: 15/11/2014
        jbL1C1.setText("X");
        jbL1C1.setEnabled(false);
        fazerJogada(0);
        verificarEmpate();
        
    }//GEN-LAST:event_jbL1C1ActionPerformed

    private void jbL1C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbL1C2ActionPerformed
        //Marihelly Santini em: 15/11/2014
        jbL1C2.setText("X");
        jbL1C2.setEnabled(false);
        fazerJogada(1);
        verificarEmpate();
    }//GEN-LAST:event_jbL1C2ActionPerformed

    private void jbL1C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbL1C3ActionPerformed
        //Marihelly Santini em: 15/11/2014
        jbL1C3.setText("X");
        jbL1C3.setEnabled(false);
        fazerJogada(2);
        verificarEmpate();
    }//GEN-LAST:event_jbL1C3ActionPerformed

    private void jbL2C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbL2C1ActionPerformed
        jbL2C1.setText("X");
        jbL2C1.setEnabled(false);
        fazerJogada(3);
        verificarEmpate();
    }//GEN-LAST:event_jbL2C1ActionPerformed

    private void jbL2C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbL2C2ActionPerformed
        jbL2C2.setText("X");
        jbL2C2.setEnabled(false);
        fazerJogada(4);
        verificarEmpate();
    }//GEN-LAST:event_jbL2C2ActionPerformed

    private void jbL2C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbL2C3ActionPerformed
        //Marihelly Santini em: 15/11/2014
        jbL2C3.setText("X");
        jbL2C3.setEnabled(false);
        fazerJogada(5);
        verificarEmpate();
    }//GEN-LAST:event_jbL2C3ActionPerformed

    private void jbL3C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbL3C1ActionPerformed
        //Marihelly Santini em: 15/11/2014
        jbL3C1.setText("X");
        jbL3C1.setEnabled(false);
        fazerJogada(6);
        verificarEmpate();
    }//GEN-LAST:event_jbL3C1ActionPerformed

    private void jbL3C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbL3C2ActionPerformed
        //Marihelly Santini em: 15/11/2014
        jbL3C2.setText("X");
        jbL3C2.setEnabled(false);
        fazerJogada(7);
        verificarEmpate();
    }//GEN-LAST:event_jbL3C2ActionPerformed

    private void jbL3C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbL3C3ActionPerformed
        //Marihelly Santini em: 15/11/2014
        jbL3C3.setText("X");
        jbL3C3.setEnabled(false);
        fazerJogada(8);
        verificarEmpate();
    }//GEN-LAST:event_jbL3C3ActionPerformed

    private void jbIniciarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIniciarPartidaActionPerformed
        //Marihelly Santini em: 15/11/2014
        jrbComputador.setEnabled(false);
        jrbUsuario.setEnabled(false);
        jrbMinimax.setEnabled(false);
        jrbPodaAlphaBetha.setEnabled(false);

        jbIniciarPartida.setEnabled(false);
        jbReiniciarPartida.setEnabled(true);

        jbL1C1.setEnabled(true);
        jbL1C2.setEnabled(true);
        jbL1C3.setEnabled(true);
        jbL2C1.setEnabled(true);
        jbL2C2.setEnabled(true);
        jbL2C3.setEnabled(true);
        jbL3C1.setEnabled(true);
        jbL3C2.setEnabled(true);
        jbL3C3.setEnabled(true);
        
        //Francis Hilla em: 21/11/2014
        jlTempoDeJogadaPC.setText("0,00");
        jlNosAbertos.setText("0");
        jlTotNosAbertos.setText("0");
        
        //Verficação se selecionou setPoda
        if(jrbPodaAlphaBetha.isSelected()){
            ia.setPoda(true);            
        }else{
            ia.setPoda(false);
        }
        
        if(jrbComputador.isSelected()){
            ia.setPrimeiroJogar(true);
            tabujogada = ia.efetuarJogada(tabujogada);
            jogaPc();
        } else {
            ia.setPrimeiroJogar(false);
        }

    }//GEN-LAST:event_jbIniciarPartidaActionPerformed

    private void jbReiniciarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReiniciarPartidaActionPerformed
        //Marihelly Santini em: 15/11/2014
        jrbComputador.setEnabled(true);
        jrbUsuario.setEnabled(true);
        jrbMinimax.setEnabled(true);
        jrbPodaAlphaBetha.setEnabled(true);

        jbIniciarPartida.setEnabled(true);
        jbReiniciarPartida.setEnabled(false);
        
        jlVencedorDaPartida.setText("");

        jbL1C1.setEnabled(false);
        jbL1C2.setEnabled(false);
        jbL1C3.setEnabled(false);
        jbL2C1.setEnabled(false);
        jbL2C2.setEnabled(false);
        jbL2C3.setEnabled(false);
        jbL3C1.setEnabled(false);
        jbL3C2.setEnabled(false);
        jbL3C3.setEnabled(false);
        
        jbL1C1.setText("");
        jbL1C2.setText("");
        jbL1C3.setText("");
        jbL2C1.setText("");
        jbL2C2.setText("");
        jbL2C3.setText("");
        jbL3C1.setText("");
        jbL3C2.setText("");
        jbL3C3.setText("");
        
        //Francis Hilla em: 21/11/2014
        for(int i = 0; i <tabujogada.length; i++){
            tabujogada[i] = ' ';
        }
        
        //Francis Hilla em: 21/11/2014
        jlTempoDeJogadaPC.setText("0,00");
        jlNosAbertos.setText("0");
        jlTotNosAbertos.setText("0");
        ia.setTotalNosAberto(0);
        tempo1 = tempo2 = result = 0;
        
    }//GEN-LAST:event_jbReiniciarPartidaActionPerformed

    private void jrbPodaAlphaBethaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbPodaAlphaBethaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbPodaAlphaBethaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }
    
    //Marihelly Santini em: 15/11/2014
    public void verificarEmpate() {
        if ((jbL1C1.getText().equals("X") || jbL1C1.getText().equals("O"))
                && (jbL1C2.getText().equals("X") || jbL1C2.getText().equals("O"))
                && (jbL1C3.getText().equals("X") || jbL1C3.getText().equals("O"))
                && (jbL2C1.getText().equals("X") || jbL2C1.getText().equals("O"))
                && (jbL2C2.getText().equals("X") || jbL2C2.getText().equals("O"))
                && (jbL2C3.getText().equals("X") || jbL2C3.getText().equals("O"))
                && (jbL3C1.getText().equals("X") || jbL3C1.getText().equals("O"))
                && (jbL3C2.getText().equals("X") || jbL3C2.getText().equals("O"))
                && (jbL3C3.getText().equals("X") || jbL3C3.getText().equals("O"))) {
            JOptionPane.showMessageDialog(rootPane, "Empate! \nPara iniciar uma nova partida clique em 'Reiniciar Partida'.");
            jlVencedorDaPartida.setText("Empate");          
            }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgAlgoritmo;
    private javax.swing.ButtonGroup bgJogadorInicial;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbIniciarPartida;
    private javax.swing.JButton jbL1C1;
    private javax.swing.JButton jbL1C2;
    private javax.swing.JButton jbL1C3;
    private javax.swing.JButton jbL2C1;
    private javax.swing.JButton jbL2C2;
    private javax.swing.JButton jbL2C3;
    private javax.swing.JButton jbL3C1;
    private javax.swing.JButton jbL3C2;
    private javax.swing.JButton jbL3C3;
    private javax.swing.JButton jbReiniciarPartida;
    private javax.swing.JLabel jlNosAbertos;
    private javax.swing.JLabel jlTempoDeJogadaPC;
    private javax.swing.JLabel jlTotNosAbertos;
    private javax.swing.JLabel jlVencedorDaPartida;
    private javax.swing.JRadioButton jrbComputador;
    private javax.swing.JRadioButton jrbMinimax;
    private javax.swing.JRadioButton jrbPodaAlphaBetha;
    private javax.swing.JRadioButton jrbUsuario;
    // End of variables declaration//GEN-END:variables
}
