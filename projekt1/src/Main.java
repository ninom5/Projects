import java.util.Scanner;
import java.security.SecureRandom;
import java.util.Arrays;

class Main
{
    public static void main(String[] args) {


        System.out.println("Chose option for your password");
        Scanner scanner = new Scanner(System.in);

        SecureRandom secureRandom = new SecureRandom();


        StringBuilder stringBuilder = new StringBuilder();
        boolean is_true = false;

        while(!is_true)
        {
            System.out.println("Choose one of the options: 1-only numbers, 2-only letters, 3-everything(special characters included)");
            int option = Integer.parseInt((scanner.nextLine()));
            System.out.println("length of password?");
            int length = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    for(int i = 0; i<length; i++)
                    {
                        int randomNum = secureRandom.nextInt(10);
                        stringBuilder.append(randomNum);
                    }
                    String result_Numbers = stringBuilder.toString();
                    System.out.printf("Password for numbers only: " + result_Numbers + "\n");

                    int strength1 = passwordChecker(result_Numbers);
                    print(strength1);

                    float c_time = crackTime(length, result_Numbers);
                    float c_time_in_days = (float) c_time / 86400;
                    System.out.printf("Assuming that hackers can try 100.000.000.000 combinations per second it would take them: %f seconds or %f days to crack your password\n", c_time, c_time_in_days);
                    System.out.println("Are you satisfied with password\n");
                    String answer1 = scanner.nextLine();
                    if(answer1.equals("yes"))
                    {
                        is_true = true;
                    }
                    stringBuilder.setLength(0);


                    break;
                case 2:
                    for(int i = 0; i<length; i++)
                    {
                        char randomChar;
                        if (secureRandom.nextBoolean())
                        {
                                randomChar = (char) ('a' + secureRandom.nextInt(26));
                        }
                        else
                        {
                            randomChar = (char) ('A' + secureRandom.nextInt(26));
                        }
                        stringBuilder.append(randomChar);
                    }
                    String result_Letters = stringBuilder.toString();
                    System.out.printf("Password for letters only: " + result_Letters );

                    int strength2 = passwordChecker(result_Letters);
                    print(strength2);

                    float cr_time = crackTime(length, result_Letters);
                    float cr_time_in_days = (float) cr_time / 86400;
                    System.out.printf("Assuming that hackers can try 100.000.000.000 combinations per second it would take them: %f seconds or %f days to crack your password\n", cr_time, cr_time_in_days);

                    System.out.println("Are you satisfied with password");
                    String answer2 = scanner.nextLine();
                    if(answer2.equals("yes"))
                    {
                        is_true = true;
                    }
                    stringBuilder.setLength(0);
                    break;
                case 3:
                    for(int i = 0; i < length; i++)
                    {
                        char randomChar;
                        int randomNumber;
                        char randomSpecial;

                        if(secureRandom.nextBoolean())
                        {
                            randomNumber = secureRandom.nextInt(10);
                            stringBuilder.append(randomNumber);
                        }
                        else if (secureRandom.nextBoolean())
                        {
                            if(secureRandom.nextBoolean())
                            {
                                randomChar = (char) ('a' + secureRandom.nextInt(26));
                            }
                            else
                            {
                                randomChar = (char) ('A' + secureRandom.nextInt(26));
                            }
                            stringBuilder.append(randomChar);
                        }
                        else
                        {
                            randomSpecial = (char) (secureRandom.nextInt(15) + 33);
                            stringBuilder.append((randomSpecial));
                        }
                    }
                    String resultEv = stringBuilder.toString();
                    System.out.printf("Password for everything included: " + resultEv);

                    int strength = passwordChecker(resultEv);
                    print(strength);

                    float crc_time = crackTime(length, resultEv);
                    float crc_time_in_days = (float) crc_time / 86400;
                    System.out.printf("Assuming that hackers can try 100.000.000.000 combinations per second it would take them: %f seconds or %f days to crack your password\n", crc_time, crc_time_in_days);

                    System.out.println("Are you satisfied with password");
                    String answer = scanner.nextLine();
                    if(answer.equals("yes"))
                    {
                        is_true = true;
                    }

                    //estimated time to crack;
                    stringBuilder.setLength(0);
                    break;
                default:
                    System.out.printf("wrong choice try again");
                    break;
            }
        }

        scanner.close();
    }
    public static int passwordChecker(String result)
    {
        int numbers = 0;
        int lowerCase = 0;
        int upperCase = 0;
        int specialSymbols = 0;

        for(int i = 0; i < result.length(); i++)
        {
            if(Character.isDigit(result.charAt(i)))
            {
                numbers++;
            }
            else if(Character.isLowerCase(result.charAt(i)))
            {
                lowerCase++;
            }
            else if(Character.isUpperCase(result.charAt(i)))
            {
                upperCase++;
            }
            else
            {
                specialSymbols++;
            }
        }
        int strength = 0;

        if(result.length() >= 8 && result.length() <10)
            strength++;
        else if(result.length() >= 10 && result.length() <= 14)
            strength+=2;
        else if (result.length() > 14)
            strength+=3;

        if(numbers > 0)
            strength++;
        if(upperCase > 0)
            strength++;
        if(lowerCase > 0)
            strength++;
        if(specialSymbols > 0)
            strength++;

        return strength;
    }
    public static void print(int strength)
    {
        int max_strength = 7;
        if(strength <= 2)
            System.out.printf("Password is weak. It has grade: %d out od %d", strength, max_strength);
        else if (strength > 2 && strength <= 4)
            System.out.printf("Password is good. It has grade: %d out od %d", strength, max_strength);
        else if(strength > 4 && strength < 7)
            System.out.printf("Password is strong. It has grade: %d out od %d", strength, max_strength);
        else
            System.out.printf("Password is SUPER STRONG. It has grade: %d out od %d", strength, max_strength);
    }
    public static long crackTime(int length, String password)
    {
        long time = 0;
        long guesses_per_second = 100000000000L;

        int numbers = 0;
        int lowerCase = 0;
        int upperCase = 0;
        int specialSymbols = 0;

        for(int i = 0; i < password.length(); i++)
        {
            if(Character.isDigit(password.charAt(i)))
            {
                numbers++;
            }
            else if(Character.isLowerCase(password.charAt(i)))
            {
                lowerCase++;
            }
            else if(Character.isUpperCase(password.charAt(i)))
            {
                upperCase++;
            }
            else
            {
                specialSymbols++;
            }
        }
        if((numbers > 0) && (lowerCase > 0) && (upperCase > 0) && (specialSymbols > 0))
        {
            int all_char = 82;
            long possible_combinations = (long)Math.pow(all_char, length);
            time = possible_combinations/guesses_per_second;
            return time;
        } else if ((numbers > 0) && (lowerCase > 0) && (upperCase > 0))
        {
            int all_char = 62;
            long possible_combinations = (long)Math.pow(all_char, length);
            time = possible_combinations/guesses_per_second;
            return time;
        }
        else if ((numbers > 0) && (lowerCase > 0) && (specialSymbols > 0))
        {
            int all_char = 42;
            long possible_combinations = (long)Math.pow(all_char, length);
            time = possible_combinations/guesses_per_second;
            return time;
        }
        else if ((numbers > 0) && (upperCase > 0) && (specialSymbols > 0))
        {
            int all_char = 42;
            long possible_combinations = (long)Math.pow(all_char, length);
            time = possible_combinations/guesses_per_second;
            return time;
        }
        else if ((lowerCase > 0) && (upperCase > 0) && (specialSymbols > 0))
        {
            int all_char = 72;
            long possible_combinations = (long)Math.pow(all_char, length);
            time = possible_combinations/guesses_per_second;
            return time;
        }
        else if ((lowerCase > 0) && (upperCase > 0))
        {
            int all_char = 26;
            long possible_combinations = (long)Math.pow(all_char, length);
            time = possible_combinations/guesses_per_second;
            return time;
        }
        else
        {
            int all_char = 10;
            long possible_combinations = (long)Math.pow(all_char, length);
            time = possible_combinations/guesses_per_second;
            return time;
        }
    }
}