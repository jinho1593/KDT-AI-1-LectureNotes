package ArrayTest;

public class ArrayTest {
    public static void main(String[] args) {
        final int START = 0;

        // 배열을 만드는 방법(일단 final은 제끼세요)
        // 1. 데이터 타입을 적고 대괄호[]를 적습니다
        // 2. 변수 선언하듯 변수 이름을 작성합니다.
        //    당연히 이름이기 때문에 전달력 및 표현력이 중요합니다
        // 3. 필요하다면 중괄호를 열고 초기화를 하거나
        //    또는 new 데이터타입(1번) [] 형태로
        //    Heap에 메ㅁ리 할당을 강제할 수 있습니다.

        final int[] numberArray = { 1, 2, 3, 4, 5};

        // 여기서 이야기 한 heap과 대조되는 것이 Stack입니다.
        // 현재 위 코드는 Stack이라는 지역 변수에 설정하는 배열이며
        // new를 통해 할당하는 경우에엔 Heap이라는 공간에 할당합니다.
        // 우리는 로우 시스템 개발자가 아니므로 여기서 더 깊게 들어갈 필욘 없습니다
        // 그냥 아! new를 했기때문에 Heap에 있구나 정도면 OK

        // 반면 new를 해서 Heap에 설정되는 정보들은 메모리에 상주하게 됩니다.
        // 그러므로 언제 어디서든 데이터에 접근할 수 있게 됩니다.
        // 자바 개발자에게 있어 둘의 차이점이라면
        // 현재 이 내용이 가장 크다 볼 수 있겠습니다.

        // 결론: Stack은 중괄호{} 내에서 사용됨
        //      Heap은 new 하고 이후로 사용됨

        for (int i = START; i < numberArray.length; i++) {
            // 배열 이라는 녀석은 메모리 공간상에 순차적으로 배치됩니다.
            // 메모리 공간이라는 것이 생소하다면
            // 아래와 같이 박스들이 일렬로 나열되어 있는 상황을 생각해도 됩니다.

            //   0     1     2     3     4  <<-- 5개 있지만 0 ~ 4로 표현됨
            // [   ] [   ] [   ] [   ] [   ]

            // 주의할 부분이라면 배열의 시작이 0부터라는 것에 주의를 해주세요.
            // 우리는 1부터 100까지라고 말하지만
            // 배열은 0부터 99까지 움직이게 됩니다.

            // 그러므로 numberArray [0]은 숫자 1을 표현하고
            // numberArry[1]은 숫자 2를 표현하며
            // numberArry[2]은 숫자 3
            // numberArry[3]은 숫자 4
            // numberArry[4]은 숫자 5

            // 위 형태로 동작하여 for 루프에서
            // i값이 증가함에 따라 모든 배열의 원소들은 출력하게 됩니다
            System.out.println("배열 출력: " + numberArray[i]);
        }

        System.out.println();

        // for의 변형 버전 foreach라고도 이야기함
        // foreach 사용법
        // 1. 배열의 데이터 타입을 작성합니다(여기선 int)
        // 2. 배열의 원소를 표현할 이름을 적당히 지정합니다 (여기선 num)
        // 3. 콜론하나 찍습니다 (:)
        // 4. 정보를 하나씩 꺼내 올 배열을 적어줍니다 (여기선 numberArray)

        for (int num: numberArray) {
            System.out.println("배열 원소 출력: " + num);
        }

        // 비지니스가 확장됨에 따라 서비스가 커졌고
        // 그에 따라 데이터의 규모도 커졌다 (여기선 배열에 정보가 많다고 가정)
        // 이런 상황에서 for(초기화; 조건; 증감) 과 foreach가 있다면 누가 더 좋을까 ?

        // 첫 번째 - 이유 -> 초기화나 조건등이 있어 향후 변경에 유리하다 생각됨
        // 두 번째 - 이유 -> 전자는 계속 조건식을 검사해야함
        // 이런 이유 때문에 사실 데이터를 요청하면
        // 뭉태기로 한 번에 쏘지 않고 필요한 정보만 선별해서 쏘게 됩니다.
        // 가령 AWS에서 1000만명 분량의 데이터를
        // 검색 한 번에 다 가져오게 되면 요금 폭탄맞고 회사 망합니다.
        // 그래서 서비스 관점에선 이런 조각 내기 개념으로서 페이징(paging)이라는 것을 합니다.
        // os 레벨에서 이야기하는 paging과는 다른 개념이니 주의합시다!
        // (여기서 이야기하는 paging은 데이터 조각내기 관점이라 보면 됩니다.)

    }
}
