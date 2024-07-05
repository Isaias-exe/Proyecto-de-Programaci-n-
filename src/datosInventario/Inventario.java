package datosInventario;

import java.time.LocalDate;
import java.util.ArrayList;

public class Inventario {
    private ArrayList<InventarioDeProductos> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(InventarioDeProductos producto) {
        productos.add(producto);
    }

    public void eliminarProductos(int codigo) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo() == codigo) {
                productos.remove(i);
                System.out.println("Producto con código " + codigo + " eliminado.");
                return;
            }
        }
        System.out.println("Producto con código " + codigo + " no encontrado.");
    }

    public void actualizarProductos(int codigo, InventarioDeProductos nuevoProducto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo() == codigo) {
                productos.set(i, nuevoProducto);
                System.out.println("Producto con código " + codigo + " actualizado.");
                return;
            }
        }
        System.out.println("Producto con código " + codigo + " no encontrado.");
    }

    public void productosProntosAvencer() {
        System.out.println("Productos pronto a vencerse, debería venderlos lo más antes posible");
        LocalDate hoy = LocalDate.now();
        for (InventarioDeProductos producto : productos) {
            if (producto.getFechaDeVencimiento().isAfter(hoy) && producto.getFechaDeVencimiento().isBefore(hoy.plusDays(15))) {
                producto.mostrarInformacion();
            }
        }
    }

    public void productosVencidos() {
        System.out.println("Productos vencidos, por favor retirar del inventario");
        LocalDate hoy = LocalDate.now();
        for (InventarioDeProductos producto : productos) {
            if (producto.getFechaDeVencimiento().isBefore(hoy)) {
                producto.mostrarInformacion();
            }
        }
    }

    public void mostrarTodosLosProductos() {
        for (InventarioDeProductos producto : productos) {
            producto.mostrarInformacion();
        }
    }
}