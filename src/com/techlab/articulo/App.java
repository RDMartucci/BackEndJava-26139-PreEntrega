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
        //    - Repositorio<Articulo>
        //    - Repositorio<Categoria>
        // 3) Crear los dos menús:
        //    - MenuArticulos
        //    - MenuCategorias
        // 4) Crear un menú principal que permita elegir:
        //    - 1: ir al menú de artículos
        //    - 2: ir al menú de categorías
        //    - 0: salir
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

        //variable de control del menú principal.
        int opcion;
         do {
            System.out.println("\n===================================================");
            System.out.println("| BroncoMuebles - CRUD DE ARTÍCULOS con CATEGORÍAS |");
            System.out.println("|==================================================|");
            System.out.println("| 1 - Ingresar artículo                            |");
            System.out.println("| 2 - Listar artículos                             |");
            System.out.println("| 3 - Consulta por artículo                        |");
            System.out.println("| 4 - Modificar artículo                           |");
            System.out.println("| 5 - Eliminar artículo                            |");
            System.out.println("| 6 - Listar categorías precargadas                |");
            System.out.println("| 0 - Salir                                        |");
            System.out.println("====================================================");

            
//            System.out.println("\nIngrese una opción: ");
//            opcion = scanner.nextInt();

            opcion = validarEntero(scanner, "Ingrese una opción: ");

            switch (opcion) {
                case 1:
//                    ingresarArticulo(scanner, articulos, categorias);
                    System.out.println("\nFuncionalidad de ingreso de artículo aún no implementada.");
                    break;
                case 2:
//                    System.out.println("\nFuncionalidad de listado de artículos aún no implementada.");
                    listarArticulos(articulos);
                    break;
                case 3:
//                    consultarArticulo(scanner, articulos);
                    System.out.println("\nFuncionalidad de consulta de artículo aún no implementada.");
                    break;
                case 4:
//                    modificarArticulo(scanner, articulos, categorias);
                    System.out.println("\nFuncionalidad de modificación de artículo aún no implementada.");
                    break;
                case 5:
//                    eliminarArticulo(scanner, articulos);
                    System.out.println("\nFuncionalidad de eliminación de artículo aún no implementada.");
                    break;
                case 6:
                    listarCategorias(categorias);
                    System.out.println("\nFuncionalidad de listado de categorías aún no implementada.");
                    break;
                case 0:
                    System.out.println("\nSaliendo del sistema.");
                    break;
                default:
                    System.out.println("\nError: la opción ingresada no es válida.");
            }

        } while (opcion != 0);


        scanner.close();

    }


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
                System.out.println("Error: debe ingresar un número entero válido.");
            }
        }
    }

    
    // Metodo para listar los artículos cargados.
    public static void listarArticulos(ArrayList<Articulo> articulos) {
        if (articulos.isEmpty()) {
            System.out.println("No hay artículos para mostrar.");
            return;
        }

        System.out.println("\n=========================================");
        System.out.println("|        LISTADO DE ARTÍCULOS            |");
        System.out.println("|----------------------------------------|");

        for (Articulo articulo : articulos) {
            System.out.println(articulo);
        }
    }

    public static void listarCategorias(ArrayList<Categoria> categorias) {
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías para mostrar.");
            return;
        }

        System.out.println("\n=========================================");
        System.out.println("|        LISTADO DE CATEGORÍAS           |");
        System.out.println("|----------------------------------------|");

        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }


    }   
}
