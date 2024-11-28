package gestioninventario;

import java.util.ArrayList;
import java.util.List;

public class PedidoServicio {
    private static List<Pedido> pedidos = new ArrayList<>();

    public static void registrarPedido(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido registrado: " + pedido.getIdProducto() + ", Cantidad: " + pedido.getCantidad());
    }

    public static void marcarPedidoProcesado(Pedido pedido) {
        pedido.setProcesado(true);
        System.out.println("Pedido procesado: " + pedido.getIdProducto());
    }

    public static List<Pedido> obtenerPedidos() {
        return pedidos;
    }
}