
package prolab1.pkg3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class KullaniciGiris extends javax.swing.JFrame {
int sayac=0;
int robot_sayisi=0;
ArrayList<String> robot_tipi = new ArrayList();
ArrayList<Robot> robot_dizi = new ArrayList();
ArrayList<GezginRobotlar> gezgin_dizi = new ArrayList();
String[] robotlar={"Spider","Paletli","Tekerlekli","Seri","Paralel","Hibrit"};
//ileri,sağa,geri,sola    
    public KullaniciGiris() {
        initComponents();
        goster_button.setVisible(false);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();
        text_alan = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        hata = new javax.swing.JLabel();
        goster_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        label.setText("Kaç tane robot tanımlamak istediğinizi girin:");

        jButton1.setText("Tamam");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        goster_button.setText("Göster");
        goster_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goster_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goster_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 101, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(hata)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(goster_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label)
                    .addComponent(text_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(hata)
                    .addComponent(goster_button))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
       
       int kontrol = 0;
       int sayac2=0;
       
        if(sayac==0){
           try{
               robot_sayisi = Integer.parseInt(text_alan.getText());
               hata.setText("");
               text_alan.setText("");
               sayac++;
           }catch(NumberFormatException e){
               hata.setText("Lutfen boş bırakmayın ya da yazı girmeyin.");
           }
       }
       if(sayac>0 && sayac<=robot_sayisi){
           label.setText(sayac+". robotun tipini girin:");
           String robot_tip = text_alan.getText();
            for (int i = 0; i < robotlar.length; i++) {
            if(robot_tip.equalsIgnoreCase(robotlar[i])){
              kontrol = 1;
           }
            }
            if(kontrol == 1){
           if(sayac==robot_sayisi){
               sayac=999;
               text_alan.setVisible(false);
               label.setVisible(false);
               hata.setVisible(false);
           }
           sayac++;
           robot_tipi.add(text_alan.getText());
           text_alan.setText("");
           label.setText(sayac+". robotun tipini girin:");
           hata.setText("");
            }else{
               hata.setText("Girdiğiniz robot tipi bulunmamaktadır.");
           }
       }
       if(sayac==1000){
           jButton1.setVisible(false);
           goster_button.setVisible(true);
           for (sayac2 = 0; sayac2 < robot_sayisi; sayac2++) {
      if("spider".equalsIgnoreCase(robot_tipi.get(sayac2))){
                  Spider s = new Spider();
                      s.setRobot_tipi("Spider");
                      s.setBacak_sayisi(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Spider) robotun bacak sayısı")));
                      s.setMotor_sayisi(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Spider) robotun motor sayısı")));
                      s.setYuk_miktari(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Spider) robotun yük miktarı")));
                      do{
                      s.setGezinme_hizi(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Spider) robotun gezinme hızı")));
                      }while(s.getGezinme_hizi()==0);
                      robot_dizi.add(s);
      }
      if("tekerlekli".equalsIgnoreCase(robot_tipi.get(sayac2))){
                  Tekerlekli t = new Tekerlekli();
                      t.setRobot_tipi("Tekerlekli");
                      t.setTekerlek_sayisi(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Tekerlekli) robotun tekerlek sayısı")));
                      t.setMotor_sayisi(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Tekerlekli) robotun motor sayısı")));
                      t.setYuk_miktari(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Tekerlekli) robotun yük miktarı")));
                      do{
                      t.setGezinme_hizi(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Tekerlekli) robotun gezinme hızı")));
                      }while(t.getGezinme_hizi()==0);
                      robot_dizi.add(t);
      }
      if("paletli".equalsIgnoreCase(robot_tipi.get(sayac2))){
                  Paletli p = new Paletli();
                      p.setRobot_tipi("Paletli");
                      p.setPalet_sayisi(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Paletli) robotun palet sayısı")));
                      p.setMotor_sayisi(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Paletli) robotun motor sayısı")));
                      p.setYuk_miktari(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Paletli) robotun yük miktarı")));
                      do{
                      p.setGezinme_hizi(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Paletli) robotun gezinme hızı")));
                      }while(p.getGezinme_hizi()==0);
                      robot_dizi.add(p);
      }
      if("seri".equalsIgnoreCase(robot_tipi.get(sayac2))){
          Seri se = new Seri();
          se.setRobot_tipi("Seri");
          do{
          se.setKapasite(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Seri) robotun kapasitesi")));
          }while(se.getKapasite()>20);
          se.setKol_uzunlugu(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Seri) robotun kol uzunlugu")));
          se.setMotor_sayisi(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Seri) robotun motor sayısı")));
          do{
          se.setYuk_miktari(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Seri) robotun yük miktarı")));
          }while(se.getKapasite()<se.getYuk_miktari());
          do{
          se.setTasima_hizi(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Seri) robotun taşıma hızı")));
          }while(se.getTasima_hizi()>20);
          robot_dizi.add(se);
      }
      if("paralel".equalsIgnoreCase(robot_tipi.get(sayac2))){
          Paralel pa = new Paralel();
          pa.setRobot_tipi("Paralel");
          pa.setKapasite(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Paralel) robotun kapasitesi")));
          pa.setKol_uzunlugu(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Paralel) robotun kol uzunlugu")));
          pa.setMotor_sayisi(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Paralel) robotun motor sayısı")));
          do{
          pa.setYuk_miktari(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Paralel) robotun yük miktarı")));
          }while(pa.getKapasite()<pa.getYuk_miktari());
          pa.setTasima_hizi(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Paralel) robotun taşıma hızı")));
          robot_dizi.add(pa);
      }
      if("hibrit".equalsIgnoreCase(robot_tipi.get(sayac2))){
          String gezginkisim,gezmeyenkisim;   
          gezginkisim = JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun gezen kısmı");
          if(gezginkisim.equalsIgnoreCase("spider")){
          int bacak_sayi = Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Spider) robotun bacak sayısı"));
          int gezinme_hizi = Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun gezinme hızı"));
          Hibrit hi = new Hibrit(new Spider(),bacak_sayi,gezinme_hizi);    
             if(hi.getGezinme_hizi() == 30){
                 System.out.println("selam");
             }
             if(hi.getGezinme_hizi() == 0){
                 System.out.println("selam0");
             }
          hi.setMotor_sayisi(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun motor sayısı")));
          gezmeyenkisim = JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun sabit kısmı");
          hi.setKapasite(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun kapasitesi")));
          hi.setKol_uzunlugu(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun kol uzunluğu")));
          do{
          hi.setYuk_miktari(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun yük miktarı")));
          }while(hi.getKapasite()<hi.getYuk_miktari());
          hi.setTasima_hizi(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun taşıma hızı")));
          robot_dizi.add(hi);
          }
          if(gezginkisim.equalsIgnoreCase("tekerlekli")){
          int motor_sayi = Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun motor sayısı"));
          int gezinme_hizi = Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun gezinme hızı"));
          Hibrit hi = new Hibrit(new Spider(),motor_sayi,gezinme_hizi);    
          gezmeyenkisim = JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun sabit kısmı");
          hi.setKapasite(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun kapasitesi")));
          hi.setKol_uzunlugu(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun kol uzunluğu")));
          do{
          hi.setYuk_miktari(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun yük miktarı")));
          }while(hi.getKapasite()<hi.getYuk_miktari());
          hi.setTasima_hizi(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun taşıma hızı")));
          robot_dizi.add(hi);    
          }
          if(gezginkisim.equalsIgnoreCase("paletli")){
              int motor_sayi = Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun motor sayısı"));
              int gezinme_hizi = Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun gezinme hızı"));
          Hibrit hi = new Hibrit(new Spider(),motor_sayi,gezinme_hizi);    
          gezmeyenkisim = JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun sabit kısmı");
          hi.setKapasite(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun kapasitesi")));
          hi.setKol_uzunlugu(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun kol uzunluğu")));
          do{
          hi.setYuk_miktari(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun yük miktarı")));
          }while(hi.getKapasite()<hi.getYuk_miktari());
          hi.setTasima_hizi(Integer.parseInt(JOptionPane.showInputDialog(null,(sayac2+1)+".(Hibrit) robotun taşıma hızı")));
          robot_dizi.add(hi);
          }
          
      }
        }
       }
       
       
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void goster_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goster_buttonActionPerformed
      int i;
      do{
      i=Integer.parseInt(JOptionPane.showInputDialog(null,"Kaçıncı robotu görüntülemek istiyorsunuz?"));  
      }while(i>robot_tipi.size());
      int engel_sayisi=0;
      int[][] robot_konum = new int[1][2];
      int[] hareket = new int[4];
      int[] hibrit_kol = new int[4];
      engel_sayisi = (Integer.parseInt(JOptionPane.showInputDialog(null,"Girmek istediğiniz engel sayısı")));
                      int[][] engel_konum = new int[engel_sayisi][2];
                      if(engel_sayisi>0){
                          for (int j = 0; j < engel_sayisi; j++){
                            engel_konum[j][0]=(Integer.parseInt(JOptionPane.showInputDialog(null,j+1+". engelin x konumu")));
                            engel_konum[j][1]=(Integer.parseInt(JOptionPane.showInputDialog(null,j+1+". engelin y konumu")));
                          }
                      }
                      robot_konum[0][0]=(Integer.parseInt(JOptionPane.showInputDialog(null,"Robotun x konumu")));
                      robot_konum[0][1]=(Integer.parseInt(JOptionPane.showInputDialog(null,"Robotun y konumu")));
                      hareket[0]=(Integer.parseInt(JOptionPane.showInputDialog(null,"Robotun ileri hareketi")));
                      hareket[1]=(Integer.parseInt(JOptionPane.showInputDialog(null,"Robotun sağa hareketi")));
                      hareket[2]=(Integer.parseInt(JOptionPane.showInputDialog(null,"Robotun geri hareketi")));
                      hareket[3]=(Integer.parseInt(JOptionPane.showInputDialog(null,"Robotun sola hareketi")));
                      JFrame jf = new JFrame();
                      jf.setSize(625,650);
                      jf.setLocation(400,75);
                      jf.setVisible(true);
                      String robotun_tipi = robot_dizi.get(i-1).getRobot_tipi();
                      if(robotun_tipi.equalsIgnoreCase("spider")){
                      Grafik g = new Grafik(engel_konum,engel_sayisi,robot_konum,hareket,robotun_tipi,((GezginRobotlar)robot_dizi.get(i-1)).getGezinme_hizi(),0);
                      jf.add(g);
                      }
                      if(robotun_tipi.equalsIgnoreCase("tekerlekli")){
                      Grafik g = new Grafik(engel_konum,engel_sayisi,robot_konum,hareket,robotun_tipi,((GezginRobotlar)robot_dizi.get(i-1)).getGezinme_hizi(),((Tekerlekli)robot_dizi.get(i-1)).EngelGecmeSuresiBul(((Tekerlekli)robot_dizi.get(i-1)).getMotor_sayisi()));
                      jf.add(g);   
                      }
                      if(robotun_tipi.equalsIgnoreCase("paletli")){
                      Grafik g = new Grafik(engel_konum,engel_sayisi,robot_konum,hareket,robotun_tipi,((GezginRobotlar)robot_dizi.get(i-1)).getGezinme_hizi(),((Paletli)robot_dizi.get(i-1)).EngelGecmeSuresiBul(((Paletli)robot_dizi.get(i-1)).getMotor_sayisi()));
                      jf.add(g);       
                      }
                      if(robotun_tipi.equalsIgnoreCase("seri")){
                      Grafik g = new Grafik(robot_konum,hareket,robotun_tipi,((Seri)robot_dizi.get(i-1)).getTasima_hizi(),((Seri)robot_dizi.get(i-1)).getKol_uzunlugu());    
                      jf.add(g);
                      }
                      if(robotun_tipi.equalsIgnoreCase("paralel")){
                      Grafik g = new Grafik(robot_konum,hareket,robotun_tipi,((Paralel)robot_dizi.get(i-1)).getTasima_hizi(),((Paralel)robot_dizi.get(i-1)).getKol_uzunlugu());    
                      jf.add(g);
                      }
                      if(robotun_tipi.equalsIgnoreCase("hibrit")){
                      hibrit_kol[0]=(Integer.parseInt(JOptionPane.showInputDialog(null,"Robot kolunun ileri hareketi")));
                      hibrit_kol[1]=(Integer.parseInt(JOptionPane.showInputDialog(null,"Robot kolunun sağa hareketi")));
                      hibrit_kol[2]=(Integer.parseInt(JOptionPane.showInputDialog(null,"Robot kolunun geri hareketi")));
                      hibrit_kol[3]=(Integer.parseInt(JOptionPane.showInputDialog(null,"Robot kolunun sola hareketi")));
                      
                      if(((Hibrit)robot_dizi.get(i-1)).kontrol==1){
                      Grafik g = new Grafik(engel_konum,engel_sayisi,robot_konum,hareket,robotun_tipi,((GezginRobotlar)robot_dizi.get(i-1)).getGezinme_hizi(),((Hibrit)robot_dizi.get(i-1)).getTasima_hizi(),0,((Hibrit)robot_dizi.get(i-1)).getKol_uzunlugu(),hibrit_kol);
                          System.out.println(((GezginRobotlar)robot_dizi.get(i-1)).getGezinme_hizi());
                      jf.add(g);  
                      }
                      if(((Hibrit)robot_dizi.get(i-1)).kontrol==2){
                      Grafik g = new Grafik(engel_konum,engel_sayisi,robot_konum,hareket,robotun_tipi,((GezginRobotlar)robot_dizi.get(i-1)).getGezinme_hizi(),((Hibrit)robot_dizi.get(i-1)).getTasima_hizi(),((Hibrit)robot_dizi.get(i-1)).engel_gecme,((Hibrit)robot_dizi.get(i-1)).getKol_uzunlugu(),hibrit_kol);
                      jf.add(g);     
                      }
                      if(((Hibrit)robot_dizi.get(i-1)).kontrol==3){
                      Grafik g = new Grafik(engel_konum,engel_sayisi,robot_konum,hareket,robotun_tipi,((GezginRobotlar)robot_dizi.get(i-1)).getGezinme_hizi(),((Hibrit)robot_dizi.get(i-1)).getTasima_hizi(),((Hibrit)robot_dizi.get(i-1)).engel_gecme,((Hibrit)robot_dizi.get(i-1)).getKol_uzunlugu(),hibrit_kol);
                      jf.add(g);     
                      }
                      
                      
                      }
                        
    }//GEN-LAST:event_goster_buttonActionPerformed

    
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
            java.util.logging.Logger.getLogger(KullaniciGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KullaniciGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KullaniciGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KullaniciGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KullaniciGiris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goster_button;
    private javax.swing.JLabel hata;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel label;
    private javax.swing.JTextField text_alan;
    // End of variables declaration//GEN-END:variables

   static class Grafik extends JPanel{
        
       int[][] engel;
       int[][] robot;
       int[] hareket;
       int[] kol_hareket;
       int engel_sayisi;
       int hiz;
       int tasima_hiz;
       double engel_gecme;
       int kol_uzunlugu;
       String robot_tipi;
       
       public Grafik(){
       }
       public Grafik(int[][] engel_konum,int engel_sayisi,int[][] robot_konumu,int[] move,String robot_tipi,int hiz,double engel_gecme){
           this.engel = new int[engel_sayisi][2];
           this.robot = new int[1][2];
           this.hareket = new int[4];
           this.engel_sayisi = engel_sayisi;
           this.robot_tipi = robot_tipi;
           this.hiz = hiz;
           this.engel_gecme = engel_gecme;
           
           
           robot = robot_konumu;
           hareket = move;
           engel = engel_konum;
           
           
           for (int i = 0; i < 1; i++) {
               for (int j = 0; j < 2; j++) {
                   robot[i][j] = (robot[i][j]*3);
               }
           }
           for (int i = 0; i < engel.length; i++) {
               for (int j = 0; j < 2; j++) {
                   engel[i][j] = (engel[i][j]*3);
               }
       }
       }
       public Grafik(int[][] robot_konumu,int[] move,String robot_tipi,int hiz,int kol_uzunlugu){
        this.engel = new int[engel_sayisi][2];
           this.robot = new int[1][2];
           this.hareket = new int[4];
           this.robot_tipi = robot_tipi;
           this.hiz = hiz;
           this.kol_uzunlugu = kol_uzunlugu;
           
           
           robot = robot_konumu;
           hareket = move;
           
           
           
           for (int i = 0; i < 1; i++) {
               for (int j = 0; j < 2; j++) {
                   robot[i][j] = (robot[i][j]*3);
               }
           }  
       }
       public Grafik(int[][] engel_konum,int engel_sayisi,int[][] robot_konumu,int[] move,String robot_tipi,int gezme_hiz,int tasima_hiz,double engel_gecme,int kol_uzunlugu,int[] kol_hareketi){
       this.engel = new int[engel_sayisi][2];
           this.robot = new int[1][2];
           this.hareket = new int[4];
           this.kol_hareket = new int[4];
           this.engel_sayisi = engel_sayisi;
           this.robot_tipi = robot_tipi;
           this.hiz = gezme_hiz;
           this.tasima_hiz = tasima_hiz;
           this.engel_gecme = engel_gecme;
           this.kol_uzunlugu = kol_uzunlugu;
           
           
           robot = robot_konumu;
           hareket = move;
           engel = engel_konum;
           kol_hareket = kol_hareketi;
           
           
           for (int i = 0; i < 1; i++) {
               for (int j = 0; j < 2; j++) {
                   robot[i][j] = (robot[i][j]*3);
               }
           }
           for (int i = 0; i < engel.length; i++) {
               for (int j = 0; j < 2; j++) {
                   engel[i][j] = (engel[i][j]*3);
               }
       }    
       } 
       @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
            
            
            
            for (int i = 0; i <= 600; i+=30) {
                g.setColor(Color.black);
                g.drawLine(i, 0, i, 600);
                g.drawLine(0, i, 600, i);
            }
            g.setColor(Color.blue);
            g.fillOval(robot[0][0]-5, robot[0][1]-5, 10,10);
            
            for (int i = 0; i < engel.length; i++) {
                g.setColor(Color.red);           
                g.fillOval(engel[i][0]-5,engel[i][1]-5,10,10);
            }
            
                g.setColor(Color.magenta);
           
            if(robot_tipi.equalsIgnoreCase("spider") || robot_tipi.equalsIgnoreCase("tekerlekli") || robot_tipi.equalsIgnoreCase("paletli"))
                problem1(g,robot_tipi,hareket,robot,engel,engel_sayisi,engel_gecme);
            if(robot_tipi.equalsIgnoreCase("seri") || robot_tipi.equalsIgnoreCase("paralel"))
                problem2(g,robot_tipi,hareket,robot,kol_uzunlugu);
            if(robot_tipi.equalsIgnoreCase("hibrit"))
                problem3(g,robot_tipi,hareket,robot,engel,engel_sayisi,engel_gecme,kol_uzunlugu,kol_hareket);
                
        }
        
        public void problem1(Graphics g,String robot_tipi,int[] hareket,int[][] robot,int[][] engel,int engel_sayisi,double engel_gecme){
          g.setColor(Color.magenta);
          int kontrol = 0,i;
          double gecen_sure=0;
          

          //robotun ileri hareketi
          for (i = robot[0][1]; i <= robot[0][1]+(hareket[0]*30); i++) {
          if(engel_sayisi != 0){
          for (int j = 0; j < engel_sayisi; j++) {
           if(i==engel[j][1] && robot[0][0]==engel[j][0]){
              if(robot_tipi.equalsIgnoreCase("spider")){
              JOptionPane.showMessageDialog(null,"Robotun son konumu x:"+robot[0][0]/3+" y:"+i/3);
              kontrol=1;
              break;
              }
              if(robot_tipi.equalsIgnoreCase("tekerlekli") || robot_tipi.equalsIgnoreCase("paletli"))
                  gecen_sure += engel_gecme;
          }       
              }
              }
          if(i>600){
              JOptionPane.showMessageDialog(null,"Robot sınır alanının dışına çıkmıştır.");
              kontrol = 1;
              break;
          }
          }
          gecen_sure += (Math.abs((double)((robot[0][1]/3)) - (double)((i/3))))/hiz;
          g.drawLine(robot[0][0],robot[0][1], robot[0][0],i);
          robot[0][1]=i-1;
          g.setColor(Color.green);
          g.fillOval(robot[0][0]-5,robot[0][1]-5, 10, 10);
          g.setColor(Color.magenta);
          
          
          
          
          //robotun sağa hareketi
          if(kontrol != 1){
          for (i = robot[0][0]; i <= robot[0][0]+(hareket[1]*30); i++) {
          if(engel_sayisi != 0){
              for (int j = 0; j < engel_sayisi; j++) {
          if(i==engel[j][0] && robot[0][1]==engel[j][1]){
              if(robot_tipi.equalsIgnoreCase("spider")){
              JOptionPane.showMessageDialog(null,"Robotun son konumu x:"+i/3+" y:"+robot[0][1]/3);
              kontrol=1;
              break;
              }
              if(robot_tipi.equalsIgnoreCase("tekerlekli") || robot_tipi.equalsIgnoreCase("paletli"))
                  gecen_sure += engel_gecme;
          }       
              }
         
          }
          if(i>600){
              JOptionPane.showMessageDialog(null,"Robot sınır alanının dışına çıkmıştır.");
              kontrol = 1;
              break;
          }
          }
          gecen_sure += (Math.abs((double)((robot[0][0]/3)) - (double)((i/3))))/hiz;
          g.drawLine(robot[0][0], robot[0][1], i, robot[0][1]);
          robot[0][0]=i-1;
          g.setColor(Color.green);
          g.fillOval(robot[0][0]-5,robot[0][1]-5, 10, 10);
          g.setColor(Color.magenta);
          }
          



          //robotun geri hareketi
          if(kontrol != 1){
          for (i = robot[0][1]; i >= robot[0][1]-(hareket[2]*30); i--) {
          if(engel_sayisi != 0){
              for (int j = 0; j < engel_sayisi; j++) {
          if(i==engel[j][1] && robot[0][0]==engel[j][0]){
              if(robot_tipi.equalsIgnoreCase("spider")){
              JOptionPane.showMessageDialog(null,"Robotun son konumu x:"+robot[0][0]/3+" y:"+i/3);
              kontrol=1;
              break;
              }
              if(robot_tipi.equalsIgnoreCase("tekerlekli") || robot_tipi.equalsIgnoreCase("paletli"))
                  gecen_sure += engel_gecme;
          }        
              }
          
          }
          if(i<0){
              JOptionPane.showMessageDialog(null,"Robot sınır alanının dışına çıkmıştır.");
              kontrol = 1;
              break;
          }
          }
          gecen_sure += (Math.abs( (double)(((i+1)/3)) - (double)((robot[0][1]/3))))/hiz;
          g.drawLine(robot[0][0],robot[0][1], robot[0][0],i);
          robot[0][1]=i+1;
          g.setColor(Color.green);
          g.fillOval(robot[0][0]-5,robot[0][1]-5, 10, 10);
          g.setColor(Color.magenta);
          }
          
          
          //robotun sola hareketi
          if(kontrol != 1){
          for (i = robot[0][0]; i >= robot[0][0]-(hareket[3]*30); i--) {
          if(engel_sayisi != 0){
              for (int j = 0; j < engel_sayisi; j++) {
          if(i==engel[j][0] && robot[0][1]==engel[j][1]){
              if(robot_tipi.equalsIgnoreCase("spider")){
              JOptionPane.showMessageDialog(null,"Robotun son konumu x:"+i/3+" y:"+robot[0][1]/3);
              kontrol=1;
              break;
              }
              if(robot_tipi.equalsIgnoreCase("tekerlekli") || robot_tipi.equalsIgnoreCase("paletli"))
                  gecen_sure += engel_gecme;
          }        
              }
          }
          if(i<0){
              JOptionPane.showMessageDialog(null,"Robot sınır alanının dışına çıkmıştır.");
              kontrol = 1;
              break;
          }
          }
          gecen_sure += (Math.abs((double)(((i+1)/3)) - (double)((robot[0][0]/3))))/hiz;
          g.drawLine(robot[0][0], robot[0][1], i, robot[0][1]);
          robot[0][0]=i+1;
          } 
          g.setColor(Color.black);
          g.fillOval(robot[0][0]-5,robot[0][1]-5, 10, 10);
          JOptionPane.showMessageDialog(null,"Robot hedefe "+gecen_sure+"sn'de ulaşmıştır.");
     
           
        }
        public void problem2(Graphics g,String robot_tipi,int[] hareket,int[][] robot,int kol_uzunlugu){
            g.setColor(Color.magenta);
            double gecen_sure=0;
            int kontrol=0,i;
            
            //ileri hareketi
            if(kol_uzunlugu>=hareket[0]){
            for (i = robot[0][1]; i <= robot[0][1]+(hareket[0]*30); i++) {
          if(i>600){
              JOptionPane.showMessageDialog(null,"Robot sınır alanının dışına çıkmıştır.");
              kontrol = 1;
              break;
          }
          }
          gecen_sure += (Math.abs((double)((robot[0][1]/3)) - (double)((i/3))))/hiz;
          g.drawLine(robot[0][0],robot[0][1], robot[0][0],i);
          robot[0][1]=i-1;
          g.setColor(Color.green);
          g.fillOval(robot[0][0]-5,robot[0][1]-5, 10, 10);
          g.setColor(Color.magenta);
            }
           
          //robutun sağa hareketi  
          if(kol_uzunlugu>=hareket[1]){
          if(kontrol != 1){
          for (i = robot[0][0]; i <= robot[0][0]+(hareket[1]*30); i++) {
          if(i>600){
              JOptionPane.showMessageDialog(null,"Robot sınır alanının dışına çıkmıştır.");
              kontrol = 1;
              break;
          }
          }
          gecen_sure += (Math.abs((double)((robot[0][0]/3)) - (double)((i/3))))/hiz;
          g.drawLine(robot[0][0], robot[0][1], i, robot[0][1]);
          robot[0][0]=i-1;
          g.setColor(Color.green);
          g.fillOval(robot[0][0]-5,robot[0][1]-5, 10, 10);
          g.setColor(Color.magenta);
          }    
          }
          
          //robotun geri hareketi
          if(kol_uzunlugu>=hareket[2]){
          if(kontrol != 1){
          for (i = robot[0][1]; i >= robot[0][1]-(hareket[2]*30); i--) {
          if(i<0){
              JOptionPane.showMessageDialog(null,"Robot sınır alanının dışına çıkmıştır.");
              kontrol = 1;
              break;
          }
          }
          gecen_sure += (Math.abs( (double)(((i+1)/3)) - (double)((robot[0][1]/3))))/hiz;
          g.drawLine(robot[0][0],robot[0][1], robot[0][0],i);
          robot[0][1]=i+1;
          g.setColor(Color.green);
          g.fillOval(robot[0][0]-5,robot[0][1]-5, 10, 10);
          g.setColor(Color.magenta);
          }    
          }
          
          //robotun sola hareketi
          if(kol_uzunlugu>=hareket[3]){
          if(kontrol != 1){
          for (i = robot[0][0]; i >= robot[0][0]-(hareket[3]*30); i--) {
          if(i<0){
              JOptionPane.showMessageDialog(null,"Robot sınır alanının dışına çıkmıştır.");
              kontrol = 1;
              break;
          }
          }
          gecen_sure += (Math.abs((double)(((i+1)/3)) - (double)((robot[0][0]/3))))/hiz;
          g.drawLine(robot[0][0], robot[0][1], i, robot[0][1]);
          robot[0][0]=i+1;
          }     
          }
          g.setColor(Color.black);
          g.fillOval(robot[0][0]-5,robot[0][1]-5, 10, 10);
          
          
          JOptionPane.showMessageDialog(null,"Robotun hedefe ulaşması "+gecen_sure+"sn sürdü.");
          
          
          
          
          
        }
        public void problem3(Graphics g,String robot_tipi,int[] hareket,int[][] robot,int[][] engel,int engel_sayisi,double engel_gecme,int kol_uzunlugu,int[] kol_hareketi){
        g.setColor(Color.magenta);
          int kontrol = 0,i;
          double gecen_sure=0;
          

          //robotun ileri hareketi
          for (i = robot[0][1]; i <= robot[0][1]+(hareket[0]*30); i++) {
          if(engel_sayisi != 0){
          for (int j = 0; j < engel_sayisi; j++) {
           if(i==engel[j][1] && robot[0][0]==engel[j][0]){
              if(robot_tipi.equalsIgnoreCase("spider")){
              JOptionPane.showMessageDialog(null,"Robotun son konumu x:"+robot[0][0]/3+" y:"+i/3);
              kontrol=1;
              break;
              }
              if(robot_tipi.equalsIgnoreCase("tekerlekli") || robot_tipi.equalsIgnoreCase("paletli"))
                  gecen_sure += engel_gecme;
          }       
              }
              }
          if(i>600){
              JOptionPane.showMessageDialog(null,"Robot sınır alanının dışına çıkmıştır.");
              kontrol = 1;
              break;
          }
          }
          gecen_sure += (Math.abs((double)((robot[0][1]/3)) - (double)((i/3))))/hiz;
          g.drawLine(robot[0][0],robot[0][1], robot[0][0],i);
          robot[0][1]=i-1;
          g.setColor(Color.green);
          g.fillOval(robot[0][0]-5,robot[0][1]-5, 10, 10);
          g.setColor(Color.magenta);
          
          
          
          
          //robotun sağa hareketi
          if(kontrol != 1){
          for (i = robot[0][0]; i <= robot[0][0]+(hareket[1]*30); i++) {
          if(engel_sayisi != 0){
              for (int j = 0; j < engel_sayisi; j++) {
          if(i==engel[j][0] && robot[0][1]==engel[j][1]){
              if(robot_tipi.equalsIgnoreCase("spider")){
              JOptionPane.showMessageDialog(null,"Robotun son konumu x:"+i/3+" y:"+robot[0][1]/3);
              kontrol=1;
              break;
              }
              if(robot_tipi.equalsIgnoreCase("tekerlekli") || robot_tipi.equalsIgnoreCase("paletli"))
                  gecen_sure += engel_gecme;
          }       
              }
         
          }
          if(i>600){
              JOptionPane.showMessageDialog(null,"Robot sınır alanının dışına çıkmıştır.");
              kontrol = 1;
              break;
          }
          }
          gecen_sure += (Math.abs((double)((robot[0][0]/3)) - (double)((i/3))))/hiz;
          g.drawLine(robot[0][0], robot[0][1], i, robot[0][1]);
          robot[0][0]=i-1;
          g.setColor(Color.green);
          g.fillOval(robot[0][0]-5,robot[0][1]-5, 10, 10);
          g.setColor(Color.magenta);
          }
          



          //robotun geri hareketi
          if(kontrol != 1){
          for (i = robot[0][1]; i >= robot[0][1]-(hareket[2]*30); i--) {
          if(engel_sayisi != 0){
              for (int j = 0; j < engel_sayisi; j++) {
          if(i==engel[j][1] && robot[0][0]==engel[j][0]){
              if(robot_tipi.equalsIgnoreCase("spider")){
              JOptionPane.showMessageDialog(null,"Robotun son konumu x:"+robot[0][0]/3+" y:"+i/3);
              kontrol=1;
              break;
              }
              if(robot_tipi.equalsIgnoreCase("tekerlekli") || robot_tipi.equalsIgnoreCase("paletli"))
                  gecen_sure += engel_gecme;
          }        
              }
          
          }
          if(i<0){
              JOptionPane.showMessageDialog(null,"Robot sınır alanının dışına çıkmıştır.");
              kontrol = 1;
              break;
          }
          }
          gecen_sure += (Math.abs( (double)(((i+1)/3)) - (double)((robot[0][1]/3))))/hiz;
          g.drawLine(robot[0][0],robot[0][1], robot[0][0],i);
          robot[0][1]=i+1;
          g.setColor(Color.green);
          g.fillOval(robot[0][0]-5,robot[0][1]-5, 10, 10);
          g.setColor(Color.magenta);
          }
          
          
          //robotun sola hareketi
          if(kontrol != 1){
          for (i = robot[0][0]; i >= robot[0][0]-(hareket[3]*30); i--) {
          if(engel_sayisi != 0){
              for (int j = 0; j < engel_sayisi; j++) {
          if(i==engel[j][0] && robot[0][1]==engel[j][1]){
              if(robot_tipi.equalsIgnoreCase("spider")){
              JOptionPane.showMessageDialog(null,"Robotun son konumu x:"+i/3+" y:"+robot[0][1]/3);
              kontrol=1;
              break;
              }
              if(robot_tipi.equalsIgnoreCase("tekerlekli") || robot_tipi.equalsIgnoreCase("paletli"))
                  gecen_sure += engel_gecme;
          }        
              }
          }
          if(i<0){
              JOptionPane.showMessageDialog(null,"Robot sınır alanının dışına çıkmıştır.");
              kontrol = 1;
              break;
          }
          }
          gecen_sure += (Math.abs((double)(((i+1)/3)) - (double)((robot[0][0]/3))))/hiz;
          g.drawLine(robot[0][0], robot[0][1], i, robot[0][1]);
          robot[0][0]=i+1;
          }
          

//robotun kol hareketi
          
            g.setColor(Color.magenta);
        
            kontrol=0;i=0;
            
            //ileri hareketi
            if(kol_uzunlugu>=hareket[0]){
            for (i = robot[0][1]; i <= robot[0][1]+(hareket[0]*30); i++) {
          if(i>600){
              JOptionPane.showMessageDialog(null,"Robot sınır alanının dışına çıkmıştır.");
              kontrol = 1;
              break;
          }
          }
          gecen_sure += (Math.abs((double)((robot[0][1]/3)) - (double)((i/3))))/hiz;
          g.drawLine(robot[0][0],robot[0][1], robot[0][0],i);
          robot[0][1]=i-1;
          g.setColor(Color.green);
          g.fillOval(robot[0][0]-5,robot[0][1]-5, 10, 10);
          g.setColor(Color.magenta);
            }
           
          //robutun sağa hareketi  
          if(kol_uzunlugu>=hareket[1]){
          if(kontrol != 1){
          for (i = robot[0][0]; i <= robot[0][0]+(hareket[1]*30); i++) {
          if(i>600){
              JOptionPane.showMessageDialog(null,"Robot sınır alanının dışına çıkmıştır.");
              kontrol = 1;
              break;
          }
          }
          gecen_sure += (Math.abs((double)((robot[0][0]/3)) - (double)((i/3))))/hiz;
          g.drawLine(robot[0][0], robot[0][1], i, robot[0][1]);
          robot[0][0]=i-1;
          g.setColor(Color.green);
          g.fillOval(robot[0][0]-5,robot[0][1]-5, 10, 10);
          g.setColor(Color.magenta);
          }    
          }
          
          //robotun geri hareketi
          if(kol_uzunlugu>=hareket[2]){
          if(kontrol != 1){
          for (i = robot[0][1]; i >= robot[0][1]-(hareket[2]*30); i--) {
          if(i<0){
              JOptionPane.showMessageDialog(null,"Robot sınır alanının dışına çıkmıştır.");
              kontrol = 1;
              break;
          }
          }
          gecen_sure += (Math.abs( (double)(((i+1)/3)) - (double)((robot[0][1]/3))))/hiz;
          g.drawLine(robot[0][0],robot[0][1], robot[0][0],i);
          robot[0][1]=i+1;
          g.setColor(Color.green);
          g.fillOval(robot[0][0]-5,robot[0][1]-5, 10, 10);
          g.setColor(Color.magenta);
          }    
          }
          
          //robotun sola hareketi
          if(kol_uzunlugu>=hareket[3]){
          if(kontrol != 1){
          for (i = robot[0][0]; i >= robot[0][0]-(hareket[3]*30); i--) {
          if(i<0){
              JOptionPane.showMessageDialog(null,"Robot sınır alanının dışına çıkmıştır.");
              kontrol = 1;
              break;
          }
          }
          gecen_sure += (Math.abs((double)(((i+1)/3)) - (double)((robot[0][0]/3))))/hiz;
          g.drawLine(robot[0][0], robot[0][1], i, robot[0][1]);
          robot[0][0]=i+1;
          }     
          }
          g.setColor(Color.black);
          g.fillOval(robot[0][0]-5,robot[0][1]-5, 10, 10);
          
          
          JOptionPane.showMessageDialog(null,"Robotun hedefe ulaşması "+gecen_sure+"sn sürdü.");
          
          
          
          
        }
   }


}
