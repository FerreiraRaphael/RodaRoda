/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Configuracoes.Configuracao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author raphael
 */
public class ViewInicial extends javax.swing.JFrame {

    private ViewRodaRoda vwRodaRoda;
    private final ViewConfiguracoes vwConf;
    /** Construtor que irá instanciar o ViewInicial.
     * Creates new form ViewFrame
     */
    public ViewInicial() {
        initComponents();
        //vwRodaRoda = new ViewRodaRoda(this);
        vwConf = new ViewConfiguracoes(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnHeader = new javax.swing.JPanel();
        lbHeader = new javax.swing.JLabel();
        pnBotoes = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnIniciar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnConfiguracoes = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 450));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        pnHeader.setBorder(new javax.swing.border.MatteBorder(null));
        pnHeader.setPreferredSize(new java.awt.Dimension(250, 150));
        pnHeader.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 50));

        lbHeader.setFont(new java.awt.Font("Dialog", 3, 48)); // NOI18N
        lbHeader.setText("Roda a Roda");
        lbHeader.setAlignmentX(0.5F);
        pnHeader.add(lbHeader);

        jPanel1.add(pnHeader);

        pnBotoes.setBorder(new javax.swing.border.MatteBorder(null));
        pnBotoes.setLayout(new java.awt.GridLayout(3, 1));

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        btnIniciar.setText("Iniciar");
        btnIniciar.setAlignmentX(0.5F);
        btnIniciar.setMaximumSize(new java.awt.Dimension(150, 50));
        btnIniciar.setMinimumSize(new java.awt.Dimension(150, 50));
        btnIniciar.setPreferredSize(new java.awt.Dimension(150, 50));
        btnIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIniciarMouseClicked(evt);
            }
        });
        jPanel2.add(btnIniciar);

        pnBotoes.add(jPanel2);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        btnConfiguracoes.setText("Configurações");
        btnConfiguracoes.setAlignmentX(0.5F);
        btnConfiguracoes.setMaximumSize(new java.awt.Dimension(150, 50));
        btnConfiguracoes.setMinimumSize(new java.awt.Dimension(150, 50));
        btnConfiguracoes.setPreferredSize(new java.awt.Dimension(150, 50));
        btnConfiguracoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfiguracoesMouseClicked(evt);
            }
        });
        jPanel3.add(btnConfiguracoes);

        pnBotoes.add(jPanel3);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        btnSair.setText("Sair");
        btnSair.setAlignmentX(0.5F);
        btnSair.setMaximumSize(new java.awt.Dimension(150, 50));
        btnSair.setMinimumSize(new java.awt.Dimension(150, 50));
        btnSair.setPreferredSize(new java.awt.Dimension(150, 50));
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSairMouseClicked(evt);
            }
        });
        jPanel4.add(btnSair);

        pnBotoes.add(jPanel4);

        jPanel1.add(pnBotoes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarMouseClicked
        Configuracao configuracoes = Configuracao.getInstance();
        if(configuracoes.getNumeroJogadores() != 0 && configuracoes.getNumeroEtapas() != 0 && configuracoes.getNumeroPalavras() != 0){
            try {
                vwRodaRoda = new ViewRodaRoda(this);
            } catch (IOException ex) {
                Logger.getLogger(ViewInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
            trocarJanela(vwRodaRoda);
        }
        else{
            JOptionPane.showMessageDialog(this, "Você deve escolher as configurações do jogo primeiro");
            trocarJanela(vwConf);
        }
    }//GEN-LAST:event_btnIniciarMouseClicked

    private void btnConfiguracoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfiguracoesMouseClicked
        trocarJanela(vwConf);
    }//GEN-LAST:event_btnConfiguracoesMouseClicked

    private void btnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnSairMouseClicked
    /** Este método irá trocar a Janela atual por outra janela estabelecida pelo parâmetro.
     * 
     * @param janela JFrame - Janela que irá substituir a anterior.
     */
    private void trocarJanela(JFrame janela){
        this.setVisible(false);
        janela.setSize(this.getSize());
        janela.setLocationRelativeTo(this);
        janela.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfiguracoes;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbHeader;
    private javax.swing.JPanel pnBotoes;
    private javax.swing.JPanel pnHeader;
    // End of variables declaration//GEN-END:variables
}
