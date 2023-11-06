/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.entidades.Alumno;
import logica.entidades.Docente;
import logica.entidades.DocenteMateria;
import logica.entidades.Materia;
//import static logica.entidades.Materia_.docente;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author juanmarobles
 */
public class DocenteMateriaJpaController implements Serializable {

    public DocenteMateriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //CONTROLADOR
    public DocenteMateriaJpaController() {
        emf = Persistence.createEntityManagerFactory("centroeducativoPU");
    }

    public void create(DocenteMateria docenteMateria) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(docenteMateria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DocenteMateria docenteMateria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            docenteMateria = em.merge(docenteMateria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = docenteMateria.getId();
                if (findDocenteMateria(id) == null) {
                    throw new NonexistentEntityException("The docenteMateria with id " + id + " no longer exists.");
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
            DocenteMateria docenteMateria;
            try {
                docenteMateria = em.getReference(DocenteMateria.class, id);
                docenteMateria.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The docenteMateria with id " + id + " no longer exists.", enfe);
            }
            em.remove(docenteMateria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DocenteMateria> findDocenteMateriaEntities() {
        return findDocenteMateriaEntities(true, -1, -1);
    }

    public List<DocenteMateria> findDocenteMateriaEntities(int maxResults, int firstResult) {
        return findDocenteMateriaEntities(false, maxResults, firstResult);
    }

    private List<DocenteMateria> findDocenteMateriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DocenteMateria.class));
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

    public DocenteMateria findDocenteMateria(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DocenteMateria.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocenteMateriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DocenteMateria> rt = cq.from(DocenteMateria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    List<Materia> traerMateriasPorDocente(Docente docSeleccionado) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT dm.materia FROM DocenteMateria dm WHERE dm.docente = :docente");
            query.setParameter("docente", docSeleccionado);  // Utiliza docSeleccionado en lugar de docente
            List<Materia> materias = query.getResultList();
            return materias;
        } finally {
            em.close();
        }
    }

    public List<Alumno> obtenerAlumnosAsignadosAlDocente(int docenteId) {
    EntityManager em = getEntityManager();
    try {
        // Busca al docente por su ID
        Docente docente = em.find(Docente.class, docenteId);

        if (docente != null) {
            // Luego, obtén las relaciones DocenteMateria para el docente
            TypedQuery<DocenteMateria> docenteMateriaQuery = em.createQuery(
                "SELECT dm FROM DocenteMateria dm WHERE dm.docente = :docente",
                DocenteMateria.class
            );
            docenteMateriaQuery.setParameter("docente", docente);
            List<DocenteMateria> docenteMaterias = docenteMateriaQuery.getResultList();

            // A continuación, obtén los alumnos relacionados con esas relaciones DocenteMateria
            List<Alumno> alumnosAsignados = new ArrayList<>();
            for (DocenteMateria docenteMateria : docenteMaterias) {
                Materia materia = docenteMateria.getMateria();
                alumnosAsignados.addAll(materia.getAlumnos());
            }

            return alumnosAsignados;
        } else {
            // Manejar el caso en que el docente no se encuentra
            return Collections.emptyList();
        }
    } finally {
        em.close();
    }
}


}
