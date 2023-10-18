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
import logica.entidades.Nota;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.entidades.Docente;
import logica.entidades.Materia;
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
    //CONTROLADOR
    public DocenteJpaController() {
        emf = Persistence.createEntityManagerFactory("centroeducativoPU");
    }

    public void create(Docente docente) {
        if (docente.getNotas() == null) {
            docente.setNotas(new ArrayList<Nota>());
        }
        if (docente.getMaterias() == null) {
            docente.setMaterias(new ArrayList<Materia>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Nota> attachedNotas = new ArrayList<Nota>();
            for (Nota notasNotaToAttach : docente.getNotas()) {
                notasNotaToAttach = em.getReference(notasNotaToAttach.getClass(), notasNotaToAttach.getIdNota());
                attachedNotas.add(notasNotaToAttach);
            }
            docente.setNotas(attachedNotas);
            List<Materia> attachedMaterias = new ArrayList<Materia>();
            for (Materia materiasMateriaToAttach : docente.getMaterias()) {
                materiasMateriaToAttach = em.getReference(materiasMateriaToAttach.getClass(), materiasMateriaToAttach.getIdMateria());
                attachedMaterias.add(materiasMateriaToAttach);
            }
            docente.setMaterias(attachedMaterias);
            em.persist(docente);
            for (Nota notasNota : docente.getNotas()) {
                Docente oldDocenteOfNotasNota = notasNota.getDocente();
                notasNota.setDocente(docente);
                notasNota = em.merge(notasNota);
                if (oldDocenteOfNotasNota != null) {
                    oldDocenteOfNotasNota.getNotas().remove(notasNota);
                    oldDocenteOfNotasNota = em.merge(oldDocenteOfNotasNota);
                }
            }
            for (Materia materiasMateria : docente.getMaterias()) {
                materiasMateria.getDocentes().add(docente);
                materiasMateria = em.merge(materiasMateria);
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
            List<Nota> notasOld = persistentDocente.getNotas();
            List<Nota> notasNew = docente.getNotas();
            List<Materia> materiasOld = persistentDocente.getMaterias();
            List<Materia> materiasNew = docente.getMaterias();
            List<Nota> attachedNotasNew = new ArrayList<Nota>();
            for (Nota notasNewNotaToAttach : notasNew) {
                notasNewNotaToAttach = em.getReference(notasNewNotaToAttach.getClass(), notasNewNotaToAttach.getIdNota());
                attachedNotasNew.add(notasNewNotaToAttach);
            }
            notasNew = attachedNotasNew;
            docente.setNotas(notasNew);
            List<Materia> attachedMateriasNew = new ArrayList<Materia>();
            for (Materia materiasNewMateriaToAttach : materiasNew) {
                materiasNewMateriaToAttach = em.getReference(materiasNewMateriaToAttach.getClass(), materiasNewMateriaToAttach.getIdMateria());
                attachedMateriasNew.add(materiasNewMateriaToAttach);
            }
            materiasNew = attachedMateriasNew;
            docente.setMaterias(materiasNew);
            docente = em.merge(docente);
            for (Nota notasOldNota : notasOld) {
                if (!notasNew.contains(notasOldNota)) {
                    notasOldNota.setDocente(null);
                    notasOldNota = em.merge(notasOldNota);
                }
            }
            for (Nota notasNewNota : notasNew) {
                if (!notasOld.contains(notasNewNota)) {
                    Docente oldDocenteOfNotasNewNota = notasNewNota.getDocente();
                    notasNewNota.setDocente(docente);
                    notasNewNota = em.merge(notasNewNota);
                    if (oldDocenteOfNotasNewNota != null && !oldDocenteOfNotasNewNota.equals(docente)) {
                        oldDocenteOfNotasNewNota.getNotas().remove(notasNewNota);
                        oldDocenteOfNotasNewNota = em.merge(oldDocenteOfNotasNewNota);
                    }
                }
            }
            for (Materia materiasOldMateria : materiasOld) {
                if (!materiasNew.contains(materiasOldMateria)) {
                    materiasOldMateria.getDocentes().remove(docente);
                    materiasOldMateria = em.merge(materiasOldMateria);
                }
            }
            for (Materia materiasNewMateria : materiasNew) {
                if (!materiasOld.contains(materiasNewMateria)) {
                    materiasNewMateria.getDocentes().add(docente);
                    materiasNewMateria = em.merge(materiasNewMateria);
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
            List<Nota> notas = docente.getNotas();
            for (Nota notasNota : notas) {
                notasNota.setDocente(null);
                notasNota = em.merge(notasNota);
            }
            List<Materia> materias = docente.getMaterias();
            for (Materia materiasMateria : materias) {
                materiasMateria.getDocentes().remove(docente);
                materiasMateria = em.merge(materiasMateria);
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
