package org.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeList {
    public List<Tree> trees = new ArrayList<Tree>();
    public TreeList(List<ArrayList<Integer>> data){
        for(ArrayList<Integer> row : data){

            if (row.get(0).equals(row.get(1))){
                TreeNode root = new TreeNode(row.get(0));
                root.setParent(root);
                this.trees.add(new Tree(row.get(0), root));
            }
            else {
                for (Tree tree : this.trees){
                    TreeNode parentNode = tree.getNodeById(row.get(1));
                    if (parentNode != null){
                        parentNode.addChild(new TreeNode(row.get(0), parentNode));
                        break;
                    }
                }
            }
        }
    }

    public int getLeafsSum(){
        return this.trees.stream().mapToInt(tree -> tree.getLeafs().size()).sum();
    }
}
