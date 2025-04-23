package es.cursojava.hibernate;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.query.Query;

import es.cursojava.hibernate.dto.ClienteDTO;
import es.cursojava.hibernate.entities.Cliente;
import es.cursojava.hibernate.entities.Pedido;
import es.cursojava.inicio.funciones.Utilidades;

public class ClientePedidosMain {
    public static void main(String[] args) {

        //ingresarClientes();
        //mostrarPedidosPorEmail();
        //mostrarPedidosSolicitandoEmail();
        mostrarPedidosPorFecha();

    }

    public static void ingresarClientes() {

        Session session = HibernateUtil.getSession();

        try {
            //ArrayList<Pedido> pedidos = new ArrayList<>();
            int cantidadPedido = 0;

            for (int i = 0; i < 3; i++) {

                String nombre = "Nombre " + i;
                String email = "email"+i+"@gmail.com";
                Cliente cliente = new Cliente(nombre, email);

                for (int j = 0; j < 4; j++) {
                    String descripcionPedido = "DescPedido"+j;
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechaPedido=null;
                    try {
                        fechaPedido = format.parse("23/12/2018");
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    double precioPedido = Math.random()*1000;
                    
                    Pedido pedido = new Pedido(descripcionPedido, fechaPedido, precioPedido);
                    pedido.setCliente(cliente);
                    pedido.setPrecioPedido(precioPedido);
                    cliente.getPedidos().add(pedido);
                }
                session.beginTransaction();
                session.persist(cliente);
                session.getTransaction().commit();
            }
        } finally {
            session.close();
        }
    }

    public static void mostrarPedidosPorEmail() {

        Session session = HibernateUtil.getSession();

        // String queryCliente = "SELECT new
        // es.cursojava.hibernate.dto.ClienteDTO(c.email, AVG(c.valor)) FROM Cliente c
        // GROUP BY c.email = :param1";
        String queryCliente = "SELECT new es.cursojava.hibernate.dto.ClienteDTO(p.cliente.email, AVG(p.precioPedido)) FROM Pedido p GROUP BY p.cliente.email";

        Query<ClienteDTO> query = session.createQuery(queryCliente, ClienteDTO.class);

        List<ClienteDTO> resultados = query.list();

        for (ClienteDTO dto : resultados) {
            System.out.println("Email: " + dto.getEmail() + ", Media de pedidos: "
                    + dto.getMediaPedidos());
        }

    }

    public static void mostrarPedidosSolicitandoEmail() {

        Session session = HibernateUtil.getSession();

        String email = Utilidades.pideDatoCadena("¿De que email quieres saber el promedio de pedidos?");

        // String queryCliente = "SELECT new
        // es.cursojava.hibernate.dto.ClienteDTO(c.email, AVG(c.valor)) FROM Cliente c
        // GROUP BY c.email = :param1";
        String queryCliente = "SELECT "+
            "new es.cursojava.hibernate.dto.ClienteDTO(p.cliente.email, AVG(p.precioPedido)) "+
            " FROM Pedidos p WHERE p.cliente.email = :param1 "+
            " GROUP BY p.cliente.email";

        Query<ClienteDTO> query = session.createQuery(queryCliente, ClienteDTO.class);

        query.setParameter("param1", email);

        List<ClienteDTO> resultados = query.list();

        for (ClienteDTO dto : resultados) {
            System.out.println("Email: " + dto.getEmail() + ", Media de pedidos: "
                    + dto.getMediaPedidos());
        }

    }

    public static void mostrarPedidosPorFecha() {
        Session session = HibernateUtil.getSession();
        Date fecha = Utilidades.pideDatoDate("¿De que fecha quieres saber el total de pedidos?");

        String queryCliente = "SELECT SUM(p.precioPedido) FROM Pedido p WHERE p.fechaPedido = :param1";
        // GROUP BY p.fechaPedido
        Query<Double> query = session.createQuery(queryCliente, Double.class);

        query.setParameter("param1", fecha);

        Double sumatorioPorFecha = query.uniqueResult();

        NumberFormat formato = NumberFormat.getNumberInstance(new Locale("es", "ES"));
        formato.setMinimumFractionDigits(3);
        formato.setMaximumFractionDigits(3);

        String numeroFormateado = formato.format(sumatorioPorFecha);

        System.out.println("La suma de los pedidos para la fecha: " + fecha + ",es: " + numeroFormateado);

    }

}