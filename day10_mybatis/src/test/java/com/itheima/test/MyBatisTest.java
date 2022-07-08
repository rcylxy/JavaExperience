package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname MyBatisTest
 * @Date 2022/7/4 19:48
 * @Created by 李晓阳
 */
public class MyBatisTest {

    @Test
    public void testSelectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectBrand();
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testSelectBrand() throws IOException {
        int id = 1;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = brandMapper.selectByIdBrand(id);
        System.out.println(brand);
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";
        Map map = new HashMap();
//        map.put("companyName", companyName);
//        map.put("brandName", brandName);
        map.put("status", status);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        String description = "aaa";
        int ordered = 100;

        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setStatus(status);
        brand.setDescription(description);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        brandMapper.add(brand);
//        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testAdd2() throws IOException {
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        String description = "aaa";
        int ordered = 100;

        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setStatus(status);
        brand.setDescription(description);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        brandMapper.add(brand);
        System.out.println(brand.getId());

//        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        int status = 1;
        String companyName = "华为s";
        String brandName = "华为sxxxxxxxxxxxxxxxx";
        String description = "aaas";
        int ordered = 1500;
        int id = 5;
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
//        brand.setStatus(status);
        brand.setDescription(description);
        brand.setId(id);
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        int update = brandMapper.update(brand);
        System.out.println(update);
//        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws IOException {
        int id = 8;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);

        brandMapper.deleteById(id);
//        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws IOException {
        int[] ids = {};
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);

        brandMapper.deleteByIds(ids);
//        sqlSession.commit();
        sqlSession.close();
    }


}




















































