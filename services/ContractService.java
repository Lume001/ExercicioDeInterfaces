package POOudemy.ExercicioPoo8.services;

import POOudemy.ExercicioPoo8.entities.Contract;
import POOudemy.ExercicioPoo8.entities.Installment;

import java.time.LocalDateTime;


public class ContractService {
    private OnlinePaymentService onlinePayment;
    private Installment installment;


    public void processContract(Contract contract, Integer months, OnlinePaymentService onlinePayment){
        for(int i = 0; i<months; i++) {
            LocalDateTime data = contract.getDate().plusMonths(1);
            installment.setDueDate(data);
            System.out.println("Data: "+installment.getDueDate());

            System.out.println( onlinePayment.paymentFee(contract.getTotalValue())+"\n"+
            onlinePayment.interest(contract.getTotalValue(), months));

        }

    }
}
