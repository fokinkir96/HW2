package org.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeList {
    public List<Tree> trees = new ArrayList<Tree>();
    public TreeList(List<ArrayList<Integer>> data){
        List<ArrayList<Integer>> notInTrees = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> row : data){

            if (row.get(0).equals(row.get(1))){
                TreeNode root = new TreeNode(row.get(0));
                root.setParent(root);
                this.trees.add(new Tree(row.get(0), root));
            }
            else {
                notInTrees.add(row);
            }
        }
        while(!notInTrees.isEmpty()){
            boolean inTree = false;
            ArrayList<Integer> firstNode = notInTrees.remove(0);
            for (Tree tree : trees){
                TreeNode parentNode = tree.getNodeById(firstNode.get(1));
                if (parentNode != null){
                    parentNode.addChild(new TreeNode(firstNode.get(0), parentNode));
                    inTree = true;
                    break;
                }
            }
            if(!inTree) {
                notInTrees.add(firstNode);
            }
        }
    }

    public int getLeafsSum(){
        return this.trees.stream().mapToInt(tree -> tree.getLeafs().size()).sum();
    }
}
