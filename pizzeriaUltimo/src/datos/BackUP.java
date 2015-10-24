package datos;

import java.io.*;

public class BackUP {

    String rutaMySqlDump = "C:\\Program Files\\MySQL\\MySQL Server 5.6\\bin\\mysqldump.exe";
    String rutaMySql = "C:\\Program Files\\MySQL\\MySQL Server 5.6\\bin\\mysql.exe";
    String contrasenia ="1234";
    String usuario = "root";
    String dataBase = "pizzeria";

    public void generarBackUp(String rutaFile){
        try{
        	String cad = "\"" + rutaMySqlDump + "\" --opt --password=" + contrasenia + " --user=" + usuario + " " + dataBase + " > \"" + rutaFile +"\"\n";

            File fcopi = new File("copia_seguridad.bat");
            FileWriter fw = new FileWriter(fcopi);
            fw.write(cad, 0, cad.length());
            fw.close();
            Runtime.getRuntime().exec("copia_Seguridad.bat");
         }catch(Exception ex){
             ex.printStackTrace();
         }
    }
    public void restaurarBackUp(String rutaFile){
       
    	try{
    		String cad = "\"" + rutaMySql + "\" --password=" + contrasenia + " --user=" + usuario + " " + dataBase + " < \"" + rutaFile +"\"\n";

            File fcopi = new File("copia_seguridad.bat");
            FileWriter fw = new FileWriter(fcopi);
            fw.write(cad, 0, cad.length());
            fw.close();
            Runtime.getRuntime().exec("copia_Seguridad.bat");
         }catch(Exception ex){
             ex.printStackTrace();
         }
    }
}

 