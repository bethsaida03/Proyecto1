package DONANTE;

import INTERFACES.TIPDONA;
import java.util.*;

/**
 *
 * @author mac
 */
public abstract class Donacion implements TIPDONA {
    Scanner sc = new Scanner(System.in);
    private String TIPDON;
    private String codigo;
    private String motivo;
    public Donante persona;
    
    public Donacion(String codigo, String motivo,String tipdon, Donante persona) {
        this.codigo = codigo;
        this.motivo = motivo;
        this.TIPDON= tipdon;
        this.persona = persona;
    }

    public Donacion() {
        this.codigo = "";
        this.motivo = "";
        this.TIPDON="";
        this.persona = null;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Donante getPersona() {
        return persona;
    }

    public void setPersona(Donante persona) {
        this.persona = persona;
    }
    
    public String getTIPDON() {
        return TIPDON;
    }

    public void setTIPDON(String TIPDON) {
        this.TIPDON = TIPDON;
    }    
    
    public double Val_num(String Enunciado){
        String s1= "";
        while(s1.equals("")){
            System.out.print(Enunciado);
            s1 = sc.nextLine();
            if (!s1.matches("[0-9,.]*$")){
                s1="";
                System.out.println("SOLO PUEDE INGRESAR NUMEROS");
            }
        }
        return Double.parseDouble(s1);
    }
    
    public int Val_num2(String Enunciado){
        String s1= "";
        while(s1.equals("")){
            System.out.print(Enunciado);
            s1 = sc.nextLine();
            if (!s1.matches("[0-9]*$")){
                s1="";
                System.out.println("SOLO PUEDE INGRESAR NUMEROS");
            }
        }
        return Integer.parseInt(s1);
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
        System.out.print("INGRESE EL CODIGO             : " );
        this.setCodigo(this.codigo=sc.nextLine());
       
        System.out.print("INGRESE EL MOTIVO             : " );
        this.setMotivo(this.motivo=sc.nextLine());
    }
    
    @Override
    public String  toString(){
        String s;
        s =    "\nCODIGO                        : "+this.getCodigo();
        s = s+ this.getPersona();
        s = s+ "\nMOTIVO                        : " + this.getMotivo();
        return  s;
    }
    
    public void Val_excepcion(){
        try{
            this.Elegir_opcion();
        }catch(InputMismatchException e){
            //JOptionPane.showMessageDialog(null,"NO PUEDE INGRESAR NUMEROS","SOTFWARE", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("SOLO PUEDE INGRESAR NUMEROS");
        }
    }
}
