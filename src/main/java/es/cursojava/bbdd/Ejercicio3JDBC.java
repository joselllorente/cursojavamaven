package es.cursojava.bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.cursojava.utils.UtilidadesBD;

public class Ejercicio3JDBC {
    private static final String CONSULTA_EMPLEADOS=""+
                    " SELECT e.ID as ID_EMPLEADO, e.NOMBRE as NOMBRE_EMPLEADO, e.EDAD as EDAD_EMPLEADO, "+
                    " e.SALARIO as SALARIO_EMPLEADO, e.DEPARTAMENTO_ID, "+
                    " e.FECHA_CONTRATACION as CONTRATACION_EMPLEADO, eq.NOMBRE as NOMBRE_EQUIPO "+
                    " FROM EMPLEADOS e "+
                    " JOIN EQUIPOS eq ON e.id_equipo=eq.id";
    public static void main(String[] args) {


    }

    


    public static List<Empleado> consultaEmpleadoMap() {
        List<Empleado> empleados = new ArrayList<>();
        Map<String, List<Empleado>> mapaEmpleados = new HashMap<>();
        
        Connection conexion = UtilidadesBD.crearConexion();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conexion.createStatement();
            String query = CONSULTA_EMPLEADOS;

            System.out.println(query);

            rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("ID_EMPLEADO");
                String nombreEmpleado = rs.getString("NOMBRE_EMPLEADO");
                String nombreEquipo = rs.getString("NOMBRE_EQUIPO");
                int edad = rs.getInt("EDAD_EMPLEADO");
                double salario = rs.getDouble("SALARIO_EMPLEADO");

                
                Empleado emp = new Empleado(id, nombreEmpleado, edad, salario, id, null);
                empleados.add(emp);
                
                mapaEmpleados.putIfAbsent(nombreEquipo, new ArrayList<>());
                mapaEmpleados.get(nombreEquipo).add(emp);

            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            UtilidadesBD.cierraConexion(conexion);
            try {
                st.close();
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


        return empleados;
    }

}
