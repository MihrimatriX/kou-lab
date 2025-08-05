namespace SahanaKutuphane.Models
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;

    public partial class KutuphaneDB : DbContext
    {
        public KutuphaneDB() : base("name=KutuphaneDB")
        {
        }

        public virtual DbSet<Admin> Admin { get; set; }
        public virtual DbSet<Kitap> Kitap { get; set; }
        public virtual DbSet<sysdiagrams> sysdiagrams { get; set; }
        public virtual DbSet<Uye> Uye { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Kitap>()
                .HasMany(e => e.Uye)
            .WithRequired(e => e.Kitap)
             .WillCascadeOnDelete(false);

            modelBuilder.Entity<Uye>()
                .Property(e => e.CezaliKitap)
                .IsFixedLength();

            modelBuilder.Entity<Uye>()
                .HasMany(e => e.Admin)
                .WithRequired(e => e.Uye)
                .WillCascadeOnDelete(false);
        }
    }
}
