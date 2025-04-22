package es.cursojava.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import es.cursojava.hibernate.dao.CaballoDAO;
import es.cursojava.hibernate.dao.CaballoDAOImpl;
import es.cursojava.hibernate.dto.CaballoDTO;
import es.cursojava.hibernate.entities.CaballoCarrera;
import es.cursojava.hibernate.entities.Jinete;
import es.cursojava.hibernate.exceptions.CaballoException;

public class CarreraService {
    private final int DISTANCIA = 1_000;
    private CaballoDAO dao = new CaballoDAOImpl();

    public void insertarCaballo(CaballoDTO caballoDto) {
        if (caballoDto.getVelocidadMaxima()<30 || caballoDto.getVelocidadMaxima()>80){
            throw new CaballoException("Velocidad no permitida 30-80: "+ caballoDto.getVelocidadMaxima());
        }


        Jinete jinete = new Jinete(caballoDto.getNombreJinete(), caballoDto.getNacionalidadJinete());
        CaballoCarrera caballo = new CaballoCarrera(
                caballoDto.getNombre(),
                caballoDto.getEdad(),
                caballoDto.getVelocidadMaxima(),
                caballoDto.getNumeroDeTriunfos(),
                caballoDto.getExperiencia(), caballoDto.isActivo() );
        caballo.setJinete(jinete);
        
        dao.insertar(caballo);
    }

    public CaballoDTO obtenerJineteCaballo (long idCaballo){
        return dao.obtenerJinete(idCaballo);
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
        CaballoDTO caballoGanador= null;

        if (caballosDTO.size()>=2){
            System.out.println("Empieza la carrera");

            do{
                for (CaballoDTO caballoDTO : caballosDTO) {
                    double avance = getAvance(caballoDTO);
                    caballoDTO.setAvance(caballoDTO.getAvance() + avance);
                    System.out.println("Caballo "+ caballoDTO.getNombre() + " lleva recorridos "+ caballoDTO.getAvance() + " metros");
                    if (caballoDTO.getAvance()>=DISTANCIA){
                        System.out.println("El caballo "+caballoDTO.getNombre() +" ha ganado la carrera");
                        caballoGanador = caballoDTO;
                        break;
                    }
                }
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //Obtenemos el caballo ganador
            }while(caballoGanador==null);



        }else{
            System.out.println("No hay suficientes caballos activos");
        }
    }

    private double getAvance(CaballoDTO caballoDTO) {
        double avance = Math.random()*50 + caballoDTO.getVelocidadMaxima()*(Math.random()*10) +
            caballoDTO.getExperiencia()*(Math.random()*10) - caballoDTO.getEdad()* (Math.random()*10);
        
        return avance<0?0:avance;
    }

    private List<CaballoDTO> generaDTO (List<CaballoCarrera> caballos){
        List<CaballoDTO> dtos = new ArrayList<>();
        for (CaballoCarrera c : caballos) {
            dtos.add(new CaballoDTO(
                    c.getNombre(),
                    c.getEdad(),
                    c.getVelocidadMaxima(),
                    c.getNumeroTriunfos(),
                    c.getExperiencia(),
                    c.isEstaActivo(),
                    c.getJinete().getNombre(), 
                    c.getJinete().getNacionalidad()
            ));
        }
        return dtos;
    }

    public void eliminarCaballo(long id){
        dao.eliminar(id);
    }


    public void actualizarJineteCaballo(Long idCaballo, CaballoDTO caballoDTO){
        //Obtengo el caballo a actualizar
        CaballoCarrera cc = dao.getCaballoPorId(idCaballo);

        //Genero el jinete a partir de la información del DTO
        Jinete jinete = new Jinete(caballoDTO.getNombreJinete(), caballoDTO.getNacionalidadJinete());

        //Asigno el nuevo jinete al caballo
        cc.setJinete(jinete);

        dao.actualizar(cc);
    }

    public List<CaballoCarrera> obtenerCaballosNacionalidadJinete(String nacionalidad){
        return dao.obtenerCaballosPorNacionalidadJinete(nacionalidad);
    }
}
