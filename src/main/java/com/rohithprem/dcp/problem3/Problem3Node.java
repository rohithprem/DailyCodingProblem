package com.rohithprem.dcp.problem3;

public class Problem3Node {

    protected String value;
    protected Problem3Node left;
    protected Problem3Node right;

    public Problem3Node(String value, Problem3Node left, Problem3Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Problem3Node(String value) {
        this(value, null, null);
    }

    public Problem3Node(String value, Problem3Node left) {
        this(value, left, null);
    }

    public Problem3Node getLeft() {
        return this.left;
    }

    public Problem3Node getRight() {
        return this.right;
    }

    public void setLeft(Problem3Node left) {
        this.left = left;
    }

    public void setRight(Problem3Node right) {
        this.right = right;
    }

    public String getValue() {
        return this.value;
    }

}
