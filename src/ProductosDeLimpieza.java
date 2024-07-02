import java.time.LocalDate;

public class ProductosDeLimpieza extends InventarioDeProductos{

    private double cantidadEnLitros;
    private String aroma;


    public ProductosDeLimpieza(String nombre, int cantidadDeProducto, boolean vigente , int codigo, String marca, String descripcion, LocalDate fechaDeVencimiento, double cantidadEnLitros, String aroma){
        super(nombre, cantidadDeProducto, vigente, codigo, marca, descripcion, fechaDeVencimiento);
        this.aroma=aroma;
        this.cantidadEnLitros=cantidadEnLitros;
    }



    public double getCantidadEnLitros() {
        return cantidadEnLitros;
    }
    public void setCantidadEnLitros(double cantidadEnLitros) {
        this.cantidadEnLitros = cantidadEnLitros;
    }
    public void setAroma(String aroma) {
        this.aroma = aroma;
    }
    public String getAroma() {
        return aroma;
    }


    @Override
    public void mostrarProducto() {
        System.out.println("====================================");
        System.out.print("Detalles del: " + nombre + " | ");
        System.out.print( "Cantidad en inventario: " + getCantidadDeProducto() + " | " );
        System.out.print("Marca: " + getMarca() + " | " );
        System.out.print( cantidadEnLitros + "Litros" + " | ");
        System.out.print("Código: " + getCodigo() + " | ");
        System.out.print(getDescripcion() + " | ");
        System.out.println("Aroma: " + aroma);
        System.out.print("Vence: " + getFechaDeVencimiento());
        
    }

}
