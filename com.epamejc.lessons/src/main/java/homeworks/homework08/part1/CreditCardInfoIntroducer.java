package homeworks.homework08.part1;

public class CreditCardInfoIntroducer {
    public <R> R getCardInformation(MySupplier<? extends CreditCard> creditCard,
                                    MySupplier<? extends User> user,
                                    MyBiFunction<? super CreditCard, ? super User, R> function ) {
        return function.apply(creditCard.get(), user.get());
    }
}
