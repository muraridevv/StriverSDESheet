package com.murari.striverheet.binarysearchtree2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerialiseAndDeserialise {

  public String serialize(TreeNode root) {
    // perform preorder traversal and enccode tree's structure into string
    StringBuilder result = new StringBuilder();
    serializeHelper(root, result);
    return result.toString();
  }

  private void serializeHelper(TreeNode node, StringBuilder result) {
    if (node == null) {
      result.append("#").append(",");
      return;
    }
    result.append(node.val).append(",");
    serializeHelper(node.left, result);
    serializeHelper(node.right, result);
  }

  public TreeNode deserialize(String data) {
    // From String, form the tree in preOrder traversal
    Queue<String> nodesValue = new LinkedList<>(Arrays.asList(data.split(",")));
    return deserializeHelper(nodesValue);
  }

  private TreeNode deserializeHelper(Queue<String> nodesValue) {
    String value = nodesValue.poll();
    if (value.equals("#")) return null;

    TreeNode node = new TreeNode(Integer.parseInt(value));
    node.left = deserializeHelper(nodesValue);
    node.right = deserializeHelper(nodesValue);

    return node;
  }

  public static void main(String[] args) {
    // Create a binary tree
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);

    // Create an instance of the Codec class
    SerialiseAndDeserialise codec = new SerialiseAndDeserialise();

    // Serialize the binary tree
    String serializedTree = codec.serialize(root);
    System.out.println("Serialized tree: " + serializedTree);

    // Deserialize the serialized string
    TreeNode deserializedRoot = codec.deserialize(serializedTree);

    // Print the original and deserialized trees
    System.out.println("Original tree: " + root);
    System.out.println("Deserialized tree: " + deserializedRoot);
  }
}
