package Tesseract;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program 
{
    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    public ArrayList<Veri> VeriGetir() {
        ArrayList<Veri> cikti = new ArrayList<Veri>();
        try
        {
            statement = con.createStatement();
            String sorgu = "Select * From fistabani";/* Buraya Sorgu Gelecek */
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next())
            {
                int fis = rs.getInt("fisno");
                String companyName = rs.getString("companyname");
                String tarih = rs.getString("tarih");
                String toplamfiyat = rs.getString("toplam");
                String urunkdvfiyat = rs.getString("urunkdvfiyat"); 
                cikti.add(new Veri(fis, companyName, tarih, urunkdvfiyat, toplamfiyat));
            }
            //con.close();
            return cikti;
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);     
            return null;
        }
    }
    
    public ArrayList<Veri> VeriGuncelAra(String Company, String Date) {
        ArrayList<Veri> cikti = new ArrayList<Veri>();
        try
        {
            statement = con.createStatement();
            String sorgu = "select * from fistabani where companyname='" + Company + "' and tarih='" + Date + "'";/* Buraya Sorgu Gelecek */
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next())
            {
                int fis = rs.getInt("fisno");
                String companyName = rs.getString("companyname");
                String tarih = rs.getString("tarih");
                String toplamfiyat = rs.getString("toplam");
                String UrunKDVFiyat = rs.getString("urunkdvfiyat"); 
                cikti.add(new Veri(fis, companyName, tarih, UrunKDVFiyat, toplamfiyat));
            }
            //con.close();
            return cikti;
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);     
            return null;
        }
    }
    
    public void veriSil(int fisno) {
        String sorgu = "Delete from fistabani where id = ?"; //Silme Sorgusu
 
        try
        {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(fisno, fisno);    
            preparedStatement.executeUpdate();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    
    public void VeriEkle(String compname, String tarih, int fis, String urunkdvfiyat, String top) {
        String sorgu = "INSERT INTO `fistabani` (`companyname`, `tarih`, `fisno`, `urunkdvfiyat`, `toplam`) VALUES ('"+ compname +"', '"+ tarih +"', '"+ fis +"', '"+ urunkdvfiyat +"', '"+ top +"')";    
        try{
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.executeUpdate();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean girisYap(String kullanici_adi, String parola) {
        String sorgu = "Select * From admin where KullaniciAdi = ? and Sifre = ?";

        try 
        {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, kullanici_adi);
            preparedStatement.setString(2, parola);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
    public Program() {
        String url = "jdbc:mysql://" + DB.host + ":" + DB.port + "/" + DB.db_ismi+ "?useUnicode=true&characterEncoding=utf8";
        
        try
        {    
            Class.forName("com.mysql.jdbc.Driver");   
        }
        catch (ClassNotFoundException ex) 
        {
            System.out.println("Driver Bulunamadı....");
        }
        try 
        {
            con = DriverManager.getConnection(url, DB.kullanici_adi, DB.parola);
            System.out.println("Bağlantı Başarılı. Driver");    
        }
        catch (SQLException ex) 
        {
            System.out.println("Bağlantı Başarısız...");
            ex.printStackTrace();
        }
    }   
}