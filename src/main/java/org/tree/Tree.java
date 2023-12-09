package org.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    public int id;
    public TreeNode root;

    public Tree(int id, TreeNode root){
        this.id = id;
        this.root = root;
    }

    public TreeNode getRoot(){
        return this.root;
    }

    public List<TreeNode> getNodes(){
//        List<TreeNode> nodes;
        var nodes = new ArrayList<TreeNode>();
        var list = new ArrayList<TreeNode>();
        list.add(this.root);

        while (!list.isEmpty()){
            TreeNode removed = list.remove(0);
            nodes.add(removed);
            list.addAll(removed.getChildren());
        }
        return nodes;
    }

    public List<TreeNode> getLeafs(){
        return this.getNodes().stream().filter(TreeNode::isLeaf).toList();
    }

    public TreeNode getNodeById(int id){
        for(TreeNode node : this.getNodes()){
            if (node.getId() == id)
                return node;
        }

        return null;
    }
}
