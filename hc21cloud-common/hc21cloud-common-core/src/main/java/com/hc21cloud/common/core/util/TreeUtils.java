package com.hc21cloud.common.core.util;


import com.hc21cloud.common.base.model.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形结构生成工具类
 *
 * @author shaofeng
 */
public class TreeUtils {
    /**
     * 两层循环实现建树
     *
     * @param treeNodes 传入的树节点列表
     * @return
     */
    public static <T extends TreeNode> List<T> bulid(List<T> treeNodes, Long root) {
        List<T> trees = new ArrayList<>();
        for (T treeNode : treeNodes) {
            if (root.equals(treeNode.getParentId())) {
                trees.add(treeNode);
            }
            for (T it : treeNodes) {
                if (it.getParentId().equals(treeNode.getId())) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<>());
                    }
                    treeNode.add(it);
                }
            }
            if (treeNode.getChildren() != null && treeNode.getChildren().size() > 0) {
                treeNode.setHasLeaf(true);
            }
        }
        return setChecked(trees);
    }

    /**
     * 使用递归方法建树
     *
     * @param treeNodes
     * @return
     */
    public static <T extends TreeNode> List<T> buildByRecursive(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<T>();
        for (T treeNode : treeNodes) {
            if (root.equals(treeNode.getParentId())) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    private static <T extends TreeNode> T findChildren(T treeNode, List<T> treeNodes) {
        for (T it : treeNodes) {
            if (treeNode.getId().equals(it.getParentId())) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<>());
                }
                treeNode.add(findChildren(it, treeNodes));
            }
        }
        if (treeNode.getChildren() != null && treeNode.getChildren().size() > 0) {
            treeNode.setHasLeaf(true);
        }
        return treeNode;
    }

    /**
     * 递归设置选中值
     *
     * @param treeNodes
     * @return
     */
    private static <T extends TreeNode> List<T> setChecked(List<T> treeNodes) {
        for (T it : treeNodes) {
            boolean checked = true;
            if (it.getChildren() != null && it.getChildren().size() > 0) {
                List<TreeNode> childNodes = it.getChildren();
                for (TreeNode treeNode : childNodes) {
                    if (treeNode.getChildren() != null && treeNode.getChildren().size() > 0) {
                        setChecked(childNodes);
                    }
                    if (!treeNode.getChecked()) {
                        checked = false;
                        break;
                    }
                }
                if (!checked) {
                    it.setChecked(false);
                }
            }
        }
        return treeNodes;
    }

}
