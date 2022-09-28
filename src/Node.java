import java.io.File;
import java.util.ArrayList;

public class Node {
    private File folder;
    private ArrayList<Node> children;
    private Long size;
    private int level;

    public Node (File folder){
        this.folder = folder;
        children = new ArrayList<>();
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public File getFolder (){
        return folder;
    }

    public void addChild (Node node){
        node.setLevel(level + 1);
        children.add(node);
    }

    public ArrayList<Node> getChildren (){
        return children;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public String toString (){
        StringBuilder bilder = new StringBuilder();
        String size = SizeCalculator.getHumanRedableSize(getSize());
        bilder.append(folder.getName() + " - " + size + "\n");
        for (Node child : children){
            bilder.append("  " + child.toString());
        }
        return bilder.toString();
    }
}
