using SahanaKutuphane.Models;
using System;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.Helpers;
using System.Web.Mvc;

namespace SahanaKutuphane.Controllers
{
    public class AdminController : Controller
    {
        KutuphaneDB database = new KutuphaneDB();

        public ActionResult Index()
        {
            return View(database.Kitap.ToList());
        }

        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [ValidateInput(false)]
        public ActionResult Create(Kitap kitap, HttpPostedFileBase KitapResimURL)
        {
            if (ModelState.IsValid)
            {
                if (KitapResimURL != null)
                {
                    WebImage img = new WebImage(KitapResimURL.InputStream);
                    FileInfo imginfo = new FileInfo(KitapResimURL.FileName);

                    string resim = KitapResimURL.FileName + imginfo.Extension;
                    img.Resize(250, 375);
                    img.Save("~/Uploads/Kitaplar/" + resim);
                    kitap.Kullanımda = 0;
                    kitap.GetirmeTarih = DateTime.Now;
                    kitap.KitapResimURL = "~/Uploads/Kitaplar/" + resim;
                }

                database.Kitap.Add(kitap);
                database.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(kitap);
        }

        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                ViewBag.Uyari = "Güncellenecek Kitap Bilgisi Bulunamdı.";
            }

            var kitap = database.Kitap.Find(id);
            if (kitap==null)
            {
                return HttpNotFound();
            }
            return View(kitap);
        }

        [HttpPost]
        [ValidateInput(false)]
        public ActionResult Edit(int? id, Kitap kitap, HttpPostedFileBase KitapResimURL)
        {
           
            if (ModelState.IsValid)
            {
                var k = database.Kitap.Where(x => x.KitapId == id).SingleOrDefault();
                if (KitapResimURL == null)
                {
                    if (System.IO.File.Exists(Server.MapPath(k.KitapResimURL)))
                    {
                        System.IO.File.Delete(Server.MapPath(k.KitapResimURL));
                    }
                    WebImage img = new WebImage(KitapResimURL.InputStream);
                    FileInfo imginfo = new FileInfo(KitapResimURL.FileName);

                    string resim = KitapResimURL.FileName + imginfo.Extension;
                    img.Resize(250, 375);
                    img.Save("~/Uploads/Kitaplar/" + resim);
                    k.Kullanımda = 0;
                    k.KitapResimURL = "~/Uploads/Kitaplar/" + resim;
                }

                k.KitapAd = kitap.KitapAd;
                k.KitapAciklama = kitap.KitapAciklama;
               
                database.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(kitap);
        }

        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return HttpNotFound();
            }

            var k = database.Kitap.Find(id);

            if (k == null)
            {
                return HttpNotFound();
            }
            database.Kitap.Remove(k);
            database.SaveChanges();

            return RedirectToAction("Index");
        }

        public ActionResult UyeGetir()
        {
            var uyeler = database.Uye.ToList();
            return View(uyeler);
        }

        public ActionResult ZamanAtla()
        {
            return View();
        }     

        [HttpPost]
        [ValidateInput(false)]
        public ActionResult ZamanAtla(string gelen)
        {
            DateTime date = Convert.ToDateTime(gelen);
            var kitapListe = database.Kitap.ToList();

            foreach (var item in kitapListe)
            {
                item.GetirmeTarih = date;
            }
            return RedirectToAction("Index");
        }

        public ActionResult LogIn()
        {
            return View();
        }

        [HttpPost]
        public ActionResult LogIn(Admin admin, Uye uye)
        {
            var log = database.Admin.Where(x => x.AdminAd == admin.AdminAd).SingleOrDefault();
            var uyelog = database.Uye.Where(x => x.UyeId == uye.UyeId).SingleOrDefault();
            if (log.AdminAd == admin.AdminAd && log.AdminSifre == admin.AdminSifre)
            {
                Session["adminid"] = log.AdminAd;
                Session["sifre"] = log.AdminSifre;
                return RedirectToAction("Index","Admin");
            }
            else if (uyelog.UyeId == uye.UyeId && uyelog.UyeSifre == uye.UyeSifre)
            {
                Session["uyeid"] = uyelog.UyeAd;
                Session["uyesifre"] = uyelog.UyeSifre;
                return RedirectToAction("Index","Uye");
            }

            ViewBag.Uyari = "Kullanıcı Adi ve ya Şİfre Yanlıştır.";
            return View(admin);
        }

        public ActionResult Logout()
        {
            Session["adminad"] = null;
            Session["sifre"] = null;

            Session.Abandon();

            return RedirectToAction("Login","Admin");

        }
    }
}