package POOudemy.ExercicioPoo8.Application;

import POOudemy.ExercicioPoo8.entities.Contract;
import POOudemy.ExercicioPoo8.entities.Installment;
import POOudemy.ExercicioPoo8.services.ContractService;
import POOudemy.ExercicioPoo8.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato: ");
        System.out.println("Numero: ");
        int numero = sc.nextInt();
        System.out.println("Data: ");
        sc.nextLine();
        LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
        System.out.println("Valor do contrato: ");
        double totalValue = sc.nextDouble();

        Contract c1 = new Contract(numero, date, totalValue);

        System.out.println("Entre com o numero de parcelas: ");
        int n = sc.nextInt();

        ContractService service = new ContractService(new PaypalService());
        service.processContract(c1, n);

        System.out.println("Parcelas: ");
        for (Installment installment : c1.getInstallments()){
            System.out.println(installment);
        }

        sc.close();
    }
}
