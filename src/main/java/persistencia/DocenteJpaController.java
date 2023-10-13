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
import logica.entidades.Curso;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import logica.entidades.Docente;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author juanmarobles
 */
public class DocenteJpaController implements Serializable {

    public DocenteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Docente docente) {
        if (docente.getCursos() == null) {
            docente.setCursos(new ArrayList<Curso>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Curso> attachedCursos = new ArrayList<Curso>();
            for (Curso cursosCursoToAttach : docente.getCursos()) {
                cursosCursoToAttach = em.getReference(cursosCursoToAttach.getClass(), cursosCursoToAttach.getCursoId());
                attachedCursos.add(cursosCursoToAttach);
            }
            docente.setCursos(attachedCursos);
            em.persist(docente);
            for (Curso cursosCurso : docente.getCursos()) {
                cursosCurso.getDocentes().add(docente);
                cursosCurso = em.merge(cursosCurso);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Docente docente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Docente persistentDocente = em.find(Docente.class, docente.getIdPersona());
            List<Curso> cursosOld = persistentDocente.getCursos();
            List<Curso> cursosNew = docente.getCursos();
            List<Curso> attachedCursosNew = new ArrayList<Curso>();
            for (Curso cursosNewCursoToAttach : cursosNew) {
                cursosNewCursoToAttach = em.getReference(cursosNewCursoToAttach.getClass(), cursosNewCursoToAttach.getCursoId());
                attachedCursosNew.add(cursosNewCursoToAttach);
            }
            cursosNew = attachedCursosNew;
            docente.setCursos(cursosNew);
            docente = em.merge(docente);
            for (Curso cursosOldCurso : cursosOld) {
                if (!cursosNew.contains(cursosOldCurso)) {
                    cursosOldCurso.getDocentes().remove(docente);
                    cursosOldCurso = em.merge(cursosOldCurso);
                }
            }
            for (Curso cursosNewCurso : cursosNew) {
                if (!cursosOld.contains(cursosNewCurso)) {
                    cursosNewCurso.getDocentes().add(docente);
                    cursosNewCurso = em.merge(cursosNewCurso);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = docente.getIdPersona();
                if (findDocente(id) == null) {
                    throw new NonexistentEntityException("The docente with id " + id + " no longer exists.");
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
            Docente docente;
            try {
                docente = em.getReference(Docente.class, id);
                docente.getIdPersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The docente with id " + id + " no longer exists.", enfe);
            }
            List<Curso> cursos = docente.getCursos();
            for (Curso cursosCurso : cursos) {
                cursosCurso.getDocentes().remove(docente);
                cursosCurso = em.merge(cursosCurso);
            }
            em.remove(docente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Docente> findDocenteEntities() {
        return findDocenteEntities(true, -1, -1);
    }

    public List<Docente> findDocenteEntities(int maxResults, int firstResult) {
        return findDocenteEntities(false, maxResults, firstResult);
    }

    private List<Docente> findDocenteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Docente.class));
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

    public Docente findDocente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Docente.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocenteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Docente> rt = cq.from(Docente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
