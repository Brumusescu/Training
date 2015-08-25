package com.endava.dao;

import com.endava.entity.NodeEntity;
import org.jongo.MongoCollection;
import java.util.List;

public interface NodeDAO {
    MongoCollection getCollection();

    NodeEntity getNodeById (String _id);

    NodeEntity getRootNode ();

    List<NodeEntity> getAllNodes();

    void saveNode (NodeEntity node);

    void deleteNode (String _id);
}
