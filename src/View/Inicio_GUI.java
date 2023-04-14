/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.io.FileOutputStream;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fabio
 */
public class Inicio_GUI extends javax.swing.JFrame {

 static int cod;
 static String nom;
 static String end;
 static String em;
 static long tel;

    private static String getText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
  String url = "jdbc:mysql://localhost/aprender"; // endereço do BD
  String username = "root";        //nome de um usuário de seu BD
  String password = "";  // senha do BD
  //-----> Inicio
  
  public static DefaultTableModel  cliente(ResultSet rs) {
        try {
           ResultSetMetaData metaData = rs.getMetaData();
         int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();
       // AS LINHAS ABAIXO SÃO REFERENTES AOS CAMPOS DA TABELA CLIENTE
            columnNames.addElement("Código");
            columnNames.addElement("Nome");
            columnNames.addElement("Endereço");
            columnNames.addElement("E-mail");
            columnNames.addElement("Telefone");
         
            Vector rows = new Vector();
            while (rs.next()) {
                Vector newRow = new Vector();
                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }
                rows.addElement(newRow);
            }
           return new DefaultTableModel(rows, columnNames);
       } catch (Exception e) {

           return null;
        }
        }
    public void refresh(){
    
try{
   Connection conn;
          conn = (Connection) DriverManager.getConnection(url, username, password);
    Controller.Conexao_DB.conectaDriver();
     
    
    System.out.println("realizado");
            String sql = "SELECT * FROM cliente;";
PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
ResultSet rs = pst.executeQuery();
tabela.setModel(cliente(rs));
}
catch(Exception e){
JOptionPane.showMessageDialog(null, e);
}    
    } 

//POR  FIM ESTANCIE  OU DENTRO DE UM BOTÃO ATUALIZAR  OU DEPOIS DA INSERÇÃO DOS DADOS A FUNÇÃO   REFRESH :

private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {                                          
                 refresh();
    }  



  
  
  //-------> Termino

    public Inicio_GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("aprender?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        clienteQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Cliente c");
        clienteList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : clienteQuery.getResultList();
        clienteQuery1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Cliente c");
        clienteList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : clienteQuery1.getResultList();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nome1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        end1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        email1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tel1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cadastrar = new javax.swing.JButton();
        fechar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cod2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nome2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        end2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        email2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tel2 = new javax.swing.JTextField();
        consulta = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        relatorio = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(null);

        jLabel1.setText("NOME : ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 60, 100, 30);
        jPanel1.add(nome1);
        nome1.setBounds(100, 60, 240, 30);

        jLabel2.setText("ENDEREÇO : ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 120, 90, 20);
        jPanel1.add(end1);
        end1.setBounds(100, 110, 240, 30);

        jLabel3.setText("EMAIL :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 170, 70, 20);
        jPanel1.add(email1);
        email1.setBounds(100, 160, 240, 30);

        jLabel4.setText("TELEFONE : ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 220, 90, 20);
        jPanel1.add(tel1);
        tel1.setBounds(100, 210, 240, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("AGENDA");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(180, 10, 80, 30);

        cadastrar.setText("CADASTRAR");
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(cadastrar);
        cadastrar.setBounds(360, 20, 110, 30);

        fechar.setText("X");
        fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharActionPerformed(evt);
            }
        });
        jPanel1.add(fechar);
        fechar.setBounds(409, 250, 50, 40);

        jTabbedPane1.addTab("Cadastrar", jPanel1);

        jPanel2.setLayout(null);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, clienteList1, tabela);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${clientePK}"));
        columnBinding.setColumnName("Código / Nome");
        columnBinding.setColumnClass(View.ClientePK.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cliEnd}"));
        columnBinding.setColumnName("Endereço");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cliEmail}"));
        columnBinding.setColumnName("Email");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cliTel}"));
        columnBinding.setColumnName("Telefone");
        columnBinding.setColumnClass(java.math.BigInteger.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tabela);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 11, 495, 92);

        jLabel6.setText("Código :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 110, 80, 30);

        cod2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cod2ActionPerformed(evt);
            }
        });
        jPanel2.add(cod2);
        cod2.setBounds(60, 110, 100, 30);

        jLabel7.setText("Nome :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 150, 70, 30);
        jPanel2.add(nome2);
        nome2.setBounds(60, 150, 240, 30);

        jLabel8.setText("Endereço :");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 200, 80, 30);
        jPanel2.add(end2);
        end2.setBounds(70, 190, 220, 40);

        jLabel9.setText("Email :");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(20, 250, 50, 30);
        jPanel2.add(email2);
        email2.setBounds(70, 250, 230, 30);

        jLabel10.setText("Telefone :");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 300, 70, 20);
        jPanel2.add(tel2);
        tel2.setBounds(80, 290, 190, 30);

        consulta.setText("CONSULTA");
        consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaActionPerformed(evt);
            }
        });
        jPanel2.add(consulta);
        consulta.setBounds(380, 113, 110, 40);

        alterar.setText("ALTERAR");
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });
        jPanel2.add(alterar);
        alterar.setBounds(380, 170, 110, 40);

        relatorio.setText("RELATORIO");
        relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorioActionPerformed(evt);
            }
        });
        jPanel2.add(relatorio);
        relatorio.setBounds(380, 290, 110, 40);

        excluir.setText("EXCLUIR");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });
        jPanel2.add(excluir);
        excluir.setBounds(380, 230, 110, 40);

        jTabbedPane1.addTab("Consultar / Alterar", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Excluir", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        bindingGroup.bind();

        setSize(new java.awt.Dimension(500, 388));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharActionPerformed
        System.exit(0);
    }//GEN-LAST:event_fecharActionPerformed

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        //---> inicio
        
        nom = nome1.getText(); // recebendo o nome
end = end1.getText(); // recebendo o email      
em = email1.getText(); // recebendo o email
  tel = Long.valueOf(tel1.getText());// recebendo o telefone

Controller.Conexao_DB.conectaDriver();       
      try { 
               
                   
               
            Connection con = null;
            
            
    try {
    con = (Connection) DriverManager.getConnection(url, username, password);
    } catch (SQLException ex) {
    Logger.getLogger(Inicio_GUI.class.getName()).log(Level.SEVERE, null, ex);

            
                   }

            // Recebendo os dados a serem inseridos na tabela
            String sql = "INSERT INTO cliente (cli_nome,cli_end,cli_email,cli_tel) values('"+nom+"', '"+end+"'  , '"+em+"','"+tel+"')";
     
            try { // Tratamento de Erros para inserção

                // Criando varialvel que executara a inserção
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); // Executando a inserção

  JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);
                nome1.setText("");
                end1.setText("");
                email1.setText("");
                tel1.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Tratamento de erro caso o usuario não digite o telefone corretamente
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente","ERRO",0);
            tel1.setText("");
        }       
        
        //---> Termino
        refresh();
    }//GEN-LAST:event_cadastrarActionPerformed

    private void cod2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cod2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cod2ActionPerformed

    private void consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaActionPerformed
       //---> inicio
        try{     //Iniciando o possivel tratamento de erros
            //Declarando a variavel código
            int codigo = Integer.valueOf(cod2.getText());
            Controller.Conexao_DB.conectaDriver(); // Carregando o driver
            try {// Tratamento de erro para a conexao
                // Declarando  a variavel de conexão con
                // e estabelendo a conexão
                Connection con = null;

                try {
                    con = (Connection) DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    Logger.getLogger(Inicio_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Declarando uma string com o comando mySQL para consulta
                String sql = "SELECT cli_nome, cli_end, cli_email, cli_tel FROM cliente where cli_cod = "+codigo;
                // Criando variavel que executara o comando da string sql
                Statement stm = (Statement) con.createStatement();
                try//Tratamento de erro da consulta
                { //Criando variavel que exibira os resultados
                    //Executando o comando da string sql na variavel rs

                    ResultSet rs = stm.executeQuery(sql);

                    int i=0; // Variavel utilizada para saber se ha dados cadastrados

                    while (rs.next()) {  // Criando variaveis que receberão os valores do banco de dados
                        String nome = rs.getString("cli_nome");
			String endereco = rs.getString("cli_end");
                        String email = rs.getString("cli_email");
                        String telefone = rs.getString("cli_tel");

                        i++;

                        //JOptionPane.showMessageDialog(null,"Nome: " + nome + "\nEmail: " +telefone + "\nTelefone: " +telefone, "Resultado",-1);
                        nome2.setText(String.valueOf(nome));
			end2.setText(String.valueOf(endereco));
                        email2.setText(String.valueOf(email));
                        tel2.setText(String.valueOf(telefone));

                    }

                    if(i==0){ // Verificando se ha dados cadastrados atraves da variavel i

                        JOptionPane.showMessageDialog(null,"Dado não cadastrado","Resultado",-1);

                    }

                } catch (Exception ex) { // Consulta mal sucedida
                    JOptionPane.showMessageDialog(null,"\nErro ao consultar!","ERRO",0);
                }

            } catch (SQLException ex) {
                // Conexão com servidor mal sucedida
                JOptionPane.showMessageDialog(null,"Erro ao conectar com o servidor","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Código fora do formato
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            cod2.setText("");
        }

       
       
       
       
        //---> Termino
    }//GEN-LAST:event_consultaActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
        //---> Inicio
        
        nom = nome2.getText(); // recebendo o nome
        String ende = end2.getText(); //recebendo o endereco
       em = email2.getText(); // recebendo o email         
      tel = Long.valueOf(tel2.getText());// recebendo o telefone

       Controller.Conexao_DB.conectaDriver();
       
      try {     
            Connection con = null;
      try {
            con = (Connection) DriverManager.getConnection(url, username, password);
      }catch (SQLException ex) {
            Logger.getLogger(Inicio_GUI.class.getName()).log(Level.SEVERE, null, ex);
      }
            String sql = "UPDATE cliente SET Cli_nome='"+nom+"',Cli_email='"+em+"',Cli_end='"+ende+"',Cli_tel='"+tel+"' WHERE Cli_Cod="+cod2.getText();
            
     
            try { 
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); // Executando a inserção

                JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);
                nome2.setText("");
                end2.setText("");
                email2.setText("");
                tel2.setText("");
                cod2.setText("");
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Tratamento de erro caso o usuario não digite o telefone corretamente
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente","ERRO",0);
            tel2.setText("");
        }  
               
         //---> Termino
         refresh();
    }//GEN-LAST:event_alterarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        //---> Inicio

        Controller.Conexao_DB.conectaDriver(); // Carregando o driver

        // int codigo = Integer.valueOf(cod2tela0.getText()); // Recebendo o código

        try {// Tratamento de erro para a conexao
            // Declarando  a variavel de conexão con
            // e estabelendo a conexão
            Connection con = null;

            try {
                con = (Connection) DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                Logger.getLogger(Inicio_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Criando String com comando SQL para exclusão
            String sql = "DELETE FROM cliente WHERE cli_cod = "+cod2.getText();;

            try // Tratamento de erros para exclusão
            {// Criando Variavel para executar a ação
                PreparedStatement excluir = (PreparedStatement) con.prepareStatement(sql);
                excluir.execute();// Executando a exclusão

                JOptionPane.showMessageDialog(null,"\nExclusão realizada com sucesso!!!\n","",-1);
                cod2.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na exclusão!","ERRO!",0);
            }

        } catch(NumberFormatException erro){ // Codigo digitado com caracteres não numericos
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            cod2.setText("");

        }

        //---> Termino
        refresh();
    }//GEN-LAST:event_excluirActionPerformed

    private void relatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorioActionPerformed
            
        //-----> Inico
        DB banco = new DB("org.gjt.mm.mysql.Driver","jdbc:mysql://localhhost3306/dbjava","root","");
        ResultSet rr =banco.retDados();
        Document doc = new Document();   
        
        try{
            pdfWriter.getInstance(doc, new FileOutputStream("novo4.pdf"));
            doc.open();
            Font f = new Font(Font.HELVETICA, 20, Font.BOLDITALIC, new Color (0,0,255));
        }
        
        
        
        
        
        //------>Termino
    }//GEN-LAST:event_relatorioActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Inicio_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterar;
    private javax.swing.JButton cadastrar;
    private java.util.List<View.Cliente> clienteList;
    private java.util.List<View.Cliente> clienteList1;
    private javax.persistence.Query clienteQuery;
    private javax.persistence.Query clienteQuery1;
    private javax.swing.JTextField cod2;
    private javax.swing.JButton consulta;
    private javax.swing.JTextField email1;
    private javax.swing.JTextField email2;
    private javax.swing.JTextField end1;
    private javax.swing.JTextField end2;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton excluir;
    private javax.swing.JButton fechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nome1;
    private javax.swing.JTextField nome2;
    private javax.swing.JButton relatorio;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField tel1;
    private javax.swing.JTextField tel2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}