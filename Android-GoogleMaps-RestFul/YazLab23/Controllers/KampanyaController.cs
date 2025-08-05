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
    public class KampanyaController : ApiController
    {
        private YazLab23Entities3 db = new YazLab23Entities3();

        // GET: api/Kampanya
        public IQueryable<Kampanya> GetKampanya()
        {
            return db.Kampanya;
        }

        // GET: api/Kampanya/5
        [ResponseType(typeof(Kampanya))]
        public IHttpActionResult GetKampanya(int id)
        {
            Kampanya kampanya = db.Kampanya.Find(id);
            if (kampanya == null)
            {
                return NotFound();
            }

            return Ok(kampanya);
        }

        // PUT: api/Kampanya/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutKampanya(int id, Kampanya kampanya)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != kampanya.FirmaID)
            {
                return BadRequest();
            }

            db.Entry(kampanya).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!KampanyaExists(id))
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

        // POST: api/Kampanya
        [ResponseType(typeof(Kampanya))]
        public IHttpActionResult PostKampanya(Kampanya kampanya)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Kampanya.Add(kampanya);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = kampanya.FirmaID }, kampanya);
        }

        // DELETE: api/Kampanya/5
        [ResponseType(typeof(Kampanya))]
        public IHttpActionResult DeleteKampanya(int id)
        {
            Kampanya kampanya = db.Kampanya.Find(id);
            if (kampanya == null)
            {
                return NotFound();
            }

            db.Kampanya.Remove(kampanya);
            db.SaveChanges();

            return Ok(kampanya);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool KampanyaExists(int id)
        {
            return db.Kampanya.Count(e => e.FirmaID == id) > 0;
        }
    }
}