package es.cursojava.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import es.cursojava.hibernate.dao.CaballoDAO;
import es.cursojava.hibernate.dao.CaballoDAOImpl;
import es.cursojava.hibernate.dto.CaballoDTO;
import es.cursojava.hibernate.entities.CaballoCarrera;

public class CarreraService {

    private CaballoDAO dao = new CaballoDAOImpl();

    public void insertarCaballo(CaballoDTO dto) {
        CaballoCarrera caballo = new CaballoCarrera(
                dto.getNombre(),
                dto.getEdad(),
                dto.getVelocidadMaxima(),
                dto.getNumeroDeTriunfos(),
                dto.getExperiencia(), dto.isActivo() );
        dao.insertar(caballo);
    }

    public List<CaballoDTO> obtenerCaballos(boolean activos) {
        List<CaballoCarrera> caballos = null;
        if (!activos){
            caballos = dao.obtenerTodos();
        }else{
            caballos = dao.obtenerActivos();
        }
        
        return generaDTO(caballos);
    }

    public void simularCarrera(List<CaballoDTO> caballosDTO) {
        
        if (caballosDTO.size()>=2){
            System.out.println("Empieza la carrera");
        }else{
            System.out.println("No hay suficientes caballos activos");
        }
    }

    private List<CaballoDTO> generaDTO (List<CaballoCarrera> caballos){
        List<CaballoDTO> dtos = new ArrayList<>();
        for (CaballoCarrera c : caballos) {
            dtos.add(new CaballoDTO(
                    c.getNombre(),
                    c.getEdad(),
                    c.getVelocidadMaxima(),
                    c.getNumeroTriunfos(),
                    c.getExperiencia()
            ));
        }
        return dtos;
    }
}
