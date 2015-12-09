import java.util.*;

public class TestDriver
{
    public static void main(String[] args)
    {
        int inputCheck1 = 0;
        int insertInt = 0;
        double insertDouble = 0.0;
        int temp = 0;
        int temp1 = 0;
        Comparable smallest = 0.0;
        Comparable largest = 0.0;
        SortedLinkedList mainSorted = new SortedLinkedList();
        Scanner keyboard = new Scanner(System.in);
        do
        {
	        System.out.println("Insert\nDelete\nClear\nSmallest\nLargest\nExit");
            System.out.print("Choose one of the above: ");
            String option = keyboard.next();
            String optionCheck = option.toUpperCase();

            do
            {
                do
                {   
                    if (optionCheck.equals("INSERT"))
                    {
                        System.out.print("Type in the integer or double to be inserted(type back to go back to menu or distance for distance): ");

                            if (keyboard.hasNextInt())
                            {
                                insertInt = keyboard.nextInt();
                                inputCheck1 = 0;
                                temp1 = 1;
                            }
                            else if (keyboard.hasNextDouble())
                            {
                                insertDouble = keyboard.nextDouble();
                                inputCheck1 = 0;
                                temp1 = 2;
                            }
                            else
                            {
                                option = keyboard.next();
                                optionCheck = option.toUpperCase();
                            
                                if (!optionCheck.equals("BACK") && !optionCheck.equals("DISTANCE"))
                                {
                                    System.out.println("Incorrect data type! Must be an integer or double, please try again.");
                                    inputCheck1 = 1;
                                    optionCheck = "INSERT";
                                }
                                else if (optionCheck.equals("BACK"))
                                {
                                    break;
                                }
                                else if (optionCheck.equals("DISTANCE"))
                                {
                                    double feet = 0.0;
                                    double inches = 0.0;
                                    System.out.print("Enter feet: ");
                                    if (keyboard.hasNextInt())
                                    {
                                        System.out.println("Must be a double or integer! Try again.");
                                        inputCheck1 = 1;
                                    }
                                    else
                                    {
                                        feet = keyboard.nextDouble();
                                        System.out.print("Enter inches: ");
                                        inputCheck1 = 0;
                                        if (keyboard.hasNextInt())
                                        {
                                            System.out.println("Must be a doubleor integer! Try again.");
                                            inputCheck1 = 1;
                                        }
                                        else
                                        {
                                            inches = keyboard.nextDouble();
                                            insertDouble = (feet*12) + inches;
                                            temp1 = 2;
                                            inputCheck1 = 0;
                                            Distance distanceAll = new Distance();
                                        }
                                    }
                                }
                            }
                        }
                    } while (inputCheck1 == 1);

                do
                {
                    if (optionCheck.equals("DELETE"))
                    {
                        System.out.print("Type in the integer or double to be deleted(type back to go back to menu): ");

                            if (keyboard.hasNextInt())
                            {
                                insertInt = keyboard.nextInt();
                                inputCheck1 = 0;
                                temp1 = 1;
                            }
                            else if (keyboard.hasNextDouble())
                            {
                                insertDouble = keyboard.nextDouble();
                                inputCheck1 = 0;
                                temp1 = 2;
                            }
                            else
                            {
                                option = keyboard.next();
                                optionCheck = option.toUpperCase();
                                if (!optionCheck.equals("BACK"))
                                {
                                    System.out.println("Incorrect data type! Must be an integer or double, please try again.");
                                    inputCheck1 = 1;
                                    optionCheck = "DELETE";
                                }
                                else if (optionCheck.equals("BACK"))
                                {
                                    break;
                                }
                            }
                    }
                } while (inputCheck1 == 1);

                if (optionCheck.equals("CLEAR"))
                {
                    mainSorted.clear();
                    break;
                }

                if (optionCheck.equals("SMALLEST"))
                {
                    smallest = mainSorted.smallest();
                    System.out.println("Smallest Data Item: " + smallest);
                    break;
                }

                if (optionCheck.equals("LARGEST"))
                {
                    largest = mainSorted.largest();
                    System.out.println("Largest Data Item: " + largest);
                    break;
                }

                if (optionCheck.equals("EXIT"))
                {
                    System.exit(0);
                }
            
                Comparable correctType = temp;

                if (temp1 == 1)
                {
                    insertDouble = (double) insertInt;
                }      

                Double insertToLinkedList = new Double(insertDouble);
                correctType = insertToLinkedList;

                if (optionCheck.equals("INSERT") || optionCheck.equals("DELETE") || optionCheck.equals("DISTANCE"))
                {
                    if (optionCheck.equals("INSERT") || optionCheck.equals("DISTANCE"))
                    {
                        mainSorted.insert(correctType);
                    }   
                    else if (optionCheck.equals("DELETE"))
                    {
                        mainSorted.delete(correctType);
                    }
                    System.out.println("Linked List Contents: ");
                    if (mainSorted.head == null)
                    {
                        System.out.println("Empty Linked List");
                    }
                    else
                    {
                        Node printPoint = mainSorted.head;
                        while (printPoint != null)
                        {
                            System.out.print(printPoint.data + " ");
                            printPoint = printPoint.next;
                        }
                        System.out.println();
                    }   
                }
            } while (!optionCheck.equals("BACK") && !optionCheck.equals("DISTANCE"));
        } while (temp == 0);
    }
}
