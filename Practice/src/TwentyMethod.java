import java.util.Arrays;

public class TwentyMethod {

    static int getMinNumber(int[] numbers)
    {
        int minNum = numbers[0];
        for (int number : numbers)
        {
            if (minNum > number)
            {
                minNum = number;
            }
        }
        return minNum;
    }

    static int getMaxNumber(int[] numbers)
    {
        int maxNum = numbers[0];
        for (int number : numbers) {
            if (maxNum < number)
            {
                maxNum = number;
            }
        }
        return maxNum;
    }

    static int binarySearch(int [] numbers, int searchNum)
    {
//        Search number in numbers array and return index of this number
        int minIndex = 0;
        int maxIndex = numbers.length - 1;

        int answer = -1;

        while (minIndex <= maxIndex)
        {
            int midlIndex = (minIndex + maxIndex) / 2;

            if (searchNum == numbers[midlIndex])
            {
                answer = midlIndex;
                return answer;
            }
            else if (searchNum > midlIndex)
            {
                minIndex = midlIndex + 1;
            }
            else if (searchNum < midlIndex)
            {
                maxIndex = midlIndex - 1;
            }
        }
        return answer;
    }


    static int indexEl(int[] numbers, int findNum)
    {
        int index = 0;
        while (index < numbers.length)
        {
            if (numbers[index] == findNum)
            {
                break;
            }
            index++;
        }
        return index;
    }

    static int[] deleteEl(int[] numbers, int delNum)
    {
        int index = indexEl(numbers, delNum);

        if (numbers == null || index < 0 || index > numbers.length)
        {
            return numbers;
        }
        int[] result = new int[numbers.length - 1];
        System.arraycopy(numbers, 0, result, 0, index);
        System.arraycopy(numbers, index + 1, result, index, numbers.length - index - 1);
        return result;
    }

    static int[] selectionSort(int[] unSort)
    {
        int[] unsortClon = unSort.clone();
        int i = 0;
        while (unSort.length > 0)
        {
            int minNumber = getMinNumber(unSort);
            unsortClon[i] = minNumber;
            unSort = deleteEl(unSort, minNumber);
            i++;
        }
        return unsortClon;
    }

    static int[] bubbleSort(int[] unSort)
    {
        return new int[]{};
    }

    static int[] mergeSort(int[] unSort)
    {
//        I didn't have time to write
        return new int[]{};
    }

    static double [] getDiscriminant(int a, int b, int c)
    {
        int discriminant = b * b - 4 * a * c;
        if (discriminant < 0)
        {
            return new double[]{0};
        }
        else if (discriminant == 0)
        {
            return new double[]{-b / (2 * a)};
        }

        else
        {
            return new double[] {((-b + Math.sqrt(discriminant)) / 2 * a), (int) ((-b - Math.sqrt(discriminant)) / 2 * a)};
        }
    }

    static int getFactorial(int n)
    {
        if (n == 1)
        {
            return 1;
        }
        else if (n <= 0)
        {
            return 0;
        }
        else
        {
            return n * getFactorial(n-1);
        }
    }

    static int getFibonachi(int number)
    {
        if (number == 1)
        {
            return 0;
        }
        else if (number % 2 == 0)
        {
            return 1 + getFibonachi(number/2);
        }
        else
        {
            return 1 + getFibonachi((number * 3) + 1);
        }
    }

    static int getLength(String str)
    {
        char[] strChars = str.toCharArray();
        int lenString = 0;
        for (char ch: strChars)
        {
            lenString++;
        }

        return lenString;
    }

    static String getReversString(String str)
    {
        return "";
    }

    static String replaceAllChars(String str, char rep)
    {
        return "";
    }

    static String replaceFirstChar(String str, char rep)
    {
        return "";
    }

    static int dateToday()
    {
        return 0;
    }

    static int dateTommorow()
    {
        return 0;
    }

    static int sumEveryNumber(int number)
    {
//        This method sum each separated num in number.
//        For example: number = 123
//        Method return 1 + 2 + 3 = 6
        return 0;
    }

    public static void main(String[] args) {
        int[] testArray = {2, 3, 1, 5};
        System.out.println("Min number in" + Arrays.toString(testArray) + " is " + getMinNumber(testArray));
        System.out.println("Max number in " + Arrays.toString(testArray) + " is " + getMaxNumber(testArray));
        System.out.println("Index numbers \"5\" in array " + Arrays.toString(testArray) + " is " + binarySearch(testArray, 5));
        System.out.println("Selection sort array " + Arrays.toString(testArray) + " result = " + Arrays.toString(selectionSort(testArray)));
        System.out.println("Equation 3x^2 - 4x + 2 = 0\rAnswer: " + Arrays.toString(getDiscriminant(3, -4, 2)));
        System.out.println("Equation x^2 - 6x + 9 = 0\rAnswer: " + Arrays.toString(getDiscriminant(1, -6, 9)));
        System.out.println("Equation x^2 - 4x - 5 = 0\rAnswer: " + Arrays.toString(getDiscriminant(1, -4, -5)));
        System.out.println("Factorial 3 is " + getFactorial(3));
        System.out.println("Fibonacci 7 is " + getFibonachi(7));
        System.out.println("Length String \"Hi\" is " + getLength("Hi"));
    }
}
