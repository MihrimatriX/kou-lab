using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using System.Diagnostics;
using System.Globalization;
using MySql.Data.MySqlClient;

namespace WindowsFormsApp1
{
    
    public partial class Registeration_Window : Form
    {
        List<string> cultureList = new List<string>(); //DIL PAKETLERINDEN ULKE ISIMLERINI CEKER
        CultureInfo[] cultures = CultureInfo.GetCultures(CultureTypes.SpecificCultures);
        RegionInfo region;
        public Registeration_Window()
        {
            InitializeComponent();
        }

        private void Registeration_Window_Load(object sender, EventArgs e)
        {
            this.SetDesktopLocation(MousePosition.X - 150, MousePosition.Y - 100);

            foreach (CultureInfo culture in cultures)
            {
                region = new RegionInfo(culture.LCID);
                if (!(cultureList.Contains(region.EnglishName)))
                {
                    cultureList.Add(region.EnglishName);
                    Country_Box.Items.Add(region.EnglishName);
                }
            }
            for(int i = 1; i <= 120; i++)
            {
                Age_Box.Items.Add(i);
            }



        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {

            bool userInput = true;

            if (User_ID_Box.Text.Length < 6)
            {
                ID_Error.Text = "* UserID must be at least 6 characters.";
                ID_Error.Show();
                userInput = false;
            }
            else ID_Error.Hide();

            if (Password_Box1.Text.Length < 6)
            {
                Password_Error.Text = "* Password must be at least 6 characters.";
                Password_Error.Show();
                userInput = false;
            }
            else if (!Password_Box1.Text.Equals(Password_Box2.Text))
            {
                Password_Error.Text = "* Passwords are incorrect.";
                Password_Error.Show();
                userInput = false;
            }
            else Password_Error.Hide();

            if (Country_Box.Text.Equals("Country") || Country_Box.Text.Length<2)
            {
                Location_Error.Text = "* Invaled country name.";
                Location_Error.Show();
                userInput = false;
            }
            else if (City_Box.Text.Length < 2)
            {
                Location_Error.Text = "* Invaled City name.";
                Location_Error.Show();
                userInput = false;
            }
            else if (! int.TryParse(Age_Box.Text, out int Age)) //Girilen Deger Rakam Degilse
            {

                Location_Error.Text = "* Invaled Age Input.";
                Location_Error.Show();
                userInput = false;
            }
            else if(Age<1 || Age>120)
            {
                Location_Error.Text = "* Invaled Age Input.";
                Location_Error.Show();
                userInput = false;
            }
            else Location_Error.Hide();


            MySqlConnection baglanti = new MySqlConnection("server=localhost;user id=root;database=yaz_lab");

            bool durumNee = false;
            baglanti.Open();
            if (baglanti.State != ConnectionState.Closed)
            {
                string sql = "SELECT * FROM `kullanicilar` WHERE `isim` = '" + User_ID_Box.Text + "' LIMIT 1";
                MySqlCommand cmd = new MySqlCommand(sql, baglanti);
                MySqlDataReader rdr = cmd.ExecuteReader();
                int x = 0;
                if (rdr.Read())
                {
                    x++;
                }
                rdr.Close();
                baglanti.Close();
                if (x != 0)
                {
                    durumNee = true;
                }
            }
            else
            {
                MessageBox.Show("Bağlantı yok, kayıt işlemi gerçekleşemez !");
                return;
            }
            if (durumNee)
            {
                MessageBox.Show("Böyle bir kullanıcı var !");
                return;
            }
            baglanti.Open();
            if (baglanti.State != ConnectionState.Closed)
            {
                MySqlCommand komutVer = baglanti.CreateCommand();
                komutVer.CommandText = "INSERT INTO kullanicilar(isim, sifre, location) VALUES(@isim, @sifre, @location)";
                komutVer.Parameters.AddWithValue("@isim", User_ID_Box.Text);
                komutVer.Parameters.AddWithValue("@sifre", Password_Box1.Text);
                komutVer.Parameters.AddWithValue("@location",City_Box.Text);
                komutVer.ExecuteNonQuery();
                MessageBox.Show("Kayıt olundu !");
            }
            else
            {
                MessageBox.Show("Bağlantı yok, kayıt işlemi gerçekleşemez !");
            }
            baglanti.Close();




        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void pictureBox3_Click(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
           
        }

        private void Exit1_Click(object sender, EventArgs e)
        {
            this.Hide();
            Login_Window LW = new Login_Window();
            LW.Show();
        }

        private void pictureBox4_Click(object sender, EventArgs e)
        {

        }

        private void comboBox2_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void FakeID_Label_Click(object sender, EventArgs e)
        {
            FakeID_Label.Hide();
            User_ID_Box.Select();

        }

        private void textBox1_TextChanged_1(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {
            Fake_Password1.Hide();
            Password_Box1.Select();
        }

        private void Fake_Password2_Click(object sender, EventArgs e)
        {
            Fake_Password2.Hide();
            Password_Box2.Select();
        }

        private void Fake_City_Box_Click(object sender, EventArgs e)
        {
            Fake_City_Box.Hide();
            City_Box.Select();
        }
        int mouseX, mouseY;
        bool mouseDown;
        private void Registeration_Window_MouseDown(object sender, MouseEventArgs e)
        {
            mouseDown = true;
        }

        private void Registeration_Window_MouseMove(object sender, MouseEventArgs e)
        {
            if (!mouseDown)
            {
                mouseX = MousePosition.X - this.Location.X;
                mouseY = MousePosition.Y - this.Location.Y;
            }
            else
            {

                this.SetDesktopLocation(MousePosition.X - mouseX, MousePosition.Y - mouseY);
            }
        }

        private void label1_Click_1(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void Registeration_Window_MouseUp(object sender, MouseEventArgs e)
        {
            mouseDown = false;
        }
    }
}
