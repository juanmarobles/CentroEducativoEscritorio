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
import logica.entidades.TutorAlumno;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author juanmarobles
 */
public class TutorAlumnoJpaController implements Serializable {

    public TutorAlumnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    //CONTROLADOR

    public TutorAlumnoJpaController() {
        emf = Persistence.createEntityManagerFactory("centroeducativoPU");
    }


    public void create(TutorAlumno tutorAlumno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tutorAlumno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TutorAlumno tutorAlumno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tutorAlumno = em.merge(tutorAlumno);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tutorAlumno.getId();
                if (findTutorAlumno(id) == null) {
                    throw new NonexistentEntityException("The tutorAlumno with id " + id + " no longer exists.");
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
            TutorAlumno tutorAlumno;
            try {
                tutorAlumno = em.getReference(TutorAlumno.class, id);
                tutorAlumno.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tutorAlumno with id " + id + " no longer exists.", enfe);
            }
            em.remove(tutorAlumno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TutorAlumno> findTutorAlumnoEntities() {
        return findTutorAlumnoEntities(true, -1, -1);
    }

    public List<TutorAlumno> findTutorAlumnoEntities(int maxResults, int firstResult) {
        return findTutorAlumnoEntities(false, maxResults, firstResult);
    }

    private List<TutorAlumno> findTutorAlumnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TutorAlumno.class));
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

    public TutorAlumno findTutorAlumno(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TutorAlumno.class, id);
        } finally {
            em.close();
        }
    }

    public int getTutorAlumnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TutorAlumno> rt = cq.from(TutorAlumno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
