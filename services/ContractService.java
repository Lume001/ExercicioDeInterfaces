package POOudemy.ExercicioPoo8.services;

import POOudemy.ExercicioPoo8.entities.Contract;
import POOudemy.ExercicioPoo8.entities.Installment;

import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentService onlinePayment;

    public ContractService(OnlinePaymentService onlinePayment) {
        this.onlinePayment = onlinePayment;
    }

    public void processContract(Contract contract, Integer months){

        double basicQuota = contract.getTotalValue() / months;

        for(int i = 1; i <= months; i++) {
            LocalDate data = contract.getDate().plusMonths(i);

            double interest =  onlinePayment.interest(basicQuota, i);
            double fee = onlinePayment.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + fee;

            contract.getInstallments().add(new Installment(data, quota));

        }
    }
}
