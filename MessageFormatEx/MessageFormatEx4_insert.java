package MessageFormatEx;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Scanner;

/*
이전의 예제에서는 데이터를 객체배열에 직접 초기화
-> 이렇게 하면 데이터가 바뀔때마다 매번 배열을 변경해야 하고 그리고 다시 컴파일이 필요함

이러한 불편함을 없애기 위해 Scanner를 통해 파일로부터 데이터를 가져와서 읽는다
파일로부터 데이터를 읽으면 데이터가 변경되어도 컴파일이 필요없다

※프로그램 실행시에 파일명도 지정할 수 있게 하면 파일의 이름이 바뀌어도 컴파일이 필요없다.
 */

public class MessageFormatEx4_insert {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        String tableName = "COST_INFO";
        String fileName = "data.txt";
        String msg = "INSERT INTO " + tableName + " VALUES (''{0}'',''{1}'',{2},''{3}'');";

        Scanner scanner = new Scanner(new File(fileName));

        String pattern = "{0},{1},{2},{3}";
        MessageFormat mf = new MessageFormat(pattern);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Object[] objs = mf.parse(line);
            System.out.println(MessageFormat.format(msg, objs));
        }

        scanner.close();
    }
}
