/*
Clase usada para represnetar a una RepresentantePre
*/
public class RepresentantePre{
    String identificador;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String calidadRepresentante;
    String casilla;
    String seccion;

    public RepresentantePre(String id, String n, String aP, String aM, String cR, String c, String s){
        identificador = id;
        nombre = n;
        apellidoPaterno = aP;
        apellidoMaterno = aM;
        calidadRepresentante = cR;
        casilla = c;
        seccion = s;
    }


    /*
     Metodo auxiliar para to String
    */
    public String toString(){
        return identificador+"|"+nombre+"|"+apellidoPaterno+"|"+apellidoMaterno+"|"+calidadRepresentante+"|"+casilla+"|"+seccion;
    }

    /*
     Metodo auxiliar para escrbir los archivos CSV
    */
    public String toCSV(){
        return identificador+","+nombre+","+apellidoPaterno+","+apellidoMaterno+","+calidadRepresentante+","+casilla+","+seccion;
    }

}
