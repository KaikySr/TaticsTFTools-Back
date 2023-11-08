package com.kaiky.taticstftools.a_exerciciosBase;

import java.util.ArrayList;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

public class a_ExerciciosBase {   
    @Getter @Setter
    private String name;

    public void Exercicio1(){
     
        float media = (10 + 7.5f + 4 + 2) / 4;

        System.out.println("Media: " + media);

        if (media >= 9){
            System.out.println("Parabens!");
        }
        else if (media >= 7) {
            System.out.println("Aprovado!");
        }
        else if (media <= 3){
            System.out.println("Reprovado!");
        }
        else{
            System.out.println("Recuperação!");
        }
    }

    public void Exercicio2and3(){
        Scanner ler = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Insira o tamanho do array: ");
        int tam = ler.nextInt();

        int i = 0;
        while (true) {
            System.out.println("Insira " + (tam - i) + " valores para realizar uma soma.");
            int num = ler.nextInt();

            numbers.add(num);

            i++;

            if(i == tam)
                break;
        }

        ler.close();

        int sum = 0;
        for(int num : numbers)
            sum += num;

        float media = sum / tam;

        System.out.println("A soma dos valores inseridos é: " + sum);
        System.out.println("A media dos valores inseridos é: " + media);
    }
}
