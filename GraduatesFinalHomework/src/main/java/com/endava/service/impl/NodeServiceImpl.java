package com.endava.service.impl;

import com.endava.dao.NodeDAO;
import com.endava.entity.NodeEntity;
import com.endava.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NodeServiceImpl implements NodeService {
    protected static final String STRATEGY_TOP = "top";
    protected static final String STRATEGY_BOTTOM = "bottom";

    private final NodeDAO nodeDAO;

    @Autowired
    public NodeServiceImpl(NodeDAO nodeDAO) {
        this.nodeDAO = nodeDAO;
    }

    private void deleteNodes (String nodeId) {
        NodeEntity node = nodeDAO.getNodeById(nodeId);
        if (node != null && !node.getChildren().isEmpty()) {
            for (String child : node.getChildren()) {
                deleteNodes(child);
            }
        }
        nodeDAO.deleteNode(node.getId());
    }

    public void addRootNode (String nodeId, Map<String, Object> configuration) {
        NodeEntity node = new NodeEntity();
        node.setId(nodeId);
        node.setParentId("-1");
        node.setChildren(new ArrayList<String>());
        node.setConfiguration(configuration);

        try {
            nodeDAO.saveNode(node);
        }
        catch (Exception e) {
            System.out.println("Could not add root!");
            nodeDAO.deleteNode(node.getId());
        }
    }

    public void addNode (String nodeId, String parentId, Map<String, Object> configuration) {
        NodeEntity node = new NodeEntity();
        node.setId(nodeId);
        node.setParentId(parentId);
        node.setChildren(new ArrayList<String>());
        node.setConfiguration(configuration);

        try {
            nodeDAO.saveNode(node);
            NodeEntity parent = nodeDAO.getNodeById(node.getParentId());
            parent.addChild(node.getId());
            nodeDAO.saveNode(parent);
        }
        catch (Exception e) {
            nodeDAO.deleteNode(node.getId());
            System.out.println("Could not add node!");
        }

    }

    public NodeEntity getRoot(){
        return nodeDAO.getRootNode();
    }

    public NodeEntity getNodeById(String nodeId) {
        try {
            return nodeDAO.getNodeById(nodeId);
        }
        catch (Exception e) {
            System.out.println("Could not get node by id!");
            return null;
        }
    }

    public NodeEntity getParent (String nodeId) {
        return getNodeById(getNodeById(nodeId).getParentId());
    }

    public List<String> getChildren(String nodeId) {
        return getNodeById(nodeId).getChildren();
    }

    public List<NodeEntity> getAllNodes(){
        return nodeDAO.getAllNodes();
    }

    public void updateConfiguration (String nodeId, Map<String, Object> configuration) {
        NodeEntity node = getNodeById(nodeId);
        node.setConfiguration(configuration);
        nodeDAO.saveNode(node);
    }

    public void updateParent (String nodeId, String newParentId) {
        NodeEntity node = getNodeById(nodeId);

        //add node to new parent's children list:
        NodeEntity newParentNode = nodeDAO.getNodeById(newParentId);
        newParentNode.addChild(nodeId);
        nodeDAO.saveNode(newParentNode);

        //remove node from old parent's children list:
        NodeEntity oldParentNode = nodeDAO.getNodeById(nodeId);
        oldParentNode.removeChild(oldParentNode, nodeId);
        nodeDAO.saveNode(oldParentNode);

        //change node's current parentId:
        node.setParentId(newParentId);
        nodeDAO.saveNode(node);
    }

    public void updateConfigurationForParentNode (String parentId, Map<String, Object> config) {
        NodeEntity parentNode = getNodeById(parentId);
        List<String> nodesToConfigure = parentNode.getChildren();
        for (String currentNode : nodesToConfigure) {
            NodeEntity nodeToConfigure = getNodeById(currentNode);
            nodeToConfigure.setConfiguration(config);
            nodeDAO.saveNode(nodeToConfigure);
        }
    }

    public void removeNode (String nodeId){
        NodeEntity node = getNodeById(nodeId);
        if (node.getParentId() != null) {
            NodeEntity parent = getParent(nodeId);
            node.removeChild(parent, nodeId);
            nodeDAO.saveNode(parent);
        }
        deleteNodes(nodeId);
    }

    public Map<String, Object> fetchNodeByStrategy (String nodeId, String strategy) {
        NodeEntity currentNode = getNodeById(nodeId);
        Map<String, Object> finalConfiguration = new HashMap<String, Object>();

        List <String> nodeList = new ArrayList<String>();
        while (!"-1".equalsIgnoreCase(currentNode.getParentId())) {
            nodeList.add(currentNode.getId());
            currentNode = getNodeById(currentNode.getParentId());
        }
        nodeList.add(getRoot().getId());

        if (STRATEGY_TOP.equalsIgnoreCase(strategy)) {
            for (int i = 0; i < nodeList.size(); i++) {
                finalConfiguration.putAll(getNodeById(nodeList.get(i)).getConfiguration());
            }
        }
        else {
            if (STRATEGY_BOTTOM.equalsIgnoreCase(strategy)) {
                for (int i = nodeList.size() - 1; i >= 0; i--) {
                    finalConfiguration.putAll(getNodeById(nodeList.get(i)).getConfiguration());
                }
            }
            else {
                System.out.println("Wrong configuration selected! <Top> or <Bottom> required!");
            }
        }

        return finalConfiguration;
    }
}
