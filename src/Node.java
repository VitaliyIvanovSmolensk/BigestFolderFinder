import java.io.File;
import java.util.ArrayList;

public class Node {
    private File folder;
    private ArrayList<Node> children;
    private long size;
    private int level;
    private long limit;

    public Node (File folder, long limit){
        this.folder = folder;
        this.limit = limit;
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

    public long getLimit() {
        return limit;
    }

    public ArrayList<Node> getChildren (){
        return children;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public String toString (){
        StringBuilder bilder = new StringBuilder();
        String size = SizeCalculator.getHumanRedableSize(getSize());
        bilder.append(folder.getName() + " - " + size + "\n");
        for (Node child : children){
            if (child.getSize() < limit){
                continue;
            }
           String tab ="";
            for ( int i= 0; i < child.getLevel();i++){
                tab = tab + "   ";
            }
            bilder.append(tab + child.toString());
        }
        return bilder.toString();
    }
}
