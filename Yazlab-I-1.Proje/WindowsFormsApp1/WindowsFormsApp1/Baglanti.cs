using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public class Baglanti
    {
        /*

        private static string sIp = "127.0.0.1"; // Sunucu IP Adresi
        private static string sDB = "kodsql"; // Veritabanı
        private static string sKA = "root"; // Kullanıcı Adı
        private static string sSifre = ""; // Şifre

        */

        public MySqlConnection connect;
        public string server;
        public string database;
        public string uid;
        public string password;

        public Baglanti()
        {
            server = "127.0.0.1";
            database = "yazlab";
            uid = "root";
            password = "";

            string connectString;
            connectString = $"SERVER={server};DATABASE={database};UID={uid};PASSWORD={password};";

            connect = new MySqlConnection(connectString);

            connect.Open();
            if(connect.State != System.Data.ConnectionState.Closed)
            {
                //MessageBox.Show("Başarılı");
                Console.WriteLine("Bağlantı başarılı");
            }
            else
            {
                //MessageBox.Show("Başarısız");
                Console.WriteLine("Başarısız");
            }

            connect.Close();
        }
                
        public bool OpenConnection()
        {
            try
            {
                connect.Open();
                return true;
            }
            catch (MySqlException ex)
            {
                switch (ex.Number)
                {
                    case 0:
                        MessageBox.Show("Server Bağlantı Hatası");
                        break;
                    case 1045:
                        MessageBox.Show("Server Kullanıcı Adı ya da Parolası Hatalı");
                        break;
                }
                return false;
            }
        }
    }
}
