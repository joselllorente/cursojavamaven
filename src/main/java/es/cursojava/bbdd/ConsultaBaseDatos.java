package es.cursojava.bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import es.cursojava.utils.UtilidadesBD;

public class ConsultaBaseDatos {
    private static final String CONSULTA_EMPLEADOS=""+
                    " SELECT ID, NOMBRE, EDAD, SALARIO, FECHA_CONTRATACION "+
                    " FROM EMPLEADOS";
    public static void main(String[] args) {

        
        //Este muestra todos los registros de la tabla por la inyección de código
        String nombre2 = "Laura Torres' or '1'='1";
        consultaEmpleadosPorNombre(nombre2);

        //Al usar PrepareStament la consulta va parametrizada y se evita inyección de código
        String nombre1 = "Laura Torres";
        consultaEmpleadosPorNombrePS(nombre1);
        
        //System.out.println("Num empleados "+consultaEmpleadoEdad(0,0).size());

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
                Date fecha = rs.getDate("FECHA_CONTRATACION");

                System.out.println("Registro.[ id: "+ id + ", nombre: "+ nombre
                + ", edad: " + edad + ", salario: "+salario+ " fecha:" + fecha +  "]");

                Empleado emp = new Empleado(id, nombre, edad, salario, id, fecha);
                System.out.println("Fecha empleado "+emp.getFecha_contratacion());
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


    public static List<Empleado> consultaEmpleadosPorNombre (String nombre){
        // Se construye la consulta concatenando el valor directamente
        String sql = "SELECT * FROM EMPLEADOS WHERE NOMBRE = '" + nombre + "'";
        System.out.println(sql);
        try (Connection conn = UtilidadesBD.crearConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID") +
                                   ", NOMBRE: " + rs.getString("NOMBRE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static List<Empleado> consultaEmpleadosPorNombrePS (String nombre){
        // Se construye la consulta concatenando el valor directamente
        String sql = "SELECT * FROM EMPLEADOS WHERE NOMBRE = ? AND EDAD> ?";
        System.out.println(sql);
        try {
            Connection conn = UtilidadesBD.crearConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setInt(2, 20);

            ResultSet rs = ps.executeQuery();
            //ps.executeUpdate();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID") +
                                   ", NOMBRE: " + rs.getString("NOMBRE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
