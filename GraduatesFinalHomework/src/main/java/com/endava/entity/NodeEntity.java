package com.endava.entity;

import org.jongo.marshall.jackson.oid.MongoId;

import java.util.*;

public class NodeEntity {
    @MongoId
    private String _id;
    private String parentId;
    private List<String> children;
    private Map<String, Object> configuration = new HashMap<String, Object>();

    public NodeEntity(String _id) {
        this._id = _id;
    }

    public NodeEntity() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public void addChild (String child) {
        this.children.add(child);
    }

    public void removeChild (NodeEntity parent, String child) {
        Iterator<String> iterator = parent.getChildren().iterator();
        while (iterator.hasNext()) {
            String childFound = iterator.next();
            if (childFound.equals(child)) {
                iterator.remove();
            }
        }
    }

    public Map<String, Object> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Map<String, Object> config) {
        this.configuration = config;
    }

    public String toString() {
        return ("Node:" + "\n" +
                "[id: " + _id + "\n" +
                "parentId: " + parentId + "\n" +
                "Children: " + children + "\n" +
                "Configuration: " + getConfiguration() + "\n" +
                "]");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeEntity that = (NodeEntity) o;
        return Objects.equals(_id, that._id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id);
    }
}
