import java.time.LocalDate;

public class productosEnvasados extends InventarioDeProductos{

    private double cantidadEnLitros;


    public productosEnvasados (String nombre, int cantidadDeProducto, boolean vigente , int codigo, String marca, String descripcion, LocalDate fechaDeVencimiento, double cantidadEnLitros){

        super(nombre, cantidadDeProducto, vigente, codigo, marca, descripcion, fechaDeVencimiento);
        this.cantidadEnLitros=cantidadEnLitros;
        
    }

    public void setCantidadEnLitros(double cantidadEnLitros) {
        this.cantidadEnLitros = cantidadEnLitros;
    }
    public double getCantidadEnLitros() {
        return cantidadEnLitros;
    }


    
    @Override
    public void mostrarProducto() {
        System.out.println("====================================");
        System.out.print("Detalles del: " + nombre + " | ");
        System.out.print( "Cantidad en inventario: " + getCantidadDeProducto() + " | " );
        System.out.print("Marca: " + getMarca() + " | " );
        System.out.print(getCantidadEnLitros() + "Litros" + " | ");
        System.out.print("Código: " + getCodigo() + " | ");
        System.out.print(getDescripcion() + " | ");
        System.out.print("Vence: " + getFechaDeVencimiento());
        
    }
  
        
        
    

}
