/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Alumno {
    private Alumno next;
    private Integer noControl;
    private String nombre;
    private String paterno;
    private String materno;
    private Fecha fechaNac;
    private String carrera;
    private Double promedio;
    private ListaMaterias materias;
    
    public Alumno(Integer noControl, String nombre, String paterno, String materno, Fecha fechaNac, String carrera, Double promedio){
        this.noControl= noControl;
        this.nombre= nombre;
        this.paterno= paterno;
        this.materno= materno;
        this.fechaNac= fechaNac;
        this.carrera= carrera;
        this.promedio= promedio;
    }

    public Integer getNoControl() {
        return noControl;
    }

    public void setNoControl(Integer noControl) {
        this.noControl = noControl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public Fecha getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public Alumno getNext() {
        return next;
    }

    public void setNext(Alumno next) {
        this.next = next;
    }

    public ListaMaterias getMaterias() {
        return materias;
    }

    public void setMaterias(ListaMaterias materias) {
        this.materias = materias;
    }
    
    
}
