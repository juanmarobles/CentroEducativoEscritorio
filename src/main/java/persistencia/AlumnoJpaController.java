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
import logica.entidades.Tutor;
import logica.entidades.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.entidades.Alumno;
import logica.entidades.Nota;
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
    public AlumnoJpaController() {
        emf = Persistence.createEntityManagerFactory("centroeducativoPU");
    }

    public void create(Alumno alumno) {
        if (alumno.getMaterias() == null) {
            alumno.setMaterias(new ArrayList<Materia>());
        }
        if (alumno.getNotas() == null) {
            alumno.setNotas(new ArrayList<Nota>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tutor tutor = alumno.getTutor();
            if (tutor != null) {
                tutor = em.getReference(tutor.getClass(), tutor.getId());
                alumno.setTutor(tutor);
            }
            List<Materia> attachedMaterias = new ArrayList<Materia>();
            for (Materia materiasMateriaToAttach : alumno.getMaterias()) {
                materiasMateriaToAttach = em.getReference(materiasMateriaToAttach.getClass(), materiasMateriaToAttach.getIdMateria());
                attachedMaterias.add(materiasMateriaToAttach);
            }
            alumno.setMaterias(attachedMaterias);
            List<Nota> attachedNotas = new ArrayList<Nota>();
            for (Nota notasNotaToAttach : alumno.getNotas()) {
                notasNotaToAttach = em.getReference(notasNotaToAttach.getClass(), notasNotaToAttach.getIdNota());
                attachedNotas.add(notasNotaToAttach);
            }
            alumno.setNotas(attachedNotas);
            em.persist(alumno);
            if (tutor != null) {
                tutor.getAlumnos().add(alumno);
                tutor = em.merge(tutor);
            }
            for (Materia materiasMateria : alumno.getMaterias()) {
                materiasMateria.getAlumnos().add(alumno);
                materiasMateria = em.merge(materiasMateria);
            }
            for (Nota notasNota : alumno.getNotas()) {
                Alumno oldAlumnoOfNotasNota = notasNota.getAlumno();
                notasNota.setAlumno(alumno);
                notasNota = em.merge(notasNota);
                if (oldAlumnoOfNotasNota != null) {
                    oldAlumnoOfNotasNota.getNotas().remove(notasNota);
                    oldAlumnoOfNotasNota = em.merge(oldAlumnoOfNotasNota);
                }
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
            List<Materia> materiasOld = persistentAlumno.getMaterias();
            List<Materia> materiasNew = alumno.getMaterias();
            List<Nota> notasOld = persistentAlumno.getNotas();
            List<Nota> notasNew = alumno.getNotas();
            if (tutorNew != null) {
                tutorNew = em.getReference(tutorNew.getClass(), tutorNew.getId());
                alumno.setTutor(tutorNew);
            }
            List<Materia> attachedMateriasNew = new ArrayList<Materia>();
            for (Materia materiasNewMateriaToAttach : materiasNew) {
                materiasNewMateriaToAttach = em.getReference(materiasNewMateriaToAttach.getClass(), materiasNewMateriaToAttach.getIdMateria());
                attachedMateriasNew.add(materiasNewMateriaToAttach);
            }
            materiasNew = attachedMateriasNew;
            alumno.setMaterias(materiasNew);
            List<Nota> attachedNotasNew = new ArrayList<Nota>();
            for (Nota notasNewNotaToAttach : notasNew) {
                notasNewNotaToAttach = em.getReference(notasNewNotaToAttach.getClass(), notasNewNotaToAttach.getIdNota());
                attachedNotasNew.add(notasNewNotaToAttach);
            }
            notasNew = attachedNotasNew;
            alumno.setNotas(notasNew);
            alumno = em.merge(alumno);
            if (tutorOld != null && !tutorOld.equals(tutorNew)) {
                tutorOld.getAlumnos().remove(alumno);
                tutorOld = em.merge(tutorOld);
            }
            if (tutorNew != null && !tutorNew.equals(tutorOld)) {
                tutorNew.getAlumnos().add(alumno);
                tutorNew = em.merge(tutorNew);
            }
            for (Materia materiasOldMateria : materiasOld) {
                if (!materiasNew.contains(materiasOldMateria)) {
                    materiasOldMateria.getAlumnos().remove(alumno);
                    materiasOldMateria = em.merge(materiasOldMateria);
                }
            }
            for (Materia materiasNewMateria : materiasNew) {
                if (!materiasOld.contains(materiasNewMateria)) {
                    materiasNewMateria.getAlumnos().add(alumno);
                    materiasNewMateria = em.merge(materiasNewMateria);
                }
            }
            for (Nota notasOldNota : notasOld) {
                if (!notasNew.contains(notasOldNota)) {
                    notasOldNota.setAlumno(null);
                    notasOldNota = em.merge(notasOldNota);
                }
            }
            for (Nota notasNewNota : notasNew) {
                if (!notasOld.contains(notasNewNota)) {
                    Alumno oldAlumnoOfNotasNewNota = notasNewNota.getAlumno();
                    notasNewNota.setAlumno(alumno);
                    notasNewNota = em.merge(notasNewNota);
                    if (oldAlumnoOfNotasNewNota != null && !oldAlumnoOfNotasNewNota.equals(alumno)) {
                        oldAlumnoOfNotasNewNota.getNotas().remove(notasNewNota);
                        oldAlumnoOfNotasNewNota = em.merge(oldAlumnoOfNotasNewNota);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = alumno.getId();
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

    public void destroy(int id) throws NonexistentEntityException {
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
            List<Materia> materias = alumno.getMaterias();
            for (Materia materiasMateria : materias) {
                materiasMateria.getAlumnos().remove(alumno);
                materiasMateria = em.merge(materiasMateria);
            }
            List<Nota> notas = alumno.getNotas();
            for (Nota notasNota : notas) {
                notasNota.setAlumno(null);
                notasNota = em.merge(notasNota);
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

    public Alumno findAlumno(int id) {
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
