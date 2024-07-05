package datosInventario;


import java.time.LocalDate;

public class productosEnvasados extends InventarioDeProductos { //no se si asi funcione el serializable

    private double cantidadEnLitros;


    public productosEnvasados (String nombre, int cantidadDeProducto, boolean vigente , int codigo, String marca, String descripcion, LocalDate fechaDeVencimiento, double cantidadEnLitros){

        super(nombre, cantidadDeProducto, codigo, marca, descripcion, fechaDeVencimiento);
        this.cantidadEnLitros=cantidadEnLitros;
        
    }

  productosEnvasados (){
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
        System.out.print( "Cantidad en inventario: " + getCantidadDeProducto() + " | " );
        System.out.print("Marca: " + getMarca() + " | " );
        System.out.print(getCantidadEnLitros() + "Litros" + " | ");
        System.out.print("Código: " + getCodigo() + " | ");
        System.out.print(getDescripcion() + " | ");
        System.out.print("Vence: " + getFechaDeVencimiento());
        
    }
  
        
        
    @Override
    public String toString() {
        return this.getNombre() + this.getCantidadDeProducto() + this.getCodigo() + 
        this.getMarca() + this.getDescripcion() + this.getFechaDeVencimiento() + this.getCantidadEnLitros();
   }

}