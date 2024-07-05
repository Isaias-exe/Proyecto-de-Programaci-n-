package datosInventario;
import java.io.Serializable;


import java.time.LocalDate;
abstract class InventarioDeProductos  implements Serializable {

    private String nombre;
    private int cantidadDeProducto;
    private int codigo;
    private String marca;
    private String descripcion;
    private LocalDate fechaDeVencimiento;

    public InventarioDeProductos (String nombre, int cantidadDeProducto, int codigo, String marca, String descripcion, LocalDate fechaDeVencimiento){
        this.nombre=nombre;
        this.cantidadDeProducto= cantidadDeProducto;
        this.codigo=codigo;
        this.marca=marca;
        this.descripcion=descripcion;
        this.fechaDeVencimiento=fechaDeVencimiento;
    }
    InventarioDeProductos(){ 
      }

    public void setCantidadDeProducto(int cantidadDeProducto) {
        this.cantidadDeProducto = cantidadDeProducto;
    }
    public int getCantidadDeProducto() {
        return cantidadDeProducto;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setFechaDeVencimiento(LocalDate fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }
    public LocalDate getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getMarca() {
        return marca;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    public abstract void mostrarInformacion();

}