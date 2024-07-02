import java.time.LocalDate;
import java.util.ArrayList;

public class Inventario {
private ArrayList<InventarioDeProductos>productos;

public Inventario(){
    productos=new ArrayList<>();
}
public void agregarproducto(InventarioDeProductos producto){
    productos.add(producto);
}
public void eliminarProductos(int codigo){
    for (int i = 0; i < productos.size(); i++) {
        if (productos.get(i).getCodigo()==codigo) {
            productos.remove(i);
            break;   
        }
    }
    System.out.println("Producto con código "+codigo+" no encontrado. ");
}

public void actualizarProductos(int codigo, InventarioDeProductos nuevProductos){
    for (int i = 0; i <productos.size(); i++) {
        if (productos.get(i).getCodigo()==codigo) {
            productos.set(i, nuevProductos);
            break;
        }
    }
    System.out.println("producto con código "+codigo+" no encontrado.");
}
public void ProductosProntosAvencer(){
    LocalDate hoy =LocalDate.now();

  for (InventarioDeProductos producto : productos) {
    if (producto.getFechaDeVencimiento().isAfter(hoy) && producto.getFechaDeVencimiento().isBefore(hoy.plusDays(15)) ) { 

        producto.mostrarInformacion();
        
    }
    
  }
}
public void productosVencidos(){
    LocalDate hoy=LocalDate.now();
    for (InventarioDeProductos producto : productos) {
        if (producto.getFechaDeVencimiento().isBefore(hoy)) {
            producto.mostrarInformacion();
            
        }
        
    }
}
public void mostrarTodosLosProductos(){
    for (InventarioDeProductos producto : productos) {

        producto.mostrarInformacion();
        
    }
}
}