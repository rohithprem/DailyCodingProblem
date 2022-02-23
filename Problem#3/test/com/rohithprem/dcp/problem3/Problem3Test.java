package com.rohithprem.dcp.problem3;

import com.sun.source.tree.Tree;
import org.junit.Assert;
import org.junit.Test;

/**
 * Given the root to a binary tree, implement serialize(root),
 * which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.
 *
 * For example, given the following Node class
 *
 * class Node:
 *     def __init__(self, val, left=None, right=None):
 *         self.val = val
 *         self.left = left
 *         self.right = right
 * The following test should pass:
 *
 * node = Node('root', Node('left', Node('left.left')), Node('right'))
 * assert deserialize(serialize(node)).left.left.val == 'left.left'
 */

public class Problem3Test {

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


    @Test
    public void testSerialization(){
        Problem3Node rightRight = new Problem3Node("right.right");
        Problem3Node right = new Problem3Node("right", null, rightRight);
        Problem3Node leftLeft = new Problem3Node("left.left");
        Problem3Node leftrightright = new Problem3Node("left.right.right");
        Problem3Node leftRight = new Problem3Node("left.right", null, leftrightright);
        Problem3Node left = new Problem3Node("left", leftLeft, leftRight);
        Problem3Node root = new Problem3Node("root", left, right);

        String serializedString = TreeOperation.serialize(root);
        String expected = "root,left,left.left,null,null,left.right,null,left.right.right,null,null,right,null,right.right,null,null";
        Assert.assertEquals(expected,serializedString);
    }

    @Test
    public void testDeSerialization(){
        final String TREE_SERIAlIZED = "root,left,left.left,null,null,left.right,null,left.right.right,null,null,right,null,right.right,null,null";
        Problem3Node root = TreeOperation.deserialize(TREE_SERIAlIZED);
        String serializedString = TreeOperation.serialize(root);
        Assert.assertEquals(TREE_SERIAlIZED,serializedString);
    }

    @Test
    public void testGivenExample(){
        Problem3Node givenNode = new Problem3Node("root", new Problem3Node("left", new Problem3Node("left.left")), new Problem3Node("right"));
        Assert.assertEquals(TreeOperation.deserialize(TreeOperation.serialize(givenNode)).getLeft().getLeft().getValue(), "left.left");
    }

    @Test
    public void testNull(){
        final String TREE_SERIAlIZED = null;
        Problem3Node root = TreeOperation.deserialize(TREE_SERIAlIZED);
        String serializedString = TreeOperation.serialize(root);
        Assert.assertEquals(TREE_SERIAlIZED,serializedString);
    }

    @Test
    public void testEmptyRoot(){
        final String TREE_SERIAlIZED = "root,null,null";
        Problem3Node root = TreeOperation.deserialize(TREE_SERIAlIZED);
        String serializedString = TreeOperation.serialize(root);
        Assert.assertEquals(TREE_SERIAlIZED,serializedString);
    }

    @Test
    public void testInvalid(){
        final String TREE_SERIAlIZED = "root,null";
        Problem3Node root = TreeOperation.deserialize(TREE_SERIAlIZED);
        String serializedString = TreeOperation.serialize(root);
        Assert.assertEquals("root,null,null",serializedString);
    }

}
