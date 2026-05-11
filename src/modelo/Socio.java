package modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
public class Socio {
    @Id
    @GeneratedValue(strategy = AUTO)
    private int id;
    private String nombreCompleto;
    private int edad;
    private boolean vip;
    @ManyToMany(mappedBy = "socios")
    private List<Gimnasio> gimnasios;

    public Socio() {
    }

    public Socio(String nombreCompleto, int edad, boolean vip) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.vip = vip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public List<Gimnasio> getGimnasios() {
        return gimnasios;
    }

    public void setGimnasios(List<Gimnasio> gimnasios) {
        this.gimnasios = gimnasios;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "id=" + id +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", edad=" + edad +
                ", vip=" + vip +
                ", gimnasios=" + gimnasios +
                '}';
    }
}
