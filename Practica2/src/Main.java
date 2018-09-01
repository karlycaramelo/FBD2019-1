import java.util.Scanner;

/*
Clase main para la practica que muestra los menus y hace las validaciones pertinentes haciendo uso de las clases Casillas.java y 
RepresentantesPre.java
*/
public class Main{


    Casillas casi = new Casillas();
    RepresentantesPre reps = new RepresentantesPre();
   
    /*
    Al iniciar la clase simplemente cargamos las casillas y representantesPre a memoria
    */
    public Main(){
       casi = new Casillas();
       reps = new RepresentantesPre();
    }

    /*
    Mensaje de inicio
    */
    public void inicio(){
        System.out.println("Se carga los archivos de representantes y casillas:");
        System.out.println("Se tienen las casillas:");
        System.out.println(casi);
        System.out.println("Y los representantes:");
        System.out.println(reps);
        System.out.println("Los representantes y casillas deben ser espcificados por el identificador correspondiente.");
    }

    /*
    Opciones de comandos ejecutar
    */
    public void queHacer(){
        System.out.println("Que deseas hacer (Debe escribir un Entero)?");
        System.out.println("1 - Capturar nuevo representante");
        System.out.println("2 - Modificar representante");
        System.out.println("3 - Eliminar representante");
        System.out.println("4 - Salvar lista de representantes");
        System.out.println("5 - Salir");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        switch(n){
            case 1:
                 capturarNuevo();
                 break;
            case 2:
                 modificarRepresentante();
                 break;
            case 3:
                 eliminaRepresentante();
                 break;
            case 4:
                 reps.guarda();
                 System.out.println("Lista Guardada");
                 queHacer();
                 break;
            case 5:
                 System.out.println("Saliendo...");
                 break;
            default:
                 System.out.println("Opcion invalida");
                 queHacer();

        }

    }

    /*
    Metodo que va guiandonos atraves de eliminacion de un representante
    */
    public void eliminaRepresentante(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Vamos a eliminar un representante");
        boolean eliminado = false;
        int repindice = 0;
        while(!eliminado){
            System.out.println("Ingresa un indice de representante (Un entero que debe corresponder al id de un representante existente)");
            System.out.println(reps);
            repindice = sc.nextInt();
            sc.nextLine();
            eliminado = reps.borrarRepresentante(Integer.toString(repindice));
            if (!eliminado){
                System.out.println("Ingresa un indice de representante valido");
            }
        }
        System.out.println("Representante eliminado exitosamente");
        System.out.println(reps);
        queHacer();
    }

    /*
    Metodo que va guiandonos atraves de modficacion de un representante
    */
    public void modificarRepresentante(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Vamos a modificar un representante");
        RepresentantePre amodificar = null;
        int repindice = 0;
        while(amodificar==null){
            System.out.println("Ingresa un indice de representante (Un entero que debe corresponder al id de un representante existente)");
            System.out.println(reps);
            repindice = sc.nextInt();
            sc.nextLine();
            amodificar = reps.buscarRepresentante(Integer.toString(repindice));
            if (amodificar==null){
                System.out.println("Ingresa un indice de representante valido");
            }
        }
        System.out.println("Vamos a modificar al representante:"+amodificar);
        System.out.println("Ingresa el nuevo nombre (Una cadena)");
        String nombre = sc.nextLine();
        System.out.println("Ingresa el nuevo apellido paterno (Una cadena)");
        String aP = sc.nextLine();
        System.out.println("Ingresa el nuevo apellido materno (Una cadena)");
        String aM = sc.nextLine();
        System.out.println("Ingresa nuevo calidad representante (Una cadena)");
        String cR = sc.nextLine();

        int casilla = 0;
        boolean casilla_incorrecta = true;
        while(casilla_incorrecta){
            System.out.println("Ingresa el nuevo indice de casilla (Un entero que debe corresponder al id de una casilla existente)");
            System.out.println(casi);
            casilla = sc.nextInt();
            sc.nextLine();
            if (!casi.casillaExiste(casilla)){
                System.out.println("El ID de la casilla no existe");
                continue;
            }
            if (!casi.casillasEstaAprobada(casilla)){
                System.out.println("La casilla no esta aprobada");
                continue;
            }
            casilla_incorrecta = false;
        }

        System.out.println("Ingresa una nueva seccion (Una cadena)");
        String seccion = sc.nextLine();
        RepresentantePre modif = new RepresentantePre("0",nombre,aP,aM,cR,Integer.toString(casilla),seccion);
        reps.modificarRepresentante(Integer.toString(repindice),modif);
        System.out.println("Representante modificado exitosamente");
        System.out.println(reps);
        queHacer();
    }

    /*
    Metodo que va guiandonos atraves de la captura de un representante
    */
    public void capturarNuevo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Vamos a capturar un nuevo representante");
        System.out.println("Ingresa el nombre (Una cadena)");
        String nombre = sc.nextLine();
        System.out.println("Ingresa el apellido paterno (Una cadena)");
        String aP = sc.nextLine();
        System.out.println("Ingresa el apellido materno (Una cadena)");
        String aM = sc.nextLine();
        System.out.println("Ingresa calidad representante (Una cadena)");
        String cR = sc.nextLine();

        int casilla = 0;
        boolean casilla_incorrecta = true;
        while(casilla_incorrecta){
            System.out.println("Ingresa unn casilla (Un entero que debe corresponder al id de una casilla existente)");
            System.out.println(casi);
            casilla = sc.nextInt();
            sc.nextLine();
            if (!casi.casillaExiste(casilla)){
                System.out.println("El ID de la casilla no existe");
                continue;
            }
            if (!casi.casillasEstaAprobada(casilla)){
                System.out.println("La casilla no esta aprobada");
                continue;
            }
            casilla_incorrecta = false;
        }

        System.out.println("Ingresa una seccion (Una cadena)");
        String seccion = sc.nextLine();
        reps.agregaRepresentante(nombre, aP, aM, cR, Integer.toString(casilla), seccion);
        System.out.println("Representante agregado exitosamente");
        System.out.println(reps);
        queHacer();
    }

    /*
    Main que inicializa con el mensaje de incio y el menu  queHacer
    */
    public static void main(String[] args) {
        Main main = new Main();
        main.inicio();
        main.queHacer();


    }

}
