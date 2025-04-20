package com.prufercode;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Tree tree = genTree();
        System.out.println("Vertices: ");
        tree.getVertices().forEach(e -> System.out.print(e + " "));
        System.out.println();
        System.out.println("Edges: ");
        tree.getEdges().forEach(e -> System.out.println(String.format("[%d - %d]", e.first(), e.second())));

        ConvertEdgeListAlgorithm converter = new ConvertEdgeListAlgorithm(tree);
        converter.convertTreeToEdgeList();
        var convertionResult = converter.getResult();
        System.out.println(convertionResult);

        EulerTourBuilder eulerTourBuilder = new EulerTourBuilder(convertionResult);
        eulerTourBuilder.computeEulerTourBuilding();
        var eulerTourResult = eulerTourBuilder.getResult();
        System.out.println("Euler tour");
        System.out.println(eulerTourResult);

        ParentArrayBuilder parentArrayBuilder = new ParentArrayBuilder(tree, eulerTourResult);
        parentArrayBuilder.buildParentArray();
        var parentArray = parentArrayBuilder.getResult();
        System.out.println(parentArray);

        MaximumSubtreeValuesFinder maximumFinder = new MaximumSubtreeValuesFinder(parentArray);
        maximumFinder.computeMaximums();
        var maximumArray = maximumFinder.getResult();
        System.out.println(maximumArray);

        ChainTransform chainTransform = new ChainTransform(maximumArray.getMaximum(), parentArray.getParentArray());
        chainTransform.buildChainArray();
        var chainArray = chainTransform.getResult();
        System.out.println(chainArray);

        RankBuilder rankBuilder = new RankBuilder(chainArray);
        rankBuilder.buildRankArray();
        var rankArray = rankBuilder.getResult();
        System.out.println(rankArray);

        RemovalBuilder removalBuilder = new RemovalBuilder(maximumArray.getMaximum(), rankArray.getRankArray());
        removalBuilder.buildRemoval();
        var removalArray = removalBuilder.getResult();
        System.out.println(removalArray);

        PruferChainBuilder pruferBuilder = new PruferChainBuilder(removalArray.getRemovalArray(), parentArray.getParentArray());
        pruferBuilder.buildPruferCode();
        System.out.println("PRUFER CODE: ");
        System.out.println(Arrays.toString(pruferBuilder.getResult()));
    }

    public static Tree genTree(){
        Tree tree = new Tree(5);
        tree.addEdge(5, 4);
        tree.addEdge(4, 2);
        tree.addEdge(2, 1);
        tree.addEdge(2, 3);

        // Tree tree = new Tree(7);
        // tree.addEdge(7, 5);
        // tree.addEdge(7, 2);
        // tree.addEdge(2, 3);
        // tree.addEdge(5, 4);
        // tree.addEdge(5, 6);
        // tree.addEdge(5, 1);

        //Example tree
        // Tree tree = new Tree(33);
        // tree.addEdge(33, 8);
        // tree.addEdge(33, 7);
        // tree.addEdge(33, 30);
        // tree.addEdge(33, 21);
        // tree.addEdge(33, 20);

        // tree.addEdge(30, 24);
        // tree.addEdge(24, 29);
        // tree.addEdge(29, 17);
        // tree.addEdge(17, 13);
        // tree.addEdge(13, 16);
        // tree.addEdge(13, 10);

        // tree.addEdge(20, 14);
        // tree.addEdge(20, 31);
        // tree.addEdge(31, 25);
        // tree.addEdge(31, 5);
        // tree.addEdge(5, 12);
        // tree.addEdge(12, 26);

        // tree.addEdge(8, 28);
        // tree.addEdge(8, 3);
        // tree.addEdge(8, 23);

        // tree.addEdge(23, 11);
        // tree.addEdge(28, 15);
        // tree.addEdge(28, 9);
        // tree.addEdge(28, 27);
        // tree.addEdge(28, 22);
        // tree.addEdge(27, 6);
        // tree.addEdge(27, 1);

        // tree.addEdge(15, 32);
        // tree.addEdge(32, 4);
        // tree.addEdge(32, 18);
        // tree.addEdge(32, 19);
        // tree.addEdge(32, 2);
        return tree;
    }
}