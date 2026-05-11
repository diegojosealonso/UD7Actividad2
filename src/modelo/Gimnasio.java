package modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;
import static jakarta.persistence.GenerationType.AUTO;

@Entity
public class Gimnasio {
    @Id
    @GeneratedValue(strategy = AUTO)
    private int id;
    private String nombre;
    private String ciudad;
    private double cuotaMensual;
    @ManyToMany
    private List<Socio> socios;

    public Gimnasio() {
    }

    public Gimnasio(String nombre, String ciudad, double cuotaMensual) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.cuotaMensual = cuotaMensual;
        this.socios = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(double cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public List<Socio> getSocios() {
        return socios;
    }

    public void setSocios(List<Socio> socios) {
        this.socios = socios;
    }

    @Override
    public String toString() {
        return "Gimnasio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", cuotaMensual=" + cuotaMensual +
                ", socios=" + socios +
                '}';
    }
}
