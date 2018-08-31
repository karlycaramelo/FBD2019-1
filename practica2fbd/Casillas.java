import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
Clase que devuelve un objeto con la lista de las casillas en donde podemos ver si una casilla esta aprobada o ono
*/
public class Casillas{

    private String[][] casillas;
    
    public Casillas(){
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader("casillas.csv");
            br = new BufferedReader(fr);
            String sCurrentLinee;
            int numberLines = 0;
            while ((sCurrentLinee = br.readLine()) != null) {
                numberLines += 1;
            }
            br.close();
            fr.close();
            System.out.println(numberLines);

            casillas = new String[numberLines][6];
            fr = new FileReader("casillas.csv");
            br = new BufferedReader(fr);
            String sCurrentLine;
            int indexarray = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] arrOfStr = sCurrentLine.split(",");
                casillas[indexarray] = arrOfStr;
                indexarray += 1;
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
    }

    public boolean casillasEstaAprobada(int index){
        return casillas[index][5].equals("S");
    }

    public String toString(){
            String devolver = "";
            for (int i = 0; i < casillas.length;i++){
                for (int j = 0; j < casillas[i].length;j++){
                    devolver += casillas[i][j]+"|";
                }
                devolver +="\n";
            }
            return devolver;
    }
    
    public static void main(String[] args) {
        Casillas casi = new Casillas();
        System.out.println(casi);
        System.out.println(casi.casillasEstaAprobada(3));
        System.out.println(casi.casillasEstaAprobada(4));
        System.out.println(casi.casillasEstaAprobada(20));
    }
}
