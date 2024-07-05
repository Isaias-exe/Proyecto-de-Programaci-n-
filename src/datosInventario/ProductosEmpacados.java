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

        System.out.println("Producto empacado { "+"Nombre= "+getNombre()+'\'' +"Cantidad de producto= "+getCantidadDeProducto()+
        " Codigo= "+getCodigo()+"Marca= "+getMarca()+" Descripcion= "+getDescripcion()+" Fecha de vencimiento= "+getFechaDeVencimiento()+"Peso de producto= "+getPesoEnKg()+" }");
    }

    @Override
    public String toString() {
        return this.getNombre() + this.getCantidadDeProducto() + this.getCodigo() + 
        this.getMarca() + this.getDescripcion() + this.getFechaDeVencimiento() + this.getPesoEnKg();
   }

}