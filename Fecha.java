/**
 * Esto es una prueba
 */    
/**
 * Write a description of class Fecha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fecha
{
    private int dia;
    private int mes;
    private int anho;

    /**
     * Constructor. 
     * Imprime, si es valida, la fecha creada.
     */
    public Fecha (int dia, int mes, int anho)
    {
    assert(fechaValida(dia,mes,anho)) : "La fecha es invalida.";   
    assert(esPostGregoriano(dia,mes,anho)) : "La fecha no es post-gregoriana (15/10/1582)";
    this.dia = dia;
    this.mes = mes;
    this.anho= anho;
    System.out.println("Fecha Ingresada: " + dia + "/" + mes + "/" + anho);
    }
    
    /**
     * Devuelve la maxima cantidad de dias de un mes en un anho en particular.
     * Comprende a anho. bisiestos.
     */
    private int cantidadDias(int mes, int anho){
        int cant;
        assert mes>0 && mes<13;
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            cant = 31;
        } else {
            if (mes == 4 || mes == 6 || mes ==  9 || mes == 11){
                cant = 30;
            }
            if(esBisiesto(anho)==true){
                cant= 29;
            }
            else{
                cant = 28;
            }
        }
        return cant;
    }
    
    /**
     *Analiza si la fecha ingresada tiene una cantidad de dias validos para el mes ingresado, que el mes sea valido, 
     *y que el anho sea gregoriano.
     */
    private boolean fechaValida(int dia, int mes, int anho)
    {
        if(dia<=cantidadDias(mes,anho) && dia >0 && mes >0 && mes <=12 && esPostGregoriano(dia,mes,anho)  )
        {
           return true; 
        }
        else
        {
          return false;  
        }
    }
    
    /**
     * Analiza si el anho ingresado es bisiesto
     */
    private boolean esBisiesto(int anho)
    {
        assert (anho>0); 
        if(anho % 400==0 || anho % 4 == 0){
            return true;    
        }
        if (anho % 4 == 0 && anho % 100 == 0){
            return false; 
        }
        else{
            return false;
        }
        
    }
    
    /**
     * Analiza si la fecha ingresada es igual o mayor a 15/10/1582
     */
    private boolean esPostGregoriano(int dia, int mes, int anho) 
    {
        if (anho<1582) {
            return false;
        }
        if (anho==1582 && mes<10) {
            return false;
        }
        if( anho==1582 && mes>=10 && dia<15){
            return false;
        }
        else {
            return true;
        }
    }
    
    public void cambiarDia(int dia)
    {
        assert(fechaValida(dia,mes,anho));
        this.dia = dia;
    }
    
    public int obtenerDia()
    {
        return dia;
    }
    
    public void cambiarMes(int mes)
    {
        assert(fechaValida(dia,mes,anho));
        this.mes = mes;
    }
    
    public int obtenerMes()
    {
        return mes;
    }
    
    public void cambiarAnho(int anho)
    {
        assert(fechaValida(dia,mes,anho));
        this.anho=anho;
    }
    
    public int obtenerAnho()
    {
        return anho;
    }
    
    /*
    public void cambiarFecha(int dia, int mes, int anho)
    {
        assert(fechaValida(dia,mes,anho));
        this.dia=dia;
        this.mes=mes;
        this.anho=anho;
    }*/
}




