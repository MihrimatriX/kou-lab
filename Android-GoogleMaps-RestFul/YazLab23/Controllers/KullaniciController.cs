using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using YazLab23.Models;

namespace YazLab23.Controllers
{
    public class KullaniciController : ApiController
    {
        private YazLab23Entities3 db = new YazLab23Entities3();

        // GET: api/Kullanici
        public IQueryable<Kullanici> GetKullanici()
        {
            return db.Kullanici;
        }

        // GET: api/Kullanici/5
        [ResponseType(typeof(Kullanici))]
        public IHttpActionResult GetKullanici(string id)
        {
            Kullanici kullanici = db.Kullanici.Find(id);
            if (kullanici == null)
            {
                return NotFound();
            }

            return Ok(kullanici);
        }

        // PUT: api/Kullanici/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutKullanici(string id, Kullanici kullanici)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != kullanici.KullaniciAdi)
            {
                return BadRequest();
            }

            db.Entry(kullanici).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!KullaniciExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/Kullanici
        [ResponseType(typeof(Kullanici))]
        public IHttpActionResult PostKullanici(Kullanici kullanici)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Kullanici.Add(kullanici);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (KullaniciExists(kullanici.KullaniciAdi))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = kullanici.KullaniciAdi }, kullanici);
        }

        // DELETE: api/Kullanici/5
        [ResponseType(typeof(Kullanici))]
        public IHttpActionResult DeleteKullanici(string id)
        {
            Kullanici kullanici = db.Kullanici.Find(id);
            if (kullanici == null)
            {
                return NotFound();
            }

            db.Kullanici.Remove(kullanici);
            db.SaveChanges();

            return Ok(kullanici);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool KullaniciExists(string id)
        {
            return db.Kullanici.Count(e => e.KullaniciAdi == id) > 0;
        }
    }
}