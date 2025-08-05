using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace pdfreader
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //axAcroPDF1.LoadFile("D:\\HNK\\PowerPointTest.pdf");
            axAcroPDF1.LoadFile("pdfDosyalar\\PowerPointTest.pdf");
        }

        private void açToolStripMenuItem_Click(object sender, EventArgs e)
        {
            
            OpenFileDialog dosya = new OpenFileDialog();
            dosya.Filter = "PDF Dosyaları |*.pdf";
            dosya.ShowDialog();
            if(dosya.FileName!="")
            {
                axAcroPDF1.LoadFile(dosya.FileName);
            }
        }

        private void kapatToolStripMenuItem_Click(object sender, EventArgs e)
        {
            axAcroPDF1.Dispose();
            this.Close();
        }
    }
}
