package DONANTE;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author mac
 */
public class Donante {
    Scanner sc = new Scanner(System.in);
    private String nombre;
    private String apellido;
    private String cedula;
    
    public Donante(String nombre, String apellido, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }
    
    public Donante() {
    this.cedula="";
    this.nombre="";
    this.apellido="";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }    
    
/*
    @Override
    public boolean equals(Object obj){
        boolean res;
        if (obj instanceof Donante){
            Donante Dona = (Donante)obj;
            if(this.cedula==Dona.cedula){
                return true;}
            else{
                return false;}
        }
        else{
            return false;}
    }
*/
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.cedula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;}
        if (getClass() != obj.getClass()) {
            return false;}
        final Donante other = (Donante) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }

    public String Val_num(String Enunciado){
        String s1= "";
        while(s1.equals("")){
            System.out.print(Enunciado);
            s1 = sc.nextLine();
            if (!s1.matches("[0-9]{10}")){
                s1="";
                System.out.println("SOLO PUEDE INGRESAR NUMEROS Y DEBE SER DE 10 NUMEROS");
            }
        }
        //return Integer.parseInt(s1);
        return s1;
    }
    
    
    public String Val_texto(String Enunciado){
        String s1= "";
        while(s1.equals("")){
            System.out.print(Enunciado);
            s1 = sc.nextLine();
            if (!s1.matches("^[A-Za-z ]*$")){
                s1="";
                System.out.println("NO PUEDE INGRESAR NUMEROS");
            }
        }
        return s1;
    }
    
    public void IngresarD(){
        System.out.println("**   DONANTE   **");
        //System.out.print("INGRESE LA CEDULA          : " );  
        //this.setCedula(this.cedula=sc.nextLine());
        this.setCedula(this.Val_num("INGRESE LA CEDULA          : "));
        this.setNombre(this.Val_texto("INGRESE EL NOMBRE          : "));
        this.setApellido(this.Val_texto("INGRESE EL APELLIDO        : "));     
    }
     
    @Override
    public String  toString(){
        String s;
        s =    "\nCEDULA                        : " + this.getCedula();
        s = s+ "\nNOMBRE                        : "+this.getNombre();
        s = s+ "\nAPELLIDO                      : "+this.getApellido();
        return  s;
    }
}
