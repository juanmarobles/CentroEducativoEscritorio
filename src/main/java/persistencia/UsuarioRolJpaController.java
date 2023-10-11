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
import logica.entidades.UsuarioRol;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author juanmarobles
 */
public class UsuarioRolJpaController implements Serializable {

    public UsuarioRolJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    //CONTROLADOR
    public UsuarioRolJpaController(){
    emf = Persistence.createEntityManagerFactory("centroeducativoPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsuarioRol usuarioRol) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarioRol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioRol usuarioRol) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarioRol = em.merge(usuarioRol);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = usuarioRol.getId();
                if (findUsuarioRol(id) == null) {
                    throw new NonexistentEntityException("The usuarioRol with id " + id + " no longer exists.");
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
            UsuarioRol usuarioRol;
            try {
                usuarioRol = em.getReference(UsuarioRol.class, id);
                usuarioRol.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioRol with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuarioRol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UsuarioRol> findUsuarioRolEntities() {
        return findUsuarioRolEntities(true, -1, -1);
    }

    public List<UsuarioRol> findUsuarioRolEntities(int maxResults, int firstResult) {
        return findUsuarioRolEntities(false, maxResults, firstResult);
    }

    private List<UsuarioRol> findUsuarioRolEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioRol.class));
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

    public UsuarioRol findUsuarioRol(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioRol.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioRolCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsuarioRol> rt = cq.from(UsuarioRol.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
