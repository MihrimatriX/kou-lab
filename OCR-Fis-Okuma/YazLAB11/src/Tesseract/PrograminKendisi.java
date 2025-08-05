package Tesseract;

import com.mysql.jdbc.Statement;
import com.sun.javafx.css.Size;
import javax.swing.table.DefaultTableModel;
import java.awt.Frame;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.TableRowSorter;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.log4j.chainsaw.Main;
import static org.bytedeco.javacpp.opencv_imgproc.CV_ADAPTIVE_THRESH_MEAN_C;
import static org.bytedeco.javacpp.opencv_imgproc.CV_THRESH_BINARY;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class PrograminKendisi extends javax.swing.JFrame {
    String SecilenDosya;
    DefaultTableModel model;
    DefaultTableModel sonuc;
    DefaultTableModel ilk;
    Program araclar = new Program();
    
    public PrograminKendisi() {
        initComponents();
        model = (DefaultTableModel) tablodesen.getModel();
        VeriGoruntule();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DosyaSec = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablodesen = new javax.swing.JTable();
        parseET = new javax.swing.JButton();
        dosyaSec = new javax.swing.JButton();
        CompanyArea = new javax.swing.JTextField();
        HistoryArea = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        LOGKismi = new javax.swing.JTextArea();
        aramacubuk = new javax.swing.JTextField();
        sil = new javax.swing.JButton();
        ekleme = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        aramabuton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DosyaSec.setBackground(new java.awt.Color(153, 255, 255));
        DosyaSec.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DosyaSec.setForeground(new java.awt.Color(255, 102, 0));
        DosyaSec.setText("                  :::::::::DOSYA SECME ALANI::::::::");

        tablodesen.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        tablodesen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fis No", "Şirket Adı", "Tarih", "Urun KDV Fiyat", "Toplam Fiyat"
            }
        ));
        tablodesen.setRowHeight(48);
        tablodesen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablodesenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablodesen);

        parseET.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        parseET.setText("PARSE");
        parseET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parseETActionPerformed(evt);
            }
        });

        dosyaSec.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        dosyaSec.setText("DOSYA SEC");
        dosyaSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosyaSecActionPerformed(evt);
            }
        });

        CompanyArea.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        CompanyArea.setForeground(new java.awt.Color(204, 102, 0));

        HistoryArea.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        HistoryArea.setForeground(new java.awt.Color(153, 102, 0));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("COMPANY NAME        ::");

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("DATE                            ::");

        LOGKismi.setColumns(20);
        LOGKismi.setFont(new java.awt.Font("Monospaced", 2, 18)); // NOI18N
        LOGKismi.setRows(5);
        jScrollPane2.setViewportView(LOGKismi);

        aramacubuk.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        aramacubuk.setText("Aramak Için Yazin");
        aramacubuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aramacubukMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aramacubukMouseExited(evt);
            }
        });
        aramacubuk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aramacubukKeyReleased(evt);
            }
        });

        sil.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        sil.setForeground(new java.awt.Color(51, 51, 51));
        sil.setText("SIL");
        sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silActionPerformed(evt);
            }
        });

        ekleme.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        ekleme.setText("EKLE");
        ekleme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eklemeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel3.setText("                         ::: OCR TABANLI FIS VERITABANI :::");

        aramabuton.setText("ARAMA YAP");
        aramabuton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aramabutonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ekleme, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sil, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(aramabuton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(5, 5, 5))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(HistoryArea, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                                    .addComponent(CompanyArea)))
                            .addComponent(aramacubuk)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dosyaSec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(parseET, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DosyaSec, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aramacubuk, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(aramabuton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ekleme, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sil, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CompanyArea)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(DosyaSec, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(parseET, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(dosyaSec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HistoryArea, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void dinamikAra(String ara) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tablodesen.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(ara));
    }
    private void dosyaSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosyaSecActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath() + " Secilen Dosya Yolu ");
            SecilenDosya = selectedFile.getAbsolutePath();
            DosyaSec.setIcon(new ImageIcon(SecilenDosya));
        }
    }//GEN-LAST:event_dosyaSecActionPerformed
    private void parseETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parseETActionPerformed
        System.out.println("Parse Islemi Basladi.");
        log("Parse Islemi Basladi.");
        Tesseract tesseract = new Tesseract();
        try {
            tesseract.setDatapath("C:\\Users\\XPS\\Desktop\\Tess4J\\tessdata");
            String text = tesseract.doOCR(new File(SecilenDosya));
            
            tesseract.setLanguage("Interstate");
            
            int x = 5;
            
           Mat img = new Mat();
           img = Imgcodecs.imread("sample_photo.jpg"); 
           Imgcodecs.imwrite("preprocess/True_Image.png", img);
           
           
           Mat imgGray = new Mat();
           Imgproc.cvtColor(img, imgGray, Imgproc.COLOR_BGR2GRAY);
           Imgcodecs.imwrite("preprocess/Gray.png", imgGray);


            Mat imgGaussianBlur = new Mat(); 
           // Imgproc.GaussianBlur(imgGray,imgGaussianBlur,new Size(3, 3),0);
            Imgcodecs.imwrite("preprocess/gaussian_blur.png", imgGaussianBlur);  


            Mat imgAdaptiveThreshold = new Mat();
            Imgproc.adaptiveThreshold(imgGaussianBlur, imgAdaptiveThreshold, 255, CV_ADAPTIVE_THRESH_MEAN_C ,CV_THRESH_BINARY, 99, 4);
            Imgcodecs.imwrite("preprocess/adaptive_threshold.png", imgAdaptiveThreshold);
          
            
            /**
             * Image Processing
             */
            String fisno = ParseIslem.FisNoAra(text);
            String isletmeadi = ParseIslem.IsletmeAra(text);
            String tarih = ParseIslem.TarihAra(text);
            String fiyaturunkdv = ParseIslem.UrunAra(text);
            
            String toplamyazisi = ParseIslem.ToplamAra(text);
            
           
            //ParseIslem.UrunAra(text);
            //ParseIslem.MiktarAra(text);

            //System.out.print(text);
            log(text);

            System.out.println("--------------------------------");
            System.out.println("Fiş Numara :" + fisno);
            System.out.println("İşletme Adı :" +isletmeadi);
            System.out.println("Tarih :" + tarih);
            System.out.println("Fiyat Urun KDV :" + fiyaturunkdv);
            System.out.println("Toplam Fiyat :" + toplamyazisi);

            int yollafis = Integer.parseInt(fisno);
            
            araclar.VeriEkle(isletmeadi, tarih, yollafis, fiyaturunkdv, toplamyazisi);
            
            
            
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_parseETActionPerformed
    private void tablodesenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablodesenMouseClicked
        int selectedrow = tablodesen.getSelectedRow();
        CompanyArea.setText(model.getValueAt(selectedrow, 1).toString());
        HistoryArea.setText(model.getValueAt(selectedrow, 2).toString());
    }//GEN-LAST:event_tablodesenMouseClicked
    private void aramacubukKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aramacubukKeyReleased
        String ara = aramacubuk.getText();
        dinamikAra(ara);
    }//GEN-LAST:event_aramacubukKeyReleased
    private void aramacubukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aramacubukMouseClicked
        aramacubuk.setText("");
    }//GEN-LAST:event_aramacubukMouseClicked
    private void aramacubukMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aramacubukMouseExited
        aramacubuk.setText("Aramak Için Yazin.");
    }//GEN-LAST:event_aramacubukMouseExited
    private void eklemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eklemeActionPerformed
        FisEkleme fisekle = new FisEkleme();
        fisekle.setVisible(true);
        fisekle.setResizable(false);
        VeriGoruntule();
    }//GEN-LAST:event_eklemeActionPerformed
    private void silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silActionPerformed
        log("Veri Silme Islemi");
        int selectedrow = tablodesen.getSelectedRow();

        if (selectedrow == -1) {
            if (model.getRowCount() == 0) {
                log("Tablo Su Anda Bos");
            } else {
                log("Silinecek Kismi Secin");
            }
        } else {
            int id = (int) model.getValueAt(selectedrow, 0);
            araclar.veriSil(id);
            VeriGoruntule();
            log("Veri Basariyla Silindi.");
        }
    }//GEN-LAST:event_silActionPerformed

    private void aramabutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aramabutonActionPerformed
        //VeriAra(CompanyArea.getText(), HistoryArea.getText());
        //araclar.VeriGuncelAra(CompanyArea.getText(), HistoryArea.getText());
        VeriGoruntule();
        tablodesen.setModel(model);
        tablodesen.getModel();
    }//GEN-LAST:event_aramabutonActionPerformed
    public void log(String msg) {
        LOGKismi.append(msg);
    }
    public void VeriGoruntule() {
        model.setRowCount(0);
        ArrayList<Veri> verii = new ArrayList<Veri>();
        verii = araclar.VeriGuncelAra(CompanyArea.getText(), HistoryArea.getText());

        if (verii != null) {
            for (Veri verigirisi : verii) {
                Object[] eklenecek
                        = {
                            verigirisi.getFisNo(), verigirisi.getCompanyName(),
                            verigirisi.getTarih(), verigirisi.getUrunKDVFiyat(),
                            verigirisi.getToplamFiyat()
                        };
                model.addRow(eklenecek);
            }
        }
    }

    public void VeriGor()
    {
        ilk.setRowCount(0);
        ArrayList<Veri> ilk = new ArrayList<Veri>();
        ilk = araclar.VeriGetir();

        if (ilk != null) {
            for (Veri verigirisi : ilk) {
                Object[] eklenecek
                        = {
                            verigirisi.getFisNo(), verigirisi.getCompanyName(),
                            verigirisi.getTarih(), verigirisi.getUrunKDVFiyat(),
                            verigirisi.getToplamFiyat()
                        };
                sonuc.addRow(eklenecek);
            }
        }
    }
    
    public void VeriAraGoruntule() {
        sonuc.setRowCount(0);
        ArrayList<Veri> aramasonu = new ArrayList<Veri>();
        aramasonu = araclar.VeriGetir();

        if (aramasonu != null) {
            for (Veri verigirisi : aramasonu) {
                Object[] eklenecek
                        = {
                            verigirisi.getFisNo(), verigirisi.getCompanyName(),
                            verigirisi.getTarih(), verigirisi.getUrunKDVFiyat(),
                            verigirisi.getToplamFiyat()
                        };
                sonuc.addRow(eklenecek);
            }
        }
    }
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(PrograminKendisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrograminKendisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrograminKendisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrograminKendisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrograminKendisi().setVisible(true);
            }
        });
    }
    public void VeriAra(String Company, String Date) {
        araclar.VeriGuncelAra(CompanyArea.getText(), HistoryArea.getText());
        VeriAraGoruntule();
        tablodesen.setModel(sonuc);
        tablodesen.getModel();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CompanyArea;
    private javax.swing.JLabel DosyaSec;
    private javax.swing.JTextField HistoryArea;
    private javax.swing.JTextArea LOGKismi;
    private javax.swing.JButton aramabuton;
    private javax.swing.JTextField aramacubuk;
    private javax.swing.JButton dosyaSec;
    private javax.swing.JButton ekleme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JButton parseET;
    private javax.swing.JButton sil;
    private javax.swing.JTable tablodesen;
    // End of variables declaration//GEN-END:variables
}