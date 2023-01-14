# ssm
有关ssm学习的相关代码




# MyBatis学习

> 相关视频请移步到bilibili[尚硅谷](https://www.bilibili.com/video/BV1Ya411S7aT/)

> [mybatis官方中文文档](https://mybatis.org/mybatis-3/zh/index.html)

> 文章及相关代码正在更新中🎠

## 依赖

```xml
<!-- MyBatis依赖-->
    <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.11</version>
    </dependency>

```

## 核心配置文件

### 精简版

> <span style="color:#c04851">注意：</span> "<span style="color:#525288">当`"http://mybatis.org/dtd/mybatis-3-config.dtd"`设置为`https`时`idea`无法识别`xml`中的`sql`，具体原因暂时未知</span>

```xml
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
```

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--引入配置文件-->
    <properties resource="jdbc.properties"/>
    <typeAliases>
        <!--com.zzuli.entity-->
        <package name=""/>
    </typeAliases>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>
    <!--引入mybatis映射文件-->
    <mappers>
<!--        <mapper resource="mappers/userMapper.xml"/>-->
        <!--
            以包的方式引入映射文件，但是必须满足两个条件
            1.mapper接口和映射文件所在的包必须一致
            2.mapper接口的名字和映射文件的名字必须一致
			例如：com/zzuli/mapper
        -->
        <package name=""/>
    </mappers>
</configuration>
```

> jdbc.properties配置文件

```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC
jdbc.username=***
jdbc.password=***
```

### 详细的内容

> 核心配置文件中的标签必须按照固定的顺序(有的标签可以不写，但顺序一定不能乱)：
> properties、settings、typeAliases、typeHandlers、objectFactory、objectWrapperFactory、reflectorFactory、plugins、environments、databaseIdProvider、mappers

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
     <!--引入配置文件，使用${key}访问对应value-->
    <properties resource="jdbc.properties"/>
    <typeAliases>
           <!-- typeAlias:设置类性别名
            在MyBatis的范围中，就可以使用别名表示一个具体的类性
    		不设置alias，默认的别名类名不区分大小写
     -->
        <typeAlias type="com.zzuli.entity.user" alias="User"/>
        <!--通过包设置类性别名，指定包下的所有类性将全部拥有默认的别名-->
        <package name="com.zzuli.entity"/>
    </typeAliases>
     -->
    <typeAliases>
        <typeAlias type="com.zzuli.entity.user" alias="User"/>
    </typeAliases>
    <!--配置连接数据库的环境-->
    <!--environments的default属性用于配置默认环境id-->
    <environments default="development">
        <!--environment的id属性唯一标识，设置一个具体的数据库连接环境-->
        <environment id="development">
            <!--transactionManager：设置事务管理器
                属性：
                    type:设置事务管理方式 “JDBC/MANAGED”
                   JDBC:JDBC原生的事务管理方式
                   MANAGED:被管理，例如spring-->
            <transactionManager type="JDBC"/>
            <!--dataSource: 设置数据源
             属性:
                type:设置数据源的类性"POOLED/UNPOOLED/JNDI "
                POOLED:表示使用数据库连接池
                UNPOOLED:不使用数据库连接池
                JNDI:使用上下文的数据源
                -->
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>
    <!--引入mybatis映射文件-->
    <mappers>
        <mapper resource="mappers/userMapper.xml"/>
        <!--
            以包的方式引入映射文件，但是必须满足两个条件
            1.mapper接口和映射文件所在的包必须一致
            2.mapper接口的名字和映射文件的名字必须一致
        -->
        <package name="com/zzuli/mapper"/>
    </mappers>
</configuration>
```

## 阿里巴巴druid数据源

```xml
    <!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.2.8</version>
    </dependency>
```

## mapper配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="">
  <select id="selectBlog" resultType="Blog">
    select * from Blog where id = #{id}
  </select>
</mapper>	
```

### 简单的测试

```java 
       //获取核心配置文件的输入流
       InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
       //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sql的会话对象sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取userMapper的代理实现类对象
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        //调用mapper接口中的方法，实现具体的添加功能
        int result = mapper.insetUser();
		//这种方法不常用
		// result=sqlSession.insert("com.zzuli.mapper.userMapper.insetUser");
        System.out.println("结果"+result);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
```

### mapper配置文件的详细配置

```xml
   <!--
        resultType:设置结果类型，查询接过的java类型,这里还可以设置用别名
        resultMap：自定义映射，处理多对一、一对多的关系映射
    -->
    <select id="getUserById" resultType="com.zzuli.entity.User">
        select * from t_user where id=4
    </select>
    <select id="getAllUser" resultType="User">
            select  * from t_user
    </select>
```

### 若使用别名需要在mybatis-config.xml中设置

```xml
   <typeAliases>
<!--  <typeAlias type="com.zzuli.entity.user" alias="User"/>-->
        <!--通过包设置类性别名，指定包下的所有类性将全部拥有默认的别名-->
        <package name="com.zzuli.entity"/>
    </typeAliases>
```

```xml
 <!-- MyBatis获取参数值的两种方式：${} #{}
    ${}:使用字符串拼接sql
    #{}:使用占位符方式拼接sql
    -->
    <select id="getUsername" resultType="User">
       select * from t_user where username=#{username}
        <!--select * from t_user where username='${username}'-->
    </select>
```

### 如果有多个参数

```xml
<select>
<!--提供的访问关键字[arg1, arg0, param1, param2]-->
        select * from t_user where username=#{param1} and password=#{param2}
        <!--select * from t_user where username='${username}'-->
</select>
```

### mapper接口的方式有三种方式

```java
    User checkLogin(String username,String password);//这种为指定关键字的在mapper.xml中只能用 [arg1, arg0, param1, param2]   /**
     * 登录验证（以map集合坐为参数）
     * @param map
     * @return
     */
      /**
      一下两种方法在mapper.xml可以设置为[password, param1, username, param2]
      其中username 和password是你自己指定的
         **/
    User checkLoginByMap(Map<String,Object> map);
    User checkLoginByParam(@Param("username")String username, @Param("password")String password);
```

## 特殊的SQL语句

### 解决模糊查询

```xml
    <select id="getUserByLike" resultType="user">
        <!--
        解决模糊查询的三种方式：
            1.select * from t_user where username like '%${vague}%';
            2.select * from t_user where username like concat('%',#{vague},'%')
			3.select * from  t_user where username like "%"#{vague}"%"
        -->
    </select>
```

### 多行删除

```xml
	<!--
        批量删除
        方法一： delete from t_user where id in(${ids})
        方法二:(动态sql例如：delete from t_user where id=5 or id=8)
    -->
    <delete id="deleteMoreUser">
        delete from t_user where id in(${ids});
    </delete>
```

### 动态表名查询

```xml
  <!--
            动态表名查询（表名不加单引号）:
                select * from  ${tableName}
    -->
    <select id="getUserList" resultType="User">
        select * from  ${tableName}
    </select>

```

### 获取自增主键

```xml
<!--设置useGeneratedKeys属性为true，keyProperty指定获取主键对应的对象的属性名-->  
<insert id="insertUser" useGeneratedKeys="true" keyProperty="id">
        insert into t_user values (null,#{username},#{password},#{age},#{gender},#{email})
</insert>
```

## 自定义映射resultMap

> 出现字段名不匹配的时候解决方法（处理映射关系）：

> 方法一：通过起别名的方式映射

```sql
select emp_id empId,emp_name empName,age,gender,dept_id deptId from t_emp where emp_id=#{empId}
```

> 方法二：当字段符合下划线_,而属性符合java的要求使用驼峰
> 	在mybatis-config.xml开启驼峰命名自动映射

```xml
    <settings>
        <!--是否开启驼峰命名自动映射-->
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>
```

> 方法三：自定义映射规则
>
> 设置resultMap

```xml
<resultMap id="empResultMap" type="Emp">
     <id column="emp_id" property="empId"/>
    <result column="emp_name" property="empName"/>
     <result column="age" property="age"/>
     <result column="gender" property="gender"/>
     <result column="dept_id" property="deptId"/>
</resultMap>
<select id="getEmpByEmpId" resultMap="empResultMap">
      select * from t_emp where emp_id=#{empId}
</select>
```

## 处理多对一查询

> 方法一： 级联方式处理

```xml
<resultMap id="EmpAndDeptResultMap" type="Emp">
     <id column="emp_id" property="empId"/>
     <result column="emp_name" property="empName"/>
     <result column="age" property="age"/>
     <result column="gender" property="gender"/>
     <result column="dept_id" property="dept.deptId"/>
     <result column="dept_name" property="dept.deptName"/>
</resultMap>
    <select id="getEmpAndDeptByEmpId" resultMap="EmpAndDeptResultMap">
        select
            *
        from t_emp
        left join t_dept td
        on td.dept_id = t_emp.dept_id
        where emp_id=#{empId}
    </select>
```

> 方法二：使用association属性处理

```xml
   <resultMap id="EmpAndDeptResultMap" type="Emp">
        <id column="emp_id" property="empId"/>
        <result column="emp_name" property="empName"/>
        <result column="age" property="age"/>
        <result column="gender" property="gender"/>
        <association property="dept" javaType="Dept">
            <id column="dept_id" property="deptId"/>
            <result column="dept_name" property="deptName"/>
        </association>
    </resultMap>
    <select id="getEmpAndDeptByEmpId" resultMap="EmpAndDeptResultMap">
        select
            *
        from t_emp
        left join t_dept td
        on td.dept_id = t_emp.dept_id
        where emp_id=#{empId}
    </select>
```

> 方法三：分步查询

> EmpMapper.java

```java
   Emp getEmpAndDeptByEmpStepOne(@Param("empId")Integer empId);
```

> EmpMapper.xml

```xml
<resultMap id="EmpAndDeptResultMap" type="Emp">
    <id column="emp_id" property="empId"/>
    <result column="emp_name" property="empName"/>
    <result column="age" property="age"/>
    <result column="gender" property="gender"/>
    <association property="dept"
                 select="com.zzuli.mapper.DeptMapper.getEmpAndDeptByEmpStepTwo"
                 column="dept_id"/>
</resultMap>
<select id="getEmpAndDeptByEmpStepOne" resultMap="EmpAndDeptResultMap">
    select * from t_emp where emp_id=#{empId}
</select>
```

> DeptMapper.java

```java
Dept getEmpAndDeptByEmpStepTwo(@Param("deptId")Integer deptId);
```

> DeptMapper.xml

```xml
   <select id="getEmpAndDeptByEmpStepTwo" resultType="Dept">
        select dept_id,dept_name from t_dept where dept_id=#{deptId}
    </select>
```

> 分步查询的优点：可以实现延迟加载
>
> 配置延迟需要在核心配置文件中设置全局配置信息
>
> lazyLoadingEnabled： 延迟加载的全局开关。当开启时，所有关联对象都会延迟加载。 特定关联关系中可通过设置 `fetchType` 属性来覆盖该项的开关状态。
>
> aggressiveLazyLoading：开启时，任一方法的调用都会加载该对象的所有延迟加载属性。 否则，每个延迟加载属性会按需加载（参考 `lazyLoadTriggerMethods`)。

> 当开启全局延迟加载时可配置mapper.xml配置文件中的association标签下的 `fetchType`进行设置`eager`(立即加载)/`lazy`(延迟加载)

```xml
<resultMap id="EmpAndDeptResultMap" type="Emp">
   <id column="emp_id" property="empId"/>
   <result column="emp_name" property="empName"/>
   <result column="age" property="age"/>
   <result column="gender" property="gender"/>
   <association property="dept"
                select="com.zzuli.mapper.DeptMapper.getEmpAndDeptByEmpStepTwo"
                column="dept_id"
                fetchType="eager"/>
</resultMap>
```



## 处理一对多查询

> 方法一：级联方式处理

```xml
    <resultMap id="DeptAndEmpResultMap" type="Dept">
        <id column="dept_id" property="deptId"/>
        <result column="dept_name" property="deptName"/>
        <!--
            collection处理一对多的映射关系（处理集合属性）
            使用ofType设置集合的对用对象
        -->
        <collection property="empList" ofType="Emp">
            <id column="emp_id" property="empId"/>
            <result column="emp_name" property="empName"/>
            <result column="age" property="age"/>
            <result column="gender" property="gender"/>
<!--            就算你配置了注释的也不会陷入循环-->
<!--            <result column="dept_id" property="dept.deptId"/>-->
<!--            <result column="dept_name" property="dept.deptName"/>-->

        </collection>
    </resultMap>
<!--    Dept getDeptAndEmpById(@Param("deptId")Integer deptId);-->
    <select id="getDeptAndEmpById" resultMap="DeptAndEmpResultMap">
        select * from t_dept
        left join t_emp te
        on t_dept.dept_id = te.dept_id
        where te.dept_id=#{deptId}
    </select>
```

## 动态SQL

> 根据特定条件拼装SQL语句

### if、where、trim标签

> 多条件查询
>
> 遇到的问题：因为sql的语法限制（sql中where 后面不能直接放and出现并且where不能为结尾）

> 方法一：where后添加恒成立条件

```xml
  <select id="getEmpByCondition" resultType="Emp">
        select * from t_emp where true
        <if test="empName!=null and empName!=''">
            and emp_Name=#{empName}
        </if>
        <if test="age!=null and age!=''">
           and age=#{age}
        </if>
        <if test="gender!=null and gender!=''">
           and gender=#{gender}
        </if>                         
    </select>
```

> 方法二：添加where标签

```xml
    <select id="getEmpByCondition" resultType="Emp">
        select * from t_emp
<!--        ①：where 内有条件成立会在sql中添加where关键词,如果所有条件不成立不影响正常执行
            ②：自动截取多余的and（只能去除语句前面的and）
-->
        <where>
            <if test="empName!=null and empName!=''">
                and emp_Name=#{empName}
            </if>
            <if test="age!=null and age!=''">
                and age=#{age}
            </if>
            <if test="gender!=null and gender!=''">
                and gender=#{gender}
            </if>
        </where>
    </select>
```

> 方法三：自定义标签trim

```xml
  <select id="getEmpByCondition" resultType="Emp">
        select * from t_emp
        <!--       prefix:在前面添加内容
                   prefixOverrides: 截取前面的内容
                   suffix:在后面添加内容
                   suffixOverrides: 截取后面的内容
        -->
        <trim prefix="where" prefixOverrides="and">
            <if test="empName!=null and empName!=''">
                and emp_Name=#{empName}
            </if>
            <if test="age!=null and age!=''">
                and age=#{age}
            </if>
            <if test="gender!=null and gender!=''">
                and gender=#{gender}
            </if>
        </trim>
    </select>
```

### choose、when、otherwrise标签

> 相当于java中的if...else if...else
>
> when：当前面的when成立后不再执行后面的when
>
> otherwrise：是指的其他情况

```xml
 <select id="getEmpByChoose" resultType="Emp">
        select * from t_emp
        <where>
            <choose>
                <when test="empName!=null and empName!=''">
                     emp_Name=#{empName}
                </when>
                <when test="age!=null and age!=''">
                    age=#{age}
                </when>
                <when test="gender!=null and gender!=''">
                    gender=#{gender}
                </when>
            </choose>
        </where>

    </select>
```

### foreach标签

> 实现批量插入数据

```xml
<insert id="insertMoreEmp">
        insert into t_emp values 
         <!--collection:传过来的参数，默认为list
            item:遍历赋值给emp
            separator:分隔符   
         -->                          
        <foreach collection="emps" item="emp" separator=",">
            (null,#{emp.empName},#{emp.age},#{emp.gender},null)
        </foreach>
</insert>
```

> 实现批量删除

> 方法一：

```xml
<!--    int deleteMoreEmp(@Param("empIds") Integer[] empIds);-->
    <delete id="deleteMoreEmp">
        delete from t_emp where emp_id in(
            <foreach collection="empIds" item="empId" separator=",">
                #{empId}
            </foreach>
            )
    </delete>
```

> 方法二：

```xml
<delete id="deleteMoreEmp">
     delete from t_emp where emp_id in
     <!--open:当前循环内容以"("开始
 			close:当前循环内容以")"结束
	 -->
    <foreach collection="empIds" item="empId" separator="," open="(" close=")">
                #{empId}
    </foreach>            
</delete>
```

> 方法三：

```xml
<delete id="deleteMoreEmp">
        delete from t_emp where
        <foreach collection="empIds" item="empId" separator="or">
            emp_id=#{empId}
        </foreach>
</delete>
```

### sql标签

> 自定义sql片段通过include标签引入（refid属性指定id）
>
> 例如：

```xml
 <sql id="empColumns">
        emp_id,emp_name,age,gender,dept_id
 </sql>
    <select id="getEmpByCondition" resultType="Emp">
        select <include refid="empColumns"></include>from t_emp
        <!--       prefix:在前面添加内容
                   prefixOverrides: 截取前面的内容
                   suffix:在后面添加内容
                   suffixOverrides: 截取后面的内容
        -->
        <trim prefix="where" prefixOverrides="and">
            <if test="empName!=null and empName!=''">
                and emp_Name=#{empName}
            </if>
            <if test="age!=null and age!=''">
                and age=#{age}
            </if>
            <if test="gender!=null and gender!=''">
                and gender=#{gender}
            </if>
        </trim>
    </select>
```

## MyBatis缓存

> MyBatis缓存分为一级缓存和二级缓存，<span style="color:#c04851">注意：</span>**一级缓存默认开启**
>
> 缓存是指查询数据会被缓存，下次查询相同数据时直接从缓存获取，不会再次访问数据库
>
> 一级缓存为SqlSession级别，二级缓存为SqlSessionFactory级别

#### 一级缓存

> mybatis的一级缓存是sqlSession级别的，
> 也就是同一个SqlSession查询相同的数据时从缓存中查询，不用执行sql语句

> sqlSession失效的四种情况：
>
> * 1)不同sqlSession对应不同的一级缓存
> * 2)同一sqlSession查询条件不同
> * 3)同一sqlSession两次查询期间执行增删改操作
> * 4)同一sqlSession手动清空了缓存

### 二级缓存

> mybatis的二级缓存是sqlSessionFactory级别的，
> 也就是同一个sqlSessionFactory查询相同的数据时从缓存中查询，不用执行sql语句
>
> 二级缓存开启的条件：
>
> * 在核心文件中，设置全局配置cacheEnabled="true",默认为true，不需要另外配置
> * 在映射mapper.xml中设置<cache/>
> * 二级缓存必须在sqlSession关闭或者提交之后才有效
> * 查询的数据所转换的实体类必须实现系列化接口（`implements Serializable `）

> sqlSessionFactory失效情况：
>
> * 两次查询期间执行增删改操作

### cache标签的相关配置

```xml
<cache
  eviction="FIFO"
  flushInterval="60000"
  size="512"
  readOnly="true"/>
```

> 可用的清除策略有：
>
> - `LRU` – 最近最少使用：移除最长时间不被使用的对象。
> - `FIFO` – 先进先出：按对象进入缓存的顺序来移除它们。
> - `SOFT` – 软引用：基于垃圾回收器状态和软引用规则移除对象。
> - `WEAK` – 弱引用：更积极地基于垃圾收集器状态和弱引用规则移除对象。
>
> 默认的清除策略是 LRU。

> flushInterval（刷新间隔）属性可以被设置为任意的正整数，设置的值应该是一个以毫秒为单位的合理时间量。 默认情况是不设置，也就是没有刷新间隔，缓存仅仅会在调用语句时刷新。

> size（引用数目）属性可以被设置为任意正整数，要注意欲缓存对象的大小和运行环境中可用的内存资源。默认值是 1024。

> readOnly（只读）属性可以被设置为 true 或 false。只读的缓存会给所有调用者返回缓存对象的相同实例。 因此这些对象不能被修改。这就提供了可观的性能提升。而可读写的缓存会（通过序列化）返回缓存对象的拷贝。 速度上会慢一些，但是更安全，因此默认值是 false。

### mybatis缓存的查询顺序

> 先查询二级缓存，如果二级缓存没命中，在查询一级缓存，如果一级缓存没命中，则查询数据库
>
> sqlSession关闭后，一级缓存中的数据会被写到二级缓存中

### 整合第三方缓存

> 处理的是二级缓存

#### 整合EHCache

> 依赖

```xml
 <!-- Mybatis EHCache整合包-->
        <dependency>
            <groupId>org.mybatis.caches</groupId>
            <artifactId>mybatis-ehcache</artifactId>
            <version>1.2.3</version>
        </dependency>
        <!-- slf4j日志门面的具体实现-->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.4.5</version>
        </dependency>
```

> 在resources下创建ehcache.xml

```xml
<?xml version="1.0" encoding="utf-8" ?>
<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:noNamespaceSchemaLocation="http://ehcache.org/ehcache.xsd">
    <!-- 磁盘保存路径 -->
    <diskStore path="F:\zzuli\ehcache"/>
    <defaultCache
            maxElementsInMemory="1000"
            maxElementsOnDisk="10000000"
            eternal="false"
            overflowToDisk="true"
            timeToIdleSeconds="120"
            timeToLiveSeconds="120"
            diskExpiryThreadIntervalSeconds="120"
            memoryStoreEvictionPolicy="LRU">
    </defaultCache>
</ehcache>
```

#### 设置二级缓存类型

> mapper.xml中的cache标签指定缓存类型

```xml
<cache type="org.mybatis.caches.ehcache.EhcacheCache"/>
```

#### 配置logback日志

> 存在SLF4J时，作为简易日志的log4j将失效，此时我们需要借助SLF4J的具体实现logback来打印日志。 创建logback的配置文件logback.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration debug="true">
    <!-- 指定日志输出的位置 -->
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <!-- 日志输出的格式 -->
            <!-- 按照顺序分别是： 时间、日志级别、线程名称、打印日志的类、日志主体内容、换行-->
            <pattern>[%d{HH:mm:ss.SSS}] [%-5level] [%thread] [%logger][%msg]%n</pattern>
        </encoder>
    </appender>
    <!-- 设置全局日志级别。日志级别按顺序分别是： DEBUG、INFO、WARN、ERROR -->
    <!-- 指定任何一个日志级别都只打印当前级别和后面级别的日志。 -->
    <root level="DEBUG">
        <!-- 指定打印日志的appender，这里通过“STDOUT”引用了前面配置的appender -->
        <appender-ref ref="STDOUT" />
    </root>
    <!-- 根据特殊需求指定局部日志级别 -->
    <logger name="com.zzuli.mapper" level="DEBUG"/>
</configuration>
```

#### EHCache配置文件说明

| 属性名                          | 是否必须 | 作用                                                         |
| ------------------------------- | -------- | ------------------------------------------------------------ |
| maxElementsInMemory             | 是       | 在内存中缓存的element的最大数目                              |
| maxElementsOnDisk               | 是       | 在磁盘上缓存的element的最大数目，若是0表示无穷大             |
| eternal                         | 是       | 设定缓存的elements是否永远不过期。 如果为true，则缓存的数据始终有效， 如果为false那么还要根据timeToIdleSeconds、timeToLiveSeconds判断 |
| overflowToDisk                  | 是       | 设定当内存缓存溢出的时候是否将过期的element缓存到磁盘上      |
| timeToIdleSeconds               | 否       | 当缓存在EhCache中的数据前后两次访问的时间超过timeToIdleSeconds的属性取值时， 这些数据便会删除，默认值是0,也就是可闲置时间无穷大 |
| timeToLiveSeconds               | 否       | 缓存element的有效生命期，默认是0.,也就是element存活时间无穷大 |
| diskSpoolBufferSizeMB           | 否       | DiskStore(磁盘缓存)的缓存区大小。默认是30MB。每个Cache都应该有自己的一个缓冲区 |
| diskPersistent                  | 否       | 在VM重启的时候是否启用磁盘保存EhCache中的数据，默认是false。 |
| diskExpiryThreadIntervalSeconds | 否       | 磁盘缓存的清理线程运行间隔，默认是120秒。每个120s， 相应的线程会进行一次EhCache中数据的清理工作 |
| memoryStoreEvictionPolicy       | 否       | 当内存缓存达到最大，有新的element加入的时候， 移除缓存中element的策略。 默认是LRU （最近最少使用），可选的有LFU （最不常使用）和FIFO （先进先出） |

***

## mybatis逆向工程

> 正向工程：实体类生成sql 。如：Hibenmate、jpa
>
> 逆向工程：数据库表生成资源文件
>
> 	* java实体类
> 	* Mapper接口
> 	* Mapper映射文件

### 导入依赖

```xml
<dependencies>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <scope>test</scope>
        </dependency>
</dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>1.4.1</version>
            <!-- 插件的核心依赖-->
                <dependencies>
                    <dependency>
                        <groupId>org.mybatis.generator</groupId>
                        <artifactId>mybatis-generator-core</artifactId>
                        <version>1.4.1</version>
                    </dependency>
                    <dependency>
                        <groupId>com.mysql</groupId>
                        <artifactId>mysql-connector-j</artifactId>
                        <version>8.0.31</version>
                    </dependency>
                </dependencies>
            </plugin>
        </plugins>
    </build>
```

### 逆向工程配置文件

> generatorConfig.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
    <!--
            targetRuntime: 执行生成的逆向工程的版本
                MyBatis3Simple: 生成基本的CRUD（清新简洁版）
                MyBatis3: 生成带条件的CRUD（奢华尊享版）
    -->
    <context id="DB2Tables" targetRuntime="MyBatis3">
        <!-- 数据库的连接信息 -->
        <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
                        connectionURL="jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC"
                        userId="root"
                        password="123456">
        </jdbcConnection>
        <!-- javaBean的生成策略
             也就是实体类entity-->
        <javaModelGenerator targetPackage="com.zzuli.entity" targetProject=".\src\main\java">
            <property name="enableSubPackages" value="true" />
            <property name="trimStrings" value="true" />
        </javaModelGenerator>
        <!-- SQL映射文件的生成策略 -->
        <sqlMapGenerator targetPackage="com.zzuli.mapper" targetProject=".\src\main\resources">
            <property name="enableSubPackages" value="true" />
        </sqlMapGenerator>
        <!-- Mapper接口的生成策略 -->
        <javaClientGenerator type="XMLMAPPER" targetPackage="com.zzuli.mapper" targetProject=".\src\main\java">
            <property name="enableSubPackages" value="true" />
        </javaClientGenerator>
        <!-- 逆向分析的表 -->
        <!-- tableName设置为*号，可以对应所有表，此时不写domainObjectName -->
        <!-- domainObjectName属性指定生成出来的实体类的类名 -->
        <table tableName="t_emp" domainObjectName="Emp"/>
        <table tableName="t_dept" domainObjectName="Dept"/>
    </context>
</generatorConfiguration>
```

> 配置之后点击插件mybatis-generator即可生成逆向工程

***

## 分页插件

> limit（分页关键字） 、index、pageSize
>
> pageSize: 每页显示条数
>
> pageNum: 当前页的页码
>
> index: 当前页的起始索引: <span style="color:#c04851">$index=(pageNum-1)\times pageSize$</span>
>
> cout:总记录数
>
> totalPage:总页数



<a>首页</a> <a>下一页</a> 2 3 4 5 <a>上一页</a> <a>尾页</a>

### 依赖

```xml
  <!-- 分页插件-->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>5.3.2</version>
        </dependency>
    </dependencies>
```

> mybatis核心配置文件添加`mybatis-config.xml`

```xml
    <plugins>
<!--        配置分页插件-->
        <plugin interceptor="com.github.pagehelper.PageInterceptor"/>
    </plugins>
```

> 测试类

```java
    @Test
    public void test_Page(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //在查询功能之前开启分页功能
        Page<Object> page = PageHelper.startPage(1, 4);
        List<Emp> list=mapper.selectByExample(null);
        list.forEach(System.out::println);
        System.out.println(page);
    }
```

> 第二种: 方式 [官方文档](https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md)

```java
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
```

> pageInfo

```java
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
```

### pageInfo属性值：

```java
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
```

>* pageNum：当前页的页码
>
>* pageSize：每页显示的条数
>
>* size：当前页显示的真实条数
>
>* total：总记录数
>
>* pages：总页数
>
>* prePage：上一页的页码
>
>* nextPage：下一页的页码
>
>* isFirstPage/isLastPage：是否为第一页/最后一页
>
>* hasPreviousPage/hasNextPage：是否存在上一页/下一页
>
>* navigatePages：导航分页的页码数
>
>* navigatepageNums：导航分页的页码，[1,2,3,4,5]



