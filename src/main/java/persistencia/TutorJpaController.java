/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.entidades.Alumno;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.entidades.Tutor;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author juanmarobles
 */
public class TutorJpaController implements Serializable {

    public TutorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //CONTROLADOR
    public TutorJpaController() {
        emf = Persistence.createEntityManagerFactory("centroeducativoPU");
    }

    public void create(Tutor tutor) {
        if (tutor.getAlumnos() == null) {
            tutor.setAlumnos(new ArrayList<Alumno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Alumno> attachedAlumnos = new ArrayList<Alumno>();
            for (Alumno alumnosAlumnoToAttach : tutor.getAlumnos()) {
                alumnosAlumnoToAttach = em.getReference(alumnosAlumnoToAttach.getClass(), alumnosAlumnoToAttach.getId());
                attachedAlumnos.add(alumnosAlumnoToAttach);
            }
            tutor.setAlumnos(attachedAlumnos);
            em.persist(tutor);
            for (Alumno alumnosAlumno : tutor.getAlumnos()) {
                Tutor oldTutorOfAlumnosAlumno = alumnosAlumno.getTutor();
                alumnosAlumno.setTutor(tutor);
                alumnosAlumno = em.merge(alumnosAlumno);
                if (oldTutorOfAlumnosAlumno != null) {
                    oldTutorOfAlumnosAlumno.getAlumnos().remove(alumnosAlumno);
                    oldTutorOfAlumnosAlumno = em.merge(oldTutorOfAlumnosAlumno);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tutor tutor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tutor persistentTutor = em.find(Tutor.class, tutor.getId());
            List<Alumno> alumnosOld = persistentTutor.getAlumnos();
            List<Alumno> alumnosNew = tutor.getAlumnos();
            List<Alumno> attachedAlumnosNew = new ArrayList<Alumno>();
            for (Alumno alumnosNewAlumnoToAttach : alumnosNew) {
                alumnosNewAlumnoToAttach = em.getReference(alumnosNewAlumnoToAttach.getClass(), alumnosNewAlumnoToAttach.getId());
                attachedAlumnosNew.add(alumnosNewAlumnoToAttach);
            }
            alumnosNew = attachedAlumnosNew;
            tutor.setAlumnos(alumnosNew);
            tutor = em.merge(tutor);
            for (Alumno alumnosOldAlumno : alumnosOld) {
                if (!alumnosNew.contains(alumnosOldAlumno)) {
                    alumnosOldAlumno.setTutor(null);
                    alumnosOldAlumno = em.merge(alumnosOldAlumno);
                }
            }
            for (Alumno alumnosNewAlumno : alumnosNew) {
                if (!alumnosOld.contains(alumnosNewAlumno)) {
                    Tutor oldTutorOfAlumnosNewAlumno = alumnosNewAlumno.getTutor();
                    alumnosNewAlumno.setTutor(tutor);
                    alumnosNewAlumno = em.merge(alumnosNewAlumno);
                    if (oldTutorOfAlumnosNewAlumno != null && !oldTutorOfAlumnosNewAlumno.equals(tutor)) {
                        oldTutorOfAlumnosNewAlumno.getAlumnos().remove(alumnosNewAlumno);
                        oldTutorOfAlumnosNewAlumno = em.merge(oldTutorOfAlumnosNewAlumno);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tutor.getId();
                if (findTutor(id) == null) {
                    throw new NonexistentEntityException("The tutor with id " + id + " no longer exists.");
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
            Tutor tutor;
            try {
                tutor = em.getReference(Tutor.class, id);
                tutor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tutor with id " + id + " no longer exists.", enfe);
            }
            List<Alumno> alumnos = tutor.getAlumnos();
            for (Alumno alumnosAlumno : alumnos) {
                alumnosAlumno.setTutor(null);
                alumnosAlumno = em.merge(alumnosAlumno);
            }
            em.remove(tutor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tutor> findTutorEntities() {
        return findTutorEntities(true, -1, -1);
    }

    public List<Tutor> findTutorEntities(int maxResults, int firstResult) {
        return findTutorEntities(false, maxResults, firstResult);
    }

    private List<Tutor> findTutorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tutor.class));
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

    public Tutor findTutor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tutor.class, id);
        } finally {
            em.close();
        }
    }

    public int getTutorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tutor> rt = cq.from(Tutor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public Tutor buscarTutorPorNombre(String nombreTutor) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("centroeducativoPU"); // Reemplaza "nombreUnidadPersistencia" con el nombre de tu unidad de persistencia
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Tutor> query = em.createQuery("SELECT t FROM Tutor t WHERE t.nombre = :nombreTutor", Tutor.class);
            query.setParameter("nombreTutor", nombreTutor);

            Tutor tutor = query.getSingleResult();
            return tutor;
        } catch (NoResultException e) {
            return null; // Retorna null si no se encontró ningún tutor con ese nombre
        } finally {
            em.close();
            emf.close();
        }
    }

}
