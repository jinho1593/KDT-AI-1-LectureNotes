package variousClassUsage.refactor;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RefactorManager {
    List<RefactorMember> memberList;
    List<RefactorProduct> productList;

    public RefactorManager() {
        memberList = new ArrayList<>();
        productList = new ArrayList<>();
    }

    // 랜덤한 이메일을 만들어줘야함
    // 앞에 글자 4 ~ 8개 정도를 랜덤으로 뽑자!
    // 뒤에는 @test.com을 붙이도록 한다.
    // 5명 정도 만든다고 가정!
    public void addRandomMember() {
        final int MAX_MEMBER_NUMBER = 5;

        final int MIN_EMAIL_LENGTH = 4;
        final int MAX_EMAIL_LENGTH = 8;

        for(int i = 0; i < MAX_MEMBER_NUMBER; i++) {
            String tmpString = "";
            int emailLength = CustomRandom.generateNumber(MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);

            for (int j = 0; j < emailLength; j++) {
                tmpString += (char) CustomRandom.generateNumber('a', 'z');
            }

            memberList.add(new RefactorMember(
                    i, tmpString + "@test.com", "test"));

        }

    }

    public void printMemberList () {
        for (RefactorMember member : memberList) {
            System.out.println(member);
        }
    }

    public void addRandomProduct() {
        final int MIN = 0;
        final int MAX = 2;

        final int DAECHUL_MIN = 1;
        final int DAECHUL_MAX = 10;

        final String[] productNameArray = { "대출상품1", "대출상품2", "대출상품3", };
        final String vendor = "DAECHWUL";

        for (int i = 0; i <productNameArray.length; i++) {
            int price = 10000000 * CustomRandom.generateNumber(DAECHUL_MIN, DAECHUL_MAX);
            productList.add(new RefactorProduct(
                    productNameArray[i], vendor, price));
        }
    }

    public void printProductList () {
        for (RefactorProduct product : productList) {
            System.out.println(product);
        }
    }

    public void buyRandomProduct() {
        final int MIN = 0;
        final int MAX = 4;
        // List의 길이는 size()를 통해 구할 수 있습니다.
        int productLength = productList.size();

        for (int i = 0; i < productLength; i++) {
            RefactorProduct product = productList.get(
                    CustomRandom.generateNumber(2));

            product.setMemberId(
                    CustomRandom.generateNumber(MIN, MAX));
        }
    }
}
