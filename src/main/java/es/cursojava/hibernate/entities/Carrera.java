package es.cursojava.hibernate.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CARRERA")
public class Carrera {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String lugar;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
    		name = "TB_CARRERA_CABALLO",
    		joinColumns = @JoinColumn(name = "carrera_id"),
    		inverseJoinColumns = @JoinColumn(name = "caballo_id")
    )
    private List<CaballoCarrera> caballos = new ArrayList<>();

    public Carrera() {}

    public Carrera(String nombre, String lugar) {
        this.nombre = nombre;
        this.lugar = lugar;
    }

    public void agregarCaballo(CaballoCarrera caballo) {
        this.caballos.add(caballo);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public List<CaballoCarrera> getCaballos() {
		return caballos;
	}

	public void setCaballos(List<CaballoCarrera> caballos) {
		this.caballos = caballos;
	}
}
