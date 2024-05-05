import java.util.Random;
import java.util.Scanner;

class DartGame {
    public static int wuhu(int res) {
        Random rand = new Random();

        int comb = 0;

        while (res != 0) {
            if (res == 25) {
                comb = res;
                res -= comb;
                System.out.println(comb);
            } else if (res == 50) {
                comb = res / 2;
                res -= comb * 2;
                System.out.println("double" + comb);
            } else if (res % 3 == 0) {
                comb = res / 3;
                res -= comb * 3;
                System.out.println("triple" + comb);
            } else if (res % 2 == 0) {
                comb = res / 2;
                res -= comb * 2;
                System.out.println("double" + comb);
            } else {
                if (res > 20) {
                    int num1 = rand.nextInt(22);
                    if (num1 == 21)
                        num1 = 25;
                    System.out.println(num1);
                    res -= num1;
                } else {
                    int temp = res;
                    res -= temp;
                    System.out.println(temp);
                }
            }
        }
        return res;
    }

    public static int k(int uk) {
        Random rand = new Random();
        int r = 0;
        int wtf = 0;

        while (r == 0) {
            int num1 = rand.nextInt(22);
            if (num1 == 21)
                num1 = 25;
            int num2 = rand.nextInt(22);
            if (num2 == 21)
                num2 = 25;
            int num3 = rand.nextInt(22);
            if (num3 == 21)
                num3 = 25;

            if (num1 != 25 && num2 != 25 && num3 != 25) {
                for (int i = 1; i <= 3; i++) {
                    for (int j = 1; j <= 3; j++) {
                        for (int z = 1; z <= 3; z++) {
                            wtf = num1 * i + num2 * j + num3 * z;
                            if (wtf == uk) {
                                System.out.printf("Combination: %d * %d + %d * %d + %d * %d = %d\n", num1, i, num2, j, num3, z, uk);
                                r = 1;
                                break;
                            }
                        }
                        if (r == 1)
                            break;
                    }
                    if (r == 1)
                        break;
                }
            } else {
                if (num1 == 25 || num2 == 25 || num3 == 25) {
                    for (int i = 1; i <= (num1 == 25 ? 2 : 3); i++) {
                        for (int j = 1; j <= (num2 == 25 ? 2 : 3); j++) {
                            for (int k = 1; k <= (num3 == 25 ? 2 : 3); k++) {
                                wtf = num1 * i + num2 * j + num3 * k;
                                if (wtf == uk) {
                                    System.out.printf("Combination: %d * %d + %d * %d + %d * %d = %d\n", num1, i, num2, j, num3, k, uk);
                                    r = 1;
                                    break;
                                }
                            }
                            if (r == 1)
                                break;
                        }
                        if (r == 1)
                            break;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int res = 0;
        int comb = 0;
        System.out.print("Enter a value: ");
        res = scanner.nextInt();
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        if (res <= 60) {
            res = wuhu(res);
        } else if (res > 60 && res < 120) {
            while (res != 0) {
                int temp = 3 * 20;
                res -= temp;
                System.out.println("triple 20");
                res = wuhu(res);
            }
        } else {
            k(res);
        }
    }
}

