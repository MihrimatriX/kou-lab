using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using MySql.Data;
using MySql.Data.MySqlClient;

namespace WindowsFormsApp1
{
    public partial class Login_Window : Form
    {
        string constring = $"datasource=127.0.0.1;port=3306;username=root;password=;database=prolab;";

        public Login_Window()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void bindingNavigator1_RefreshItems(object sender, EventArgs e)
        {

        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void trackBar1_Scroll(object sender, EventArgs e)
        {

        }

        private void exitButton_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {

            //*************           SİL          **************      
            Application_Window AW = new Application_Window();
            this.Hide();
            AW.Show();
            //*************           SİL          **************
        }

        private void label2_Click(object sender, EventArgs e)
        {
            this.Hide();
            Registeration_Window RW = new Registeration_Window();
            RW.Show();
        }

        private void textBox1_TextChanged_1(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged_1(object sender, EventArgs e)
        {

        }

        private void pictureBox4_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox4_TextChanged(object sender, EventArgs e)
        {

        }

        private void label2_Click_1(object sender, EventArgs e)
        {
            FakeID_Label.Hide();
            UserID_box.Select();


        }

        private void Fake_Password_Label_Click(object sender, EventArgs e)
        {
            Fake_Password_Label.Hide();
            Password_Box.Select();



        }

        int mouseX, mouseY;
        bool mouseDown;

        private void Login_Window_MouseMove(object sender, MouseEventArgs e)
        {
            if (!mouseDown)
            {
                mouseX = MousePosition.X - this.Location.X;
                mouseY = MousePosition.Y - this.Location.Y;
            }
            else
            {
                this.SetDesktopLocation(MousePosition.X-mouseX,MousePosition.Y-mouseY);
            }
        }

        private void Login_Window_MouseUp(object sender, MouseEventArgs e)
        {
            mouseDown = false;
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void UserID_box_TextChanged(object sender, EventArgs e)
        {

        }

        private void Login_Window_MouseDown(object sender, MouseEventArgs e)
        {
            mouseDown = true;
        }
    }
}
