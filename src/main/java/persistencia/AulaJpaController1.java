/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.entidades.Alumno;
import logica.entidades.Aula;
import logica.entidades.Materia;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author juanmarobles
 */
public class AulaJpaController1 implements Serializable {

    public AulaJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
//CONTROLADOR

    public AulaJpaController1() {
        emf = Persistence.createEntityManagerFactory("centroeducativoPU");
    }

    public void create(Aula aula) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(aula);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Aula aula) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            aula = em.merge(aula);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = aula.getAulaId();
                if (findAula(id) == null) {
                    throw new NonexistentEntityException("The aula with id " + id + " no longer exists.");
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
            Aula aula;
            try {
                aula = em.getReference(Aula.class, id);
                aula.getAulaId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The aula with id " + id + " no longer exists.", enfe);
            }
            em.remove(aula);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Aula> findAulaEntities() {
        return findAulaEntities(true, -1, -1);
    }

    public List<Aula> findAulaEntities(int maxResults, int firstResult) {
        return findAulaEntities(false, maxResults, firstResult);
    }

    private List<Aula> findAulaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Aula.class));
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

    public Aula findAula(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aula.class, id);
        } finally {
            em.close();
        }
    }

    public int getAulaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Aula> rt = cq.from(Aula.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Alumno> findAlumnosPorAula(Aula aula) {
        EntityManager em = getEntityManager();
        try {
            // Crea una consulta JPQL para seleccionar los alumnos asignados a un aula específica
            Query query = em.createQuery("SELECT a FROM Alumno a WHERE a.aula = :aula");
            query.setParameter("aula", aula);

            // Ejecuta la consulta y devuelve la lista de alumnos
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
