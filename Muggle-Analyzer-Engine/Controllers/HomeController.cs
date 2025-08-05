using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using HtmlAgilityPack;

namespace MuggleAnalyzerEngine.Controllers
{
    public class HomeController : Controller
    {
        List<String> sayfaStrings = new List<String>();
        int[] sayfaCount = new int[1000];

        List<String> digerSayfaStrings = new List<String>();
        int[] digerSayfaCount = new int[1000];

        int[] tempSira1 = new int[1000];
        int[] tempSira2 = new int[1000];

        List<String> sayfa1Keys = new List<String>();
        List<String> sayfa2Keys = new List<String>();

        [HttpGet]
        public ActionResult Index()
        {
            return View("Index");
        }

        [HttpPost]
        public ActionResult Index(string urlFirst, string urlSecond)
        {
            string url1 = urlFirst.ToLower();
            ViewBag.uriFirst = url1;

            //Verilen 2 Url Icin Gecerlidir.            
            if (!urlSecond.Equals(""))
            {
                Console.WriteLine("Ikinci URL Bos");
                digerSite(urlSecond);
                keywordsHesap();
                ViewBag.uriSecond = urlSecond;
            }

            Uri url11 = new Uri(url1);
            WebClient client = new WebClient();
            string html = client.DownloadString(url11);

            HtmlAgilityPack.HtmlDocument dokuman = new HtmlAgilityPack.HtmlDocument();
            dokuman.LoadHtml(html);

            List<String> allWord = new List<String>();
            List<String> singleWords = new List<String>();
            List<String> bruteForceStrings = new List<String>();
            string[] allSingleWords = new string[1000];
            int[] repeatCount = new int[1000];

            HtmlNodeCollection basliklar = dokuman.DocumentNode.SelectNodes("/html/body/div[1]/div/main/div/div[0]");

            for (int i = 1; i < 1000; i++)
            {
                string tempString = "/html/body/div[1]/div/main/div/div[" + i.ToString() + "]";
                basliklar = dokuman.DocumentNode.SelectNodes(tempString);

                if (basliklar != null)
                {
                    foreach (var baslik in basliklar)
                    {
                        allWord.Add(baslik.InnerText);
                    }
                }
            }

            for (int i = 0; i < allWord.Count; i++)
            {
                allSingleWords[i] = allWord[i].ToString();
                string[] tempString = allSingleWords[i].Split(new string[] { "\\", "/", " ", ", ", ". ", ".", " .", "- ", " - ", " -", "! ", "? ", ":", ";", "+", "*", "(", ")", "...", "@", "#", "^", "$", "&" }, System.StringSplitOptions.RemoveEmptyEntries);

                foreach (var doit in tempString)
                {
                    singleWords.Add(doit);
                }
            }

            int counterSingleWords = 0;
            bool semafor = false;
            bool tempSemafor = true;
            bool badSemafor = true;

            bruteForceStrings.Add("");

            for (int i = 0; i < singleWords.Count; i++)
            {
                for (int j = 0; j < bruteForceStrings.Count; j++)
                {
                    if (singleWords[i] == bruteForceStrings[j])
                    {
                        if (badSemafor)
                        {
                            repeatCount[j]++;
                            badSemafor = false;
                        }
                        tempSemafor = false;
                        semafor = false;
                    }
                    else
                    {
                        if (tempSemafor)
                        {
                            semafor = true;
                        }
                    }
                }
                if (semafor)
                {
                    bruteForceStrings.Add(singleWords[i]);
                    semafor = false;
                }
                tempSemafor = true;
                badSemafor = true;
                counterSingleWords++;
            }

            for (int i = 0; i < bruteForceStrings.Count; i++)
            {
                sayfaStrings.Add(bruteForceStrings[i]);
            }

            for (int i = 0; i < repeatCount.Length; i++)
            {
                sayfaCount[i] = repeatCount[i];
            }

            ViewBag.data = bruteForceStrings;
            ViewBag.count = repeatCount;

            keywordshesap2();

            int benzerlikOrani = benzerlikOranHesapla();
            ViewBag.benzerOrani = benzerlikOrani;
            return View("ResultPage");
        }

        public void digerSite(string urlDigerSite)
        {

            Uri url11 = new Uri(urlDigerSite);
            WebClient client = new WebClient();
            string html = client.DownloadString(url11);

            HtmlAgilityPack.HtmlDocument dokuman = new HtmlAgilityPack.HtmlDocument();
            dokuman.LoadHtml(html);

            List<String> allWord = new List<String>();
            List<String> singleWords = new List<String>();
            List<String> bruteForceStrings = new List<String>();
            string[] allSingleWords = new string[1000];
            int[] repeatCount = new int[1000];

            HtmlNodeCollection basliklar = dokuman.DocumentNode.SelectNodes("/html/body/div[1]/div/main/div/div[0]");
            for (int i = 1; i < 1000; i++)
            {
                string tempString = "/html/body/div[1]/div/main/div/div[" + i.ToString() + "]";
                basliklar = dokuman.DocumentNode.SelectNodes(tempString);

                if (basliklar != null)
                {
                    foreach (var baslik in basliklar)
                    {
                        // Biraz önceki basliklar koleksiyonunu tek tek gezerek, her bir elemanının içindeki text'i alıyoruz
                        allWord.Add(baslik.InnerText);
                    }
                }
            }

            for (int i = 0; i < allWord.Count; i++)
            {
                allSingleWords[i] = allWord[i].ToString();
                string[] tempString = allSingleWords[i].Split(new string[] { "\\", "/", " ", ", ", ". ", "- ", " - ", " -", "! ", "? ", ":", ";", "+", "*", "(", ")", "...", "@", "#", "^", "$", "&" }, System.StringSplitOptions.RemoveEmptyEntries);

                foreach (var doit in tempString)
                {
                    singleWords.Add(doit);
                }
            }

            int counterSingleWords = 0;
            bool semafor = false;
            bool tempSemafor = true;
            bool badSemafor = true;

            bruteForceStrings.Add("");

            for (int i = 0; i < singleWords.Count; i++)
            {
                for (int j = 0; j < bruteForceStrings.Count; j++)
                {
                    if (singleWords[i] == bruteForceStrings[j])
                    {
                        if (badSemafor)
                        {
                            repeatCount[j]++;
                            badSemafor = false;
                        }
                        tempSemafor = false;
                        semafor = false;
                    }
                    else
                    {
                        if (tempSemafor)
                        {
                            semafor = true;
                        }
                    }
                }
                if (semafor)
                {
                    bruteForceStrings.Add(singleWords[i]);
                    semafor = false;
                }
                tempSemafor = true;
                badSemafor = true;
                counterSingleWords++;
            }

            for (int i = 0; i < bruteForceStrings.Count; i++)
            {
                digerSayfaStrings.Add(bruteForceStrings[i]);
            }

            for (int i = 0; i < repeatCount.Length; i++)
            {
                digerSayfaCount[i] = repeatCount[i];
            }


            ViewBag.data2 = bruteForceStrings;
            ViewBag.count2 = repeatCount;

        }

        public void keywordsHesap()
        {


            for (int i = 0; i < digerSayfaStrings.Count; i++)
            {
                if (digerSayfaCount[i] > 5)
                {
                    sayfa2Keys.Add(digerSayfaStrings[i]);
                }
            }

            ViewBag.sayfa2Keyleri = sayfa2Keys;

        }

        public void keywordshesap2()
        {
            for (int i = 0; i < sayfaStrings.Count; i++)
            {
                if (sayfaCount[i] > 5)
                {
                    sayfa1Keys.Add(sayfaStrings[i]);
                }
            }
            ViewBag.sayfa1Keyleri = sayfa1Keys;
        }

        public int benzerlikOranHesapla()
        {
            int katsayi = 1;
            int bosOran = 0;

            int ilkGenislik = sayfa1Keys.Count;
            int ikinciGenislik = sayfa2Keys.Count;

            if (ilkGenislik < ikinciGenislik)
            {
                for (int i = 0; i < sayfa1Keys.Count; i++)
                {
                    for (int j = 0; j < sayfa2Keys.Count; j++)
                    {

                        if (sayfa1Keys[i] == sayfa2Keys[j])
                        {
                            katsayi++;
                        }
                    }
                }
                int skorOrani = 100 * katsayi / ikinciGenislik;
                return skorOrani;
            }

            if (ilkGenislik > ikinciGenislik)
            {
                for (int i = 0; i < sayfa2Keys.Count; i++)
                {
                    for (int j = 0; j < sayfa2Keys.Count; j++)
                    {
                        if (sayfa1Keys[i] == sayfa2Keys[j])
                        {
                            katsayi++;
                        }
                    }
                }
                int skorOrani = 100 * katsayi / ilkGenislik;
                return skorOrani;
            }

            if (ilkGenislik == ikinciGenislik)
            {
                for (int i = 0; i < sayfa2Keys.Count; i++)
                {
                    if (sayfa1Keys[i] == sayfa2Keys[i])
                    {
                        katsayi++;
                    }
                }
                int skorOrani = 100 * katsayi / ilkGenislik;
                return skorOrani;
            }
            return bosOran;
        }
    }
}