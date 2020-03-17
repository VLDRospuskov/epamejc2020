package homeworks.homework08.part1;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        CreditCardInfoIntroducer creditCardInfoIntroducer = new CreditCardInfoIntroducer();

        MySupplier<CreditCard> creditCardMySupplier =
                () -> new CreditCard(4221, BigDecimal.valueOf(500_000), 289);

        MySupplier<User> userSupplier = () -> new User("Masha");

        String cardInfoShort = creditCardInfoIntroducer.getCardInformation(
                creditCardMySupplier, userSupplier, (card, user) ->
                        user.name + " owns card " + card.getCardNumber());

        String cardInfoFull = creditCardInfoIntroducer.getCardInformation(
                creditCardMySupplier, userSupplier, (card, user) ->
                        user.name + " owns card " + card.getCardNumber()
                                + ". Balance: " + card.getBalance()
                                + ". CVV: " + card.getCVV());

        System.out.println(cardInfoShort);
        System.out.println(cardInfoFull);
    }
}
