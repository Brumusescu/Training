package com.endava.service.impl;

import com.endava.dao.impl.NodeDAOImpl;
import com.endava.entity.NodeEntity;
import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

public class TestNodeServiceImpl {
    private NodeServiceImpl underTest;
    private NodeDAOImpl nodeDAO = mock(NodeDAOImpl.class);
    private Map<String, Object> configuration;
    private Map<String, Object> configurationUnderParentMap = new HashMap<String, Object>();
    private List<NodeEntity> allNodes = new ArrayList<NodeEntity>();
    private NodeEntity savedNode = null;

    NodeEntity root = new NodeEntity();
    NodeEntity node1 = new NodeEntity();
    NodeEntity node2 = new NodeEntity();
    NodeEntity node3 = new NodeEntity();
    NodeEntity node4 = new NodeEntity();

    @Before
    public void setUp() throws Exception {
        underTest = new NodeServiceImpl(nodeDAO);

        root.setId("1");
        root.setParentId("-1");
        configuration = new HashMap<String, Object>();
        configuration.put("c1", 2);
        configuration.put("c3", 4);
        root.setConfiguration(configuration);
        root.setChildren(new ArrayList<String>(Arrays.asList("2", "3", "4")));

        node1.setId("4");
        node1.setParentId("1");
        configuration = new HashMap<String, Object>();
        configuration.put("c5", 1);
        node1.setConfiguration(configuration);
        node1.setChildren(new ArrayList<String>(Arrays.asList("7", "8", "9")));

        node2.setId("8");
        node2.setParentId("4");
        configuration = new HashMap<String, Object>();
        configuration.put("c3", 1);
        configuration.put("c4", 2);
        configuration.put("c7", 3);
        node2.setConfiguration(configuration);
        node2.setChildren(new ArrayList<String>(Arrays.asList("10", "11")));

        node3.setId("11");
        node3.setParentId("8");
        configuration = new HashMap<String, Object>();
        node3.setConfiguration(configuration);
        node3.setChildren(new ArrayList<String>());

        node4.setId("10");
        node4.setParentId("8");
        configuration = new HashMap<String, Object>();
        node4.setConfiguration(configuration);
        node4.setChildren(new ArrayList<String>());

        allNodes.add(root);
        allNodes.add(node1);
        allNodes.add(node2);
        allNodes.add(node3);

        when(nodeDAO.getRootNode()).thenReturn(root);

        when(nodeDAO.getNodeById(eq("1"))).thenReturn(root);
        when(nodeDAO.getNodeById(eq("4"))).thenReturn(node1);
        when(nodeDAO.getNodeById(eq("8"))).thenReturn(node2);
        when(nodeDAO.getNodeById(eq("11"))).thenReturn(node3);
        when(nodeDAO.getNodeById(eq("10"))).thenReturn(node4);

        when(nodeDAO.getAllNodes()).thenReturn(allNodes);
        doAnswer(new Answer() {
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                savedNode = (NodeEntity)invocationOnMock.getArguments()[0];
                return null;
            }
        }).when(nodeDAO).saveNode(any(NodeEntity.class));

        configurationUnderParentMap.put("c7", 3);
    }

    @Test
    public void testGetRoot() {
        NodeEntity result = underTest.getRoot();
        NodeEntity expected = root;

        Assert.assertNotNull(result);
        Assert.assertEquals("Root not found!", expected, result);
        verify(nodeDAO,atLeastOnce()).getRootNode();
    }

    @Test
    public void testGetNodeByIdForExistingId () {
        NodeEntity result = underTest.getNodeById("8");
        NodeEntity expected = node2;

        Assert.assertNotNull(result);
        Assert.assertEquals("Wrong match by id!", expected, result);
        verify(nodeDAO,atLeastOnce()).getNodeById(eq("8"));
    }

    @Test
    public void testGetNodeByIdForMissingId () {
        NodeEntity result = underTest.getNodeById("20");

        Assert.assertTrue(result == null);
    }

    @Test
    public void testGetParent () {
        NodeEntity result = underTest.getParent("8");
        NodeEntity expected = node1;

        Assert.assertEquals("Not expected parent!", expected, result);
    }

    @Test
    public void testGetChildren () {
        List<String> result = underTest.getChildren("8");
        List<String> expected = Arrays.asList("10", "11");

        Assert.assertNotNull(result);
        Assert.assertEquals("Not expected children!", expected, result);
    }

    @Test
    public void testGetAllNodes() {
        List<NodeEntity> result = underTest.getAllNodes();
        List<NodeEntity> expected = new ArrayList<NodeEntity>();
        expected.add(root);
        expected.add(node1);
        expected.add(node2);
        expected.add(node3);

        Assert.assertNotNull(result);
        Assert.assertEquals("Not expected list!", expected, result);
    }

    @Test
    public void testUpdateConfiguration () {
        underTest.updateConfiguration("8", configurationUnderParentMap);
        Assert.assertNotNull(savedNode);
        Assert.assertEquals("8", savedNode.getId());
        Assert.assertEquals(configurationUnderParentMap, savedNode.getConfiguration());

        verify(nodeDAO, times(1)).saveNode(any(NodeEntity.class));
    }

    @Test
    public void testUpdateParent () {
        underTest.updateParent("11", "4");
        Assert.assertNotNull(savedNode);
        Assert.assertEquals("4", savedNode.getParentId());
        Assert.assertEquals("11", savedNode.getId());
    }

    @Test
    public void testUpdateConfigurationForParentNode () {
        underTest.updateConfigurationForParentNode("8", configurationUnderParentMap);
        Assert.assertNotNull(savedNode);
        Assert.assertEquals(configurationUnderParentMap, savedNode.getConfiguration());
        Assert.assertEquals("11", savedNode.getId());
    }

    @Test
    public void testFetchNodeByStrategyForTopStrategy() throws Exception {
        Map<String,Object> result = underTest.fetchNodeByStrategy("11",NodeServiceImpl.STRATEGY_TOP);

        Map<String,Object> expected = new HashMap<String,Object>();
        expected.put("c7", 3);
        expected.put("c4", 2);
        expected.put("c5", 1);
        expected.put("c3", 4);
        expected.put("c1", 2);

        //assert junit:
        Assert.assertNotNull(result);
        Assert.assertEquals("Not expected!", expected, result);

        verify(nodeDAO,atLeastOnce()).getNodeById(eq("11"));
        verify(nodeDAO, never()).deleteNode(anyString());
    }

    @Test
    public void testFetchNodeByStrategyForBottomStrategy() throws Exception {
        Map<String,Object> result = underTest.fetchNodeByStrategy("11", NodeServiceImpl.STRATEGY_BOTTOM);

        Map<String,Object> expected = new HashMap<String,Object>();
        expected.put("c7", 3);
        expected.put("c4", 2);
        expected.put("c5", 1);
        expected.put("c3", 1);
        expected.put("c1", 2);

        //assert junit:
        Assert.assertNotNull(result);
        Assert.assertEquals("Not expected!", expected, result);

        verify(nodeDAO,atLeastOnce()).getNodeById(eq("11"));
        verify(nodeDAO, never()).deleteNode(anyString());
    }
}