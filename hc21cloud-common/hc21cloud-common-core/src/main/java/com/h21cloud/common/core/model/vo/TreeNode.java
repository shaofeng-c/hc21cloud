package com.h21cloud.common.core.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 树形结构节点
 *
 * @author shaofeng
 */
public class TreeNode implements Serializable {

    private static final long serialVersionUID = 1519279303737602623L;
    /**
     * 节点唯一标识
     */
    private Long id;
    /**
     * 父节点唯一标识
     */
    private Long parentId;
    /**
     * 节点标签名字
     */
    private String label;
    /**
     * 节点是否选中
     */
    private Boolean checked = false;
    /**
     * 是否拥有子节点
     */
    private Boolean hasLeaf = false;
    /**
     * 子节点
     */
    private List<TreeNode> children;

    public void add(TreeNode node) {
        children.add(node);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public Boolean getHasLeaf() {
        return hasLeaf;
    }

    public void setHasLeaf(Boolean hasLeaf) {
        this.hasLeaf = hasLeaf;
    }
}
