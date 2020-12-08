package com.wondersgroup.excerpt;

import java.util.Date;

import com.wondersgroup.excerpt.index.UsersIndex;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2020/12/4 12:26
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest extends TestCase {
    @Autowired
    private ElasticsearchRestTemplate esTemplate;

    /**
     * 不建议使用 ElasticsearchTemplate 对索引进行管理（创建索引，更新映射，删除索引）
     * 索引就像是数据库或者数据库中的表，我们平时是不会是通过java代码频繁的去创建修改删除数据库或者表的
     * 我们只会针对数据做CRUD的操作
     * 在es中也是同理，我们尽量使用 ElasticsearchTemplate 对文档数据做CRUD的操作
     * 1. 属性（FieldType）类型不灵活
     * 2. 主分片与副本分片数无法设置
     */
    // 创建索引
    @Test
    public void createIndexStu() {
        UsersIndex usersIndex = new UsersIndex();
        usersIndex.setId("1");
        usersIndex.setUsername("22");
        usersIndex.setPassword("33");
        usersIndex.setNickname("44");
        usersIndex.setRealname("55");
        usersIndex.setFace("");
        usersIndex.setMobile("");
        usersIndex.setEmail("");
        usersIndex.setSex(0);
        usersIndex.setBirthday(new Date());
        usersIndex.setCreatedTime(new Date());
        usersIndex.setUpdatedTime(new Date());

        IndexQuery indexQuery = new IndexQueryBuilder().withObject(usersIndex).build();
        esTemplate.index(indexQuery,IndexCoordinates.of("usersindex"));
    }

    @Test
    public void addDoc(){
        UsersIndex usersIndex = new UsersIndex();
        usersIndex.setId("1");
        usersIndex.setUsername("22");
        usersIndex.setPassword("33");
        usersIndex.setNickname("44");
        usersIndex.setRealname("55");
        usersIndex.setFace("");
        usersIndex.setMobile("");
        usersIndex.setEmail("");
        usersIndex.setSex(0);
        usersIndex.setBirthday(new Date());
        usersIndex.setCreatedTime(new Date());
        usersIndex.setUpdatedTime(new Date());
        esTemplate.save(usersIndex);
    }
}