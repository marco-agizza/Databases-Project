package Dialogs.mono;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class InfoLogPagamenti extends javax.swing.JDialog {
    Connection myconObj=null;
    int IDPartita;
    /**
     * Creates new form InfoLogPagamenti
     */
    public InfoLogPagamenti(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void setid(int m){
        IDPartita=m;
        selectionall();
    }
    public void selectionall(){
        DefaultTableModel model=(DefaultTableModel)TablePagamenti.getModel();
        model.setRowCount(0);
        TableColumnModel columnModel= TablePagamenti.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(200);
        columnModel.getColumn(4).setPreferredWidth(200);
        try{
            System.out.println("La partita selezionata è: "+IDPartita);
            myconObj=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "Utente","12345");
            Statement mystatObj = myconObj.createStatement();
            System.out.println("Faccio primo statement");
            ResultSet allpagamenti=mystatObj.executeQuery("SELECT LogPagamento.Pedina1 as Pedina1,LogPagamento.Pedina2 as Pedina2,LogPagamento.Turno as Turno,LogPagamento.PrezzoPagato as PrezzoPagato,Contratti.Nome as Nome,LogPagamento.Posizione as Posizione FROM LogPagamento, Contratti WHERE LogPagamento.Posizione=Contratti.Posizione and LogPagamento.IDPartita1=Contratti.IDPartita and Contratti.IDPartita="+IDPartita+" ORDER BY LogPagamento.Turno");
            System.out.println("Fatta prima query");
            System.out.println("Sto per entrare nel while");
            while(allpagamenti.next()){
                model.addRow(new Object[]{allpagamenti.getString("Pedina1"),allpagamenti.getString("Pedina2"),allpagamenti.getInt("Turno"),allpagamenti.getInt("PrezzoPagato"),allpagamenti.getString("Nome"),allpagamenti.getInt("Posizione")});
            } 
            System.out.println("Sono uscito dal while");
            myconObj.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablePagamenti = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LogPagamenti");
        setResizable(false);

        TablePagamenti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pagante", "Beneficiario", "Turno", "Prezzo pagato", "Contratto", "Posizione"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablePagamenti);
        if (TablePagamenti.getColumnModel().getColumnCount() > 0) {
            TablePagamenti.getColumnModel().getColumn(0).setResizable(false);
            TablePagamenti.getColumnModel().getColumn(1).setResizable(false);
            TablePagamenti.getColumnModel().getColumn(2).setResizable(false);
            TablePagamenti.getColumnModel().getColumn(3).setResizable(false);
            TablePagamenti.getColumnModel().getColumn(4).setResizable(false);
            TablePagamenti.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel1.setText("Pagamenti avvenuti in partita_");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(InfoLogPagamenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoLogPagamenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoLogPagamenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoLogPagamenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InfoLogPagamenti dialog = new InfoLogPagamenti(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablePagamenti;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}