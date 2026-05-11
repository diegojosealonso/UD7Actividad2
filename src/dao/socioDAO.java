package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import modelo.Gimnasio;
import modelo.Socio;

import java.util.ArrayList;
import java.util.List;

public class socioDAO {
    private EntityManagerFactory emf;

    public socioDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void insertarSocio(Socio s) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
    }

    public void actualizarSocio(int id, String nuevoNombreCompleto, Integer nuevaEdad, Boolean nuevoVip) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Socio s = em.find(Socio.class, id);
        if (s != null) {
            if (nuevoNombreCompleto != null) {
                s.setNombreCompleto(nuevoNombreCompleto);
            }
            if (nuevaEdad != null) {
                s.setEdad(nuevaEdad);
            }
            if (nuevoVip != null) {
                s.setVip(nuevoVip);
            }
        }
        em.getTransaction().commit();
        em.close();
    }

    public void borrarSocio(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Socio s = em.find(Socio.class, id);
        if (s != null) {
            em.remove(s);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void asignarSocio(int idSocio, int idGimnasio) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Socio s = em.find(Socio.class, idSocio);
        Gimnasio g = em.find(Gimnasio.class, idGimnasio);
        if (s != null && g != null) {
            g.getSocios().add(s);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void borrarSocioDeGimnasio(int idSocio, int idGimnasio) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Socio s = em.find(Socio.class, idSocio);
        Gimnasio g = em.find(Gimnasio.class, idGimnasio);
        if (s != null && g != null) {
            g.getSocios().remove(s);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Gimnasio> getGimnasiosDeSocio(int idSocio) {
        EntityManager em = emf.createEntityManager();
        Socio s = em.find(Socio.class, idSocio);
        List<Gimnasio> todos = em.createQuery("SELECT g FROM Gimnasio g", Gimnasio.class).getResultList();
        List<Gimnasio> resultado = new ArrayList<>();
        for (Gimnasio g : todos) {
            if (g.getSocios().contains(s)) {
                resultado.add(g);
            }
        }
        em.close();
        return resultado;
    }

    public Double getMediaEdadSocios() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Double> query = em.createQuery("SELECT AVG(s.edad) FROM Socio s", Double.class);
        Double resultado = query.getSingleResult();
        em.close();
        return resultado;
    }

    public List<Socio> getSociosSinGimnasio() {
        EntityManager em = emf.createEntityManager();
        List<Socio> todos = em.createQuery("SELECT s FROM Socio s", Socio.class).getResultList();
        List<Socio> resultado = new ArrayList<>();
        for (Socio s : todos) {
            if (s.getGimnasios().isEmpty()) {
                resultado.add(s);
            }
        }
        em.close();
        return resultado;
    }
}
