package Model;

import exceptions.FechaInvalidaException;


public class Fecha {
    Integer dia;
    Integer mes;
    Integer anio;
    
    public Fecha(){
        this.dia = 1;
        this.mes = 1;
        this.anio = 2018;
    }
    
    
    public Fecha(Integer dia, Integer mes, Integer anio) throws FechaInvalidaException{
    //    Exception FechaInvalidadException;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;

    }
    
    public String fechaToString(){
        return dia+"/"+mes+"/"+anio;
    } 
    public void setDia(Integer dia){
        this.dia = dia;
    }
    public Integer getDia(){
        return dia;
    }
    public void setMes(Integer mes){
        this.mes = mes;
    }
    public Integer getMes(){
        return mes;
    }
    public void setAnio(Integer anio){
        this.anio = anio;
    }
    public Integer getAnio(){
        return anio;
    }
    
    public void aumentarDia() throws FechaInvalidaException{
        dia = dia+1;
        if(dia>diasMes()){
            dia = 1;
            //aumenta un mes
            mes = mes+1;
            if(mes>12){
                mes = 1; //aumenta el anio
                anio = anio+1;
            }           
        }
    }
    
    private Integer diasMes() throws FechaInvalidaException{
        switch(mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if(anio%4 == 0)
                    return 29;
                else
                    return 28;
            default:
                System.out.println("error");
        }
        return null;
    }
    public Integer compararFecha(Fecha fecha2){
        if( anio == fecha2.getAnio() && mes == fecha2.getMes() && dia ==fecha2.getDia()) 
            return 1;
        else if(anio > fecha2.getAnio()) //el primero mayor
            return 2;
        else if(mes > fecha2.getMes())
            return 2;
        else if(dia > fecha2.getDia())
            return 2;
        else return 3;
    }
}
