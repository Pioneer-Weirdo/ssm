package com.zzuli;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzuli.entity.Emp;
import com.zzuli.mapper.EmpMapper;
import com.zzuli.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PageTest {
    @Test
    public void test_Page(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //在查询功能之前开启分页功能
//        Page<Object> page = PageHelper.startPage(1, 4);
//        List<Emp> list=mapper.selectByExample(null);
        Page<Object> page =  PageHelper.startPage(1,4).doSelectPage(new ISelect() {
            @Override
            public void doSelect() {
                mapper.selectByExample(null);
            }
        });
        page.forEach(System.out::println);
        System.out.println(page);
    }

    /**
     * PageInfo{
     * pageNum=1,
     * pageSize=4,
     * size=4,
     * startRow=1,
     * endRow=4,
     * total=100,
     * pages=25,
     * list=Page{count=true, pageNum=1, pageSize=4, startRow=0, endRow=4, total=100, pages=25, reasonable=false, pageSizeZero=false}[Emp(empId=1, empName=潘小雯, age=22, gender=女, deptId=2), Emp(empId=2, empName=罗詩涵, age=30, gender=女, deptId=1), Emp(empId=3, empName=汪震南, age=50, gender=男, deptId=7), Emp(empId=4, empName=姜子异, age=58, gender=男, deptId=3)],
     * prePage=0, nextPage=2, isFirstPage=true,
     * isLastPage=false, hasPreviousPage=false,
     * hasNextPage=true, navigatePages=5,
     * navigateFirstPage=1, navigateLastPage=5, navigatepageNums=[1, 2, 3, 4, 5]}
     */
    @Test
    public void test_PageInfo(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //在查询功能之前开启分页功能
        Page<Object> page = PageHelper.startPage(1, 4);
        List<Emp> list=mapper.selectByExample(null);
        PageInfo<Object> pageInfo = new PageInfo<>(list,5);
        list.forEach(System.out::println);
        System.out.println(pageInfo);
    }
}
