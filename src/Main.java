import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("1から50までの数字を入力してください: ");
            int maxNumber = scanner.nextInt();

            if (maxNumber < 1 || maxNumber > 50) {
                throw new IllegalArgumentException("入力は1から50の間でなければなりません。");
            }

            List<Integer> numbers = IntStream.rangeClosed(1, maxNumber)
                    .map(n -> n * 2)
                    .filter(n -> n % 5 == 2)
                    .boxed()
                    .collect(Collectors.toList());

            System.out.println("選ばれた数字: " + numbers);
        } catch (InputMismatchException e) {
            System.out.println("エラー: 数字を入力してください。");
        } catch (IllegalArgumentException e) {
            System.out.println("エラー: " + e.getMessage());
        } finally {
            try {
                scanner.close();
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("スキャナーのクローズ中にエラーが発生しました。");
            }
        }
    }
}
