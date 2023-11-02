/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.entidades.AlumnoCuota;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author juanmarobles
 */
public class AlumnoCuotaJpaController implements Serializable {

    public AlumnoCuotaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //CONTROLADOR
    public AlumnoCuotaJpaController() {
        emf = Persistence.createEntityManagerFactory("centroeducativoPU");
    }

    public void create(AlumnoCuota alumnoCuota) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alumnoCuota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AlumnoCuota alumnoCuota) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            alumnoCuota = em.merge(alumnoCuota);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = alumnoCuota.getId();
                if (findAlumnoCuota(id) == null) {
                    throw new NonexistentEntityException("The alumnoCuota with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AlumnoCuota alumnoCuota;
            try {
                alumnoCuota = em.getReference(AlumnoCuota.class, id);
                alumnoCuota.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alumnoCuota with id " + id + " no longer exists.", enfe);
            }
            em.remove(alumnoCuota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AlumnoCuota> findAlumnoCuotaEntities() {
        return findAlumnoCuotaEntities(true, -1, -1);
    }

    public List<AlumnoCuota> findAlumnoCuotaEntities(int maxResults, int firstResult) {
        return findAlumnoCuotaEntities(false, maxResults, firstResult);
    }

    private List<AlumnoCuota> findAlumnoCuotaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AlumnoCuota.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public AlumnoCuota findAlumnoCuota(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AlumnoCuota.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlumnoCuotaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AlumnoCuota> rt = cq.from(AlumnoCuota.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
