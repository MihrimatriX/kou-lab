using MySql.Data;
using MySql.Data.MySqlClient;

namespace WindowsFormsApp1
{
    partial class Registeration_Window
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Registeration_Window));
            this.button1 = new System.Windows.Forms.Button();
            this.Password_Box1 = new System.Windows.Forms.TextBox();
            this.UserID_Box = new System.Windows.Forms.TextBox();
            this.LOGIN = new System.Windows.Forms.Label();
            this.Country_Box = new System.Windows.Forms.ComboBox();
            this.Password_Box2 = new System.Windows.Forms.TextBox();
            this.City_Box = new System.Windows.Forms.TextBox();
            this.pictureBox4 = new System.Windows.Forms.PictureBox();
            this.Exit1 = new System.Windows.Forms.PictureBox();
            this.pictureBox3 = new System.Windows.Forms.PictureBox();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.Age_Box = new System.Windows.Forms.ComboBox();
            this.TermsAndConditions = new System.Windows.Forms.CheckBox();
            this.User_ID_Box = new System.Windows.Forms.TextBox();
            this.FakeID_Label = new System.Windows.Forms.Label();
            this.Fake_Password1 = new System.Windows.Forms.Label();
            this.Fake_Password2 = new System.Windows.Forms.Label();
            this.Fake_City_Box = new System.Windows.Forms.Label();
            this.ID_Error = new System.Windows.Forms.Label();
            this.Password_Error = new System.Windows.Forms.Label();
            this.Location_Error = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.Exit1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.button1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.button1.Cursor = System.Windows.Forms.Cursors.Hand;
            this.button1.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.button1.Font = new System.Drawing.Font("Trajan Pro", 12F, System.Drawing.FontStyle.Bold);
            this.button1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.button1.Location = new System.Drawing.Point(32, 305);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(233, 31);
            this.button1.TabIndex = 17;
            this.button1.Text = "ACCEPT";
            this.button1.UseMnemonic = false;
            this.button1.UseVisualStyleBackColor = false;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // Password_Box1
            // 
            this.Password_Box1.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.Password_Box1.Font = new System.Drawing.Font("Trebuchet MS", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Password_Box1.Location = new System.Drawing.Point(65, 121);
            this.Password_Box1.MaxLength = 16;
            this.Password_Box1.Name = "Password_Box1";
            this.Password_Box1.Size = new System.Drawing.Size(200, 26);
            this.Password_Box1.TabIndex = 14;
            this.Password_Box1.UseSystemPasswordChar = true;
            this.Password_Box1.TextChanged += new System.EventHandler(this.textBox2_TextChanged);
            // 
            // UserID_Box
            // 
            this.UserID_Box.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.UserID_Box.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.UserID_Box.Location = new System.Drawing.Point(65, 64);
            this.UserID_Box.MaxLength = 25;
            this.UserID_Box.Name = "UserID_Box";
            this.UserID_Box.Size = new System.Drawing.Size(200, 26);
            this.UserID_Box.TabIndex = 13;
            this.UserID_Box.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // LOGIN
            // 
            this.LOGIN.AutoSize = true;
            this.LOGIN.Font = new System.Drawing.Font("Trajan Pro", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LOGIN.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.LOGIN.Location = new System.Drawing.Point(68, 0);
            this.LOGIN.Name = "LOGIN";
            this.LOGIN.Size = new System.Drawing.Size(160, 34);
            this.LOGIN.TabIndex = 12;
            this.LOGIN.Text = "REGISTER";
            // 
            // Country_Box
            // 
            this.Country_Box.AccessibleDescription = "";
            this.Country_Box.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.Country_Box.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.Country_Box.Font = new System.Drawing.Font("Mongolian Baiti", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.Country_Box.FormattingEnabled = true;
            this.Country_Box.Location = new System.Drawing.Point(65, 203);
            this.Country_Box.MaxLength = 30;
            this.Country_Box.Name = "Country_Box";
            this.Country_Box.Size = new System.Drawing.Size(200, 24);
            this.Country_Box.Sorted = true;
            this.Country_Box.TabIndex = 22;
            this.Country_Box.Text = "Country";
            this.Country_Box.SelectedIndexChanged += new System.EventHandler(this.comboBox1_SelectedIndexChanged);
            // 
            // Password_Box2
            // 
            this.Password_Box2.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.Password_Box2.Font = new System.Drawing.Font("Trebuchet MS", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Password_Box2.Location = new System.Drawing.Point(65, 153);
            this.Password_Box2.MaxLength = 16;
            this.Password_Box2.Name = "Password_Box2";
            this.Password_Box2.Size = new System.Drawing.Size(200, 26);
            this.Password_Box2.TabIndex = 23;
            this.Password_Box2.UseSystemPasswordChar = true;
            // 
            // City_Box
            // 
            this.City_Box.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.City_Box.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.City_Box.Location = new System.Drawing.Point(65, 233);
            this.City_Box.MaxLength = 50;
            this.City_Box.Name = "City_Box";
            this.City_Box.Size = new System.Drawing.Size(146, 26);
            this.City_Box.TabIndex = 24;
            // 
            // pictureBox4
            // 
            this.pictureBox4.BackgroundImage = global::WindowsFormsApp1.Properties.Resources.icons8_Globe_104px;
            this.pictureBox4.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.pictureBox4.Location = new System.Drawing.Point(32, 217);
            this.pictureBox4.Name = "pictureBox4";
            this.pictureBox4.Size = new System.Drawing.Size(27, 27);
            this.pictureBox4.TabIndex = 25;
            this.pictureBox4.TabStop = false;
            this.pictureBox4.Click += new System.EventHandler(this.pictureBox4_Click);
            // 
            // Exit1
            // 
            this.Exit1.BackgroundImage = global::WindowsFormsApp1.Properties.Resources.icons8_Close_Window_96px;
            this.Exit1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.Exit1.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Exit1.Location = new System.Drawing.Point(281, 0);
            this.Exit1.Name = "Exit1";
            this.Exit1.Size = new System.Drawing.Size(20, 20);
            this.Exit1.TabIndex = 19;
            this.Exit1.TabStop = false;
            this.Exit1.Click += new System.EventHandler(this.Exit1_Click);
            // 
            // pictureBox3
            // 
            this.pictureBox3.BackgroundImage = global::WindowsFormsApp1.Properties.Resources.icons8_Lock_104px_2;
            this.pictureBox3.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.pictureBox3.Location = new System.Drawing.Point(32, 134);
            this.pictureBox3.Name = "pictureBox3";
            this.pictureBox3.Size = new System.Drawing.Size(27, 27);
            this.pictureBox3.TabIndex = 16;
            this.pictureBox3.TabStop = false;
            this.pictureBox3.Click += new System.EventHandler(this.pictureBox3_Click);
            // 
            // pictureBox2
            // 
            this.pictureBox2.BackgroundImage = global::WindowsFormsApp1.Properties.Resources.icons8_User_Male_104px_1;
            this.pictureBox2.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.pictureBox2.Location = new System.Drawing.Point(32, 63);
            this.pictureBox2.Name = "pictureBox2";
            this.pictureBox2.Size = new System.Drawing.Size(27, 27);
            this.pictureBox2.TabIndex = 15;
            this.pictureBox2.TabStop = false;
            this.pictureBox2.Click += new System.EventHandler(this.pictureBox2_Click);
            // 
            // Age_Box
            // 
            this.Age_Box.AccessibleDescription = "";
            this.Age_Box.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.Age_Box.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.Age_Box.Font = new System.Drawing.Font("Mongolian Baiti", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.Age_Box.FormattingEnabled = true;
            this.Age_Box.Location = new System.Drawing.Point(217, 234);
            this.Age_Box.MaxLength = 3;
            this.Age_Box.Name = "Age_Box";
            this.Age_Box.Size = new System.Drawing.Size(48, 24);
            this.Age_Box.TabIndex = 26;
            this.Age_Box.Text = "Age";
            this.Age_Box.SelectedIndexChanged += new System.EventHandler(this.comboBox2_SelectedIndexChanged);
            // 
            // TermsAndConditions
            // 
            this.TermsAndConditions.AutoSize = true;
            this.TermsAndConditions.Font = new System.Drawing.Font("Adobe Song Std L", 8.25F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TermsAndConditions.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.TermsAndConditions.Location = new System.Drawing.Point(32, 282);
            this.TermsAndConditions.Name = "TermsAndConditions";
            this.TermsAndConditions.Size = new System.Drawing.Size(244, 17);
            this.TermsAndConditions.TabIndex = 27;
            this.TermsAndConditions.Text = "I have read and agree to the terms and conditions ";
            this.TermsAndConditions.UseVisualStyleBackColor = true;
            this.TermsAndConditions.CheckedChanged += new System.EventHandler(this.checkBox1_CheckedChanged);
            // 
            // User_ID_Box
            // 
            this.User_ID_Box.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.User_ID_Box.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.User_ID_Box.Location = new System.Drawing.Point(65, 64);
            this.User_ID_Box.MaxLength = 16;
            this.User_ID_Box.Name = "User_ID_Box";
            this.User_ID_Box.Size = new System.Drawing.Size(200, 26);
            this.User_ID_Box.TabIndex = 28;
            this.User_ID_Box.TextChanged += new System.EventHandler(this.textBox1_TextChanged_1);
            // 
            // FakeID_Label
            // 
            this.FakeID_Label.AutoSize = true;
            this.FakeID_Label.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.FakeID_Label.Cursor = System.Windows.Forms.Cursors.Hand;
            this.FakeID_Label.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold);
            this.FakeID_Label.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.FakeID_Label.Location = new System.Drawing.Point(70, 67);
            this.FakeID_Label.Name = "FakeID_Label";
            this.FakeID_Label.Size = new System.Drawing.Size(191, 19);
            this.FakeID_Label.TabIndex = 29;
            this.FakeID_Label.Text = "UserID                                 ";
            this.FakeID_Label.Click += new System.EventHandler(this.FakeID_Label_Click);
            // 
            // Fake_Password1
            // 
            this.Fake_Password1.AutoSize = true;
            this.Fake_Password1.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.Fake_Password1.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Fake_Password1.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold);
            this.Fake_Password1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Fake_Password1.Location = new System.Drawing.Point(70, 126);
            this.Fake_Password1.Name = "Fake_Password1";
            this.Fake_Password1.Size = new System.Drawing.Size(192, 19);
            this.Fake_Password1.TabIndex = 30;
            this.Fake_Password1.Text = "Password                              ";
            this.Fake_Password1.Click += new System.EventHandler(this.label1_Click);
            // 
            // Fake_Password2
            // 
            this.Fake_Password2.AutoSize = true;
            this.Fake_Password2.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.Fake_Password2.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Fake_Password2.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold);
            this.Fake_Password2.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Fake_Password2.Location = new System.Drawing.Point(70, 158);
            this.Fake_Password2.Name = "Fake_Password2";
            this.Fake_Password2.Size = new System.Drawing.Size(190, 19);
            this.Fake_Password2.TabIndex = 31;
            this.Fake_Password2.Text = "Confirm Password               ";
            this.Fake_Password2.Click += new System.EventHandler(this.Fake_Password2_Click);
            // 
            // Fake_City_Box
            // 
            this.Fake_City_Box.AutoSize = true;
            this.Fake_City_Box.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.Fake_City_Box.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Fake_City_Box.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold);
            this.Fake_City_Box.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Fake_City_Box.Location = new System.Drawing.Point(70, 236);
            this.Fake_City_Box.Name = "Fake_City_Box";
            this.Fake_City_Box.Size = new System.Drawing.Size(137, 19);
            this.Fake_City_Box.TabIndex = 32;
            this.Fake_City_Box.Text = "City                         ";
            this.Fake_City_Box.Click += new System.EventHandler(this.Fake_City_Box_Click);
            // 
            // ID_Error
            // 
            this.ID_Error.AutoSize = true;
            this.ID_Error.Font = new System.Drawing.Font("Adobe Song Std L", 8.25F);
            this.ID_Error.ForeColor = System.Drawing.Color.White;
            this.ID_Error.Location = new System.Drawing.Point(62, 48);
            this.ID_Error.Name = "ID_Error";
            this.ID_Error.Size = new System.Drawing.Size(173, 13);
            this.ID_Error.TabIndex = 33;
            this.ID_Error.Text = "* UserID must be at least 6 characters.";
            this.ID_Error.Visible = false;
            this.ID_Error.Click += new System.EventHandler(this.label1_Click_1);
            // 
            // Password_Error
            // 
            this.Password_Error.AutoSize = true;
            this.Password_Error.Font = new System.Drawing.Font("Adobe Song Std L", 8.25F);
            this.Password_Error.ForeColor = System.Drawing.Color.White;
            this.Password_Error.Location = new System.Drawing.Point(62, 105);
            this.Password_Error.Name = "Password_Error";
            this.Password_Error.Size = new System.Drawing.Size(183, 13);
            this.Password_Error.TabIndex = 34;
            this.Password_Error.Text = "* Password must be at least 6 characters.";
            this.Password_Error.Visible = false;
            // 
            // Location_Error
            // 
            this.Location_Error.AutoSize = true;
            this.Location_Error.Font = new System.Drawing.Font("Adobe Song Std L", 8.25F);
            this.Location_Error.ForeColor = System.Drawing.Color.White;
            this.Location_Error.Location = new System.Drawing.Point(62, 187);
            this.Location_Error.Name = "Location_Error";
            this.Location_Error.Size = new System.Drawing.Size(114, 13);
            this.Location_Error.TabIndex = 35;
            this.Location_Error.Text = "* Invaled country name.";
            this.Location_Error.Visible = false;
            this.Location_Error.Click += new System.EventHandler(this.label3_Click);
            // 
            // Registeration_Window
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.ClientSize = new System.Drawing.Size(300, 450);
            this.Controls.Add(this.Location_Error);
            this.Controls.Add(this.Password_Error);
            this.Controls.Add(this.ID_Error);
            this.Controls.Add(this.Fake_City_Box);
            this.Controls.Add(this.Fake_Password2);
            this.Controls.Add(this.Fake_Password1);
            this.Controls.Add(this.FakeID_Label);
            this.Controls.Add(this.User_ID_Box);
            this.Controls.Add(this.TermsAndConditions);
            this.Controls.Add(this.Age_Box);
            this.Controls.Add(this.pictureBox4);
            this.Controls.Add(this.City_Box);
            this.Controls.Add(this.Password_Box2);
            this.Controls.Add(this.Country_Box);
            this.Controls.Add(this.Exit1);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.pictureBox3);
            this.Controls.Add(this.pictureBox2);
            this.Controls.Add(this.Password_Box1);
            this.Controls.Add(this.UserID_Box);
            this.Controls.Add(this.LOGIN);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Registeration_Window";
            this.Opacity = 0.95D;
            this.Text = "Registeration_Window";
            this.Load += new System.EventHandler(this.Registeration_Window_Load);
            this.MouseDown += new System.Windows.Forms.MouseEventHandler(this.Registeration_Window_MouseDown);
            this.MouseMove += new System.Windows.Forms.MouseEventHandler(this.Registeration_Window_MouseMove);
            this.MouseUp += new System.Windows.Forms.MouseEventHandler(this.Registeration_Window_MouseUp);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.Exit1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.PictureBox Exit1;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.PictureBox pictureBox3;
        private System.Windows.Forms.PictureBox pictureBox2;
        private System.Windows.Forms.TextBox Password_Box1;
        private System.Windows.Forms.TextBox UserID_Box;
        private System.Windows.Forms.Label LOGIN;
        private System.Windows.Forms.ComboBox Country_Box;
        private System.Windows.Forms.TextBox Password_Box2;
        private System.Windows.Forms.TextBox City_Box;
        private System.Windows.Forms.PictureBox pictureBox4;
        private System.Windows.Forms.CheckBox TermsAndConditions;
        private System.Windows.Forms.TextBox User_ID_Box;
        private System.Windows.Forms.Label FakeID_Label;
        private System.Windows.Forms.Label Fake_Password1;
        private System.Windows.Forms.Label Fake_Password2;
        private System.Windows.Forms.Label Fake_City_Box;
        private System.Windows.Forms.Label ID_Error;
        private System.Windows.Forms.Label Password_Error;
        private System.Windows.Forms.Label Location_Error;
        private System.Windows.Forms.ComboBox Age_Box;
    }
}