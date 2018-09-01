/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.io.FileNotFoundException;

/**
 *
 * @author Nieves
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu m = new Menu();
        try{
            m.cargar_representantes();
            if(m.casilla_aprobada(2)){
                System.out.println("la casilla esta aprobada");
            }else{
                System.out.println("la casilla no esta aprobada");
            }
        }catch(FileNotFoundException exception){
            System.out.println("el archivo no se encontro :(");
        }
    }
    
}
