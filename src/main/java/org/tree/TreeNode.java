package org.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int id;
    public TreeNode parent;
    public List<TreeNode> children = new ArrayList<TreeNode>();

    public TreeNode(int id, TreeNode parent){
        this.id = id;
        this.parent = parent;
    }

    public TreeNode(int id){
        this.id = id;
    }

    public void setParent(TreeNode node){
        this.parent = node;
    }

    public int getId(){

        return this.id;
    }

    public TreeNode getParent(){

        return this.parent;
    }

    public List<TreeNode> getChildren(){

        return this.children;
    }

    public boolean isRoot(){
        return this.id == this.parent.getId();
    }

    public boolean isLeaf(){
        return this.children.isEmpty();
    }

    public void addChild(TreeNode node){
        this.children.add(node);
    }
}
