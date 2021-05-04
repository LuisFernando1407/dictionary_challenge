package br.dictonary.data;

public class Node {
    private String data;
    private Node start; //left
    private Node end; //right

    public static Node of(String data){
        return new Node(data);
    }

    private Node(String data) {
        this.data = data;
        this.start = null;
        this.end = null;
    }

    public void addNode(String data) {
        if (this.data == null) {
            this.data = data;
        } else {
            if (this.data.toLowerCase().compareTo(data.toLowerCase()) > 0) {
                if (this.start != null) {
                    this.start.addNode(data);
                } else {
                    this.start = new Node(data);
                }

            } else {
                if (this.end != null) {
                    this.end.addNode(data);
                } else {
                    this.end = new Node(data);
                }
            }
        }
    }

    public void InOrder() {
        if (this.start != null) {
            this.start.InOrder();
        }

        System.out.println(this.data);

        if (this.end != null) {
            this.end.InOrder();
        }
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }
}
