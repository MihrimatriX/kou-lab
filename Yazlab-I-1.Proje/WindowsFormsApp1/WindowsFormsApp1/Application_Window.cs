using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using MySql.Data.MySqlClient;
using MySql.Data;

namespace WindowsFormsApp1
{
    public partial class Application_Window : Form
    {
        public Application_Window()
        {
            InitializeComponent();
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void Exit1_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void Application_Window_Load(object sender, EventArgs e)
        {
            Book_Image17.Load("http://images.amazon.com/images/P/0684845989.01.THUMBZZZ.jpg");
            Book_Image1.Load("http://images.amazon.com/images/P/0684845989.01.THUMBZZZ.jpg");
            Book_Image3.Load("http://images.amazon.com/images/P/0684845989.01.THUMBZZZ.jpg");
            Book_Image7.Load("http://images.amazon.com/images/P/0684845989.01.THUMBZZZ.jpg");
            
            foreach (Control panel in Panel2.Controls)
            {
                
                for (int i = 1; i < 25; i++)
                {
                    if (panel.Name.Equals("Book" + i))
                    {
                       foreach (Control c in panel.Controls)
                        {
                            if(c.Name.Equals("Book_Title" + i)) // KITAP BASLIKLARI
                            {
                                c.Text = "Book Title " + i;
                            }
                            /*if(c.Name.Equals("Book_Image"+i))
                            {
                                c.Load("http://images.amazon.com/images/P/0684845989.01.THUMBZZZ.jpg")
                            }*/
                            
                        }
                        /*foreach (PictureBox picture in panel.Controls)
                        {

                            if (picture.Name.Equals("Book_Image" + i))
                            {
                                MessageBox.Show("bom");
                                picture.Load("http://images.amazon.com/images/P/0684845989.01.THUMBZZZ.jpg");
                            }

                        }*/

                    }
                    
                    
                }
            }

        }

        int mouseX, mouseY;
        bool mouseDown;
        private void Application_Window_MouseDown(object sender, MouseEventArgs e)
        {
            mouseDown = true;
        }

        private void Application_Window_MouseMove(object sender, MouseEventArgs e)
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

        private void label7_Click(object sender, EventArgs e)
        {
            Book_Information_Window BIW = new Book_Information_Window();
            BIW.SetDesktopLocation(this.Location.X, this.Location.Y + 85);
            BIW.Show();
        }

        private void pictureBox8_Click(object sender, EventArgs e)
        {

        }

        private void pictureBox7_Click(object sender, EventArgs e)
        {

        }

        private void Most_Rated_Click(object sender, EventArgs e)
        {
            Most_Rated.BackColor = Color.DarkGoldenrod;
            Most_Rated_Background.BackColor = Color.DarkGoldenrod;

            Most_Voted.BackColor = Color.Goldenrod;
            Most_Voted_Background.BackColor = Color.Goldenrod;

            Recomended.BackColor = Color.Goldenrod;
            Recomended_Background.BackColor = Color.Goldenrod;

            Recent.BackColor = Color.Goldenrod;
            Recent_Background.BackColor = Color.Goldenrod;
        }

        private void Most_Rated_Background_Paint(object sender, PaintEventArgs e)
        {
            
        }

        private void Most_Rated_Background_Click(object sender, EventArgs e)
        {
            Most_Rated_Click(sender, e);
        }

        private void Most_Voted_Click(object sender, EventArgs e)
        {
            Most_Rated.BackColor = Color.Goldenrod;
            Most_Rated_Background.BackColor = Color.Goldenrod;

            Most_Voted.BackColor = Color.DarkGoldenrod;
            Most_Voted_Background.BackColor = Color.DarkGoldenrod;

            Recomended.BackColor = Color.Goldenrod;
            Recomended_Background.BackColor = Color.Goldenrod;

            Recent.BackColor = Color.Goldenrod;
            Recent_Background.BackColor = Color.Goldenrod;
        }

        private void Most_Voted_Background_Click(object sender, EventArgs e)
        {
            Most_Voted_Click(sender, e);
        }

        private void Recomended_Click(object sender, EventArgs e)
        {
            Most_Rated.BackColor = Color.Goldenrod;
            Most_Rated_Background.BackColor = Color.Goldenrod;

            Most_Voted.BackColor = Color.Goldenrod;
            Most_Voted_Background.BackColor = Color.Goldenrod;

            Recomended.BackColor = Color.DarkGoldenrod;
            Recomended_Background.BackColor = Color.DarkGoldenrod;

            Recent.BackColor = Color.Goldenrod;
            Recent_Background.BackColor = Color.Goldenrod;
        }

        private void Recomended_Background_Click(object sender, EventArgs e)
        {
            Recomended_Click(sender, e);
        }

        private void Recent_Click(object sender, EventArgs e)
        {
            Most_Rated.BackColor = Color.Goldenrod;
            Most_Rated_Background.BackColor = Color.Goldenrod;

            Most_Voted.BackColor = Color.Goldenrod;
            Most_Voted_Background.BackColor = Color.Goldenrod;

            Recomended.BackColor = Color.Goldenrod;
            Recomended_Background.BackColor = Color.Goldenrod;

            Recent.BackColor = Color.DarkGoldenrod;
            Recent_Background.BackColor = Color.DarkGoldenrod;
        }

        private void Recent_Background_Click(object sender, EventArgs e)
        {
            Recent_Click(sender, e);
        }

        private void Application_Window_MouseUp(object sender, MouseEventArgs e)
        {
            mouseDown = false;
        }
    }
}
