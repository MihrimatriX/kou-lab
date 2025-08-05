namespace SahanaKutuphane.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("Uye")]
    public partial class Uye
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public Uye()
        {
            Admin = new HashSet<Admin>();
        }

        public int UyeId { get; set; }

        [Required]
        [StringLength(50)]
        public string UyeAd { get; set; }

        [Required]
        [StringLength(30)]
        public string UyeSifre { get; set; }

        [StringLength(10)]
        public string CezaliKitap { get; set; }

        [StringLength(10)]
        public string UyeFoto { get; set; }

        public int KitapId { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<Admin> Admin { get; set; }

        public virtual Kitap Kitap { get; set; }
    }
}
