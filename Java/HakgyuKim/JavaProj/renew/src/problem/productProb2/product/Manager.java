package problem.productProb2.product;

import problem.productProb2.member.Member;
import utility.generator.SequenceGenerator;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {
    List<Member> memberList;
    List<Product> productList;
    public Map<String, List<Integer>> productListMap = new HashMap<>();

    public Manager() {
        memberList = new ArrayList<>();
        productList = new ArrayList<>();
    }

    public void addRandomMember() {
        final int MAX_MEMBER_NUMBER = 5;

        for (int i = 0; i < MAX_MEMBER_NUMBER; i++) {
            addMember();
        }
    }

    public void addMember () {
        final int MIN_EMAIL_LENGTH = 4;
        final int MAX_EMAIL_LENGTH = 8;

        String tmpString = "";
        int emailLength = CustomRandom.generateNumber(MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);

        for (int j = 0; j < emailLength; j++) {
            tmpString += (char) CustomRandom.generateNumber('a', 'z');
        }

        memberList.add(new Member(
                SequenceGenerator.getSpecificEntityId("Member"),
                tmpString + "@test.com", "test"));
    }

    public void printMemberList () {
        for (Member member: memberList) {
            System.out.println(member);
        }
    }

    public void addRandomProduct() {
        final int DAECHWUL_MIN = 1;
        final int DAECHWUL_MAX = 10;

        final String[] productNameArray = { "대출상품1", "대출상품2", "대출상품3" };
        final String vendor = "DAECHWUL";

        for (int i = 0; i < productNameArray.length; i++) {
            int price = 10000000 * CustomRandom.generateNumber(DAECHWUL_MIN, DAECHWUL_MAX);
            productList.add(new Product(
                    productNameArray[i], vendor, price));
        }
    }

    public void printProductList () {
        for (Product product: productList) {
            System.out.println(product);
        }
    }

    public void buyRandomProduct() {
        final int MAX = memberList.size() - 1;

        int productLength = productList.size();

        for (int i = 0; i < productLength; i++) {
            int randomProduct = CustomRandom.generateNumber(productLength - 1);
            Product product = productList.get(randomProduct);

            product.setMemberId(
                    CustomRandom.generateNumber(MAX));

            productListMap.put(productList.get(randomProduct).getProductName(), product.getMemberIdList());
        }
    }
    public void getProductBuyerId (String productName) {
        if (productListMap.get(productName) == null) {
            System.out.println("상품 구매자가 없습니다");
        } else {
            System.out.println(productListMap.get(productName));
        }
    }
}