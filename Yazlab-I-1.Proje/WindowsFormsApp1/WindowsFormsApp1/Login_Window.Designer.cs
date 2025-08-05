using MySql.Data;
using MySql.Data.MySqlClient;

namespace WindowsFormsApp1
{
    partial class Login_Window
    {
        /// <summary>
        ///Gerekli tasarımcı değişkeni.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///Kullanılan tüm kaynakları temizleyin.
        /// </summary>
        ///<param name="disposing">yönetilen kaynaklar dispose edilmeliyse doğru; aksi halde yanlış.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer üretilen kod

        /// <summary>
        /// Tasarımcı desteği için gerekli metot - bu metodun 
        ///içeriğini kod düzenleyici ile değiştirmeyin.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Login_Window));
            this.flowLayoutPanel1 = new System.Windows.Forms.FlowLayoutPanel();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.label1 = new System.Windows.Forms.Label();
            this.LOGIN = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.I_Dont_Have_An_Acc = new System.Windows.Forms.Label();
            this.Password_Box = new System.Windows.Forms.TextBox();
            this.UserID_box = new System.Windows.Forms.TextBox();
            this.Exit1 = new System.Windows.Forms.PictureBox();
            this.pictureBox3 = new System.Windows.Forms.PictureBox();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.FakeID_Label = new System.Windows.Forms.Label();
            this.Fake_Password_Label = new System.Windows.Forms.Label();
            this.flowLayoutPanel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.Exit1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            this.SuspendLayout();
            // 
            // flowLayoutPanel1
            // 
            this.flowLayoutPanel1.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.flowLayoutPanel1.Controls.Add(this.pictureBox1);
            this.flowLayoutPanel1.Controls.Add(this.label1);
            this.flowLayoutPanel1.Dock = System.Windows.Forms.DockStyle.Left;
            this.flowLayoutPanel1.Location = new System.Drawing.Point(0, 0);
            this.flowLayoutPanel1.Name = "flowLayoutPanel1";
            this.flowLayoutPanel1.Size = new System.Drawing.Size(200, 300);
            this.flowLayoutPanel1.TabIndex = 1;
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackgroundImage = global::WindowsFormsApp1.Properties.Resources.icons8_Open_Book_100px_2;
            this.pictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.pictureBox1.Location = new System.Drawing.Point(3, 3);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(200, 150);
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            this.pictureBox1.Click += new System.EventHandler(this.pictureBox1_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Trajan Pro", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.label1.Location = new System.Drawing.Point(3, 156);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(191, 27);
            this.label1.TabIndex = 3;
            this.label1.Text = "Ali Oğuzhan T.";
            // 
            // LOGIN
            // 
            this.LOGIN.AutoSize = true;
            this.LOGIN.Font = new System.Drawing.Font("Trajan Pro", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LOGIN.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.LOGIN.Location = new System.Drawing.Point(342, 0);
            this.LOGIN.Name = "LOGIN";
            this.LOGIN.Size = new System.Drawing.Size(118, 34);
            this.LOGIN.TabIndex = 2;
            this.LOGIN.Text = "LOGIN";
            this.LOGIN.Click += new System.EventHandler(this.label1_Click);
            // 
            // button1
            // 
            this.button1.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.button1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.button1.Cursor = System.Windows.Forms.Cursors.Hand;
            this.button1.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.button1.Font = new System.Drawing.Font("Trajan Pro", 12F, System.Drawing.FontStyle.Bold);
            this.button1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.button1.Location = new System.Drawing.Point(285, 180);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(233, 31);
            this.button1.TabIndex = 8;
            this.button1.Text = "ACCEPT";
            this.button1.UseMnemonic = false;
            this.button1.UseVisualStyleBackColor = false;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // I_Dont_Have_An_Acc
            // 
            this.I_Dont_Have_An_Acc.AutoSize = true;
            this.I_Dont_Have_An_Acc.Cursor = System.Windows.Forms.Cursors.Hand;
            this.I_Dont_Have_An_Acc.Font = new System.Drawing.Font("Trajan Pro", 8.25F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.I_Dont_Have_An_Acc.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.I_Dont_Have_An_Acc.Location = new System.Drawing.Point(288, 214);
            this.I_Dont_Have_An_Acc.Name = "I_Dont_Have_An_Acc";
            this.I_Dont_Have_An_Acc.Size = new System.Drawing.Size(161, 14);
            this.I_Dont_Have_An_Acc.TabIndex = 9;
            this.I_Dont_Have_An_Acc.Text = "I dont have an account.";
            this.I_Dont_Have_An_Acc.Click += new System.EventHandler(this.label2_Click);
            // 
            // Password_Box
            // 
            this.Password_Box.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.Password_Box.Font = new System.Drawing.Font("Trebuchet MS", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Password_Box.Location = new System.Drawing.Point(318, 127);
            this.Password_Box.MaxLength = 16;
            this.Password_Box.Name = "Password_Box";
            this.Password_Box.Size = new System.Drawing.Size(200, 26);
            this.Password_Box.TabIndex = 16;
            this.Password_Box.UseSystemPasswordChar = true;
            this.Password_Box.TextChanged += new System.EventHandler(this.textBox3_TextChanged);
            // 
            // UserID_box
            // 
            this.UserID_box.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.UserID_box.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.UserID_box.Location = new System.Drawing.Point(318, 74);
            this.UserID_box.MaxLength = 16;
            this.UserID_box.Name = "UserID_box";
            this.UserID_box.Size = new System.Drawing.Size(200, 26);
            this.UserID_box.TabIndex = 25;
            this.UserID_box.TextChanged += new System.EventHandler(this.UserID_box_TextChanged);
            // 
            // Exit1
            // 
            this.Exit1.BackgroundImage = global::WindowsFormsApp1.Properties.Resources.icons8_Close_Window_96px;
            this.Exit1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.Exit1.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Exit1.Location = new System.Drawing.Point(580, 0);
            this.Exit1.Name = "Exit1";
            this.Exit1.Size = new System.Drawing.Size(20, 20);
            this.Exit1.TabIndex = 10;
            this.Exit1.TabStop = false;
            this.Exit1.Click += new System.EventHandler(this.pictureBox4_Click);
            // 
            // pictureBox3
            // 
            this.pictureBox3.BackgroundImage = global::WindowsFormsApp1.Properties.Resources.icons8_Lock_104px_2;
            this.pictureBox3.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.pictureBox3.Location = new System.Drawing.Point(286, 127);
            this.pictureBox3.Name = "pictureBox3";
            this.pictureBox3.Size = new System.Drawing.Size(26, 26);
            this.pictureBox3.TabIndex = 7;
            this.pictureBox3.TabStop = false;
            // 
            // pictureBox2
            // 
            this.pictureBox2.BackgroundImage = global::WindowsFormsApp1.Properties.Resources.icons8_User_Male_104px_1;
            this.pictureBox2.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.pictureBox2.Location = new System.Drawing.Point(285, 74);
            this.pictureBox2.Name = "pictureBox2";
            this.pictureBox2.Size = new System.Drawing.Size(26, 26);
            this.pictureBox2.TabIndex = 6;
            this.pictureBox2.TabStop = false;
            this.pictureBox2.Click += new System.EventHandler(this.pictureBox2_Click);
            // 
            // FakeID_Label
            // 
            this.FakeID_Label.AutoSize = true;
            this.FakeID_Label.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.FakeID_Label.Cursor = System.Windows.Forms.Cursors.Hand;
            this.FakeID_Label.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold);
            this.FakeID_Label.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.FakeID_Label.Location = new System.Drawing.Point(324, 77);
            this.FakeID_Label.Name = "FakeID_Label";
            this.FakeID_Label.Size = new System.Drawing.Size(191, 19);
            this.FakeID_Label.TabIndex = 20;
            this.FakeID_Label.Text = "UserID                                 ";
            this.FakeID_Label.Click += new System.EventHandler(this.label2_Click_1);
            // 
            // Fake_Password_Label
            // 
            this.Fake_Password_Label.AutoSize = true;
            this.Fake_Password_Label.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.Fake_Password_Label.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Fake_Password_Label.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold);
            this.Fake_Password_Label.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Fake_Password_Label.Location = new System.Drawing.Point(323, 131);
            this.Fake_Password_Label.Name = "Fake_Password_Label";
            this.Fake_Password_Label.Size = new System.Drawing.Size(192, 19);
            this.Fake_Password_Label.TabIndex = 21;
            this.Fake_Password_Label.Text = "Password                              ";
            this.Fake_Password_Label.Click += new System.EventHandler(this.Fake_Password_Label_Click);
            // 
            // Login_Window
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(600, 300);
            this.Controls.Add(this.Fake_Password_Label);
            this.Controls.Add(this.FakeID_Label);
            this.Controls.Add(this.UserID_box);
            this.Controls.Add(this.Password_Box);
            this.Controls.Add(this.Exit1);
            this.Controls.Add(this.I_Dont_Have_An_Acc);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.pictureBox3);
            this.Controls.Add(this.pictureBox2);
            this.Controls.Add(this.flowLayoutPanel1);
            this.Controls.Add(this.LOGIN);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Login_Window";
            this.Opacity = 0.95D;
            this.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.Tag = "";
            this.Text = " ";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.MouseDown += new System.Windows.Forms.MouseEventHandler(this.Login_Window_MouseDown);
            this.MouseMove += new System.Windows.Forms.MouseEventHandler(this.Login_Window_MouseMove);
            this.MouseUp += new System.Windows.Forms.MouseEventHandler(this.Login_Window_MouseUp);
            this.flowLayoutPanel1.ResumeLayout(false);
            this.flowLayoutPanel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.Exit1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.FlowLayoutPanel flowLayoutPanel1;
        private System.Windows.Forms.Label LOGIN;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.PictureBox pictureBox2;
        private System.Windows.Forms.PictureBox pictureBox3;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label I_Dont_Have_An_Acc;
        private System.Windows.Forms.PictureBox Exit1;
        private System.Windows.Forms.TextBox Password_Box;
        private System.Windows.Forms.TextBox UserID_box;
        private System.Windows.Forms.Label FakeID_Label;
        private System.Windows.Forms.Label Fake_Password_Label;
    }
}

