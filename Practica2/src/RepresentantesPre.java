import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;

/*
Clase modela lista lista de objtos de RepresentantesPre y tiene todo los metodos para manipularla
asi como para guardar los cambios en el archivo
*/
public class RepresentantesPre{

    ArrayList<RepresentantePre> reps = new ArrayList<RepresentantePre>();
    int index = 1;
    
    /*
    Al iniciar le objecto RepresentantesPre cargamos toda la informacion del archivo a la lista reps
    */
    public RepresentantesPre(){
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader("archivos/representantes_preliminares.csv");
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] arrOfStr = sCurrentLine.split(",");
                RepresentantePre nuevo = new RepresentantePre(arrOfStr[0],arrOfStr[1],arrOfStr[2],arrOfStr[3],arrOfStr[4],arrOfStr[5],arrOfStr[6]);
                reps.add(nuevo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();

            } catch (IOException ex) {
                ex.printStackTrace();

            }

        }
        initIndex();
    }

    /*
    Metodo para inicilizar el index lo inicilaiza en el mayor que este dentro de la lista
    */
    private void initIndex(){
        for (RepresentantePre rep : reps){
            try{
                int indexrep = Integer.parseInt(rep.identificador);
                if (indexrep > index){
                    index = indexrep;
                }
            }catch(Exception e){
                 //Solo para cachar la expceion del encabezado indetificador que no es un numero
            }
        }
    }

    /*
    Metodo de apoyo para convertir a String
    */
    public String toString(){
        String cadena = "";
        for (RepresentantePre rep : reps){
            cadena += rep+"\n";
        }
        return cadena;
    }

    /*
    Agrega un nuevo representante a la lista asignado como indice el +1 del ultimo indice
    */
    public void agregaRepresentante(String name, String apellidoPaterno, String apellidoMaterno, String calidadRepresentante, String casilla, String seccion){
        index = index +1;
        int nuevoIndex = index;
        RepresentantePre nuevo = new RepresentantePre(Integer.toString(nuevoIndex),name,apellidoPaterno,apellidoMaterno,calidadRepresentante,casilla,seccion);
        reps.add(nuevo);
    }

    /*
    Busca si existe un representante con el identificador dado en la lista de ser asi lo borra y regresa True si no existe regresa False
    */
    public boolean borrarRepresentante(String identificador){
        boolean remove = false;
        RepresentantePre aremover = null;
        for (RepresentantePre rep : reps){
            if(rep.identificador.equals(identificador)){
                aremover = rep;
                remove = true;
            }
        }
        if (remove){
            reps.remove(aremover);
        }
        return remove;
    }

    /*
    Busca si existe un representante con el identificador dado en la lista de ser asi lo regresa si no regresa null
    */
    public RepresentantePre buscarRepresentante(String identificador){
        for (RepresentantePre rep : reps){
            if(rep.identificador.equals(identificador)){
                return rep;
            }
        }
        return null;
    }

    /*
    Busca si existe un representante con el identificador dado en la lista de ser asi modifica sus datos con los de
    representante nuevo todos menos el identificador y regresa true si no lo encuentra regresa false
    */
    public boolean modificarRepresentante(String identificador, RepresentantePre nuevo){
        boolean modif = false;
        RepresentantePre aremover = null;
        for (RepresentantePre rep : reps){
            if(rep.identificador.equals(identificador)){
                rep.nombre = nuevo.nombre;
                rep.apellidoPaterno = nuevo.apellidoPaterno;
                rep.apellidoMaterno = nuevo.apellidoMaterno;
                rep.calidadRepresentante = nuevo.calidadRepresentante;
                rep.casilla = nuevo.casilla;
                rep.seccion = nuevo.seccion;
                modif = true;
            }
        }
        return modif;
    }

    /*
    Escribe en el archivo la lista actual
    */
    public void guarda(){
        try {
            File file = new File("archivos/representantes_preliminares.csv");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            for (RepresentantePre rep : reps){
                writer.write(rep.toCSV()+"\n");
            }
            writer.flush();
            writer.close();  
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }

   /*
    Main de esta clase se uso para probarla
    */
    public static void main(String[] args) {
        RepresentantesPre reps = new RepresentantesPre();
        System.out.println(reps);
        reps.agregaRepresentante("Hugo", "Perez", "Sanches", "calidad", "12", "22");
        System.out.println(reps);
        RepresentantePre encontrado = reps.buscarRepresentante("3");
        System.out.println(encontrado);
        RepresentantePre modif = new RepresentantePre("0","modif","modif","modif","modif","modif","modif");
        reps.modificarRepresentante("3", modif);
        System.out.println(reps);
        //reps.guarda();
    }

}
