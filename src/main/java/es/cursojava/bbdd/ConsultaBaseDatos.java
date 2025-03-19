package es.cursojava.bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.cursojava.utils.UtilidadesBD;

public class ConsultaBaseDatos {
    private static final String CONSULTA_EMPLEADOS=""+
                    " SELECT ID, NOMBRE, EDAD, SALARIO "+
                    " FROM EMPLEADOS";
    public static void main(String[] args) {

        System.out.println("Num empleados "+consultaEmpleadoEdad(0,0).size());

    }

    public static void consultaEmpleados() {
        
        Connection conexion = UtilidadesBD.crearConexion();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conexion.createStatement();
            rs = st.executeQuery(CONSULTA_EMPLEADOS);
            while(rs.next()){
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                int edad = rs.getInt("EDAD");
                double salario = rs.getDouble("SALARIO");

                System.out.println("Registro.[ id: "+ id + ", nombre: "+ nombre
                        + ", edad: " + edad + ", salario: "+salario+ "]");

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


        System.out.println("TERMINA");
    }


    public static List<Empleado> consultaEmpleadoEdad(int edadConsultada, double salarioConsultado) {
        List<Empleado> empleados = new ArrayList<>();

        Connection conexion = UtilidadesBD.crearConexion();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conexion.createStatement();
            String query = CONSULTA_EMPLEADOS + " WHERE 1=1 ";

            if (edadConsultada!=0){
                query+= " AND EDAD>"+edadConsultada;
            }

            if (salarioConsultado!=0){
                query+= " AND SALARIO>"+salarioConsultado;
            }

            System.out.println(query);

            rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                int edad = rs.getInt("EDAD");
                double salario = rs.getDouble("SALARIO");

                System.out.println("Registro.[ id: "+ id + ", nombre: "+ nombre
                + ", edad: " + edad + ", salario: "+salario+ "]");

                Empleado emp = new Empleado(id, nombre, edad, salario, id, null);
                empleados.add(emp);
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
