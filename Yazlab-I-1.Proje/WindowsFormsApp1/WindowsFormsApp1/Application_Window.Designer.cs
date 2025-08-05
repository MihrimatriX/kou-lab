using MySql.Data;
using MySql.Data.MySqlClient;

namespace WindowsFormsApp1
{
    partial class Application_Window
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Application_Window));
            this.panel1 = new System.Windows.Forms.Panel();
            this.Most_Rated_Background = new System.Windows.Forms.Panel();
            this.Most_Rated = new System.Windows.Forms.Label();
            this.Most_Voted_Background = new System.Windows.Forms.Panel();
            this.Most_Voted = new System.Windows.Forms.Label();
            this.Recomended_Background = new System.Windows.Forms.Panel();
            this.Recomended = new System.Windows.Forms.Label();
            this.Recent_Background = new System.Windows.Forms.Panel();
            this.Recent = new System.Windows.Forms.Label();
            this.panel6 = new System.Windows.Forms.Panel();
            this.LOGIN = new System.Windows.Forms.Label();
            this.Panel2 = new System.Windows.Forms.Panel();
            this.pictureBox29 = new System.Windows.Forms.PictureBox();
            this.pictureBox28 = new System.Windows.Forms.PictureBox();
            this.pictureBox27 = new System.Windows.Forms.PictureBox();
            this.pictureBox26 = new System.Windows.Forms.PictureBox();
            this.Book24 = new System.Windows.Forms.Panel();
            this.panel54 = new System.Windows.Forms.Panel();
            this.Book_Image24 = new System.Windows.Forms.PictureBox();
            this.Book_Title24 = new System.Windows.Forms.Label();
            this.Book20 = new System.Windows.Forms.Panel();
            this.panel46 = new System.Windows.Forms.Panel();
            this.Book_Image20 = new System.Windows.Forms.PictureBox();
            this.Book_Title20 = new System.Windows.Forms.Label();
            this.Book16 = new System.Windows.Forms.Panel();
            this.panel38 = new System.Windows.Forms.Panel();
            this.Book_Image16 = new System.Windows.Forms.PictureBox();
            this.Book_Title16 = new System.Windows.Forms.Label();
            this.Book12 = new System.Windows.Forms.Panel();
            this.panel30 = new System.Windows.Forms.Panel();
            this.Book_Image12 = new System.Windows.Forms.PictureBox();
            this.Book_Title12 = new System.Windows.Forms.Label();
            this.Book8 = new System.Windows.Forms.Panel();
            this.panel22 = new System.Windows.Forms.Panel();
            this.Book_Image8 = new System.Windows.Forms.PictureBox();
            this.Book_Title8 = new System.Windows.Forms.Label();
            this.Book4 = new System.Windows.Forms.Panel();
            this.panel11 = new System.Windows.Forms.Panel();
            this.Book_Image4 = new System.Windows.Forms.PictureBox();
            this.Book_Title4 = new System.Windows.Forms.Label();
            this.Book22 = new System.Windows.Forms.Panel();
            this.panel52 = new System.Windows.Forms.Panel();
            this.Book_Image22 = new System.Windows.Forms.PictureBox();
            this.Book_Title22 = new System.Windows.Forms.Label();
            this.Book18 = new System.Windows.Forms.Panel();
            this.panel44 = new System.Windows.Forms.Panel();
            this.Book_Image18 = new System.Windows.Forms.PictureBox();
            this.Book_Title18 = new System.Windows.Forms.Label();
            this.Book14 = new System.Windows.Forms.Panel();
            this.panel36 = new System.Windows.Forms.Panel();
            this.Book_Image14 = new System.Windows.Forms.PictureBox();
            this.Book_Title14 = new System.Windows.Forms.Label();
            this.Book10 = new System.Windows.Forms.Panel();
            this.panel28 = new System.Windows.Forms.Panel();
            this.Book_Image10 = new System.Windows.Forms.PictureBox();
            this.Book_Title10 = new System.Windows.Forms.Label();
            this.Book6 = new System.Windows.Forms.Panel();
            this.panel20 = new System.Windows.Forms.Panel();
            this.Book_Image6 = new System.Windows.Forms.PictureBox();
            this.Book_Title6 = new System.Windows.Forms.Label();
            this.Book2 = new System.Windows.Forms.Panel();
            this.panel13 = new System.Windows.Forms.Panel();
            this.Book_Image2 = new System.Windows.Forms.PictureBox();
            this.Book_Title2 = new System.Windows.Forms.Label();
            this.Book21 = new System.Windows.Forms.Panel();
            this.panel50 = new System.Windows.Forms.Panel();
            this.Book_Image21 = new System.Windows.Forms.PictureBox();
            this.Book_Title21 = new System.Windows.Forms.Label();
            this.Book23 = new System.Windows.Forms.Panel();
            this.panel48 = new System.Windows.Forms.Panel();
            this.Book_Image23 = new System.Windows.Forms.PictureBox();
            this.Book_Title23 = new System.Windows.Forms.Label();
            this.Book17 = new System.Windows.Forms.Panel();
            this.panel42 = new System.Windows.Forms.Panel();
            this.Book_Image17 = new System.Windows.Forms.PictureBox();
            this.Book_Title17 = new System.Windows.Forms.Label();
            this.Book19 = new System.Windows.Forms.Panel();
            this.panel40 = new System.Windows.Forms.Panel();
            this.Book_Image19 = new System.Windows.Forms.PictureBox();
            this.Book_Title19 = new System.Windows.Forms.Label();
            this.Book13 = new System.Windows.Forms.Panel();
            this.panel34 = new System.Windows.Forms.Panel();
            this.Book_Image13 = new System.Windows.Forms.PictureBox();
            this.Book_Title13 = new System.Windows.Forms.Label();
            this.Book15 = new System.Windows.Forms.Panel();
            this.panel32 = new System.Windows.Forms.Panel();
            this.Book_Image15 = new System.Windows.Forms.PictureBox();
            this.Book_Title15 = new System.Windows.Forms.Label();
            this.Book9 = new System.Windows.Forms.Panel();
            this.panel26 = new System.Windows.Forms.Panel();
            this.Book_Image9 = new System.Windows.Forms.PictureBox();
            this.Book_Title9 = new System.Windows.Forms.Label();
            this.Book11 = new System.Windows.Forms.Panel();
            this.panel24 = new System.Windows.Forms.Panel();
            this.Book_Image11 = new System.Windows.Forms.PictureBox();
            this.Book_Title11 = new System.Windows.Forms.Label();
            this.Book5 = new System.Windows.Forms.Panel();
            this.panel18 = new System.Windows.Forms.Panel();
            this.Book_Image5 = new System.Windows.Forms.PictureBox();
            this.Book_Title5 = new System.Windows.Forms.Label();
            this.Book7 = new System.Windows.Forms.Panel();
            this.panel16 = new System.Windows.Forms.Panel();
            this.Book_Image7 = new System.Windows.Forms.PictureBox();
            this.Book_Title7 = new System.Windows.Forms.Label();
            this.Book1 = new System.Windows.Forms.Panel();
            this.panel15 = new System.Windows.Forms.Panel();
            this.Book_Image1 = new System.Windows.Forms.PictureBox();
            this.Book_Title1 = new System.Windows.Forms.Label();
            this.Book3 = new System.Windows.Forms.Panel();
            this.panel9 = new System.Windows.Forms.Panel();
            this.Book_Image3 = new System.Windows.Forms.PictureBox();
            this.Book_Title3 = new System.Windows.Forms.Label();
            this.Exit1 = new System.Windows.Forms.PictureBox();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.panel1.SuspendLayout();
            this.Most_Rated_Background.SuspendLayout();
            this.Most_Voted_Background.SuspendLayout();
            this.Recomended_Background.SuspendLayout();
            this.Recent_Background.SuspendLayout();
            this.Panel2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox29)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox28)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox27)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox26)).BeginInit();
            this.Book24.SuspendLayout();
            this.panel54.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image24)).BeginInit();
            this.Book20.SuspendLayout();
            this.panel46.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image20)).BeginInit();
            this.Book16.SuspendLayout();
            this.panel38.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image16)).BeginInit();
            this.Book12.SuspendLayout();
            this.panel30.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image12)).BeginInit();
            this.Book8.SuspendLayout();
            this.panel22.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image8)).BeginInit();
            this.Book4.SuspendLayout();
            this.panel11.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image4)).BeginInit();
            this.Book22.SuspendLayout();
            this.panel52.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image22)).BeginInit();
            this.Book18.SuspendLayout();
            this.panel44.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image18)).BeginInit();
            this.Book14.SuspendLayout();
            this.panel36.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image14)).BeginInit();
            this.Book10.SuspendLayout();
            this.panel28.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image10)).BeginInit();
            this.Book6.SuspendLayout();
            this.panel20.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image6)).BeginInit();
            this.Book2.SuspendLayout();
            this.panel13.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image2)).BeginInit();
            this.Book21.SuspendLayout();
            this.panel50.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image21)).BeginInit();
            this.Book23.SuspendLayout();
            this.panel48.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image23)).BeginInit();
            this.Book17.SuspendLayout();
            this.panel42.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image17)).BeginInit();
            this.Book19.SuspendLayout();
            this.panel40.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image19)).BeginInit();
            this.Book13.SuspendLayout();
            this.panel34.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image13)).BeginInit();
            this.Book15.SuspendLayout();
            this.panel32.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image15)).BeginInit();
            this.Book9.SuspendLayout();
            this.panel26.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image9)).BeginInit();
            this.Book11.SuspendLayout();
            this.panel24.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image11)).BeginInit();
            this.Book5.SuspendLayout();
            this.panel18.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image5)).BeginInit();
            this.Book7.SuspendLayout();
            this.panel16.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image7)).BeginInit();
            this.Book1.SuspendLayout();
            this.panel15.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image1)).BeginInit();
            this.Book3.SuspendLayout();
            this.panel9.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.Exit1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.panel1.Controls.Add(this.Most_Rated_Background);
            this.panel1.Controls.Add(this.Most_Voted_Background);
            this.panel1.Controls.Add(this.Recomended_Background);
            this.panel1.Controls.Add(this.Recent_Background);
            this.panel1.Controls.Add(this.panel6);
            this.panel1.Location = new System.Drawing.Point(0, 50);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(900, 30);
            this.panel1.TabIndex = 0;
            // 
            // Most_Rated_Background
            // 
            this.Most_Rated_Background.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.Most_Rated_Background.Controls.Add(this.Most_Rated);
            this.Most_Rated_Background.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Most_Rated_Background.Location = new System.Drawing.Point(0, 0);
            this.Most_Rated_Background.Name = "Most_Rated_Background";
            this.Most_Rated_Background.Size = new System.Drawing.Size(180, 30);
            this.Most_Rated_Background.TabIndex = 24;
            this.Most_Rated_Background.Click += new System.EventHandler(this.Most_Rated_Background_Click);
            this.Most_Rated_Background.Paint += new System.Windows.Forms.PaintEventHandler(this.Most_Rated_Background_Paint);
            // 
            // Most_Rated
            // 
            this.Most_Rated.AutoSize = true;
            this.Most_Rated.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.Most_Rated.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Most_Rated.Font = new System.Drawing.Font("Trajan Pro", 15F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Most_Rated.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Most_Rated.Location = new System.Drawing.Point(3, 5);
            this.Most_Rated.Name = "Most_Rated";
            this.Most_Rated.Size = new System.Drawing.Size(149, 25);
            this.Most_Rated.TabIndex = 21;
            this.Most_Rated.Text = "Most Rated";
            this.Most_Rated.Click += new System.EventHandler(this.Most_Rated_Click);
            // 
            // Most_Voted_Background
            // 
            this.Most_Voted_Background.BackColor = System.Drawing.Color.Goldenrod;
            this.Most_Voted_Background.Controls.Add(this.Most_Voted);
            this.Most_Voted_Background.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Most_Voted_Background.Dock = System.Windows.Forms.DockStyle.Right;
            this.Most_Voted_Background.Location = new System.Drawing.Point(180, 0);
            this.Most_Voted_Background.Name = "Most_Voted_Background";
            this.Most_Voted_Background.Size = new System.Drawing.Size(180, 30);
            this.Most_Voted_Background.TabIndex = 23;
            this.Most_Voted_Background.Click += new System.EventHandler(this.Most_Voted_Background_Click);
            // 
            // Most_Voted
            // 
            this.Most_Voted.AutoSize = true;
            this.Most_Voted.BackColor = System.Drawing.Color.Goldenrod;
            this.Most_Voted.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Most_Voted.Font = new System.Drawing.Font("Trajan Pro", 15F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Most_Voted.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Most_Voted.Location = new System.Drawing.Point(3, 5);
            this.Most_Voted.Name = "Most_Voted";
            this.Most_Voted.Size = new System.Drawing.Size(153, 25);
            this.Most_Voted.TabIndex = 22;
            this.Most_Voted.Text = "Most Voted";
            this.Most_Voted.Click += new System.EventHandler(this.Most_Voted_Click);
            // 
            // Recomended_Background
            // 
            this.Recomended_Background.BackColor = System.Drawing.Color.Goldenrod;
            this.Recomended_Background.Controls.Add(this.Recomended);
            this.Recomended_Background.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Recomended_Background.Dock = System.Windows.Forms.DockStyle.Right;
            this.Recomended_Background.Location = new System.Drawing.Point(360, 0);
            this.Recomended_Background.Name = "Recomended_Background";
            this.Recomended_Background.Size = new System.Drawing.Size(180, 30);
            this.Recomended_Background.TabIndex = 22;
            this.Recomended_Background.Click += new System.EventHandler(this.Recomended_Background_Click);
            // 
            // Recomended
            // 
            this.Recomended.AutoSize = true;
            this.Recomended.BackColor = System.Drawing.Color.Goldenrod;
            this.Recomended.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Recomended.Font = new System.Drawing.Font("Trajan Pro", 15F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Recomended.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Recomended.Location = new System.Drawing.Point(3, 5);
            this.Recomended.Name = "Recomended";
            this.Recomended.Size = new System.Drawing.Size(163, 25);
            this.Recomended.TabIndex = 24;
            this.Recomended.Text = "Recomended";
            this.Recomended.Click += new System.EventHandler(this.Recomended_Click);
            // 
            // Recent_Background
            // 
            this.Recent_Background.BackColor = System.Drawing.Color.Goldenrod;
            this.Recent_Background.Controls.Add(this.Recent);
            this.Recent_Background.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Recent_Background.Dock = System.Windows.Forms.DockStyle.Right;
            this.Recent_Background.Location = new System.Drawing.Point(540, 0);
            this.Recent_Background.Name = "Recent_Background";
            this.Recent_Background.Size = new System.Drawing.Size(180, 30);
            this.Recent_Background.TabIndex = 26;
            this.Recent_Background.Click += new System.EventHandler(this.Recent_Background_Click);
            // 
            // Recent
            // 
            this.Recent.AutoSize = true;
            this.Recent.BackColor = System.Drawing.Color.Goldenrod;
            this.Recent.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Recent.Font = new System.Drawing.Font("Trajan Pro", 15F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Recent.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Recent.Location = new System.Drawing.Point(6, 5);
            this.Recent.Name = "Recent";
            this.Recent.Size = new System.Drawing.Size(95, 25);
            this.Recent.TabIndex = 23;
            this.Recent.Text = "Recent";
            this.Recent.Click += new System.EventHandler(this.Recent_Click);
            // 
            // panel6
            // 
            this.panel6.BackColor = System.Drawing.Color.Goldenrod;
            this.panel6.Dock = System.Windows.Forms.DockStyle.Right;
            this.panel6.Location = new System.Drawing.Point(720, 0);
            this.panel6.Name = "panel6";
            this.panel6.Size = new System.Drawing.Size(180, 30);
            this.panel6.TabIndex = 25;
            // 
            // LOGIN
            // 
            this.LOGIN.AutoSize = true;
            this.LOGIN.Font = new System.Drawing.Font("Trajan Pro", 25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LOGIN.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.LOGIN.Location = new System.Drawing.Point(322, 4);
            this.LOGIN.Name = "LOGIN";
            this.LOGIN.Size = new System.Drawing.Size(211, 43);
            this.LOGIN.TabIndex = 13;
            this.LOGIN.Text = "E-LIBRARY";
            // 
            // Panel2
            // 
            this.Panel2.BackColor = System.Drawing.Color.DarkGoldenrod;
            this.Panel2.Controls.Add(this.pictureBox29);
            this.Panel2.Controls.Add(this.pictureBox28);
            this.Panel2.Controls.Add(this.pictureBox27);
            this.Panel2.Controls.Add(this.pictureBox26);
            this.Panel2.Controls.Add(this.Book24);
            this.Panel2.Controls.Add(this.Book20);
            this.Panel2.Controls.Add(this.Book16);
            this.Panel2.Controls.Add(this.Book12);
            this.Panel2.Controls.Add(this.Book8);
            this.Panel2.Controls.Add(this.Book4);
            this.Panel2.Controls.Add(this.Book22);
            this.Panel2.Controls.Add(this.Book18);
            this.Panel2.Controls.Add(this.Book14);
            this.Panel2.Controls.Add(this.Book10);
            this.Panel2.Controls.Add(this.Book6);
            this.Panel2.Controls.Add(this.Book2);
            this.Panel2.Controls.Add(this.Book21);
            this.Panel2.Controls.Add(this.Book23);
            this.Panel2.Controls.Add(this.Book17);
            this.Panel2.Controls.Add(this.Book19);
            this.Panel2.Controls.Add(this.Book13);
            this.Panel2.Controls.Add(this.Book15);
            this.Panel2.Controls.Add(this.Book9);
            this.Panel2.Controls.Add(this.Book11);
            this.Panel2.Controls.Add(this.Book5);
            this.Panel2.Controls.Add(this.Book7);
            this.Panel2.Controls.Add(this.Book1);
            this.Panel2.Controls.Add(this.Book3);
            this.Panel2.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.Panel2.Location = new System.Drawing.Point(0, 85);
            this.Panel2.Name = "Panel2";
            this.Panel2.Size = new System.Drawing.Size(900, 515);
            this.Panel2.TabIndex = 1;
            // 
            // pictureBox29
            // 
            this.pictureBox29.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.pictureBox29.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox29.Image = global::WindowsFormsApp1.Properties.Resources.icons8_Chevron_Left_30px_1;
            this.pictureBox29.Location = new System.Drawing.Point(48, 0);
            this.pictureBox29.Name = "pictureBox29";
            this.pictureBox29.Size = new System.Drawing.Size(30, 30);
            this.pictureBox29.TabIndex = 16;
            this.pictureBox29.TabStop = false;
            // 
            // pictureBox28
            // 
            this.pictureBox28.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.pictureBox28.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox28.Image = global::WindowsFormsApp1.Properties.Resources.icons8_Chevron_Right_30px_1;
            this.pictureBox28.Location = new System.Drawing.Point(822, 0);
            this.pictureBox28.Name = "pictureBox28";
            this.pictureBox28.Size = new System.Drawing.Size(30, 30);
            this.pictureBox28.TabIndex = 15;
            this.pictureBox28.TabStop = false;
            // 
            // pictureBox27
            // 
            this.pictureBox27.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.pictureBox27.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox27.Image = global::WindowsFormsApp1.Properties.Resources.icons8_Double_Left_30px;
            this.pictureBox27.Location = new System.Drawing.Point(12, 0);
            this.pictureBox27.Name = "pictureBox27";
            this.pictureBox27.Size = new System.Drawing.Size(30, 30);
            this.pictureBox27.TabIndex = 14;
            this.pictureBox27.TabStop = false;
            // 
            // pictureBox26
            // 
            this.pictureBox26.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.pictureBox26.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox26.Image = global::WindowsFormsApp1.Properties.Resources.icons8_Double_Right_30px;
            this.pictureBox26.Location = new System.Drawing.Point(858, 0);
            this.pictureBox26.Name = "pictureBox26";
            this.pictureBox26.Size = new System.Drawing.Size(30, 30);
            this.pictureBox26.TabIndex = 13;
            this.pictureBox26.TabStop = false;
            // 
            // Book24
            // 
            this.Book24.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book24.Controls.Add(this.panel54);
            this.Book24.Controls.Add(this.Book_Title24);
            this.Book24.Location = new System.Drawing.Point(673, 435);
            this.Book24.Name = "Book24";
            this.Book24.Size = new System.Drawing.Size(215, 75);
            this.Book24.TabIndex = 12;
            // 
            // panel54
            // 
            this.panel54.Controls.Add(this.Book_Image24);
            this.panel54.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel54.Location = new System.Drawing.Point(0, 0);
            this.panel54.Name = "panel54";
            this.panel54.Size = new System.Drawing.Size(50, 75);
            this.panel54.TabIndex = 12;
            // 
            // Book_Image24
            // 
            this.Book_Image24.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image24.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image24.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image24.Location = new System.Drawing.Point(0, 0);
            this.Book_Image24.Name = "Book_Image24";
            this.Book_Image24.Size = new System.Drawing.Size(50, 75);
            this.Book_Image24.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image24.TabIndex = 2;
            this.Book_Image24.TabStop = false;
            // 
            // Book_Title24
            // 
            this.Book_Title24.AutoSize = true;
            this.Book_Title24.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title24.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title24.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title24.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title24.Location = new System.Drawing.Point(55, 0);
            this.Book_Title24.Name = "Book_Title24";
            this.Book_Title24.Size = new System.Drawing.Size(153, 14);
            this.Book_Title24.TabIndex = 11;
            this.Book_Title24.Text = "The ANATOMY OFmot ...";
            this.Book_Title24.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book20
            // 
            this.Book20.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book20.Controls.Add(this.panel46);
            this.Book20.Controls.Add(this.Book_Title20);
            this.Book20.Location = new System.Drawing.Point(673, 354);
            this.Book20.Name = "Book20";
            this.Book20.Size = new System.Drawing.Size(215, 75);
            this.Book20.TabIndex = 12;
            // 
            // panel46
            // 
            this.panel46.Controls.Add(this.Book_Image20);
            this.panel46.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel46.Location = new System.Drawing.Point(0, 0);
            this.panel46.Name = "panel46";
            this.panel46.Size = new System.Drawing.Size(50, 75);
            this.panel46.TabIndex = 12;
            // 
            // Book_Image20
            // 
            this.Book_Image20.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image20.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image20.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image20.Location = new System.Drawing.Point(0, 0);
            this.Book_Image20.Name = "Book_Image20";
            this.Book_Image20.Size = new System.Drawing.Size(50, 75);
            this.Book_Image20.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image20.TabIndex = 2;
            this.Book_Image20.TabStop = false;
            // 
            // Book_Title20
            // 
            this.Book_Title20.AutoSize = true;
            this.Book_Title20.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title20.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title20.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title20.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title20.Location = new System.Drawing.Point(55, 0);
            this.Book_Title20.Name = "Book_Title20";
            this.Book_Title20.Size = new System.Drawing.Size(153, 14);
            this.Book_Title20.TabIndex = 11;
            this.Book_Title20.Text = "The ANATOMY OFmot ...";
            this.Book_Title20.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book16
            // 
            this.Book16.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book16.Controls.Add(this.panel38);
            this.Book16.Controls.Add(this.Book_Title16);
            this.Book16.Location = new System.Drawing.Point(673, 273);
            this.Book16.Name = "Book16";
            this.Book16.Size = new System.Drawing.Size(215, 75);
            this.Book16.TabIndex = 12;
            // 
            // panel38
            // 
            this.panel38.Controls.Add(this.Book_Image16);
            this.panel38.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel38.Location = new System.Drawing.Point(0, 0);
            this.panel38.Name = "panel38";
            this.panel38.Size = new System.Drawing.Size(50, 75);
            this.panel38.TabIndex = 12;
            // 
            // Book_Image16
            // 
            this.Book_Image16.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image16.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image16.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image16.Location = new System.Drawing.Point(0, 0);
            this.Book_Image16.Name = "Book_Image16";
            this.Book_Image16.Size = new System.Drawing.Size(50, 75);
            this.Book_Image16.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image16.TabIndex = 2;
            this.Book_Image16.TabStop = false;
            // 
            // Book_Title16
            // 
            this.Book_Title16.AutoSize = true;
            this.Book_Title16.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title16.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title16.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title16.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title16.Location = new System.Drawing.Point(55, 0);
            this.Book_Title16.Name = "Book_Title16";
            this.Book_Title16.Size = new System.Drawing.Size(153, 14);
            this.Book_Title16.TabIndex = 11;
            this.Book_Title16.Text = "The ANATOMY OFmot ...";
            this.Book_Title16.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book12
            // 
            this.Book12.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book12.Controls.Add(this.panel30);
            this.Book12.Controls.Add(this.Book_Title12);
            this.Book12.Location = new System.Drawing.Point(673, 192);
            this.Book12.Name = "Book12";
            this.Book12.Size = new System.Drawing.Size(215, 75);
            this.Book12.TabIndex = 12;
            // 
            // panel30
            // 
            this.panel30.Controls.Add(this.Book_Image12);
            this.panel30.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel30.Location = new System.Drawing.Point(0, 0);
            this.panel30.Name = "panel30";
            this.panel30.Size = new System.Drawing.Size(50, 75);
            this.panel30.TabIndex = 12;
            // 
            // Book_Image12
            // 
            this.Book_Image12.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image12.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image12.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image12.Location = new System.Drawing.Point(0, 0);
            this.Book_Image12.Name = "Book_Image12";
            this.Book_Image12.Size = new System.Drawing.Size(50, 75);
            this.Book_Image12.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image12.TabIndex = 2;
            this.Book_Image12.TabStop = false;
            // 
            // Book_Title12
            // 
            this.Book_Title12.AutoSize = true;
            this.Book_Title12.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title12.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title12.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title12.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title12.Location = new System.Drawing.Point(55, 0);
            this.Book_Title12.Name = "Book_Title12";
            this.Book_Title12.Size = new System.Drawing.Size(153, 14);
            this.Book_Title12.TabIndex = 11;
            this.Book_Title12.Text = "The ANATOMY OFmot ...";
            this.Book_Title12.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book8
            // 
            this.Book8.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book8.Controls.Add(this.panel22);
            this.Book8.Controls.Add(this.Book_Title8);
            this.Book8.Location = new System.Drawing.Point(673, 111);
            this.Book8.Name = "Book8";
            this.Book8.Size = new System.Drawing.Size(215, 75);
            this.Book8.TabIndex = 12;
            // 
            // panel22
            // 
            this.panel22.Controls.Add(this.Book_Image8);
            this.panel22.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel22.Location = new System.Drawing.Point(0, 0);
            this.panel22.Name = "panel22";
            this.panel22.Size = new System.Drawing.Size(50, 75);
            this.panel22.TabIndex = 12;
            // 
            // Book_Image8
            // 
            this.Book_Image8.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image8.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image8.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image8.Location = new System.Drawing.Point(0, 0);
            this.Book_Image8.Name = "Book_Image8";
            this.Book_Image8.Size = new System.Drawing.Size(50, 75);
            this.Book_Image8.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image8.TabIndex = 2;
            this.Book_Image8.TabStop = false;
            // 
            // Book_Title8
            // 
            this.Book_Title8.AutoSize = true;
            this.Book_Title8.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title8.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title8.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title8.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title8.Location = new System.Drawing.Point(55, 0);
            this.Book_Title8.Name = "Book_Title8";
            this.Book_Title8.Size = new System.Drawing.Size(153, 14);
            this.Book_Title8.TabIndex = 11;
            this.Book_Title8.Text = "The ANATOMY OFmot ...";
            this.Book_Title8.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book4
            // 
            this.Book4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book4.Controls.Add(this.panel11);
            this.Book4.Controls.Add(this.Book_Title4);
            this.Book4.Location = new System.Drawing.Point(673, 30);
            this.Book4.Name = "Book4";
            this.Book4.Size = new System.Drawing.Size(215, 75);
            this.Book4.TabIndex = 12;
            // 
            // panel11
            // 
            this.panel11.Controls.Add(this.Book_Image4);
            this.panel11.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel11.Location = new System.Drawing.Point(0, 0);
            this.panel11.Name = "panel11";
            this.panel11.Size = new System.Drawing.Size(50, 75);
            this.panel11.TabIndex = 12;
            // 
            // Book_Image4
            // 
            this.Book_Image4.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image4.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image4.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image4.Location = new System.Drawing.Point(0, 0);
            this.Book_Image4.Name = "Book_Image4";
            this.Book_Image4.Size = new System.Drawing.Size(50, 75);
            this.Book_Image4.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image4.TabIndex = 2;
            this.Book_Image4.TabStop = false;
            // 
            // Book_Title4
            // 
            this.Book_Title4.AutoSize = true;
            this.Book_Title4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title4.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title4.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title4.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title4.Location = new System.Drawing.Point(55, 0);
            this.Book_Title4.Name = "Book_Title4";
            this.Book_Title4.Size = new System.Drawing.Size(153, 14);
            this.Book_Title4.TabIndex = 11;
            this.Book_Title4.Text = "The ANATOMY OFmot ...";
            this.Book_Title4.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book22
            // 
            this.Book22.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book22.Controls.Add(this.panel52);
            this.Book22.Controls.Add(this.Book_Title22);
            this.Book22.Location = new System.Drawing.Point(233, 435);
            this.Book22.Name = "Book22";
            this.Book22.Size = new System.Drawing.Size(215, 75);
            this.Book22.TabIndex = 12;
            // 
            // panel52
            // 
            this.panel52.Controls.Add(this.Book_Image22);
            this.panel52.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel52.Location = new System.Drawing.Point(0, 0);
            this.panel52.Name = "panel52";
            this.panel52.Size = new System.Drawing.Size(50, 75);
            this.panel52.TabIndex = 12;
            // 
            // Book_Image22
            // 
            this.Book_Image22.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image22.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image22.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image22.Location = new System.Drawing.Point(0, 0);
            this.Book_Image22.Name = "Book_Image22";
            this.Book_Image22.Size = new System.Drawing.Size(50, 75);
            this.Book_Image22.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image22.TabIndex = 2;
            this.Book_Image22.TabStop = false;
            // 
            // Book_Title22
            // 
            this.Book_Title22.AutoSize = true;
            this.Book_Title22.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title22.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title22.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title22.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title22.Location = new System.Drawing.Point(55, 0);
            this.Book_Title22.Name = "Book_Title22";
            this.Book_Title22.Size = new System.Drawing.Size(153, 14);
            this.Book_Title22.TabIndex = 11;
            this.Book_Title22.Text = "The ANATOMY OFmot ...";
            this.Book_Title22.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book18
            // 
            this.Book18.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book18.Controls.Add(this.panel44);
            this.Book18.Controls.Add(this.Book_Title18);
            this.Book18.Location = new System.Drawing.Point(233, 354);
            this.Book18.Name = "Book18";
            this.Book18.Size = new System.Drawing.Size(215, 75);
            this.Book18.TabIndex = 12;
            // 
            // panel44
            // 
            this.panel44.Controls.Add(this.Book_Image18);
            this.panel44.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel44.Location = new System.Drawing.Point(0, 0);
            this.panel44.Name = "panel44";
            this.panel44.Size = new System.Drawing.Size(50, 75);
            this.panel44.TabIndex = 12;
            // 
            // Book_Image18
            // 
            this.Book_Image18.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image18.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image18.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image18.Location = new System.Drawing.Point(0, 0);
            this.Book_Image18.Name = "Book_Image18";
            this.Book_Image18.Size = new System.Drawing.Size(50, 75);
            this.Book_Image18.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image18.TabIndex = 2;
            this.Book_Image18.TabStop = false;
            // 
            // Book_Title18
            // 
            this.Book_Title18.AutoSize = true;
            this.Book_Title18.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title18.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title18.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title18.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title18.Location = new System.Drawing.Point(55, 0);
            this.Book_Title18.Name = "Book_Title18";
            this.Book_Title18.Size = new System.Drawing.Size(153, 14);
            this.Book_Title18.TabIndex = 11;
            this.Book_Title18.Text = "The ANATOMY OFmot ...";
            this.Book_Title18.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book14
            // 
            this.Book14.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book14.Controls.Add(this.panel36);
            this.Book14.Controls.Add(this.Book_Title14);
            this.Book14.Location = new System.Drawing.Point(233, 273);
            this.Book14.Name = "Book14";
            this.Book14.Size = new System.Drawing.Size(215, 75);
            this.Book14.TabIndex = 12;
            // 
            // panel36
            // 
            this.panel36.Controls.Add(this.Book_Image14);
            this.panel36.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel36.Location = new System.Drawing.Point(0, 0);
            this.panel36.Name = "panel36";
            this.panel36.Size = new System.Drawing.Size(50, 75);
            this.panel36.TabIndex = 12;
            // 
            // Book_Image14
            // 
            this.Book_Image14.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image14.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image14.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image14.Location = new System.Drawing.Point(0, 0);
            this.Book_Image14.Name = "Book_Image14";
            this.Book_Image14.Size = new System.Drawing.Size(50, 75);
            this.Book_Image14.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image14.TabIndex = 2;
            this.Book_Image14.TabStop = false;
            // 
            // Book_Title14
            // 
            this.Book_Title14.AutoSize = true;
            this.Book_Title14.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title14.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title14.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title14.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title14.Location = new System.Drawing.Point(55, 0);
            this.Book_Title14.Name = "Book_Title14";
            this.Book_Title14.Size = new System.Drawing.Size(153, 14);
            this.Book_Title14.TabIndex = 11;
            this.Book_Title14.Text = "The ANATOMY OFmot ...";
            this.Book_Title14.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book10
            // 
            this.Book10.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book10.Controls.Add(this.panel28);
            this.Book10.Controls.Add(this.Book_Title10);
            this.Book10.Location = new System.Drawing.Point(233, 192);
            this.Book10.Name = "Book10";
            this.Book10.Size = new System.Drawing.Size(215, 75);
            this.Book10.TabIndex = 12;
            // 
            // panel28
            // 
            this.panel28.Controls.Add(this.Book_Image10);
            this.panel28.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel28.Location = new System.Drawing.Point(0, 0);
            this.panel28.Name = "panel28";
            this.panel28.Size = new System.Drawing.Size(50, 75);
            this.panel28.TabIndex = 12;
            // 
            // Book_Image10
            // 
            this.Book_Image10.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image10.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image10.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image10.Location = new System.Drawing.Point(0, 0);
            this.Book_Image10.Name = "Book_Image10";
            this.Book_Image10.Size = new System.Drawing.Size(50, 75);
            this.Book_Image10.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image10.TabIndex = 2;
            this.Book_Image10.TabStop = false;
            // 
            // Book_Title10
            // 
            this.Book_Title10.AutoSize = true;
            this.Book_Title10.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title10.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title10.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title10.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title10.Location = new System.Drawing.Point(55, 0);
            this.Book_Title10.Name = "Book_Title10";
            this.Book_Title10.Size = new System.Drawing.Size(153, 14);
            this.Book_Title10.TabIndex = 11;
            this.Book_Title10.Text = "The ANATOMY OFmot ...";
            this.Book_Title10.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book6
            // 
            this.Book6.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book6.Controls.Add(this.panel20);
            this.Book6.Controls.Add(this.Book_Title6);
            this.Book6.Location = new System.Drawing.Point(233, 111);
            this.Book6.Name = "Book6";
            this.Book6.Size = new System.Drawing.Size(215, 75);
            this.Book6.TabIndex = 12;
            // 
            // panel20
            // 
            this.panel20.Controls.Add(this.Book_Image6);
            this.panel20.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel20.Location = new System.Drawing.Point(0, 0);
            this.panel20.Name = "panel20";
            this.panel20.Size = new System.Drawing.Size(50, 75);
            this.panel20.TabIndex = 12;
            // 
            // Book_Image6
            // 
            this.Book_Image6.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image6.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image6.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image6.Location = new System.Drawing.Point(0, 0);
            this.Book_Image6.Name = "Book_Image6";
            this.Book_Image6.Size = new System.Drawing.Size(50, 75);
            this.Book_Image6.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image6.TabIndex = 2;
            this.Book_Image6.TabStop = false;
            // 
            // Book_Title6
            // 
            this.Book_Title6.AutoSize = true;
            this.Book_Title6.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title6.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title6.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title6.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title6.Location = new System.Drawing.Point(55, 0);
            this.Book_Title6.Name = "Book_Title6";
            this.Book_Title6.Size = new System.Drawing.Size(153, 14);
            this.Book_Title6.TabIndex = 11;
            this.Book_Title6.Text = "The ANATOMY OFmot ...";
            this.Book_Title6.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book2
            // 
            this.Book2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book2.Controls.Add(this.panel13);
            this.Book2.Controls.Add(this.Book_Title2);
            this.Book2.Location = new System.Drawing.Point(233, 30);
            this.Book2.Name = "Book2";
            this.Book2.Size = new System.Drawing.Size(215, 75);
            this.Book2.TabIndex = 12;
            // 
            // panel13
            // 
            this.panel13.Controls.Add(this.Book_Image2);
            this.panel13.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel13.Location = new System.Drawing.Point(0, 0);
            this.panel13.Name = "panel13";
            this.panel13.Size = new System.Drawing.Size(50, 75);
            this.panel13.TabIndex = 12;
            // 
            // Book_Image2
            // 
            this.Book_Image2.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image2.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image2.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image2.Location = new System.Drawing.Point(0, 0);
            this.Book_Image2.Name = "Book_Image2";
            this.Book_Image2.Size = new System.Drawing.Size(50, 75);
            this.Book_Image2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image2.TabIndex = 2;
            this.Book_Image2.TabStop = false;
            // 
            // Book_Title2
            // 
            this.Book_Title2.AutoSize = true;
            this.Book_Title2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title2.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title2.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title2.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title2.Location = new System.Drawing.Point(55, 0);
            this.Book_Title2.Name = "Book_Title2";
            this.Book_Title2.Size = new System.Drawing.Size(153, 14);
            this.Book_Title2.TabIndex = 11;
            this.Book_Title2.Text = "The ANATOMY OFmot ...";
            this.Book_Title2.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book21
            // 
            this.Book21.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book21.Controls.Add(this.panel50);
            this.Book21.Controls.Add(this.Book_Title21);
            this.Book21.Location = new System.Drawing.Point(12, 435);
            this.Book21.Name = "Book21";
            this.Book21.Size = new System.Drawing.Size(215, 75);
            this.Book21.TabIndex = 12;
            this.Book21.Tag = "";
            // 
            // panel50
            // 
            this.panel50.Controls.Add(this.Book_Image21);
            this.panel50.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel50.Location = new System.Drawing.Point(0, 0);
            this.panel50.Name = "panel50";
            this.panel50.Size = new System.Drawing.Size(50, 75);
            this.panel50.TabIndex = 12;
            // 
            // Book_Image21
            // 
            this.Book_Image21.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image21.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image21.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image21.Location = new System.Drawing.Point(0, 0);
            this.Book_Image21.Name = "Book_Image21";
            this.Book_Image21.Size = new System.Drawing.Size(50, 75);
            this.Book_Image21.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image21.TabIndex = 2;
            this.Book_Image21.TabStop = false;
            // 
            // Book_Title21
            // 
            this.Book_Title21.AutoSize = true;
            this.Book_Title21.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title21.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title21.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title21.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title21.Location = new System.Drawing.Point(55, 0);
            this.Book_Title21.Name = "Book_Title21";
            this.Book_Title21.Size = new System.Drawing.Size(153, 14);
            this.Book_Title21.TabIndex = 11;
            this.Book_Title21.Text = "The ANATOMY OFmot ...";
            this.Book_Title21.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book23
            // 
            this.Book23.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book23.Controls.Add(this.panel48);
            this.Book23.Controls.Add(this.Book_Title23);
            this.Book23.Location = new System.Drawing.Point(454, 435);
            this.Book23.Name = "Book23";
            this.Book23.Size = new System.Drawing.Size(215, 75);
            this.Book23.TabIndex = 12;
            // 
            // panel48
            // 
            this.panel48.Controls.Add(this.Book_Image23);
            this.panel48.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel48.Location = new System.Drawing.Point(0, 0);
            this.panel48.Name = "panel48";
            this.panel48.Size = new System.Drawing.Size(50, 75);
            this.panel48.TabIndex = 12;
            // 
            // Book_Image23
            // 
            this.Book_Image23.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image23.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image23.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image23.Location = new System.Drawing.Point(0, 0);
            this.Book_Image23.Name = "Book_Image23";
            this.Book_Image23.Size = new System.Drawing.Size(50, 75);
            this.Book_Image23.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image23.TabIndex = 2;
            this.Book_Image23.TabStop = false;
            // 
            // Book_Title23
            // 
            this.Book_Title23.AutoSize = true;
            this.Book_Title23.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title23.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title23.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title23.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title23.Location = new System.Drawing.Point(55, 0);
            this.Book_Title23.Name = "Book_Title23";
            this.Book_Title23.Size = new System.Drawing.Size(153, 14);
            this.Book_Title23.TabIndex = 11;
            this.Book_Title23.Text = "The ANATOMY OFmot ...";
            this.Book_Title23.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book17
            // 
            this.Book17.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book17.Controls.Add(this.panel42);
            this.Book17.Controls.Add(this.Book_Title17);
            this.Book17.Location = new System.Drawing.Point(12, 354);
            this.Book17.Name = "Book17";
            this.Book17.Size = new System.Drawing.Size(215, 75);
            this.Book17.TabIndex = 12;
            this.Book17.Tag = "";
            // 
            // panel42
            // 
            this.panel42.Controls.Add(this.Book_Image17);
            this.panel42.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel42.Location = new System.Drawing.Point(0, 0);
            this.panel42.Name = "panel42";
            this.panel42.Size = new System.Drawing.Size(50, 75);
            this.panel42.TabIndex = 12;
            // 
            // Book_Image17
            // 
            this.Book_Image17.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image17.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image17.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image17.Location = new System.Drawing.Point(0, 0);
            this.Book_Image17.Name = "Book_Image17";
            this.Book_Image17.Size = new System.Drawing.Size(50, 75);
            this.Book_Image17.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image17.TabIndex = 2;
            this.Book_Image17.TabStop = false;
            // 
            // Book_Title17
            // 
            this.Book_Title17.AutoSize = true;
            this.Book_Title17.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title17.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title17.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title17.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title17.Location = new System.Drawing.Point(55, 0);
            this.Book_Title17.Name = "Book_Title17";
            this.Book_Title17.Size = new System.Drawing.Size(153, 14);
            this.Book_Title17.TabIndex = 11;
            this.Book_Title17.Text = "The ANATOMY OFmot ...";
            this.Book_Title17.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book19
            // 
            this.Book19.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book19.Controls.Add(this.panel40);
            this.Book19.Controls.Add(this.Book_Title19);
            this.Book19.Location = new System.Drawing.Point(454, 354);
            this.Book19.Name = "Book19";
            this.Book19.Size = new System.Drawing.Size(215, 75);
            this.Book19.TabIndex = 12;
            // 
            // panel40
            // 
            this.panel40.Controls.Add(this.Book_Image19);
            this.panel40.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel40.Location = new System.Drawing.Point(0, 0);
            this.panel40.Name = "panel40";
            this.panel40.Size = new System.Drawing.Size(50, 75);
            this.panel40.TabIndex = 12;
            // 
            // Book_Image19
            // 
            this.Book_Image19.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image19.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image19.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image19.Location = new System.Drawing.Point(0, 0);
            this.Book_Image19.Name = "Book_Image19";
            this.Book_Image19.Size = new System.Drawing.Size(50, 75);
            this.Book_Image19.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image19.TabIndex = 2;
            this.Book_Image19.TabStop = false;
            // 
            // Book_Title19
            // 
            this.Book_Title19.AutoSize = true;
            this.Book_Title19.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title19.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title19.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title19.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title19.Location = new System.Drawing.Point(55, 0);
            this.Book_Title19.Name = "Book_Title19";
            this.Book_Title19.Size = new System.Drawing.Size(153, 14);
            this.Book_Title19.TabIndex = 11;
            this.Book_Title19.Text = "The ANATOMY OFmot ...";
            this.Book_Title19.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book13
            // 
            this.Book13.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book13.Controls.Add(this.panel34);
            this.Book13.Controls.Add(this.Book_Title13);
            this.Book13.Location = new System.Drawing.Point(12, 273);
            this.Book13.Name = "Book13";
            this.Book13.Size = new System.Drawing.Size(215, 75);
            this.Book13.TabIndex = 12;
            this.Book13.Tag = "";
            // 
            // panel34
            // 
            this.panel34.Controls.Add(this.Book_Image13);
            this.panel34.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel34.Location = new System.Drawing.Point(0, 0);
            this.panel34.Name = "panel34";
            this.panel34.Size = new System.Drawing.Size(50, 75);
            this.panel34.TabIndex = 12;
            // 
            // Book_Image13
            // 
            this.Book_Image13.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image13.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image13.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image13.Location = new System.Drawing.Point(0, 0);
            this.Book_Image13.Name = "Book_Image13";
            this.Book_Image13.Size = new System.Drawing.Size(50, 75);
            this.Book_Image13.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image13.TabIndex = 2;
            this.Book_Image13.TabStop = false;
            // 
            // Book_Title13
            // 
            this.Book_Title13.AutoSize = true;
            this.Book_Title13.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title13.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title13.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title13.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title13.Location = new System.Drawing.Point(55, 0);
            this.Book_Title13.Name = "Book_Title13";
            this.Book_Title13.Size = new System.Drawing.Size(153, 14);
            this.Book_Title13.TabIndex = 11;
            this.Book_Title13.Text = "The ANATOMY OFmot ...";
            this.Book_Title13.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book15
            // 
            this.Book15.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book15.Controls.Add(this.panel32);
            this.Book15.Controls.Add(this.Book_Title15);
            this.Book15.Location = new System.Drawing.Point(454, 273);
            this.Book15.Name = "Book15";
            this.Book15.Size = new System.Drawing.Size(215, 75);
            this.Book15.TabIndex = 12;
            // 
            // panel32
            // 
            this.panel32.Controls.Add(this.Book_Image15);
            this.panel32.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel32.Location = new System.Drawing.Point(0, 0);
            this.panel32.Name = "panel32";
            this.panel32.Size = new System.Drawing.Size(50, 75);
            this.panel32.TabIndex = 12;
            // 
            // Book_Image15
            // 
            this.Book_Image15.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image15.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image15.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image15.Location = new System.Drawing.Point(0, 0);
            this.Book_Image15.Name = "Book_Image15";
            this.Book_Image15.Size = new System.Drawing.Size(50, 75);
            this.Book_Image15.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image15.TabIndex = 2;
            this.Book_Image15.TabStop = false;
            // 
            // Book_Title15
            // 
            this.Book_Title15.AutoSize = true;
            this.Book_Title15.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title15.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title15.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title15.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title15.Location = new System.Drawing.Point(55, 0);
            this.Book_Title15.Name = "Book_Title15";
            this.Book_Title15.Size = new System.Drawing.Size(153, 14);
            this.Book_Title15.TabIndex = 11;
            this.Book_Title15.Text = "The ANATOMY OFmot ...";
            this.Book_Title15.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book9
            // 
            this.Book9.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book9.Controls.Add(this.panel26);
            this.Book9.Controls.Add(this.Book_Title9);
            this.Book9.Location = new System.Drawing.Point(12, 192);
            this.Book9.Name = "Book9";
            this.Book9.Size = new System.Drawing.Size(215, 75);
            this.Book9.TabIndex = 12;
            this.Book9.Tag = "";
            // 
            // panel26
            // 
            this.panel26.Controls.Add(this.Book_Image9);
            this.panel26.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel26.Location = new System.Drawing.Point(0, 0);
            this.panel26.Name = "panel26";
            this.panel26.Size = new System.Drawing.Size(50, 75);
            this.panel26.TabIndex = 12;
            // 
            // Book_Image9
            // 
            this.Book_Image9.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image9.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image9.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image9.Location = new System.Drawing.Point(0, 0);
            this.Book_Image9.Name = "Book_Image9";
            this.Book_Image9.Size = new System.Drawing.Size(50, 75);
            this.Book_Image9.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image9.TabIndex = 2;
            this.Book_Image9.TabStop = false;
            // 
            // Book_Title9
            // 
            this.Book_Title9.AutoSize = true;
            this.Book_Title9.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title9.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title9.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title9.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title9.Location = new System.Drawing.Point(55, 0);
            this.Book_Title9.Name = "Book_Title9";
            this.Book_Title9.Size = new System.Drawing.Size(153, 14);
            this.Book_Title9.TabIndex = 11;
            this.Book_Title9.Text = "The ANATOMY OFmot ...";
            this.Book_Title9.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book11
            // 
            this.Book11.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book11.Controls.Add(this.panel24);
            this.Book11.Controls.Add(this.Book_Title11);
            this.Book11.Location = new System.Drawing.Point(454, 192);
            this.Book11.Name = "Book11";
            this.Book11.Size = new System.Drawing.Size(215, 75);
            this.Book11.TabIndex = 12;
            // 
            // panel24
            // 
            this.panel24.Controls.Add(this.Book_Image11);
            this.panel24.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel24.Location = new System.Drawing.Point(0, 0);
            this.panel24.Name = "panel24";
            this.panel24.Size = new System.Drawing.Size(50, 75);
            this.panel24.TabIndex = 12;
            // 
            // Book_Image11
            // 
            this.Book_Image11.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image11.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image11.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image11.Location = new System.Drawing.Point(0, 0);
            this.Book_Image11.Name = "Book_Image11";
            this.Book_Image11.Size = new System.Drawing.Size(50, 75);
            this.Book_Image11.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image11.TabIndex = 2;
            this.Book_Image11.TabStop = false;
            // 
            // Book_Title11
            // 
            this.Book_Title11.AutoSize = true;
            this.Book_Title11.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title11.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title11.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title11.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title11.Location = new System.Drawing.Point(55, 0);
            this.Book_Title11.Name = "Book_Title11";
            this.Book_Title11.Size = new System.Drawing.Size(153, 14);
            this.Book_Title11.TabIndex = 11;
            this.Book_Title11.Text = "The ANATOMY OFmot ...";
            this.Book_Title11.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book5
            // 
            this.Book5.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book5.Controls.Add(this.panel18);
            this.Book5.Controls.Add(this.Book_Title5);
            this.Book5.Location = new System.Drawing.Point(12, 111);
            this.Book5.Name = "Book5";
            this.Book5.Size = new System.Drawing.Size(215, 75);
            this.Book5.TabIndex = 12;
            this.Book5.Tag = "";
            // 
            // panel18
            // 
            this.panel18.Controls.Add(this.Book_Image5);
            this.panel18.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel18.Location = new System.Drawing.Point(0, 0);
            this.panel18.Name = "panel18";
            this.panel18.Size = new System.Drawing.Size(50, 75);
            this.panel18.TabIndex = 12;
            // 
            // Book_Image5
            // 
            this.Book_Image5.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image5.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image5.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image5.Location = new System.Drawing.Point(0, 0);
            this.Book_Image5.Name = "Book_Image5";
            this.Book_Image5.Size = new System.Drawing.Size(50, 75);
            this.Book_Image5.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image5.TabIndex = 2;
            this.Book_Image5.TabStop = false;
            // 
            // Book_Title5
            // 
            this.Book_Title5.AutoSize = true;
            this.Book_Title5.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title5.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title5.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title5.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title5.Location = new System.Drawing.Point(55, 0);
            this.Book_Title5.Name = "Book_Title5";
            this.Book_Title5.Size = new System.Drawing.Size(153, 14);
            this.Book_Title5.TabIndex = 11;
            this.Book_Title5.Text = "The ANATOMY OFmot ...";
            this.Book_Title5.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book7
            // 
            this.Book7.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book7.Controls.Add(this.panel16);
            this.Book7.Controls.Add(this.Book_Title7);
            this.Book7.Location = new System.Drawing.Point(454, 111);
            this.Book7.Name = "Book7";
            this.Book7.Size = new System.Drawing.Size(215, 75);
            this.Book7.TabIndex = 12;
            // 
            // panel16
            // 
            this.panel16.Controls.Add(this.Book_Image7);
            this.panel16.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel16.Location = new System.Drawing.Point(0, 0);
            this.panel16.Name = "panel16";
            this.panel16.Size = new System.Drawing.Size(50, 75);
            this.panel16.TabIndex = 12;
            // 
            // Book_Image7
            // 
            this.Book_Image7.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image7.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image7.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image7.Location = new System.Drawing.Point(0, 0);
            this.Book_Image7.Name = "Book_Image7";
            this.Book_Image7.Size = new System.Drawing.Size(50, 75);
            this.Book_Image7.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image7.TabIndex = 2;
            this.Book_Image7.TabStop = false;
            // 
            // Book_Title7
            // 
            this.Book_Title7.AutoSize = true;
            this.Book_Title7.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title7.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title7.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title7.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title7.Location = new System.Drawing.Point(55, 0);
            this.Book_Title7.Name = "Book_Title7";
            this.Book_Title7.Size = new System.Drawing.Size(153, 14);
            this.Book_Title7.TabIndex = 11;
            this.Book_Title7.Text = "The ANATOMY OFmot ...";
            this.Book_Title7.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book1
            // 
            this.Book1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book1.Controls.Add(this.panel15);
            this.Book1.Controls.Add(this.Book_Title1);
            this.Book1.Location = new System.Drawing.Point(12, 30);
            this.Book1.Name = "Book1";
            this.Book1.Size = new System.Drawing.Size(215, 75);
            this.Book1.TabIndex = 12;
            this.Book1.Tag = "";
            // 
            // panel15
            // 
            this.panel15.Controls.Add(this.Book_Image1);
            this.panel15.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel15.Location = new System.Drawing.Point(0, 0);
            this.panel15.Name = "panel15";
            this.panel15.Size = new System.Drawing.Size(50, 75);
            this.panel15.TabIndex = 12;
            // 
            // Book_Image1
            // 
            this.Book_Image1.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image1.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image1.Location = new System.Drawing.Point(0, 0);
            this.Book_Image1.Name = "Book_Image1";
            this.Book_Image1.Size = new System.Drawing.Size(50, 75);
            this.Book_Image1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image1.TabIndex = 2;
            this.Book_Image1.TabStop = false;
            // 
            // Book_Title1
            // 
            this.Book_Title1.AutoSize = true;
            this.Book_Title1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title1.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title1.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))));
            this.Book_Title1.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title1.Location = new System.Drawing.Point(55, 0);
            this.Book_Title1.Name = "Book_Title1";
            this.Book_Title1.Size = new System.Drawing.Size(153, 14);
            this.Book_Title1.TabIndex = 11;
            this.Book_Title1.Text = "The ANATOMY OFmot ...";
            this.Book_Title1.Click += new System.EventHandler(this.label7_Click);
            // 
            // Book3
            // 
            this.Book3.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book3.Controls.Add(this.panel9);
            this.Book3.Controls.Add(this.Book_Title3);
            this.Book3.Location = new System.Drawing.Point(454, 30);
            this.Book3.Name = "Book3";
            this.Book3.Size = new System.Drawing.Size(215, 75);
            this.Book3.TabIndex = 12;
            // 
            // panel9
            // 
            this.panel9.Controls.Add(this.Book_Image3);
            this.panel9.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel9.Location = new System.Drawing.Point(0, 0);
            this.panel9.Name = "panel9";
            this.panel9.Size = new System.Drawing.Size(50, 75);
            this.panel9.TabIndex = 12;
            // 
            // Book_Image3
            // 
            this.Book_Image3.BackColor = System.Drawing.Color.Goldenrod;
            this.Book_Image3.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Book_Image3.Dock = System.Windows.Forms.DockStyle.Left;
            this.Book_Image3.Location = new System.Drawing.Point(0, 0);
            this.Book_Image3.Name = "Book_Image3";
            this.Book_Image3.Size = new System.Drawing.Size(50, 75);
            this.Book_Image3.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Book_Image3.TabIndex = 2;
            this.Book_Image3.TabStop = false;
            // 
            // Book_Title3
            // 
            this.Book_Title3.AutoSize = true;
            this.Book_Title3.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.Book_Title3.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Book_Title3.Font = new System.Drawing.Font("Trajan Pro", 8F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Book_Title3.ForeColor = System.Drawing.Color.DarkGoldenrod;
            this.Book_Title3.Location = new System.Drawing.Point(55, 0);
            this.Book_Title3.Name = "Book_Title3";
            this.Book_Title3.Size = new System.Drawing.Size(153, 14);
            this.Book_Title3.TabIndex = 11;
            this.Book_Title3.Text = "The ANATOMY OFmot ...";
            this.Book_Title3.Click += new System.EventHandler(this.label7_Click);
            // 
            // Exit1
            // 
            this.Exit1.BackgroundImage = global::WindowsFormsApp1.Properties.Resources.icons8_Close_Window_96px;
            this.Exit1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.Exit1.Cursor = System.Windows.Forms.Cursors.Hand;
            this.Exit1.Location = new System.Drawing.Point(880, 0);
            this.Exit1.Name = "Exit1";
            this.Exit1.Size = new System.Drawing.Size(20, 20);
            this.Exit1.TabIndex = 20;
            this.Exit1.TabStop = false;
            this.Exit1.Click += new System.EventHandler(this.Exit1_Click);
            // 
            // pictureBox2
            // 
            this.pictureBox2.BackgroundImage = global::WindowsFormsApp1.Properties.Resources.icons8_Open_Book_100px_3;
            this.pictureBox2.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.pictureBox2.Location = new System.Drawing.Point(589, 4);
            this.pictureBox2.Name = "pictureBox2";
            this.pictureBox2.Size = new System.Drawing.Size(43, 43);
            this.pictureBox2.TabIndex = 14;
            this.pictureBox2.TabStop = false;
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackgroundImage = global::WindowsFormsApp1.Properties.Resources.icons8_Open_Book_100px_3;
            this.pictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.pictureBox1.Location = new System.Drawing.Point(223, 4);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(43, 43);
            this.pictureBox1.TabIndex = 2;
            this.pictureBox1.TabStop = false;
            this.pictureBox1.Click += new System.EventHandler(this.pictureBox1_Click);
            // 
            // Application_Window
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(30)))), ((int)(((byte)(30)))));
            this.ClientSize = new System.Drawing.Size(900, 600);
            this.Controls.Add(this.Exit1);
            this.Controls.Add(this.pictureBox2);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.LOGIN);
            this.Controls.Add(this.Panel2);
            this.Controls.Add(this.panel1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Application_Window";
            this.Opacity = 0.97D;
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Application_Window_Load);
            this.MouseDown += new System.Windows.Forms.MouseEventHandler(this.Application_Window_MouseDown);
            this.MouseMove += new System.Windows.Forms.MouseEventHandler(this.Application_Window_MouseMove);
            this.MouseUp += new System.Windows.Forms.MouseEventHandler(this.Application_Window_MouseUp);
            this.panel1.ResumeLayout(false);
            this.Most_Rated_Background.ResumeLayout(false);
            this.Most_Rated_Background.PerformLayout();
            this.Most_Voted_Background.ResumeLayout(false);
            this.Most_Voted_Background.PerformLayout();
            this.Recomended_Background.ResumeLayout(false);
            this.Recomended_Background.PerformLayout();
            this.Recent_Background.ResumeLayout(false);
            this.Recent_Background.PerformLayout();
            this.Panel2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox29)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox28)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox27)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox26)).EndInit();
            this.Book24.ResumeLayout(false);
            this.Book24.PerformLayout();
            this.panel54.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image24)).EndInit();
            this.Book20.ResumeLayout(false);
            this.Book20.PerformLayout();
            this.panel46.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image20)).EndInit();
            this.Book16.ResumeLayout(false);
            this.Book16.PerformLayout();
            this.panel38.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image16)).EndInit();
            this.Book12.ResumeLayout(false);
            this.Book12.PerformLayout();
            this.panel30.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image12)).EndInit();
            this.Book8.ResumeLayout(false);
            this.Book8.PerformLayout();
            this.panel22.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image8)).EndInit();
            this.Book4.ResumeLayout(false);
            this.Book4.PerformLayout();
            this.panel11.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image4)).EndInit();
            this.Book22.ResumeLayout(false);
            this.Book22.PerformLayout();
            this.panel52.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image22)).EndInit();
            this.Book18.ResumeLayout(false);
            this.Book18.PerformLayout();
            this.panel44.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image18)).EndInit();
            this.Book14.ResumeLayout(false);
            this.Book14.PerformLayout();
            this.panel36.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image14)).EndInit();
            this.Book10.ResumeLayout(false);
            this.Book10.PerformLayout();
            this.panel28.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image10)).EndInit();
            this.Book6.ResumeLayout(false);
            this.Book6.PerformLayout();
            this.panel20.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image6)).EndInit();
            this.Book2.ResumeLayout(false);
            this.Book2.PerformLayout();
            this.panel13.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image2)).EndInit();
            this.Book21.ResumeLayout(false);
            this.Book21.PerformLayout();
            this.panel50.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image21)).EndInit();
            this.Book23.ResumeLayout(false);
            this.Book23.PerformLayout();
            this.panel48.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image23)).EndInit();
            this.Book17.ResumeLayout(false);
            this.Book17.PerformLayout();
            this.panel42.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image17)).EndInit();
            this.Book19.ResumeLayout(false);
            this.Book19.PerformLayout();
            this.panel40.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image19)).EndInit();
            this.Book13.ResumeLayout(false);
            this.Book13.PerformLayout();
            this.panel34.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image13)).EndInit();
            this.Book15.ResumeLayout(false);
            this.Book15.PerformLayout();
            this.panel32.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image15)).EndInit();
            this.Book9.ResumeLayout(false);
            this.Book9.PerformLayout();
            this.panel26.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image9)).EndInit();
            this.Book11.ResumeLayout(false);
            this.Book11.PerformLayout();
            this.panel24.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image11)).EndInit();
            this.Book5.ResumeLayout(false);
            this.Book5.PerformLayout();
            this.panel18.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image5)).EndInit();
            this.Book7.ResumeLayout(false);
            this.Book7.PerformLayout();
            this.panel16.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image7)).EndInit();
            this.Book1.ResumeLayout(false);
            this.Book1.PerformLayout();
            this.panel15.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image1)).EndInit();
            this.Book3.ResumeLayout(false);
            this.Book3.PerformLayout();
            this.panel9.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.Book_Image3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.Exit1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Label LOGIN;
        private System.Windows.Forms.PictureBox pictureBox2;
        private System.Windows.Forms.PictureBox Exit1;
        private System.Windows.Forms.Panel Most_Rated_Background;
        private System.Windows.Forms.Label Most_Rated;
        private System.Windows.Forms.Panel Most_Voted_Background;
        private System.Windows.Forms.Label Most_Voted;
        private System.Windows.Forms.Panel Recomended_Background;
        private System.Windows.Forms.Label Recent;
        private System.Windows.Forms.Panel Recent_Background;
        private System.Windows.Forms.Label Recomended;
        private System.Windows.Forms.Panel panel6;
        private System.Windows.Forms.Panel Panel2;
        private System.Windows.Forms.Label Book_Title3;
        private System.Windows.Forms.PictureBox Book_Image3;
        private System.Windows.Forms.Panel Book3;
        private System.Windows.Forms.Panel panel9;
        private System.Windows.Forms.Panel Book4;
        private System.Windows.Forms.Panel panel11;
        private System.Windows.Forms.PictureBox Book_Image4;
        private System.Windows.Forms.Label Book_Title4;
        private System.Windows.Forms.Panel Book1;
        private System.Windows.Forms.Panel panel15;
        private System.Windows.Forms.PictureBox Book_Image1;
        private System.Windows.Forms.Label Book_Title1;
        private System.Windows.Forms.Panel Book24;
        private System.Windows.Forms.Panel panel54;
        private System.Windows.Forms.PictureBox Book_Image24;
        private System.Windows.Forms.Label Book_Title24;
        private System.Windows.Forms.Panel Book20;
        private System.Windows.Forms.Panel panel46;
        private System.Windows.Forms.PictureBox Book_Image20;
        private System.Windows.Forms.Label Book_Title20;
        private System.Windows.Forms.Panel Book16;
        private System.Windows.Forms.Panel panel38;
        private System.Windows.Forms.PictureBox Book_Image16;
        private System.Windows.Forms.Label Book_Title16;
        private System.Windows.Forms.Panel Book12;
        private System.Windows.Forms.Panel panel30;
        private System.Windows.Forms.PictureBox Book_Image12;
        private System.Windows.Forms.Label Book_Title12;
        private System.Windows.Forms.Panel Book8;
        private System.Windows.Forms.Panel panel22;
        private System.Windows.Forms.PictureBox Book_Image8;
        private System.Windows.Forms.Label Book_Title8;
        private System.Windows.Forms.Panel panel52;
        private System.Windows.Forms.PictureBox Book_Image22;
        private System.Windows.Forms.Label Book_Title22;
        private System.Windows.Forms.Panel panel44;
        private System.Windows.Forms.PictureBox Book_Image18;
        private System.Windows.Forms.Label Book_Title18;
        private System.Windows.Forms.Panel panel36;
        private System.Windows.Forms.PictureBox Book_Image14;
        private System.Windows.Forms.Label Book_Title14;
        private System.Windows.Forms.Panel panel28;
        private System.Windows.Forms.PictureBox Book_Image10;
        private System.Windows.Forms.Label Book_Title10;
        private System.Windows.Forms.Panel panel20;
        private System.Windows.Forms.PictureBox Book_Image6;
        private System.Windows.Forms.Label Book_Title6;
        private System.Windows.Forms.Panel panel13;
        private System.Windows.Forms.PictureBox Book_Image2;
        private System.Windows.Forms.Label Book_Title2;
        private System.Windows.Forms.Panel Book21;
        private System.Windows.Forms.Panel panel50;
        private System.Windows.Forms.PictureBox Book_Image21;
        private System.Windows.Forms.Label Book_Title21;
        private System.Windows.Forms.Panel Book23;
        private System.Windows.Forms.Panel panel48;
        private System.Windows.Forms.PictureBox Book_Image23;
        private System.Windows.Forms.Label Book_Title23;
        private System.Windows.Forms.Panel Book17;
        private System.Windows.Forms.Panel panel42;
        private System.Windows.Forms.PictureBox Book_Image17;
        private System.Windows.Forms.Label Book_Title17;
        private System.Windows.Forms.Panel Book19;
        private System.Windows.Forms.Panel panel40;
        private System.Windows.Forms.PictureBox Book_Image19;
        private System.Windows.Forms.Label Book_Title19;
        private System.Windows.Forms.Panel Book13;
        private System.Windows.Forms.Panel panel34;
        private System.Windows.Forms.PictureBox Book_Image13;
        private System.Windows.Forms.Label Book_Title13;
        private System.Windows.Forms.Panel Book15;
        private System.Windows.Forms.Panel panel32;
        private System.Windows.Forms.PictureBox Book_Image15;
        private System.Windows.Forms.Label Book_Title15;
        private System.Windows.Forms.Panel Book9;
        private System.Windows.Forms.Panel panel26;
        private System.Windows.Forms.PictureBox Book_Image9;
        private System.Windows.Forms.Label Book_Title9;
        private System.Windows.Forms.Panel Book11;
        private System.Windows.Forms.Panel panel24;
        private System.Windows.Forms.PictureBox Book_Image11;
        private System.Windows.Forms.Label Book_Title11;
        private System.Windows.Forms.Panel Book5;
        private System.Windows.Forms.Panel panel18;
        private System.Windows.Forms.PictureBox Book_Image5;
        private System.Windows.Forms.Label Book_Title5;
        private System.Windows.Forms.Panel Book7;
        private System.Windows.Forms.Panel panel16;
        private System.Windows.Forms.PictureBox Book_Image7;
        private System.Windows.Forms.Label Book_Title7;
        private System.Windows.Forms.PictureBox pictureBox26;
        private System.Windows.Forms.PictureBox pictureBox28;
        private System.Windows.Forms.PictureBox pictureBox27;
        private System.Windows.Forms.PictureBox pictureBox29;
        private System.Windows.Forms.Panel Book22;
        private System.Windows.Forms.Panel Book18;
        private System.Windows.Forms.Panel Book14;
        private System.Windows.Forms.Panel Book10;
        private System.Windows.Forms.Panel Book6;
        private System.Windows.Forms.Panel Book2;
    }
}