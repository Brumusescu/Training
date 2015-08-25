package com.endava.controller.impl;

import com.endava.controller.NodeController;
import com.endava.entity.NodeEntity;
import com.endava.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;

@RestController
public class NodeControllerImpl implements NodeController {
    private static final String STRATEGY_TOP = "top";
    private static final String STRATEGY_BOTTOM = "bottom";

    @Autowired
    private NodeService nodeService;

    @RequestMapping(path = "/addRootNode/{nodeId}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> addRootNode(@PathVariable String nodeId, @RequestBody String json){
        NodeEntity root = nodeService.getRoot();
        try {
            Map<String, Object> jsonMap = new ObjectMapper().readValue(json, Map.class);
            if (root != null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).<String>body("Error at adding root node node with id " + nodeId + " !");
            }
            else {
                nodeService.addRootNode(nodeId, jsonMap);
                return ResponseEntity.ok("Root node added successfully!");
            }
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).<String>body(e.getMessage());
        }
    }

    @RequestMapping(path = "/addNode/{nodeId}/{parentId}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> addNode(@PathVariable String nodeId, @PathVariable String parentId, @RequestBody String json){
        NodeEntity node = nodeService.getNodeById(nodeId);
        try {
            Map<String, Object> jsonMap = new ObjectMapper().readValue(json, Map.class);
            if (node == null) {
                nodeService.addNode(nodeId, parentId, jsonMap);
                return ResponseEntity.ok("Node added successfully!");
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).<String>body("Error at adding node node with id " + nodeId + " !");
            }
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).<String>body(e.getMessage());
        }
    }

    @RequestMapping(path = "/getRoot", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<NodeEntity> getRoot(){
        NodeEntity node = nodeService.getRoot();
        if(node!=null) {
            return ResponseEntity.ok(nodeService.getRoot());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).<NodeEntity>body(new NodeEntity("NOT_EXISTS"));
        }
    }

    @RequestMapping(path = "/getNodeById/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<NodeEntity> getNodeById(@PathVariable String id){
        NodeEntity node = nodeService.getNodeById(id);
        if(node!=null) {
            return ResponseEntity.ok(nodeService.getNodeById(id));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).<NodeEntity>body(new NodeEntity("NOT_EXISTS"));
        }
    }

    @RequestMapping(path = "/getParent/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<NodeEntity> getParent(@PathVariable String id){
        NodeEntity node = nodeService.getParent(id);
        if(node!=null) {
            return ResponseEntity.ok(nodeService.getParent(id));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).<NodeEntity>body(new NodeEntity("NOT_EXISTS"));
        }
    }

    @RequestMapping(path = "/getChildren/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<String>> getChildren(@PathVariable String id){
        List<String> nodeList = nodeService.getChildren(id);
        if(nodeList!=null) {
            return ResponseEntity.ok(nodeService.getChildren(id));
        }
        else {
            nodeList.add("NOT_EXISTS");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).<List<String>>body(nodeList);
        }
    }

    @RequestMapping(path = "/getAllNodes", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<NodeEntity>> getChildren(){
        List<NodeEntity> nodeList = nodeService.getAllNodes();
        if(nodeList!=null) {
            return ResponseEntity.ok(nodeService.getAllNodes());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).<List<NodeEntity>>body(nodeList);
        }
    }

    @RequestMapping(path = "/updateConfiguration/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<String> updateConfiguration(@PathVariable String id, @RequestBody String json){
        try {
            Map<String, Object> jsonMap = new ObjectMapper().readValue(json, Map.class);
            NodeEntity node = nodeService.getNodeById(id);
            if (node != null) {
                nodeService.updateConfiguration(id, jsonMap);
                return ResponseEntity.ok("Node updated successfully!");
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).<String>body("Error at updating node with id " + id + " !");
            }
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).<String>body(e.getMessage());
        }
    }

    @RequestMapping(path = "/updateParent/{idNode}/{idParent}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<String> updateParent(@PathVariable String idNode, @PathVariable String idParent){
        NodeEntity node = nodeService.getNodeById(idNode);
        if(node != null) {
            nodeService.updateParent(idNode, idParent);
            return ResponseEntity.ok("Node updated successfully!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).<String>body("Error at updating node with id " + idNode + " !");
        }
    }

    @RequestMapping(path = "/updateConfigurationForParentNode/{parentId}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<String> updateConfigurationForParentNode(@PathVariable String parentId, @RequestBody String json){
        try {
            Map<String, Object> jsonMap = new ObjectMapper().readValue(json, Map.class);
            NodeEntity node = nodeService.getNodeById(parentId);

            if (node != null) {
                nodeService.updateConfigurationForParentNode(parentId, jsonMap);
                return ResponseEntity.ok("Children configuration updated successfully!");
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).<String>body("Error at updating children configuration with id " + parentId + " !");
            }
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).<String>body(e.getMessage());
        }
    }

    @RequestMapping(path = "/removeNode/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<String> removeNode(@PathVariable String id){
        NodeEntity node = nodeService.getNodeById(id);
        if(node != null) {
            nodeService.removeNode(id);
            return ResponseEntity.ok("Node removed successfully!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).<String>body("Error at removing node with id " + id + " !");
        }
    }

    @RequestMapping(path = "/fetchNodeByStrategy/{id}/{strategy}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> fetchNodeByStrategy(@PathVariable String id, @PathVariable String strategy){
        NodeEntity node = nodeService.getNodeById(id);
        if(STRATEGY_TOP.equalsIgnoreCase(strategy) || STRATEGY_BOTTOM.equalsIgnoreCase(strategy)) {
            if (node != null) {
                return ResponseEntity.ok(nodeService.fetchNodeByStrategy(id, strategy).toString());
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).<String>body("Node with id " + id + " not found!");
            }
        }
        else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).<String>body("Wrong configuration selected! <Top> or <Bottom> required!");
        }
    }
}
