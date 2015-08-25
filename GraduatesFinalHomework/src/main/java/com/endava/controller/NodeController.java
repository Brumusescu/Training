package com.endava.controller;


import com.endava.entity.NodeEntity;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface NodeController {
    ResponseEntity<String> addRootNode(String nodeId, String json);
    ResponseEntity<String> addNode(String nodeId, String parentId, String json);
    ResponseEntity<NodeEntity> getRoot();
    ResponseEntity<NodeEntity> getNodeById(String id);
    ResponseEntity<NodeEntity> getParent(String id);
    ResponseEntity<List<String>> getChildren(String id);
    ResponseEntity<List<NodeEntity>> getChildren();
    ResponseEntity<String> updateConfiguration(String id, String json);
    ResponseEntity<String> updateParent(String idNode, String idParent);
    ResponseEntity<String> updateConfigurationForParentNode(String parentId, String json);
    ResponseEntity<String> removeNode(String id);
    ResponseEntity<String> fetchNodeByStrategy(String id, String strategy);
}
