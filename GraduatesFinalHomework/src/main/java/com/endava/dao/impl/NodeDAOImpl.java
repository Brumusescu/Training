package com.endava.dao.impl;

import com.endava.entity.NodeEntity;
import com.endava.dao.NodeDAO;
import org.apache.commons.collections.IteratorUtils;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class NodeDAOImpl implements NodeDAO {

    public static final String NODES = "nodes";

    @Autowired
    private Jongo dbConnection;

    public MongoCollection getCollection(){
        return dbConnection.getCollection(NODES);
    }

    public NodeEntity getNodeById (String _id){
        return getCollection().findOne("{_id : #}", _id).as(NodeEntity.class);
    }

    public NodeEntity getRootNode () {
        return getCollection().findOne("{parentId : #}", "-1").as(NodeEntity.class);
    }

    public List<NodeEntity> getAllNodes(){
        MongoCursor<NodeEntity> nodeList = getCollection().find().as(NodeEntity.class);
        return IteratorUtils.toList(nodeList);
    }

    public void saveNode (NodeEntity node){
        getCollection().save(node);
    }

    public void deleteNode (String _id){
        getCollection().remove("{_id : #}" , _id);
    }
}
