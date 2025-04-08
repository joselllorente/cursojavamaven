package es.cursojava.hibernate;

import es.cursojava.hibernate.front.CarreraCaballosFront;

public class CarreraCaballosMain {
    public static void main(String[] args) {
        CarreraCaballosFront front = new CarreraCaballosFront("Carrera 1");
        front.iniciaMenuCarrera();
    }
}
