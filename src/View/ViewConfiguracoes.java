/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Configuracoes.Configuracao;
import Configuracoes.ControllerConfiguracao;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author raphael
 */
public final class ViewConfiguracoes extends javax.swing.JFrame {
    
    ViewInicial vwInicial;
    ControllerConfiguracao controllerConfiguracao;
    Configuracao configuracoes;
    /** Construtor que instanciará o ViewConfiguracoes.
     * 
     * @param vwInicial ViewInicial - View que será usado pelo arquivo.
     */
    public ViewConfiguracoes(ViewInicial vwInicial) {
        this.vwInicial = vwInicial;
        initComponents();
        controllerConfiguracao = new ControllerConfiguracao();
        setCombosBoxes();
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
        pnCentral = new javax.swing.JPanel();
        pnNumeroJogadores = new javax.swing.JPanel();
        lbNumeroJogadores = new javax.swing.JLabel();
        cbNumeroJogadores = new javax.swing.JComboBox<String>();
        pnNumeroEtapas = new javax.swing.JPanel();
        lbNumeroEtapas = new javax.swing.JLabel();
        cbNumeroEtapas = new javax.swing.JComboBox<String>();
        pnNumeroPalavras = new javax.swing.JPanel();
        lbNumeroPalavras = new javax.swing.JLabel();
        cbNumeroPalavras = new javax.swing.JComboBox<String>();
        pnDiferentesCategorias = new javax.swing.JPanel();
        chbDiferentesCategorias = new javax.swing.JCheckBox();
        pnBotoes = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setPreferredSize(new java.awt.Dimension(450, 450));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        pnHeader.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 25, 50));

        lbHeader.setFont(new java.awt.Font("Dialog", 3, 48)); // NOI18N
        lbHeader.setText("Configurações");
        lbHeader.setAlignmentX(0.5F);
        pnHeader.add(lbHeader);

        jPanel1.add(pnHeader);

        pnCentral.setLayout(new java.awt.GridLayout(4, 1));

        lbNumeroJogadores.setText("Número de Jogadores");
        pnNumeroJogadores.add(lbNumeroJogadores);

        cbNumeroJogadores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione Número Jogador" }));
        pnNumeroJogadores.add(cbNumeroJogadores);

        pnCentral.add(pnNumeroJogadores);

        lbNumeroEtapas.setText("Número de Etapas");
        pnNumeroEtapas.add(lbNumeroEtapas);

        cbNumeroEtapas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione Número Etapas" }));
        pnNumeroEtapas.add(cbNumeroEtapas);

        pnCentral.add(pnNumeroEtapas);

        lbNumeroPalavras.setText("Número de Palavras");
        pnNumeroPalavras.add(lbNumeroPalavras);

        cbNumeroPalavras.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione Número Palavras" }));
        pnNumeroPalavras.add(cbNumeroPalavras);

        pnCentral.add(pnNumeroPalavras);

        chbDiferentesCategorias.setSelected(true);
        chbDiferentesCategorias.setText("Diferentes Categorias");
        pnDiferentesCategorias.add(chbDiferentesCategorias);

        pnCentral.add(pnDiferentesCategorias);

        jPanel1.add(pnCentral);

        btnSalvar.setText("Salvar");
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarMouseClicked(evt);
            }
        });
        pnBotoes.add(btnSalvar);

        btnFechar.setText("Fechar");
        btnFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFecharMouseClicked(evt);
            }
        });
        pnBotoes.add(btnFechar);

        jPanel1.add(pnBotoes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseClicked
        
        if(!verificarDados()){
            JOptionPane.showMessageDialog(new JOptionPane(), "Preencha os campos obrigatorios");
        }
        else{
            salvarConfiguracoes();
            trocarJanela(vwInicial);
        }
    }//GEN-LAST:event_btnSalvarMouseClicked

    private void btnFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseClicked
        trocarJanela(vwInicial);
    }//GEN-LAST:event_btnFecharMouseClicked
    /** Verifica os Dados informados pelo Etapas, Palavras e jogadores na Interface Gráfica. Caso ainda esteja escrito "Selecione" Ele retorna falso. Caso contrário true.
     * 
     * @return boolean - true caso nenhum seja "Selecione" e false caso seja.
     */
    private boolean verificarDados() {
        if (cbNumeroEtapas.getSelectedItem().toString().contains("Selecione")) 
            return false;
        if (cbNumeroPalavras.getSelectedItem().toString().contains("Selecione")) 
            return false;
        if (cbNumeroJogadores.getSelectedItem().toString().contains("Selecione")) 
            return false;
        return true;
    }
    /** Este método irá salvar as configurações colocados pelo jogador.
     * 
     */
    private void salvarConfiguracoes(){
        controllerConfiguracao.setNumeroEtapas(cbNumeroEtapas.getSelectedIndex());
        controllerConfiguracao.setNumeroJogadores(cbNumeroJogadores.getSelectedIndex());
        controllerConfiguracao.setNumeroPalavras(cbNumeroPalavras.getSelectedIndex());
        controllerConfiguracao.setDiferentesCategorias(chbDiferentesCategorias.isSelected());
    }
    /** Este médoto irá modificar os ComboBoxes do NúmeroJogadores,NumeroEtapas,NumeroPalavras.
     * 
     */
    private void setCombosBoxes() {
        for (Integer i = 1; i <= controllerConfiguracao.getLimiteNumeroJogadores(); i++) {
            cbNumeroJogadores.addItem(i.toString());
        }
        for (Integer i = 1; i <=  controllerConfiguracao.getLimiteNumeroEtapas() ; i++) {
            cbNumeroEtapas.addItem(i.toString());
        }
        for (Integer i = 1; i <= (int) controllerConfiguracao.getLimiteNumeroPalavras(); i++) {
            cbNumeroPalavras.addItem(i.toString());
        }
        /*
        if((Integer)controllerConfiguracao.get("numeroEtapas") != 0)
            cbNumeroEtapas.setSelectedItem(configuracoes.);
        if((Integer)controllerConfiguracao.get("numeroPalavras") != 0)
            cbNumeroPalavras.setSelectedItem(controllerConfiguracao.get("numeroPalavras"));
        if((Integer)controllerConfiguracao.get("numeroJogadores") != 0)
            cbNumeroJogadores.setSelectedItem(controllerConfiguracao.get("numeroJogadores"));
            */
    }
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
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbNumeroEtapas;
    private javax.swing.JComboBox<String> cbNumeroJogadores;
    private javax.swing.JComboBox<String> cbNumeroPalavras;
    private javax.swing.JCheckBox chbDiferentesCategorias;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbHeader;
    private javax.swing.JLabel lbNumeroEtapas;
    private javax.swing.JLabel lbNumeroJogadores;
    private javax.swing.JLabel lbNumeroPalavras;
    private javax.swing.JPanel pnBotoes;
    private javax.swing.JPanel pnCentral;
    private javax.swing.JPanel pnDiferentesCategorias;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnNumeroEtapas;
    private javax.swing.JPanel pnNumeroJogadores;
    private javax.swing.JPanel pnNumeroPalavras;
    // End of variables declaration//GEN-END:variables
}
