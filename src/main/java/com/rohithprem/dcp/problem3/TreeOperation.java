package com.rohithprem.dcp.problem3;

/**
 * Daily Coding Problem: Problem #3 [Medium]
 * This problem was asked by Google.
 * <p>
 * Given the root to a binary tree, implement serialize(root),
 * which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.
 * <p>
 * For example, given the following Node class
 * <p>
 * class Node:
 * def __init__(self, val, left=None, right=None):
 * self.val = val
 * self.left = left
 * self.right = right
 * The following test should pass:
 * <p>
 * node = Node('root', Node('left', Node('left.left')), Node('right'))
 * assert deserialize(serialize(node)).left.left.val == 'left.left'
 */

public class TreeOperation {

    /**
     * Example Tree
     *
     *                                          |root|
     *                                         /      \
     *                                     |left|       |right|
     *                                    /    \               \
     *                        |left.left|   |left.right|        |right.right|
     *                                                 \
     *                                               |left.right.right|
     */

    /**
     * Serialization: root,left,left.left,null,null,left.right,null,left.right.right,null,null,right,null,right.right
     */

    static final String ROOT_NODE_VALUE = "root";
    static final String LEFT_NODE_VALUE = "left";
    static final String RIGHT_NODE_VALUE = "right";
    static final String NODE_VALUE_SEPARATOR = ",";
    static final String NODE_DEADEND = "null";

    private static class NodeBuilderObject{

        Problem3Node builtNode;
        int finalIndex;

        public NodeBuilderObject(Problem3Node builtNode, int finalIndex) {
            this.builtNode = builtNode;
            this.finalIndex = finalIndex;
        }

        public Problem3Node getBuiltNode() {
            return builtNode;
        }

        public int getFinalIndex() {
            return finalIndex;
        }
    }

    //TODO: Need to figure out how to remove extra comma
    public static String serialize(Problem3Node node){
        StringBuilder stringBuilder = new StringBuilder();
        if(node != null){
            stringBuilder.append(NODE_VALUE_SEPARATOR + node.getValue());
            stringBuilder.append(serialize(node.getLeft()));
            stringBuilder.append(serialize(node.getRight()));
        } else {
            stringBuilder.append(NODE_VALUE_SEPARATOR + NODE_DEADEND);
        }
        return stringBuilder.toString();
    }

    public static Problem3Node deserialize(String nodeString){
        String[] nodeValues = nodeString.split(NODE_VALUE_SEPARATOR);
        NodeBuilderObject response = buildNodes(nodeValues, 0);
        return response.getBuiltNode();
    }

    private static NodeBuilderObject buildNodes(String[] nodeValues, int startIndex){
        Problem3Node node = new Problem3Node(nodeValues[startIndex]);
        int leftValueIndex = startIndex + 1;
        int rightValueIndex = leftValueIndex + 1;
        String leftValue = nodeValues[leftValueIndex];
        if(!leftValue.equals(NODE_DEADEND)){
            NodeBuilderObject leftNodeDetails = buildNodes(nodeValues, leftValueIndex);
            node.setLeft(leftNodeDetails.getBuiltNode());
            rightValueIndex = leftNodeDetails.getFinalIndex() + 1;
        }
        String rightValue = nodeValues[rightValueIndex];
        int finalIndex = rightValueIndex;
        if(!rightValue.equals(NODE_DEADEND)){
            NodeBuilderObject rightNodeDetails = buildNodes(nodeValues, rightValueIndex);
            node.setRight(rightNodeDetails.getBuiltNode());
            finalIndex = rightNodeDetails.getFinalIndex();
        }
        NodeBuilderObject response = new NodeBuilderObject(node, finalIndex);
        return response;
    }


}
