using SahanaKutuphane.Models;
using System;
using System.Linq;
using System.Web.Mvc;

namespace SahanaKutuphane.Controllers
{
    public class UyeController : Controller
    {
        KutuphaneDB database = new KutuphaneDB();

        public ActionResult Index()
        {
            var ustum = database.Kitap.ToList();

            for (int i = 0;  ustum != null ; i++)
            {

            }

            return View(database.Kitap.ToList());
        }
        
        public ActionResult KitapAl(int id)
        {
            var kitap = database.Kitap.Where(x => x.KitapId == id).SingleOrDefault();

            kitap.AlmaTarih = DateTime.Now;
            kitap.Kullanımda = 1;
            return View();
        }
        
        public ActionResult KitapAra()
        {
            return View(database.Kitap.ToList());
        }

        public ActionResult KitapVer(int id)
        {
            var kitap = database.Kitap.Where(x => x.KitapId == id).SingleOrDefault();
            kitap.GetirmeTarih = DateTime.Now;
            kitap.Kullanımda = 0;
            return View();
        }
    }
}