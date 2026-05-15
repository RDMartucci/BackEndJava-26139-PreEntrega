package com.techlab.articulo;

// ============================================================
// CONSIGNA GENERAL DE LA PREENTREGA
// ============================================================
//
// Desarrollar una aplicación en Java por consola que permita gestionar
// artículos y categorías de una tienda.
//
// La aplicación deberá trabajar con:
// - Programación Orientada a Objetos
// - Clase abstracta
// - Herencia
// - Polimorfismo
// - Interfaces
// - Generics
// - Relación entre objetos
// - Menús separados
//
// ESTRUCTURA CONCEPTUAL ESPERADA
// ------------------------------------------------------------
// 1) Debe existir una clase abstracta Articulo con:
//    - codigo
//    - nombre
//    - precio
//    - categoria (objeto Categoria, NO String)
//
// 2) Deben existir dos clases hijas de Articulo:
//    - ArticuloElectronico
//    - ArticuloAlimenticio
//
// 3) Debe existir una clase Categoria con su propio CRUD.
//
// 4) Debe existir una interfaz Calculable con el método:
//    - double calcularPrecioFinal();
//
// 5) Debe existir una interfaz Identificable con el método:
//    - int getCodigo();
//
// 6) Debe existir un Repositorio<T extends Identificable>
//    para administrar artículos y categorías en memoria.
//
// 7) Debe existir una clase base Menu y dos menús hijos:
//    - MenuArticulos
//    - MenuCategorias
//
// REGLAS DE NEGOCIO PRINCIPALES
// ------------------------------------------------------------
// - No se puede crear un artículo si no existen categorías cargadas.
// - No se puede eliminar una categoría si tiene artículos asociados.
// - Los códigos de artículos y categorías deben ser automáticos.
// - Deben validarse todos los datos ingresados.
// - No debe resolverse toda la lógica dentro del main.
//
// IMPORTANTE
// ------------------------------------------------------------
// Este proyecto se entrega como PLANTILLA.
// Eso significa que:
// - la estructura ya está armada,
// - los nombres de las clases ya están definidos,
// - y en cada archivo encontrarás instrucciones específicas
//   sobre qué implementar.
//
// Tu tarea será completar cada clase respetando esta estructura.
//

import java.util.ArrayList;

// Importamos Scanner para leer datos por consola.
import java.util.Scanner;

// Importamos los menús que luego deberán completarse.
import com.techlab.articulo.menu.MenuArticulos;
import com.techlab.articulo.menu.MenuCategorias;

import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.model.ArticuloAlimenticio;
import com.techlab.articulo.model.ArticuloElectronico;
import com.techlab.articulo.model.Categoria;

public class App {

    public static void main(String[] args) {

        // ============================================================
        // INSTRUCCIONES PARA ESTA CLASE
        // ============================================================
        //
        // Esta clase debe actuar como punto de entrada del programa.
        //
        // ¿Qué debe hacer el alumno acá?
        // 1) Crear un Scanner compartido.
        // 2) Crear los repositorios necesarios:
        // - Repositorio<Articulo>
        // - Repositorio<Categoria>
        // 3) Crear los dos menús:
        // - MenuArticulos
        // - MenuCategorias
        // 4) Crear un menú principal que permita elegir:
        // - 1: ir al menú de artículos
        // - 2: ir al menú de categorías
        // - 0: salir
        // 5) Cerrar correctamente el Scanner al finalizar.
        //
        // Sugerencia:
        // El main NO debe tener toda la lógica del sistema.
        // El main solo debe coordinar el flujo principal.
        //
        // ============================================================

        Scanner scanner = new Scanner(System.in);

        // Lista donde guardaremos los artículos.
        ArrayList<Articulo> articulos = new ArrayList<>();

        // Lista donde guardaremos categorías precargadas.
        ArrayList<Categoria> categorias = new ArrayList<>();

        // Cargamos algunas categorías fijas para poder usarlas al crear artículos.
        precargarCategorias(categorias);

        // TODO:
        // Crear aquí los repositorios genéricos.

        // TODO:
        // Crear aquí los menús y pasarles lo que necesiten por constructor.

        // TODO:
        // Implementar el menú principal de la aplicación.

        // variable de control del menú principal.
        int opcion;
        do {
            System.out.println("\n===================================================");
            System.out.println("| BroncoMuebles - CRUD DE ARTÍCULOS con CATEGORÍAS |");
            System.out.println("|--------------------------------------------------|");
            System.out.println("| 1 - Ingresar artículo                            |");
            System.out.println("| 2 - Listar artículos                             |");
            System.out.println("| 3 - Consulta por artículo                        |");
            System.out.println("| 4 - Modificar artículo                           |");
            System.out.println("| 5 - Eliminar artículo                            |");
            System.out.println("| 6 - Listar categorías precargadas                |");
            System.out.println("| 0 - Salir                                        |");
            System.out.println("====================================================\n");

            // System.out.println("\nIngrese una opción: ");
            // opcion = scanner.nextInt();

            opcion = validarEntero(scanner, "Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    ingresarArticulo(scanner, articulos, categorias);
                    //System.out.println("\nFuncionalidad de ingreso de artículo aún no implementada.");
                    break;
                case 2:
                    // System.out.println("\nFuncionalidad de listado de artículos aún no
                    // implementada.");
                    listarArticulos(articulos);
                    break;
                case 3:
                    consultarArticulo(scanner, articulos);
                    //System.out.println("\nFuncionalidad de consulta de artículo aún no implementada.");
                    break;
                case 4:
                    modificarArticulo(scanner, articulos, categorias);
                    //System.out.println("\nFuncionalidad de modificación de artículo aún no implementada.");
                    break;
                case 5:
                    eliminarArticulo(scanner, articulos);
                    //System.out.println("\nFuncionalidad de eliminación de artículo aún no implementada.");
                    break;
                case 6:
                    listarCategorias(categorias);
                    // System.out.println("\nFuncionalidad de listado de categorías aún no
                    // implementada.");
                    break;
                case 0:
                    System.out.println("\nSaliendo del sistema.");
                    break;
                default:
                    System.out.println("\n¡Error!: la opción ingresada no es válida.");
            }

        } while (opcion != 0);

        scanner.close();

    }

    // Método auxiliar para precargar categorías.
    public static void precargarCategorias(ArrayList<Categoria> categorias) {
        categorias.add(new Categoria(1, "Electrónicos", "Productos tecnológicos y electrónicos"));
        categorias.add(new Categoria(2, "Alimentos", "Productos alimenticios"));
        categorias.add(new Categoria(3, "Repuestos", "Repuestos para vehículos"));
        categorias.add(new Categoria(4, "Ferretería", "Artículos de ferretería en general"));
    }

    // Método auxiliar para leer un número entero con validación.
    public static int validarEntero(Scanner scanner, String mensaje) {

        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("¡Error! debe ingresar un número entero válido.");
            }
        }
    }

    // Metodo para listar los artículos cargados.
    public static void listarArticulos(ArrayList<Articulo> articulos) {
        if (articulos.isEmpty()) {
            System.out.println("¡No hay artículos para mostrar!");
            return;
        }

        System.out.println("\n=========================================");
        System.out.println("|        LISTADO DE ARTÍCULOS            |");
        System.out.println("|----------------------------------------|\n");

        for (Articulo articulo : articulos) {
            System.out.println(articulo);
        }
    }

     // Metodo para listar las categorías cargadas.
    public static void listarCategorias(ArrayList<Categoria> categorias) {
        if (categorias.isEmpty()) {
            System.out.println("¡No hay categorías para mostrar!");
            return;
        }

        System.out.println("\n============================================================");
        System.out.println("| LISTADO DE CATEGORÍAS                                     |");
        System.out.println("|-----------------------------------------------------------|\n");

        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }

    }

    // Método para ingresar un artículo.
    public static void ingresarArticulo(
            Scanner scanner, 
            ArrayList<Articulo> articulos,
            ArrayList<Categoria> categorias) {

        System.out.println("\n=========================================");
        System.out.println("|      INGRESAR ARTICULO al SISTEMA      |");
        System.out.println("|----------------------------------------|");
        System.out.println("1 - Artículo electrónico");
        System.out.println("2 - Artículo alimenticio");
        System.out.println("=========================================\n");

        int tipoArticulo;
        do {
            tipoArticulo = validarEntero(scanner, "Seleccione el tipo de artículo: ");
            if (tipoArticulo != 1 && tipoArticulo != 2) {
                System.out.println("Error: debe elegir 1 o 2.");
            }
        } while (tipoArticulo != 1 && tipoArticulo != 2);

        int codigo = validarEntero(scanner, "Código del artículo: ");

        if (buscarArticuloPorCodigo(articulos, codigo) != null) {
            System.out.println("Error: ya existe un artículo con ese código.");
            return;
        }

        String nombre = validarTextoNoVacio(scanner, "Nombre del artículo: ");
        double precio = validarDoubleNoNegativo(scanner, "Precio del artículo: ");

        listarCategorias(categorias);
        Categoria categoria = pedirCategoriaExistente(scanner, categorias);

        Articulo articulo;

        if (tipoArticulo == 1) {
            int garantiaMeses = validarEnteroNoNegativo(scanner, "Garantía en meses: ");
            articulo = new ArticuloElectronico(codigo, nombre, precio, categoria, garantiaMeses);
        } else {
            int diasParaVencer = validarEnteroNoNegativo(scanner, "Días para su vencimiento: ");
            articulo = new ArticuloAlimenticio(codigo, nombre, precio, categoria, diasParaVencer);
        }

        articulos.add(articulo);

        System.out.println("Artículo ingresado correctamente.");
        System.out.println("Resumen del artículo creado:");
        System.out.println(articulo);
        System.out.println("Precio final calculado: " + articulo.calcularPrecioFinal());
    }

    // Método auxiliar para validar un número entero no negativo.
    public static int validarEnteroNoNegativo(Scanner scanner, String mensaje) {
        while (true) {
            int valor = validarEntero(scanner, mensaje);

            if (valor < 0) {
                System.out.println("¡Error!: el valor no puede ser negativo.");
                continue;
            }

            return valor;
        }
    }

    // Método para buscar artículo por código.
    public static Articulo buscarArticuloPorCodigo(ArrayList<Articulo> articulos, int codigo) {
        for (Articulo articulo : articulos) {
            if (articulo.getCodigo() == codigo) {
                return articulo;
            }
        }
        return null;
    }

    // Método auxiliar para validar texto no vacío.
    public static String validarTextoNoVacio(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine();

            if (!texto.trim().isEmpty()) {
                return texto.trim();
            }

            System.out.println("Error: el texto no puede estar vacío.");
        }
    }

    // Método auxiliar para validar un número decimal no negativo.
    public static double validarDoubleNoNegativo(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                double valor = Double.parseDouble(scanner.nextLine());

                if (valor < 0) {
                    System.out.println("Error: el precio no puede ser negativo.");
                    continue;
                }

                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número decimal válido.");
            }
        }
    }

    // Método para buscar categoría existente al ingresar un artículo.
    public static Categoria pedirCategoriaExistente(Scanner scanner, ArrayList<Categoria> categorias) {
        while (true) {
            int codigoCategoria = validarEntero(scanner, "Código de la categoría: ");
            Categoria categoria = buscarCategoriaPorCodigo(categorias, codigoCategoria);

            if (categoria != null) {
                return categoria;
            }

            System.out.println("Error: la categoría no existe.");
        }
    }

    // Método para buscar categoría por código.
    public static Categoria buscarCategoriaPorCodigo(ArrayList<Categoria> categorias, int codigo) {
        for (Categoria categoria : categorias) {
            if (categoria.getCodigo() == codigo) {
                return categoria;
            }
        }
        return null;
    }

    // Método para consultar un artículo por código.
    public static void consultarArticulo(Scanner scanner, ArrayList<Articulo> articulos) {
        System.out.println("\n============================================================");
        System.out.println("| CONSULTA POR ARTÍCULO                                     |");
        System.out.println("|-----------------------------------------------------------|\n");

        if (articulos.isEmpty()) {
            System.out.println("¡No hay artículos cargados!");
            return;
        }

        int codigo = validarEnteroNoNegativo(scanner, "Código del artículo a consultar: ");

        Articulo articulo = buscarArticuloPorCodigo(articulos, codigo);

        if (articulo == null) {
            System.out.println("¡No existe artículo con ese código!");
            return;
        }

        System.out.println("Se encontró el artículo:");
        System.out.println(articulo);
        System.out.println("Detalle específico: " + articulo.getDetalleEspecifico());
        System.out.println("Precio final calculado: " + articulo.calcularPrecioFinal());
    }


    // Método para modificar un artículo por código.
    public static void modificarArticulo(
            Scanner scanner,
            ArrayList<Articulo> articulos,
            ArrayList<Categoria> categorias
    ) {
        System.out.println("\n============================================================");
        System.out.println("| MODIFICAR ARTÍCULO                                        |");
        System.out.println("|-----------------------------------------------------------|\n");

        if (articulos.isEmpty()) {
            System.out.println("¡No hay artículos cargados!");
            return;
        }

        int codigo = validarEntero(scanner, "Código del artículo a modificar: ");

        Articulo articulo = buscarArticuloPorCodigo(articulos, codigo);

        if (articulo == null) {
            System.out.println("¡No existe artículo con ese código!");
            return;
        }

        String nuevoNombre = validarTextoNoVacio(scanner, "Nuevo nombre para el artículo: ");
        double nuevoPrecio = validarDoubleNoNegativo(scanner, "Nuevo precio para el artículo: ");

        listarCategorias(categorias);
        Categoria nuevaCategoria = pedirCategoriaExistente(scanner, categorias);

        articulo.setNombre(nuevoNombre);
        articulo.setPrecio(nuevoPrecio);
        articulo.setCategoria(nuevaCategoria);

        if (articulo instanceof ArticuloElectronico) {
            ArticuloElectronico electronico = (ArticuloElectronico) articulo;
            int nuevaGarantia = validarEnteroNoNegativo(scanner, "Nueva garantía en meses: ");
            electronico.setGarantiaMeses(nuevaGarantia);
        }

        if (articulo instanceof ArticuloAlimenticio) {
            ArticuloAlimenticio alimenticio = (ArticuloAlimenticio) articulo;
            int nuevosDias = validarEnteroNoNegativo(scanner, "Días para el vencimiento: ");
            alimenticio.setDiasParaVencer(nuevosDias);
        }

        System.out.println("¡Se modificó el artículo correctamente!");
        System.out.println("Precio final recalculado: " + articulo.calcularPrecioFinal());
    }

    // Método para eliminar un artículo por código.
    public static void eliminarArticulo(Scanner scanner, ArrayList<Articulo> articulos) {
                System.out.println("\n============================================================");
        System.out.println("| ELIMINAR ARTÍCULO                                        |");
        System.out.println("|-----------------------------------------------------------|\n");

        if (articulos.isEmpty()) {
            System.out.println("¡No hay artículos cargados!");
            return;
        }

        int codigo = validarEntero(scanner, "Código del artículo a eliminar: ");

        Articulo articulo = buscarArticuloPorCodigo(articulos, codigo);

        if (articulo == null) {
            System.out.println("¡No existe artículo con ese código!");
            return;
        }

        articulos.remove(articulo);
        System.out.println("Se eliminó el artículo correctamente.");
    }

}
