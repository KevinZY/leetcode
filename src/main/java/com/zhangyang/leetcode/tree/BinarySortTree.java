package com.zhangyang.leetcode.tree;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created by zhangyang on 2018/12/4.
 */
public class BinarySortTree {

    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();
    }

    private Node root;

    public Node find(int data) {
        Node p = root;
        while (p != null && (data != p.data)) {
            if (data > p.data) {
                p = p.rightChild;
            } else if (data < p.data) {
                p = p.leftChild;
            }
        }
        return p;
    }

    public void add(int data) {
        if (root == null) {
            root = Node.of(data);
            return;
        }
        Node p = root;
        while (p != null && data != p.data) {
            if (data > p.data) {
                if ((p.rightChild != null)) {
                    p = p.rightChild;
                } else {
                    p.rightChild = Node.of(data);
                    return;
                }
            } else if (data < p.data) {
                if (p.leftChild != null) {
                    p = p.leftChild;
                } else {
                    p.leftChild = Node.of(data);
                    return;
                }
            }
        }
        if (p != null) {
            while (p.next != null) {
                p = p.next;
            }
            p.next = Node.of(data);
        }
    }

    public void remove(int data) {
        Node p = root, parent = null;
        if (p == null) return;
        while (p != null && (p.data != data)) {
            parent = p;
            if (data > p.data) {
                p = p.rightChild;
            } else if (data < p.data) {
                p = p.leftChild;
            }
        }

        //要删除的节点左右都有子节点
        if (p.leftChild != null && p.rightChild != null) {
            Node minP = p.rightChild;
            Node minPP = p;
            while (minP.leftChild!=null){
                minPP = minP;
                minP = minP.leftChild;
            }
        }
    }

    public void print() {

    }

    @Data
    @RequiredArgsConstructor(staticName = "of")
    public static class Node {
        @NonNull
        int data;
        Node leftChild;
        Node rightChild;
        Node next;
    }
}
