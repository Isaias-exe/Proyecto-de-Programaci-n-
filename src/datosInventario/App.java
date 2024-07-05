package datosInventario;
import java.util.Scanner;
import java.io.*;
import java.util.*;


import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);

    private static String nombre = ""; //20 caracteres máximo = 42 bytes
    private static int cantidadDeProducto = 0; // 4 bytes
    private static int codigo = 0; // 4 bytes 
    private static String marca = ""; //15 caracteres máximo = 32 bytes
    private static String descripcion = ""; // 60 caracteres máximo = 122 bytes
    private static LocalDate fechaDeVencimiento; //no se cuánto pesa una fecha, pongamosle 10 bytes

   private static double cantidadEnLitros = 0.0; // 8 bytes 
   private static double pesoEnKg = 0.0; // 8 bytes


//total de registro 222 bytes

//lo necesario para manejar el archivo 

public static InventarioDeProductos nuevoProductoEnvasado = new productosEnvasados();
public static InventarioDeProductos nuevoProductoEmpacado = new ProductosEmpacados();


    

private static RandomAccessFile archivo=null;

private static byte []array=null;
    private static ByteArrayOutputStream escribir=null;
    private static ObjectOutputStream salida=null;
    
    //para leer el archivo
    private static ByteArrayInputStream leer=null;
    private static ObjectInputStream entrada = null;

    private static Inventario inventario = new Inventario();




    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenida Nubia Miranda");

           
        

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
                scanner.nextLine();
                 System.out.println("¿Desea añadir un producto empacado o envasado?");
                 System.out.println("1.Producto empacado");
                 System.out.println("2.Produco envasado");
                 opcion = scanner.nextInt();
                 switch (opcion) {
                    case 1:
                        DatosDelRegistro_prod_Empacado();
                        escribirProductoEmpacado();
                        break;
                    case 2: 
                        DatosDelRegistro_prod_Envasado();

                     
                        break;
                    default:
                    System.out.println("Ingrese valores correctos");
                        break;
                 }

                   // ProductosEmpacados producto = new ProductosEmpacados(nombre, cantidadDeProducto, codigo, marca, descripcion, fechaDeVencimiento, pesoEnKg);
                    //inventario.agregarproducto(producto);
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
public static void DatosDelRegistro_prod_Empacado () {
    try {
        do{
        System.out.print("Nombre: ");
            nombre = scanner.next();
                             
             }while(nombre.isEmpty() || nombre.length() != 20);
            
               
            System.out.print("Cantidad de producto: ");
            cantidadDeProducto = scanner.nextInt();
            System.out.print("Código: ");
            codigo = scanner.nextInt();

            do {
                System.out.print("Marca: ");
            marca = scanner.next();
            } while (marca.isEmpty() || marca.length() != 15);

            do {
                System.out.print("Descripción: ");
            descripcion = scanner.next();
                
            } while (descripcion.isEmpty() || descripcion.length() != 60);
    
         System.out.print("Fecha de vencimiento (AAAA-MM-DD): ");
        fechaDeVencimiento = LocalDate.parse(scanner.next());

        System.out.println("Peso en kg: ");
        pesoEnKg = scanner.nextDouble();

        nuevoProductoEmpacado.setNombre(nombre);
        nuevoProductoEmpacado.setCodigo(codigo);
        nuevoProductoEmpacado.setCantidadDeProducto(cantidadDeProducto);
        nuevoProductoEmpacado.setMarca(marca);
        nuevoProductoEmpacado.setDescripcion(descripcion);
        nuevoProductoEmpacado.setFechaDeVencimiento(fechaDeVencimiento);
        ///nuevoProductoEmpacado.setPesoEnKg(pesoEnKg);
        inventario.agregarproducto(nuevoProductoEmpacado);

       // InventarioDeProductos nuevoProductoEmpacado = new ProductosEmpacados(nombre, cantidadDeProducto, codigo, marca, descripcion, fechaDeVencimiento, pesoEnKg);

           
                               
    } catch (Exception e) {
       System.out.println(e);
       System.out.println("Ingrese valores correctos");
    }
       }


 public static void DatosDelRegistro_prod_Envasado () {
        try {
            do{
            System.out.println("Nombre: ");
                nombre = scanner.nextLine();
            }while(nombre.isEmpty() || nombre.length()>20);
                
                   
                System.out.print("Cantidad de producto: ");
                cantidadDeProducto = scanner.nextInt();

                System.out.print("Código: ");
                codigo = scanner.nextInt();
    
                do {
                    System.out.print("Marca: ");
                marca = scanner.next();
                } while (marca.isEmpty() || marca.length() > 15);
    
                do {
                    System.out.print("Descripción: ");
                descripcion = scanner.next();
                    
                } while (descripcion.isEmpty() || descripcion.length() > 60);
        
             System.out.print("Fecha de vencimiento (AAAA-MM-DD): ");
            fechaDeVencimiento = LocalDate.parse(scanner.next());
    
            System.out.println("Litros:  ");
            cantidadEnLitros = scanner.nextDouble();

            nuevoProductoEnvasado.setNombre(nombre);
            nuevoProductoEnvasado.setCodigo(codigo);
            nuevoProductoEnvasado.setCantidadDeProducto(cantidadDeProducto);
            nuevoProductoEnvasado.setDescripcion(descripcion);
            nuevoProductoEnvasado.setMarca(marca);
            nuevoProductoEnvasado.setFechaDeVencimiento(fechaDeVencimiento);
            //nuevoProductoEnvasado.setCantidadEnLitros(cantidadEnLitros);
            inventario.agregarproducto(nuevoProductoEnvasado);


           // InventarioDeProductos nuevoPro = new productosEnvasados(nombre, cantidadDeProducto, vigente, codigo, marca, descripcion, fechaDeVencimiento, cantidadEnLitros);

            
               
                                   
        } catch (Exception e) {
           System.out.println(e);
           System.out.println("Ingrese valores correctos");
        }
           }
    
    private static void escribirProductoEmpacado(){

        try {
            archivo = new RandomAccessFile("src/Inventario_Prod_Empacados.txt", "rw");
            archivo.seek(archivo.length());
            escribir= new ByteArrayOutputStream();
            salida = new ObjectOutputStream(escribir);
            salida.writeObject(nuevoProductoEmpacado.toString());
   
        } catch (Exception e) {
            System.out.println("Error al abrir el archivo" + e.getMessage());
        }
        
    }


    private static void leerProductoEmpacado(){
        try {
            archivo = new RandomAccessFile("src/Inventario_Prod_Empacados.txt", "r");
            archivo.seek(0);
            array = new byte[(int)archivo.length()];
            archivo.readFully(array);
            leer = new ByteArrayInputStream(array);
            entrada = new ObjectInputStream(leer);
            nuevoProductoEmpacado=(InventarioDeProductos) entrada.readObject();
            System.out.println(nuevoProductoEmpacado);
            entrada.close();

        } catch (Exception e) {
            System.out.println("Error al leer el archivo" + e.getMessage());
        }

    }

     

 

}
