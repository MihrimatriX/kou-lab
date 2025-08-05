namespace SahanaKutuphane.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("Kitap")]
    public partial class Kitap
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public Kitap()
        {
            Uye = new HashSet<Uye>();
        }

        public int KitapId { get; set; }

        [Required]
        [StringLength(50)]
        public string KitapAd { get; set; }

        [StringLength(30)]
        public string KitapISBN { get; set; }

        [Required]
        [StringLength(250)]
        public string KitapResimURL { get; set; }

        public string KitapAciklama { get; set; }

        [Column(TypeName = "date")]
        public DateTime? AlmaTarih { get; set; }

        [Column(TypeName = "date")]
        public DateTime? GetirmeTarih { get; set; }

        public int? Kullanımda { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<Uye> Uye { get; set; }
    }
}
