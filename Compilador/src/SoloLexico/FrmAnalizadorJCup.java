/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SoloLexico;

import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author mdelgado
 */
public class FrmAnalizadorJCup extends javax.swing.JFrame {

    private Menu menu;

    /**
     * Creates new form FrmAnalizador
     */
    public FrmAnalizadorJCup() {
        this.setUndecorated(true);
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(135, 206, 235));
        this.disegnBtns();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonAnalisis = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Resultado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        btnArchivo = new javax.swing.JButton();
        Borrar1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtxtAreaSintactico = new javax.swing.JTextArea();
        jButtonSintactico = new javax.swing.JButton();
        jButtonIntermedio = new javax.swing.JButton();
        Boton_Assembler = new javax.swing.JButton();
        Boton_Objeto = new javax.swing.JButton();
        Boton_Ejecutable = new javax.swing.JButton();
        Boton_Ejecutar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonAnalisis.setBackground(new Color(255, 192, 203));
        BotonAnalisis.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BotonAnalisis.setText("Análisis Léxico");
        BotonAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAnalisisActionPerformed(evt);
            }
        });

        Resultado.setColumns(20);
        Resultado.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Resultado.setRows(5);
        jScrollPane1.setViewportView(Resultado);

        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setRows(5);
        jScrollPane2.setViewportView(txtAnalizarLex);

        btnArchivo.setBackground(new Color(255, 192, 203));
        btnArchivo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnArchivo.setText("Cargar Archivo");
        btnArchivo.setToolTipText("");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        Borrar1.setBackground(new java.awt.Color(210, 180, 222));
        Borrar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Borrar1.setText("Limpiar Analizador");
        Borrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Borrar1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(210, 180, 222));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Actualizar Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 3, 30)); // NOI18N
        jLabel1.setText("Analizador léxico Jcup");

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(210, 180, 222));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Limpiar código fuente");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jtxtAreaSintactico.setColumns(20);
        jtxtAreaSintactico.setRows(5);
        jScrollPane3.setViewportView(jtxtAreaSintactico);

        jButtonSintactico.setBackground(new java.awt.Color(210, 180, 222));
        jButtonSintactico.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSintactico.setText("Analizador Sintáctico");
        jButtonSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSintacticoActionPerformed(evt);
            }
        });

        jButtonIntermedio.setBackground(new java.awt.Color(162, 217, 206));
        jButtonIntermedio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonIntermedio.setText("Intermedio");
        jButtonIntermedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIntermedioActionPerformed(evt);
            }
        });

        Boton_Assembler.setBackground(new java.awt.Color(162, 217, 206));
        Boton_Assembler.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Boton_Assembler.setText("Assembler");
        Boton_Assembler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_AssemblerActionPerformed(evt);
            }
        });

        Boton_Objeto.setBackground(new java.awt.Color(162, 217, 206));
        Boton_Objeto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Boton_Objeto.setText("Objeto");
        Boton_Objeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_ObjetoActionPerformed(evt);
            }
        });

        Boton_Ejecutable.setBackground(new java.awt.Color(162, 217, 206));
        Boton_Ejecutable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Boton_Ejecutable.setText("Ejecutable");
        Boton_Ejecutable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_EjecutableActionPerformed(evt);
            }
        });

        Boton_Ejecutar.setBackground(new java.awt.Color(162, 217, 206));
        Boton_Ejecutar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Boton_Ejecutar.setText("Ejecutar");
        Boton_Ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_EjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnArchivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Borrar1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane2)
                                    .addComponent(BotonAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(jButtonSintactico, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonIntermedio, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Boton_Assembler, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Boton_Objeto, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Boton_Ejecutable, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Boton_Ejecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonAnalisis)
                    .addComponent(btnArchivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Borrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonIntermedio, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton_Objeto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Boton_Assembler, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Boton_Ejecutable, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boton_Ejecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSintactico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void analizarLexico() throws IOException {
        int cont = 1;

        String expr = (String) Resultado.getText();
        Lexico lexicos = new Lexico(new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        while (true) {
            Tokens token = lexicos.yylex();
            if (token == null) {
                txtAnalizarLex.setText(resultado);
                return;
            }
            switch (token) {
                case Linea:
                    cont++;
                    resultado += "LINEA " + cont + "\n";
                    break;
                case Comillas:
                    resultado += "  <Comillas>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Cadena:
                    resultado += "  <Tipo de dato>\t" + lexicos.lexemas + "\n";
                    break;
                case T_dato:
                    resultado += "  <Tipo de dato>\t" + lexicos.lexemas + "\n";
                    break;
                case If:
                    resultado += "  <Reservada if>\t" + lexicos.lexemas + "\n";
                    break;
//                case Int:
//                    resultado += "  <Reservada int>\t" + lexicos.lexemas + "\n";
//                    break;
                case Else:
                    resultado += "  <Reservada else>\t" + lexicos.lexemas + "\n";
                    break;
                case Do:
                    resultado += "  <Reservada do>\t" + lexicos.lexemas + "\n";
                    break;
                case While:
                    resultado += "  <Reservada while>\t" + lexicos.lexemas + "\n";
                    break;
                case For:
                    resultado += "  <Reservada for>\t" + lexicos.lexemas + "\n";
                    break;
                case Igual:
                    resultado += "  <Operador igual>\t" + lexicos.lexemas + "\n";
                    break;
                case Suma:
                    resultado += "  <Operador suma>\t" + lexicos.lexemas + "\n";
                    break;
                case Resta:
                    resultado += "  <Operador resta>\t" + lexicos.lexemas + "\n";
                    break;
                case Multiplicacion:
                    resultado += "  <Operador multiplicacion>\t" + lexicos.lexemas + "\n";
                    break;
                case Division:
                    resultado += "  <Operador division>\t" + lexicos.lexemas + "\n";
                    break;
                case Op_logico:
                    resultado += "  <Operador logico>\t" + lexicos.lexemas + "\n";
                    break;
                case Op_incremento:
                    resultado += "  <Operador incremento>\t" + lexicos.lexemas + "\n";
                    break;
                case Op_relacional:
                    resultado += "  <Operador relacional>\t" + lexicos.lexemas + "\n";
                    break;
                case Op_atribucion:
                    resultado += "  <Operador atribucion>\t" + lexicos.lexemas + "\n";
                    break;
                case Op_booleano:
                    resultado += "  <Operador booleano>\t" + lexicos.lexemas + "\n";
                    break;
                case Parent_a:
                    resultado += "  <Parentesis de apertura>\t" + lexicos.lexemas + "\n";
                    break;
                case Parent_c:
                    resultado += "  <Parentesis de cierre>\t" + lexicos.lexemas + "\n";
                    break;
                case Llave_a:
                    resultado += "  <Llave de apertura>\t" + lexicos.lexemas + "\n";
                    break;
                case Llave_c:
                    resultado += "  <Llave de cierre>\t" + lexicos.lexemas + "\n";
                    break;
                case Corchete_a:
                    resultado += "  <Corchete de apertura>\t" + lexicos.lexemas + "\n";
                    break;
                case Corchete_c:
                    resultado += "  <Corchete de cierre>\t" + lexicos.lexemas + "\n";
                    break;
                case Main:
                    resultado += "  <Reservada main>\t" + lexicos.lexemas + "\n";
                    break;
                case Switch:
                    resultado += "  <Reservada switch>\t" + lexicos.lexemas + "\n";
                    break;
                case Case:
                    resultado += "  <Reservada case>\t" + lexicos.lexemas + "\n";
                    break;
                case Palabra_Reservada:
                    resultado += "  <Reservada>\t" + lexicos.lexemas + "\n";
                    break;
                case P_Coma:
                    resultado += "  <Punto y coma>\t" + lexicos.lexemas + "\n";
                    break;
                case Punto:
                    resultado += "  <Punto>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Coma:
                    resultado += "  <Coma>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Printf:
                    resultado += "  <Reservada printf>\t" + lexicos.lexemas + "\n";
                    break;
                case Scanf:
                    resultado += "  <Reservada scanf>\t" + lexicos.lexemas + "\n";
                    break;
                case Cin:
                    resultado += "  <Reservada cin>\t" + lexicos.lexemas + "\n";
                    break;
                case Cout:
                    resultado += "  <Reservada cout>\t" + lexicos.lexemas + "\n";
                    break;

                case Const:
                    resultado += "  <Reservada const>\t" + lexicos.lexemas + "\n";
                    break;
                case Short:
                    resultado += "  <Tipo de dato >\t" + lexicos.lexemas + "\n";
                    break;
                case Unsigned:
                    resultado += "  <Reservada unsigned>\t" + lexicos.lexemas + "\n";
                    break;
                case Struct:
                    resultado += "  <Reservada struct>\t" + lexicos.lexemas + "\n";
                    break;
                case Typedef:
                    resultado += "  <Reservada typedef>\t" + lexicos.lexemas + "\n";
                    break;
                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexicos.lexemas + "\n";
                    break;

                case Break:
                    resultado += "  <Reservada break>\t" + lexicos.lexemas + "\n";
                    break;

                case Default:
                    resultado += "  <Reservada default>\t" + lexicos.lexemas + "\n";
                    break;

                case Return:
                    resultado += "  <Reservada return>\t" + lexicos.lexemas + "\n";
                    break;

                case DosPuntos:
                    resultado += "  <Dos Puntos >\t" + lexicos.lexemas + "\n";
                    break;

                case ERROR:
                    resultado += "  <Simbolo no definido>\n";
                    break;

                default:
                    resultado += "  < " + lexicos.lexemas + " >\n";
                    break;
            }
        }

    }

    private void BotonAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAnalisisActionPerformed
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmAnalizadorJCup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonAnalisisActionPerformed

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        int cont = 1;
        JFileChooser escoger = new JFileChooser();
        escoger.showOpenDialog(null);
        arc = new File(escoger.getSelectedFile().getAbsolutePath());

        try {
            String ST = new String(Files.readAllBytes(arc.toPath()));
            Resultado.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmAnalizadorJCup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmAnalizadorJCup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnArchivoActionPerformed

    private void Borrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Borrar1ActionPerformed
        txtAnalizarLex.setText(null);
    }//GEN-LAST:event_Borrar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (arc != null) {
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(arc));
            } catch (IOException ex) {
                Logger.getLogger(FrmAnalizadorJFlex.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                bw.write("");
                bw.write(Resultado.getText());
                bw.close();
                JOptionPane.showMessageDialog(null, "Lo ha mofificado exitosamente");
            } catch (IOException ex) {
                Logger.getLogger(FrmAnalizadorJFlex.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha adjuntado ningun archivo (Cargar archivo)");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        this.menu.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.menu.finalizar();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Resultado.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButtonSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSintacticoActionPerformed
        String ST = Resultado.getText();
        Sintax s = new Sintax(new SoloLexico.LexicoCup(new StringReader(ST)));

        try {
            s.parse();
            jtxtAreaSintactico.setText("Analisis realizado correctamente");
            jtxtAreaSintactico.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            jtxtAreaSintactico.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            jtxtAreaSintactico.setForeground(Color.red);
        }
    }//GEN-LAST:event_jButtonSintacticoActionPerformed

    private void Boton_EjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_EjecutarActionPerformed
        try {
            String[] comando = {"correr.bat"};
            Runtime.getRuntime().exec(comando);
            System.out.println("Ejecucion del programa en el sistema operativo");
        } catch (IOException ex) {
            System.out.println(ex);
        }    }//GEN-LAST:event_Boton_EjecutarActionPerformed

    private void jButtonIntermedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIntermedioActionPerformed
        try {
            String[] intermedio = {"intermedio.bat"};
            Runtime.getRuntime().exec(intermedio);
            System.out.println("Ejecucion del convertidor de código fuente a código intermedio ");
            Boton_Assembler.setEnabled(true);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_jButtonIntermedioActionPerformed

    private void Boton_AssemblerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_AssemblerActionPerformed
        try {
            String[] gassembler = {"ensamblador.bat"};
            Runtime.getRuntime().exec(gassembler);
            System.out.println("Ejecucion del convertidor de código intermedio a assembler");
            Boton_Objeto.setEnabled(true);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_Boton_AssemblerActionPerformed

    private void Boton_ObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_ObjetoActionPerformed
        try {
            String[] gobjeto = {"objeto.bat"};
            Runtime.getRuntime().exec(gobjeto);
            System.out.println("Ejecucion del convertidor assembler a objeto");
            Boton_Ejecutable.setEnabled(true);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_Boton_ObjetoActionPerformed

    private void Boton_EjecutableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_EjecutableActionPerformed
        try {
            String[] gejecutable = {"ejecutable.bat"};
            Runtime.getRuntime().exec(gejecutable);
            System.out.println("Ejecucion del generador del programa ejecutable");
            Boton_Ejecutar.setEnabled(true);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_Boton_EjecutableActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAnalizadorJCup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAnalizadorJCup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAnalizadorJCup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAnalizadorJCup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAnalizadorJCup().setVisible(true);
            }
        });
    }

    public void disegnBtns() {
        imgRegresar = new ImageIcon("src/imagenes/izquierda.png");
        imgAux = new ImageIcon(imgRegresar.getImage().getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING));

        jButton2.setBorder(null);
        //Color rojo 236, 112, 99
        jButton2.setBackground(new Color(82, 190, 128));
        jButton2.setIcon(imgAux);

        //----------------------------------------
        imgCancelar = new ImageIcon("src/imagenes/cerrar.png");
        imgAux = new ImageIcon(imgCancelar.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
        jButton3.setBackground(null);
        jButton3.setBorder(null);
        jButton3.setIcon(imgAux);
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    private File arc;
    private ImageIcon imgCancelar, imgRegresar, imgAux;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Borrar1;
    private javax.swing.JButton BotonAnalisis;
    private javax.swing.JButton Boton_Assembler;
    private javax.swing.JButton Boton_Ejecutable;
    private javax.swing.JButton Boton_Ejecutar;
    private javax.swing.JButton Boton_Objeto;
    private javax.swing.JTextArea Resultado;
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonIntermedio;
    private javax.swing.JButton jButtonSintactico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtxtAreaSintactico;
    private javax.swing.JTextArea txtAnalizarLex;
    // End of variables declaration//GEN-END:variables
}
