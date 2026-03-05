
import java.util.ArrayList;
import java.util.Scanner;

public class CuentaBancaria{
private String titular;
private double saldo;


 public CuentaBancaria(String titular, double saldo){
  this.titular =titular;
  this.saldo =saldo;
 }
 Scanner sc = new Scanner(System.in);
 public String getTitular(){
  return titular;
 }
 public double getSaldo(){
  return saldo;
 }
 public void  setTitular(String newTitular){
  this.titular = newTitular;

 }
 public void setSaldo(double newSaldo){
  this.saldo = newSaldo;
 }

 public String Tostring() {
     return ("Titular: " + titular + "Saldo: " + saldo);
 }
 public void depositar(double monto) {
  this.saldo = this.saldo + monto;
 }
 public void retirar(double monto) {
     if(saldo >= monto){
         this.saldo = this.saldo - monto;
     }else{
         System.out.println("Saldo insuficiente");
     }

 }
  public void transferir(CuentaBancaria cD, double monto) {
      if (cD != null && this.saldo >= monto) {
          this.saldo = this.saldo - monto;
          cD.setSaldo(cD.getSaldo() + monto);
          System.out.println("Transferencia exitosa.");
      } else {
          System.out.println("Saldo insuficiente o cuenta destino invalida.");
      }

  }


}