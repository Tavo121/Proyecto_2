package com.example.CSV;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Instituto Tecnologico de Costa Rica
 * Area de Ingeniera en Computadores
 *
 * Lenguaje: Java
 * Clase: ExpressionList
 * @version 1.0
 * @author Gustavo Alvarado y Byron Mata
 *
 * Descripción: Esta clase contiene los metodos necesarios para realizar el guardado de expresion, fecha y resultado
 * en un archivo tipo csv.
 */
public class ExpressionList {
    private String date;
    private String expression;
    private String result;

    /**
     * Constructor que se encarga de obtener los datos que se guardanran en el archivo csv.
     * @param date fecha en la que se solicito la expresion.
     * @param expression expresion que se solicito evaluar.
     * @param result resultado de la expresion evaluada.
     */
    public ExpressionList(String date, String expression, String result) {
        this.date = date;
        this.expression = expression;
        this.result = result;

    }

    /**
     * Metodo que obtiene la fecha de solicitud de la expresion.
     * @return retorna la fecha de solicitud de la expresion.
     */
    public String getDate() {
        return date;
    }

    /**
     * Metodo que obtiene la expresion que se solicito evaluar.
     * @return expresion que se solicito evaluar.
     */
    public String getExpression() {
        return expression;
    }

    /**
     * Metodo que obtiene el resultado de la expresion evaluada.
     * @return resultado de la expresion evaluada.
     */
    public String getResult() {
        return result;
    }

    /**
     * Metodo que realiza el guardado de la expresion, fecha y resultado en el archivo csv.
     * @param list objeto que contiene la expresion, fecha y resultado.
     */
    public static void Save(ExpressionList list){
        String Arch = "Expressions.csv";

/*        boolean exist = new File(Arch).exists();

        if (exist){
            File newArch = new File(Arch);
            newArch.delete();
        }*/

        try {
            CsvWriter ArchCSV = new CsvWriter(new FileWriter(Arch, true), ','); //escritor de informacion en el archivo

/*            ArchCSV.write("Expression");
            ArchCSV.write("Date");
            ArchCSV.write("Result");

            ArchCSV.endRecord();*/

            //escirtura de la expresion, fecha y resultado en el archivo.
            ArchCSV.write(list.getExpression());
            ArchCSV.write(list.getDate());
            ArchCSV.write(list.getResult());

            ArchCSV.endRecord();

            ArchCSV.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * Metodo que realiza la lectura de datos contenidos en el csv.
     */
    public static void Read(){
        try{
            List<ExpressionList> list = new ArrayList<ExpressionList>();

            CsvReader reader = new CsvReader("Expressions.csv"); //lector del archivo csv.
            reader.readHeaders(); //obtiene los encabezados de columnas.

            //obtiene expresion, fecha y resultado de cada columna y lo guarda en un objeto ExpressionList.
            while(reader.readRecord()){
                String Expression = reader.get(0);
                String Date = reader.get(1);
                String Result = reader.get(2);

                list.add(new ExpressionList(Expression, Date, Result));
            }
            reader.close();

            //imprime en consola la expresion, fecha y resultado.
            for (ExpressionList expressions: list){
                System.out.println(expressions.getExpression() + ", "
                + expressions.getDate() + ", "
                + expressions.getResult());
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExpressionList expre = new ExpressionList("28/10/2021", "(5*7)+(12/6)", "37");
        Save(expre);
        //Read();
    }

}
