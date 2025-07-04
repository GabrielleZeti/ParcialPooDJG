/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcialfinal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author Danie
 */

public class ClienteCuadrado {
    public static void main(String[] args) {
        final String SERVIDOR = "localhost";
        final int PUERTO = 5000;
        
        try (Socket socket = new Socket(SERVIDOR, PUERTO);
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("Conectado al servidor en " + SERVIDOR + ":" + PUERTO);
            
            System.out.print("Ingrese su nombre: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Ingrese un numero entero: ");
            int numero = scanner.nextInt();
            
            salida.println(nombre);
            salida.println(numero);
            
            System.out.println("\nRespuesta del servidor:");
            String linea;
            while ((linea = entrada.readLine()) != null) {
                System.out.println(linea);
            }
            
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}