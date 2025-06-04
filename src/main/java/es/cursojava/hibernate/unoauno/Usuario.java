package es.cursojava.hibernate.unoauno;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/*El lado propietario de la relación es el que tiene la anotación @JoinColumn.
mappedBy se usa en el lado no propietario, indicando el atributo en el otro lado que gestiona la relación.
Puedes usar cascade = CascadeType.ALL para que al guardar un Usuario, se guarde también su Direccion.
*/
@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

/*
 * 
 * PERSIST	Si quieres que al guardar el padre, se guarde también el hijo nuevo.
MERGE	Cuando actualizas un padre y quieres que se actualice también su hijo.
REMOVE	Si al borrar el padre quieres borrar también el hijo (¡cuidado!).
REFRESH	Si quieres refrescar todos los datos relacionados desde la BD.
DETACH	Si quieres que al desconectar el padre, se desconecten los hijos también.
ALL	Aplica todas las anteriores: PERSIST, MERGE, REMOVE, REFRESH, DETACH.	
Cuando quieres una gestión en cascada completa.
 */

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@OneToOne
    @JoinColumn(name = "direccion_id") // crea la foreign key en la tabla Usuario
    private Direccion direccion;

    public Usuario() {
    }

    public Usuario(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    
}