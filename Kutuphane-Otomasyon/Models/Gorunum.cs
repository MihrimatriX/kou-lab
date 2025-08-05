using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SahanaKutuphane.Models
{
    public class Gorunum
    {
        public IEnumerable<Kitap> Kitaps { get; set; }
        public IEnumerable<Uye> Uyes { get; set; }
    }
}