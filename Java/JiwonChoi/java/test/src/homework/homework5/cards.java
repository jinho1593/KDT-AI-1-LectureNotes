package homework.homework5;
import utility.random.CustomRandom;
import java.util.ArrayList;
import homework.enumTest.CardPattern;

import static homework.enumTest.CardPattern.patternsList;

public class cards {
    private CardPattern cardPattern;
//    ArrayList<String> arrayCards = new ArrayList<>(); // 랜덤카드 배열 선언

    public cards(CardPattern cardPattern) { //생성자..?
        this.cardPattern = cardPattern;}

    @Override
    public String toString() {
        return "cards{" +
                "cardPattern=" + cardPattern +
                '}';
    }
    //    static int randomCardNum() {    // 랜덤카드 1개를 뽑는 함수
//        int randomCardNum = CustomRandom.generateNumber(1, 12);
//        return randomCardNum;
//    }
//
//    static void divideCards(ArrayList<String> realCard, int getCardsCount) { // 여러번 랜덤카드를 뽑는 함수
//        for (int i = 0; i < getCardsCount; i++) {//플레이어가 가진 카드 개수만큼 반복
//
//            int cardnum = randomCardNum();
//            String card1e = patternValueList[cardnum-1].getCardName();//??????
//            realCard.add(card1e);  //??????????????????
//
//
////            for(int i = 0; i < player1.cardsCount; i++) {
////                int cardnum = player1.cards[i];
////                String[] realCard = new String[player1.cardsCount];
////                realCard[i] = CardsPattern.patternValueList[cardnum-1].cardName;
////            }
//
//           // arrayCards.add(randomCardNum()); //뽑은 랜덤카드 1개를 arrayCards배열 요소로 추가
        }

