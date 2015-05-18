package com.ilopezluna.services;

import com.ilopezluna.Application;
import org.apache.commons.collections.IteratorUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TeamServiceTest {

    @Autowired
    private TeamService teamService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {
        Iterable all = teamService.findAll();
        List list = IteratorUtils.toList(all.iterator());
        Assert.assertNotNull(list);
        Assert.assertEquals(0, list.size());
    }
}