public class SortedLinkedList
{
    Node head;

    public SortedLinkedList()
    {
        head = null;
    }

    public Node appropriatePosition(Comparable given)
    {
        Node previous = null;
        Node current = head;

        while (current != null)
        {
            if (current.data.compareTo(given) >= 0)
            {
                return previous;
            }
            else if (current.next == null)
            {
                return current;
            }
            if (current.data.compareTo(given) < 0 && current.next.data.compareTo(given) >= 0)
            {
                return current;
            }
            previous = current;
            current = current.next;
        }
        return previous;
    }

    public Comparable smallest()
    {
       Comparable small = head.data;
       return small;
    }

    public Comparable largest()
    {
        Comparable largest = null;
        Node pointer = head;
        
        while (pointer.next != null)
        {
            pointer = pointer.next;
        }
        largest = pointer.data;
        return largest;
    }

    public void insert(Comparable givenInsert)
    {
        Node position = appropriatePosition(givenInsert);
        Node pointing = null;

        if (head == null)
        {
            head = new Node(givenInsert);
            return;
        }
        if (position == null)
        {
            pointing = new Node(head.data);
            pointing.next = new Node(head.data, head.next);
            head.data = givenInsert;
            head.next = pointing.next;
        }
        else
        {
            pointing = head;
            while (pointing != null)
            {
                if (pointing.data.compareTo(position.data) == 0)
                {
                    pointing.next = new Node(givenInsert, position.next);
                    position.next = pointing.next;
                    break;
                }
                else
                {
                    pointing = pointing.next;
                }
            }
        
        }
    }

    public Node find(Comparable findGiven)
    {
        Node point = head;

        while (point != null)
        {
            if (point.next == null || point.data.compareTo(findGiven) == 0)
            {
                if (head.data.compareTo(findGiven) == 0)
                {
                    return point;
                }
                return null;
            }
            else if (point.next.data.compareTo(findGiven) == 0)
            {
                return point;
            }
            else
            {
                point = point.next;
            }
        }
        return null;
    }

    public void delete(Comparable givenDelete)
    {
        Node check = null;

        if (head != null)
        {
            check = find(givenDelete);
        }
        else
        {
            System.out.println("This linked list is empty.");
            return;
        }

        if (check == null)
        {
            System.out.println("The data item was not found.");
        }
        else
        {
            if (head.next == null)
            {
                head = null;
                return;
            }
            else if (head.data.compareTo(check.data) == 0 && head.next.data.compareTo(givenDelete) != 0)
            {
                head.data = head.next.data;
                head.next = head.next.next;
            }
            else
            {
                check.next = check.next.next;
            }
        }
    }

    public void clear()
    {
        head = null;
    }

    public boolean empty()
    {
        if (head == null)
        {
            return true;
        }
        else
        {
            return false;
        }       
    }
}
