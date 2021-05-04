package br.dictonary.search;


import br.dictonary.data.Node;

public class BinaryTree {
    private Node node;
    private int amount = 0;

    public static BinaryTree of(){
        return new BinaryTree(null);
    }

    private BinaryTree(String data) {
        this.node = Node.of(data);
    }

    public void addNode(String content) {
        if( content != null && !content.isEmpty()) {
            // Remove the punctuation from the content
            content = content.replaceAll("(\\w+)\\p{Punct}(\\s|$)", "$1$2");
            String[] words = content.split( " " );

            for (String word : words) {
                if(this.search(this.node, word) == null) {
                    amount += 1;
                    this.node.addNode(word);
                }
            }
        }
    }

    public Node search(Node root, String data){
        // Base Cases: root is null
        if(root == null) return null;

        // Base Cases: key is present at root
        if (root.getData() != null && root.getData().toLowerCase().equals(data.toLowerCase()))
            return root;

        // val is greater than root's key
        if (root.getData() != null && root.getData().toLowerCase().compareTo(data.toLowerCase()) > 0)
            return search(root.getStart(), data);

        // val is less than root's key
        return search(root.getEnd(), data);
    }

    public int getAmount() {
        return amount;
    }

    public void show(Node root){
        if (root != null) {
            show(root.getStart());
            System.out.println(root.getData());
            show(root.getEnd());
        }
    }

    public void order(){
        this.node.InOrder();
    }
}
