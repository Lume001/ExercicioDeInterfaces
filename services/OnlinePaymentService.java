package POOudemy.ExercicioPoo8.services;

public interface OnlinePaymentService {
     double paymentFee(double amount); // taxa de pagamento, devolve taxa da quantia
     double interest(double amount, Integer months); // juros, recebe quantia, recebe meses e devolve juros

}
