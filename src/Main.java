import dao.GimnasioDAO;
import dao.socioDAO;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.Gimnasio;
import modelo.Socio;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionGimnasio.odb");

        GimnasioDAO gimnasioDAO = new GimnasioDAO(emf);
        socioDAO socioDAO = new socioDAO(emf);

        //gimnasioDAO.insertarGimnasio(new Gimnasio("Iron Temple", "Madrid", 45.99));
        //gimnasioDAO.insertarGimnasio(new Gimnasio("Sparta Fitness", "Barcelona", 29.90));
        //gimnasioDAO.insertarGimnasio(new Gimnasio("Yoga & Flow", "Valencia", 60.00));
        //gimnasioDAO.insertarGimnasio(new Gimnasio("LowCost Gym", "Sevilla", 19.95));
        //gimnasioDAO.insertarGimnasio(new Gimnasio("Elite Performance", "Madrid", 85.00));
        //gimnasioDAO.insertarGimnasio(new Gimnasio("CrossFit Box 33", "Bilbao", 70.00));
        //gimnasioDAO.insertarGimnasio(new Gimnasio("Padel & Gym", "Málaga", 35.50));
        //gimnasioDAO.insertarGimnasio(new Gimnasio("Wellness Center", "Zaragoza", 55.00));
        //gimnasioDAO.insertarGimnasio(new Gimnasio("Heavy Metal Lifting", "Vigo", 25.00));
        //gimnasioDAO.insertarGimnasio(new Gimnasio("Zumba Party", "Alicante", 32.00));

        //socioDAO.insertarSocio(new Socio("Ana García", 28, true));
        //socioDAO.insertarSocio(new Socio("Carlos Pérez", 45, false));
        //socioDAO.insertarSocio(new Socio("Lucía Fernández", 19, false));
        //socioDAO.insertarSocio(new Socio("Marcos Ruiz", 34, true));
        //socioDAO.insertarSocio(new Socio("Elena Sanz", 52, false));
        //socioDAO.insertarSocio(new Socio("David León", 23, true));
        //socioDAO.insertarSocio(new Socio("Sara Cano", 31, false));
        //socioDAO.insertarSocio(new Socio("Roberto Gómez", 60, true));
        //socioDAO.insertarSocio(new Socio("Irene Molina", 26, false));
        //socioDAO.insertarSocio(new Socio("Javier Ortiz", 40, false));

        //socioDAO.asignarSocio(11, 1);
        //socioDAO.asignarSocio(11, 3);
        //socioDAO.asignarSocio(11, 5);
        //socioDAO.asignarSocio(11, 8);
        //socioDAO.asignarSocio(11, 10);
        //socioDAO.asignarSocio(12, 2);
        //socioDAO.asignarSocio(12, 4);
        //socioDAO.asignarSocio(12, 9);
        //socioDAO.asignarSocio(13, 2);
        //socioDAO.asignarSocio(13, 4);
        //socioDAO.asignarSocio(13, 10);
        //socioDAO.asignarSocio(14, 1);
        //socioDAO.asignarSocio(14, 2);
        //socioDAO.asignarSocio(14, 3);
        //socioDAO.asignarSocio(14, 4);
        //socioDAO.asignarSocio(14, 5);
        //socioDAO.asignarSocio(15, 6);
        //socioDAO.asignarSocio(15, 7);
        //socioDAO.asignarSocio(15, 8);
        //socioDAO.asignarSocio(16, 1);
        //socioDAO.asignarSocio(16, 6);
        //socioDAO.asignarSocio(16, 9);
        //socioDAO.asignarSocio(17, 2);
        //socioDAO.asignarSocio(17, 4);
        //socioDAO.asignarSocio(17, 7);
        //socioDAO.asignarSocio(18, 1);
        //socioDAO.asignarSocio(18, 3);
        //socioDAO.asignarSocio(18, 5);
        //socioDAO.asignarSocio(19, 6);
        //socioDAO.asignarSocio(19, 10);


        Gimnasio g = new Gimnasio("Centro Pokemon", "Sevilla", 44.00);
        gimnasioDAO.insertarGimnasio(g);
        g.setId(11);
        gimnasioDAO.actualizarGimnasio(11, "Centro Terrymon", null, null);
        gimnasioDAO.borrarGimnasio(11);
        System.out.println(gimnasioDAO.obtenerSociosDeGimnasio(1));
        System.out.println(gimnasioDAO.getNumeroSociosPorGimnasio());
        System.out.println(gimnasioDAO.getGimnasiosConMenosDe10Socios());
        System.out.println(gimnasioDAO.getTop5GimnasiosCuotaMasAlta());
        System.out.println(gimnasioDAO.getGimnasioMasBaratoPorCiudad("Madrid"));

        Socio s = new Socio("Terry", 20, false);
        socioDAO.insertarSocio(s);
        s.setId(21);
        socioDAO.actualizarSocio(21, "Brandon", 22, true);
        socioDAO.borrarSocio(21);
        socioDAO.asignarSocio(19, 2);
        socioDAO.borrarSocioDeGimnasio(19, 2);
        System.out.println(socioDAO.getGimnasiosDeSocio(11));
        System.out.println(socioDAO.getMediaEdadSocios());
        System.out.println(socioDAO.getSociosSinGimnasio());

        emf.close();
    }
}