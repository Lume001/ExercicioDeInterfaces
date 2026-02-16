package POOudemy.ExercicioPoo8.services;

public class PaypalService implements OnlinePaymentService{
    @Override
    public double interest(double amount, Integer months) {
        return amount * months;
    }// nesse caso, a porcentagem de juros é de 1%, então 1 mes, 1 %, 2 meses, 2%.

    @Override
    public double paymentFee(double amount) {
        return amount += amount * 0.02;
    }
}
