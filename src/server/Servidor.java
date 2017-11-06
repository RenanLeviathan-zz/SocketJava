package server;
import java.io.*;
import java.net.*;
public class Servidor {
 public static void main(String args[]) {
 try {
 ServerSocket s = new ServerSocket(2000);
 while (true) {
 System.out.print("A carregar...");
 Socket conexao = s.accept();
 System.out.println(" Conectou!");
 BufferedReader entrada = new BufferedReader(new
 InputStreamReader(conexao.getInputStream()));
 PrintStream saida = new
 PrintStream(conexao.getOutputStream());
 String linha = entrada.readLine();
 while (linha != null && !(linha.trim().equals(""))) {
 saida.println("Eco: " + linha);
 linha = entrada.readLine();
 }
 conexao.close();
 }
 }
 catch (IOException e) {
 System.out.println("IOException: " + e);
 }
 }
}