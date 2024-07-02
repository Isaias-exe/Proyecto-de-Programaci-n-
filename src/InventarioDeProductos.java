import java.time.LocalDate;
abstract class InventarioDeProductos {

    public String nombre;
    private int cantidadDeProducto;
    private boolean vigente;
    private int codigo;
    private String marca;
    private String descripcion;
    private LocalDate fechaDeVencimiento;

    public InventarioDeProductos (String nombre, int cantidadDeProducto, boolean codigo, String marca, String descripcion, LocalDate fechaDeVencimiento){
        this.nombre=nombre;
        this.cantidadDeProducto= cantidadDeProducto;
        this.vigente=vigente;
        this.marca=marca;
        this.descripcion=descripcion;
        this.fechaDeVencimiento=fechaDeVencimiento;
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
    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
    

    public abstract void añadirProducto();
    public abstract void mostrarListaDeProductos();
    public abstract void mostrarPorFechaDeCaducidad();
    public abstract void mostrarEnOrdenAlfabetico();
    public abstract void venderProductos();
    public abstract void eliminarProducto();
    public abstract void notificar();




}
