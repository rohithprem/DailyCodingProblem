package com.rohithprem.dcp.problem3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

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
        StringBuilder stringBuilder = buildSerializedString(node);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    private static StringBuilder buildSerializedString(Problem3Node node){
        StringBuilder stringBuilder = new StringBuilder();
        if(node != null){
            stringBuilder.append(node.getValue());
            stringBuilder.append(NODE_VALUE_SEPARATOR);
            stringBuilder.append(buildSerializedString(node.getLeft()));
            stringBuilder.append(buildSerializedString(node.getRight()));
        } else {
            stringBuilder.append(NODE_DEADEND);
            stringBuilder.append(NODE_VALUE_SEPARATOR);
        }
        return stringBuilder;
    }

    public static Problem3Node deserialize(String nodeString){
        String[] nodeValues = nodeString.split(NODE_VALUE_SEPARATOR);
        Queue<String> nodeValuesQueue = new ArrayDeque<>(Arrays.asList(nodeValues));
        return buildNodes(nodeValuesQueue);
    }

    private static Problem3Node buildNodes(Queue<String> nodeValues){
        Problem3Node node = null;
        String currentValue = nodeValues.poll();
        if(currentValue != null && !currentValue.equals(NODE_DEADEND)){
            node = new Problem3Node(currentValue);
            node.setLeft(buildNodes(nodeValues));
            node.setRight(buildNodes(nodeValues));
        }
        return node;
    }


}
