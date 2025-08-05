namespace SahanaKutuphane.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("Admin")]
    public partial class Admin
    {
        public int AdminId { get; set; }

        [Required]
        [StringLength(50)]
        public string AdminAd { get; set; }

        [Required]
        [StringLength(30)]
        public string AdminSifre { get; set; }

        public int UyeId { get; set; }

        public virtual Uye Uye { get; set; }
    }
}
