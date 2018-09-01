/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 *
 * @author Nieves
 */
public class Menu {
    ArrayList<Representante> reps = new ArrayList<Representante>();
    String casillaPat = "(\\d+),(\\d+),(\\d+),(\\d+),(B1|C1|C2|C3),(S|N)";
    String represPat = "([A-Z][a-z]* ([A-Z][a-z]*)?),([A-Z][a-z]*),([A-Z][a-z]*),(\\d+)";
    public void cargar_representantes() throws FileNotFoundException{ 
        Scanner sc = new Scanner((new File("archivos/representantes_preliminares.csv")));
        Representante act;
        while(sc.findInLine(represPat) != null){
            MatchResult res = sc.match();
            System.out.println(res.group(1));
            System.out.println(res.group(3));
            System.out.println(res.group(4));
            System.out.println(res.group(5));
            act = new Representante(res.group(1),res.group(3),
                                    res.group(4),Integer.parseInt(res.group(5)));
            reps.add(act);
            sc.nextLine();
        }
    }
    public boolean casilla_aprobada(int casilla) throws FileNotFoundException{
        Scanner sc = new Scanner((new File("archivos/casillas.csv")));
        boolean encont = false;
        while(!encont && sc.findInLine(casillaPat) != null){
            MatchResult res = sc.match();
            if(casilla == Integer.parseInt(res.group(1)) && res.group(6).equals("S")){ 
                encont = true;
            }
        }
        return encont;
    }
    //escribe la lista de representantes modificada 
    //en el archivo
    private void escribirListaRepresentantes(){ 
    }
    public void capturar(){ 
        
    }
    public void modificar(){ 
        
    }
    public void eliminar(){
        
    }
    public void buscar(){ 
        
    }
}
