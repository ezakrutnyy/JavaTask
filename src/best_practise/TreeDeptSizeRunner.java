package best_practise;

import java.util.Objects;

/*
 * Посчитать глубины debt в двоичном дереве
 *
 * */
public class TreeDeptSizeRunner {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(13);

        TreeNode<Integer> parent = new TreeNode<>(7);
        parent.leftNode = new TreeNode<>(10);
        parent.rightNode = new TreeNode<>(15);

        TreeNode<Integer> parent2 = new TreeNode<>(7);
        parent2.leftNode = new TreeNode<>(10);
        parent2.rightNode = new TreeNode<>(15);

        root.leftNode = parent;
        root.rightNode = parent2;


//        System.out.println("Max dept: " + maxDept(root));
        System.out.println("Sum three recursive : " + sumThreeRecursive(root));
        System.out.println("Sum three by Stack (Обход в глубину): " + sumThreeByStack(root));
        System.out.println("Sum three by Queue (Обход в ширину): " + sumThreeByQueue(root));
//        System.out.println("IsEquals: " + isEquals(root));
//        System.out.println("IsSymetric: " + isSymetric(root));

    }


    public static <T extends Number> int maxDept(TreeNode<T> root) {
        if (root == null) return 0;

        int maxDebtLeftNode = maxDept(root.leftNode);
        int maxDebtRightNode = maxDept(root.rightNode);

        return maxDebtLeftNode > maxDebtRightNode ? maxDebtLeftNode + 1 : maxDebtRightNode + 1;
    }

    public static <T extends Number> boolean isEquals(TreeNode<T> root) {
        if (root == null) return false;

        return isEquals(root.leftNode, root.rightNode);
    }

    private static <T extends Number> boolean isEquals(TreeNode<T> leftNode, TreeNode<T> rightNode) {
        if (leftNode == null && rightNode == null) return true;

        return Objects.nonNull(leftNode) && Objects.nonNull(rightNode)
                && leftNode.value.equals(rightNode.value)
                && isEquals(leftNode.leftNode, rightNode.leftNode)
                && isEquals(leftNode.rightNode, rightNode.rightNode);
    }

    public static <T extends Number> boolean isSymetric(TreeNode<T> root) {
        if (root == null) return false;

        return isSymetric(root.leftNode, root.rightNode);
    }

    private static <T extends Number> boolean isSymetric(TreeNode<T> leftNode, TreeNode<T> rightNode) {
        if (leftNode == null && rightNode == null) return true;

        return Objects.nonNull(leftNode) && Objects.nonNull(rightNode)
                && leftNode.value.equals(rightNode.value)
                && isSymetric(leftNode.leftNode, rightNode.rightNode)
                && isSymetric(leftNode.rightNode, rightNode.leftNode);
    }

    public static int sumThreeRecursive(TreeNode<Integer> root) {
        if (root == null) return 0;

        return root.value + sumThreeRecursive(root.leftNode) + sumThreeRecursive(root.rightNode);
    }

    public static int sumThreeByStack(TreeNode<Integer> root) {
        int sum = 0;
        MyStack<TreeNode<Integer>> stack = new MyStack<>();
        stack.push(root);
        while (stack.peek() != null) {
            TreeNode<Integer> node = stack.pop();
            sum += node.value;
            if (node.leftNode != null) stack.push(node.leftNode);
            if (node.rightNode != null) stack.push(node.rightNode);
        }

        return sum;
    }

    public static int sumThreeByQueue(TreeNode<Integer> root) {
        int sum = 0;
        MyQueue<TreeNode<Integer>> queue = new MyQueue<>();
        queue.push(root);
        while (queue.peek() != null) {
            TreeNode<Integer> node = queue.pop();
            sum += node.value;
            if (node.leftNode != null) queue.push(node.leftNode);
            if (node.rightNode != null) queue.push(node.rightNode);
        }

        return sum;
    }
}


class TreeNode<T> {

    T value;

    TreeNode<T> leftNode;

    TreeNode<T> rightNode;

    public TreeNode(T value) {
        this.value = value;
    }
}
