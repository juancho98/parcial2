/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligono;

/**
 *
 * @author jdani
 */
public class Linea {
    private Punto a;
    private  Punto b;
    
    public Punto getA() {
        return a;
    }

    public void setA(Punto a) {
        this.a = a;
    }

    public Punto getB() {
        return b;
    }

    public void setB(Punto b) {
        this.b = b;
    }

    public Linea(Punto a, Punto b) {
        this.a = a;
        this.b = b;
    }
    
    public Linea(Integer x1, Integer y1, Integer x2, Integer y2){
        a = new Punto(x1, y1);
        b = new Punto (x2, y2);
    }
   
    public String toString(){
        return String.format("(%s , %s)", a.toString(), b.toString());
    }
    
    private Orientacion orientacion(Punto p){
        //considerando el origen al punto a, el segmento ab y el segmento ap, la formula seria
        //det|xb-xa  xp-ya|
        //   |yb-ya  yp-ya|
        
        Integer resultado =((b.getX()-a.getX())*(p.getY()-a.getY()))-((b.getY()-a.getY())*(p.getX()-a.getY()));
        if(resultado == 0){
            return Orientacion.COLINEAL;
        }else if (resultado > 0){
            return Orientacion.CLOCKWISE;
        }else{
            return Orientacion.COUNTERCLOCKWISE;
        }
        
    }
    public boolean Interseccion(Linea l){
        //p1(x,y)-p2(x,y)    p3(x,y)-p4(x,y)  1. (p3,p4,p1) 2.(p3,p4,p2) 3.(p1, p2, p3) 4. (p1, p2, p4)
        int d1 = direction(l.getA(), l.getB(), this.getA());
        int d2 = direction(l.getA(), l.getB(), this.getB());
        int d3 = direction(this.getA(), this.getB(), l.getA());
        int d4 = direction(this.getA(), this.getB(), l.getB());
        if((d1>0 && d2<0)||(d1<0 && d2>0) && (d3>0 && d4<0) || (d3<0 && d4>0)){
            return true;
        }else if ((d1==0)&&(segment(l.getA(), l.getB(), this.getA()))) {
            return true;
        }else if ((d2==0)&&(segment(l.getA(), l.getB(), this.getB()))) {
            return true;
        }else if ((d3==0)&&(segment(this.getA(), this.getB(), l.getA()))) {
            return true;
        }else if ((d4==0)&&(segment(this.getA(), this.getB(), l.getB()))) {
            return true;
        }else{
            return false;
        }
        
    }
    public int direction(Punto p0, Punto p2, Punto p1){
        //(p1-p0) x (p2-p0) = (x1-x0)(y2-y0)-(x2-x0)(y1-y0)
        //(pk-pi)x(pj-pi)
        return (((p1.getX()-p0.getX())*(p2.getY()-p0.getY()))-((p2.getX()-p0.getX())*(p1.getY()-p0.getY())));
    }
    public boolean segment(Punto pi, Punto pj, Punto pk){
        int a = min(pi.getX(), pj.getX());
        int b = max(pi.getX(), pj.getX());
        int c = min(pi.getY(), pj.getY());
        int d = max(pi.getY(), pj.getY());
        if(((a <= pk.getX()) && (pk.getX()<= b ))&& ((c <= pk.getY())&& (pk.getY()<= d))){
            return true;
        }else{
            return false;
        }
        //1<2<3 if(1<2)&&(2<3)
    }
    public int min(Integer a, Integer b){
        if(a<=b){
            return a;
        }else{
            return b;
        }
    }
     public int max(Integer c, Integer d){
        if(c>=d){
            return c;
        }else{
            return d;
        }
    }
}
