package datosInventario;

import java.time.LocalDate;
public class ProductosEnvasados extends InventarioDeProductos {

    private double cantidadEnLitros;

    public ProductosEnvasados(String nombre, int cantidadDeProducto, int codigo, String marca, String descripcion, LocalDate fechaDeVencimiento, double cantidadEnLitros) {
        super(nombre, cantidadDeProducto, codigo, marca, descripcion, fechaDeVencimiento);
        this.cantidadEnLitros = cantidadEnLitros;
    }

    ProductosEnvasados() {
    }

    public void setCantidadEnLitros(double cantidadEnLitros) {
        this.cantidadEnLitros = cantidadEnLitros;
    }

    public double getCantidadEnLitros() {
        return cantidadEnLitros;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("====================================");
        System.out.print("Detalles del: " + getNombre() + " | ");
        System.out.print("Cantidad en inventario: " + getCantidadDeProducto() + " | ");
        System.out.print("Marca: " + getMarca() + " | ");
        System.out.print(getCantidadEnLitros() + " Litros" + " | ");
        System.out.print("Código: " + getCodigo() + " | ");
        System.out.print(getDescripcion() + " | ");
        System.out.print("Vence: " + getFechaDeVencimiento());
    }

    @Override
    public String toString() {
        return super.toString() + ", Cantidad en litros: " + getCantidadEnLitros();
    }
}