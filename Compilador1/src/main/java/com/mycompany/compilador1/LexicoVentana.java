package com.mycompany.compilador1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.table.DefaultTableModel;

public class LexicoVentana extends javax.swing.JFrame {

    public LexicoVentana() {
        initComponents();

    }

    public void recurso(String txtATexto1) {
        HashMap<String, Integer> r = new HashMap<>();
        HashMap<String, Integer> op = new HashMap<>();
        HashMap<String, Integer> id = new HashMap<>();
        HashMap<String, Integer> deli = new HashMap<>();
        HashMap<String, Integer> num = new HashMap<>();
        LinkedList<String> texto = new LinkedList<>();

        r.put("BEGIN", 0);
        r.put("END", 0);
        r.put("WORD", 0);
        r.put("ALFA", 0);
        r.put("NUM", 0);
        r.put("DNUM", 0);
        r.put("BOOL", 0);
        r.put("LNUM", 0);
        r.put("TAKE", 0);
        r.put("SEND", 0);
        r.put("WHEN", 0);
        r.put("IT", 0);
        r.put("IS", 0);
        r.put("START", 0);
        r.put("STEP", 0);
        r.put("TO", 0);
        r.put("STOP", 0);
        r.put("SWHEN", 0);
        r.put("COMPLETE", 0);

        op.put("/", 0);
        op.put("*", 0);
        op.put("+", 0);
        op.put("-", 0);
        op.put("=", 0);
        op.put("^", 0);
        op.put("<", 0);
        op.put(">", 0);
        op.put("||", 0);
        op.put("&&", 0);

        deli.put("#", 0);
        deli.put(";", 0);
        deli.put("{", 0);
        deli.put("}", 0);
        deli.put(")", 0);
        deli.put(",", 0);
        deli.put("(", 0);

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Token", "Cantidad", "Tipo"});

        StringTokenizer st = new StringTokenizer(txtATexto1, "{}();,\"=+-*/><||&&# \n\t", true);
        String token, text = "";
        while (st.hasMoreTokens()) {
            token = st.nextToken();
            if (!" ".equals(token) && !"\n".equals(token) && !"\t".equals(token)) {
                if (r.containsKey(token)) {
                    r.put(token, r.get(token) + 1);
                } else {
                    if (op.containsKey(token)) {
                        op.put(token, op.get(token) + 1);
                    } else {
                        if (deli.containsKey(token)) {
                            deli.put(token, deli.get(token) + 1);
                            if ("#".equals(token)) {
                                token = st.nextToken();
                                while (st.hasMoreTokens() && !"#".equals(token)) {
                                    text += token;
                                    token = st.nextToken();
                                }
                                texto.add(text);
                                deli.put(token, deli.get(token) + 1);
                                text = "";
                            }
                        } else {
                            if (id.containsKey(token)) {
                                id.put(token, id.get(token) + 1);
                            } else {
                                if (token.matches("([0-9]*)|([0-9]*.[0-9]+)")) {
                                    if (num.containsKey(token)) {
                                        num.put(token, num.get(token) + 1);
                                    } else {
                                        num.put(token, 1);
                                    }
                                } else {
                                    id.put(token, 1);
                                }
                            }
                        }
                    }
                }
            }
        }

        Iterator<String> itr = r.keySet().iterator();
        while (itr.hasNext()) {
            token = itr.next();
            if (r.get(token) > 0) {
                model.addRow(new Object[]{token, r.get(token), "Palabra Reservada"});
            }
        }
        itr = op.keySet().iterator();
        while (itr.hasNext()) {
            token = itr.next();
            if (op.get(token) > 0) {
                model.addRow(new Object[]{token, op.get(token), "Operador"});
            }
        }
        itr = deli.keySet().iterator();
        while (itr.hasNext()) {
            token = itr.next();
            if (deli.get(token) > 0) {
                model.addRow(new Object[]{token, deli.get(token), "Delimitador"});
            }
        }
        itr = id.keySet().iterator();
        while (itr.hasNext()) {
            token = itr.next();
            if (id.get(token) > 0) {
                model.addRow(new Object[]{token, id.get(token), "Identificador"});
            }
        }
        itr = num.keySet().iterator();
        while (itr.hasNext()) {
            token = itr.next();
            if (num.get(token) > 0) {
                if (token.matches("[0-9]+")) {
                    model.addRow(new Object[]{token, num.get(token), "Número"});
                }
                if (token.matches("[0-9]+.[0-9]+")) {
                    model.addRow(new Object[]{token, num.get(token), "Número Decimal"});
                }
            }
        }
        itr = texto.iterator();
        while (itr.hasNext()) {
            model.addRow(new Object[]{itr.next(), "1", "Texto"});

        }
        jTable1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

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
            java.util.logging.Logger.getLogger(LexicoVentana.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LexicoVentana.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LexicoVentana.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LexicoVentana.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LexicoVentana().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}
