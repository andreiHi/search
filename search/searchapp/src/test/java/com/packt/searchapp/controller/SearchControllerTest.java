package com.packt.searchapp.controller;

import com.packt.searchapp.domain.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 07.01.2019.
 * @version $Id$.
 * @since 0.1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SearchControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testBasicSearch() {
        final Topic[] topics = this.restTemplate.getForObject("/topics?searchString=Spring", Topic[].class);
        for (Topic topic : topics) {
            assertNotNull(topic.getName());
        }
    }
}
