package datosInventario;
import java.time.LocalDate;
public class ProductosEmpacados extends InventarioDeProductos{
    private double pesoEnKg;

    public ProductosEmpacados(String nombre, int cantidadDeProducto, int codigo, String marca, String descripcion, LocalDate fechaDeVencimiento, double pesoEnKg){
        super(nombre, cantidadDeProducto, codigo, marca, descripcion, fechaDeVencimiento);
      this.pesoEnKg=pesoEnKg;
        
    }
   
   ProductosEmpacados(){
   }


    public double getPesoEnKg() {
        return pesoEnKg;
    }
    public void setPesoEnKg(double pesoEnKg) {
        this.pesoEnKg = pesoEnKg;
    }
    

    
         
    @Override
    public void mostrarInformacion(){
        System.out.println("====================================");
        System.out.print("Detalles del: " + getNombre() + " | ");
        System.out.print( "Cantidad en inventario: " + getCantidadDeProducto() + " | " );
        System.out.print("Marca: " + getMarca() + " | " );
        System.out.print(getPesoEnKg() + "Kg" + " | ");
        System.out.print("Código: " + getCodigo() + " | ");
        System.out.print(getDescripcion() + " | ");
        System.out.print("Vence: " + getFechaDeVencimiento());
        
    }

    @Override
    public String toString() {
        return super.toString() + ", Peso en kg: " + getPesoEnKg();
    }

  

}