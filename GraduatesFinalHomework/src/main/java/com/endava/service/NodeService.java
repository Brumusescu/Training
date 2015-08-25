package com.endava.service;

import com.endava.entity.NodeEntity;
import java.util.List;
import java.util.Map;

public interface NodeService {
    void addRootNode (String nodeId, Map<String, Object> configuration);

    void addNode (String nodeId, String parentId, Map<String, Object> configuration);

    NodeEntity getNodeById(String nodeId);

    NodeEntity getParent (String nodeId);

    NodeEntity getRoot();

    List<String> getChildren(String nodeId);

    List<NodeEntity> getAllNodes();

    void updateConfiguration (String nodeId, Map<String, Object> configuration);

    void updateConfigurationForParentNode (String parentId, Map<String, Object> config);

    void updateParent (String nodeId, String newParentId);

    void removeNode (String nodeId);

    Map<String, Object> fetchNodeByStrategy (String nodeId, String strategy);
}
