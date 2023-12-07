package com.mycompany.compilador1;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class SintacSeman extends javax.swing.JFrame {

    public SintacSeman() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Error = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(153, 0, 102));

        jScrollPane1.setViewportView(Error);
        Error.getAccessibleContext().setAccessibleName("");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Errores Sintácticos y Semánticos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    public boolean erroresSemSin(int errores, String txtATexto1) {

        Ventana_1 principal = new Ventana_1();
        errores = 0;
        LinkedList<String> ENT = new LinkedList<>();
        LinkedList<String> DEC = new LinkedList<>();
        LinkedList<String> TEXT = new LinkedList<>();
        LinkedList<String> TAKE = new LinkedList<>();

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
                main = "((\\s)*" + id + "(\\b)(\\s)*BEGIN(\\s)*(\\{)[.\\W\\w\\s]*(END(\\s)*(\\})(\\s)*)$)",
                main2 = "((\\s)*" + id + "(\\b)(\\s)*BEGIN(\\s)*(\\{))",
                main3 = "((\\s)*END(\\s)*(\\})(\\s)*)",
                start2 = "((\\s)*START(\\b)(\\s)*(" + id + "|" + num + ")(\\b)(\\s)*(=)*(" + id + "|" + num + ")(\\b)(\\s)*(STEP)(\\b)(\\s)*" + num + "(\\s)*[+-]?(\\s)*(\\b)(TO)(\\b)(\\s)*(" + id + "|" + num + ")(\\s)*(\\{))",
                start3 = "((\\s)*STOP(\\s)*(\\}))",
                when2 = "((\\s)*WHEN(\\s)*(\\()(\\s)*" + condicion + "(\\s)*(\\))(\\s)*(\\{))",
                when3 = "((\\s)*SWHEN(\\s)*(\\}))",
                it2 = "((\\s)*IT(\\s)*(\\()(\\s)*" + condicion + "(\\s)*(\\))(\\s)*(\\{))",
                it3 = "((\\s)*COMPLETE(\\s)*(\\}))",
                entero = "[0-9]*",
                decimal = "[0-9]*.[0-9]+";

        LinkedList<Integer> error = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(txtATexto1, ";{}", true);
        String token = "", txt = "", e;
        int i = 1, mainE = 0, start = 0, when = 0, it = 0, eB = 0;
        Error.setText("");

        if (txtATexto1.matches(main)) {

            while (st.hasMoreTokens()) {
                token = st.nextToken();
                if (st.hasMoreTokens()) {
                    token = token + st.nextToken();
                }
                if (token.matches("[.\\W\\w\\s]*(\\})") && st.countTokens() == 1) {
                    String auxTok = st.nextToken();
                    token = token + (auxTok.substring(0, auxTok.indexOf("\n")));
                }
                StringTokenizer lin = new StringTokenizer(token, "\n", true);
                while (lin.hasMoreTokens()) {
                    e = lin.nextToken();
                    if ("\n".equals(e)) {
                        i++;
                    }
                }

                if (token.matches(start2)) {
                    start++;
                }
                if (token.matches(start3)) {
                    start--;
                }
                if (token.matches(when2)) {
                    when++;
                }
                if (token.matches(when3)) {
                    when--;
                }
                if (token.matches(it2)) {
                    it++;
                }
                if (token.matches(it3)) {
                    it--;
                }
                if ((st.hasMoreTokens() == false && (start > 0 || when > 0 || it > 0)) || (start < 0 || when < 0 || it < 0)) {
                    eB = 1;
                }

                if ((token.matches(send) || token.matches(take) || token.matches(var) || token.matches(defVal) || token.matches(main2) || token.matches(main3) || token.matches("(\\s)*(\\$)") || token.matches(start2) || token.matches(start3) || token.matches(when2) || token.matches(when3) || token.matches(it2) || token.matches(it3)) && eB == 0) {
                    if (token.matches(take)) {

                    }
                    if (token.matches(var)) {
                        StringTokenizer stTipo = new StringTokenizer(token, " ,;");
                        String tipo = stTipo.nextToken();

                        if (tipo.contains("NUM")) {

                            while (stTipo.hasMoreTokens()) {
                                tipo = stTipo.nextToken();

                                if (ENT.contains(tipo) || DEC.contains(tipo) || TEXT.contains(tipo) || TAKE.contains(tipo)) {
                                    Error.setText("La Variable esta repetida (" + tipo + ") " + i + ": \n"
                                            + "________________________________________________________________________\n" + token);
                                    for (int j = 1; j < i; j++) {
                                        txt += "\n";
                                    }
                                    principal.LineaError.setText(txt + " ¡!");
                                    errores = 1;
                                    break;
                                }

                                ENT.add(tipo);
                            }
                        }
                        if (tipo.contains("DNUM")) {

                            while (stTipo.hasMoreTokens()) {
                                tipo = stTipo.nextToken();

                                if (ENT.contains(tipo) || DEC.contains(tipo) || TEXT.contains(tipo) || TAKE.contains(tipo)) {
                                    Error.setText("La Variable esta repetida (" + tipo + ") " + i + ": \n"
                                            + "________________________________________________________________________\n" + token);
                                    for (int j = 1; j < i; j++) {
                                        txt += "\n";
                                    }
                                    principal.LineaError.setText(txt + " ¡!");
                                    errores = 1;
                                    break;
                                }

                                DEC.add(tipo);
                            }
                        }
                        if (tipo.contains("TAKE")) {

                            while (stTipo.hasMoreTokens()) {
                                tipo = stTipo.nextToken();

                                if (ENT.contains(tipo) || DEC.contains(tipo) || TEXT.contains(tipo) || TAKE.contains(tipo)) {
                                    Error.setText("La Variable esta repetida (" + tipo + ") " + i + ": \n"
                                            + "________________________________________________________________________\n" + token);
                                    for (int j = 1; j < i; j++) {
                                        txt += "\n";
                                    }
                                    principal.LineaError.setText(txt + " ¡!");
                                    errores = 1;
                                    break;
                                }

                                TAKE.add(tipo);
                            }
                        }
                        if (tipo.contains("WORD")) {

                            while (stTipo.hasMoreTokens()) {
                                tipo = stTipo.nextToken();

                                if (ENT.contains(tipo) || DEC.contains(tipo) || TEXT.contains(tipo) || TAKE.contains(tipo)) {
                                    Error.setText("La variable esta repetida (" + tipo + ") " + i + ": \n"
                                            + "________________________________________________________________________\n" + token);
                                    for (int j = 1; j < i; j++) {
                                        txt += "\n";
                                    }
                                    principal.LineaError.setText(txt + " ¡!");
                                    errores = 1;
                                    break;
                                }

                                TEXT.add(tipo);
                            }
                        }
                    }
                    if (token.matches(defVal)) {
                        StringTokenizer stComprobar = new StringTokenizer(token, " \n\t=;");
                        String ID = stComprobar.nextToken(), comprobar = "", tok = "";
                        //System.out.print(ID);
                        while (stComprobar.hasMoreTokens()) {
                            comprobar += stComprobar.nextToken();
                        }

                        if (ENT.contains(ID)) {
                            StringTokenizer stComprobarE = new StringTokenizer(comprobar, "+*/-");
                            while (stComprobarE.hasMoreTokens()) {
                                tok = stComprobarE.nextToken();

                                if (tok.matches(id)) {
                                    if (ENT.contains(tok)); else {
                                        Error.setText("ERROR SEMÁNTICO (" + tok + ") " + i + ": \n"
                                                + "________________________________________________________________________\n" + token);
                                        for (int j = 1; j < i; j++) {
                                            txt += "\n";
                                        }
                                        principal.LineaError.setText(txt + " ¡!");
                                        errores = 1;
                                        break;
                                    }
                                } else {
                                    if (tok.matches(entero)); else {
                                        Error.setText("ERROR SEMÁNTICO (" + tok + ") " + i + ": \n"
                                                + "________________________________________________________________________\n" + token);
                                        for (int j = 1; j < i; j++) {
                                            txt += "\n";
                                        }
                                        principal.LineaError.setText(txt + " ¡!");
                                        errores = 1;
                                        break;
                                    }
                                }
                            }
                        } else {
                            if (DEC.contains(ID)) {
                                StringTokenizer stComprobarD = new StringTokenizer(comprobar, "+*/-");
                                while (stComprobarD.hasMoreTokens()) {
                                    tok = stComprobarD.nextToken();

                                    if (tok.matches(id)) {
                                        if (DEC.contains(tok)); else {
                                            Error.setText("ERROR SEMÁNTICO (" + tok + ") " + i + ": \n"
                                                    + "________________________________________________________________________\n" + token);
                                            for (int j = 1; j < i; j++) {
                                                txt += "\n";
                                            }
                                            principal.LineaError.setText(txt + " ¡!");
                                            errores = 1;
                                            break;
                                        }
                                    } else {
                                        if (tok.matches(decimal)); else {
                                            Error.setText("ERROR SEMÁNTICO (" + tok + ") " + i + ": \n"
                                                    + "________________________________________________________________________\n" + token);
                                            for (int j = 1; j < i; j++) {
                                                txt += "\n";
                                            }
                                            principal.LineaError.setText(txt + " ¡!");
                                            errores = 1;
                                            break;
                                        }
                                    }
                                }
                            } else {
                                if (TEXT.contains(ID)) {
                                    if (comprobar.matches("((((\")[.\\W\\w\\s]*(\"))|(" + id + "))((\\s)*(\\+)((\\s)*((\")[.\\W\\w\\s]*(\"))|(" + id + ")))*)")); else {
                                        Error.setText("ERROR SEMÁNTICO " + i + ": \n"
                                                + "________________________________________________________________________\n" + token);
                                        for (int j = 1; j < i; j++) {
                                            txt += "\n";
                                        }
                                        principal.LineaError.setText(txt + " ¡!");
                                        errores = 1;
                                        break;
                                    }
                                } else {
                                    Error.setText("Variable no declarada " + i + ": \n"
                                            + "________________________________________________________________________\n" + token);
                                    for (int j = 1; j < i; j++) {
                                        txt += "\n";
                                    }
                                    principal.LineaError.setText(txt + " ¡!");
                                    errores = 1;
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    if (token.contains("SEND")) {
                        //txtATraducido.setText("PRINT");
                        Error.setText("Error al declarar sentencia SEND; en la linea " + i + ": \n"
                                + "\n" + token);
                        errores = 1;
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    }
                    if (token.contains("NUM") || token.contains("DNUM") || token.contains("WORD")) {
                        Error.setText("Error en declaracion de variables; en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    }
                    if (token.contains("TAKE")) {
                        Error.setText("Error en lectura de valor TAKE  en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    }
                    if (token.contains("STOP}")) {

                        Error.setText("Cierre de Ciclo START incorrecto  en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    }
                    if (token.contains("START")) {

                        Error.setText("Inicio de Ciclo START incorrecto  en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    }
                    if (token.contains("SWHEN")) {
                        Error.setText("Cierre de ciclo WHEN incorrecto en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        break;
                    }
                    if (token.contains("WHEN")) {
                        Error.setText("Inicio de ciclo WHEN incorrecto en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    }
                    if (token.contains("COMPLETE")) {

                        Error.setText("Cierre de condicion IT incorrecto en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    }
                    if (token.contains("IT")) {

                        Error.setText("Inicio de IT incorrecto; en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    } else {
                        Error.setText("Sintaxis Erronea en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    }
                }

            }

        } else {
            st = new StringTokenizer(txtATexto1, ";{}", true);
            while (st.hasMoreTokens()) {
                token = st.nextToken();
                if (st.hasMoreTokens()) {
                    token = token + st.nextToken();
                }
                if (token.matches("[.\\W\\w\\s]*(\\})") && st.countTokens() == 1) {
                    String auxTok = st.nextToken();
                    token = token + (auxTok.substring(0, auxTok.indexOf("\n")));
                }
                StringTokenizer lin = new StringTokenizer(token, "\n", true);
                while (lin.hasMoreTokens()) {
                    e = lin.nextToken();
                    if ("\n".equals(e)) {
                        i++;
                    }
                }
                if (eB == 1) {
                    break;
                }
                if (token.matches(start2)) {
                    start++;
                }
                if (token.matches(start3)) {
                    start--;
                }
                if (token.matches(when2)) {
                    when++;
                }
                if (token.matches(when3)) {
                    when--;
                }
                if (token.matches(it2)) {
                    it++;
                }
                if (token.matches(it3)) {
                    it--;
                }
                if ((st.hasMoreTokens() == false && (start > 0 || when > 0 || it > 0)) || (start < 0 || when < 0 || it < 0)) {
                    eB = 1;
                }

                if ((token.matches(send) || token.matches(take) || token.matches(var) || token.matches(defVal) || token.matches(main2) || token.matches(main3) || token.matches("(\\s)*(\\$)") || token.matches(start2) || token.matches(start3) || token.matches(when2) || token.matches(when3) || token.matches(it2) || token.matches(it3)) && eB == 0) {
                    Error.setText("Compilado Exitosamente");
                    if (token.matches(main3)) {
                        eB = 1;
                    }
                } else {
                    if (token.contains("SEND")) {
                        Error.setText("Error al declarar sentencia SEND  en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    }
                    if (token.contains("NUM") || token.contains("DNUM") || token.contains("WORD")) {
                        Error.setText("Error en declaracion de variables  en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    }
                    if (token.contains("TAKE")) {
                        Error.setText("Error en lectura de valor TAKE en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    }
                    if (token.contains("STOP}")) {
                        Error.setText("Cierre de Ciclo START incorrecto en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    }
                    if (token.contains("START")) {
                        Error.setText("Inicio de Ciclo START incorrecto  en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    }
                    if (token.contains("SWHEN")) {
                        Error.setText("Cierre de ciclo WHEN incorrecto  en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    }
                    if (token.contains("WHEN")) {
                        Error.setText("Inicio de ciclo WHEN incorrecto  en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    }
                    if (token.contains("COMPLETE")) {
                        Error.setText("Cierre de condicion IT incorrecto; en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    }
                    if (token.contains("IT")) {
                        Error.setText("Inicio de IT incorrecto en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    } else {
                        Error.setText("Sintaxis Erronea en la linea " + i + ": \n"
                                + "\n" + token);
                        for (int j = 1; j < i; j++) {
                            txt += "\n";
                        }
                        principal.LineaError.setText(txt + " ¡!");
                        errores = 1;
                        break;
                    }
                }
            }
            if (mainE == 0) {
                Error.setText("Cierre de Clase incorrecto en la Linea " + i + ": \n"
                        + "\n" + token);
                for (int j = 1; j < 1; j++) {
                    txt += "\n";
                }
                principal.LineaError.setText(txt + " ¡!");
                errores = 1;
            }
        }
        if (errores == 1) {
            return (false);
            //principal.btnTraducir.setEnabled(false);
        } else {
            //principal.btnTraducir.setEnabled(true);
            return (true);
        }
    }

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
            java.util.logging.Logger.getLogger(SintacSeman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SintacSeman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SintacSeman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SintacSeman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SintacSeman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    public javax.swing.JEditorPane Error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   

}
