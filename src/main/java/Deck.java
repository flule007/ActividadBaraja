/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author flule
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
 
     private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] palos = {"Tréboles", "Corazones", "Picas", "Diamantes"};
        String[] colores = {"Negro", "Rojo"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String palo : palos) {
            String color = (palo.equals("Tréboles") || palo.equals("Picas")) ? colores[0] : colores[1];
            for (String valor : valores) {
                cards.add(new Card(palo, color, valor));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (!cards.isEmpty()) {
            Card carta = cards.remove(0);
            System.out.println(carta);
            System.out.println("Quedan " + cards.size() + " cartas en deck");
        } else {
            System.out.println("No hay más cartas en el deck.");
        }
    }

    public void pick() {
        if (!cards.isEmpty()) {
            Random rand = new Random();
            int index = rand.nextInt(cards.size());
            Card carta = cards.remove(index);
            System.out.println(carta);
            System.out.println("Quedan " + cards.size() + " cartas en deck");
        } else {
            System.out.println("No hay más cartas en el deck.");
        }
    }

    public void hand() {
        if (cards.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Card carta = cards.remove(0);
                System.out.println(carta);
            }
            System.out.println("Quedan " + cards.size() + " cartas en deck");
        } else {
            System.out.println("No hay suficientes cartas para repartir una mano.");
        }
    }

}
