package datosInventario;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);

    private static String nombre = "";
    private static int cantidadDeProducto = 0;
    private static int codigo = 0;
    private static String marca = "";
    private static String descripcion = "";
    private static LocalDate fechaDeVencimiento;

    private static double cantidadEnLitros = 0.0;
    private static double pesoEnKg = 0.0;

    private static Inventario inventario = new Inventario();

    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenida Nubia Miranda");

        while (true) {
            try {
                System.out.println("===========================================");
                System.out.println("1. Agregar producto");
                System.out.println("2. Eliminar producto");
                System.out.println("3. Actualizar producto");
                System.out.println("4. Mostrar productos prontos a vencerse");
                System.out.println("5. Mostrar productos vencidos");
                System.out.println("6. Mostrar todos los productos");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        agregarProducto();
                        break;
                    case 2:
                        eliminarProducto();
                        break;
                    case 3:
                        actualizarProducto();
                        break;
                    case 4:
                        inventario.productosProntosAvencer();
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

            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void agregarProducto() {
        System.out.println("¿Desea añadir un producto empacado o envasado?");
        System.out.println("1. Producto empacado");
        System.out.println("2. Producto envasado");

        try {
            int opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    DatosDelRegistro_prod_Empacado();
                    escribirProductoEmpacado();
                    break;
                case 2:
                    DatosDelRegistro_prod_Envasado();
                    escribirProductoEnvasado();
                    break;
                default:
                    System.out.println("Ingrese valores correctos.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número válido.");
        } catch (Exception e) {
            System.out.println("Error al agregar producto: " + e.getMessage());
        }
    }

    private static void eliminarProducto() {
        System.out.print("Ingrese el código del producto a eliminar: ");
        try {
            int codigoEliminar = Integer.parseInt(scanner.nextLine());
            inventario.eliminarProductos(codigoEliminar);
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número válido.");
        }
    }

    private static void actualizarProducto() {
        System.out.print("Ingrese el código del producto a actualizar: ");
        try {
            int codigoActualizar = Integer.parseInt(scanner.nextLine());

            System.out.print("Nombre: ");
            nombre = scanner.nextLine();

            System.out.print("Cantidad de producto: ");
            cantidadDeProducto = Integer.parseInt(scanner.nextLine());

            System.out.print("Marca: ");
            marca = scanner.nextLine();

            System.out.print("Descripción: ");
            descripcion = scanner.nextLine();

            System.out.print("Fecha de vencimiento (AAAA-MM-DD): ");
            fechaDeVencimiento = LocalDate.parse(scanner.nextLine());

            System.out.print("Peso en Kg: ");
            pesoEnKg = Double.parseDouble(scanner.nextLine());

            ProductosEmpacados productoActualizado = new ProductosEmpacados(nombre, cantidadDeProducto, codigoActualizar, marca, descripcion, fechaDeVencimiento, pesoEnKg);
            inventario.actualizarProductos(codigoActualizar, productoActualizado);
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese valores numéricos válidos.");
        } catch (Exception e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
        }
    }

    public static void DatosDelRegistro_prod_Empacado() {
        try {
            System.out.print("Nombre: ");
            nombre = scanner.nextLine();

            System.out.print("Cantidad de producto: ");
            cantidadDeProducto = Integer.parseInt(scanner.nextLine());

            System.out.print("Código: ");
            codigo = Integer.parseInt(scanner.nextLine());

            System.out.print("Marca: ");
            marca = scanner.nextLine();

            System.out.print("Descripción: ");
            descripcion = scanner.nextLine();

            System.out.print("Fecha de vencimiento (AAAA-MM-DD): ");
            fechaDeVencimiento = LocalDate.parse(scanner.nextLine());

            System.out.print("Peso en kg: ");
            pesoEnKg = Double.parseDouble(scanner.nextLine());

            ProductosEmpacados nuevoProductoEmpacado = new ProductosEmpacados(nombre, cantidadDeProducto, codigo, marca, descripcion, fechaDeVencimiento, pesoEnKg);
            inventario.agregarProducto(nuevoProductoEmpacado);
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese valores numéricos válidos.");
        } catch (Exception e) {
            System.out.println("Error al registrar producto empacado: " + e.getMessage());
        }
    }

    public static void DatosDelRegistro_prod_Envasado() {
        try {
            System.out.print("Nombre: ");
            nombre = scanner.nextLine();

            System.out.print("Cantidad de producto: ");
            cantidadDeProducto = Integer.parseInt(scanner.nextLine());

            System.out.print("Código: ");
            codigo = Integer.parseInt(scanner.nextLine());

            System.out.print("Marca: ");
            marca = scanner.nextLine();

            System.out.print("Descripción: ");
            descripcion = scanner.nextLine();

            System.out.print("Fecha de vencimiento (AAAA-MM-DD): ");
            fechaDeVencimiento = LocalDate.parse(scanner.nextLine());

            System.out.print("Litros: ");
            cantidadEnLitros = Double.parseDouble(scanner.nextLine());

            ProductosEnvasados nuevoProductoEnvasado = new ProductosEnvasados(nombre, cantidadDeProducto, codigo, marca, descripcion, fechaDeVencimiento, cantidadEnLitros);
            inventario.agregarProducto(nuevoProductoEnvasado);
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese valores numéricos válidos.");
        } catch (Exception e) {
            System.out.println("Error al registrar producto envasado: " + e.getMessage());
        }
    }

    private static void escribirProductoEmpacado() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Inventario_Prod_Empacados.dat", true))) {
            oos.writeObject(new ProductosEmpacados(nombre, cantidadDeProducto, codigo, marca, descripcion, fechaDeVencimiento, pesoEnKg));
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    private static void escribirProductoEnvasado() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Inventario_Prod_Envasados.dat", true))) {
            oos.writeObject(new ProductosEnvasados(nombre, cantidadDeProducto, codigo, marca, descripcion, fechaDeVencimiento, cantidadEnLitros));
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
}