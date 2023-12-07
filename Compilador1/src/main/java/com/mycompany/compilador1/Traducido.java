package com.mycompany.compilador1;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class Traducido extends javax.swing.JFrame {

    public Traducido() {
        initComponents();
    }

    public void ventanita(String txtATexto1) {

        txtATraducido.setText("");
        String simbolo = "([=<>])",
                id = "([(a-z)(A-Z)](\\w)*)",
                num = "((\\d)+)",
                dec = "((\\d)+(\\.)(\\d)+)",
                text = "((((#)[.\\W\\w\\s]*(#))|(" + id + "))((\\s)*(\\+)((\\s)*((#)[.\\W\\w\\s]*(#))|(" + id + ")))*)",
                send = "((\\s)*SEND(\\s)*(\\()(\\s)*((((#)[.\\W\\w\\s]*(#))|(" + id + "))((\\s)*(\\+)((\\s)*((#)[.\\W\\w\\s]*(#))|(" + id + ")))*)(\\s)*(\\))(\\s)*(;))",
                //take = "((\\s)*TAKE(\\b)(\\s)*"+id+"((\\s)*(,(\\s)*"+id+"))*(\\s)*(;))",
                take = "((\\s)*TAKE(\\s)*(\\()(\\s)*((((#)[.\\W\\w\\s]*(#))|(" + id + "))((\\s)*(\\+)((\\s)*((#)[.\\W\\w\\s]*(#))|(" + id + ")))*)(\\s)*(\\))(\\s)*(;))",
                operaciones = "((" + id + "|" + num + "|" + dec + ")(\\s)*([+-/*](\\s)*(" + id + "|" + num + "|" + dec + "))+)",
                defVal = "((\\s)*" + id + "(\\s)*=(\\s)*(" + id + "|" + text + "|" + operaciones + "|" + num + "|" + dec + ")(\\s)*(;))",
                defValVar = "((\\s)*" + id + "(\\s)*=(\\s)*(" + id + "|" + text + "|" + operaciones + "|" + num + "|" + dec + ")(\\s)*)",
                condicion = id + "(\\s)*" + simbolo + "(\\s)*(" + id + "|" + num + "|" + dec + ")((\\s)*([(&&)(||)](\\s)*" + id + "(\\s)*" + simbolo + "(\\s)*(" + id + "|" + num + "|" + dec + ")))*",
                var = "((\\s)*((NUM)|(DNUM)|(WORD))(\\b)(\\s)*(" + id + "|" + defValVar + ")((\\s)*(,(\\s)*(" + id + "|" + defValVar + ")))*(\\s)*(;))",
                main = "((\\s)*" + id + "txtATraducidoBEGIN(\\s)*(\\{)[.\\W\\w\\s]*(END(\\s)*(\\})(\\s)*)$)",
                main2 = "((\\s)*" + id + "(\\b)(\\s)*BEGIN(\\s)*(\\{))",
                main3 = "((\\s)*END(\\s)*(\\})(\\s)*)",
                start2 = "((\\s)*START(\\b)(\\s)*(" + id + "|" + num + ")(\\b)(\\s)*(=)*(" + id + "|" + num + ")(\\b)(\\s)*(STEP)(\\b)(\\s)*" + num + "(\\s)*[+-]?(\\s)*(\\b)(TO)(\\b)(\\s)*(" + id + "|" + num + ")(\\s)*(\\{))",
                foresito = "((\\s)*FOR(\\b)(\\s)*(" + id + "|" + num + ")(\\b)(\\s)*(TO)(\\b)(\\s)*(" + id + "|" + num + ")(\\s)*)",
                start3 = "((\\s)*STOP(\\s)*(\\}))",
                when2 = "((\\s)*WHEN(\\s)*(\\()(\\s)*" + condicion + "(\\s)*(\\))(\\s)*(\\{))",
                when3 = "((\\s)*SWHEN(\\s)*(\\}))",
                it2 = "((\\s)*IT(\\s)*(\\()(\\s)*" + condicion + "(\\s)*(\\))(\\s)*(\\{))",
                it3 = "((\\s)*COMPLETE(\\s)*(\\}))",
                entero = "[0-9]*",
                step = "(STEP)(\\b)(\\s)*" + num + "(\\s)*[+-]?(\\s)*(\\b)",
                to = "TO(\\b)(\\s)*(" + id + "|" + num + ")(\\s)*(\\{)",
                decimal = "[0-9]*.[0-9]+";

        StringTokenizer st = new StringTokenizer(txtATexto1, "\n");
        String token;
        while (st.hasMoreTokens()) {
            //JOptionPane.showMessageDialog(this,"Identificando Variables...");
            token = st.nextToken();

            if (token.matches(main2)) {

                String tokinn = "'";
                StringTokenizer tokin = new StringTokenizer(token, " \n");
                while (tokin.hasMoreTokens()) {
                    String testo = "";
                    testo = testo + txtATraducido.getText();
                    tokinn = tokin.nextToken();
                    if (tokinn.contains("BEGIN")) {
                        txtATraducido.setText(testo + "REM ");

                    }
                    if (tokinn.matches(id) && tokinn.contains("BEGIN") == false && tokinn.contains("{") == false) {
                        txtATraducido.setText("REM Ing. Javier Mendoza Loor;\nREM " + testo + tokinn + "");
                    }
                    if (tokinn.contains("{")) {
                        txtATraducido.setText(testo + " ;\n");
                    }
                }

            }

            if (token.matches(var)) {
                String a = "";
                a = txtATraducido.getText();
                a = a + "DIM  ";
                txtATraducido.setText(a);
                String tokinn = "";
                StringTokenizer tokin = new StringTokenizer(token, " \n,;");
                while (tokin.hasMoreTokens()) {
                    String testo = "";
                    testo = testo + txtATraducido.getText();
                    tokinn = tokin.nextToken();

                    if (tokinn.contains("NUM") || tokinn.contains("DNUM") || tokinn.contains("WORD")) {
                        String enteros = "";
                        if (tokinn.contains("NUM")) {
                            enteros = " AS INTEGER";
                        }
                        if (tokinn.contains("DNUM")) {
                            enteros = " AS DOUBLE";
                        }
                        if (tokinn.contains("WORD")) {
                            enteros = " AS STRING";
                        }

                        int contador = 0;
                        while (tokin.hasMoreTokens()) {
                            tokinn = tokin.nextToken();
                            if (tokinn.equals(";")) {

                            } else {
                                if (contador >= 1) {
                                    enteros = tokinn + "," + enteros;
                                } else {
                                    enteros = tokinn + enteros;
                                }
                            }
                            contador += 1;
                        }
                        txtATraducido.setText(testo + enteros + "\n");
                    }

                }
            }

        }
        String b = txtATraducido.getText();
        b = b + "  \n";
        txtATraducido.setText(b);

        StringTokenizer st1 = new StringTokenizer(txtATexto1, "\n");
        String token1;
        while (st1.hasMoreTokens()) {
            //JOptionPane.showMessageDialog(this,"Identificando Instrucciones...");
            token1 = st1.nextToken();
            //JOptionPane.showMessageDialog(this,token1);

            /*if(token1.matches(start2)){
                      
                        String a=txtATraducido.getText()+"\nFOR ";
                        txtATraducido.setText(a);
                        StringTokenizer st2= new StringTokenizer(token1,"()");
                    }*/
            if (token1.matches(start3)) {
                //JOptionPane.showMessageDialog(this,"Termina FOR");
                String a = txtATraducido.getText() + "\nNEXT\n";
                txtATraducido.setText(a);
            }
            if (token1.matches(when2)) {
                StringTokenizer st2 = new StringTokenizer(token1, "()");
                while (st2.hasMoreTokens()) { // poner primero por espacio con tokens y luego dentro de espacio hacer ciclo y hacer tokens por cada uno
                    String tuken = st2.nextToken();
                    if (tuken.contains("=") || tuken.contains("<") || tuken.contains(">")) {
                        if (tuken.contains("=")) {
                            StringTokenizer st3 = new StringTokenizer(tuken, "=");
                            while (st3.hasMoreTokens()) {
                                String tuken2 = st3.nextToken();

                                if (st3.hasMoreTokens() == true) {
                                    String a = txtATraducido.getText() + tuken2 + "=";
                                    txtATraducido.setText(a);
                                } else {
                                    String a = txtATraducido.getText() + tuken2;
                                    txtATraducido.setText(a);
                                }

                            }
                        } else {
                            String a = txtATraducido.getText() + tuken;
                            txtATraducido.setText(a);
                        }
                    }

                    if (tuken.contains("WHEN")) {
                        String a = txtATraducido.getText() + "\nWHILE ";
                        txtATraducido.setText(a);
                        /*String loqueva=a+txtATraducido.getText()+" THEN";
                                txtATraducido.setText(loqueva);*/
                    }
                    if (tuken.contains("{")) {
                        String a = txtATraducido.getText() + "\n";
                        txtATraducido.setText(a);
                    }
                }
            }
            if (token1.matches(when3)) {
                String a = txtATraducido.getText() + "\nWEND \n";
                txtATraducido.setText(a);
            }
            if (token1.matches(it2)) {
                StringTokenizer st2 = new StringTokenizer(token1, "()");
                while (st2.hasMoreTokens()) { // poner primero por espacio con tokens y luego dentro de espacio hacer ciclo y hacer tokens por cada uno
                    String tuken = st2.nextToken();
                    if (tuken.contains("=") || tuken.contains("<") || tuken.contains(">")) {
                        if (tuken.contains("=")) {
                            StringTokenizer st3 = new StringTokenizer(tuken, "=");
                            while (st3.hasMoreTokens()) {
                                String tuken2 = st3.nextToken();

                                if (st3.hasMoreTokens() == true) {
                                    String a = txtATraducido.getText() + tuken2 + "=";
                                    txtATraducido.setText(a);
                                } else {
                                    String a = txtATraducido.getText() + tuken2;
                                    txtATraducido.setText(a);
                                }

                            }
                        } else {
                            String a = txtATraducido.getText() + tuken;
                            txtATraducido.setText(a);
                        }
                    }

                    if (tuken.contains("IT")) {
                        String a = txtATraducido.getText() + "\nIF ";
                        txtATraducido.setText(a);
                        /*String loqueva=a+txtATraducido.getText()+" THEN";
                                txtATraducido.setText(loqueva);*/
                    }
                    if (tuken.contains("{")) {
                        String a = txtATraducido.getText() + " THEN\n";
                        txtATraducido.setText(a);
                    }
                }
            }
            if (token1.matches(it3)) {
                String a = txtATraducido.getText() + "\nEND IF \n";
                txtATraducido.setText(a);
            }
            if (token1.matches(main3)) {

                String c = txtATraducido.getText() + "\n";
                txtATraducido.setText(c);
            }
            if (token1.matches(take)) {
                StringTokenizer st2 = new StringTokenizer(token1, "()");
                while (st2.hasMoreTokens()) {
                    String tuken = st2.nextToken();
                    if (tuken.contains("TAKE")) {

                        String a = txtATraducido.getText() + "\nINPUT  ";
                        a = a.replace('#', '"');
                        txtATraducido.setText(a);
                    }
                    if (tuken.contains("+")) {
                        String tokesito;
                        StringTokenizer tuk = new StringTokenizer(tuken, "+");
                        while (tuk.hasMoreTokens()) {
                            tokesito = tuk.nextToken();
                            if (tuk.hasMoreTokens()) {
                                String a = txtATraducido.getText() + tokesito + ",";
                                a = a.replace('#', '"');
                                txtATraducido.setText(a);
                            } else {
                                String a = txtATraducido.getText() + tokesito;
                                a = a.replace('#', '"');

                                txtATraducido.setText(a);
                            }
                        }
                    }

                    if (tuken.contains(";")) {
                        String a = txtATraducido.getText() + "\n";
                        a = a.replace('#', '"');
                        txtATraducido.setText(a);

                    }
                    if (tuken.contains("TAKE") == false && tuken.contains("+") == false && tuken.contains(";") == false) {
                        String a = txtATraducido.getText() + tuken;
                        a = a.replace('#', '"');
                        txtATraducido.setText(a);
                    }
                }
            }

            /*if(tuken.contains(" ")){
                                 JOptionPane.showMessageDialog(null,"Encontre espacio");
                                String tokesito;
                                StringTokenizer tuk= new StringTokenizer(tuken," ");
                                while(tuk.hasMoreTokens()){
                                    tokesito=tuk.nextToken();
                                    if(tuk.hasMoreTokens()){
                                        String a=txtATraducido.getText()+tokesito+" ";
                                       
                                        txtATraducido.setText(a);
                                    }else{
                                        String a=txtATraducido.getText()+tokesito;
                                        
                                        
                                        txtATraducido.setText(a);
                                    }
                                }
                            }*/
 /*if(tuken.contains("STEP")){
                                 JOptionPane.showMessageDialog(null,"Encontre STEP");
                                String tokesito;
                                StringTokenizer tuk= new StringTokenizer(tuken," ");
                                while(tuk.hasMoreTokens()){
                                    tokesito=tuk.nextToken();
                                    if(tuk.hasMoreTokens()){
                                        String a=txtATraducido.getText()+tokesito+" ";
                                       
                                        txtATraducido.setText(a);
                                    }else{
                                        String a=txtATraducido.getText()+tokesito;
                                      
                                        
                                        txtATraducido.setText(a);
                                    }
                                }
                            }
                            if(tuken.matches(entero)){
                                 JOptionPane.showMessageDialog(null,"Encontre entero");
                                String tokesito;
                                StringTokenizer tuk= new StringTokenizer(tuken," ");
                                while(tuk.hasMoreTokens()){
                                    tokesito=tuk.nextToken();
                                    if(tuk.hasMoreTokens()){
                                        String a=txtATraducido.getText()+tokesito+" ";
                                       
                                        txtATraducido.setText(a);
                                    }else{
                                        String a=txtATraducido.getText()+tokesito;
                                      
                                        
                                        txtATraducido.setText(a);
                                    }
                                }
                            }
                            if(tuken.contains("TO")){
                                 JOptionPane.showMessageDialog(null,"Encontre to  ");
                                String tokesito;
                                StringTokenizer tuk= new StringTokenizer(tuken," ");
                                while(tuk.hasMoreTokens()){
                                    tokesito=tuk.nextToken();
                                    if(tuk.hasMoreTokens()){
                                        String a=txtATraducido.getText()+tokesito;
                                       
                                        txtATraducido.setText(a);
                                    }else{
                                        String a=txtATraducido.getText()+tokesito;
                                      
                                        
                                        txtATraducido.setText(a);
                                    }
                                }
                            }*/
 /*if(tuken.contains(" ")){
                                  JOptionPane.showMessageDialog(null,"Encontre espacio");
                                String tokesito;
                                StringTokenizer tuk= new StringTokenizer(tuken," ");
                                while(tuk.hasMoreTokens()){
                                    tokesito=tuk.nextToken();
                                    if(tuk.hasMoreTokens()){
                                        String a=txtATraducido.getText()+tokesito+" ";
                                       
                                        txtATraducido.setText(a);
                                    }else{
                                        String a=txtATraducido.getText()+tokesito;
                                      
                                        
                                        txtATraducido.setText(a);
                                    }
                                }
                            }
                          if(tuken.matches(to)){
                              JOptionPane.showMessageDialog(null,"Encontre un TO");
                                String tokesito;
                                StringTokenizer tuk= new StringTokenizer(tuken," ");
                                while(tuk.hasMoreTokens()){
                                    tokesito=tuk.nextToken();
                                    if(tuk.hasMoreTokens()){
                                        String a=txtATraducido.getText()+tokesito+" ";
                                       
                                        txtATraducido.setText(a);
                                    }else{
                                        String a=txtATraducido.getText()+tokesito;
                                      
                                        
                                        txtATraducido.setText(a);
                                    }
                                }
                            }
                          
                            
                            if (tuken.contains(" ")) {
                                 JOptionPane.showMessageDialog(null,"Encontre espacio");
                                String a=txtATraducido.getText()+" ";
                               
                                txtATraducido.setText(a);
                                
                            }*/
 /*if(tuken.contains("START")==false && tuken.contains("STEP")==false && tuken.contains("{")==false&& tuken.contains(entero)==false){
                                 JOptionPane.showMessageDialog(null,"Encontre otra cosa");
                                 String tokesito="";
                                StringTokenizer tuk= new StringTokenizer(tuken," ");
                                while(tuk.hasMoreTokens()){
                                    tokesito=tuk.nextToken();
                                    System.out.println(""+tokesito);
                                }
                                String a=txtATraducido.getText()+tuken;
                                a=a.replaceAll(step," ");
                                txtATraducido.setText(a);
                            }*/
            if (token1.matches(send)) {
                StringTokenizer st2 = new StringTokenizer(token1, "()");
                while (st2.hasMoreTokens()) {
                    String tuken = st2.nextToken();
                    if (tuken.contains("SEND")) {

                        String a = txtATraducido.getText() + "\nPRINT  ";
                        a = a.replace('#', '"');

                        txtATraducido.setText(a);
                    }
                    if (tuken.contains("+")) {
                        String tokesito;
                        StringTokenizer tuk = new StringTokenizer(tuken, "+");
                        while (tuk.hasMoreTokens()) {
                            tokesito = tuk.nextToken();
                            if (tuk.hasMoreTokens()) {
                                String a = txtATraducido.getText() + tokesito + ",";
                                a = a.replace('#', '"');
                                txtATraducido.setText(a);
                            } else {
                                String a = txtATraducido.getText() + tokesito;
                                a = a.replace('#', '"');
                                txtATraducido.setText(a);
                            }
                        }
                    }

                    if (tuken.contains(";")) {
                        String a = txtATraducido.getText() + " \n";
                        a = a.replace('#', '"');
                        txtATraducido.setText(a);
                    }
                    if (tuken.contains("SEND") == false && tuken.contains("+") == false && tuken.contains(";") == false) {
                        String a = txtATraducido.getText() + tuken;
                        a = a.replace('#', '"');
                        txtATraducido.setText(a);
                    }
                }
            }

            if (token1.matches(defVal)) {
                String tokesito;
                StringTokenizer tuk = new StringTokenizer(token1);
                while (tuk.hasMoreTokens()) {
                    tokesito = tuk.nextToken();
                    String a = txtATraducido.getText() + tokesito + "\n";
                    a = a.replace(';', ' ');
                    txtATraducido.setText(a);
                }

                JOptionPane.showMessageDialog(this, "Se encontro una operación");

            }

            //ESTA COSA ES PARA EL CICLO FOR
            if (token1.matches(start2)) { //Compara si esta el matches dentro del token
                String tokesito = "";
                String texto = "";
                StringTokenizer tuk = new StringTokenizer(token1, "\\s");
                while (tuk.hasMoreTokens()) {
                    tokesito = tuk.nextToken();
                    String a = txtATraducido.getText() + "\n";//almacenoo todo
                    tokesito = tokesito.replace("START", "FOR");//reemplazo
                    tokesito = tokesito.replaceAll(step, " ");
                    tokesito = tokesito.replace("{", "\n");
                    texto += a + tokesito;//se guarda en el acumulador de lo reemplazado
                    txtATraducido.setText(texto);

                }

                JOptionPane.showMessageDialog(this, "Se encontro un ciclo for");

            }

            //CICLO FOR
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtATraducido = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(153, 0, 102));

        txtATraducido.setColumns(20);
        txtATraducido.setRows(5);
        jScrollPane1.setViewportView(txtATraducido);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Código Convertido");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

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
            java.util.logging.Logger.getLogger(Traducido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Traducido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Traducido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Traducido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Traducido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea txtATraducido;
    // End of variables declaration                   
}
