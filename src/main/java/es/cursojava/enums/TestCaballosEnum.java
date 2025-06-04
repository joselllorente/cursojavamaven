package es.cursojava.enums;

public class TestCaballosEnum {
    public static void main(String[] args) {
        System.out.println(CaballosEnum.CABALLO1);
        System.out.println(CaballosEnum.CABALLO1.getNombre());
        CaballosEnum.CABALLO1.setNombre("Caballo modificado");
        System.out.println(CaballosEnum.CABALLO1.getNombre());

        System.out.println("===========================");
        for ( CaballosEnum ce   : CaballosEnum.values() ){
            System.out.println(ce.getNombre());
        }

        

    }
}
