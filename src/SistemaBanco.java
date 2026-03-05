import java.util.ArrayList;
import java.util.Scanner;
public class SistemaBanco{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

    ArrayList <CuentaBancaria> cuentas  = new ArrayList<CuentaBancaria>();
       cuentas.add(new CuentaBancaria( "Juan Ortiz", 1500.0));
       cuentas.add(new CuentaBancaria("Roberto Carlis", 0.00));
       cuentas.add(new CuentaBancaria("Santiago vicens", 1000.0));
       cuentas.add(new CuentaBancaria("Agustin Alaniz", 5000.0));
       int opcion;
       do {
           System.out.println("Bienvenido. " +
                   "1 Crear cuenta nueva. " +
                   "2 Depositar Dinero. " +
                   "3 Mostrar saldo. " +
                   "4 Retirar Dinero. " +
                   "5 Transferir Dinero. " +
                   "6 Mostrar todas las cuentas." +
                   "7 Salir. ");
           opcion = sc.nextInt();
           sc.nextLine();
           if (opcion == 1) {
               System.out.println("Ingrese su nombre y apellido: ");
               String nC = sc.nextLine();
               cuentas.add(new CuentaBancaria(nC, 0.0));
               System.out.println("Cuenta creada con exito");

           } else if (opcion == 2) {
               System.out.println("Ingrese el nombre de la cuenta a depositar: ");
               String nombreBuscado = sc.nextLine();

               boolean encontrado = false;

               for (CuentaBancaria p : cuentas) {
                   if (nombreBuscado.equalsIgnoreCase(p.getTitular())) {
                       System.out.println("Ingrese el monto a depositar: ");
                       double monto = sc.nextDouble();
                       sc.nextLine();

                       p.depositar(monto);
                       System.out.println("Depósito exitoso.");
                       encontrado = true;
                       break; // Como ya la encontramos, detenemos el bucle
                   }
               }

               if (!encontrado) {
                   System.out.println("Cuenta no encontrada");
               }

           } else if (opcion == 3) {
               System.out.println("Ingrese su nombre de usuario: ");
               String c = sc.nextLine();
               Boolean encontrado = false;
               for (CuentaBancaria p : cuentas) {
                   if (c.equalsIgnoreCase(p.getTitular())) {
                       System.out.println("El saldo de su cuenta es: " + p.getSaldo());
                    encontrado = true;
                   }

               }
               if (!encontrado) {
                   System.out.println("Cuenta no encontrada.");

               }
           } else if (opcion == 4) {
               System.out.println("Ingrese el nombre de la cuenta a retirar: ");
               String nombreBuscado = sc.nextLine();
               boolean encontrado = false;
               for (CuentaBancaria p : cuentas) {

                   if (nombreBuscado.equalsIgnoreCase(p.getTitular())) {
                       System.out.println("Ingrese el monto a retirar: ");
                       double monto = sc.nextDouble();
                       sc.nextLine();

                       p.retirar(monto);

                       encontrado = true;
                       break;
                   }
               }
               if (!encontrado) {
                   System.out.println("No encontramos la cuenta.");
               }
           } else if (opcion == 5) {
               System.out.println("Ingrese su nombre de usuario: ");
               String Nombreorigen = sc.nextLine();
               System.out.println("Ingrese el nombre de la cuenta a transferir: ");
               String NombreDestino = sc.nextLine();
               System.out.println("Ingrese el monto a enviar: ");
               double monto = sc.nextDouble();
               sc.nextLine();
               CuentaBancaria cO = null;
               CuentaBancaria cD = null;
               for (CuentaBancaria p : cuentas) {
                   if (p.getTitular().equalsIgnoreCase(Nombreorigen)) {
                       cO = p;
                   } else if (p.getTitular().equalsIgnoreCase(NombreDestino)) {
                       cD = p;

                   }
               }
               if (cO != null && cD != null) {
                   cO.transferir(cD, monto);
               }
               else {
                   System.out.println("Nombre de usuario no encontrado o monto insuficiente");
               }
           } else if (opcion == 6){
               for (CuentaBancaria p : cuentas){
                   System.out.println(p.Tostring());
               }
           }
       }
           while (opcion != 7);

    }
}