package client;
import java.io.*;
import java.net.*;
public class Cliente {
 public static void main(String args[]) {
 try {
 Socket conexao = new Socket("127.0.0.1", 2000);
 BufferedReader entrada = new BufferedReader(new
 InputStreamReader(conexao.getInputStream()));
 PrintStream saida = new
 PrintStream(conexao.getOutputStream());
 String linha;
 BufferedReader teclado =
 new BufferedReader(new InputStreamReader(System.in));
 while (true) {
 System.out.print("> ");
 linha = teclado.readLine();
 saida.println(linha+"\nFrom: "+conexao.getInetAddress());
 linha = entrada.readLine();
 if (linha == null) {
 System.out.println("Conex�o encerrada!");
 break;
 }
 System.out.println(linha);
 }
 }
 catch (IOException e) {
 System.out.println("IOException: " + e);
 }
 }
}