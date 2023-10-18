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
import javax.persistence.TypedQuery;
import logica.entidades.Docente;
import logica.entidades.Alumno;
import logica.entidades.Materia;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author juanmarobles
 */
public class MateriaJpaController implements Serializable {

    public MateriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    //CONTROLADOR

    public MateriaJpaController() {
        emf = Persistence.createEntityManagerFactory("centroeducativoPU");
    }

    public void create(Materia materia) {
        if (materia.getNotas() == null) {
            materia.setNotas(new ArrayList<Nota>());
        }
        if (materia.getDocentes() == null) {
            materia.setDocentes(new ArrayList<Docente>());
        }
        if (materia.getAlumnos() == null) {
            materia.setAlumnos(new ArrayList<Alumno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Nota> attachedNotas = new ArrayList<Nota>();
            for (Nota notasNotaToAttach : materia.getNotas()) {
                notasNotaToAttach = em.getReference(notasNotaToAttach.getClass(), notasNotaToAttach.getIdNota());
                attachedNotas.add(notasNotaToAttach);
            }
            materia.setNotas(attachedNotas);
            List<Docente> attachedDocentes = new ArrayList<Docente>();
            for (Docente docentesDocenteToAttach : materia.getDocentes()) {
                docentesDocenteToAttach = em.getReference(docentesDocenteToAttach.getClass(), docentesDocenteToAttach.getIdPersona());
                attachedDocentes.add(docentesDocenteToAttach);
            }
            materia.setDocentes(attachedDocentes);
            List<Alumno> attachedAlumnos = new ArrayList<Alumno>();
            for (Alumno alumnosAlumnoToAttach : materia.getAlumnos()) {
                alumnosAlumnoToAttach = em.getReference(alumnosAlumnoToAttach.getClass(), alumnosAlumnoToAttach.getId());
                attachedAlumnos.add(alumnosAlumnoToAttach);
            }
            materia.setAlumnos(attachedAlumnos);
            em.persist(materia);
            for (Nota notasNota : materia.getNotas()) {
                Materia oldMateriaOfNotasNota = notasNota.getMateria();
                notasNota.setMateria(materia);
                notasNota = em.merge(notasNota);
                if (oldMateriaOfNotasNota != null) {
                    oldMateriaOfNotasNota.getNotas().remove(notasNota);
                    oldMateriaOfNotasNota = em.merge(oldMateriaOfNotasNota);
                }
            }
            for (Docente docentesDocente : materia.getDocentes()) {
                docentesDocente.getMaterias().add(materia);
                docentesDocente = em.merge(docentesDocente);
            }
            for (Alumno alumnosAlumno : materia.getAlumnos()) {
                alumnosAlumno.getMaterias().add(materia);
                alumnosAlumno = em.merge(alumnosAlumno);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Materia materia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Materia persistentMateria = em.find(Materia.class, materia.getIdMateria());
            List<Nota> notasOld = persistentMateria.getNotas();
            List<Nota> notasNew = materia.getNotas();
            List<Docente> docentesOld = persistentMateria.getDocentes();
            List<Docente> docentesNew = materia.getDocentes();
            List<Alumno> alumnosOld = persistentMateria.getAlumnos();
            List<Alumno> alumnosNew = materia.getAlumnos();
            List<Nota> attachedNotasNew = new ArrayList<Nota>();
            for (Nota notasNewNotaToAttach : notasNew) {
                notasNewNotaToAttach = em.getReference(notasNewNotaToAttach.getClass(), notasNewNotaToAttach.getIdNota());
                attachedNotasNew.add(notasNewNotaToAttach);
            }
            notasNew = attachedNotasNew;
            materia.setNotas(notasNew);
            List<Docente> attachedDocentesNew = new ArrayList<Docente>();
            for (Docente docentesNewDocenteToAttach : docentesNew) {
                docentesNewDocenteToAttach = em.getReference(docentesNewDocenteToAttach.getClass(), docentesNewDocenteToAttach.getIdPersona());
                attachedDocentesNew.add(docentesNewDocenteToAttach);
            }
            docentesNew = attachedDocentesNew;
            materia.setDocentes(docentesNew);
            List<Alumno> attachedAlumnosNew = new ArrayList<Alumno>();
            for (Alumno alumnosNewAlumnoToAttach : alumnosNew) {
                alumnosNewAlumnoToAttach = em.getReference(alumnosNewAlumnoToAttach.getClass(), alumnosNewAlumnoToAttach.getId());
                attachedAlumnosNew.add(alumnosNewAlumnoToAttach);
            }
            alumnosNew = attachedAlumnosNew;
            materia.setAlumnos(alumnosNew);
            materia = em.merge(materia);
            for (Nota notasOldNota : notasOld) {
                if (!notasNew.contains(notasOldNota)) {
                    notasOldNota.setMateria(null);
                    notasOldNota = em.merge(notasOldNota);
                }
            }
            for (Nota notasNewNota : notasNew) {
                if (!notasOld.contains(notasNewNota)) {
                    Materia oldMateriaOfNotasNewNota = notasNewNota.getMateria();
                    notasNewNota.setMateria(materia);
                    notasNewNota = em.merge(notasNewNota);
                    if (oldMateriaOfNotasNewNota != null && !oldMateriaOfNotasNewNota.equals(materia)) {
                        oldMateriaOfNotasNewNota.getNotas().remove(notasNewNota);
                        oldMateriaOfNotasNewNota = em.merge(oldMateriaOfNotasNewNota);
                    }
                }
            }
            for (Docente docentesOldDocente : docentesOld) {
                if (!docentesNew.contains(docentesOldDocente)) {
                    docentesOldDocente.getMaterias().remove(materia);
                    docentesOldDocente = em.merge(docentesOldDocente);
                }
            }
            for (Docente docentesNewDocente : docentesNew) {
                if (!docentesOld.contains(docentesNewDocente)) {
                    docentesNewDocente.getMaterias().add(materia);
                    docentesNewDocente = em.merge(docentesNewDocente);
                }
            }
            for (Alumno alumnosOldAlumno : alumnosOld) {
                if (!alumnosNew.contains(alumnosOldAlumno)) {
                    alumnosOldAlumno.getMaterias().remove(materia);
                    alumnosOldAlumno = em.merge(alumnosOldAlumno);
                }
            }
            for (Alumno alumnosNewAlumno : alumnosNew) {
                if (!alumnosOld.contains(alumnosNewAlumno)) {
                    alumnosNewAlumno.getMaterias().add(materia);
                    alumnosNewAlumno = em.merge(alumnosNewAlumno);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = materia.getIdMateria();
                if (findMateria(id) == null) {
                    throw new NonexistentEntityException("The materia with id " + id + " no longer exists.");
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
            Materia materia;
            try {
                materia = em.getReference(Materia.class, id);
                materia.getIdMateria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The materia with id " + id + " no longer exists.", enfe);
            }
            List<Nota> notas = materia.getNotas();
            for (Nota notasNota : notas) {
                notasNota.setMateria(null);
                notasNota = em.merge(notasNota);
            }
            List<Docente> docentes = materia.getDocentes();
            for (Docente docentesDocente : docentes) {
                docentesDocente.getMaterias().remove(materia);
                docentesDocente = em.merge(docentesDocente);
            }
            List<Alumno> alumnos = materia.getAlumnos();
            for (Alumno alumnosAlumno : alumnos) {
                alumnosAlumno.getMaterias().remove(materia);
                alumnosAlumno = em.merge(alumnosAlumno);
            }
            em.remove(materia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Materia> findMateriaEntities() {
        return findMateriaEntities(true, -1, -1);
    }

    public List<Materia> findMateriaEntities(int maxResults, int firstResult) {
        return findMateriaEntities(false, maxResults, firstResult);
    }

    private List<Materia> findMateriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Materia.class));
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

    public Materia findMateria(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Materia.class, id);
        } finally {
            em.close();
        }
    }

    public int getMateriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Materia> rt = cq.from(Materia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    // Método para buscar una materia existente por su nombre
    public Materia buscarMateriaPorNombre(String nombreMateria) {
        EntityManager em = getEntityManager();
        try {
            // Utiliza una consulta para buscar la materia por nombre
            TypedQuery<Materia> query = em.createQuery("SELECT m FROM Materia m WHERE m.materia = :nombre", Materia.class);
            query.setParameter("nombre", nombreMateria);
            List<Materia> result = query.getResultList();

            if (!result.isEmpty()) {
                return result.get(0); // Devuelve la primera materia encontrada
            } else {
                return null; // La materia no existe
            }
        } finally {
            em.close();
        }
    }

    public void asignarMateriaADocente(Materia materia, Docente docente) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();

            // Agregar la materia al docente
            docente.getMaterias().add(materia);
            // Actualizar el docente en la base de datos
            docente = em.merge(docente);

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error al asignar la materia al docente", ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
     public void asignarMateriaAAlumno(Materia materia, Alumno alumno) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();

            // Agregar la materia al docente
            alumno.getMaterias().add(materia);
            // Actualizar el docente en la base de datos
            alumno = em.merge(alumno);

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error al asignar la materia al alumno", ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
