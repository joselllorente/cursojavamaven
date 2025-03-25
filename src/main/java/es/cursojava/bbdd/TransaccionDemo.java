package es.cursojava.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.cursojava.utils.UtilidadesBD;

public class TransaccionDemo {

    public static void main(String[] args) {
        testTransaction();
    }
    
    public static void testTransaction(){
        int contador =10_000;
        Connection con = null;
        PreparedStatement ps = null;
        try{
            
            con = UtilidadesBD.crearConexion();
            con.setAutoCommit(false);

            //Borramos la tabla
            String delete = "DELETE FROM EMPLEADOS";
            ps = con.prepareStatement(delete); 
            int totalBorrados = ps.executeUpdate();
            System.out.println("Registros eliminados: "+totalBorrados);
            ps.close();

            String insert = "INSERT INTO EMPLEADOS VALUES (?,?,?,?,?,?,?)";
            
            java.util.Date fecha = new java.util.Date();
            for (int i = 1; i < 99999; i++) {
                ps = con.prepareStatement(insert); 
                ps.setInt(1, i);
                ps.setString(2, "Nombre "+i);
                ps.setInt(3, (int)(Math.random()*100));
                ps.setDouble(4, Math.random()*10000);
                ps.setInt(5, 2);
                ps.setDate(6, null);
                ps.setInt(7,1);

                ps.executeUpdate();
                
                // if(i==contador){

                //     contador+=100_000;
                // }

                if(i%contador==0){
                    java.util.Date fecha2  = new java.util.Date();
                    long tiempoFinal = fecha2.getTime() - fecha.getTime();
                    System.out.println("Tiempo transcurrido para "+ i +" registros = " + tiempoFinal);
                    Thread.sleep(2000);
                }

                if (i==999999){
                    throw new SQLException("Por que sí");
                }

                ps.close();
            }

            //Realizamos el commit
            con.commit();
        }catch(Exception sqle){
            System.out.println("Error" + sqle.getMessage());
            try {
                con.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }finally{
            System.out.println("Cerramos conexiones");
            
            try {
                con.setAutoCommit(true);
                con.close();
                ps.close();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }



    }
}

