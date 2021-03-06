/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg120222c_imageeditor;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author Manoj
 */
public class ImageEditorWindow extends javax.swing.JFrame {

    JLabel lable = new JLabel();    //this label is used show the image
    MyImage myImage = new MyImage();    //tis is the MyImage object
    Image image;    //used to show the image

    /**
     * Creates new form ImageEditorWindow
     */
    public ImageEditorWindow() {
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

        jMenu1 = new javax.swing.JMenu();
        jScrollPane = new javax.swing.JScrollPane();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItem_Open = new javax.swing.JMenuItem();
        jMenuItem_Clone = new javax.swing.JMenuItem();
        jMenuItem_Save = new javax.swing.JMenuItem();
        jMenuItem_SaveAs = new javax.swing.JMenuItem();
        jMenuItem_exit = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItem_GrayScale = new javax.swing.JMenuItem();
        jMenuItem_Negative = new javax.swing.JMenuItem();
        jMenuItem_Brightness = new javax.swing.JMenuItem();
        jMenuItem_Metadata = new javax.swing.JMenuItem();
        jMenu_RGB = new javax.swing.JMenu();
        jMenuItem_RED = new javax.swing.JMenuItem();
        jMenuItem_GREEN = new javax.swing.JMenuItem();
        jMenuItem_BLUE = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Editor");

        jMenuFile.setText("File");

        jMenuItem_Open.setText("Open");
        jMenuItem_Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_OpenActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItem_Open);

        jMenuItem_Clone.setText("Clone");
        jMenuItem_Clone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_CloneActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItem_Clone);

        jMenuItem_Save.setText("Save");
        jMenuItem_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_SaveActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItem_Save);

        jMenuItem_SaveAs.setText("SaveAs..");
        jMenuItem_SaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_SaveAsActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItem_SaveAs);

        jMenuItem_exit.setText("Exit");
        jMenuItem_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_exitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItem_exit);

        jMenuBar.add(jMenuFile);

        jMenuEdit.setText("Edit");

        jMenuItem_GrayScale.setText("GrayScale");
        jMenuItem_GrayScale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_GrayScaleActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItem_GrayScale);

        jMenuItem_Negative.setText("Negative");
        jMenuItem_Negative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_NegativeActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItem_Negative);

        jMenuItem_Brightness.setText("Brightness");
        jMenuEdit.add(jMenuItem_Brightness);

        jMenuItem_Metadata.setText("Metadata");
        jMenuItem_Metadata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_MetadataActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItem_Metadata);

        jMenu_RGB.setText("RGB");

        jMenuItem_RED.setText("RED");
        jMenuItem_RED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_REDActionPerformed(evt);
            }
        });
        jMenu_RGB.add(jMenuItem_RED);

        jMenuItem_GREEN.setText("GREEN");
        jMenuItem_GREEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_GREENActionPerformed(evt);
            }
        });
        jMenu_RGB.add(jMenuItem_GREEN);

        jMenuItem_BLUE.setText("BLUE");
        jMenuItem_BLUE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_BLUEActionPerformed(evt);
            }
        });
        jMenu_RGB.add(jMenuItem_BLUE);

        jMenuEdit.add(jMenu_RGB);

        jMenuBar.add(jMenuEdit);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_OpenActionPerformed
        // TODO add your handling code here:
        //create a file chooser
        JFileChooser fileChooser = new JFileChooser();

        //select the file and dispaly
        if (fileChooser.showOpenDialog(jMenuBar) == JFileChooser.APPROVE_OPTION) {

            //get selected file name
            File f = fileChooser.getSelectedFile();

            //get the image
            myImage.setImage(f.toString());

            //set the buffered image to a 
            image = myImage.getImage();
            lable.setIcon(new ImageIcon(image));
            lable.setHorizontalAlignment(JLabel.CENTER);

            jScrollPane.getViewport().add(lable);

        }
    }//GEN-LAST:event_jMenuItem_OpenActionPerformed

    private void jMenuItem_GrayScaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_GrayScaleActionPerformed
        // TODO add your handling code here:
        myImage.getGrascale();
        image = myImage.getImage();
        lable.setIcon(new ImageIcon(image));

    }//GEN-LAST:event_jMenuItem_GrayScaleActionPerformed

    private void jMenuItem_NegativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_NegativeActionPerformed
        // TODO add your handling code here:
        myImage.getNegative();
        image = myImage.getImage();
        lable.setIcon(new ImageIcon(image));
    }//GEN-LAST:event_jMenuItem_NegativeActionPerformed

    private void jMenuItem_CloneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_CloneActionPerformed
        // TODO add your handling code here:
        ImageEditorWindow newWindow = new ImageEditorWindow();
        newWindow.showImage(image);
        newWindow.setVisible(true);
        newWindow.myImage.setImage((BufferedImage) image);


    }//GEN-LAST:event_jMenuItem_CloneActionPerformed

    private void jMenuItem_SaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_SaveAsActionPerformed
        // TODO add your handling code here:

        JFileChooser fileChooser = new JFileChooser();
        //select the file and dispaly
        if (fileChooser.showSaveDialog(jMenuBar) == JFileChooser.APPROVE_OPTION) {

            //get selected file name
            //int retrival=fileChooser.showSaveDialog(null);
            File f = fileChooser.getSelectedFile();
            saveToFile(f.toString());
            myImage.setFileName(f.toString());
            System.out.println("saved");
        }
    }//GEN-LAST:event_jMenuItem_SaveAsActionPerformed

    private void jMenuItem_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_SaveActionPerformed
        // TODO add your handling code here:

        saveToFile(myImage.getFileName());

    }//GEN-LAST:event_jMenuItem_SaveActionPerformed

    private void jMenuItem_MetadataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_MetadataActionPerformed
        // TODO add your handling code here:
        MetaData meta = new MetaData();
        if (new File(myImage.getFileName()).exists()) {
            meta.readAndDisplayMetadata(myImage.getFileName());
        } else {
            System.out.println("cannot find file: " + myImage.getFileName());
        }

    }//GEN-LAST:event_jMenuItem_MetadataActionPerformed

    private void jMenuItem_REDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_REDActionPerformed
        // TODO add your handling code here:
        myImage.getRed();
        image = myImage.getImage();
        lable.setIcon(new ImageIcon(image));
    }//GEN-LAST:event_jMenuItem_REDActionPerformed

    private void jMenuItem_GREENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_GREENActionPerformed
        // TODO add your handling code here:
        myImage.getGreen();
        image = myImage.getImage();
        lable.setIcon(new ImageIcon(image));
    }//GEN-LAST:event_jMenuItem_GREENActionPerformed

    private void jMenuItem_BLUEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_BLUEActionPerformed
        // TODO add your handling code here:
        myImage.getBlue();
        image = myImage.getImage();
        lable.setIcon(new ImageIcon(image));
    }//GEN-LAST:event_jMenuItem_BLUEActionPerformed

    private void jMenuItem_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_exitActionPerformed
        // TODO add your handling code here:
       // exit();
        System.exit(this.EXIT_ON_CLOSE);
    }//GEN-LAST:event_jMenuItem_exitActionPerformed

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
            java.util.logging.Logger.getLogger(ImageEditorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageEditorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageEditorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageEditorWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageEditorWindow().setVisible(true);
            }
        });
    }

    public void showImage(Image cloneImage) {

        lable.setIcon(new ImageIcon(cloneImage));
        lable.setHorizontalAlignment(JLabel.CENTER);
        jScrollPane.getViewport().add(lable);

    }

    public void saveToFile(String filename) {
        String ftype = filename.substring(filename.lastIndexOf('.') + 1);
        try {
            //the image will be saved here 
            ImageIO.write(myImage.getImage(), ftype, new File(filename));
        } catch (IOException e) {
            System.out.println("Error in saving the file");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItem_BLUE;
    private javax.swing.JMenuItem jMenuItem_Brightness;
    private javax.swing.JMenuItem jMenuItem_Clone;
    private javax.swing.JMenuItem jMenuItem_GREEN;
    private javax.swing.JMenuItem jMenuItem_GrayScale;
    private javax.swing.JMenuItem jMenuItem_Metadata;
    private javax.swing.JMenuItem jMenuItem_Negative;
    private javax.swing.JMenuItem jMenuItem_Open;
    private javax.swing.JMenuItem jMenuItem_RED;
    private javax.swing.JMenuItem jMenuItem_Save;
    private javax.swing.JMenuItem jMenuItem_SaveAs;
    private javax.swing.JMenuItem jMenuItem_exit;
    private javax.swing.JMenu jMenu_RGB;
    private javax.swing.JScrollPane jScrollPane;
    // End of variables declaration//GEN-END:variables

}
