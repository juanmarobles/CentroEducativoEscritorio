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
import logica.entidades.Alumno;
import logica.entidades.Tutor;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author juanmarobles
 */
public class AlumnoJpaController implements Serializable {

    public AlumnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
     //CONTROLADOR
    public AlumnoJpaController(){
    emf = Persistence.createEntityManagerFactory("centroeducativoPU");
    }

    public void create(Alumno alumno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tutor tutor = alumno.getTutor();
            if (tutor != null) {
                tutor = em.getReference(tutor.getClass(), tutor.getId());
                alumno.setTutor(tutor);
            }
            em.persist(alumno);
            if (tutor != null) {
                tutor.getAlumnos().add(alumno);
                tutor = em.merge(tutor);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Alumno alumno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alumno persistentAlumno = em.find(Alumno.class, alumno.getId());
            Tutor tutorOld = persistentAlumno.getTutor();
            Tutor tutorNew = alumno.getTutor();
            if (tutorNew != null) {
                tutorNew = em.getReference(tutorNew.getClass(), tutorNew.getId());
                alumno.setTutor(tutorNew);
            }
            alumno = em.merge(alumno);
            if (tutorOld != null && !tutorOld.equals(tutorNew)) {
                tutorOld.getAlumnos().remove(alumno);
                tutorOld = em.merge(tutorOld);
            }
            if (tutorNew != null && !tutorNew.equals(tutorOld)) {
                tutorNew.getAlumnos().add(alumno);
                tutorNew = em.merge(tutorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = alumno.getId();
                if (findAlumno(id) == null) {
                    throw new NonexistentEntityException("The alumno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alumno alumno;
            try {
                alumno = em.getReference(Alumno.class, id);
                alumno.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alumno with id " + id + " no longer exists.", enfe);
            }
            Tutor tutor = alumno.getTutor();
            if (tutor != null) {
                tutor.getAlumnos().remove(alumno);
                tutor = em.merge(tutor);
            }
            em.remove(alumno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Alumno> findAlumnoEntities() {
        return findAlumnoEntities(true, -1, -1);
    }

    public List<Alumno> findAlumnoEntities(int maxResults, int firstResult) {
        return findAlumnoEntities(false, maxResults, firstResult);
    }

    private List<Alumno> findAlumnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Alumno.class));
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

    public Alumno findAlumno(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Alumno.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlumnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Alumno> rt = cq.from(Alumno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
