public class Node
{
    Comparable data;
    Node next;

    public Node()
    {
        data = null;
        next = null;
    }

    public Node(Comparable d)
    {
        data = d;
        next = null;
    }

    public Node(Comparable d, Node n)
    {
        data = d;
        next = n;
    }

}
