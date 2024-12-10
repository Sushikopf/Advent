package Advent;

public class Node {
    private final int NUMBER;
    private Node next = null;
    private int length = 0;

    public Node(int number) {
        this.NUMBER = number;
        this.length = 1;
        this.next = null;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public Node next(){
        return next;
    }

    public void setLength(int length){
        this.length = length;
    }

    public void append(int number) {
        Node newNode = new Node(number);
        Node it = this;
        Node before = this;
        for(int i= 0; 0 < it.getLength(); i++) {
            if (it.next != null) {
                if (it.next.getNUMBER() < number) {
                    it = it.next;
                }else{
                    break;
                }
            } else {
                break;
            }
        }

            newNode.setNext(it.next());
            it.setNext(newNode);
            length++;
        }

        public String toString() {
            String result = "";

            Node now = new Node(0);
            for (int i = 0; i < length; i++) {
                result += now.getNUMBER() + " \n";
                now.next();
            }
            return result;
        }

    public int getLength(){
        return length;
    }
    public int getNUMBER(){
        return NUMBER;
    }


}
