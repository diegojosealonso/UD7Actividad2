package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import modelo.Gimnasio;
import modelo.Socio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GimnasioDAO {
    private EntityManagerFactory emf;
    public GimnasioDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void insertarGimnasio (Gimnasio g) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(g);
        em.getTransaction().commit();
        em.close();
    }

    public void borrarGimnasio (int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Gimnasio g = em.find(Gimnasio.class, id);
        if (g != null) {
            em.remove(g);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void actualizarGimnasio(int id, String nuevoNombre, String nuevaCiudad, Double nuevaCuotaMensual) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Gimnasio g = em.find(Gimnasio.class, id);
        if (g != null) {
            if (nuevoNombre != null) {
                g.setNombre(nuevoNombre);
            }
            if (nuevaCiudad != null) {
                g.setCiudad(nuevaCiudad);
            }
            if (nuevaCuotaMensual != null) {
                g.setCuotaMensual(nuevaCuotaMensual);
            }
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Socio> obtenerSociosDeGimnasio(int id) {
        EntityManager em = emf.createEntityManager();
        Gimnasio g = em.find(Gimnasio.class, id);
        if (g != null) {
            return g.getSocios();
        }
        em.close();
        return null;
    }

    public Map<String, Integer> getNumeroSociosPorGimnasio() {
        EntityManager em = emf.createEntityManager();
        List<Gimnasio> gimnasios = em.createQuery("SELECT g FROM Gimnasio g", Gimnasio.class).getResultList();
        Map<String, Integer> socios = new HashMap<>();
        for (Gimnasio g : gimnasios) {
            socios.put(g.getNombre(), g.getSocios().size());
        }
        em.close();
        return socios;
    }

    public List<Gimnasio> getGimnasiosConMenosDe10Socios() {
        EntityManager em = emf.createEntityManager();
        List<Gimnasio> todos = em.createQuery("SELECT g FROM Gimnasio g", Gimnasio.class).getResultList();
        List<Gimnasio> gimnasios = new ArrayList<>();
        for (Gimnasio g : todos) {
            if (g.getSocios().size() < 10) {
                gimnasios.add(g);
            }
        }
        em.close();
        return gimnasios;
    }

    public List<Gimnasio> getTop5GimnasiosCuotaMasAlta() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Gimnasio> query = em.createQuery("SELECT g FROM Gimnasio g ORDER BY g.cuotaMensual DESC", Gimnasio.class);
        query.setMaxResults(5);
        List<Gimnasio> gimnasios = query.getResultList();
        em.close();
        return gimnasios;
    }

    public Gimnasio getGimnasioMasBaratoPorCiudad(String ciudad) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Gimnasio> query = em.createQuery("SELECT g FROM Gimnasio g WHERE g.ciudad = :ciudad ORDER BY g.cuotaMensual ASC", Gimnasio.class);
        query.setParameter("ciudad", ciudad);
        query.setMaxResults(1);
        List<Gimnasio> resultado = query.getResultList();
        em.close();
        if (resultado.isEmpty()) {
            return null;
        } else {
            return resultado.get(0);
        }
    }
}
