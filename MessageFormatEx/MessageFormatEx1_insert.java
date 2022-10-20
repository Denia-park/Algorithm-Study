package MessageFormatEx;

import java.text.MessageFormat;

/*
MessageFormat 은 데이터를 정해진 양식에 맞게 출력할 수 있도록 도와준다.
데이터가 들어갈 자리를 마련해 놓은 양식을 미리 작성하고 프로그램을 이용해서
다수의 데이터를 같은 양식으로 출력할 때 사용

예를 들어 : 고객에게 보내는 안내문

MessageFormat 의 parse를 이용하면 지정된 양식에서 필요한 데이터만을 손쉽게 추출해낸다.

* */

public class MessageFormatEx1_insert {
    public static void main(String[] args) {
        //pattern 을 작성할때는 '{숫자}'로 표시된 부분이 데이터가 출력될 자리.
        //인덱스는 0부터 시작
        String msg = "Name : {0} \nTel: {1} \nAge: {2} \nBirthDay: {3}";

        //Object (객체) 의 배열이기 때문에 String 이외에도 다른 객체들이 지정될 수 있다.
        Object[] arguments = {
                "이자바", "02-123-4567", "30", "12-34"
        };

        String result = MessageFormat.format(msg, arguments);
        System.out.println(result);
    }
}
