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
import logica.entidades.Docente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import logica.entidades.Curso;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author juanmarobles
 */
public class CursoJpaController implements Serializable {

    public CursoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Curso curso) {
        if (curso.getDocentes() == null) {
            curso.setDocentes(new ArrayList<Docente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Docente> attachedDocentes = new ArrayList<Docente>();
            for (Docente docentesDocenteToAttach : curso.getDocentes()) {
                docentesDocenteToAttach = em.getReference(docentesDocenteToAttach.getClass(), docentesDocenteToAttach.getIdPersona());
                attachedDocentes.add(docentesDocenteToAttach);
            }
            curso.setDocentes(attachedDocentes);
            em.persist(curso);
            for (Docente docentesDocente : curso.getDocentes()) {
                docentesDocente.getCursos().add(curso);
                docentesDocente = em.merge(docentesDocente);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Curso curso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso persistentCurso = em.find(Curso.class, curso.getCursoId());
            List<Docente> docentesOld = persistentCurso.getDocentes();
            List<Docente> docentesNew = curso.getDocentes();
            List<Docente> attachedDocentesNew = new ArrayList<Docente>();
            for (Docente docentesNewDocenteToAttach : docentesNew) {
                docentesNewDocenteToAttach = em.getReference(docentesNewDocenteToAttach.getClass(), docentesNewDocenteToAttach.getIdPersona());
                attachedDocentesNew.add(docentesNewDocenteToAttach);
            }
            docentesNew = attachedDocentesNew;
            curso.setDocentes(docentesNew);
            curso = em.merge(curso);
            for (Docente docentesOldDocente : docentesOld) {
                if (!docentesNew.contains(docentesOldDocente)) {
                    docentesOldDocente.getCursos().remove(curso);
                    docentesOldDocente = em.merge(docentesOldDocente);
                }
            }
            for (Docente docentesNewDocente : docentesNew) {
                if (!docentesOld.contains(docentesNewDocente)) {
                    docentesNewDocente.getCursos().add(curso);
                    docentesNewDocente = em.merge(docentesNewDocente);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = curso.getCursoId();
                if (findCurso(id) == null) {
                    throw new NonexistentEntityException("The curso with id " + id + " no longer exists.");
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
            Curso curso;
            try {
                curso = em.getReference(Curso.class, id);
                curso.getCursoId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The curso with id " + id + " no longer exists.", enfe);
            }
            List<Docente> docentes = curso.getDocentes();
            for (Docente docentesDocente : docentes) {
                docentesDocente.getCursos().remove(curso);
                docentesDocente = em.merge(docentesDocente);
            }
            em.remove(curso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Curso> findCursoEntities() {
        return findCursoEntities(true, -1, -1);
    }

    public List<Curso> findCursoEntities(int maxResults, int firstResult) {
        return findCursoEntities(false, maxResults, firstResult);
    }

    private List<Curso> findCursoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Curso.class));
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

    public Curso findCurso(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Curso.class, id);
        } finally {
            em.close();
        }
    }

    public int getCursoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Curso> rt = cq.from(Curso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
