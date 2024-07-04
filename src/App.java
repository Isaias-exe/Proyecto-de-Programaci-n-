import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

           Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Mostrar productos prontos a vencerse");
            System.out.println("5. Mostrar productos vencidos");
            System.out.println("6. Mostrar todos los productos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.next();
                    System.out.print("Cantidad de producto: ");
                    int cantidadDeProducto = scanner.nextInt();
                    System.out.print("Código: ");
                    int codigo = scanner.nextInt();
                    System.out.print("Marca: ");
                    String marca = scanner.next();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.next();
                    System.out.print("Fecha de vencimiento (AAAA-MM-DD): ");
                    LocalDate fechaDeVencimiento = LocalDate.parse(scanner.next());
                    System.out.print("Peso en Kg: ");
                    double pesoEnKg = scanner.nextDouble();

                    ProductosEmpacados producto = new ProductosEmpacados(nombre, cantidadDeProducto, codigo, marca, descripcion, fechaDeVencimiento, pesoEnKg);
                    inventario.agregarproducto(producto);
                    break;
                case 2:
                    System.out.print("Ingrese el código del producto a eliminar: ");
                    int codigoEliminar = scanner.nextInt();
                    inventario.eliminarProductos(codigoEliminar);
                    break;
                case 3:
                    System.out.print("Ingrese el código del producto a actualizar: ");
                    int codigoActualizar = scanner.nextInt();
                    System.out.print("Nombre: ");
                    nombre = scanner.next();
                    System.out.print("Cantidad de producto: ");
                    cantidadDeProducto = scanner.nextInt();
                    System.out.print("Marca: ");
                    marca = scanner.next();
                    System.out.print("Descripción: ");
                    descripcion = scanner.next();
                    System.out.print("Fecha de vencimiento (AAAA-MM-DD): ");
                    fechaDeVencimiento = LocalDate.parse(scanner.next());
                    System.out.print("Peso en Kg: ");
                    pesoEnKg = scanner.nextDouble();

                    ProductosEmpacados productoActualizado = new ProductosEmpacados(nombre, cantidadDeProducto, codigoActualizar, marca, descripcion, fechaDeVencimiento, pesoEnKg);
                    inventario.actualizarProductos(codigoActualizar, productoActualizado);
                    break;
                case 4:
                    inventario.ProductosProntosAvencer();
                    break;
                case 5:
                    inventario.productosVencidos();
                    break;
                case 6:
                    inventario.mostrarTodosLosProductos();
                    break;
                case 7:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
